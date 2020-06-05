package miniproject_1;
import java.util.List;
import java.util.Objects;

public class ReservationSystem {
	private UI ui;
	private ReservationInfo reser;
	private UserInfo userinfo;
	private TicketInfo ticketinfo;
	
	public ReservationSystem(UI ui, ReservationInfo reser, 
			UserInfo userinfo, TicketInfo ticketinfo) {
		this.ui = ui;
		this.reser = reser;
		this.userinfo = userinfo;
		this.ticketinfo = ticketinfo;
	}
	
	public void start() {
		boolean login = false;
		int select_num = 0;
		User user=null;
		while (!login) {		/* ログイン */
			String id = ui.input_id();
			String password = ui.input_pass();
			String get_pass = userinfo.get_user_password(id);
			
			if (Objects.isNull(get_pass)) {
				System.out.println("ユーザIDは存在しません\n");
			}else if (get_pass.equals(password)) {
				System.out.println("ログインしました\n");
				login = true;
				user = userinfo.get_user(id);
			}else {
				System.out.println("パスワードが不正です\n");
			}
		}
		
		while(select_num != 3) {
			ui.show_menu();
			select_num = ui.input_select_num();
			String ticket_num = null;
			int num_pur = 0;
			switch (select_num) {
			  case 1:
				  List<Ticket> tinfo = ticketinfo.get_ticketinfo();
				  ui.show_ticket(tinfo);
				  break;
			
			  case 2:
				  boolean canSelect = false;
				  while(!canSelect) {
					  String check_ticket_num = ui.input_ticket_num();
					  if (ticketinfo.exist_ticket(check_ticket_num)) {
						  int ticket_pur = ui.input_pur_num();
						  if(ticket_pur>0) {
							  if (ticketinfo.check_ticket_storage(check_ticket_num, ticket_pur)) {
								  canSelect = true;
								  ticket_num = check_ticket_num;
								  num_pur = ticket_pur;
							  }else {
								  System.out.println("在庫が不足しています");
							  }
						  }else {
							  System.out.println("0以上の整数を入力して下さい");
						  }
					  }else {
						  System.out.println("存在しない予約番号です");
					  }
				  }
		
				  Ticket ticket = ticketinfo.get_ticket(ticket_num, num_pur);
				  //System.out.println(ticket.get_ticket_num());
				  reser.set_reservation(user, ticket, num_pur);
				  List<Reservation> reserinfo = reser.get_reservation();
				  
				  System.out.println("チケットを予約しました");
				  System.out.println("----------------------------------予約情報----------------------------------");
				  ui.show_reservation(reserinfo);
				  
				  break;
			  case 3:
				  break;
			  default:
				  System.out.println("1~3の中から選択してください");
				  break;
			}
		}
		ui.show_logout();
	}
}
