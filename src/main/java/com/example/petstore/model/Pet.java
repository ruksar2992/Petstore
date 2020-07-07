package com.example.petstore.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.example.petstore.enumpack.Status;


@Entity
public class Pet {
	@Id
	private int petId;
	private String petName;
	private double price;
	@Enumerated(value = EnumType.STRING)
	private Status status;
    private String description;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPetId() {
		return petId;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public static Pet findAllByPetId(int petId2) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
