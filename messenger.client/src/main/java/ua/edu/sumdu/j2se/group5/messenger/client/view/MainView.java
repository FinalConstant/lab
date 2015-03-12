package ua.edu.sumdu.j2se.group5.messenger.client.view;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import ua.edu.sumdu.j2se.group5.messenger.client.SendMessageEvent;
import ua.edu.sumdu.j2se.group5.messenger.client.SendMessageListener;
import ua.edu.sumdu.j2se.group5.messenger.client.model.ChatClient;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextArea;
/**
 * This class provides an user interface for chatting.
 * In particular: to send messages, 
 * to read messages from other users,
 * to see list of users connected to server.
 * 
 */
public class MainView extends JFrame implements Observer {
	
	private JList<String> usersList;
	private SendMessageListener messageListener;
	private JTextField textField;
	private JTextArea textArea;
	
	public MainView(ChatClient chat, SendMessageListener messageListener) {
		super();
		setResizable(false);
		this.messageListener = messageListener;
		
		setPreferredSize(new Dimension(480,240));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(0, 184, 234, 27);
		getContentPane().add(textField);
		
		JButton sendButton = new JButton("Send");
		sendButton.setBounds(233, 184, 96, 27);
		sendButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainView.this.messageListener.sendMessage(
						new SendMessageEvent(MainView.this,textField.getText()));
				textField.setText("");
			}
		});
		getContentPane().add(sendButton);
		
		String[] nicknames = new String[chat.getNickList().size()];
		usersList = new JList<String>(
				new DefaultComboBoxModel<String>(chat.getNickList().toArray(nicknames)));
		usersList.setBounds(330, 0, 144, 211);
		getContentPane().add(usersList);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setText(chat.getMessages());
		JScrollPane jp = new JScrollPane(textArea);
		jp.setBounds(0, 1, 329, 184);
		getContentPane().add(jp);
		
		pack();
		setVisible(true);
	}
	
	public void update(Observable o, Object arg) {
		ChatClient chat = (ChatClient)o;
		usersList.setModel(
				new DefaultComboBoxModel<String>(chat.getNickList().toArray(
						new String[chat.getNickList().size()])));
		textArea.setText(chat.getMessages());
		
	}
	
}
