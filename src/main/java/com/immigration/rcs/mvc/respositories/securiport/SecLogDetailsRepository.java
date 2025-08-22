package com.immigration.rcs.mvc.respositories.securiport;

import com.immigration.rcs.mvc.models.securiport.SecLogDetails;
import com.immigration.rcs.mvc.models.securiport.SecLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SecLogDetailsRepository extends JpaRepository<SecLogDetails, Long> , JpaSpecificationExecutor<SecLogDetails> {
    Optional<SecLogDetails> findBySecLog(SecLogEntity secLogEntity);
}