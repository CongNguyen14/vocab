package kits.learnvocab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kits.learnvocab.dao.TopicDao;
import kits.learnvocab.dao.UserDao;
import kits.learnvocab.dto.TopicDto;
import kits.learnvocab.dto.UserDto;

public class Login {
	static int role;
	private static boolean checkUser_Pass(){
		List<UserDto> ls = new ArrayList();
		UserDao usdao = new UserDao();
		ls = usdao.findAll();	
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap username");
		String user = sc.next();
		System.out.println("nhap pass");
		String pass = sc.next();
		for (int i =0; i < ls.size(); i++) {
			if(user.equals(ls.get(i).getUsername())&& pass.equals(ls.get(i).getPassword())) {
				role = ls.get(i).getRole();
				return true;
			}
			//System.out.println(ls.get(i).getUsername()+"\t"+ ls.get(i).getPassword());
		}
		
		
		
		
		return false;
	}
	
	public static void Login() {
		while(checkUser_Pass()==false) {
			System.out.println("nhap lai ");
		}
		System.out.println("login sucess");
		if (role==1) {
			Admin admin = new Admin();
			
		}
	}
//	public static void main(String[] args) {
////		Login();
//		
//	}
}
