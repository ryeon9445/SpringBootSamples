import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.rule.OutputCapture;
import sample.logback.SampleLogbackApplication;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

/**
 * Created by CBR on 2018. 7. 17..
 */
public class SampleLogbackApplicationTests
{
    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void testLoadedCustomLogbackConfig() throws Exception
    {
        SampleLogbackApplication.main(new String[0]);
        this.outputCapture.expect(containsString("Sample Debug Message"));
        this.outputCapture.expect(not(containsString("Sample Trace Message")));
    }

    @Test
    public void testProfile() throws Exception
    {
        SampleLogbackApplication.main(new String[]
                {
                        "--spring.profiles.active=staging"
                });
        this.outputCapture.expect(containsString("Sample Debug Message"));
        this.outputCapture.expect(containsString("Sample Trace Message"));
    }
}
