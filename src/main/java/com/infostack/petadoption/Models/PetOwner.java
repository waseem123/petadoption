package com.infostack.petadoption.Models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PetOwner {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ownerId;
	private String ownerName;
	private String ownerAddress;
	@OneToMany
	private List<PetAnimal> petAnimals;
	
	public PetOwner() {
	}

	
	public PetOwner(String ownerName, String ownerAddress) {
		super();
		this.ownerName = ownerName;
		this.ownerAddress = ownerAddress;
	}


	public PetOwner(int ownerId, String ownerName, String ownerAddress) {
		super();
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.ownerAddress = ownerAddress;
	}


	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerAddress() {
		return ownerAddress;
	}

	public void setOwnerAddress(String ownerAddress) {
		this.ownerAddress = ownerAddress;
	}


	public List<PetAnimal> getPetAnimals() {
		return petAnimals;
	}


	public void setPetAnimals(List<PetAnimal> petAnimals) {
		this.petAnimals = petAnimals;
	}

	
}
