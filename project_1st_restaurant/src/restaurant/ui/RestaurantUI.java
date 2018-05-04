package restaurant.ui;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import restaurant.dao.RestaurantDAO;
import restaurant.vo.FavoriteList;
import restaurant.vo.Menu;
import restaurant.vo.Orderlist;
import restaurant.vo.Restaurant;
import restaurant.vo.Shoppingbag;

public class RestaurantUI
{
	public static Scanner sc = new Scanner(System.in);

	UserUI userUI = new UserUI();
	AdminUI adminUI = new AdminUI();
	
	public RestaurantUI()
	{
		boolean flag = true;
		while (flag)
		{
			System.out.println("������������������������������������������");
			System.out.println("1.�����");
			System.out.println("2.������");
			System.out.println("������������������������������������������");
			
			//�޴� �Է¹ޱ� 
			int option = option("[��ȣ �Է� >>] ");
			System.out.println();
			
			//�޴����� ���� 
			switch (option)
			{
			//1. ���� �ֹ��ϱ� 
			case 1: userUI.print(); break;
			case 2: new AdminLogin(); break;
			default: System.out.println("[�ùٸ� ���ڸ� �Է��� �ּ���.]"); break;
			}
		}
	}
				
	//�޴���ȣ �Է¹޴� option �޼ҵ�
	public static int option(String string)
	{
		System.out.print(string);
		
		int option = 0;
		try
		{
			option = sc.nextInt();
		}
		catch (Exception e)
		{
			sc.nextLine();
		}
		sc.nextLine();
		return option;
	}
} //class
