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
	
	//장바구니 추가
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
					//객체를 shoppingbag리스트에 추가
					sb = new Shoppingbag();
					
					sb.setStorename(storename);
					sb.setMenuname(menuname);
					sb.setPrice(menuprice);
					sb.setAmount(amount);
					
					//System.out.println(sb);
					
					int result = rstDao.addtoshoppingbag(sb);
					if (result > 0)
					{
						System.out.println("[장바구니 등록이 완료되었습니다.]");
						System.out.println();
					}
					else
					{
						System.out.println("[장바구니 등록에 실패하였습니다.]");
						System.out.println();
					}
				}
			}
			return sb;
		}
	}
	
	//바로 주문하기
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
				System.out.println("1. 주문 수정");
				System.out.println("2. 바로 주문");
				System.out.println("3. 상위 메뉴");
				int option = option("[번호 입력 >> ]");
				
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
					System.out.println("[주문이 완료되었습니다.]");
					System.out.println();
					return;
				}
				else
				{
					System.out.println("[주문에 실패하였습니다.]");
					System.out.println();
					return;
				}
			}
		}
	}
	
/*	//주문 수정하기
	public void modifyOrder(String storename) //수정 필요
	{
		
		System.out.println("[수정할 주문번호를 입력하세요. 상위 메뉴는 9번을 입력하세요.]");
		int option = option("(번호 입력 >>) ");
		
		if (option < 1 || option > sbList.size())
		{
			System.out.println("[잘못 입력하셨습니다.]");
		}
		else if (option == 9)
		{
			return;
		}
		else
		{
			List<Menu> menuList = rstDao.getMenuList(storename);
			int menu = option("(메뉴 선택 >>) ");
			String menuname = menuList.get(menu - 1).getMenuname();
			int amount = option("(수량 선택 >>) ");
			

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
				System.out.println("[주문내용 수정에 성공하였습니다.]");
			}
			else
			{
				System.out.println("[주문내용 수정에 실패하였습니다.]");
			}
		}
	}
	*/
	public void addToOL(String storename, String menuname, int menuprice, int amount) //미완성
	{
		Calendar d = Calendar.getInstance();
		int year  = d.get(Calendar.YEAR);
		int month = d.get(Calendar.MONTH);
		int day   = d.get(Calendar.DATE);
		String today = year + "-" + month + "-" + day;
		//System.out.println(today); 잘 나온다.
		
		
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
			System.out.println("[주문 등록이 완료되었습니다.]"); 
		}
		else
		{
			System.out.println("[주문 등록에 실패하였습니다.]");
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
