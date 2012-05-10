package de.lasnom.dynamicProxyTesting;

public interface ISecurity extends Module {

	public abstract boolean verifyLogin(String userName, String password);

	public abstract boolean verifyRequest();

	public abstract String getModuleName();
	
	

}