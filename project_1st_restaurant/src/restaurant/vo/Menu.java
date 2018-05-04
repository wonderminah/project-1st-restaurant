package restaurant.vo;

public class Menu 
{
	/*1*/// field
	private int id;
	private String storename;
	private String menuname;
	private int price;
	
	/*2*/// getter and setter
	public int getId() {return id;}
	public String getStorename() {return storename;}
	public String getMenuname() {return menuname;}
	public int getPrice() {return price;}
	
	public void setId(int id) {this.id = id;}
	public void setStorename(String storename) {this.storename = storename;}
	public void setMenuname(String menuname) {this.menuname = menuname;}
	public void setPrice(int price) {this.price = price;}
	
	/*3*/// constructor
	public Menu() {}
	public Menu(String storename, String menuname, int price)
	{
		this.storename = storename;
		this.menuname = menuname;
		this.price = price;
	}
	public Menu(int id, String storename, String menuname, int price)
	{
		this.id = id;
		this.storename = storename;
		this.menuname = menuname;
		this.price = price;
	}
	
	/*4*/// method
	@Override
	public String toString()
	{
		return storename + " | " + menuname + " | " + price + "¿ø";
	}
	

}
