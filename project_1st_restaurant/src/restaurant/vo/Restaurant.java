package restaurant.vo;

public class Restaurant
{
	/*1*/// field
	private int id;           //ID
	private int foodtype;     //��������
	private String storename; //������
	private String openhour;  //���½ð� 
	private String closehour; //�����ð� 
	private String phonenum;  //��ȭ��ȣ 
	private int minorder;     //�ּ��ֹ��ݾ� 
	private int requiredtime; //�ҿ�ð� 
	private int grade;        //���� 
	private int reviewnum;    //���䰳�� 
	
	/*2*/// getter and setter 
	public int getID() {return id;}
	public int getFoodtype() {return foodtype;}
	public String getStorename() {return storename;}
	public String getOpenhour() {return openhour;}
	public String getClosehour() {return closehour;}
	public String getPhonenum() {return phonenum;}
	public int getMinorder() {return minorder;}
	public int getRequiredtime() {return requiredtime;}
	public int getGrade() {return grade;}
	public int getReviewnum() {return reviewnum;}
	
	public void setID(int id) {this.id = id;}
	public void setFoodtype(int foodtype) {this.foodtype = foodtype;}
	public void setStorename(String storename) {this.storename = storename;}
	public void setOpenhour(String openhour) {this.openhour = openhour;}
	public void setClosehour(String closehour) {this.closehour = closehour;}
	public void setPhonenum(String phonenum) {this.phonenum = phonenum;}
	public void setMinorder(int minorder){this.minorder = minorder;}
	public void setRequiredtime(int requiredtime) {this.requiredtime = requiredtime;}
	public void setGrade(int grade) {this.grade = grade;}
	public void setReviewnum(int reviewnum) {this.reviewnum = reviewnum;}
	
	/*3*/// constructor
	public Restaurant() {}
	public Restaurant(int id, String storename, String openhour, String closehour, String phonenum, int minorder, int requiredtime, int grade, int reviewnum)
	{
		this.id = id;
		this.storename = storename;
		this.openhour = openhour;
		this.closehour = closehour;
		this.phonenum = phonenum;
		this.minorder = minorder;
		this.requiredtime = requiredtime;
		this.grade = grade;
		this.reviewnum = reviewnum;
	}
	/*4*/// method
	@Override
	public String toString()
	{
		return  //foodtype   + " | " +
				storename 	 + "\t| " +
				openhour 	 + " | " +
				closehour 	 + " | " +
				phonenum 	 + " | " +
				minorder 	 + "�� | " +
				requiredtime + "�� | " +
				grade 		 + "�� | " +
				reviewnum	 + "��";
	}
}
