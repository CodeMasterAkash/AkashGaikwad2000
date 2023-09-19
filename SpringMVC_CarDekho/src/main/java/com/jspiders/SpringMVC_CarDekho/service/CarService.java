package com.jspiders.SpringMVC_CarDekho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.SpringMVC_CarDekho.pojo.CarPOJO;
import com.jspiders.SpringMVC_CarDekho.repository.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository repository;

	public CarPOJO addCar(String carName, String carBrand, String fuelType, double price) {
		CarPOJO pojo = repository.addCar(carName, carBrand, fuelType, price);
		return pojo;
	}

	public CarPOJO searchCar(int carId) {
		CarPOJO pojo = repository.searchCar(carId);
		return pojo;
	}

	public List<CarPOJO> findAllCars() {
		List<CarPOJO> cars = repository.findAllCars();
		return cars;
	}

	public CarPOJO removeCar(int carId) {
		CarPOJO pojo = repository.removeCar(carId);
		return pojo;
	}

	public CarPOJO updateCar(int carId, String carName, String carBrand, String fuelType, double price) {
		CarPOJO pojo = repository.updateCar(carId, carName, carBrand, fuelType, price);
		return pojo;
	}

}
