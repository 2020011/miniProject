package miniproject_1;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class UserTest {

	User user;
	
	@Before
	public void setup() {
		user = new User("柴犬","inu","neko");
	}
	
	@Test
	public void test1() {
		assertThat(user.get_user_name(),is("柴犬"));
	}
	
	@Test
	public void test2() {
		assertThat(user.get_user_id(),is("inu"));
	}
	
	@Test
	public void test3() {
		assertThat(user.get_user_password(),is("neko"));
	}
	
}
