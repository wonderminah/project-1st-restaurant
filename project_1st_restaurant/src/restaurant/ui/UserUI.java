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
			System.out.println("������������������������������������������");
			System.out.println("1. �ٷ� �ֹ��ϱ�");
			System.out.println("2. ��ٱ��� ���");
			System.out.println("3. �ܰ����� ���"); 
			System.out.println("4. ���ϸ��� Ȯ��"); 
			System.out.println("5. ���� �ֹ����"); 
			System.out.println("6. ������ ������"); 
			System.out.println("7. ������   �˻�"); 
			System.out.println("8. �����޴� ����");
			System.out.println("9. ���α׷� ����"); 
			System.out.println("������������������������������������������");
			
			//�޴� �Է¹ޱ� 
			int option = option("[��ȣ �Է� >>] ");
			System.out.println();
			
			//�޴����� ���� 
			switch (option)
			{
			case 1: cf.print(); break;     //1. ���� �ֹ��ϱ�
			case 2: bringshoppingbag(); break;
			case 3: favoriteList();break;
			case 4: mileageCheck(); break; //�̿ϼ�
			case 5: getOrderList(); break;
			case 6: randomFood(); break;
			case 7: searchStore(); break; //��������
			case 8: return;
			case 9: exitprogram(); break;
			default: System.out.println("[�ùٸ� ���ڸ� �Է��� �ּ���.]");
			}
		}
	}
	
	//��ٱ��� ���
	private void bringshoppingbag()
	{
		List<Shoppingbag> sbList = rstDao.bringshoppingbag();
		if (sbList.size() == 0)
		{
			System.out.println("[��ٱ��� ����� �����ϴ�.]"); System.out.println();
		}
		else
		{
			System.out.println("����������������������������������������������������������������������������������������������");
			for (Shoppingbag sb : sbList)
			{
				System.out.println(sb);
			}
			System.out.println("����������������������������������������������������������������������������������������������");
			
			System.out.println("[1. �ֹ����, 2. �ٷ��ֹ�, 3. �����޴�]");
			int option = option("[��ȣ �Է� >>] ");
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
		System.out.println("[����� �ֹ���ȣ�� �Է��ϼ���.]");
		int ordernum = option("[��ȣ �Է� >>] ");
		
		int result = rstDao.cancelorder(ordernum);
		if (result > 0)
		{
			System.out.println("[�ֹ� ��Ұ� �Ϸ�Ǿ����ϴ�.]");
		}
		else
		{
			System.out.println("[�ֹ� ��ҿ� �����Ͽ����ϴ�.]");
		}
	}
	
	//�ܰ����� ���
	private void favoriteList()
	{
		List<FavoriteList> fvList = rstDao.getfavoritelist();
		if (fvList.size() > 0)
		{
			System.out.println("������������������������������������������������������������������������������������������������������������������������");
			for (int i = 0; i < fvList.size(); i++)
			{
				System.out.println((i+1) + " | " + fvList.get(i));
			}
			System.out.println("������������������������������������������������������������������������������������������������������������������������");
		}
		else
		{
			System.out.println("[�ܰ� ��� ����� �����ϴ�.]");
		}
	}
	
	//���ϸ��� üũ
	private void mileageCheck()
	{
		List<Orderlist> mlList = rstDao.getorderlist();
		int mlsum = 0;
		
		//System.out.println("���ϸ���: " + mlList);
		if (mlList.size() == 0)
		{
			System.out.println("[������ ���ϸ����� �����ϴ�.]");
		}
		else
		{
			System.out.println("������������������������������������������������������������������������������������������������������������������������������");
			for (int i = 0; i < mlList.size(); i++)
			{
				//�÷� ���
				System.out.println((i+1) + " | " + mlList.get(i));
				//���ϸ��� ���ϱ�
				mlsum = mlsum + mlList.get(i).getMileage();
			}
			System.out.println("������������������������������������������������������������������������������������������������������������������������������");
			System.out.println("[������ ���ϸ����� " + mlsum + "�� �Դϴ�.]");
			System.out.println();
		}
	}
	
	//���� �ֹ����
	private void getOrderList()
	{
		List<Orderlist> orderList = rstDao.getorderlist();
		if (orderList.size() == 0)
		{
			System.out.println("[���� �ֹ������ �����ϴ�.]");
		}
		else
		{
			System.out.println("����������������������������������������������������������������������������������������������������������������������������������������");
			for (Orderlist o : orderList)
			{
				System.out.println(o);
			}
			System.out.println("����������������������������������������������������������������������������������������������������������������������������������������");
		}
	}
	
	//������ ������
	private void randomFood() 
	{
		Random random = new Random();

		ArrayList<String> menu = new ArrayList<String>();

		menu.add("ġŲ");
		menu.add("����");
		menu.add("����");
		menu.add("����");

		int num = random.nextInt(menu.size());
		System.out.println("[������ " + menu.get(num) + " �����?]");
		
		//System.out.println("�ѹ�: " + num);
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
	
	//������   �˻�
	private void searchStore() 
	{
		System.out.println("[1. ������ �̸����� �˻� , 2.��ȭ��ȣ�� �˻�, 9. �����޴��� ����]");
		System.out.print("[��ȣ �Է� >>] ");

		int num = sc.nextInt();
		System.out.println();

		while (true)
		{
			
			switch (num) {
			case 1: // ������ �̸�
					System.out.println("[������ �̸��� �Է��� �ּ���. ���� �޴��� 9�� �Է��ϼ���.]");
					System.out.print("[�̸� �Է� >>] ");
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
							System.out.println("[�˻� ����� �����ϴ�. �ٸ� �������� �˻� ���ּ���.]");
							System.out.println();
						}
						else
						{
							System.out.println("��������������������������������������������������������������������������������������������������������������");
							for (int i = 0; i < list.size(); i++)
							{
								System.out.println((i+1) + " | " + list.get(i).getStorename()
														 + " | " + list.get(i).getOpenhour()
														 + " | " + list.get(i).getClosehour()
														 + " | " + list.get(i).getPhonenum());
							}
							System.out.println("��������������������������������������������������������������������������������������������������������������");
							System.out.println();
						}
					}
					break;
			case 2: // ��ȭ��ȣ�� �˻�
				System.out.println("[������ ��ȭ��ȣ�� �Է��� �ּ���. ���� �޴��� 9�� �Է��ϼ���.]");
				System.out.print("[��ȣ �Է� >>] ");
				
				String phoneNum = null;
				try {
					phoneNum = sc.next();
					//System.out.println("phoneNum �Է°� ������?: " + phoneNum);
				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}

				if (phoneNum.equals("9")) {return;}
				else
				{
					List<Restaurant> list1 = rstDao.selectRestaurant2(phoneNum);
					if (list1.size() == 0) {
						System.out.println("[�˻� ����� �����ϴ�. �ٸ� �������� �˻� ���ּ���.]");
						System.out.println();
					}
					else
					{
						System.out.println("��������������������������������������������������������������������������������������������������������������");
						for (int i = 0; i < list1.size(); i++)
						{
							System.out.println((i+1) + " | " + list1.get(i).getStorename()
									 				 + " | " + list1.get(i).getOpenhour()
									 				 + " | " + list1.get(i).getClosehour()
									 				 + " | " + list1.get(i).getPhonenum());
						}
						System.out.println("��������������������������������������������������������������������������������������������������������������");
						System.out.println();
					}
				}
				break;
			case 9: return;
			default:
				System.out.println("[�ùٸ� ��ȣ�� �Է��� �ּ���.]");
				System.out.println();
				break;
			}
		}
	}

	//���α׷� ����
	private void exitprogram()
	{
		System.out.println("[���α׷��� �����Ͻðڽ��ϱ�? 1. �� 2. �ƴϿ�]");
		int option = option("[��ȣ �Է� >>] ");
		switch (option)
		{
		case 1: System.out.println("[���α׷��� �����մϴ�.]"); System.exit(0);
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
