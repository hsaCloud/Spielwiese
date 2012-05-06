package de.lasnom.akka.akkaTesting;

import akka.actor.UntypedActor;

public class EndpointMsgReceiver extends UntypedActor {

	@Override
	public void onReceive(Object msg) throws Exception {
		if (msg instanceof MessageObject){
			MessageObject mso = (MessageObject)msg;
			getSender().tell( "MsgReceiver got: " + ((MessageObject) msg).message + " MessageTo:" + mso.messageTo);
		}
		
		
	}

}
