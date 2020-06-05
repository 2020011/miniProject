package miniproject_1;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.Before;
import java.util.*;

public class TicketInfoTest {
	public TicketInfo ticketinfo;
	
	@Before
	public void setUp() {
		ticketinfo = new TicketInfo();
	}
	
	@Test
	public void test_get_ticketinfo() {
		List<Ticket> ticket = ticketinfo.get_ticketinfo();
		Ticket t1 = ticket.get(0);
		Ticket t2 = ticket.get(1);
		Ticket t3 = ticket.get(2);
		
		assertThat(t1.get_ticket_num(), is("001"));
		assertThat(t1.get_ticket_name(), is("演劇　  "));
		assertThat(t1.get_ticket_price(), is(1000));
		assertThat(t1.get_ticket_date(), is("2020-07-07"));
		assertThat(t1.get_ticket_storage(), is(100));
		
		assertThat(t2.get_ticket_num(), is("002"));
		assertThat(t2.get_ticket_name(), is("演奏会 "));
		assertThat(t2.get_ticket_price(), is(2000));
		assertThat(t2.get_ticket_date(), is("2020-06-23"));
		assertThat(t2.get_ticket_storage(), is(50));
		
		assertThat(t3.get_ticket_num(), is("003"));
		assertThat(t3.get_ticket_name(), is("セミナー"));
		assertThat(t3.get_ticket_price(), is(1500));
		assertThat(t3.get_ticket_date(), is("2020-10-28"));
		assertThat(t3.get_ticket_storage(), is(80));
	}
	
	@Test
	public void test_exist_ticket_1() {
		String ticket_num ="003";
		assertThat(ticketinfo.exist_ticket(ticket_num), is(true));
	}
	
	@Test
	public void test_exist_ticket_2() {
		String ticket_num ="004";
		assertThat(ticketinfo.exist_ticket(ticket_num), is(false));
	}
	
	@Test
	public void test_check_ticket_storage_1() {
		String ticket_num ="001";
		int reser_num_pur = 50;
		assertThat(ticketinfo.check_ticket_storage(ticket_num, reser_num_pur), is(true));
	}
	
	@Test
	public void test_check_ticket_storage_2() {
		String ticket_num ="002";
		int reser_num_pur = 60;
		assertThat(ticketinfo.check_ticket_storage(ticket_num, reser_num_pur), is(false));
	}
	
	@Test
	public void test_get_ticket() {
		String ticket_num ="003";
		int reser_num_pur = 50;
		Ticket t = ticketinfo.get_ticket(ticket_num, reser_num_pur);
		assertThat(t.get_ticket_storage(), is(30));
	}

}
