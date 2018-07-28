package sample.quartz;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by CBR on 2018. 7. 28..
 */
public class SampleQuartzApplicationTests
{
    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void quartzJobIsTriggered() throws InterruptedException {
        try (ConfigurableApplicationContext context = SpringApplication
                .run(SampleQuartzApplication.class)) {
            long end = System.currentTimeMillis() + 5000;
            while ((!this.outputCapture.toString().contains("Hello World!"))
                    && System.currentTimeMillis() < end) {
                Thread.sleep(100);
            }

            Assertions.assertThat(this.outputCapture.toString()).contains("Hello World!");
        }
    }

}
