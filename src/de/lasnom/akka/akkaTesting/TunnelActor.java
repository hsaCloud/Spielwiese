package de.lasnom.akka.akkaTesting;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;

public class TunnelActor extends UntypedActor { //oder auch msg Router.

	@Override
	public void onReceive(Object msg) throws Exception {
		
		if(msg instanceof MessageObject){
			
			String msgTo = ((MessageObject) msg).messageTo;
			String message = ((MessageObject) msg).message;
			System.out.println("tunnel got msg. >MsgTo: " + msgTo + " >message:" + message);
			
			if (msgTo.equalsIgnoreCase("EndpointMsg")){
				ActorRef ar = context().actorFor("akka://CoreSystem/user/EndpointMsgReceiver");
				ar.tell(msg, getSender()); //der nachrichten sender wird übergeben, damit rückgabe an sender und nicht an den tunnel weitergeleitet wird	
			} else unhandled(msg);
		}
		
		else unhandled(msg);
		
	}

}
