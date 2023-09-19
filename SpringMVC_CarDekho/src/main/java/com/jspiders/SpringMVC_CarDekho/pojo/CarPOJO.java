package com.jspiders.SpringMVC_CarDekho.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class CarPOJO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int carId;
	private String carName;
	private String carBrand;
	private String fuelType;
	private double price;
}
