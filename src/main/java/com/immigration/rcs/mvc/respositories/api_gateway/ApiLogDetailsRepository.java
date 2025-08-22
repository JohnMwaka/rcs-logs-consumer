package com.immigration.rcs.mvc.respositories.api_gateway;

import com.immigration.rcs.mvc.models.LogDetails;
import com.immigration.rcs.mvc.models.api_gateway.ApiLogDetails;
import com.immigration.rcs.mvc.models.api_gateway.ApiLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApiLogDetailsRepository extends JpaRepository<ApiLogDetails, Long> , JpaSpecificationExecutor<ApiLogDetails> {
    Optional<LogDetails> findByApiLog(ApiLogEntity apiLogEntity);
}