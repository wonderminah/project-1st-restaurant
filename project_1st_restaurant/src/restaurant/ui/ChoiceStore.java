package restaurant.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import restaurant.dao.RestaurantDAO;
import restaurant.vo.Restaurant;

public class ChoiceStore
{
	Scanner sc = new Scanner(System.in);
	RestaurantDAO rstDao = new RestaurantDAO();
	ChoiceInfo ci = new ChoiceInfo();
	List<Restaurant> storeList = new ArrayList<Restaurant>();
	
	public ChoiceStore()
	{
		
	}
	
	public void print(int food) //option�� ġŲ/����/����/����
	{
		storeList = rstDao.getStoreList(food);
		//System.out.println("������Ʈ: " + storeList);
		switch (food)
		{
		case 1: storeList = rstDao.getStoreList(food); break;
		case 2: storeList = rstDao.getStoreList(food); break;
		case 3: storeList = rstDao.getStoreList(food); break;
		case 4: storeList = rstDao.getStoreList(food); break;
		}
		
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������");
		for (int i = 0; i < storeList.size(); i++)
		{
			System.out.println((i+1) + " | " + storeList.get(i).getStorename() + "\t| "
											 + storeList.get(i).getOpenhour()  + " | "
											 + storeList.get(i).getClosehour() + " | "
											 + storeList.get(i).getPhonenum() + " | "
											 + storeList.get(i).getMinorder() + "�� | "
											 + storeList.get(i).getRequiredtime() + "�� | "
											 + storeList.get(i).getGrade() + "�� | "
											 + storeList.get(i).getReviewnum()+ "��");
		}
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������");
		
		
		
		UserUI userUi = new UserUI();
		while (true)
		{
			
			System.out.println ("[1. ��������, 2. ���ĺ���, 9. �����޴�, 0. ó������]");
			int option = option("[��ȣ �Է� >>] ");
			System.out.println();
			
			switch (option)
			{
			case 1: 
			{	
				while (true)
				{
					System.out.println("[���� ��ȣ�� �Է��� �ּ���. ���� �޴��� 9�� �Է��ϼ���.]");
					int store = option("[���� ��ȣ >>] ");
					
					if (store == 9)
					{
						System.out.println();
						break;
					}
					else if (store > storeList.size())
					{
						System.out.println("[�ùٸ� ��ȣ�� �Է��� �ּ���.]");
						System.out.println();
					}
					else
					{
						ci.print(food, store);
					}
				}
				break;
			}
			case 2:
			{
				while (true)
				{
					System.out.println("[1. �������, 2. �ʰԸ���, 3. �������, 4. ��������, 5. ���丹��]");
					System.out.println("[9. �����޴�, 0. ó������]");
					int orderby = option("[��ȣ�Է� >>] ");
									
					if (orderby == 9) {return;}
					else if (orderby == 0) {userUi.print();}
					else if (orderby != 1 & orderby != 2 & orderby != 3 & orderby != 4 & orderby != 5 & orderby != 9 & orderby != 0)
					{
						System.out.println("[�ùٸ� ��ȣ�� �Է��� �ּ���.]");
						System.out.println();
						break;
					}
					else
					{
						System.out.println();
						orderStore(food, orderby);
					}
				}
			}
			case 9: return;
			case 0: userUi.print(); return;
			default: System.out.println("[�ùٸ� ��ȣ�� �Է��� �ּ���.]"); break;
			}
		}
	}
	
	private void orderStore(int food, int orderby)
	{
		switch (orderby) 
		{
		case 1: // ������� ��
			earlyopen(food);
			break;
		case 2: // �ʰԸ��� ��
			lateclose(food);
			break;
		case 3: // ������� ��
			earlydelivery(food);
			break;
		case 4: // �������� ��
			highaverage(food);
			break;
		case 5: // ���丹�� ��
			manyreview(food);
			break;
		default:
			System.out.println("[�ùٸ� ��ȣ�� �Է��� �ּ���.]");
			break;
		}
	}
	
	private void earlyopen(int food) {
		List<Restaurant> list = rstDao.earlyopen(food);
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������");
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i+1) + " | " + list.get(i));
		}System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������");
	}
	
	private void lateclose(int food) {
		List<Restaurant> list = rstDao.lateclose(food);
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������");
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i+1) + " | " + list.get(i));
		}System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������");
	}
	
	private void earlydelivery(int food) {
		List<Restaurant> list = rstDao.earlydelivery(food);
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������");
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i+1) + " | " + list.get(i));
		}System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������");
	}
	
	private void highaverage(int food) {
		List<Restaurant> list = rstDao.highaverage(food);
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������");
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i+1) + " | " + list.get(i));
		}System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������");
	}
	
	private void manyreview(int food) {
		List<Restaurant> list = rstDao.manyreview(food);
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������");
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i+1) + " | " + list.get(i));
		}System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������");
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
