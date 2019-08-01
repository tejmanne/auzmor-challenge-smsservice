package com.tejamanne.challenges.smsservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.tejamanne.challenges.smsservice.entities.PhoneNumber;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long>, JpaSpecificationExecutor<PhoneNumber> {

}
