package miniproject_1;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class UserinfoTest {
	
	@Test
	public void テスト１() {
		List<User> user = new ArrayList<User>();
		UserInfo userinfo = new UserInfo();
		
		String expect = userinfo.get_user_password("inu");
		assertThat(expect, is("neko"));
	}
	
	@Test
	public void テスト2() {
		List<User> user = new ArrayList<User>();
		UserInfo userinfo = new UserInfo();
		String s = null;
		String expect = userinfo.get_user_password("saru");
		assertThat(expect, is(s));
	}
	
	@Test
	public void テスト3() {
		List<User> user = new ArrayList<User>();
		UserInfo userinfo = new UserInfo();
		User u1 = new User("柴犬","inu","neko");
		User expect = userinfo.get_user("inu");
		assertThat(expect.get_user_name(), is("柴犬"));
		assertThat(expect.get_user_password(), is("neko"));
		assertThat(expect.get_user_id(), is("inu"));
	}
}
