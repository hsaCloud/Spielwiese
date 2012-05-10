package de.lasnom.dynamicProxyTesting;

import java.util.HashMap;

public class DbModule implements Module, IDbModule {

	private HashMap<String, String> users = new HashMap<String, String>();
	private String name = "simpleDbModule";
	
	public DbModule(){
		ReferenceHolder.core.registerModule(this);
		users.put("abc", "muh");
	}
	
	public String getModuleName() {
		return name;
	}
	
	public String[] getUser(String user){
		String[] usr = new String[2];
		usr[0] = user;
		usr[1] = users.get(user);
		
		return usr;
	}

}
