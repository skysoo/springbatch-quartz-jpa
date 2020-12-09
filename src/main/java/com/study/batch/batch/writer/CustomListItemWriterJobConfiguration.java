package com.study.batch.batch.writer;

import com.study.batch.dto.Pay;
import com.study.batch.dto.Pay2;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;
import java.util.Arrays;
import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Configuration
public class CustomListItemWriterJobConfiguration {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final EntityManagerFactory entityManagerFactory;

    private static final int chunkSize = 2;

    @Bean
    public Job customListItemWriterJob() {
        return jobBuilderFactory.get("customListItemWriterJob")
                .start(customListItemWriterStep())
                .build();
    }

    @Bean
    public Step customListItemWriterStep() {
        return stepBuilderFactory.get("customItemWriterStep")
                .<Pay, List<Pay2>>chunk(chunkSize)
                .reader(customListItemWriterReader())
                .processor(customItemListWriterProcessor())
                .writer(customListItemWriter())
                .build();
    }

    @Bean(destroyMethod = "")
    public JpaPagingItemReader<Pay> customListItemWriterReader() {
        return new JpaPagingItemReaderBuilder<Pay>()
                .name("customListItemWriterReader")
                .entityManagerFactory(entityManagerFactory)
                .pageSize(chunkSize)
                .queryString("SELECT p FROM Pay p")
                .build();
    }
    /**
     * Writer에서 읽은 데이터를 파싱한 데이터 묶음(list)를 writer로 던져야 할 때
     **/
    @Bean
    public ItemProcessor<Pay,List<Pay2>> customItemListWriterProcessor() {
        return pay -> Arrays.asList(
                Pay2.builder()
                        .amount(pay.getAmount() +3000)
                        .txName(pay.getTxName() +"_CUSTOM_CLONE1")
                        .txDateTime(pay.getTxDateTime())
                        .build(),
                Pay2.builder()
                        .amount(pay.getAmount() +3000)
                        .txName(pay.getTxName() +"_CUSTOM_CLONE2")
                        .txDateTime(pay.getTxDateTime())
                        .build()
        );
    }

    /**
     *
     **/
    @Bean
    public ItemWriter<List<Pay2>> customListItemWriter() {
        return items -> {
            for (List<Pay2> list : items){
                for (Pay2 pay2 : list){
                    log.info(pay2);
                }
            }
        };
    }
}
