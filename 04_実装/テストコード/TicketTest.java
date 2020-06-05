package miniproject_1;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class TicketTest {
	Ticket ticket;
	
	@Before
	public void setup() {
		ticket = new Ticket("001","演劇",1500,"2020-07-07",100);
	}
	
	@Test
	public void test1(){
		assertThat(ticket.get_ticket_num(),is("001"));
	}
	
	@Test
	public void test2(){
		assertThat(ticket.get_ticket_name(),is("演劇"));
	}
	
	@Test
	public void test3(){
		assertThat(ticket.get_ticket_price(),is(1500));
	}
	
	@Test
	public void test4(){
		assertThat(ticket.get_ticket_date(),is("2020-07-07"));
	}
	
	@Test
	public void test5(){
		assertThat(ticket.get_ticket_storage(),is(100));
	}
	
	@Test
	public void test6(){
		ticket.decrease_ticket_storage(10);
		assertThat(ticket.get_ticket_storage(),is(90));
	}
}
