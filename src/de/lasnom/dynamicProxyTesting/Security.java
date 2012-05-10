package de.lasnom.dynamicProxyTesting;

public class Security implements Module, ISecurity {
	private String moduleName = "Security";
	private IDbModule db;
	
	public Security(){
		ReferenceHolder.core.registerModule(this);
		db = (IDbModule)ReferenceHolder.core.getModule("simpleDbModule", IDbModule.class);
	}
	
	public Security(boolean withoutRegister){
		
	}

	public boolean verifyLogin(String userName, String password){
		if (db.getUser(userName).equals(password)) return true;
		
		return false;
	}
	

	public boolean verifyRequest(){
		return true;
	}

	

	public String getModuleName() {
		return moduleName;
	}

}
