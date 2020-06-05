package miniproject_1;

public class User {
	private String user_name;
	private String user_id;
	private String user_password;
	
	public User(String user_name,String user_id,String user_password) {
		this.user_name=user_name;
		this.user_id=user_id;
		this.user_password=user_password;
	}
	public String get_user_id() {
		return user_id;
	}
	public String get_user_password() {
		return user_password;
	}
	public String get_user_name() {
		return user_name;
	}
}
