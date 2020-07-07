package com.example.petstore.dto;

import com.example.petstore.enumpack.Status;

public class PetDetailsResponseDto {
    
		private int petId;  
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