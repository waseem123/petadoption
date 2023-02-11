package com.infostack.petadoption.repositories;

import com.infostack.petadoption.Models.PetAdopter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdopterRepository extends CrudRepository<PetAdopter,Integer>{

}
