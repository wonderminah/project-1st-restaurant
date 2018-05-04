package restaurant.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import restaurant.dao.RestaurantDAO;
import restaurant.vo.Restaurant;
import restaurant.vo.Review;

public class ChoiceInfo
{
	Scanner sc = new Scanner(System.in);
	ChoiceMenu cm = new ChoiceMenu();
	private RestaurantDAO rstDao = new RestaurantDAO();
	List<Restaurant> storeList = new ArrayList<>(); 
	
	public ChoiceInfo() {}
	
	public void print(int food, int store)
	{
		UserUI userUi = new UserUI();
		while (true)
		{
			System.out.println("������������������������������������������");
			System.out.println("1. �޴� ����");
			System.out.println("2. ���� ����");
			System.out.println("3. ���� ���");
			System.out.println("4. �ܰ� ���");
			System.out.println("9. ���� �޴�");
			System.out.println("0. ó�� ����");
			System.out.println("������������������������������������������");
			int option = option("(��ȣ �Է� >>) ");
			System.out.println();
			
			storeList = rstDao.getStoreList(food);
			String storename = null; 
			switch(store)
			{
			case 1: storename = storeList.get(0).getStorename(); break; //ù��° ������
			case 2: storename = storeList.get(1).getStorename(); break; //�ι�° ������
			case 3: storename = storeList.get(2).getStorename(); break; //����° ������
			}
			
			switch (option)
			{
			case 1: cm.print(food, store); break;
			case 2: reviewprint(storename); break;
			case 3: writeReview(storename); break;
			case 4: addToFavorite(storename); break;
			case 9: return;
			case 0: userUi.print(); return;
			}
		//	return foodname;
		}
	}
	
	private void reviewprint(String storename) 
	{
		//System.out.println("�������� ������? " + storename);
		List<Review> reviewlist = rstDao.getReviewList(storename);
		//System.out.println("���丮��Ʈ ������? " + reviewlist);
		
		//�ش� ������ ���� ���
		System.out.println();
		System.out.println("��������������������������������������������������������������������������������������������������������������������������������������");
		for (int i = 0; i < reviewlist.size(); i++) 
		{
			if(reviewlist.get(i).getStorename().equals(storename)) 
			{
				System.out.println((i+1) + " | " + reviewlist.get(i));
			}
		}
		System.out.println("��������������������������������������������������������������������������������������������������������������������������������������");
	}
	
	private void writeReview(String storename)
	{
		int option = option("[���並 ����ðڽ��ϱ�? 1. �� 2. �ƴϿ� >>] ");
		switch (option)
		{
		case 1: 
		{
			while (true)
			{
				try
				{
					System.out.print("[�г����� �Է����ּ��� >>] ");
					String nickname = sc.next();
					System.out.print("[������   �Է����ּ��� >>] ");
					int grade = sc.nextInt();
					System.out.print("[������   �Է����ּ��� >>] ");
					String text = sc.next();
					
					Review r = new Review();
					r.setNickname(nickname);
					r.setGrade(grade);
					r.setStorename(storename);
					r.setText(text);
					
					int result = rstDao.writeReview(r);
					if (result > 0)
					{
						System.out.println("[���� ��Ͽ� �����Ͽ����ϴ�.]");
						System.out.println();
						return;
					}
					else
					{
						System.out.println("[���� ��Ͽ� �����Ͽ����ϴ�.]");
						System.out.println();
					}
				}
				catch (Exception e)
				{
					System.out.println("[�ùٸ� ���� �Է��� �ּ���]");
					System.out.println();
					break;
				}
			}
			
			
			
			break;
		}
		case 2: return;
		}
		
	}
	
	private void addToFavorite(String storename)
	{
		for (int i = 0; i < storeList.size(); i++)
		{
			if (storeList.get(i).getStorename().equals(storename))
			{
				System.out.println("��������������������������������������������������������������������������������������������������������������������������������������");
				System.out.println(storeList.get(i));
				System.out.println("��������������������������������������������������������������������������������������������������������������������������������������");
				int result = rstDao.addtofavorite(storeList.get(i));
				if (result > 0)
				{
					System.out.println("�ܰ� ����� �Ϸ�Ǿ����ϴ�.");
				}
				else
				{
					System.out.println("�ܰ� ��Ͽ� �����Ͽ����ϴ�.");
				}
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
