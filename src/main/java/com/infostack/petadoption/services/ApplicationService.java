package com.infostack.petadoption.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infostack.petadoption.Models.Application;
import com.infostack.petadoption.dto.ApplicationDTO;
import com.infostack.petadoption.repositories.ApplicationRepository;

@Service
public class ApplicationService {
	@Autowired
	private ApplicationRepository applicationRepository;

	public Application saveApplication(Application application) {
		return applicationRepository.save(application);
		
	}
	
	public List<ApplicationDTO> getApplication() {
		return applicationRepository.getAppDataWithOwner();
	}
}
