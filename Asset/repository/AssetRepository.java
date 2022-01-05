package com.spring.Asset.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import com.spring.Asset.model.Asset;

public interface AssetRepository extends CassandraRepository<Asset,String>{

	@AllowFiltering
	List<Asset> findByName(String name);
 
	 
}
