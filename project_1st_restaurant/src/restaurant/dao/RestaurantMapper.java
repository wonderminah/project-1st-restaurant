package restaurant.dao;

import java.util.List;

import restaurant.vo.FavoriteList;
import restaurant.vo.Login;
import restaurant.vo.Menu;
import restaurant.vo.Orderlist;
import restaurant.vo.Restaurant;
import restaurant.vo.Review;
import restaurant.vo.Shoppingbag;

public interface RestaurantMapper
{
	//¹Î¾Æ¾¾
	List<Restaurant> getStoreList(int food);
	List<Menu> getMenuList(String storename);
	int addtoshoppingbag(Shoppingbag sb);
	List<Shoppingbag> bringshoppingbag();
	int addtofavorite(Restaurant r);
	int addtoorderlist(Orderlist ol);
	List<Orderlist> getorderlist();
	List<FavoriteList> getfavoritelist();
	
	//Á¤Çö¾¾
	List<Restaurant> selectRestaurant(String store);
	List<Restaurant> selectRestaurant2(String phoneNum);
	int modifyOrder(Shoppingbag sb);
	List<Review> getReviewList(String storename);
	int writeReview(Review r);
	List<Login> check(Login l);
	List<Orderlist> getMileageList();
	List<Restaurant> earlyopen(int food);
	List<Restaurant> lateclose(int food);
	List<Restaurant> earlydelivery(int food);
	List<Restaurant> highaverage(int food);
	List<Restaurant> manyreview(int food);
	int add(Restaurant r);
	int add2(Menu m);
	int cancelorder(int ordernum);
	
}
