package de.lasnom.akka.akkaTesting;

public class MessageObject {

	public String message;
	public String messageTo;
	
	public String session; //für später.. session oder ähnliches
	
	public MessageObject(String message, String messageTo){
		this.message = message;
		this.messageTo = messageTo;
	}
	
	
}
