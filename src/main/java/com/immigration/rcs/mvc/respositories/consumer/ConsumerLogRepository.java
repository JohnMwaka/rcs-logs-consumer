package com.immigration.rcs.mvc.respositories.consumer;

import com.immigration.rcs.mvc.models.consumer.ConsumerLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerLogRepository extends JpaRepository<ConsumerLogEntity, Long> , JpaSpecificationExecutor<ConsumerLogEntity> {
}