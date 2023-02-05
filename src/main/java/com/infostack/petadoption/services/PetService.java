/**
 * 
 */
package com.infostack.petadoption.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infostack.petadoption.Models.PetAnimal;
import com.infostack.petadoption.dto.PetData;
import com.infostack.petadoption.repositories.PetRepository;

/**
 * @author Computer
 *
 */

@Service
public class PetService {
	@Autowired
	PetRepository petRepository;
	
	public PetAnimal addNew(PetAnimal petAnimal) {
		return petRepository.save(petAnimal);
		
	}

	public List<PetAnimal> getAllAnimals() {
		// TODO Auto-generated method stub
		
		return (List<PetAnimal>) petRepository.findAll();
	}

	public PetAnimal getAnimalById(int pet_id) {
		// TODO Auto-generated method stub
		return petRepository.findById(pet_id).get();
	}

	public void deletePetAnimal(int petId) {
		// TODO Auto-generated method stub
		petRepository.deleteById(petId);
		
	}

	public PetAnimal getAnimalByName(String petName) {
		// TODO Auto-generated method stub
		return petRepository.getAnimalByName(petName);
	}
	
	public List<PetAnimal> getAnimalsByName(String petName) {
		// TODO Auto-generated method stub
		return petRepository.getAnimalsByName(petName);
	}

	public List<PetAnimal> getAnimalsByCategoryAndGender(String petCategory, String petGender) {
		// TODO Auto-generated method stub
		return petRepository.getAnimalsByCategoryAndGender(petCategory,petGender);
	}
	
	public List<PetData> getAnimalsData(String petCategory, String petGender) {
		// TODO Auto-generated method stub
		return petRepository.getAnimalsData(petCategory,petGender);
	}
}
