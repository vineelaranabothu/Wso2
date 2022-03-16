package com.example.LocationPostman.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.example.LocationPostman.model.LocationService;



public interface CassandraLocationRepository extends CassandraRepository<LocationService, String> {

}
