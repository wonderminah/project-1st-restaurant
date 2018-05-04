package restaurant.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import restaurant.dao.RestaurantDAO;
import restaurant.vo.FavoriteList;
import restaurant.vo.Orderlist;
import restaurant.vo.Restaurant;
import restaurant.vo.Shoppingbag;

public class UserUI
{
	Scanner sc = new Scanner(System.in);
	RestaurantDAO rstDao = new RestaurantDAO();
	ChoiceFood cf = new ChoiceFood();
	
	public UserUI() {}
	
	public void print() 
	{
		while (true)
		{
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
			System.out.println("1. ¹Ù·Î ÁÖ¹®ÇÏ±â");
			System.out.println("2. Àå¹Ù±¸´Ï Ãâ·Â");
			System.out.println("3. ´Ü°ñÁ¡Æ÷ ¸ñ·Ï"); 
			System.out.println("4. ¸¶ÀÏ¸®Áö È®ÀÎ"); 
			System.out.println("5. ÀÌÀü ÁÖ¹®¸ñ·Ï"); 
			System.out.println("6. ¿À´ÃÀº ¹¹¸ÔÁö"); 
			System.out.println("7. À½½ÄÁ¡   °Ë»ö"); 
			System.out.println("8. »óÀ§¸Þ´º °¡±â");
			System.out.println("9. ÇÁ·Î±×·¥ Á¾·á"); 
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
			
			//¸Þ´º ÀÔ·Â¹Þ±â 
			int option = option("[¹øÈ£ ÀÔ·Â >>] ");
			System.out.println();
			
			//¸Þ´ºº°·Î ½ÇÇà 
			switch (option)
			{
			case 1: cf.print(); break;     //1. À½½Ä ÁÖ¹®ÇÏ±â
			case 2: bringshoppingbag(); break;
			case 3: favoriteList();break;
			case 4: mileageCheck(); break; //¹Ì¿Ï¼º
			case 5: getOrderList(); break;
			case 6: randomFood(); break;
			case 7: searchStore(); break; //¿À·ù»óÅÂ
			case 8: return;
			case 9: exitprogram(); break;
			default: System.out.println("[¿Ã¹Ù¸¥ ¼ýÀÚ¸¦ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.]");
			}
		}
	}
	
	//Àå¹Ù±¸´Ï Ãâ·Â
	private void bringshoppingbag()
	{
		List<Shoppingbag> sbList = rstDao.bringshoppingbag();
		if (sbList.size() == 0)
		{
			System.out.println("[Àå¹Ù±¸´Ï ¸ñ·ÏÀÌ ¾ø½À´Ï´Ù.]"); System.out.println();
		}
		else
		{
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
			for (Shoppingbag sb : sbList)
			{
				System.out.println(sb);
			}
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
			
			System.out.println("[1. ÁÖ¹®Ãë¼Ò, 2. ¹Ù·ÎÁÖ¹®, 3. »óÀ§¸Þ´º]");
			int option = option("[¹øÈ£ ÀÔ·Â >>] ");
			System.out.println();
			
			switch (option)
			{
			case 1: cancelorder(); break;
			case 2: break;
			case 3: return;
			}
		}
	}
	
	private void cancelorder()
	{
		System.out.println("[Ãë¼ÒÇÒ ÁÖ¹®¹øÈ£¸¦ ÀÔ·ÂÇÏ¼¼¿ä.]");
		int ordernum = option("[¹øÈ£ ÀÔ·Â >>] ");
		
		int result = rstDao.cancelorder(ordernum);
		if (result > 0)
		{
			System.out.println("[ÁÖ¹® Ãë¼Ò°¡ ¿Ï·áµÇ¾ú½À´Ï´Ù.]");
		}
		else
		{
			System.out.println("[ÁÖ¹® Ãë¼Ò¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.]");
		}
	}
	
	//´Ü°ñÁ¡Æ÷ ¸ñ·Ï
	private void favoriteList()
	{
		List<FavoriteList> fvList = rstDao.getfavoritelist();
		if (fvList.size() > 0)
		{
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
			for (int i = 0; i < fvList.size(); i++)
			{
				System.out.println((i+1) + " | " + fvList.get(i));
			}
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		}
		else
		{
			System.out.println("[´Ü°ñ µî·Ï ¸ñ·ÏÀÌ ¾ø½À´Ï´Ù.]");
		}
	}
	
	//¸¶ÀÏ¸®Áö Ã¼Å©
	private void mileageCheck()
	{
		List<Orderlist> mlList = rstDao.getorderlist();
		int mlsum = 0;
		
		//System.out.println("¸¶ÀÏ¸®Áö: " + mlList);
		if (mlList.size() == 0)
		{
			System.out.println("[Àû¸³µÈ ¸¶ÀÏ¸®Áö°¡ ¾ø½À´Ï´Ù.]");
		}
		else
		{
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
			for (int i = 0; i < mlList.size(); i++)
			{
				//ÄÃ·³ Ãâ·Â
				System.out.println((i+1) + " | " + mlList.get(i));
				//¸¶ÀÏ¸®Áö ±¸ÇÏ±â
				mlsum = mlsum + mlList.get(i).getMileage();
			}
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
			System.out.println("[Àû¸³µÈ ¸¶ÀÏ¸®Áö´Â " + mlsum + "Á¡ ÀÔ´Ï´Ù.]");
			System.out.println();
		}
	}
	
