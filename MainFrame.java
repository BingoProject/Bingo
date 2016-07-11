package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MainFrame extends JFrame implements ActionListener{
	private JButton[] btnArr = new JButton[25];
	private JButton randomBtn;
	private JPanel bingoPane /*memberPane*/;
	
	public void makeFrame(){
		
		
		
		
		//메인프레임 set하기
		this.setTitle("빙고 게임");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBounds(200, 300, 1000, 600);
		this.setLayout(new BorderLayout());
		
		
		//빙고 판 set하기
		bingoPane = new JPanel();
		bingoPane.setBackground(Color.lightGray);
		bingoPane.setSize(1000, 500);
		bingoPane.setLocation(20, 20);
		bingoPane.setLayout(new GridLayout(5, 5));
		
		for(int i = 0; i < btnArr.length; i++){
			
			btnArr[i] = new JButton("버튼");
			
			btnArr[i].addActionListener(this);
			bingoPane.add(btnArr[i]);
		}
		this.add(bingoPane, BorderLayout.CENTER);
		bingoPane.setVisible(true);
		
		//자동 채우기 버튼
		randomBtn = new JButton("자동 채우기");
		randomBtn.setBackground(Color.lightGray);
		randomBtn.setSize(1000, 200);
		
		
		randomBtn.addActionListener(this);
		this.add(randomBtn, BorderLayout.SOUTH);
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
		if(e.getActionCommand().equals(randomBtn.getText()))
			for(int i = 0; i < btnArr.length; i++){
				btnArr[i].
				
				
			}
		
		
	}
	
}
