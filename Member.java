package model;

import java.io.*;
import java.util.*;

public class Member {
	public Member(){}
			
	//로그인 체크 처리 메소드
	public User loginCheck(String userId, char[] userPwd){
		User loginUser = null;
		
		//Map 리턴 받음.
		Map<String, User> users = new UserInfo().readProperties();
		
		//로그인 체크 로직
		if(users.containsKey(userId)){//로그인 아이디 비교
			User user = users.get(userId); 
			if(user.getUserPwd().equals(new String(userPwd))){//로그인 패스워드 비교
				loginUser = user; //값이 둘다 맞으면 아이디 반환
			}
		}
		
		return loginUser;
				
	}
	//회원 가입 처리용 메소드
	public boolean joinUser(User user){
		boolean result = false;
		UserInfo userInfo = new UserInfo();
		//회원 정보 읽어와 users에 저장
		Map<String, User> users = userInfo.readProperties();
		
		//매개변수 받은 정보 Map에 넣음
		users.put(user.getUserId(), user);
		
		result = userInfo.saveProperties(users);
		
		return result;
	}
}
