package restaurant.vo;

public class FavoriteList extends Restaurant
{
	/*1*/// field : Restaurant�� �״�� ��
	private int id;
	
	/*2*/// getter and setter : Restaurant�� �״�� ��
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	
	/*3*/// constructor
	FavoriteList() {}
	
	/*4*/// method
	public String toString()
	{
		return //id + " | " + 
			   getStorename() + " | " +  
			   getOpenhour()  + " | " +  
			   getClosehour() + " | " +  
			   getPhonenum();
	}
}
