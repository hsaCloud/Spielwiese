package de.lasnom.akka.akkaTesting;

import akka.actor.UntypedActor;

public class CallbackActor extends UntypedActor {

	@Override
	public void onReceive(Object msg) throws Exception {
		
		if (msg instanceof CallbackMessage){
			CallbackMessage cbm = (CallbackMessage)msg;
			cbm.callbackObject.receiveCallback(cbm.msg);
		} else unhandled(msg);
		
		
	}

}
