package de.hsa.cloud.cms.core.module.loader;

import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;

public class ModuleManager {
	final private static String PATH_TO_MODULES = "WEB-INF/modules/";
	
	
	public ModuleManager(){
		
		File[] modules = new File(PATH_TO_MODULES).listFiles(new FileFilter(){

			@Override
			public boolean accept(File file) {
				return (file.isDirectory() && new File(file.getAbsolutePath() + "/WEB-INF/config.xml").exists());
			}
			
		});
		
		
		for(File f: modules){
			System.out.println(f.getName());
		}
	}
	
	public static void main(String[] args){
		ModuleManager mm = new ModuleManager();
	}
}