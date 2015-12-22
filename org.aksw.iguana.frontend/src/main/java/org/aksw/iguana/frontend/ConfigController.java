package org.aksw.iguana.frontend;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;



@ManagedBean(name="configController")
@ApplicationScoped
public class ConfigController {
	
	private List<Config> configs = new LinkedList<Config>();

	private Config config;
	
	@PostConstruct
	private void load(){
		File dir = new File("configs");
		if(!dir.exists()){
			dir.mkdir();
			return;
		}
		for(File f : dir.listFiles()){
			//TODO load Config
			Config c = new Config();
			c.setId(f.getName().replace(".xml", ""));
			configs.add(c);
		}
	}

	public List<Config> getConfigs() {
		return configs;
	}

	public void setConfigs(List<Config> configs) {
		this.configs = configs;
	}

	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}
	
	

}
