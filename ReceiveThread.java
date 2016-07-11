package test2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;

public class ReceiveThread extends Thread {
	
	Socket socket;	
	boolean[][] bool;
	JButton bt[][];
	InputStream is;
	InputStreamReader isr;
	BufferedReader br;
	String receive;
	String[][] bt_txt;
	int count;
	BingoCount bc;
	JLabel lb;
	int turn;
	

	public ReceiveThread(Socket socket, JButton[][] bt, boolean[][] bool, int count, JLabel lb, int turn) {
		this.socket = socket;
		this.bool = bool;
		this.bt = bt;
		this.count = count;
		this.lb = lb;
		this.turn = turn;
		
		try{
			is = socket.getInputStream();
		}catch(IOException ee) {
			ee.printStackTrace();
		}
		isr = new InputStreamReader(is);
		br = new BufferedReader(isr);
		receive = "";
		bt_txt = new String[5][5];
	}

	public void run() {
		
		while(true) {
			
			try{
				receive = br.readLine();
			}catch(IOException ee) {
				ee.printStackTrace();
			}		
			
			for(int i = 0; i < 5; i++) {
				
				for(int j = 0; j <5; j++) {
					bt_txt[i][j] = bt[i][j].getText(); 
					
					if(receive.equals(bt_txt[i][j])) {
						turn = 0;
						System.out.println(turn);
						bt[i][j].setEnabled(false);
						bool[i][j] = true;
						bc = new BingoCount(bool, count, lb);
						bc.start();						
					}
				}		
			}
		}		
	}
}
