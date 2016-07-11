package run;

import view.*;

public class Main {

	public static void main(String[] args) {
		
		LoginDialog login = new LoginDialog();
		login.setModal(true);
		login.setLocation(550, 300);
		login.setSize(500, 200);
		login.setVisible(true);
		
		
		
		
		
		new MainFrame().makeFrame();
	}

}
