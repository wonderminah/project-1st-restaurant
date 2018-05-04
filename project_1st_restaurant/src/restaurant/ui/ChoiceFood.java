package restaurant.ui;

import java.util.Scanner;

public class ChoiceFood
{
	Scanner sc = new Scanner(System.in);
	ChoiceStore cs = new ChoiceStore();
	
	public ChoiceFood() {}
	
	public void print()
	{
		UserUI userUi = new UserUI();
		while (true)
		{
			System.out.println("─────────────────────");
			System.out.println("1. 치    킨");
			System.out.println("2. 피    자");
			System.out.println("3. 족    발");
			System.out.println("4. 보    쌈");
			System.out.println("9. 상위메뉴");
			System.out.println("0. 처음으로");
			System.out.println("─────────────────────");
			int option = option("번호 입력 >> ");
			System.out.println();
			
			switch(option)
			{
			case 1: cs.print(1); break;
			case 2: cs.print(2); break;
			case 3: cs.print(3); break;
			case 4: cs.print(4); break;
			case 9: return;
			case 0: userUi.print(); return;
			default: System.out.println("[올바른 번호를 입력해 주세요.]"); break;
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
