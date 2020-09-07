package com.duongnv30.mock_v1.main;

import java.io.IOException;
import java.util.Scanner;

import com.duongnv30.mock_v1.main.admin.HomeOfAdmin;
import com.duongnv30.mock_v1.main.user.HomeOfUser;
import com.duongnv30.mock_v1.model.User;
import com.duongnv30.mock_v1.service.BookCaseService;
import com.duongnv30.mock_v1.service.UserService;
import com.duongnv30.mock_v1.service.impl.BookCaseServiceImpl;
import com.duongnv30.mock_v1.service.impl.UserServiceImpl;
import com.duongnv30.mock_v1.utils.constant.SystemConstant;
import com.duongnv30.mock_v1.utils.system.SystemObject;

public class Program {

	public static UserService userService;
	public static BookCaseService bookCaseService;

	public Program() {
		//Khi khởi chạy chương trình load hết User vào trong 1 Dictionary 
		//để những lần đăng nhập sau không cần phải truy vấn từ cơ sở dữ liệu
		userService = UserServiceImpl.getInstance();
		bookCaseService = BookCaseServiceImpl.getInstance();
		new SystemObject();
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Program program = new Program();
		User user;
		while(true) {
			user = login(sc);
			switch (user.getRoles().get(0).getAuthority()) {
			case SystemConstant.ADMIN:
				HomeOfAdmin.homeOfAdmin(sc, user);
				break;
				
			case SystemConstant.USER:
				HomeOfUser.homeOfUser(sc, user);
				break;
				
			default:
				System.out.println("No Access!");
				break;
			}
		}
	}
	
	
	/*
	 * kiêm tra login
	 */
	public static User login(Scanner sc) throws IOException {
		String userName, passWord;
		User user;
		System.out.println("Wellcome to Read Book Application! Please enter your username and password.");
		do {
			System.out.println("UserName: ");
			userName = sc.nextLine().trim();
			System.out.println("PassWord: ");
			passWord = sc.nextLine().trim();
			//user = userService.findByUserNamePassWord(userName, passWord, 1);
			
			// tìm kiếm trong Dictionary có User nào tương đồng không 
			//(hàm hashCode của User đã được chỉnh sửa lại để phục vụ tìm kiếm)
			user = SystemObject.dictionaryUser.get(new User(userName, passWord, 1).hashCode());
			if(user == null) {
				System.out.println("\nUserName or PassWord is wrong!\nPlease enter again:");
			}else {
				// lấy ra thông tin BookCase tương ứng với User đã đăng nhập
				user.setBookCase(bookCaseService.findOne(user.getId()));
				System.out.println("Login successfully!\n");
				return user;
			}
		} while (true);
	}	
	
	
	//Làm trắng Console
	public static void clrscr(){
		   //Clears Screen in java
		   try {
		       if (System.getProperty("os.name").contains("Windows"))
		           new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		       else
		           Runtime.getRuntime().exec("clear");
		   } catch (IOException | InterruptedException ex) {}
		}
}
