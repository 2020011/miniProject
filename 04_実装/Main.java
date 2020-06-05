package miniproject_1;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		UI ui = new UI();
		ReservationInfo reservationInfo = new ReservationInfo();
		UserInfo userinfo = new UserInfo();
		TicketInfo ticketinfo = new TicketInfo();
		ReservationSystem reservationsystem = new ReservationSystem(ui,reservationInfo,userinfo,ticketinfo);
		
		reservationsystem.start();
	}

}
