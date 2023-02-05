package com.infostack.petadoption.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infostack.petadoption.Models.PetOwner;
import com.infostack.petadoption.repositories.OwnerRepository;

@Service
public class OwnerService {
	@Autowired
	private OwnerRepository ownerRepository;
	
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
}
