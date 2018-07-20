package sample.activemq;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by CBR on 2018. 7. 20..
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleActiveMqTests
{
    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Autowired
    private Producer producer;

    @Test
    public void sendSimpleMessage() throws InterruptedException
    {
        this.producer.send("Test message");

        Thread.sleep(1000L);
        Assertions.assertThat(this.outputCapture.toString().contains("Test message")).isTrue();
    }
}
