package com.mybank.mybankbatch.config.participating;



import com.mybank.mybankbatch.repository.CustomerRepository;
import org.omg.PortableServer.THREAD_POLICY_ID;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.partition.PartitionHandler;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.core.partition.support.TaskExecutorPartitionHandler;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.task.TaskExecutorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;

import java.util.HashMap;
import java.util.Map;

@EnableBatchProcessing
@Configuration
public class ParticipatConfig {

    private final static int THREAD = 10;

    @Autowired
    private CustomerRepository custDao;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;


    @Bean
    public Step step1Master() {
        return stepBuilderFactory.get("step1.master")
                .<String, String>partitioner("step1", partitioner())
                .partitionHandler( partitionHandler() )
                .build();
    }

    @Bean
    public TaskExecutor taskExecutor()
    {
        TaskExecutorBuilder taskExecutorBuilder = new TaskExecutorBuilder();

        return taskExecutorBuilder.maxPoolSize( 100 )
                            .corePoolSize( 50 )
                            .build();
    }

    @Bean
    public PartitionHandler partitionHandler()
    {
        TaskExecutorPartitionHandler partitionHandler = new TaskExecutorPartitionHandler();
        partitionHandler.setTaskExecutor( taskExecutor() );
        partitionHandler.setStep(step1());
        partitionHandler.setGridSize( THREAD );
        return partitionHandler;
    }

    @Bean
    public Partitioner partitioner()
    {
        Partitioner partitioner = new Partitioner() {
            @Override
            public Map<String, ExecutionContext> partition(int gridSize) {
                Map<String,ExecutionContext> result = new HashMap<String,ExecutionContext>(  );

                long maxRecordId = custDao.getMinCustomerId();
                long minRecordId = custDao.getMinCustomerId();
                long targetSize = (maxRecordId - minRecordId)
                long start = minRecordId;
                long end = start + targetSize -1;

                while()
                {

                }
                for (int j = 1; j<gridSize;j++)
                {
                    ExecutionContext value = new ExecutionContext();
                    result.put( "partition" + j, value );

                    value.put( "MinID", );
                    value.put("MaxID",)
                }
                return null;
            }
        }
    }


}
