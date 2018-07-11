package hello;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by CBR on 2018. 7. 12..
 */

@RestController
public class HelloController
{
    @RequestMapping("/")
    public String test()
    {
        return "Greetings from Spring Boot!";
    }
}
