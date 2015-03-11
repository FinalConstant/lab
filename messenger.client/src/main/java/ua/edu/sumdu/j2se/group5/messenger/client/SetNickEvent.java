package ua.edu.sumdu.j2se.group5.messenger.client;

import java.util.EventObject;

public class SetNickEvent extends EventObject {
	private String nick;
	public SetNickEvent(Object source, String nick) {
		super(source);
		this.nick = nick;
	}
	
	public String getNick() {
		return nick;
	}
}
