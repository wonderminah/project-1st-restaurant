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
			System.out.println("������������������������������������������");
			System.out.println("1. ġ    Ų");
			System.out.println("2. ��    ��");
			System.out.println("3. ��    ��");
			System.out.println("4. ��    ��");
			System.out.println("9. �����޴�");
			System.out.println("0. ó������");
			System.out.println("������������������������������������������");
			int option = option("��ȣ �Է� >> ");
			System.out.println();
			
			switch(option)
			{
			case 1: cs.print(1); break;
			case 2: cs.print(2); break;
			case 3: cs.print(3); break;
			case 4: cs.print(4); break;
			case 9: return;
			case 0: userUi.print(); return;
			default: System.out.println("[�ùٸ� ��ȣ�� �Է��� �ּ���.]"); break;
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
