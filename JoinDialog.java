package view;

import java.awt.*;
import java.awt.event.*;
import java.util.*;


import javax.swing.*;
import javax.swing.event.*;

import model.Member;
import model.User;

public class JoinDialog extends JDialog {
	private JLabel LabelId, LabelPwd, LabelName;
	
	private JTextField TextId, TextName;
	private JPasswordField TextPwd;
	
	private JButton joinBtn, cancelBtn; 
	
	
	public JoinDialog(){
		joinUI();
		Listener();
	}

	public void joinUI(){
		this.setTitle("회원가입");
		
		JPanel topPane = new JPanel(new GridBagLayout());
		JPanel buttonPane = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	
		
		LabelId = new JLabel("아이디 : ");
		LabelPwd = new JLabel("암   호 : ");
		LabelName = new JLabel("이   름 : ");
		
		TextId = new JTextField();
		TextPwd = new JPasswordField();
		TextName = new JTextField();
		
		joinBtn = new JButton("가입");
		cancelBtn = new JButton("취소");
		
		
		
		GridBagConstraints gbc = new GridBagConstraints();
		 
		gbc.insets = new Insets(4, 4, 4, 4);
 
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0;
		topPane.add(LabelId, gbc);
 
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		topPane.add(TextId, gbc);
 
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 0;
		topPane.add(LabelPwd, gbc);
 
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 1;
		topPane.add(TextPwd, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0;
		topPane.add(LabelName, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weightx = 1;
		topPane.add(TextName, gbc);
				
		buttonPane.add(joinBtn);
		buttonPane.add(cancelBtn);
		
		this.add(topPane);
		this.add(buttonPane, BorderLayout.SOUTH);
		
		this.setVisible(false);
	}

	public void Listener(){
		joinBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// 회원가입 버튼
				User user = new User();
				Member member = new Member();
				
				user.setUserId(TextId.getText());
				user.setUserPwd(new String(TextPwd.getPassword()));
				user.setUserName(TextName.getText());
				member.joinUser(user);
				
				JOptionPane.showMessageDialog(joinBtn, "가입 되었습니다!");
				dispose();
			}
			
		});
	
		cancelBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// 취소 버튼
				dispose();
			}
			
		});
	}
}
