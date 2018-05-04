package restaurant.ui;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

import org.apache.ibatis.exceptions.PersistenceException;

import restaurant.dao.RestaurantDAO;
import restaurant.vo.Menu;
import restaurant.vo.Restaurant;

public class AdminUI
{
	Scanner sc = new Scanner(System.in);
	RestaurantDAO rstDao = new RestaurantDAO();
	
	public AdminUI()
	{
		
	}
	
	public void print()
	{
		while (true)
		{
			System.out.println("[1. 점포 등록, 2. 메뉴 등록, 9. 상위 메뉴]");
			System.out.print("[번호 입력 >>] ");
			int option = sc.nextInt();
			System.out.println();
			
			switch (option) 
			{
			case 1: add();
					break;
			case 2:	add2();	break;
			case 9:	return;
			default: System.out.println("[올바른 숫자를 입력해 주세요]"); System.out.println();
			}
		}
	}
	
	private void add()
	{
		while(true)
		{
			Restaurant r = new Restaurant();
			System.out.println("[점포를 등록합니다. 상위 메뉴는 9번을 입력하세요.]");
			System.out.print("음식 종류(치킨: 1, 피자: 2, 족발: 3, 보쌈: 4): ");
			int foodtype = sc.nextInt();
			if (foodtype == 9) {System.out.println(); return;}
			else if (foodtype != 1 & foodtype != 2 & foodtype != 3 & foodtype != 4)
			{
				System.out.println("[올바른 숫자를 입력해 주세요.]");
				System.out.println();
			}
			else
			{
				System.out.print("점포 명칭: ");
				String storename = sc.next();
				System.out.print("오픈 시각: ");
				String openhour = sc.next();
				System.out.print("마감 시각: ");
				String closehour = sc.next();
				System.out.print("전화 번호: ");
				String phonenum = sc.next();
				System.out.print("최소 주문금액: ");
				int minorder = sc.nextInt();
				System.out.print("소요 시간: ");
				int requiredtime = sc.nextInt();
				
				r.setFoodtype(foodtype);
				r.setStorename(storename);
				r.setOpenhour(openhour);
				r.setClosehour(closehour);
				r.setPhonenum(phonenum);
				r.setMinorder(minorder);
				r.setRequiredtime(requiredtime);
				
				int result = rstDao.add(r);
				
				if (result > 0) 
				{
					System.out.println("[점포 등록에 성공 하였습니다.]");
					System.out.println();
				} 
				else 
				{
					System.out.println("[점포 등록에 실패 하였습니다.]");
					System.out.println();
				}
			}
		}
	}
	
	private void add2() 
	{
		while (true)
		{
			Menu m = new Menu();
			System.out.println("[메뉴를 등록합니다. 상위 메뉴는 9번을 입력하세요.]");
			System.out.print("점포명: ");
			String storename = sc.next();
			if (storename.equals("9")) {System.out.println(); return;}
			System.out.print("메  뉴: ");
			String menuname = sc.next();
			System.out.print("가  격: ");
			int price = sc.nextInt();
	
			m.setStorename(storename);
			m.setMenuname(menuname);
			m.setPrice(price);
	
			int result = rstDao.add2(m);
	
			if (result > 0) {
				System.out.println("[메뉴 등록에 성공 하였습니다.]");
				System.out.println();
			} else {
				System.out.println("[메뉴 등록에 실패 하였습니다.]");
				System.out.println();
			}
		}
	}
}
