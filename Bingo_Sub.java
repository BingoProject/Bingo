package test2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;

public class Bingo_Sub {
	Socket socket;
	JFrame frame;
	JRootPane jrp;
	Container con;
	JPanel p;
	JButton bt[][];
	JLabel lb;
	int random_value[];
	ActionEvents ae;
	boolean bool[][];
	SendThread st;
	ReceiveThread rt;
	String send;
	int count;
	BingoCount bc;
	int turn;

	public Bingo_Sub() {
		frame = new JFrame("빙고 클라이언트");
		jrp = frame.getRootPane();
		con = jrp.getContentPane();
		p = new JPanel(new GridLayout(5,5,5,5));
		bt = new JButton[5][5];
		lb = new JLabel("빙고 게임을 시작 합니다.", JLabel.CENTER);
		random_value = new int[50];
		ae = new ActionEvents();
		bool = new boolean[5][5];
		send = "";
		count = 0;
		turn = 0;
	}

	public void init() {		
		
		con.setLayout(new BorderLayout());
		con.add("North", lb);
		for(int i = 0; i < 50; i++) {
			random_value[i] = (int)(Math.random() * 50) + 1;
			for(int j = 0; j < i;  j++) {
				if(random_value[i] == random_value[j]) {
					i--;
					break;
				}
			}
		}
		int count = 0;		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j <5; j++) {
				bt[i][j] = new JButton(String.valueOf(random_value[count]));
				bool[i][j] = false;
				count++;
			}		
		}

		for(int i = 0; i < 5; i++) {
			for(int j = 0; j <5; j++) {
				p.add(bt[i][j]);
			}
		}

		con.add("Center", p);

		frame.setSize(300,350);
		frame.setLocation(700, 300);
		frame.setVisible(true);

		myEvents();

		try{
			socket = new Socket("localhost", 7606);
		}catch(UnknownHostException ee) {
			ee.printStackTrace();
		}catch(IOException ee) {
			System.out.println("서버 프로그램을 먼저 실행시켜 주세요!!");
			System.exit(0);
		}
		rt = new ReceiveThread(socket, bt, bool, count, lb, turn);
		rt.start();
	}

	public void myEvents() {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j <5; j++) {
				bt[i][j].addActionListener(ae);				
			}		
		}
	}

	public class ActionEvents implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			for(int i = 0; i < 5; i++) {
				for(int j = 0; j <5; j++) {
					if(e.getSource() == bt[i][j]) {	
						if(turn == 0) {
							send =  bt[i][j].getText();
							st = new SendThread(socket, send);
							st.start();
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
	
	
	public static void main(String[] args) {
		Bingo_Sub bs = new Bingo_Sub();
		bs.init();
	}
}
