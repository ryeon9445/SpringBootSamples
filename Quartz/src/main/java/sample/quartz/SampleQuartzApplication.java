package sample.quartz;

import org.quartz.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by CBR on 2018. 7. 28..
 */
@SpringBootApplication
public class SampleQuartzApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(SampleQuartzApplication.class, args);
    }

    @Bean
    public JobDetail sampleJobDetail()
    {
        return JobBuilder.newJob(SampleJob.class).withIdentity("SampleJob")
                .usingJobData("name", "World").storeDurably().build();
    }

    @Bean
    public Trigger sampleJobTrigger()
    {
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(2).repeatForever();

        return TriggerBuilder.newTrigger().forJob(sampleJobDetail())
                .withIdentity("sampleTrigger").withSchedule(simpleScheduleBuilder).build();
    }
}
