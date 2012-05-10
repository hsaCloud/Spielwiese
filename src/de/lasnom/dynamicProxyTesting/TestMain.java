package de.lasnom.dynamicProxyTesting;


public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ReferenceHolder.core = new Core();
		new DbModule();
		new Security();
		new MuhModule();
		
		ISecurity sec = (ISecurity) ReferenceHolder.core.getModule("Security", ISecurity.class);
		sec.verifyLogin("abc", "muh");
		
		IMuhModule iMuh = (IMuhModule) ReferenceHolder.core.getModule("muhModule", IMuhModule.class);
		System.out.println(">>IMuhMod says: " + iMuh.giveMeAMuh("horscht"));
		
	}

}
