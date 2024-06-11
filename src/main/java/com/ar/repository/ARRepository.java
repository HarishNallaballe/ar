package com.ar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ar.bindings.SsaResponse;
import com.ar.entity.RegistrationEntity;

public interface ARRepository extends JpaRepository<RegistrationEntity, Integer>{

	public SsaResponse findByCitizenId(Integer citienId);
	
}
