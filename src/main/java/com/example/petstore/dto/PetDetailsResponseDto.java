package com.example.petstore.dto;

import com.example.petstore.enumpack.Status;

public class PetDetailsResponseDto {
    
		private int petId;  
	    private String petName;
	    private String description;
	    public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getPetName() {
			return petName;
		}
		public void setPetName(String petName) {
			this.petName = petName;
		}
		private double price;  
	    private Status status;
		public int getPetId() {
			return petId;
		}
		public void setPetId(int petId) {
			this.petId = petId;
		}
			 
		
		
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public Status getStatus() {
			return status;
		}
		public void setStatus(Status status) {
			this.status = status;
		}            
	
	    
}