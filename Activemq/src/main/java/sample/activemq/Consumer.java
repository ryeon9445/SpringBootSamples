package sample.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by CBR on 2018. 7. 20..
 */

@Component
public class Consumer
{
    @JmsListener(destination = "sample.queue")
    public void receiveQueue(String text)
    {
        System.out.println(text);
    }
}
