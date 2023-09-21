package com.hexagonal.api.application.useCases;
import com.hexagonal.api.domain.models.AdditionalTasksInfo;
import com.hexagonal.api.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.hexagonal.api.domain.ports.out.ExternalServicePort;

public class GetAdditionalTaskInfoUseCaseImpl implements GetAdditionalTaskInfoUseCase{
    private final ExternalServicePort externalServicePort;

    public GetAdditionalTaskInfoUseCaseImpl(ExternalServicePort externalServicePort) {
        this.externalServicePort = externalServicePort;
    }
    
    @Override
    public AdditionalTasksInfo getAdditionalTaskInfo(Long id) {
        return externalServicePort.getAdditionalTaskInfo(id);
    }
    
}
