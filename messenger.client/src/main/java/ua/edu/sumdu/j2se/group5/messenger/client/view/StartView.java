package ua.edu.sumdu.j2se.group5.messenger.client.view;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import ua.edu.sumdu.j2se.group5.messenger.client.SetNickEvent;
import ua.edu.sumdu.j2se.group5.messenger.client.SetNicknameListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
/**
 * This view provides an user interface for setting
 * nick name.
 * 
 */
public class StartView extends JFrame {
	/**
	 * Only constructor.
	 * 
	 * @param nickSetter  Instance if SetNicknameListener interface that may
	 *  				  process a SetNickEvent when it occurs.
	 */
	public StartView(SetNicknameListener nickSetter) {
		super();
		this.nickSetter = nickSetter;
		
		this.setPreferredSize(new Dimension(240,120));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(74, 23, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(74, 47, 86, 23);
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StartView.this.nickSetter.setNick(new SetNickEvent(StartView.this,textField.getText()));
			}
		});
		getContentPane().add(btnSubmit);
		
		JLabel lblNick = new JLabel("Nick:");
		lblNick.setBounds(10, 26, 57, 14);
		getContentPane().add(lblNick);
		
		this.pack();
		this.setVisible(true);
	}
	
	private SetNicknameListener nickSetter;
	private JTextField textField;
}
