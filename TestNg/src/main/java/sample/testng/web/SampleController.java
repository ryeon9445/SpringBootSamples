package sample.testng.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sample.testng.service.HelloWorldService;

/**
 * Created by CBR on 2018. 8. 19..
 */
@Controller
public class SampleController
{
    @Autowired
    private HelloWorldService helloWorldService;

    @GetMapping("/")
    @ResponseBody
    public String helloWorld()
    {
        return this.helloWorldService.getHelloMessage();
    }
}
