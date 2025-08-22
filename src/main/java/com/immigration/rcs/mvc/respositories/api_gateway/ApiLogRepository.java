package com.immigration.rcs.mvc.respositories.api_gateway;

import com.immigration.rcs.mvc.models.api_gateway.ApiLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiLogRepository extends JpaRepository<ApiLogEntity, Long> , JpaSpecificationExecutor<ApiLogEntity> {
}