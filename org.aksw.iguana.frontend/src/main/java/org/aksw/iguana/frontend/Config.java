package org.aksw.iguana.frontend;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FlowEvent;

@ManagedBean(name = "config")
@SessionScoped
public class Config implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3174838612189572332L;

	private String validation="abc";

	
	private String id="";

	private List<Connection> connections = new LinkedList<Connection>();

	private Connection selectedConnection=null;


	
	private LogAnalyzer logAnalyzer;
	
	public void addConnection(Connection con) {
		if(connections.contains(con)){
			connections.remove(con);
			connections.add(con);
			return;
		}
		connections.add(con);
	}

	public String onFlowProcess(FlowEvent event) {

		if(event.getOldStep().equals("connections")){
			if(!valConns()){
				return event.getOldStep();
			}
		}

		return event.getNewStep();

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Connection> getConnections() {
		return connections;
	}

	public void setConnections(List<Connection> connections) {
		this.connections = connections;
	}

	public Connection getSelectedConnection() {
		connections.remove(selectedConnection);
		return selectedConnection;
	}

	public void setSelectedConnection(Connection selectedConnection) {
		this.selectedConnection = selectedConnection;
	}
	
	@Override
	public String toString(){
		return this.id;
	}

	public LogAnalyzer getLogAnalyzer() {
		return logAnalyzer;
	}

	public void setLogAnalyzer(LogAnalyzer logAnalyzer) {
		this.logAnalyzer = logAnalyzer;
	}

	public String getValidation() {
		return validation;
	}

	public void setValidation(String validation) {
		this.validation = validation;
	}

	public boolean valConns() {
		if (connections.isEmpty()) {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "You need to specify at least one Connection.", "You need to specify at least one Connection."));        
	        return false;
		}
		return true;	
	}
	
}
