package restaurant.vo;

public class Login {
	
	private String id; //아이디
	private String pw; //비밀번호
	
	public Login() {}

	public Login(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", pw=" + pw + "]";
	}
}