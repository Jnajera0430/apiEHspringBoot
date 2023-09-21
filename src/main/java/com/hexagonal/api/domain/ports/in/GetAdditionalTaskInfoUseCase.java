
package com.hexagonal.api.domain.ports.in;

import com.hexagonal.api.domain.models.AdditionalTasksInfo;

public interface GetAdditionalTaskInfoUseCase {
    AdditionalTasksInfo getAdditionalTaskInfo(Long id);
}
