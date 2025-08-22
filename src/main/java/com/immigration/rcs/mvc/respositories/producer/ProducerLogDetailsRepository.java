package com.immigration.rcs.mvc.respositories.producer;

import com.immigration.rcs.mvc.models.LogDetails;
import com.immigration.rcs.mvc.models.producer.ProducerLogDetails;
import com.immigration.rcs.mvc.models.producer.ProducerLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProducerLogDetailsRepository extends JpaRepository<ProducerLogDetails, Long> , JpaSpecificationExecutor<ProducerLogDetails> {
    Optional<LogDetails> findByProducerLog(ProducerLogEntity producerLogEntity);
}