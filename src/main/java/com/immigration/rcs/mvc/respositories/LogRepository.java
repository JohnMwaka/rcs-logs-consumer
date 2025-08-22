package com.immigration.rcs.mvc.respositories;

import com.immigration.rcs.mvc.models.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<LogEntity, Long> , JpaSpecificationExecutor<LogEntity> {
}