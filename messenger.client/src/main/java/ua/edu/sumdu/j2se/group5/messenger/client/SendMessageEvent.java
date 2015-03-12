package ua.edu.sumdu.j2se.group5.messenger.client;

import java.util.EventObject;
/**
 * This class describes event that may occur 
 * when user is trying to send message.
 *
 */
public class SendMessageEvent extends EventObject {
	public SendMessageEvent(Object source, String message) {
		super(source);
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	private String message;
}
