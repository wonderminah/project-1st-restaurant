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
			System.out.println("式式式式式式式式式式式式式式式式式式式式式");
			System.out.println("1. 夥煎 輿僥ж晦");
			System.out.println("2. 濰夥掘棲 轎溘");
			System.out.println("3. 欽埤薄ん 跡煙"); 
			System.out.println("4. 葆橾葬雖 �挫�"); 
			System.out.println("5. 檜瞪 輿僥跡煙"); 
			System.out.println("6. 螃棺擎 凳詳雖"); 
			System.out.println("7. 擠衝薄   匐儀"); 
			System.out.println("8. 鼻嬪詭景 陛晦");
			System.out.println("9. Щ煎斜極 謙猿"); 
			System.out.println("式式式式式式式式式式式式式式式式式式式式式");
			
			//詭景 殮溘嫡晦 
			int option = option("[廓�� 殮溘 >>] ");
			System.out.println();
			
			//詭景滌煎 褒ч 
			switch (option)
			{
			case 1: cf.print(); break;     //1. 擠衝 輿僥ж晦
			case 2: bringshoppingbag(); break;
			case 3: favoriteList();break;
			case 4: mileageCheck(); break; //嘐諫撩
			case 5: getOrderList(); break;
			case 6: randomFood(); break;
			case 7: searchStore(); break; //螃盟鼻鷓
			case 8: return;
			case 9: exitprogram(); break;
			default: System.out.println("[螢夥艇 璋濠蒂 殮溘п 輿撮蹂.]");
			}
		}
	}
	
	//濰夥掘棲 轎溘
	private void bringshoppingbag()
	{
		List<Shoppingbag> sbList = rstDao.bringshoppingbag();
		if (sbList.size() == 0)
		{
			System.out.println("[濰夥掘棲 跡煙檜 橈蝗棲棻.]"); System.out.println();
		}
		else
		{
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			for (Shoppingbag sb : sbList)
			{
				System.out.println(sb);
			}
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			
			System.out.println("[1. 輿僥鏃模, 2. 夥煎輿僥, 3. 鼻嬪詭景]");
			int option = option("[廓�� 殮溘 >>] ");
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
		System.out.println("[鏃模й 輿僥廓�ㄧ� 殮溘ж撮蹂.]");
		int ordernum = option("[廓�� 殮溘 >>] ");
		
		int result = rstDao.cancelorder(ordernum);
		if (result > 0)
		{
			System.out.println("[輿僥 鏃模陛 諫猿腎歷蝗棲棻.]");
		}
		else
		{
			System.out.println("[輿僥 鏃模縑 褒ぬж艘蝗棲棻.]");
		}
	}
	
	//欽埤薄ん 跡煙
	private void favoriteList()
	{
		List<FavoriteList> fvList = rstDao.getfavoritelist();
		if (fvList.size() > 0)
		{
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			for (int i = 0; i < fvList.size(); i++)
			{
				System.out.println((i+1) + " | " + fvList.get(i));
			}
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		}
		else
		{
			System.out.println("[欽埤 蛔煙 跡煙檜 橈蝗棲棻.]");
		}
	}
	
	//葆橾葬雖 羹觼
	private void mileageCheck()
	{
		List<Orderlist> mlList = rstDao.getorderlist();
		int mlsum = 0;
		
		//System.out.println("葆橾葬雖: " + mlList);
		if (mlList.size() == 0)
		{
			System.out.println("[瞳董脹 葆橾葬雖陛 橈蝗棲棻.]");
		}
		else
		{
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			for (int i = 0; i < mlList.size(); i++)
			{
				//鏽歲 轎溘
				System.out.println((i+1) + " | " + mlList.get(i));
				//葆橾葬雖 掘ж晦
				mlsum = mlsum + mlList.get(i).getMileage();
			}
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			System.out.println("[瞳董脹 葆橾葬雖朝 " + mlsum + "薄 殮棲棻.]");
			System.out.println();
		}
	}
	
	//檜瞪 輿僥跡煙
	private void getOrderList()
	{
		List<Orderlist> orderList = rstDao.getorderlist();
		if (orderList.size() == 0)
		{
			System.out.println("[檜瞪 輿僥跡煙檜 橈蝗棲棻.]");
		}
		else
		{
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			for (Orderlist o : orderList)
			{
				System.out.println(o);
			}
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		}
	}
	
	//螃棺擎 凳詳雖
	private void randomFood() 
	{
		Random random = new Random();

		ArrayList<String> menu = new ArrayList<String>();

		menu.add("纂鑑");
		menu.add("Я濠");
		menu.add("褶嫦");
		menu.add("爾諉");

		int num = random.nextInt(menu.size());
		System.out.println("[螃棺擎 " + menu.get(num) + " 橫集撮蹂?]");
		
		//System.out.println("剩幗: " + num);
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
	
	//擠衝薄   匐儀
	private void searchStore() 
	{
		System.out.println("[1. 擠衝薄 檜葷戲煎 匐儀 , 2.瞪�食醽ㄦ� 匐儀, 9. 鼻嬪詭景煎 犒敝]");
		System.out.print("[廓�� 殮溘 >>] ");

		int num = sc.nextInt();
		System.out.println();

		while (true)
		{
			
			switch (num) {
			case 1: // 擠衝薄 檜葷
					System.out.println("[擠衝薄 檜葷擊 殮溘п 輿撮蹂. 鼻嬪 詭景朝 9蒂 殮溘ж撮蹂.]");
					System.out.print("[檜葷 殮溘 >>] ");
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
							System.out.println("[匐儀 唸婁陛 橈蝗棲棻. 棻艇 擠衝薄擊 匐儀 п輿撮蹂.]");
							System.out.println();
						}
						else
						{
							System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
							for (int i = 0; i < list.size(); i++)
							{
								System.out.println((i+1) + " | " + list.get(i).getStorename()
														 + " | " + list.get(i).getOpenhour()
														 + " | " + list.get(i).getClosehour()
														 + " | " + list.get(i).getPhonenum());
							}
							System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
							System.out.println();
						}
					}
					break;
			case 2: // 瞪�食醽ㄦ� 匐儀
				System.out.println("[擠衝薄 瞪�食醽ㄧ� 殮溘п 輿撮蹂. 鼻嬪 詭景朝 9蒂 殮溘ж撮蹂.]");
				System.out.print("[廓�� 殮溘 >>] ");
				
				String phoneNum = null;
				try {
					phoneNum = sc.next();
					//System.out.println("phoneNum 殮溘高 菟橫螃釭?: " + phoneNum);
				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}

				if (phoneNum.equals("9")) {return;}
				else
				{
					List<Restaurant> list1 = rstDao.selectRestaurant2(phoneNum);
					if (list1.size() == 0) {
						System.out.println("[匐儀 唸婁陛 橈蝗棲棻. 棻艇 擠衝薄擊 匐儀 п輿撮蹂.]");
						System.out.println();
					}
					else
					{
						System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
						for (int i = 0; i < list1.size(); i++)
						{
							System.out.println((i+1) + " | " + list1.get(i).getStorename()
									 				 + " | " + list1.get(i).getOpenhour()
									 				 + " | " + list1.get(i).getClosehour()
									 				 + " | " + list1.get(i).getPhonenum());
						}
						System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
						System.out.println();
					}
				}
				break;
			case 9: return;
			default:
				System.out.println("[螢夥艇 廓�ㄧ� 殮溘п 輿撮蹂.]");
				System.out.println();
				break;
			}
		}
	}

	//Щ煎斜極 謙猿
	private void exitprogram()
	{
		System.out.println("[Щ煎斜極擊 謙猿ж衛啊蝗棲梱? 1. 蕨 2. 嬴棲螃]");
		int option = option("[廓�� 殮溘 >>] ");
		switch (option)
		{
		case 1: System.out.println("[Щ煎斜極擊 謙猿м棲棻.]"); System.exit(0);
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
