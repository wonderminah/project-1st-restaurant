package restaurant.vo;

public class Orderlist extends Shoppingbag
{
	/*1*/// field
	private String orderdate;
	private int mileage;
	
	/*2*/// getter and setter
	public String getOrderdate() {return orderdate;}
	public int getMileage() {return mileage;}
	
	public void setOrderdate(String orderdate) {this.orderdate = orderdate;}
	public void setMileage(int mileage) {this.mileage = mileage;}
	
	/*3*/// constructor
	public Orderlist() {}
	
	public Orderlist(String orderdate, String storename, String menuname, int amount, int price, int mileage)
	{
		super(storename, menuname, price, amount);
		this.orderdate = orderdate;
		this.mileage = mileage;
	}
	
	/*4*/// method
	public String toString()
	{
		return orderdate + " | " + super.toString() + " | " + mileage + "Á¡"; 
	}
}
