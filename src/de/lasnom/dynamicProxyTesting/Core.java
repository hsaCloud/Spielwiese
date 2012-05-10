package de.lasnom.dynamicProxyTesting;

import java.lang.reflect.Proxy;
import java.util.HashMap;

public class Core {

	private HashMap<String, Module> modules = new HashMap<String, Module>();
	private ISecurity sec = null;
	
	public void registerModule(Module module){
		modules.put(module.getModuleName(), module);
		
	}
	
	public Module getModule(String moduleName, Class moduleInterface){
		if (sec == null) sec = new Security(true);
//		 Foo foo = (Foo) DebugProxy.newInstance(new FooImpl());
		
		Module m = modules.get(moduleName);
		m.getClass();
		m = (Module) Proxy.newProxyInstance(Module.class.getClassLoader(), new Class[]{Module.class, moduleInterface}, new ModuleProxy<Module>(m, sec));
		
		return m;
		
	}
	
}
