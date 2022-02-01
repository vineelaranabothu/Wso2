package com.spring.cassandra.AssetSaml2.service;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.spring.cassandra.AssetSaml2.model.Asset;
import com.spring.cassandra.AssetSaml2.repository.CassandraAssetRepository;


@Service

public class CassandraAssetService {
	@Autowired
	public CassandraAssetRepository assetRepository;
	
	//Getting all Asset data (Get)	
	
	
	public List<Asset> findAll() {
		
		return (List<Asset>) assetRepository.findAll();
	}
	
	//Saving data into the asset (Post)

	
	public void save(Asset asset) {
		LocalDate date = LocalDate.now();
		asset.setCreatedAt(date);
		assetRepository.save(asset);
		
	}
    //Deleting all the data in the asset (Delete)
	 
	public void deleteAll() {
		
		assetRepository.deleteAll();
		
	}
    //Count of the data present in the Asset (Get)
	
	public long count() {
		
		return assetRepository.count();
	}
    
    //Deleting data by the given id (Delete)
	
	public void deleteById(String id) {
	    assetRepository.deleteById(id);
		
	}
    
    //Finding data by id (get)
	
	public Optional<Asset> findById(String id) {
		
		return assetRepository.findById(id);
	}
	
    //Updating the present in the Asset (put)
	
	public void update(Asset asset) {
    	LocalDate date = LocalDate.now();
		asset.setCreatedAt(date);
	    assetRepository.save(asset);
		
	}
	
	//Get data by name
	
	public List<Asset> findByName(String name) {
		List<Asset> byName = assetRepository.findByName(name);
		return byName;
		
	}
}


