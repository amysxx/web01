/**
 * @author amy
 * @date 2019/9/29 12:12
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.test.context.ContextConfiguration;


@ContextConfiguration(locations = {"log4j2.xml"})
public class Log4j2_Test {

    /**
     * @param args
     */
    //根据类的全名(com.undergrowth.Log4j2_Test)获取Logger
    //因为com.undergrowth.Log4j2_Test中没有Logger的实现类
    //所以logger继承rootLogger
    public static Logger logger=LogManager.getLogger(Log4j2_Test.class);

    //输出日志的六个级别的信息
    public static void outLogger()
    {
        logger.trace("trace to console");
        logger.debug("debug to console");
        logger.info("info to console");
        logger.warn("warn to console");
        logger.error("error to console");
        logger.fatal("fatal to console");
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //因为logger继承rootLogger 这里又没有配置文件设定rootLogger 所以采用默认的配置方式
        //即rootLogger的日志级别(level)为error 输出源(appender)为控制台
        outLogger();
    }

}