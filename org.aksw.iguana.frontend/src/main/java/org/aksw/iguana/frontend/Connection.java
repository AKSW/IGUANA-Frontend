package org.aksw.iguana.frontend;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="connection")
@RequestScoped
public class Connection implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1093403218519831244L;

	private String endpoint="http://example.com";
	private String updateEndpoint="";
	private String user="";
	private String password="";
	private String id="Connection ID";
	
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public String getUpdateEndpoint() {
		return updateEndpoint;
	}
	public void setUpdateEndpoint(String updateEndpoint) {
		this.updateEndpoint = updateEndpoint;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public void set(Connection con){
		if(con==null){
			return;
		}
		this.id=con.id;
		user=con.user;
		password=con.password;
		endpoint=con.endpoint;
		updateEndpoint=con.updateEndpoint;
	}
	
	
	@Override
	public boolean equals(Object obj){
		if(obj==null){
			return false;
		}
		if(this.toString().equals(obj.toString())){
			return true;
		}
		return false;
	}
	
	@Override
	public String toString(){
		return this.id;
	}
	
}
