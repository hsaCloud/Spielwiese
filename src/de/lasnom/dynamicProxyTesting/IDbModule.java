package de.lasnom.dynamicProxyTesting;

public interface IDbModule extends Module {

	public String getModuleName();
	public String[] getUser(String user);
	
}
