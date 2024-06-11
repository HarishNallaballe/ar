package com.ar.rest;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ar.bindings.SsaRequest;
import com.ar.bindings.SsaResponse;
import com.ar.service.ARService;

@RestController
public class ARControlller {

	@Autowired
	private ARService arSservice;

	@PostMapping("/registration")
	public ResponseEntity<String> registration(@RequestBody SsaRequest ssaRequest) {
		String message = arSservice.createApplication(ssaRequest);
		return new ResponseEntity<>(message,HttpStatus.OK);
	}

	@GetMapping("/applications")
	public ResponseEntity<List<SsaResponse>> getAll() {
		List<SsaResponse> applications = arSservice.getApplications();
		return new ResponseEntity<>(applications, HttpStatus.OK);
	}

	@GetMapping("/application/{appNum}")
	public ResponseEntity<SsaResponse> getByAppNum(@PathVariable Integer appNum){
		SsaResponse response = arSservice.getApplication(appNum);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping("/citizen/{citizenId}")
	public ResponseEntity<SsaResponse> getByCitizen(@PathVariable Integer citizenId){
		SsaResponse response = arSservice.getByCitizen(citizenId);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
