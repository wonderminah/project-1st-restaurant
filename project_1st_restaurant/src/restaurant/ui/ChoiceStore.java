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
	
	public void print(int food) //optionÀº Ä¡Å²/ÇÇÀÚ/Á·¹ß/º¸½Ó
	{
		storeList = rstDao.getStoreList(food);
		//System.out.println("½ºÅä¾î¸®½ºÆ®: " + storeList);
		switch (food)
		{
		case 1: storeList = rstDao.getStoreList(food); break;
		case 2: storeList = rstDao.getStoreList(food); break;
		case 3: storeList = rstDao.getStoreList(food); break;
		case 4: storeList = rstDao.getStoreList(food); break;
		}
		
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		for (int i = 0; i < storeList.size(); i++)
		{
			System.out.println((i+1) + " | " + storeList.get(i).getStorename() + "\t| "
											 + storeList.get(i).getOpenhour()  + " | "
											 + storeList.get(i).getClosehour() + " | "
											 + storeList.get(i).getPhonenum() + " | "
											 + storeList.get(i).getMinorder() + "¿ø | "
											 + storeList.get(i).getRequiredtime() + "ºÐ | "
											 + storeList.get(i).getGrade() + "Á¡ | "
											 + storeList.get(i).getReviewnum()+ "°³");
		}
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		
		
		
		UserUI userUi = new UserUI();
		while (true)
		{
			
			System.out.println ("[1. Á¡Æ÷¼±ÅÃ, 2. Á¤·Äº¸±â, 9. »óÀ§¸Þ´º, 0. Ã³À½À¸·Î]");
			int option = option("[¹øÈ£ ÀÔ·Â >>] ");
			System.out.println();
			
			switch (option)
			{
			case 1: 
			{	
				while (true)
				{
					System.out.println("[Á¡Æ÷ ¹øÈ£¸¦ ÀÔ·ÂÇØ ÁÖ¼¼¿ä. »óÀ§ ¸Þ´º´Â 9¸¦ ÀÔ·ÂÇÏ¼¼¿ä.]");
					int store = option("[Á¡Æ÷ ¹øÈ£ >>] ");
					
					if (store == 9)
					{
						System.out.println();
						break;
					}
					else if (store > storeList.size())
					{
						System.out.println("[¿Ã¹Ù¸¥ ¹øÈ£¸¦ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.]");
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
					System.out.println("[1. ÀÏÂï¿ÀÇÂ, 2. ´Ê°Ô¸¶°¨, 3. »¡¸®¹è´Þ, 4. ÆòÁ¡³ôÀº, 5. ¸®ºä¸¹Àº]");
					System.out.println("[9. »óÀ§¸Þ´º, 0. Ã³À½À¸·Î]");
					int orderby = option("[¹øÈ£ÀÔ·Â >>] ");
									
					if (orderby == 9) {return;}
					else if (orderby == 0) {userUi.print();}
					else if (orderby != 1 & orderby != 2 & orderby != 3 & orderby != 4 & orderby != 5 & orderby != 9 & orderby != 0)
					{
						System.out.println("[¿Ã¹Ù¸¥ ¹øÈ£¸¦ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.]");
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
			default: System.out.println("[¿Ã¹Ù¸¥ ¹øÈ£¸¦ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.]"); break;
			}
		}
	}
	
	private void orderStore(int food, int orderby)
	{
		switch (orderby) 
		{
		case 1: // ÀÏÂï¿ÀÇÂ ¼ø
			earlyopen(food);
			break;
		case 2: // ´Ê°Ô¸¶°¨ ¼ø
			lateclose(food);
			break;
		case 3: // »¡¸®¹è´Þ ¼ø
			earlydelivery(food);
			break;
		case 4: // ÆòÁ¡³ôÀº ¼ø
			highaverage(food);
			break;
		case 5: // ¸®ºä¸¹Àº ¼ø
			manyreview(food);
			break;
		default:
			System.out.println("[¿Ã¹Ù¸¥ ¹øÈ£¸¦ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.]");
			break;
		}
	}
	
	private void earlyopen(int food) {
		List<Restaurant> list = rstDao.earlyopen(food);
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i+1) + " | " + list.get(i));
		}System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
	}
	
	private void lateclose(int food) {
		List<Restaurant> list = rstDao.lateclose(food);
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i+1) + " | " + list.get(i));
		}System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
	}
	
	private void earlydelivery(int food) {
		List<Restaurant> list = rstDao.earlydelivery(food);
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i+1) + " | " + list.get(i));
		}System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
	}
	
	private void highaverage(int food) {
		List<Restaurant> list = rstDao.highaverage(food);
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i+1) + " | " + list.get(i));
		}System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
	}
	
	private void manyreview(int food) {
		List<Restaurant> list = rstDao.manyreview(food);
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i+1) + " | " + list.get(i));
		}System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
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
