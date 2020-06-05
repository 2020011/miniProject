package miniproject_1;

import java.util.ArrayList;
import java.util.List;

public class UserInfo {

	private List<User> user = new ArrayList<User>();
	
	public UserInfo() {
		User u1 = new User("柴犬","inu","neko");
		User u2 = new User("シマウマ","uma","shika");
		User u3 = new User("白クマ","panda","kuma");
		user.add(u1);
		user.add(u2);
		user.add(u3);
	}
	
	
	public User get_user(String id) {
		User u = null;
		
		for (int i = 0; i < user.size(); i++) {
			if (user.get(i).get_user_id().equals(id)) {
				u = user.get(i);
				break;
			}
		}
		return u;
	}
	
	public String get_user_password(String id) {
		String s = null;
		
		for (int i = 0; i < user.size(); i++) {
			if (user.get(i).get_user_id().equals(id)) {
				s = user.get(i).get_user_password();
				break;
			}
		}
		return s;
	}
}
