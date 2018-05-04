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
			System.out.println("[1. ���� ���, 2. �޴� ���, 9. ���� �޴�]");
			System.out.print("[��ȣ �Է� >>] ");
			int option = sc.nextInt();
			System.out.println();
			
			switch (option) 
			{
			case 1: add();
					break;
			case 2:	add2();	break;
			case 9:	return;
			default: System.out.println("[�ùٸ� ���ڸ� �Է��� �ּ���]"); System.out.println();
			}
		}
	}
	
	private void add()
	{
		while(true)
		{
			Restaurant r = new Restaurant();
			System.out.println("[������ ����մϴ�. ���� �޴��� 9���� �Է��ϼ���.]");
			System.out.print("���� ����(ġŲ: 1, ����: 2, ����: 3, ����: 4): ");
			int foodtype = sc.nextInt();
			if (foodtype == 9) {System.out.println(); return;}
			else if (foodtype != 1 & foodtype != 2 & foodtype != 3 & foodtype != 4)
			{
				System.out.println("[�ùٸ� ���ڸ� �Է��� �ּ���.]");
				System.out.println();
			}
			else
			{
				System.out.print("���� ��Ī: ");
				String storename = sc.next();
				System.out.print("���� �ð�: ");
				String openhour = sc.next();
				System.out.print("���� �ð�: ");
				String closehour = sc.next();
				System.out.print("��ȭ ��ȣ: ");
				String phonenum = sc.next();
				System.out.print("�ּ� �ֹ��ݾ�: ");
				int minorder = sc.nextInt();
				System.out.print("�ҿ� �ð�: ");
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
					System.out.println("[���� ��Ͽ� ���� �Ͽ����ϴ�.]");
					System.out.println();
				} 
				else 
				{
					System.out.println("[���� ��Ͽ� ���� �Ͽ����ϴ�.]");
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
			System.out.println("[�޴��� ����մϴ�. ���� �޴��� 9���� �Է��ϼ���.]");
			System.out.print("������: ");
			String storename = sc.next();
			if (storename.equals("9")) {System.out.println(); return;}
			System.out.print("��  ��: ");
			String menuname = sc.next();
			System.out.print("��  ��: ");
			int price = sc.nextInt();
	
			m.setStorename(storename);
			m.setMenuname(menuname);
			m.setPrice(price);
	
			int result = rstDao.add2(m);
	
			if (result > 0) {
				System.out.println("[�޴� ��Ͽ� ���� �Ͽ����ϴ�.]");
				System.out.println();
			} else {
				System.out.println("[�޴� ��Ͽ� ���� �Ͽ����ϴ�.]");
				System.out.println();
			}
		}
	}
}
