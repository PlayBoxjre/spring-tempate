package simple;

import com.playboxjre.spring.learn.hibernate.BootStrapServiceRegistryFactory;
import com.playboxjre.spring.learn.hibernate.User;
import com.playboxjre.spring.learn.hibernate.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.Serializable;
import java.util.List;

/**
 * simple
 * Administrator
 * 2018\1\31 0031 20:33
 * EMAIL : playboxjre@gmail.com
 */
public class HibernateTest {
    Logger log = LoggerFactory.getLogger(HibernateTest.class);

    @Test
    public void testHibernateSpringXML() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new
                ClassPathXmlApplicationContext();
        classPathXmlApplicationContext.registerShutdownHook();
        classPathXmlApplicationContext.setConfigLocation("application-context.xml");
        classPathXmlApplicationContext.refresh();

        //addUser(classPathXmlApplicationContext);
        UserService userDao = classPathXmlApplicationContext.getBean("userService", UserService.class);
        User user = new User();
        user.setUsername("wo shi shui ");
        user.setPassword("hello world");
        userDao.addUser(user);


        List list = userDao.findAllUsers();


        log.info("list = {}",list.toString());




    }

    private void addUser(ClassPathXmlApplicationContext classPathXmlApplicationContext) {
        SessionFactory sessionFactory = classPathXmlApplicationContext.getBean("sessionFactory", SessionFactory.class);

        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.getTransaction();
            transaction.begin();
            User user = new User();
            user.setPassword("123");
            user.setUsername("hello");
            session.save(user);
            session.flush();
            session.getTransaction().commit();

        } catch (Exception e) {
             log.info("e : {}",e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }


    @Test
    public void testHibernate() {
        BootStrapServiceRegistryFactory factory = new BootStrapServiceRegistryFactory();
        SessionFactory sessionFactory = factory.createSessionFactoryWithStandardRegistry();

        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        try {
            User user = new User();
            user.setUsername("shishui2");
            user.setPassword("xxxxxx");
            Serializable save = session.save(user);
            session.getTransaction().commit();

            log.info("save is {}", save.toString());
            log.info("user is {}", user.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
