package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MainFrame extends JFrame implements ActionListener{
	private JButton[] btnArr = new JButton[25];
	private JButton[] btnArr2 = new JButton[25];
	private JButton randomBtn, readyBtn;
	private JLabel bingoCountLabel;
	private JPanel bingoPane, bingoPane2, readyPane, bingoCountPane /*memberPane*/;
	private int bingoCount;
	
	public void makeFrame(){
		
		
		System.out.println("실행");
		
		//메인프레임 set하기
		this.setTitle("빙고 게임");
		this.setBounds(300, 100, 1050, 650);
		this.setLayout(null);
		
		
		//빙고 판 set하기
		//내 빙고판
		bingoPane = new JPanel();
		bingoPane.setBackground(Color.lightGray);
		bingoPane.setLocation(0, 0);
		bingoPane.setLayout(new GridLayout(5, 5));
		bingoPane.setSize(500, 500);
		
		//상대편 빙고판
		bingoPane2 = new JPanel();
		bingoPane2.setBackground(Color.lightGray);
		bingoPane2.setLocation(533, 0);
		bingoPane2.setLayout(new GridLayout(5, 5));
		bingoPane2.setSize(500, 500);
		
		for(int i = 0; i < btnArr.length; i++){
			
			btnArr[i] = new JButton("버튼");
			btnArr2[i] = new JButton();
			
			btnArr[i].addActionListener(this);
			
			bingoPane.add(btnArr[i]);
			bingoPane2.add(btnArr2[i]);
			
		}
		this.add(bingoPane2);
		this.add(bingoPane);
		
		bingoPane.setVisible(true);
		bingoPane2.setVisible(true);
		
		//빙고 갯수 표시 패널
		bingoCountPane = new JPanel();
		bingoCountLabel = new JLabel(bingoCount + " 빙고 ! ");
		bingoCountLabel.setFont(new Font(bingoCountLabel.getText(), Font.BOLD, 35));
		
	
		bingoCountPane.setBackground(Color.lightGray);
		bingoCountPane.setSize(1035, 50);
		bingoCountPane.setLocation(0, 560);
		
			
		bingoCountPane.add(bingoCountLabel);
		this.add(bingoCountPane);
		
		//자동 채우기 버튼 & 준비 버튼 
		readyBtn = new JButton("준비 완료");
		readyBtn.setFont(new Font(readyBtn.getText(), Font.BOLD, 30));
		readyBtn.setBackground(Color.lightGray);
		readyBtn.setEnabled(false);
		
		readyPane = new JPanel();
		readyPane.setLayout(new GridLayout(1, 2));
		readyPane.setSize(1035, 60);
		readyPane.setLocation(0, 500);
		
		
		randomBtn = new JButton("자동 채우기");
		randomBtn.setFont(new Font(randomBtn.getText(), Font.BOLD, 30));
		randomBtn.setBackground(Color.lightGray);
		
		readyPane.add(randomBtn);
		readyPane.add(readyBtn);
		
		randomBtn.addActionListener(this);
		readyBtn.addActionListener(this);
		
		this.add(readyPane, BorderLayout.SOUTH);
		/*this.add(readyBtn, BorderLayout.SOUTH);
		this.add(randomBtn, BorderLayout.SOUTH);*/
		
		readyPane.setVisible(true);
		randomBtn.setVisible(true);
		/*//회원 관리 set하기
		memberPane = new JPanel();
		memberPane.setLayout(new BoxLayout(memberPane, BoxLayout.Y_AXIS));
		memberPane.setSize(100, 100);
		memberPane.setLocation(950, 100);
		
		memberPane.add(new JLabel("ID : ", Label.LEFT));
		memberPane.add(new JTextField(15));
		memberPane.add(new JLabel("PWD : ", Label.LEFT));
		memberPane.add(new JTextField(15));
		
		this.add(memberPane, BorderLayout.EAST);
		memberPane.setVisible(true);*/
		
		
		
		
		
		this.setVisible(true);
		
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		// 자동 채우기 버튼
		if(e.getActionCommand().equals(randomBtn.getText())){
			for(int i = 0; i < btnArr.length; i++){
				int random = (int)(Math.random() * 50) + 1;
				btnArr[i].setText(String.valueOf(random));
				for(int j = 0; j < i; j++){
					if(btnArr[j].getText().equals(String.valueOf(random))){
						i--;
						break;
					}
						
				}
				
				
				btnArr[i].setEnabled(false);
			}
			readyBtn.setEnabled(true);
			randomBtn.setEnabled(false);
		}
		// 준비 완료 버튼
		if(e.getActionCommand().equals(readyBtn.getText())){
			readyBtn.setEnabled(false);
			
			for(int i = 0; i < btnArr.length; i++){
				btnArr[i].setEnabled(true);
			}
				
			
		}
		
	
			
	}
	
}
