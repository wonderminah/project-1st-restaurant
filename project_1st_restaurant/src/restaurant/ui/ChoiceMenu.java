package restaurant.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import restaurant.dao.RestaurantDAO;
import restaurant.vo.Menu;
import restaurant.vo.Restaurant;
import restaurant.vo.Shoppingbag;

public class ChoiceMenu
{
	Scanner sc = new Scanner(System.in);
	RestaurantDAO rstDao = new RestaurantDAO();
	ChoiceOrder co = new ChoiceOrder();
		
	public ChoiceMenu() {}
	
	public void print(int food, int store)
	{
		UserUI userUi = new UserUI();
		while (true)
		{
			List<Restaurant> storeList = rstDao.getStoreList(food);

			String storename = null;
			switch(store)
			{
			case 1: storename = storeList.get(0).getStorename(); break; //첫번째 점포명
			case 2: storename = storeList.get(1).getStorename(); break; //두번째 점포명
			case 3: storename = storeList.get(2).getStorename(); break; //세번째 점포명
			}
			//System.out.println("storename: " + storename);
			
			/*
			1 | 네네치킨 | 스노윙 | 17000
			2 | 네네치킨 | 후라이드 | 15000
			3 | 네네치킨 | 양념 | 16000
			*/
			
			List<Menu> menuList = rstDao.getMenuList(storename);
			
			System.out.println("──────────────────────────────────────");
			for (int i = 0; i < menuList.size(); i++)
			{
				System.out.println((i+1) + " | " + menuList.get(i));
			}
			System.out.println("──────────────────────────────────────");
			
			System.out.println("[1. 메뉴 및 수량 선택, 9. 상위메뉴, 0. 처음으로]");
			int option = option("[번호 선택 >>] ");
			System.out.println();
			
			switch (option)
			{
			case 1: 
			{
					int menu = option("[메뉴 선택 >>] ");
					if (menu > menuList.size()) 
					{
						System.out.println("[올바른 번호를 입력해 주세요.]");
					}
					else
					{
						int amount = option("[수량 선택 >>] ");
						System.out.println();
				
						String menuname = menuList.get(menu - 1).getMenuname(); //선택한 메뉴의 이름
						int menuprice = menuList.get(menu - 1).getPrice();   //선택한 메뉴의 가격
						
						co.print(storename, menuname, menuprice, amount);
					}
					break;
			}
			case 9: return;
			case 0: userUi.print(); return;
			default : System.out.println("[올바른 번호를 입력해주세요.]"); break;
			}
		}
	}
	
/*	public void addToSpb(String menuname, int menuprice, int amount)
	{
		Shoppingbag sb = new Shoppingbag();
		System.out.println(amount); //test
		for (int i = 0; i < menuList.size(); i++)
		{
			if (menuList.get(i).getMenuname().equals(menuname))
			{
				//객체를 shoppingbag리스트에 추가
				sb = new Shoppingbag();
				
				sb.setStorename(storename);
				sb.setMenuname(menuname);
				sb.setPrice(menuprice);
				sb.setAmount(amount);
				
				System.out.println(sb);
				int result = restaurantDao.addtoshoppingbag(sb);
				if (result > 0)
				{
					System.out.println("장바구니 등록이 완료되었습니다.");
				}
				else
				{
					System.out.println("장바구니 등록에 실패하였습니다.");
				}
			}
		}
	}*/
	
	public int option(String string)
	{
		System.out.print(string);
		int option = 0;
		try	{option = sc.nextInt();}
		catch (Exception e)	{sc.nextLine();}
		sc.nextLine();
		return option;
	}
}
