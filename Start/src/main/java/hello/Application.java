package hello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * Created by CBR on 2018. 7. 12..
 */

@SpringBootApplication
public class Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context)
    {
        return args ->
        {
            System.out.println("Let's inspect the beans provided by Spring Boot");

            String[] beanNames = context.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames)
            {
                System.out.println(beanName);
            }
        };
    }
}
