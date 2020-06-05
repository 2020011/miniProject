package miniproject_1;

public class Ticket {
	private String ticket_num;
	private String ticket_name;
	private int ticket_price;
	private String ticket_date;
	private int ticket_storage;
	
	public Ticket(String ticket_num,String ticket_name,
			int ticket_price,String ticket_date,int ticket_storage){
		this.ticket_num=ticket_num;
		this.ticket_name=ticket_name;
		this.ticket_price=ticket_price;
		this.ticket_date=ticket_date;
		this.ticket_storage=ticket_storage;
	}
	
	public void decrease_ticket_storage(int reser_num_pur){
		ticket_storage=ticket_storage-reser_num_pur;
	}
	
	public String get_ticket_num() {
		return ticket_num;
	}
	public String get_ticket_name() {
		return ticket_name;
	}
	public int get_ticket_price() {
		return ticket_price;
	}
	public String get_ticket_date() {
		return ticket_date;
	}
	public int get_ticket_storage() {
		return ticket_storage;
	}
}
