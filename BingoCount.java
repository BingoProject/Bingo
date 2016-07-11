package test2;
import javax.swing.*;

public class BingoCount extends Thread {
	boolean[][] bool;
	int count;
	JLabel lb;

	public BingoCount(boolean[][] bool, int count, JLabel lb) {
		this.bool = bool;
		this.count = count;
		this.lb = lb;
	}
	
	public void run() {
		count = 0;
		for(int i = 0; i < 5; i++) {
			if(bool[i][0] && bool[i][1] && bool[i][2] && bool[i][3] && bool[i][4]) {
				count++;
			}

			if(bool[0][i] && bool[1][i] && bool[2][i] && bool[3][i] && bool[4][i]) {
				count++;
			}
		}
		
		if(bool[0][0] && bool[1][1] && bool[2][2] && bool[3][3] && bool[4][4]) {
			count++;
		}

		if(bool[4][0] && bool[3][1] && bool[2][2] && bool[1][3] && bool[0][4]) {
			count++;
		}
		if(count < 5) {
			lb.setText("현재 " + count + "줄");
		}
		else {
			lb.setText("빙고");
		}

	}
}
