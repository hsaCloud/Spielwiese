package de.lasnom.dynamicProxyTesting;

public class MuhModule implements IMuhModule, Module {

	public String giveMeAMuh(String myName){
		return "muuuuuh " + myName;
	}
	
	public MuhModule(){
		ReferenceHolder.core.registerModule(this);
	}

	public String getModuleName() {
		return "muhModule";
	}
	
}
