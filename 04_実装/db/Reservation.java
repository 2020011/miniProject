package miniproject_1;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Reservation {
	private int reser_num;
	private String reser_user_name;
	private String reser_name;
	private String reser_date;
	private int reser_num_pur;
	
	public Reservation(Ticket ticket,User user,int reser_num_pur) {
		this.reser_name = ticket.get_ticket_name();
		this.reser_user_name = user.get_user_name();
		this.reser_num_pur = reser_num_pur;
		this.reser_num = (int)(Math.random()*10000);
	}
	
	public int get_reser_num() {
		return reser_num;
	}
	public String get_reser_user_name() {
		return reser_user_name;
	}
	public String get_reser_name() {
		return reser_name;
	}
	public String get_reser_date() {
		Calendar date = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		reser_date = sdf.format(date.getTime());
		return reser_date;
	}
	public int get_reser_num_pur() {
		return reser_num_pur;
	}
}
