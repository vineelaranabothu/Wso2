package com.spring.Location.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Location.model.Location;
import com.spring.Location.repository.LocationRepository ;


@RestController
@RequestMapping("/api")

public class LocationController {
	
	@Autowired
	private LocationRepository locationRepository;
	
	
	//Entering values into asset table
		@PostMapping(path="/location")
	    private Location creat(@RequestBody Location location){
			locationRepository.save(location);
			return location;
		}
		
		//Getting all the data from Asset
		@GetMapping("/location")
		private List<Location> allData(){
			List<Location> data = (List<Location>) locationRepository.findAll();
			return data;
		}		//Updating asset data
		@PutMapping("/location")
		private Location update(@RequestBody Location location) {
			locationRepository.save(location);
			return location;
		}
		
		//Delete by id
		@DeleteMapping("location/{id}")
		private String deleteById(@PathVariable String id) {
			locationRepository.deleteById(id);
			return "id: "+id+" deleted";
		}


}
