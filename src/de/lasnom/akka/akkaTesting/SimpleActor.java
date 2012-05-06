package de.lasnom.akka.akkaTesting;

import akka.actor.UntypedActor;

public class SimpleActor extends UntypedActor {

	@Override
	public void onReceive(Object msg) throws Exception {
		if (msg instanceof String) {
			
			System.out.println(getSelf() +  " got msg: " + msg);
			getSender().tell("Got: " + msg, getSelf());
		}
		
		
		else {
			System.out.println("msg ist kein string.");
			unhandled(msg);
		}
		
		
	}

}
