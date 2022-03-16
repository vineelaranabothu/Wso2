package com.example.LocationService.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.example.LocationService.model.LocationService;

public interface CassandraLocationRepository extends CassandraRepository<LocationService, String> {

}
