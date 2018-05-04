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
			System.out.println("─────────────────────");
			System.out.println("1.사용자");
			System.out.println("2.관리자");
			System.out.println("─────────────────────");
			
			//메뉴 입력받기 
			int option = option("[번호 입력 >>] ");
			System.out.println();
			
			//메뉴별로 실행 
			switch (option)
			{
			//1. 음식 주문하기 
			case 1: userUI.print(); break;
			case 2: new AdminLogin(); break;
			default: System.out.println("[올바른 숫자를 입력해 주세요.]"); break;
			}
		}
	}
				
	//메뉴번호 입력받는 option 메소드
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
