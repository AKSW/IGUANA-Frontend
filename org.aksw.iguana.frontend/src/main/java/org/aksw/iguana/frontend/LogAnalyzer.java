package org.aksw.iguana.frontend;

import java.util.Properties;

import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="logAnalyzer")
@RequestScoped
public class LogAnalyzer {

	private String className="";
	
	Properties p = new Properties();

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	public void addProperties(String name, String value){
		p.put(name, value);
	}
	
	
}
