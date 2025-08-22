package com.immigration.rcs.mvc.respositories.securiport;

import com.immigration.rcs.mvc.models.securiport.SecLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SecLogRepository extends JpaRepository<SecLogEntity, Long> , JpaSpecificationExecutor<SecLogEntity> {
}