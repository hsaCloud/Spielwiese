package de.hsa.cloud.cms.core.module.loader;

import java.util.HashMap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ModuleConfig {
	String name;
	String group;
	String discription;
	String path;
	boolean available;

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getGroup(){
		return this.group;
	}
	
	@XmlElement
	public void setGroup(String group){
		this.group = group;
	}
	
	public String getDiscription() {
		return discription;
	}

	@XmlElement
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	
	public String getPath() {
		return path;
	}

	@XmlElement
	public void setPath(String path) {
		this.path = path;
	}
	
	public boolean isAvailable() {
		return available;
	}

	@XmlElement
	public void setAvailable(boolean available) {
		this.available = available;
	}
}
