package com.example.LocationService.controller;

import java.sql.Timestamp;
import java.util.List;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.LocationService.model.GeoShape;
import com.example.LocationService.model.Location;
import com.example.LocationService.model.LocationService;
import com.example.LocationService.repository.CassandraLocationRepository;
import com.example.LocationService.repository.LocationRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/api")
public class LocationController {
     @Autowired
     private LocationRepository repository;
     @Autowired
     private CassandraLocationRepository csRepository;
     @Autowired
 	 private ModelMapper modelMapper;
     
     @GetMapping("/ShowFormForAdd")
 	 public String ShowFormForAdd(Model model)
 	 {
 		LocationService locationService = new LocationService();
 		model.addAttribute("saveLocation",locationService);
 		return "Location-form";
 	 }
     
   //Entering values into asset table
 	@PostMapping("/location")
     private String creat(@ModelAttribute("saveLocation")LocationService locationService) throws JsonMappingException, JsonProcessingException{
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
 		csRepository.save(locationService);
 		return "Location-form";
 	}
 	@GetMapping("/locationList")
 	private String read(Model model) {
 		List<Location> data = (List<Location>) repository.findByObjectType("location");
 		model.addAttribute("location",data);
 		System.out.println(data);
 		
 	  
 		return "Location-list";
 	}
 	@GetMapping("/findById/{id}")
 	public Location findById(@PathVariable String id){
 		Location location=  repository.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
 		System.out.println(location.getGeo_shape1().getCoordinates());
 		return location;
 	}
 	 @GetMapping("/ShowFormForUpdate")
 	 public String ShowFormForUpdate(Model model)
 	 {
 		LocationService locationService = new LocationService();
 		model.addAttribute("saveLocation",locationService);
 		return "Update-form";
 	 }
 	@PostMapping("/locationUpdate")
    private String Update(@ModelAttribute("saveLocation")LocationService locationService) throws JsonMappingException, JsonProcessingException{
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
		csRepository.save(locationService);
		return "Update-form";
	}
 	@GetMapping("delete")
	private String deleteById(@RequestParam("id") String id) {
		repository.deleteById(id);
		csRepository.deleteById(id);
		return "redirect:/api/assetList";
	}

     
}
