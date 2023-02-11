package com.infostack.petadoption.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infostack.petadoption.Models.PetAnimal;
import com.infostack.petadoption.Models.PetOwner;
import com.infostack.petadoption.repositories.OwnerRepository;
import com.infostack.petadoption.repositories.PetRepository;

@Service
public class OwnerService {
	@Autowired
	private OwnerRepository ownerRepository;
	
	@Autowired
	private PetRepository petRepository;
	
	public boolean addNewOwner(PetOwner petOwner) {
		if(petOwner!=null) {
			ownerRepository.save(petOwner);
			return true;
		}
		return false;
	}
	
	public List<PetOwner> getAllOwners(){
		return (List<PetOwner>) ownerRepository.findAll();
	}

	public PetOwner getOwnerById(int ownerId) {
		// TODO Auto-generated method stub
		return ownerRepository.findById(ownerId).get();
	}
	
	public List<PetAnimal> getAnimalsByOwner(int ownerId) {
		// TODO Auto-generated method stub
		return petRepository.getAnimalsByOwner(ownerId);
	}

    public PetOwner login(String ownerEmail, String ownerPassword) {
		PetOwner owner = ownerRepository.login(ownerEmail, ownerPassword);
		return owner;
    }
}
