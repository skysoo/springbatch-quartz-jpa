package com.study.batch.service;

import com.study.batch.batch.writer.JpaItemWriterJobConfiguration;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@Component
public class JobScheduler {
    private final JobLauncher jobLauncher;
    private final JpaItemWriterJobConfiguration jobConfiguration;

    public JobScheduler(JobLauncher jobLauncher, JpaItemWriterJobConfiguration jobConfiguration) {
        this.jobLauncher = jobLauncher;
        this.jobConfiguration = jobConfiguration;
    }

//    @Scheduled(cron = "*/30 * * * * *")
    public void runJob() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        Map<String, JobParameter> confMap = new HashMap<>();
        confMap.put("time", new JobParameter(String.valueOf(LocalDateTime.now())));
        JobParameters jobParameters = new JobParameters(confMap);

        jobLauncher.run(jobConfiguration.jpaItemWriterJob(), jobParameters);
    }
}
