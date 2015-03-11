package ua.edu.sumdu.j2se.group5.messenger.client.controller;

import javax.swing.JOptionPane;

import ua.edu.sumdu.j2se.group5.messenger.client.SendMessageEvent;
import ua.edu.sumdu.j2se.group5.messenger.client.SendMessageListener;
import ua.edu.sumdu.j2se.group5.messenger.client.SetNickEvent;
import ua.edu.sumdu.j2se.group5.messenger.client.SetNicknameListener;
import ua.edu.sumdu.j2se.group5.messenger.client.model.ChatClient;
import ua.edu.sumdu.j2se.group5.messenger.client.view.MainView;
import ua.edu.sumdu.j2se.group5.messenger.client.view.StartView;

public class Controller implements SendMessageListener, SetNicknameListener {

	public static void main(String[] args) {
		new StartView(new Controller());
		new MainView(new ChatClient() ,new Controller());
	}

	public void setNick(SetNickEvent e) {
		JOptionPane.showMessageDialog(null, e.getNick());
	}

	public void sendMessage(SendMessageEvent e) {
		JOptionPane.showMessageDialog(null, e.getMessage());
	}

}
