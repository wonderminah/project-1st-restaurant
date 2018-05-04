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
			System.out.println("─────────────────────");
			System.out.println("1. 메뉴 보기");
			System.out.println("2. 리뷰 보기");
			System.out.println("3. 리뷰 등록");
			System.out.println("4. 단골 등록");
			System.out.println("9. 상위 메뉴");
			System.out.println("0. 처음 으로");
			System.out.println("─────────────────────");
			int option = option("(번호 입력 >>) ");
			System.out.println();
			
			storeList = rstDao.getStoreList(food);
			String storename = null; 
			switch(store)
			{
			case 1: storename = storeList.get(0).getStorename(); break; //첫번째 점포명
			case 2: storename = storeList.get(1).getStorename(); break; //두번째 점포명
			case 3: storename = storeList.get(2).getStorename(); break; //세번째 점포명
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
		//System.out.println("스토어네임 들어오나? " + storename);
		List<Review> reviewlist = rstDao.getReviewList(storename);
		//System.out.println("리뷰리스트 들어오나? " + reviewlist);
		
		//해당 점포의 리뷰 출력
		System.out.println();
		System.out.println("───────────────────────────────────────────────────────────────────");
		for (int i = 0; i < reviewlist.size(); i++) 
		{
			if(reviewlist.get(i).getStorename().equals(storename)) 
			{
				System.out.println((i+1) + " | " + reviewlist.get(i));
			}
		}
		System.out.println("───────────────────────────────────────────────────────────────────");
	}
	
	private void writeReview(String storename)
	{
		int option = option("[리뷰를 남기시겠습니까? 1. 예 2. 아니오 >>] ");
		switch (option)
		{
		case 1: 
		{
			while (true)
			{
				try
				{
					System.out.print("[닉네임을 입력해주세요 >>] ");
					String nickname = sc.next();
					System.out.print("[평점을   입력해주세요 >>] ");
					int grade = sc.nextInt();
					System.out.print("[내용을   입력해주세요 >>] ");
					String text = sc.next();
					
					Review r = new Review();
					r.setNickname(nickname);
					r.setGrade(grade);
					r.setStorename(storename);
					r.setText(text);
					
					int result = rstDao.writeReview(r);
					if (result > 0)
					{
						System.out.println("[리뷰 등록에 성공하였습니다.]");
						System.out.println();
						return;
					}
					else
					{
						System.out.println("[리뷰 등록에 실패하였습니다.]");
						System.out.println();
					}
				}
				catch (Exception e)
				{
					System.out.println("[올바른 값을 입력해 주세요]");
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
				System.out.println("───────────────────────────────────────────────────────────────────");
				System.out.println(storeList.get(i));
				System.out.println("───────────────────────────────────────────────────────────────────");
				int result = rstDao.addtofavorite(storeList.get(i));
				if (result > 0)
				{
					System.out.println("단골 등록이 완료되었습니다.");
				}
				else
				{
					System.out.println("단골 등록에 실패하였습니다.");
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
