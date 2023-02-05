package com.infostack.petadoption.controllers;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infostack.petadoption.Models.Application;
import com.infostack.petadoption.Models.PetAdopter;
import com.infostack.petadoption.Models.PetAnimal;
import com.infostack.petadoption.Models.PetOwner;
import com.infostack.petadoption.dto.ApplicationDTO;
import com.infostack.petadoption.dto.PetData;
import com.infostack.petadoption.services.ApplicationService;
import com.infostack.petadoption.services.OwnerService;
import com.infostack.petadoption.services.PetAdopterService;
import com.infostack.petadoption.services.PetService;

@RestController
@RequestMapping(path="/petanimal")
public class PetController {
	@Autowired
	PetService petService;
	
	@Autowired
	OwnerService ownerService;

	@Autowired
	private PetAdopterService petAdopterService;

	@Autowired
	private ApplicationService applicationService;
	
	@RequestMapping("/")
	public List<PetAnimal> getAnimals() {
		List<PetAnimal> petAnimalList=new ArrayList<>();
		petAnimalList = petService.getAllAnimals();
		return petAnimalList;
	}
	
	@RequestMapping("/{pet_id}")
	public PetAnimal getAnimalById(@PathVariable int pet_id) {
		PetAnimal pet = null;
		 try {
			 pet = petService.getAnimalById(pet_id);
		 }catch(Exception ex){
			 pet = new PetAnimal();
		 }
		 return pet;
	}
	
	@GetMapping("/search")
	public PetAnimal getAnimalByName(@RequestParam("pet_name") String petName) {
		PetAnimal pet = null;
		 try {
			 pet = petService.getAnimalByName(petName);
		 }catch(Exception ex){
			 pet = new PetAnimal();
		 }
		 return pet;
	}
	
	@GetMapping("/searchall")
	public List<PetAnimal> getAnimalsByName(@RequestParam("pet_name") String petName) {
		List<PetAnimal> pet = null;
		pet = petService.getAnimalsByName(petName);
		return pet;
	}
	
	@GetMapping("/searchbycategory")
	public List<PetAnimal> getAnimalsByCategoryAndGender(@RequestParam("pet_category") String petCategory,@RequestParam("pet_gender") String petGender) {
		List<PetAnimal> pet = null;
		pet = petService.getAnimalsByCategoryAndGender(petCategory,petGender);
		return pet;
	}
	
	@GetMapping("/searchbycategoryandgender")
	public List<PetData> getAnimalsData(@RequestParam("pet_category") String petCategory,@RequestParam("pet_gender") String petGender) {
		List<PetData> pet = null;
		pet = petService.getAnimalsData(petCategory,petGender);
		return pet;
	}
	
	@PostMapping("/add")
	public PetAnimal addNew(
			@RequestParam("pet_name") String petName,
			@RequestParam("pet_category") String petCategory, 
			@RequestParam("pet_age") int petAge, 
			@RequestParam("pet_gender") String petGender, 
			@RequestParam("pet_breed") String petBreed) {
		PetAnimal petAnimal = new PetAnimal(petName,petCategory,petAge,petGender,petBreed,false);
		PetOwner petOwner = ownerService.getOwnerById(1);
		petAnimal.setPetOwner(petOwner);
		return petService.addNew(petAnimal);
	}
	
	@PutMapping("/edit")
	public PetAnimal edit(
			@RequestParam("pet_id") int petId,
			@RequestParam("pet_name") String petName,
			@RequestParam("pet_category") String petCategory, 
			@RequestParam("pet_age") int petAge, 
			@RequestParam("pet_gender") String petGender, 
			@RequestParam("pet_breed") String petBreed) {
		PetAnimal petAnimal = new PetAnimal(petId,petName,petCategory,petAge,petGender,petBreed,false);
		return petService.addNew(petAnimal);
	}
	
	@DeleteMapping("/delete/{pet_id}")
	public String deletePet(@PathVariable("pet_id") int petId) {
		PetAnimal pet = petService.getAnimalById(petId);
		if(pet.isPetStatus()) {
			petService.deletePetAnimal(petId);
			return "DELETED SUCCESFULLY";
		}
		return "CANNOT DELETE";
		
	}
	
	@RequestMapping("/application/{pet_id}")
	public Application apply(@PathVariable("pet_id") int petId) throws ParseException {
		PetAnimal petAnimal = petService.getAnimalById(petId);
		PetAdopter petAdopter = petAdopterService.getAdopterById(1);
		
		Application application = new Application();
		application.setPetAnimal(petAnimal);
		application.setPetAdopter(petAdopter);
		application.setApplicationDate(new SimpleDateFormat("yyyy-MM-dd").parse("2023-01-30"));
		return applicationService.saveApplication(application);
	}
	
	@RequestMapping("/application/")
	public List<ApplicationDTO> getApplicationData() {
		
		return applicationService.getApplication();
	}
}
