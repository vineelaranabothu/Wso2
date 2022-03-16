package com.example.demo.model;

import java.sql.Timestamp;

import org.elasticsearch.common.geo.GeoPoint;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.stereotype.Component;

@Component
@Document(indexName="innominds",type="_doc")
public class Asset {
	@Id
	public String  id;
	public String  objectType;
	public String  tenent_id;
	public String  name;
	public String  status;
	public String  external_id;
	public Boolean parent;
	public Boolean del;
	public String  image_url;
	public String tenent_name;
	public String position1;
	public GeoPoint position;
	public Timestamp createdAt;
	public Asset() {
		
	}
	public Asset(String id, String objectType, String tenent_id, String name, String status, String external_id,
			Boolean parent, Boolean del, String image_url, String tenent_name, String position1, GeoPoint position,
			Timestamp createdAt) {
		super();
		this.id = id;
		this.objectType = objectType;
		this.tenent_id = tenent_id;
		this.name = name;
		this.status = status;
		this.external_id = external_id;
		this.parent = parent;
		this.del = del;
		this.image_url = image_url;
		this.tenent_name = tenent_name;
		this.position1 = position1;
		this.position = position;
		this.createdAt = createdAt;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getObjectType() {
		return objectType;
	}
	public void setObjectType(String objectType) {
		this.objectType = objectType;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getExternal_id() {
		return external_id;
	}
	public void setExternal_id(String external_id) {
		this.external_id = external_id;
	}
	public Boolean getParent() {
		return parent;
	}
	public void setParent(Boolean parent) {
		this.parent = parent;
	}
	public Boolean getDel() {
		return del;
	}
	public void setDel(Boolean del) {
		this.del = del;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public String getTenent_name() {
		return tenent_name;
	}
	public void setTenent_name(String tenent_name) {
		this.tenent_name = tenent_name;
	}
	public String getPosition1() {
		return position1;
	}
	public void setPosition1(String position1) {
		this.position1 = position1;
	}
	public GeoPoint getPosition() {
		return position;
	}
	public void setPosition(GeoPoint position) {
		this.position = position;
	}
	public Timestamp getCreatedat() {
		return createdAt;
	}
	public void setCreatedat(Timestamp createdat) {
		this.createdAt = createdat;
	}
	         
}
