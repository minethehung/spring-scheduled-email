package com.hungmine.scheduled_mail_sender.quarzt;

import com.hungmine.scheduled_mail_sender.service.MailService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

@RequiredArgsConstructor
public class EmailJob extends QuartzJobBean {
    private final MailService mailService;
    @Override
    protected void executeInternal(@NonNull JobExecutionContext context) {
        mailService.sendForAllUser();
    }
}
