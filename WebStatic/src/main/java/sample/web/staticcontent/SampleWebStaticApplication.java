package sample.web.staticcontent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Created by CBR on 2018. 8. 17..
 */
@SpringBootApplication
public class SampleWebStaticApplication extends SpringBootServletInitializer
{
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder)
    {
        return builder.sources(SampleWebStaticApplication.class);
    }

    public static void main(String[] args)
    {
        SpringApplication.run(SampleWebStaticApplication.class, args);
    }
}