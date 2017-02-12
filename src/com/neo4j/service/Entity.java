

package com.neo4j.service;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "entity")
public class Entity implements Serializable{
	
	private String name;
	private String type;
	private String status;
	private String lastChanged;
	private int frequency;
	
	
	public Entity(String name, String type, String status, String lastChanged, int frequency) {
		super();
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
	
	public String gettype() {
		return type;
	}
	
	public void settype(String type) {
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
	
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	

}




