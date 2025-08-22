package com.immigration.rcs.mvc.respositories.consumer;

import com.immigration.rcs.mvc.models.LogDetails;
import com.immigration.rcs.mvc.models.consumer.ConsumerLogDetails;
import com.immigration.rcs.mvc.models.consumer.ConsumerLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConsumerLogDetailsRepository extends JpaRepository<ConsumerLogDetails, Long> , JpaSpecificationExecutor<ConsumerLogDetails> {
    Optional<LogDetails> findByConsumerLog(ConsumerLogEntity consumerLogEntity);
}