package com.example.LocationService.model;







import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;




public class GeoShape {
	
	public String type;
	//@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	public JsonNode coordinates;
	public GeoShape() {
		
	}
	public GeoShape(String type, JsonNode coordinates) {
		super();
		this.type = type;
		this.coordinates = coordinates;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public JsonNode getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(JsonNode coordinates) {
		this.coordinates = coordinates;
	}
	
	
	
}
