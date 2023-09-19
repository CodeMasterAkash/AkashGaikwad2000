package com.jspiders.SpringMVC_CarDekho.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.SpringMVC_CarDekho.pojo.CarPOJO;

@Repository
public class CarRepository {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;

	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("MVC");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}

	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction != null) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
	}

	public CarPOJO addCar(String carName, String carBrand, String fuelType, double price) {
		openConnection();
		transaction.begin();

		CarPOJO pojo = new CarPOJO();
		pojo.setCarName(carName);
		pojo.setCarBrand(carBrand);
		pojo.setFuelType(fuelType);
		pojo.setPrice(price);

		manager.persist(pojo);

		transaction.commit();
		closeConnection();
		return pojo;
	}

	public CarPOJO searchCar(int carId) {
		openConnection();
		transaction.begin();

		CarPOJO pojo = manager.find(CarPOJO.class, carId);

		transaction.commit();
		closeConnection();
		return pojo;
	}

	public List<CarPOJO> findAllCars() {
		openConnection();
		transaction.begin();
		String jpql = "from CarPOJO";
		query = manager.createQuery(jpql);
		@SuppressWarnings("unchecked")
		List<CarPOJO> cars = query.getResultList();
		transaction.commit();
		closeConnection();
		return cars;
	}

	public CarPOJO removeCar(int carId) {
		openConnection();
		transaction.begin();

		CarPOJO pojo = manager.find(CarPOJO.class, carId);
		if (pojo != null) {
			manager.remove(pojo);
		}

		transaction.commit();
		closeConnection();
		return pojo;
	}

	public CarPOJO updateCar(int carId, String carName, String carBrand, String fuelType, double price) {
		openConnection();
		transaction.begin();

		CarPOJO pojo = manager.find(CarPOJO.class, carId);
		pojo.setCarName(carName);
		pojo.setCarBrand(carBrand);
		pojo.setFuelType(fuelType);
		pojo.setPrice(price);

		manager.persist(pojo);

		transaction.commit();
		closeConnection();
		return pojo;
	}

}
