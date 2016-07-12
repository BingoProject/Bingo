package model;

import java.io.*;
import java.util.*;

public class UserInfo {
	
	Properties prop = new Properties();
	
	public UserInfo(){}
	
	//user.properties 파일 읽기 메소드
	public Map<String, User> readProperties(){
		Map<String, User> users = null;
		
		try {
			prop.load(new FileReader("users.properties"));
			
			if(prop.size() > 0){//데이터가 존재하냐는 조건문
				//String 값 Map으로 변환
				users = new HashMap<String, User>();
				
				//하나씩 꺼내기 위해 목록화
				Iterator Iter = prop.entrySet().iterator();
				
			while(Iter.hasNext()){
				Map.Entry entry = (Map.Entry)Iter.next();
				String key = (String)entry.getKey();
				String value = (String)entry.getValue();
				
				// 꺼낸 value값 String 배열에 split으로 나누어 저장
				String[] values = value.split(",");
								
				users.put(key, new User(values[0], values[1], values[2]));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return users;
	}
	//properties 파일에 정보 저장
	public boolean saveProperties(Map<String, User> users){
		// 저장되면 true, 안되면 false 반환.
		boolean result = false;
		//그대로 읽어올 수 없어 Map 목록화 진행
		Iterator<Map.Entry<String, User>> Iter = users.entrySet().iterator();
		
		//읽어들인 값 prop에 저장
		while(Iter.hasNext()){
			Map.Entry<String, User> entry = Iter.next();
			prop.setProperty(entry.getKey(), entry.getValue().toString());
		}
		
		//prop에 저장된 정보 users.properties에 저장
		try {
			prop.store(new FileWriter("users.properties"), null);
			//저장되었으므로 true 반환
			result = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
