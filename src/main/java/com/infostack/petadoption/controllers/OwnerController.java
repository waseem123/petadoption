package com.infostack.petadoption.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infostack.petadoption.Models.PetOwner;
import com.infostack.petadoption.services.OwnerService;

@RestController
@RequestMapping("/owner")
public class OwnerController {
	@Autowired
	private OwnerService ownerService;

	@PostMapping("/add")
	public ResponseEntity<String> addOwner(@RequestParam("owner_name") String ownerName,@RequestParam("owner_address") String ownerAddress){
		if( ownerService.addNewOwner(new PetOwner(ownerName,ownerAddress))) {
			return new ResponseEntity<String>("Data Saved Successfully",HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Data could be saved",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping("/")
	public ResponseEntity<List<PetOwner>> getAllOwners(){
		List<PetOwner> petOwners = new ArrayList<PetOwner>();
		petOwners = ownerService.getAllOwners();
		if(!petOwners.isEmpty()) {
			
			return new ResponseEntity<List<PetOwner>>(petOwners,HttpStatus.FOUND);
		}
		List<PetOwner> petOwners1 = new ArrayList<PetOwner>();
		return new ResponseEntity<List<PetOwner>>(petOwners1,HttpStatus.NOT_FOUND);
	}
}
