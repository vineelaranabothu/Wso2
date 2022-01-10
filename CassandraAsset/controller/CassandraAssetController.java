package com.example.CassandraAsset.controller;

//import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.CassandraAsset.model.Asset;
import com.example.CassandraAsset.repository.CassandraAssetRepository;
import com.example.CassandraAsset.service.CassandraAssetService;



@RestController
@RequestMapping("/api")

public class CassandraAssetController {
	
	@Autowired
	private CassandraAssetService assetService;
	
	//Entering values into asset table
	@PostMapping("/asset")
    private Asset creat(@RequestBody Asset asset){
		assetService.save(asset);
		return asset;
	}
	
	//Deleting all the data
	@DeleteMapping("/asset")
	private String delete() {
		assetService.deleteAll();
		return "All the data deleted";
	}
	
	//Getting all the data from Asset
	//@PreAuthorize("hasRole('EMPLOYEE')")
	@GetMapping("/asset")
	private List<Asset> allData(){
		List<Asset> data = (List<Asset>) assetService.findAll();
		return data;
	}
	
	//Updating asset data
	@PutMapping("/asset")
	private Asset update(@RequestBody Asset asset) {
		assetService.update(asset);
		return asset;
	}
    
	//Total number of data present
	@GetMapping("asset/count")
	private long count() {
		return assetService.count();
	}
	
	//Delete by id
	@DeleteMapping("asset/{id}")
	private String deleteById(@PathVariable String id) {
		assetService.deleteById(id);
		return "id: "+id+" deleted";
	}
	
	//Finding by id
	@GetMapping("asset/{id}")
	private Optional<Asset> byId(@PathVariable String id){
		Optional<Asset> byId = assetService.findById(id);
		return byId;
	}
	
	@GetMapping("/asset1/{name}")
	private List<Asset> byName(@PathVariable String name){
		List<Asset> byName = assetService.findByName(name);
		return byName;
	}
}
