package com.immigration.rcs.mvc.respositories;

import com.immigration.rcs.mvc.models.LogDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LogDetailsRepository extends JpaRepository<LogDetails, Long> , JpaSpecificationExecutor<LogDetails> {
}