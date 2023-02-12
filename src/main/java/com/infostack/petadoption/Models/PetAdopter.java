package com.infostack.petadoption.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_adopter")
public class PetAdopter {
    @Id
    @Column(name = "adopter_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adopterId;
    @Column(name = "adopter_name")
    private String adopterName;
    @Column(name = "owner_address")
    private String adopterAddress;

    public PetAdopter() {
    }

    public int getAdopterId() {
        return adopterId;
    }

    public void setAdopterId(int adopterId) {
        this.adopterId = adopterId;
    }

    public String getAdopterName() {
        return adopterName;
    }

    public void setAdopterName(String adopterName) {
        this.adopterName = adopterName;
    }

    public String getAdopterAddress() {
        return adopterAddress;
    }

    public void setAdopterAddress(String adopterAddress) {
        this.adopterAddress = adopterAddress;
    }


}
