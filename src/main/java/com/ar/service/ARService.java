package com.ar.service;

import java.util.List;

import com.ar.bindings.SsaRequest;
import com.ar.bindings.SsaResponse;

public interface ARService {
	
	public String createApplication(SsaRequest ssaRequest);
	public List<SsaResponse> getApplications();
	public SsaResponse getApplication(Integer appNumber);
	public SsaResponse getByCitizen(Integer citizenId);
}
