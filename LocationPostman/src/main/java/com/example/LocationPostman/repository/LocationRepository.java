package com.example.LocationPostman.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.LocationPostman.model.Location;

public interface LocationRepository extends ElasticsearchRepository<Location, String>{

	List<Location> findByObjectType(String objectType);

}
