package miniproject_1;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class ReservationInfoTest {
	ReservationInfo reservationInfo;
	
	
	@Before
	public void setup() {
		reservationInfo = new ReservationInfo();
	}
	
	@Test
	public void test1() {
		int num = 20;
		User user = new User("柴犬","inu","neko");
		Ticket ticket = new Ticket("001","演劇",1500,"2020-07-07",100);
		this.reservationInfo.set_reservation(user, ticket, num);
		List<Reservation> reservation= new ArrayList<Reservation>();
		reservation.addAll(this.reservationInfo.get_reservation());
		
		assertThat(reservation.get(0).get_reser_user_name(),is("柴犬"));
		assertThat(reservation.get(0).get_reser_name(),is("演劇"));
		assertThat(reservation.get(0).get_reser_date(),is("2020-06-05"));
		assertThat(reservation.get(0).get_reser_num_pur(),is(num));
		
		
	}
	
	@Test
	public void test2() {
		User user1 = new User("柴犬","inu","neko");
		Ticket ticket1 = new Ticket("001","演劇",1500,"2020-07-07",100);
		Ticket ticket2 = new Ticket("002","演奏会",2000,"2020-06-23",50);
		
		this.reservationInfo.set_reservation(user1, ticket1, 20);
		this.reservationInfo.set_reservation(user1, ticket2, 10);
		List<Reservation> reservation= new ArrayList<Reservation>();
		reservation.addAll(this.reservationInfo.get_reservation());
		
		assertThat(reservation.get(0).get_reser_user_name(),is("柴犬"));
		assertThat(reservation.get(0).get_reser_name(),is("演劇"));
		assertThat(reservation.get(0).get_reser_date(),is("2020-06-05"));
		assertThat(reservation.get(0).get_reser_num_pur(),is(20));
		
		assertThat(reservation.get(1).get_reser_user_name(),is("柴犬"));
		assertThat(reservation.get(1).get_reser_name(),is("演奏会"));
		assertThat(reservation.get(1).get_reser_date(),is("2020-06-05"));
		assertThat(reservation.get(1).get_reser_num_pur(),is(10));
	}
	
	@Test
	public void test3() {
		User user1 = new User("柴犬","inu","neko");
		Ticket ticket1 = new Ticket("001","演劇",1500,"2020-07-07",100);
		Ticket ticket2 = new Ticket("002","演奏会",2000,"2020-06-23",50);
		Ticket ticket3 = new Ticket("003","セミナ-",1000,"2020-10-28",80);
		
		this.reservationInfo.set_reservation(user1, ticket1, 20);
		this.reservationInfo.set_reservation(user1, ticket2, 10);
		this.reservationInfo.set_reservation(user1, ticket3, 15);
		List<Reservation> reservation= new ArrayList<Reservation>();
		reservation.addAll(this.reservationInfo.get_reservation());
		
		assertThat(reservation.get(0).get_reser_user_name(),is("柴犬"));
		assertThat(reservation.get(0).get_reser_name(),is("演劇"));
		assertThat(reservation.get(0).get_reser_date(),is("2020-06-05"));
		assertThat(reservation.get(0).get_reser_num_pur(),is(20));
		
		assertThat(reservation.get(1).get_reser_user_name(),is("柴犬"));
		assertThat(reservation.get(1).get_reser_name(),is("演奏会"));
		assertThat(reservation.get(1).get_reser_date(),is("2020-06-05"));
		assertThat(reservation.get(1).get_reser_num_pur(),is(10));
		
		assertThat(reservation.get(2).get_reser_user_name(),is("柴犬"));
		assertThat(reservation.get(2).get_reser_name(),is("セミナ-"));
		assertThat(reservation.get(2).get_reser_date(),is("2020-06-05"));
		assertThat(reservation.get(2).get_reser_num_pur(),is(15));
	}
}
