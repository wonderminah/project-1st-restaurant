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

		// ������ ���� id : system pw : system
		Scanner sc = new Scanner(System.in);
			
		while (true) 
		{
			System.out.println("[������ ����Դϴ�. ���� �޴��� 9���� �Է��ϼ���.]");
			System.out.print("�� �� ��: ");
			String id = sc.next(); if (id.equals("9")) {return;}
			System.out.print("��й�ȣ: ");
			String pw = sc.next();

			l.setId(id);
			l.setPw(pw);

			List<Login> loginList = LoginDao.check(l);

			if (loginList.size() == 1) 
			{
				System.out.println("[�α��ο� ���� �Ͽ����ϴ�.]");
				System.out.println();
				adminUi.print(); // UI�� �ٽ� �ö�
			} 
			else 
			{
				System.out.println("[�α��ο� ���� �Ͽ����ϴ�.]");
				System.out.println();
			}
		}
	}
}
