package miniproject_1;
import java.util.*;

public class ReservationInfo {
	private List<Reservation> reservation;
	
	public ReservationInfo(){
		this.reservation  = new ArrayList<Reservation>();
	}
	
	public void set_reservation(User user,Ticket ticket ,int num) {
		Reservation reservations = new Reservation(ticket,user,num);
		for(Reservation reser: this.reservation) {
			if(reser.get_reser_num() == reservations.get_reser_num()) {
				this.set_reservation(user, ticket, num);
			}
		}
		this.reservation.add(reservations);
	}
	
	public List<Reservation> get_reservation() {
		return this.reservation;
	}
}
