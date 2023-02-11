package com.infostack.petadoption.repositories;

import com.infostack.petadoption.Models.Application;
import com.infostack.petadoption.dto.ApplicationDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends CrudRepository<Application,Integer>{
	
	@Query("SELECT new com.infostack.petadoption.dto.ApplicationDTO(ap.applicationId,ad.adopterName,pet.petName,ap.applicationDate) FROM Application ap INNER JOIN ap.petAdopter ad INNER JOIN ap.petAnimal pet ")
	public List<ApplicationDTO> getAppData();
	
	@Query("SELECT new com.infostack.petadoption.dto.ApplicationDTO(ap.applicationId,ad.adopterName,pet.petName,o.ownerName,ap.applicationDate) FROM Application ap INNER JOIN ap.petAdopter ad INNER JOIN ap.petAnimal pet INNER JOIN pet.petOwner o")
	public List<ApplicationDTO> getAppDataWithOwner();
}
