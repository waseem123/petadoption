package com.infostack.petadoption.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infostack.petadoption.Models.PetAdopter;

@Repository
public interface AdopterRepository extends CrudRepository<PetAdopter,Integer>{

}
