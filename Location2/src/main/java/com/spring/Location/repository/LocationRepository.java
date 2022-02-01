package com.spring.Location.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.spring.Location.model.Location;



public interface LocationRepository  extends CassandraRepository<Location,String> {

}
