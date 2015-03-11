package ua.edu.sumdu.j2se.group5.messenger.client.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

public class ChatClient extends Observable {
	
	private Connection con = null;
	private Thread connectionThread = null;
	private String serverHost = "localhost";
	private int serverPort = 4444;
	private StringBuffer messages;
	private List<String> nickList;
	
	public List<String> getNickList() {
		//return nickList;
		List<String> listik = new LinkedList<String>();
		listik.add("afdsbads");
		listik.add("two");
		return listik;
	}
	
	public String getMessages() {
		//return messages.toString();
		return "akldejgnb;"
				+"This example provides a scrolling capacity for the text area with \n"
				+ "the default scroll bar policy. By default, the vertical scroll bar only appears when the display\n"
				+ " area is entirely filled with text and there is no room to append new words. You can provide a scroll pane of this type with the following code:\n"
+"textArea.setWrapStyleWord(true);\n"
					  +"jScrollPane1 = new JScrollPane(textArea);\n"
					+"As mentioned above, the text area is editable.\n"
					+ " You can play with the text area by typing and pasting text,\n"
					+ " or by deleting some parts of text or the entire content. \n"
					+ "Also try using standard key bindings for editing text within the text area.\n"
+"Now explore how the word completion function is implemented.\n"
+ " Type in a word like \"Swing\" or \"special\". \n"
+ "As soon as you have typed \"sw\" the program shows a\n"
+ " possible completion \"ing\" highlighted in light-blue. Press Enter to accept the completion or continue typing.\n"
				+	"The following code adds a document listener to the text area's document:\n"
					 + "--> textArea.getDocument().addDocumentListener(this);"
					+"When you started typing a word, the insertUpdate method checks whether\n"
					+ " the program's vocabulary contains the typed prefix.\n"
					+ " Once a completion for the prefix is found, a call to the invokeLater method submits a task for changing the document later.\n"
					+ " It is important to remember that you cannot modify the document from within the document event notification,\n"
					+ " otherwise you will get an exception. Examine the following code below.";
	}
	
	public void setNickName(String nick) throws IOException {
		//connectionThread.interrupt();
		//if(con!=null)
			//con.close();
		con = new Connection(serverHost,serverPort);
		connectionThread = new Thread() {
			@Override
			public void run() {
				BufferedReader r = con.getReader();
				BufferedWriter w = con.getWriter();
				while(true) {
					try {
						if(r.readLine() != null) {
							
						}
					} catch(IOException e) {
						//LOG.warn(e);
						e.printStackTrace();
					}
					try {
						sleep(23);
					} catch (InterruptedException e) {
						//LOG.trace(e);
						e.printStackTrace();
					}
				}
			}
		};
	}
	
	public void sendMessage() {
		
	}
	
	public void close() throws IOException {
		connectionThread.interrupt();
		connectionThread = null;
		con.close();
		con = null;
	}
}
