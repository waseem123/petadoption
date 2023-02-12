package com.infostack.petadoption.services;

import com.infostack.petadoption.Models.PetAdopter;
import com.infostack.petadoption.repositories.AdopterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetAdopterService {
	@Autowired
	AdopterRepository adopterRepository;
	public PetAdopter getAdopterById(int adopter_id) {
		return adopterRepository.findById(adopter_id).get();
	}

    public PetAdopter login(String user_email, String user_password) {
		return adopterRepository.login(user_email,user_password);
    }
}
