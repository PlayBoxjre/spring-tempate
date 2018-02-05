package simple;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jTest {
    Logger logger = LoggerFactory.getLogger(Log4jTest.class);

    @Test
    public void log4jConsoleTest(){
        logger.info("hello world!");
    }
}
