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
			case 1: storename = storeList.get(0).getStorename(); break; //ù��° ������
			case 2: storename = storeList.get(1).getStorename(); break; //�ι�° ������
			case 3: storename = storeList.get(2).getStorename(); break; //����° ������
			}
			//System.out.println("storename: " + storename);
			
			/*
			1 | �׳�ġŲ | ������ | 17000
			2 | �׳�ġŲ | �Ķ��̵� | 15000
			3 | �׳�ġŲ | ��� | 16000
			*/
			
			List<Menu> menuList = rstDao.getMenuList(storename);
			
			System.out.println("����������������������������������������������������������������������������");
			for (int i = 0; i < menuList.size(); i++)
			{
				System.out.println((i+1) + " | " + menuList.get(i));
			}
			System.out.println("����������������������������������������������������������������������������");
			
			System.out.println("[1. �޴� �� ���� ����, 9. �����޴�, 0. ó������]");
			int option = option("[��ȣ ���� >>] ");
			System.out.println();
			
			switch (option)
			{
			case 1: 
			{
					int menu = option("[�޴� ���� >>] ");
					if (menu > menuList.size()) 
					{
						System.out.println("[�ùٸ� ��ȣ�� �Է��� �ּ���.]");
					}
					else
					{
						int amount = option("[���� ���� >>] ");
						System.out.println();
				
						String menuname = menuList.get(menu - 1).getMenuname(); //������ �޴��� �̸�
						int menuprice = menuList.get(menu - 1).getPrice();   //������ �޴��� ����
						
						co.print(storename, menuname, menuprice, amount);
					}
					break;
			}
			case 9: return;
			case 0: userUi.print(); return;
			default : System.out.println("[�ùٸ� ��ȣ�� �Է����ּ���.]"); break;
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
				//��ü�� shoppingbag����Ʈ�� �߰�
				sb = new Shoppingbag();
				
				sb.setStorename(storename);
				sb.setMenuname(menuname);
				sb.setPrice(menuprice);
				sb.setAmount(amount);
				
				System.out.println(sb);
				int result = restaurantDao.addtoshoppingbag(sb);
				if (result > 0)
				{
					System.out.println("��ٱ��� ����� �Ϸ�Ǿ����ϴ�.");
				}
				else
				{
					System.out.println("��ٱ��� ��Ͽ� �����Ͽ����ϴ�.");
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
