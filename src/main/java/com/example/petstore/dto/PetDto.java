package com.example.petstore.dto;

import com.example.petstore.enumpack.Status;

public class PetDto {
    
		private int petId;
		private double Price;
	    private String description;
	    private Status status;
		public int getPetId() {
			return petId;
		}
		public void setPetId(int petId) {
			this.petId = petId;
		}
		
		public double getPrice() {
			return Price;
		}
		public void setPrice(double price) {
			Price = price;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Status getStatus() {
			return status;
		}
		public void setStatus(Status status) {
			this.status = status;
		}
	    
	    
	    
}	     





