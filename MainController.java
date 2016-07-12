package controller;

import model.Member;
import model.User;


public class MainController {
	
	public MainController(){}
	
	//로그인 처리 컨트롤러
	public User loginController(String userId, char[] userPwd){
		Member member = new Member();
		User loginUser = member.loginCheck(userId, userPwd);
		if(loginUser != null){//로그인 성공 시
			return loginUser;
		}else
			return null;
		
		 
	}

	//회원가입 처리 컨트롤러
	public void joinUserController(User user){
		
	}
}
