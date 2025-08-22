package com.immigration.rcs.mvc.respositories.producer;

import com.immigration.rcs.mvc.models.producer.ProducerLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerLogRepository extends JpaRepository<ProducerLogEntity, Long> , JpaSpecificationExecutor<ProducerLogEntity> {
}