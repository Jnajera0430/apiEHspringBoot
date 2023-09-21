package com.hexagonal.api.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hexagonal.api.application.services.TaskServices;
import com.hexagonal.api.application.useCases.CreateTaskUseCaseImpl;
import com.hexagonal.api.application.useCases.DeleteTaskUseCaseImpl;
import com.hexagonal.api.application.useCases.GetAdditionalTaskInfoUseCaseImpl;
import com.hexagonal.api.application.useCases.RetriveTaskUseCaseImpl;
import com.hexagonal.api.application.useCases.UpdateTaskUseCaseImpl;
import com.hexagonal.api.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.hexagonal.api.domain.ports.out.ExternalServicePort;
import com.hexagonal.api.domain.ports.out.TaskRepositoryPort;
import com.hexagonal.api.infrastructure.adapters.ExternalServiceAdapters;
import com.hexagonal.api.infrastructure.repositories.JPATaskRepositoryAdapter;

@Configuration
public class ApplicationConfig {
    @Bean
    public TaskServices taskServices(TaskRepositoryPort taskRepositoryPort,
            GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
        return new TaskServices(
                new CreateTaskUseCaseImpl(taskRepositoryPort),
                new DeleteTaskUseCaseImpl(taskRepositoryPort),
                new UpdateTaskUseCaseImpl(taskRepositoryPort),
                new RetriveTaskUseCaseImpl(taskRepositoryPort),
                getAdditionalTaskInfoUseCase);
    }

    @Bean
    public TaskRepositoryPort taskRepositoryPort(JPATaskRepositoryAdapter jpaTaskRepositoryAdapter){
        return jpaTaskRepositoryAdapter;
    }

    @Bean
    public GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase(
        ExternalServicePort externalServicePort){
            return new GetAdditionalTaskInfoUseCaseImpl(externalServicePort);
    }

    @Bean
    public ExternalServicePort externalServicePort(){
        return new ExternalServiceAdapters();
    }
}
