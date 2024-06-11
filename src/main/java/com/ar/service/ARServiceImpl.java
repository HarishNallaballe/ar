package com.ar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ar.bindings.SsaRequest;
import com.ar.bindings.SsaResponse;
import com.ar.entity.RegistrationEntity;
import com.ar.props.AppProps;
import com.ar.repository.ARRepository;

@Service
public class ARServiceImpl implements ARService {

	@Autowired
	private AppProps appProps;

	@Autowired
	private ARRepository arRepository;

	public final String apiUrl = "http://13.235.5.131:1999/state/{ssn}";

	@Override
	public String createApplication(SsaRequest ssaRequest) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> forEntity = restTemplate.getForEntity(apiUrl, String.class, ssaRequest.getSsn());
		String stateName = forEntity.getBody();
		if (stateName.equalsIgnoreCase("Rhode Island")) {
			RegistrationEntity entity = new RegistrationEntity();
			BeanUtils.copyProperties(ssaRequest, entity);
			arRepository.save(entity);
			return "Created Successfully";
		} else {
			return "Not Created";
		}

	}

	@Override
	public List<SsaResponse> getApplications() {
		
		  List<RegistrationEntity> entities = arRepository.findAll(); 
		  List<SsaResponse> dto=new ArrayList<>();
		  entities.forEach(e->{
			  SsaResponse response = new SsaResponse();
			  BeanUtils.copyProperties(e, response);
			  dto.add(response);
		  });
		return dto;
		
	}

	private static Integer generateAppNumber() {
		String alphanumericCharacters = "1234567890";
		int length = 4;
		StringBuffer randomString = new StringBuffer(length);
		Random random = new Random();

		for (int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(alphanumericCharacters.length());
			char randomChar = alphanumericCharacters.charAt(randomIndex);
			randomString.append(randomChar);
		}

		String string = randomString.toString();
		return Integer.parseInt(string);
	}

	@Override
	public SsaResponse getApplication(Integer appNumber) {
		RegistrationEntity entity = arRepository.findById(appNumber).orElseThrow();
		SsaResponse response = new SsaResponse();
		BeanUtils.copyProperties(entity, response);
		return response;
	}

	@Override
	public SsaResponse getByCitizen(Integer citizenId) {
		SsaResponse citizen = arRepository.findByCitizenId(citizenId);
		return citizen;
	}

}
