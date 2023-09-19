package com.jspiders.SpringMVC_CarDekho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jspiders.SpringMVC_CarDekho.pojo.AdminPOJO;
import com.jspiders.SpringMVC_CarDekho.pojo.CarPOJO;
import com.jspiders.SpringMVC_CarDekho.service.CarService;

@Controller
public class CarController {

	@Autowired
	private CarService service;

	// Home Page Controller
	@GetMapping("/home")
	public String home(@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map) {

		if (admin != null) {
			return "Home";
		}

		map.addAttribute("msg", "Session TimeOut. Login to proceed..!");
		return "Login";
	}

	// Add Page Controller
	@GetMapping("/add")
	public String addPage(@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map) {

		if (admin != null) {
			List<CarPOJO> cars = service.findAllCars();
			if (!cars.isEmpty()) {
				map.addAttribute("cars", cars);
				return "Add";
			}
			return "Add";
		}

		map.addAttribute("msg", "Session TimeOut. Login To proceed..!");
		return "Login";
	}

	// Add Car Controller
	@PostMapping("/add")
	public String addCar(@SessionAttribute(name = "login", required = false) AdminPOJO admin,
			@RequestParam String carName, @RequestParam String carBrand, @RequestParam String fuelType,
			@RequestParam double price, ModelMap map) {
		if (admin != null) {
			CarPOJO pojo = service.addCar(carName, carBrand, fuelType, price);

			// Success
			if (pojo != null) {
				map.addAttribute("msg", "Data inserted successfully..!");
				List<CarPOJO> cars = service.findAllCars();
				map.addAttribute("cars", cars);
				return "Add";
			}
			// Failure
			map.addAttribute("msg", "Data not inserted..!");
			List<CarPOJO> cars = service.findAllCars();
			if (!cars.isEmpty()) {
				map.addAttribute("cars", cars);
			}
			return "Add";
		}
		map.addAttribute("msg", "Session TimeOut. Login to proceed..!");
		return "Login";
	}

	// Search page Controller
	@GetMapping("/search")
	public String searchPage(@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map) {
		if (admin != null) {
			return "Search";
		}
		map.addAttribute("msg", "Session TimeOut. Login to proceed..!");
		return "Login";
	}

	// Search Car Controller
	@PostMapping("/search")
	public String searchCar(@SessionAttribute(name = "login", required = false) AdminPOJO admin,
			@RequestParam int carId, ModelMap map) {
		if (admin != null) {
			CarPOJO pojo = service.searchCar(carId);
			// Success
			if (pojo != null) {
				map.addAttribute("car", pojo);
				map.addAttribute("msg", "CarDetails data found..!");
				return "Search";
			}
			// Failure
			map.addAttribute("msg", "CarDetails data not found..!");
			return "Search";
		}
		map.addAttribute("msg", "Session TimeOut. Login to proceed..!");
		return "Login";
	}

	// Remove page Controller
	@GetMapping("/remove")
	public String removePage(@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map) {
		if (admin != null) {
			List<CarPOJO> cars = service.findAllCars();
			// Success
			if (!cars.isEmpty()) {
				map.addAttribute("cars", cars);
				return "Remove";
			}
			map.addAttribute("msg", "No data present..!");
			return "Remove";
		}
		map.addAttribute("msg", "Session TimeOut. Login to proceed..!");
		return "Login";
	}

	// Remove Cars Controller
	@PostMapping("/remove")
	public String removeCar(@SessionAttribute(name = "login", required = false) AdminPOJO admin,
			@RequestParam int carId, ModelMap map) {
		if (admin != null) {
			CarPOJO pojo = service.removeCar(carId);
			List<CarPOJO> cars = service.findAllCars();

			// Success
			if (pojo != null) {
				map.addAttribute("msg", "Data removed successfully..!");
				map.addAttribute("cars", cars);
				return "Remove";
			}
			// Failure
			map.addAttribute("msg", "Data does not exist..!");
			map.addAttribute("cars", cars);
			return "Remove";
		}
		map.addAttribute("msg", "Session TimeOut. Login to proceed..!");
		return "Login";
	}

	// Update page Controller
	@GetMapping("/update")
	public String updatePage(@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map) {
		if (admin != null) {
			List<CarPOJO> cars = service.findAllCars();
			map.addAttribute("cars", cars);
			return "Update";
		}
		map.addAttribute("msg", "Session TimeOut. Login to proceed..!");
		return "Login";
	}

	// Update form/view Controller
	@PostMapping("/update")
	public String updateForm(@SessionAttribute(name = "login", required = false) AdminPOJO admin,
			@RequestParam int carId, ModelMap map) {
		if (admin != null) {
			CarPOJO pojo = service.searchCar(carId);
			// Success
			if (pojo != null) {
				map.addAttribute("car", pojo);
				return "Update";
			}
			// Failure
			List<CarPOJO> cars = service.findAllCars();
			map.addAttribute("cars", cars);
			map.addAttribute("msg", "CarDetails data not found..!");
			return "Update";
		}
		map.addAttribute("msg", "Session TimeOut. Login to proceed..!");
		return "Login";
	}

	// Update student Controller
	@PostMapping("/updateCar")
	public String updateCar(@SessionAttribute(name = "login", required = false) AdminPOJO admin,
			@RequestParam int carId, @RequestParam String carName, @RequestParam String carBrand,
			@RequestParam String fuelType, @RequestParam double price, ModelMap map) {
		if (admin != null) {
			CarPOJO pojo = service.updateCar(carId, carName, carBrand, fuelType, price);
			// Success
			if (pojo != null) {
				List<CarPOJO> cars = service.findAllCars();
				map.addAttribute("msg", "Data updated successfully..!");
				map.addAttribute("cars", cars);
				return "Update";
			}
			List<CarPOJO> cars = service.findAllCars();
			map.addAttribute("msg", "Data not updated..!");
			map.addAttribute("cars", cars);
			return "Update";
		}
		map.addAttribute("msg", "Session TimeOut. Login to proceed..!");
		return "Login";
	}

}
