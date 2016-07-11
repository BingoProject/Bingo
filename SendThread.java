package test2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;

public class SendThread extends Thread {
	
	Socket socket;	
	OutputStream os;
	PrintWriter pw;
	String send;
	//boolean turn;
	
	
	public SendThread(Socket socket, String send) {
		this.socket = socket;
		this.send = send;
		//this.turn = turn;
		
		try{
			os = socket.getOutputStream();
		}catch(IOException ee) {
			ee.printStackTrace();
		}
		pw = new PrintWriter(os);		
	}

	public void run() {
		pw.println(send);
		pw.flush();		
	}
}
