package com.neo4j.service;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name = "Dependency")
public class Dependency {
	private String name;
	private String type;
	private String status;
	private String lastChanged;
	private String frequency;
	
	
	public Dependency(String name, String type, String status, String lastChanged, String frequency) {
		
		this.name = name;
		this.type = type;
		this.status = status;
		this.lastChanged = lastChanged;
		this.frequency = frequency;
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
		type = type;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getLastChanged() {
		return lastChanged;
	}
	public void setLastChanged(String lastChanged) {
		this.lastChanged = lastChanged;
	}
	
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	

	

}
