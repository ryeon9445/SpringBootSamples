package sample.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * Created by CBR on 2018. 7. 20..
 */

@Component
public class Producer implements CommandLineRunner
{
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Override
    public void run(String... strings) throws Exception
    {
        send("Sample message");
        System.out.println("Message was sent to the Queue");
    }

    public void send(String msg)
    {
        this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
    }
}
