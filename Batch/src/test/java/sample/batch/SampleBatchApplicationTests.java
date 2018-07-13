package sample.batch;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.rule.OutputCapture;

/**
 * Created by CBR on 2018. 7. 14..
 */
public class SampleBatchApplicationTests
{
    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void testDefaultSettings()
    {
        Assertions.assertThat(SpringApplication.exit(
                SpringApplication.run(SampleBatchApplication.class))).isEqualTo(0);
        String output = this.outputCapture.toString();
        Assertions.assertThat(output).contains("completed with the following parameters");
    }
}
