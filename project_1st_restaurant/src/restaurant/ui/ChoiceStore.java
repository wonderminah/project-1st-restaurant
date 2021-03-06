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
	
	public void print(int food) //option擎 纂鑑/Я濠/褶嫦/爾諉
	{
		storeList = rstDao.getStoreList(food);
		//System.out.println("蝶饜橫葬蝶お: " + storeList);
		switch (food)
		{
		case 1: storeList = rstDao.getStoreList(food); break;
		case 2: storeList = rstDao.getStoreList(food); break;
		case 3: storeList = rstDao.getStoreList(food); break;
		case 4: storeList = rstDao.getStoreList(food); break;
		}
		
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		for (int i = 0; i < storeList.size(); i++)
		{
			System.out.println((i+1) + " | " + storeList.get(i).getStorename() + "\t| "
											 + storeList.get(i).getOpenhour()  + " | "
											 + storeList.get(i).getClosehour() + " | "
											 + storeList.get(i).getPhonenum() + " | "
											 + storeList.get(i).getMinorder() + "錳 | "
											 + storeList.get(i).getRequiredtime() + "碟 | "
											 + storeList.get(i).getGrade() + "薄 | "
											 + storeList.get(i).getReviewnum()+ "偃");
		}
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		
		
		
		UserUI userUi = new UserUI();
		while (true)
		{
			
			System.out.println ("[1. 薄ん摹鷗, 2. 薑溺爾晦, 9. 鼻嬪詭景, 0. 籀擠戲煎]");
			int option = option("[廓�� 殮溘 >>] ");
			System.out.println();
			
			switch (option)
			{
			case 1: 
			{	
				while (true)
				{
					System.out.println("[薄ん 廓�ㄧ� 殮溘п 輿撮蹂. 鼻嬪 詭景朝 9蒂 殮溘ж撮蹂.]");
					int store = option("[薄ん 廓�� >>] ");
					
					if (store == 9)
					{
						System.out.println();
						break;
					}
					else if (store > storeList.size())
					{
						System.out.println("[螢夥艇 廓�ㄧ� 殮溘п 輿撮蹂.]");
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
					System.out.println("[1. 橾鎰螃Ъ, 2. 棵啪葆馬, 3. 說葬寡殖, 4. ゎ薄堪擎, 5. 葬箔號擎]");
					System.out.println("[9. 鼻嬪詭景, 0. 籀擠戲煎]");
					int orderby = option("[廓��殮溘 >>] ");
									
					if (orderby == 9) {return;}
					else if (orderby == 0) {userUi.print();}
					else if (orderby != 1 & orderby != 2 & orderby != 3 & orderby != 4 & orderby != 5 & orderby != 9 & orderby != 0)
					{
						System.out.println("[螢夥艇 廓�ㄧ� 殮溘п 輿撮蹂.]");
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
			default: System.out.println("[螢夥艇 廓�ㄧ� 殮溘п 輿撮蹂.]"); break;
			}
		}
	}
	
	private void orderStore(int food, int orderby)
	{
		switch (orderby) 
		{
		case 1: // 橾鎰螃Ъ 牖
			earlyopen(food);
			break;
		case 2: // 棵啪葆馬 牖
			lateclose(food);
			break;
		case 3: // 說葬寡殖 牖
			earlydelivery(food);
			break;
		case 4: // ゎ薄堪擎 牖
			highaverage(food);
			break;
		case 5: // 葬箔號擎 牖
			manyreview(food);
			break;
		default:
			System.out.println("[螢夥艇 廓�ㄧ� 殮溘п 輿撮蹂.]");
			break;
		}
	}
	
	private void earlyopen(int food) {
		List<Restaurant> list = rstDao.earlyopen(food);
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i+1) + " | " + list.get(i));
		}System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
	}
	
	private void lateclose(int food) {
		List<Restaurant> list = rstDao.lateclose(food);
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i+1) + " | " + list.get(i));
		}System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
	}
	
	private void earlydelivery(int food) {
		List<Restaurant> list = rstDao.earlydelivery(food);
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i+1) + " | " + list.get(i));
		}System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
	}
	
	private void highaverage(int food) {
		List<Restaurant> list = rstDao.highaverage(food);
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i+1) + " | " + list.get(i));
		}System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
	}
	
	private void manyreview(int food) {
		List<Restaurant> list = rstDao.manyreview(food);
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i+1) + " | " + list.get(i));
		}System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
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
