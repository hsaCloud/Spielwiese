package de.lasnom.akka.akkaTesting;

public class CallbackReceiverTestClass implements CallbackObject {

	@Override
	public void receiveCallback(String msg) {
		System.out.println("received callback: " + msg);
		
	}

}
