package ua.edu.sumdu.j2se.group5.messenger.client.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Connection {
	private Socket socket;
	private BufferedReader reader = null;
	private BufferedWriter writer = null;
	
	public BufferedReader getReader() {
		return reader;
	}

	public BufferedWriter getWriter() {
		return writer;
	}
	
	public Connection(String server, int port) throws IOException {
		socket = new Socket(server,port);
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			//LOG.warn(e);
			e.printStackTrace();
			throw e;
		} 
		try {
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			//LOG.warn(e);
			e.printStackTrace();
			throw e;
		} 
	}
	
	public void close() throws IOException {
		if(socket!=null)
		socket.close();
		if(reader!=null)
		reader.close();
			
	}

}
