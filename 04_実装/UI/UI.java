package miniproject_1;

import java.io.BufferedReader;
import java.util.List;
import java.util.Scanner;

public class UI {
	
	public UI() {
	}

	public int input_select_num() {
		int menu = 0;
		System.out.println("メニュー番号を入力してください");
		Scanner scan1 = new Scanner(System.in);
		try {
			menu = scan1.nextInt();			
		}catch(Exception e) {
			return -1;
		}
		return menu;
	}

	public String input_ticket_num() {
		System.out.println("チケット番号を入力してください ");
		String ticket_num;
		Scanner scan1 = new Scanner(System.in);
		ticket_num = scan1.next();
		return ticket_num;
	}

	public int input_pur_num() {
		System.out.println("購入チケット枚数を入力してください ");
		int num_pur = 0;
		Scanner scan1 = new Scanner(System.in);
		try{
			num_pur = scan1.nextInt();
		}catch(Exception e) {
			return -1;
		}
		return num_pur;
	}

	public String input_id() {
		String id = " ";
		System.out.println("ユーザIDを入力してください");
		Scanner scan1 = new Scanner(System.in);
		id = scan1.next();
		return id;
	}

	public String input_pass() {
		String password = " ";
		Scanner scan1 = new Scanner(System.in);
		System.out.println("パスワードを入力してください");
		password = scan1.next();
		return password;
	}

	// 予約情報を表示する
	public void show_reservation(List<Reservation> reserinfo) {
		int i = reserinfo.size() - 1;
		int number = reserinfo.get(i).get_reser_num(); // 予約番号
		String user_name = reserinfo.get(i).get_reser_user_name(); // ユーザ名
		String ticket_name = reserinfo.get(i).get_reser_name();// チケット名
		String date = reserinfo.get(i).get_reser_date();// 予約日
		int num_pur = reserinfo.get(i).get_reser_num_pur(); // 購入枚数
		System.out.println("予約番号:"+number+" | ユーザ名:"+ user_name +" | チケット名:"+ ticket_name +" | 予約日:"+ date +" | 購入枚数:"+ num_pur);
	}

	// チケット情報を表示する
	public void show_ticket(List<Ticket> ticketinfo) {
		System.out.println("チケット番号 | チケット名 | 価格 |     開催日          | 在庫 |");
		System.out.println("-----------------------------------------------");
		for (int i = 0; i < ticketinfo.size(); i++) {
            String ticket_num = ticketinfo.get(i).get_ticket_num();
            String ticket_name = ticketinfo.get(i).get_ticket_name();
            int ticket_price = ticketinfo.get(i).get_ticket_price();
            String ticket_date = ticketinfo.get(i).get_ticket_date();
            int ticket_storage = ticketinfo.get(i).get_ticket_storage();
           
            System.out.println("   "+ticket_num+"     "+ ticket_name+"      "+ ticket_price +"    "+ticket_date +"    "+ticket_storage);
           
        	}
		}
	
	// メニューを表示する
	public void show_menu() {
		System.out.println("1.チケット一覧を表示 ");
		System.out.println("2.予約");
		System.out.println("3.ログアウト");
	}
	
	//ログアウトを出力する
	public void show_logout() {
		System.out.println("ログアウトしました。");
	}

}
