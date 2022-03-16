package com.example.demo.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AssetService;



@Repository
public interface CassandraAssetRepository extends CassandraRepository<AssetService,String>{

	@AllowFiltering
	List<AssetService> findByName(String name);

	
 
	 
}

