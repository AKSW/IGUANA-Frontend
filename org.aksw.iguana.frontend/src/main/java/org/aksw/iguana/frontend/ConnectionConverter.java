package org.aksw.iguana.frontend;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("connectionConverter")
public class ConnectionConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent arg1, String arg2) {
			for(Connection con : ((Config)context.getExternalContext().getSessionMap().get("config")).getConnections()){
				if(con.getId().equals(arg2)){
					return con;
				}
			}
			return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return arg2.toString();
	}

}
