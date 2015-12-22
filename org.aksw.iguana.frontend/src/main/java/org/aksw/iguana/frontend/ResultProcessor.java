package org.aksw.iguana.frontend;

import java.io.File;
import java.io.FilenameFilter;
import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;


@ManagedBean(name="resultProcessor")
@ApplicationScoped
public class ResultProcessor {
	
	private boolean empty=true;
	private List<File> files = new LinkedList<File>();
	
	public void updateList(){
		File dir = new File(".");
		File[] files = dir.listFiles(new FilenameFilter(){

			@Override
			public boolean accept(File dir, String name) {
				if(name.matches("results_[0-9]+")){
					File res = new File(name);
					if(res.listFiles().length==0){
						return false;
					}
					return true;
				}
				return false;
			}		});
		for(File f: files){
			this.files.add(f);
		}
	}

	public boolean isEmpty() {
		updateList();
		if(files.isEmpty()){
			return true;
		}
		return false;
	}

	public void setEmpty(boolean empty) {
		//
	}

}
