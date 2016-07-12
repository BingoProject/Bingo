package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

import controller.MainController;
import model.Member;
import model.User;

import javax.swing.*;

public class LoginDialog extends JDialog {
	JLabel LabelId = new JLabel("ID : ");
	JLabel LabelPwd = new JLabel("PWD : ");

	JTextField TextId = new JTextField(20);
	JPasswordField TextPwd = new JPasswordField(20);

	JButton loginBtn = new JButton("로그인");
	JButton cancelBtn = new JButton("종료");
	JButton joinBtn = new JButton("회원가입");

	public LoginDialog() {
		loginUI();
		Listener();

	}

	public void loginUI() {
		this.setTitle("로그인");
		addWindowListener(new WindowAdapter(){
			
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		JPanel topPane = new JPanel(new GridBagLayout());
		JPanel buttonPane = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		buttonPane.add(loginBtn);
		buttonPane.add(cancelBtn);
		buttonPane.add(joinBtn);

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

		this.add(topPane);

		this.add(buttonPane, BorderLayout.SOUTH);

	}

	public void Listener() {
		loginBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 로그인 버튼
				User login = new MainController().loginController(TextId.getText(), TextPwd.getPassword());
				System.out.println(login);
				if (login != null) {
					JOptionPane.showMessageDialog(loginBtn, "로그인 되었습니다!");
					getParent().setVisible(false);
				} else
					JOptionPane.showMessageDialog(loginBtn, "회원 정보가 없습니다.");

			}

		});

		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 취소 버튼
				System.exit(0);
			}

		});

		joinBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 회원가입 버튼
				JoinDialog join = new JoinDialog();
				join.setModal(true);
				join.setLocation(550, 300);
				join.setSize(500, 200);
				join.setVisible(true);

			}

		});
		
	}
		
}