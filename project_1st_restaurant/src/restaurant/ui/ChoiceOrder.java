package restaurant.ui;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import restaurant.dao.RestaurantDAO;
import restaurant.vo.Menu;
import restaurant.vo.Orderlist;
import restaurant.vo.Shoppingbag;

public class ChoiceOrder
{
	Scanner sc = new Scanner(System.in);
	SbOrOrder soo = new SbOrOrder();
	
	public ChoiceOrder() {}
	
	public void print(String storename, String menuname, int menuprice, int amount)
	{
		UserUI userUi = new UserUI();
		while(true)
		{
			//�ֹ����� Ȯ��
			System.out.println("������������������������������������������������������������");
			System.out.println("���� �޴�: " + menuname);
			System.out.println("�ֹ� ����: " + amount);
			System.out.println("�հ� �ݾ�: " + menuprice * amount);
			System.out.println("������������������������������������������������������������");
			
			//��ٱ��Ͽ� �߰��� ��, �ٷ� �ֹ��� ��, �ٽ� ������ ��?
			System.out.println("[1. ��ٱ��� �߰�]");
			System.out.println("[2. �ٷ� �ֹ��ϱ�]");
			System.out.println("[9. �����޴� ����]");
			System.out.println("[0. ó������ ����]");
			int option = option("[��ȣ �Է� >>] ");
			System.out.println();
	
			switch (option)
			{
			case 1: soo.addToSB(storename, menuname, menuprice, amount); break;
			case 2: soo.orderNow(storename, menuname, menuprice, amount); break;
			case 9: return;
			case 0: userUi.print(); return;
			}
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