	//ÀÌÀü ÁÖ¹®¸ñ·Ï
	private void getOrderList()
	{
		List<Orderlist> orderList = rstDao.getorderlist();
		if (orderList.size() == 0)
		{
			System.out.println("[ÀÌÀü ÁÖ¹®¸ñ·ÏÀÌ ¾ø½À´Ï´Ù.]");
		}
		else
		{
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
			for (Orderlist o : orderList)
			{
				System.out.println(o);
			}
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		}
	}
	
	//¿À´ÃÀº ¹¹¸ÔÁö
	private void randomFood() 
	{
		Random random = new Random();

		ArrayList<String> menu = new ArrayList<String>();

		menu.add("Ä¡Å²");
		menu.add("ÇÇÀÚ");
		menu.add("Á·¹ß");
		menu.add("º¸½Ó");

		int num = random.nextInt(menu.size());
		System.out.println("[¿À´ÃÀº " + menu.get(num) + " ¾î¶°¼¼¿ä?]");
		
		//System.out.println("³Ñ¹ö: " + num);
		//System.out.println(num+1);
		
		ChoiceStore cs = new ChoiceStore();
		switch (num)
		{
		case 1: cs.print(num+1); break;
		case 2: cs.print(num+1); break;
		case 3: cs.print(num+1); break;
		case 4: cs.print(num+1); break;
		}
		
		menu.remove(num);
	}
	
	//À½½ÄÁ¡   °Ë»ö
	private void searchStore() 
	{
		System.out.println("[1. À½½ÄÁ¡ ÀÌ¸§À¸·Î °Ë»ö , 2.ÀüÈ­¹øÈ£·Î °Ë»ö, 9. »óÀ§¸Þ´º·Î º¹±Í]");
		System.out.print("[¹øÈ£ ÀÔ·Â >>] ");

		int num = sc.nextInt();
		System.out.println();

		while (true)
		{
			
			switch (num) {
			case 1: // À½½ÄÁ¡ ÀÌ¸§
					System.out.println("[À½½ÄÁ¡ ÀÌ¸§À» ÀÔ·ÂÇØ ÁÖ¼¼¿ä. »óÀ§ ¸Þ´º´Â 9¸¦ ÀÔ·ÂÇÏ¼¼¿ä.]");
					System.out.print("[ÀÌ¸§ ÀÔ·Â >>] ");
					String store = null;
					try 
					{
						store = sc.next();
					} 
					catch (Exception e) 
					{
						e.printStackTrace();
						sc.nextLine();
					}
		
					if (store.equals("9")) {return;}
					else
					{
						List<Restaurant> list = rstDao.selectRestaurant(store);
						if (list.size() == 0) 
						{
							System.out.println("[°Ë»ö °á°ú°¡ ¾ø½À´Ï´Ù. ´Ù¸¥ À½½ÄÁ¡À» °Ë»ö ÇØÁÖ¼¼¿ä.]");
							System.out.println();
						}
						else
						{
							System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
							for (int i = 0; i < list.size(); i++)
							{
								System.out.println((i+1) + " | " + list.get(i).getStorename()
														 + " | " + list.get(i).getOpenhour()
														 + " | " + list.get(i).getClosehour()
														 + " | " + list.get(i).getPhonenum());
							}
							System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
							System.out.println();
						}
					}
					break;
			case 2: // ÀüÈ­¹øÈ£·Î °Ë»ö
				System.out.println("[À½½ÄÁ¡ ÀüÈ­¹øÈ£¸¦ ÀÔ·ÂÇØ ÁÖ¼¼¿ä. »óÀ§ ¸Þ´º´Â 9¸¦ ÀÔ·ÂÇÏ¼¼¿ä.]");
				System.out.print("[¹øÈ£ ÀÔ·Â >>] ");
				
				String phoneNum = null;
				try {
					phoneNum = sc.next();
					//System.out.println("phoneNum ÀÔ·Â°ª µé¾î¿À³ª?: " + phoneNum);
				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}

				if (phoneNum.equals("9")) {return;}
				else
				{
					List<Restaurant> list1 = rstDao.selectRestaurant2(phoneNum);
					if (list1.size() == 0) {
						System.out.println("[°Ë»ö °á°ú°¡ ¾ø½À´Ï´Ù. ´Ù¸¥ À½½ÄÁ¡À» °Ë»ö ÇØÁÖ¼¼¿ä.]");
						System.out.println();
					}
					else
					{
						System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
						for (int i = 0; i < list1.size(); i++)
						{
							System.out.println((i+1) + " | " + list1.get(i).getStorename()
									 				 + " | " + list1.get(i).getOpenhour()
									 				 + " | " + list1.get(i).getClosehour()
									 				 + " | " + list1.get(i).getPhonenum());
						}
						System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
						System.out.println();
					}
				}
				break;
			case 9: return;
			default:
				System.out.println("[¿Ã¹Ù¸¥ ¹øÈ£¸¦ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.]");
				System.out.println();
				break;
			}
		}
	}

	//ÇÁ·Î±×·¥ Á¾·á
	private void exitprogram()
	{
		System.out.println("[ÇÁ·Î±×·¥À» Á¾·áÇÏ½Ã°Ú½À´Ï±î? 1. ¿¹ 2. ¾Æ´Ï¿À]");
		int option = option("[¹øÈ£ ÀÔ·Â >>] ");
		switch (option)
		{
		case 1: System.out.println("[ÇÁ·Î±×·¥À» Á¾·áÇÕ´Ï´Ù.]"); System.exit(0);
		case 2: return;
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
