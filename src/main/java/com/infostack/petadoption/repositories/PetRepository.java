package com.infostack.petadoption.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infostack.petadoption.Models.PetAnimal;
import com.infostack.petadoption.dto.PetData;

@Repository
public interface PetRepository extends CrudRepository<PetAnimal,Integer> {
	
	@Query("SELECT p from PetAnimal p WHERE p.petName=?1")
	public PetAnimal getAnimalByName(String animalName);
	
	@Query("SELECT p from PetAnimal p WHERE p.petName LIKE (%?1%)")
	public List<PetAnimal> getAnimalsByName(String animalName);

	@Query("select p from PetAnimal p " +
			"where p.petCategory = ?1 and p.petGender = ?2 and p.petBreed like concat('%', ?3, '%') " +
			"order by p.petAge")
	List<PetAnimal> findByPetCategoryOrPetGenderOrPetBreedOrderByPetAgeAsc(String petCategory, String petGender, String petBreed);


	
	@Query("SELECT new com.infostack.petadoption.dto.PetData(p.petId,p.petName,p.petAge) from PetAnimal p WHERE p.petCategory=?1 AND p.petGender=?2")
	public List<PetData> getAnimalsData(String petCategory,String petGender);

	@Query("select p from PetAnimal p where p.petOwner.ownerId = ?1")
	List<PetAnimal> getAnimalsByOwner(int ownerId);

}