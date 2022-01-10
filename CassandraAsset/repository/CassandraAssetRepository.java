package com.example.CassandraAsset.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.example.CassandraAsset.model.Asset;


@Repository
public interface CassandraAssetRepository extends CassandraRepository<Asset,String>{

	@AllowFiltering
	List<Asset> findByName(String name);

	
 
	 
}

