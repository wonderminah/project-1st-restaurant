package restaurant.ui;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import restaurant.dao.RestaurantDAO;
import restaurant.vo.Menu;
import restaurant.vo.Orderlist;
import restaurant.vo.Shoppingbag;

public class SbOrOrder
{
	Scanner sc = new Scanner(System.in);
	RestaurantDAO rstDao = new RestaurantDAO();
	List<Shoppingbag> sbList = rstDao.bringshoppingbag();
	
	public SbOrOrder() {}
	
	//��ٱ��� �߰�
	public Shoppingbag addToSB(String storename, String menuname, int menuprice, int amount)
	{
		while(true)
		{
			/*
			System.out.println(storename);
			System.out.println(menuname);
			System.out.println(menuprice);
			System.out.println(amount);
			*/
			
			Shoppingbag sb = new Shoppingbag();
			List<Menu> menuList = rstDao.getMenuList(storename);
			
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
					
					//System.out.println(sb);
					
					int result = rstDao.addtoshoppingbag(sb);
					if (result > 0)
					{
						System.out.println("[��ٱ��� ����� �Ϸ�Ǿ����ϴ�.]");
						System.out.println();
					}
					else
					{
						System.out.println("[��ٱ��� ��Ͽ� �����Ͽ����ϴ�.]");
						System.out.println();
					}
				}
			}
			return sb;
		}
	}
	
	//�ٷ� �ֹ��ϱ�
	public void orderNow(String storename, String menuname, int menuprice, int amount)
	{
		while (true)
		{
				
			/*
			System.out.println(storename);
			System.out.println(menuname);
			System.out.println(menuprice);
			System.out.println(amount);
			*/
			
			/*if (sbList.size() > 0)
			{
				for (int i = 0; i < sbList.size(); i++)
				{
					System.out.println((i+1) + " " + sbList.get(i));
				}
				System.out.println("1. �ֹ� ����");
				System.out.println("2. �ٷ� �ֹ�");
				System.out.println("3. ���� �޴�");
				int option = option("[��ȣ �Է� >> ]");
				
				switch (option)
				{
				case 1: modifyOrder(storename); break;
				case 2: addToOL(storename, menuname, menuprice, amount); return;
				case 3: return;
				}
			}
			else
			*/
			{
				Calendar d = Calendar.getInstance();
				int year  = d.get(Calendar.YEAR);
				int month = d.get(Calendar.MONTH);
				int day   = d.get(Calendar.DATE);
				String today = year + "-" + month + "-" + day;
				
				Orderlist o = new Orderlist();
				o.setOrderdate(today);
				o.setStorename(storename);
				o.setMenuname(menuname);
				o.setPrice(menuprice);
				o.setAmount(amount);
				o.setMileage(menuprice * amount / 10);
				
				int result = rstDao.addtoorderlist(o);
				if (result > 0)
				{
					System.out.println("[�ֹ��� �Ϸ�Ǿ����ϴ�.]");
					System.out.println();
					return;
				}
				else
				{
					System.out.println("[�ֹ��� �����Ͽ����ϴ�.]");
					System.out.println();
					return;
				}
			}
		}
	}
	
/*	//�ֹ� �����ϱ�
	public void modifyOrder(String storename) //���� �ʿ�
	{
		
		System.out.println("[������ �ֹ���ȣ�� �Է��ϼ���. ���� �޴��� 9���� �Է��ϼ���.]");
		int option = option("(��ȣ �Է� >>) ");
		
		if (option < 1 || option > sbList.size())
		{
			System.out.println("[�߸� �Է��ϼ̽��ϴ�.]");
		}
		else if (option == 9)
		{
			return;
		}
		else
		{
			List<Menu> menuList = rstDao.getMenuList(storename);
			int menu = option("(�޴� ���� >>) ");
			String menuname = menuList.get(menu - 1).getMenuname();
			int amount = option("(���� ���� >>) ");
			

			int result = 0;
			for (int i = 0; i < sbList.size(); i++)
			{
				if (sbList.get(i).getId() == option)
				{
					sbList.get(i).setMenuname(menuname);
					sbList.get(i).setAmount(amount);
					result = rstDao.modifyOrder(sbList.get(i)); break;
				}
			}
			
			if (result > 0)
			{
				System.out.println("[�ֹ����� ������ �����Ͽ����ϴ�.]");
			}
			else
			{
				System.out.println("[�ֹ����� ������ �����Ͽ����ϴ�.]");
			}
		}
	}
	*/
	public void addToOL(String storename, String menuname, int menuprice, int amount) //�̿ϼ�
	{
		Calendar d = Calendar.getInstance();
		int year  = d.get(Calendar.YEAR);
		int month = d.get(Calendar.MONTH);
		int day   = d.get(Calendar.DATE);
		String today = year + "-" + month + "-" + day;
		//System.out.println(today); �� ���´�.
		
		
		int result = 0;
		Orderlist ol = new Orderlist();
		ol.setOrderdate(today);
		ol.setStorename(storename);
		ol.setMenuname(menuname);
		ol.setPrice(menuprice);
		ol.setAmount(amount);
		ol.setMileage(menuprice / 10);
		
		result = rstDao.addtoorderlist(ol);
		
		if (result > 0)
		{
			System.out.println("[�ֹ� ����� �Ϸ�Ǿ����ϴ�.]"); 
		}
		else
		{
			System.out.println("[�ֹ� ��Ͽ� �����Ͽ����ϴ�.]");
		}
		
	}
	
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
