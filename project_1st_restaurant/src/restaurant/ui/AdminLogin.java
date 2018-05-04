package restaurant.ui;

import java.util.List;
import java.util.Scanner;

import restaurant.dao.LoginDAO;
import restaurant.vo.Login;

public class AdminLogin 
{

	public AdminLogin() 
	{
		AdminUI adminUi = new AdminUI();
		Login l = new Login();
		LoginDAO LoginDao = new LoginDAO();

		// 관리자 계정 id : system pw : system
		Scanner sc = new Scanner(System.in);
			
		while (true) 
		{
			System.out.println("[관리자 모드입니다. 상위 메뉴는 9번을 입력하세요.]");
			System.out.print("아 이 디: ");
			String id = sc.next(); if (id.equals("9")) {return;}
			System.out.print("비밀번호: ");
			String pw = sc.next();

			l.setId(id);
			l.setPw(pw);

			List<Login> loginList = LoginDao.check(l);

			if (loginList.size() == 1) 
			{
				System.out.println("[로그인에 성공 하였습니다.]");
				System.out.println();
				adminUi.print(); // UI로 다시 올라감
			} 
			else 
			{
				System.out.println("[로그인에 실패 하였습니다.]");
				System.out.println();
			}
		}
	}
}
