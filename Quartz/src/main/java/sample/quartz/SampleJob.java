package sample.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Created by CBR on 2018. 7. 28..
 */
public class SampleJob extends QuartzJobBean
{
    private String name;

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException
    {
        System.out.println(String.format("Hello %s!", this.name));
    }
}
