package com.hexagonal.api.domain.ports.out;

import com.hexagonal.api.domain.models.AdditionalTasksInfo;

public interface ExternalServicePort {
    AdditionalTasksInfo getAdditionalTaskInfo(Long id);
}
