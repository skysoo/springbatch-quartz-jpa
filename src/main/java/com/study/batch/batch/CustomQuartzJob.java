package com.study.batch.batch;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.quartz.JobExecutionContext;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@Getter
@Setter
public class CustomQuartzJob extends QuartzJobBean {
    private String jobName;
    private JobLauncher jobLauncher;
    private JobLocator jobLocator;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) {
        try {
            Job job = jobLocator.getJob(jobName);
            Map<String, JobParameter> confMap = new HashMap<>();
            confMap.put("time", new JobParameter(String.valueOf(LocalDateTime.now())));
            JobParameters jobParameter = new JobParameters(confMap);

            jobLauncher.run(job, jobParameter);
        } catch (NoSuchJobException | JobInstanceAlreadyCompleteException | JobRestartException | JobParametersInvalidException | JobExecutionAlreadyRunningException e) {
            log.error(e);
        }

    }
}
