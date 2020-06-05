package miniproject_1;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import miniproject_1.Ticket;
import miniproject_1.User;

public class RecervationTest {
	User user;
	Ticket ticket;
	Reservation reser;
	
	@Before
	public void setup() {
		user = new User("柴犬","inu","neko");
		ticket = new Ticket("001","演劇",1500,"2020-07-07",100);
		reser = new Reservation(ticket, user, 10);
	}
	
	@Test
	public void test1() {
		String ticket_name = reser.get_reser_name();
		assertThat(ticket_name,is("演劇"));
	}
	
	@Test
	public void test2() {
		String user_name = reser.get_reser_user_name();
		assertThat(user_name,is("柴犬"));
	}
	
}
