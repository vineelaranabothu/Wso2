package com.example.LocationPostman.model;

import java.sql.Timestamp;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("LocationService")
public class LocationService {
    
	@PrimaryKey
	public String id;
	public String tenent_id;
	public String name;
	public String type;
	public String description;
	public String created_by;
	public Timestamp created_time;
	public Boolean deleted;
	public String modified_by;
	public Timestamp modified_time;
	public String address;
	public String properties;
	public Integer sort_order;
	public String geo_json;
	public String geo_shape;
	public String external_id;
	public LocationService() {
		 
	}
	public LocationService(String id, String tenent_id, String name, String type, String description, String created_by,
			Timestamp created_time, Boolean deleted, String modified_by, Timestamp modified_time, String address,
			String properties, Integer sort_order, String geo_json, String geo_shape, String external_id) {
		super();
		this.id = id;
		this.tenent_id = tenent_id;
		this.name = name;
		this.type = type;
		this.description = description;
		this.created_by = created_by;
		this.created_time = created_time;
		this.deleted = deleted;
		this.modified_by = modified_by;
		this.modified_time = modified_time;
		this.address = address;
		this.properties = properties;
		this.sort_order = sort_order;
		this.geo_json = geo_json;
		this.geo_shape = geo_shape;
		this.external_id = external_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTenent_id() {
		return tenent_id;
	}
	public void setTenent_id(String tenent_id) {
		this.tenent_id = tenent_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public Timestamp getCreated_time() {
		return created_time;
	}
	public void setCreated_time(Timestamp created_time) {
		this.created_time = created_time;
	}
	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	public String getModified_by() {
		return modified_by;
	}
	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}
	public Timestamp getModified_time() {
		return modified_time;
	}
	public void setModified_time(Timestamp modified_time) {
		this.modified_time = modified_time;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProperties() {
		return properties;
	}
	public void setProperties(String properties) {
		this.properties = properties;
	}
	public Integer getSort_order() {
		return sort_order;
	}
	public void setSort_order(Integer sort_order) {
		this.sort_order = sort_order;
	}
	public String getGeo_json() {
		return geo_json;
	}
	public void setGeo_json(String geo_json) {
		this.geo_json = geo_json;
	}
	public String getGeo_shape() {
		return geo_shape;
	}
	public void setGeo_shape(String geo_shape) {
		this.geo_shape = geo_shape;
	}
	public String getExternal_id() {
		return external_id;
	}
	public void setExternal_id(String external_id) {
		this.external_id = external_id;
	}
	
	
	
	
	
	
	
   
   
   
  
    
  
    
   
   
}
