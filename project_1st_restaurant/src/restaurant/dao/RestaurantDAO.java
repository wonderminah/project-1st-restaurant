package restaurant.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import restaurant.vo.FavoriteList;
import restaurant.vo.Menu;
import restaurant.vo.Orderlist;
import restaurant.vo.Restaurant;
import restaurant.vo.Review;
import restaurant.vo.Shoppingbag;

public class RestaurantDAO
{
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	public List<Restaurant> getStoreList(int food) 
	{
		List<Restaurant> result = null;
		SqlSession session = null;
		try
		{
			session = factory.openSession();
			RestaurantMapper mapper = session.getMapper(RestaurantMapper.class);
			result = mapper.getStoreList(food);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (session != null)
			{
				session.close();
			}
		}
		return result;
	}
	
	public List<Menu> getMenuList(String storename) 
	{
		List<Menu> result = null;
		SqlSession session = null;
		try
		{
			session = factory.openSession();
			
			//System.out.println(storename.length());	// 스페이스가 2개 붙음
			
			storename = storename.trim();			    // 제거
			//System.out.println(storename.length());	// 스페이스가 사라진 문장
			
			RestaurantMapper mapper = session.getMapper(RestaurantMapper.class);
			result = mapper.getMenuList(storename);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (session != null)
			{
				session.close();
			}
		}
		return result;
	}

	public int addtoshoppingbag(Shoppingbag sb) 
	{
		SqlSession session = null;
		int result = 0;
		try
		{
			session = factory.openSession();
			RestaurantMapper mapper = session.getMapper(RestaurantMapper.class);
			result = mapper.addtoshoppingbag(sb);
			session.commit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (session != null)
			{
				session.close();
			}
		}
		return result;
	}

	public List<Shoppingbag> bringshoppingbag() 
	{
		List<Shoppingbag> result = null;
		SqlSession session = null;
		try
		{
			session = factory.openSession();
			RestaurantMapper mapper = session.getMapper(RestaurantMapper.class);
			result = mapper.bringshoppingbag();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (session != null)
			{
				session.close();
			}
		}
		return result;
	}

	public int addtofavorite(Restaurant r) 
	{
		SqlSession session = null;
		int result = 0;
		try
		{
			session = factory.openSession();
			RestaurantMapper mapper = session.getMapper(RestaurantMapper.class);
			result = mapper.addtofavorite(r);
			session.commit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (session != null)
			{
				session.close();
			}
		}
		return result;
	}

	public int addtoorderlist(Orderlist ol) 
	{
		SqlSession session = null;
		int result = 0;
		try
		{
			session = factory.openSession();
			RestaurantMapper mapper = session.getMapper(RestaurantMapper.class);
			result = mapper.addtoorderlist(ol);
			session.commit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (session != null)
			{
				session.close();
			}
		}
		return result;
	}

	public List<Orderlist> getorderlist() 
	{
		List<Orderlist> result = null;
		SqlSession session = null;
		try
		{
			session = factory.openSession();
			RestaurantMapper mapper = session.getMapper(RestaurantMapper.class);
			result = mapper.getorderlist();
			session.commit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (session != null)
			{
				session.close();
			}
		}
		return result;
	}

	public List<FavoriteList> getfavoritelist() 
	{
		List<FavoriteList> result = null;
		SqlSession session = null;
		try
		{
			session = factory.openSession();
			RestaurantMapper mapper = session.getMapper(RestaurantMapper.class);
			result = mapper.getfavoritelist();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (session != null)
			{
				session.close();
			}
		}
		return result;
	}

	// 1. 가게 이름으로 검색
	public List<Restaurant> selectRestaurant(String store) 
	{
		List<Restaurant> result = null;
		SqlSession session = null;
		try {
			session = factory.openSession();
			RestaurantMapper mapper = session.getMapper(RestaurantMapper.class);
			result = mapper.selectRestaurant(store);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;

	}

	// 2. 가게 전화번호로 검색
	public List<Restaurant> selectRestaurant2(String phoneNum) 
	{
		//System.out.println("phoneNum 입력값 들어오나?: " + phoneNum);
		List<Restaurant> result = null;
		SqlSession session = null;
		try 
		{
			session = factory.openSession();
			RestaurantMapper mapper = session.getMapper(RestaurantMapper.class);
			result = mapper.selectRestaurant2(phoneNum);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			if (session != null) 
			{
				session.close();
			}
		}
		return result;

	}

	public int modifyOrder(Shoppingbag sb)
	{
		int result = 0;
		SqlSession session = null;
		try 
		{
			session = factory.openSession();
			RestaurantMapper mapper = session.getMapper(RestaurantMapper.class);
			result = mapper.modifyOrder(sb);
			session.commit();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			if (session != null) 
			{
				session.close();
			}
		}
		return result;
	}
	public List<Review> getReviewList(String storename) 
	{
		List<Review> result = null;
		SqlSession session = null;
		try 
		{
			session = factory.openSession();
			RestaurantMapper mapper = session.getMapper(RestaurantMapper.class);
			result = mapper.getReviewList(storename);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} finally 
		{
			if (session != null) 
			{
				session.close();
			}
		}
		return result;
	}

	public int writeReview(Review r)
	{
		int result = 0;
		SqlSession session = null;
		try
		{
			session = factory.openSession();
			RestaurantMapper mapper = session.getMapper(RestaurantMapper.class);
			result = mapper.writeReview(r);
			session.commit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (session != null)
			{
				session.close();
			}
		}
		return result;
	}
	
	public List<Restaurant> earlyopen(int food) { // 일찍 오픈순
		List<Restaurant> result = null;
		SqlSession session = null;
		try {
			session = factory.openSession();
			RestaurantMapper mapper = session.getMapper(RestaurantMapper.class);
			result = mapper.earlyopen(food);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}

	public List<Restaurant> lateclose(int food) {
		List<Restaurant> result = null;
		SqlSession session = null;
		try {
			session = factory.openSession();
			RestaurantMapper mapper = session.getMapper(RestaurantMapper.class);
			result = mapper.lateclose(food);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}

	public List<Restaurant> earlydelivery(int food) {
		List<Restaurant> result = null;
		SqlSession session = null;
		try {
			session = factory.openSession();
			RestaurantMapper mapper = session.getMapper(RestaurantMapper.class);
			result = mapper.earlydelivery(food);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}

	public List<Restaurant> highaverage(int food)
	{
		List<Restaurant> result = null;
		SqlSession session = null;
		try {
			session = factory.openSession();
			RestaurantMapper mapper = session.getMapper(RestaurantMapper.class);
			result = mapper.highaverage(food);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}

	public List<Restaurant> manyreview(int food)
	{
		List<Restaurant> result = null;
		SqlSession session = null;
		try {
			session = factory.openSession();
			RestaurantMapper mapper = session.getMapper(RestaurantMapper.class);
			result = mapper.manyreview(food);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}

	public int add(Restaurant r) {
		SqlSession session = null;
		int result = 0;
		try {
			session = factory.openSession();
			RestaurantMapper mapper = session.getMapper(RestaurantMapper.class);
			result = mapper.add(r);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}
	
	public int add2(Menu m) {
		SqlSession session = null;
		int result = 0;
		try {
			session = factory.openSession();
			RestaurantMapper mapper = session.getMapper(RestaurantMapper.class);
			result = mapper.add2(m);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}

	public int cancelorder(int ordernum)
	{
		int result = 0;
		SqlSession session = null;
		try {
			session = factory.openSession();
			RestaurantMapper mapper = session.getMapper(RestaurantMapper.class);
			result = mapper.cancelorder(ordernum);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}
}
