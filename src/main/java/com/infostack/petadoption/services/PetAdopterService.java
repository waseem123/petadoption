package com.infostack.petadoption.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infostack.petadoption.Models.PetAdopter;
import com.infostack.petadoption.repositories.AdopterRepository;

@Service
public class PetAdopterService {
	@Autowired
	AdopterRepository adopterRepository;
	public PetAdopter getAdopterById(int adopter_id) {
		return adopterRepository.findById(adopter_id).get();
	}

}
