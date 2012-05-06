package de.lasnom.akka.akkaTesting;

import akka.actor.*;
import akka.dispatch.Await;
import akka.dispatch.Future;
import akka.pattern.Patterns;
import akka.util.Duration;
import akka.util.Timeout;
import static java.util.concurrent.TimeUnit.SECONDS;

public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ActorSystem actorSystem = ActorSystem.create("CoreSystem"); //cure System wird initialisiert
		ReferenceHolder.actorSys = actorSystem;
		
//		firstTest(actorSystem);
//		callbackTest();
		routingTest();
		
		
		actorSystem.shutdown();
		
		
		
	}
	
	public static void firstTest(ActorSystem actorSystem){
		ReferenceHolder.actorSys = actorSystem; //ReferenceHolder wird die actorSystem referenz übergeben
		
		ActorRef simpleActorRef = actorSystem.actorOf(new Props(SimpleActor.class), "SimpleActor"); //actor Refferenz vom Actor System holen. Actor wird erstellt
		simpleActorRef.tell("oi"); //fire and forget
		
		ActorRef sActor = ReferenceHolder.actorSys.actorFor("akka://CoreSystem/user/SimpleActor"); //actor Ref über Referenz-Holder vom actorSys vom Existierendem Actor holen
		sActor.tell("muh"); //fire and forget
		
		Timeout timeout = new Timeout(Duration.parse("5 seconds")); //timeout für future erstellen
		Future<Object> future = Patterns.ask(simpleActorRef, "say something", timeout); //nachricht senden und future als rückgabe kriegen
		
		
		try {
			String result = (String) Await.result(future, timeout.duration());
			System.out.println("got result from future: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	public static void callbackTest(){
		ActorRef fActor = ReferenceHolder.actorSys.actorOf(new Props(CallbackActor.class), "CallbackActor"); //actor Ref über Referenz-Holder vom actorSys holen
		CallbackMessage cbm = new CallbackMessage();
		cbm.msg = "i'm a callback";
		cbm.callbackObject = new CallbackReceiverTestClass();
		fActor.tell(cbm);
		
		
	}
	

	public static void routingTest(){
		
		ActorRef simpleActorRef = ReferenceHolder.actorSys.actorOf(new Props(TunnelActor.class), "TunnelActor"); //actor Refferenz vom Actor System holen
		ReferenceHolder.actorSys.actorOf(new Props(EndpointMsgReceiver.class), "EndpointMsgReceiver");
		
		MessageObject mso = (new MessageObject("yeah", "EndpointMsg"));
		
		Timeout timeout = new Timeout(Duration.parse("5 seconds")); //timeout für future erstellen
		Future<Object> future = Patterns.ask(simpleActorRef, mso, timeout); //nachricht senden und future als rückgabe kriegen
		
		
		try {
			String result = (String) Await.result(future, timeout.duration());
			System.out.println("got result from future: \"" + result + "\"");
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
	
	
	
	
	
}








