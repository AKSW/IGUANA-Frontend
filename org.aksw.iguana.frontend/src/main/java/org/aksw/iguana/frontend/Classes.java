package org.aksw.iguana.frontend;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;




@ManagedBean(name="classes")
@ApplicationScoped
public class Classes {

	public List<String> getLogClasses() {
		return logClasses;
	}

	public void setLogClasses(List<String> logClasses) {
		this.logClasses = logClasses;
	}

	private List<String> logClasses = new LinkedList<String>();
	
	@PostConstruct
	public void init(){
		//logClasses

		Reflections ref = new Reflections(new ConfigurationBuilder().setUrls(ClasspathHelper.forPackage("")));
		 Set<Class<? extends Exception>> allClasses = 
			     ref.getSubTypesOf(Exception.class);
		 System.out.println(allClasses);
		 for(Class<? extends Exception> c : allClasses){
			 logClasses.add(c.getCanonicalName());
		 }
		 
	}
}
