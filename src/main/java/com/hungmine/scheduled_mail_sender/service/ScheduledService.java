package com.hungmine.scheduled_mail_sender.service;

import com.hungmine.scheduled_mail_sender.quarzt.EmailJob;
import lombok.RequiredArgsConstructor;
import org.quartz.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduledService {
    private final Scheduler scheduler;

    public void schedule(String exp) throws SchedulerException {
        JobDetail job = JobBuilder.newJob(EmailJob.class).withIdentity("emailJob", "emailGroup").build();
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("emailTrigger", "emailGroup")
                .withSchedule(CronScheduleBuilder.cronSchedule(exp))
                .build();
        scheduler.scheduleJob(job, trigger);
    }
}
