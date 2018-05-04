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
			//주문내역 확인
			System.out.println("──────────────────────────────");
			System.out.println("선택 메뉴: " + menuname);
			System.out.println("주문 수량: " + amount);
			System.out.println("합계 금액: " + menuprice * amount);
			System.out.println("──────────────────────────────");
			
			//장바구니에 추가할 지, 바로 주문할 지, 다시 선택할 지?
			System.out.println("[1. 장바구니 추가]");
			System.out.println("[2. 바로 주문하기]");
			System.out.println("[9. 상위메뉴 가기]");
			System.out.println("[0. 처음으로 가기]");
			int option = option("[번호 입력 >>] ");
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
