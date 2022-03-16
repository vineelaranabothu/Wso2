package com.example.demo.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Asset;


@Repository
public interface AssetRepository extends ElasticsearchRepository<Asset,String>{

	List<Asset> findByObjectType(String objectType);

	
	
 
	 
}

