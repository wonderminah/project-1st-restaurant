package restaurant.vo;

public class Shoppingbag extends Menu 
{
	/*1*/// field
	private int sbid;
	private int amount;
	
	/*2*/// getter and setter
	public int getId() {return sbid;}
	public int getAmount() {return amount;}
	
	public void setId(int id) {this.sbid = id;}
	public void setAmount(int amount) {this.amount = amount;}
	
	/*3*/// constructor
	public Shoppingbag() {}
	public Shoppingbag(String storename, String menuname, int price, int amount)
	{
		super(storename, menuname, price);
		this.amount = amount;
	}

	/*4*/// method
	@Override
	public String toString()
	{
		return sbid + " | " + super.toString() + " | " + amount + "°³ | " + (getPrice()*amount) + "¿ø";
	}
}
