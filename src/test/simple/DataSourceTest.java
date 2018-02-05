package simple;

import com.playboxjre.spring.learn.cha9_aop.SomeBean;
import com.playboxjre.spring.learn.jdbc.DBConfig;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactory;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * simple
 * Administrator
 * 2018\1\30 0030 15:47
 * EMAIL : playboxjre@gmail.com
 */
public class DataSourceTest {
    Logger log = LoggerFactory.getLogger(DataSourceTest.class);

    AnnotationConfigApplicationContext ctx;
    @Before
    public void before(){
        ctx = new AnnotationConfigApplicationContext();
        ctx.register(DBConfig.class);
        ctx.refresh();
    }

    @Test
    public void testDriverMangerDataSource(){

        DataSource bean = ctx.getBean(DataSource.class);
        assert bean != null;
        try( Connection conn = bean.getConnection();) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from accracy");
            while (resultSet.next()){
                String anInt = resultSet.getString(1);
                log.info("0 column = {}",anInt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testJdbcTemplate(){
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");

        jdbcTemplate.query("select * from accracy", new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                while (resultSet.next()) {
                    String string = resultSet.getString(1);
                    log.info(string);
                }
            }
        });

        jdbcTemplate.query("", new RowMapper<SomeBean>() {
            @Override
            public SomeBean mapRow(ResultSet resultSet, int i) throws SQLException {
                return null;
            }
        });

        MappingSqlQuery<SomeBean> sqlQuery = new MappingSqlQuery<SomeBean>() {
            @Override
            protected SomeBean mapRow(ResultSet rs, int rowNum) throws SQLException {
                return null;
            }
        };
    }


    @Test
    public void testEmbededDb(){
        String defaultDatabaseName = EmbeddedDatabaseFactory.DEFAULT_DATABASE_NAME;
        EmbeddedDatabaseFactory embeddedDatabaseFactory = new EmbeddedDatabaseFactory();
        embeddedDatabaseFactory.setGenerateUniqueDatabaseName(true);

        EmbeddedDatabase build = new EmbeddedDatabaseBuilder().addDefaultScripts().generateUniqueName(true)
                .setType(EmbeddedDatabaseType.H2).setScriptEncoding("utf-8")
                .ignoreFailedDrops(true)
                .continueOnError(true)
                .build();

    }

}

