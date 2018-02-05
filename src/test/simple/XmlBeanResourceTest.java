package simple;

import com.playboxjre.spring.learn.annotations.*;
import com.playboxjre.spring.learn.bean.Bird;
import com.playboxjre.spring.learn.bean.CollectionsBean;
import com.playboxjre.spring.learn.bean.Dog;
import com.playboxjre.spring.learn.bean.Eatable;
import com.playboxjre.spring.learn.container.Function01;
import com.playboxjre.spring.learn.container.Function02;
import com.playboxjre.spring.learn.container.Server;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlBeanResourceTest {
    Logger logger = LoggerFactory.getLogger(XmlBeanResourceTest.class);
    /**
     * 同时加载多个配置文件，初始化bean的元素bean在不同配置文件定义
     */
    @Test
    public void testLoadMoreXmlConfig(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "spring/container/server.xml",
                "spring/container/func1.xml",
                "spring/container/func2.xml"
        );

        Object func1 = context.getBean("func1");
        Object func2 = context.getBean("func2");
        Object server = context.getBean("server");

        Assert.assertNotNull(server);
        Assert.assertEquals(func1,((Server)server).getFunction01());
        Assert.assertEquals(func2,((Server)server).getFunction02());

        ((Server)server).useFunction01();
        ((Server)server).useFunction02();
    }

    /**
     * 配置文件使用import导入多个文件测试
     */
    @Test
    public void testImportMoreXmlConfig(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "spring/container/server-import.xml"
        );
        Object func1 = context.getBean("func1");
        Object func2 = context.getBean("func2");
        Object server = context.getBean("server");

        Assert.assertNotNull(server);
        Assert.assertEquals(func1,((Server)server).getFunction01());
        Assert.assertEquals(func2,((Server)server).getFunction02());

        ((Server)server).useFunction01();
        ((Server)server).useFunction02();
    }

    /**
     * 将外部bean放入到 ApplicationContext IOC 容器中
     * #@{context.getBeanFactory().registerSingleton(beanname,object);}
     */
    @Test
    public void testOutCreateBeanIntoContext() {
        Function01 function01 = new Function01();
        function01.setTag("outer function 01 ");

        Function02 function02 = new Function02();
        function02.setTag("outer function 02");


        Server server1 = new Server();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml"
        );
        context.getBeanFactory().registerSingleton("func1", function01);
        context.getBeanFactory().registerSingleton("func2", function02);

        Object func1 = context.getBean("func1");
        Object func2 = context.getBean("func2");

        Assert.assertNotNull(func1);
        Assert.assertNotNull(func2);
        logger.info(func1.toString());
        logger.info(func2.toString());

    }

    /**
     * 测试Bean命名功能 id 、name、alias
     */
    @Test
    public void testBeanNaming(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/bean/appaction-bean.xml");

        Object function01 = context.getBean("function01");
        Object func1 = context.getBean("fun1");
        Object func_1 = context.getBean("fun_1");
        Object first = context.getBean("first");
        Object fun_one = context.getBean("fun_one");

        Object f1 = context.getBean("f1");
        Object f2 = context.getBean("f2");



        Assert.assertEquals(function01,fun_one);
        Assert.assertEquals(function01,func1);
        Assert.assertEquals(function01,func_1);
        Assert.assertEquals(function01,first);
        Assert.assertEquals(function01,f1);

        logger.info(f1.toString());
        logger.info(f2.toString());
    }

    /**
     * 测试 实例化方式：
     *  静态工程方式实例化对象
     *  使用实例工厂实例化对象
     */
    @Test
    public void testStaticFactoryInitialize(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/bean/appaction-bean.xml");
        Eatable animalFactory = (Eatable)context.getBean("animal");
        animalFactory.eat("水果");

        //使用实例工厂实例化对象
        Dog dog = context.getBean("dog", Dog.class);
        Bird bird = context.getBean("bird", Bird.class);

        dog.eat("屎");
        bird.eat("石头");
    }

    /**
     * 测试集合类 xml 定义
     */
    @Test
    public void testCollectionsBean(){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring/bean/appaction-collects.xml");
       /* CollectionsBean collectionBean = context.getBean("collectionBean", CollectionsBean.class);
        collectionBean.getAdminEmail().forEach((key,value)->{
            logger.info("{} : {} ", key,value);
        });*/

        // 集合合并-- 父子
        CollectionsBean child =
                context.getBean("child", CollectionsBean.class);
        child.getAdminEmail().forEach((key,value)->{
            logger.info("{} : {} ", key,value);
        });

    }
    /**
     * 测试集合类 xml 定义
     */
    @Test
    public void testQulaifierBean(){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring/bean/appaction-bean.xml");

        QualifierImp bean = context.getBean("qu",QualifierImp.class);
        assert  bean != null;
        Bird birds = bean.getBirds();birds.eat("hlel");

    }

    /**
     * 泛型自动装载测试
     */
    @Test
    public void testGeneriAutowired(){
        AnnotationConfigApplicationContext configApplicationContext =
                new AnnotationConfigApplicationContext(Configuration.class);
        StringStore bean = configApplicationContext.getBean(StringStore.class);
        StoreContainer bean1 = configApplicationContext.getBean(StoreContainer.class);
        assert  bean != null;
        assert bean1 != null;
        assert  bean1.getStringStore() == bean;
    }

    /**对这些注解的支持提供了另一个替代initialization callbacks和destroy callbacks。
     * JSR-250 生命周期注解。
     * 测试 注解 PostConstruct & PreDestory
     * @see javax.annotation.PostConstruct  init声明周期
     * @see javax.annotation.PreDestroy destory声明周期
     * @since spring 2.5
     */
    @Test
    public void testPostConsturct(){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring/bean/appaction-bean.xml");

        context.registerShutdownHook();
        PostConstructImp postConstructImp = context.getBean("postConstructImp", PostConstructImp.class);

    }

}
