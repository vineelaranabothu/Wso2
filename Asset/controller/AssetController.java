package com.spring.Asset.controller;

import java.sql.Date;
import java.time.LocalDate;
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

import com.spring.Asset.model.Asset;
import com.spring.Asset.repository.AssetRepository;

@RestController
@RequestMapping("/api")
public class AssetController {
	
	@Autowired
	private AssetRepository assetRepository;
	
	//Entering values into asset table
	@PostMapping("/asset")
	@PreAuthorize("hasRole('user')")
    private Asset creat(@RequestBody Asset asset){
		LocalDate date = LocalDate.now();
		asset.setCreatedAt(date);
		assetRepository.save(asset);
		return asset;
	}
	
	//Deleting all the data
	@DeleteMapping("/asset")
	private String delete() {
		assetRepository.deleteAll();
		return "All the data deleted";
	}
	
	//Getting all the data from Asset
	@PreAuthorize("hasRole('user2')")
	@GetMapping("/asset")
	private List<Asset> allData(){
		List<Asset> data = assetRepository.findAll();
		return data;
	}
	
	//Updating asset data
	@PutMapping("/asset")
	private Asset update(@RequestBody Asset asset) {
		assetRepository.save(asset);
		return asset;
	}
    
	//Total number of data present
	@GetMapping("/count")
	private long count() {
		return assetRepository.count();
	}
	
	//Delete by id
	@DeleteMapping("delete/{id}")
	private String deleteById(@PathVariable String id) {
		assetRepository.deleteById(id);
		return "id: "+id+" deleted";
	}
	
	//Finding by id
	@GetMapping("/byid/{id}")
	private Optional<Asset> byId(@PathVariable String id){
		Optional<Asset> byId = assetRepository.findById(id);
		return byId;
	}
	
	//Finding by name
	@GetMapping("/byName/{name}")
	private List<Asset> byName(@PathVariable String name){
		List<Asset> byName = assetRepository.findByName(name);
		return byName;
	}
}
