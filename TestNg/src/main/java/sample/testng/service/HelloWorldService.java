package sample.testng.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by CBR on 2018. 8. 19..
 */
@Component
public class HelloWorldService
{
    @Value("${name:World}")
    private String name;

    public String getHelloMessage()
    {
        return "Hello " + this.name;
    }
}
