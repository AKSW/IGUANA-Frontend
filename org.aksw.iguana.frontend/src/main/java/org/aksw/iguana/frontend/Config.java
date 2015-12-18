package org.aksw.iguana.frontend;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.FlowEvent;

@ManagedBean(name = "config")
@SessionScoped
public class Config implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3174838612189572332L;

	private String id="";

	private List<Connection> connections = new LinkedList<Connection>();

	private Connection selectedConnection=null;
	
	public void addConnection(Connection con) {
		if(connections.contains(con)){
			connections.remove(con);
			connections.add(con);
			return;
		}
		connections.add(con);
		System.out.println("con: "+connections.get(connections.size()-1).getId());
		System.out.println("size: "+connections.size());
	}

	public String onFlowProcess(FlowEvent event) {
		return event.getNewStep();

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Connection> getConnections() {
		System.out.println(connections);
		return connections;
	}

	public void setConnections(List<Connection> connections) {
		this.connections = connections;
	}

	public Connection getSelectedConnection() {
		return selectedConnection;
	}

	public void setSelectedConnection(Connection selectedConnection) {
		this.selectedConnection = selectedConnection;
	}

}
