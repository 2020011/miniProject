package miniproject_1;
import java.util.ArrayList;
import java.util.List;

public class TicketInfo {
	List<Ticket> ticket = new ArrayList<Ticket>();
	
	public TicketInfo() {
		Ticket t1 = new Ticket("001", "演劇　  ", 1000,  "2020-07-07", 100);
		Ticket t2 = new Ticket("002", "演奏会 ", 2000,  "2020-06-23", 0);
		Ticket t3 = new Ticket("003", "セミナー", 1500,  "2020-10-28", 80);
		
		ticket.add(t1);
		ticket.add(t2);
		ticket.add(t3);
	}
	
	public List<Ticket> get_ticketinfo(){
		return ticket;
	}
	public boolean exist_ticket(String ticket_num) {
		boolean flag = false;
		
		for (int i = 0; i < ticket.size(); i++) {
			Ticket t = ticket.get(i);
			String t_num = t.get_ticket_num();
			if (t_num.equals(ticket_num)) {
				flag = true;
			}
		}
		return flag ;
	}
	
	public boolean check_ticket_storage(String ticket_num, int ticket_pur) {
		boolean flag = false;
		Ticket t = ticket.get(0);
		
		for (int i = 0; i < ticket.size(); i++) {
			t = ticket.get(i);
			String t_num = t.get_ticket_num();
			if (t_num.equals(ticket_num)) {
				break;
			}
		}
			
		if (t.get_ticket_storage() >= ticket_pur) {
			flag = true;
		}
			
		return flag;
	}
	
	public Ticket get_ticket(String ticket_num, int reser_num_pur) {
		Ticket t = null;
		
		for (int i = 0; i < ticket.size(); i++) {
			t = ticket.get(i);
			String t_num = t.get_ticket_num();
			if (t_num.equals(ticket_num)) {
				break;
			}
		}
		t.decrease_ticket_storage(reser_num_pur);
		//System.out.println(t.get_ticket_storage());
		return t;
	}
}