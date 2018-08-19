package sample.testng;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by CBR on 2018. 8. 19..
 */
@SpringBootApplication
public class SampleTestNGApplication
{
    private static Log logger = LogFactory.getLog(SampleTestNGApplication.class);

    @Bean
    protected ServletContextListener listener()
    {
        return new ServletContextListener()
        {
            @Override
            public void contextInitialized(ServletContextEvent servletContextEvent)
            {
                logger.info("ServletContext initialized");
            }

            @Override
            public void contextDestroyed(ServletContextEvent servletContextEvent)
            {
                logger.info("ServletContext destroyed.");
            }
        };
    }

    public static void main(String[] args)
    {
        SpringApplication.run(SampleTestNGApplication.class, args);
    }
}
