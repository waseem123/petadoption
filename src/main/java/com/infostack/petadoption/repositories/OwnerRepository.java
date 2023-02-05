package com.infostack.petadoption.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infostack.petadoption.Models.PetOwner;

@Repository
public interface OwnerRepository extends CrudRepository<PetOwner,Integer> {

}
