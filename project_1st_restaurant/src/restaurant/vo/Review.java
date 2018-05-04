package restaurant.vo;

public class Review 
{
	/*1*/// field
	private int id;
	private String nickname;
	private String storename;
	private int grade;
	private String text;

	/*2*/// getter and setter
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getNickname() {return nickname;}
	public void setNickname(String nickname) {this.nickname = nickname;}
	public String getStorename() {return storename;}
	public void setStorename(String storename) {this.storename = storename;}
	public String getText() {return text;}
	public void setText(String text) {this.text = text;}
	public int getGrade() {return grade;}
	public void setGrade(int grade) {this.grade = grade;}
	
	/*3*/// constructor
	public Review() 
	{
		
	}

	public Review(int id, String nickname, String storename, String text) 
	{
		this.id = id;
		this.nickname = nickname;
		this.storename = storename;
		this.grade = grade;
		this.text = text;
	}

	/*4*/// method
	@Override
	public String toString() 
	{
		return //id + " | " + 
			   storename + " | " + 
		       nickname + "\t| " + 
			   grade + "Á¡ | " +
			   text;
	}

}