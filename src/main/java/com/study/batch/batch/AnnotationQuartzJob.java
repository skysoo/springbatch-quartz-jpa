package com.study.batch.batch;

import com.study.batch.batch.writer.JpaItemWriterJobConfiguration;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@Component
public class AnnotationQuartzJob {
    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private JpaItemWriterJobConfiguration jobConfiguration;

//    @Scheduled(cron = "*/30 * * * * *")
    public void runJob() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        Map<String, JobParameter> confMap = new HashMap<>();
        confMap.put("time", new JobParameter(String.valueOf(LocalDateTime.now())));
        JobParameters jobParameters = new JobParameters(confMap);

        jobLauncher.run(jobConfiguration.jpaItemWriterJob(), jobParameters);
    }
}
