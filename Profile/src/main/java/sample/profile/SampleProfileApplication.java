package sample.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sample.profile.service.MessageService;

/**
 * Created by CBR on 2018. 8. 2..
 */
@SpringBootApplication
public class SampleProfileApplication implements CommandLineRunner
{
    @Autowired
    private MessageService helloWorldService;

    @Override
    public void run(String... strings) throws Exception
    {
        System.out.println(this.helloWorldService.getMessage());
    }

    public static void main(String[] args)
    {
        SpringApplication.run(SampleProfileApplication.class, args);
    }
}