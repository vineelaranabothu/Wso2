package com.example.LocationPostman.controller;

import java.sql.Timestamp;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LocationPostman.model.GeoShape;
import com.example.LocationPostman.model.Location;
import com.example.LocationPostman.model.LocationService;
import com.example.LocationPostman.repository.CassandraLocationRepository;
import com.example.LocationPostman.repository.LocationRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")
public class LocationController {
     @Autowired
     private LocationRepository repository;
     @Autowired
     private CassandraLocationRepository csRepository;
     @Autowired
 	 private ModelMapper modelMapper;
     
   
   //Entering values into asset table
 	@PostMapping("/location")
     private LocationService creat(@RequestBody LocationService locationService) throws JsonMappingException, JsonProcessingException{
 		Location location = modelMapper.map(locationService,Location.class);
 		Timestamp time = new Timestamp(System.currentTimeMillis());
 		location.setCreated_time(time);
 		locationService.setCreated_time(time);
 		location.setObjectType("location");
 		GeoShape gs = new ObjectMapper().readValue(locationService.getGeo_shape(), GeoShape.class);
 		System.out.println(gs);
 		location.setGeo_shape1(gs);
 		System.out.println(location.getGeo_shape1().getCoordinates());
 		repository.save(location);
 		return csRepository.save(locationService);
 		
 	}
 	@GetMapping("/findAll")
	public Iterable<Location> findAllCustomers() {
		return repository.findByObjectType("location");
	}
 	@GetMapping("/findById/{id}")
 	public Location findById(@PathVariable String id){
 		Location location=  repository.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
 		System.out.println(location.getGeo_shape1().getCoordinates());
 		return location;
 	}
 	@PutMapping("/location")
 	 private LocationService update(@RequestBody LocationService locationService) throws JsonMappingException, JsonProcessingException{
 		Location location = modelMapper.map(locationService,Location.class);
 		Location locationS= (Location) repository.findById(location.getId()).orElseThrow(() -> new RuntimeException("id not found"));
 		
 		Timestamp time = new Timestamp(System.currentTimeMillis());
 		location.setCreated_time(locationS.getCreated_time());
 		locationService.setCreated_time(locationS.getCreated_time());
 		location.setCreated_by(locationS.getCreated_by());
 		locationService.setCreated_by(locationS.getCreated_by());
 		location.setModified_time(time);
 		locationService.setModified_time(time);
 		location.setObjectType("location");
 		GeoShape gs = new ObjectMapper().readValue(locationService.getGeo_shape(), GeoShape.class);
 		System.out.println(gs);
 		location.setGeo_shape1(gs);
 		System.out.println(location.getGeo_shape1().getCoordinates());
 		repository.save(location);
 		return csRepository.save(locationService);
 		
 	}
 	
 	@DeleteMapping("/location/{id}")
 	public String deleteById(@PathVariable String id){
 		repository.deleteById(id);
 		csRepository.deleteById(id);
 		return "id is deleted";
 	}
 		
 	
}
