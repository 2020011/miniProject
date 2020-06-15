package miniproject_3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class ManegersCommand implements Command {
	String password;

	public ManegersCommand() {
		this.password = "yudetamago";
	}

	public void execute(GUI gui, DrinkInfo drinkinfo, MoneyInfo moneyinfo) {
		// TODO 自動生成されたメソッド・スタブ
		LoginAction(gui);

		Menu m_num = Menu.NULL;
		boolean m_flag = false;

		while (m_flag == false) {

			do {
				m_num = gui.input_management_num();
				System.out.print("");
			} while (m_num == Menu.NULL);

			if (m_num == Menu.STORAGE) {
				StorageAction(drinkinfo);
				gui.set_storage_label(drinkinfo.get_drinkInfoList());
				gui.set();

			} else if (m_num == Menu.CHANGESORT) {
				CoinAction(moneyinfo);
				gui.set_coin_storage_label(moneyinfo.get_moneyInfoList());
				gui.set();
			} else if (m_num == Menu.EXIT) {
				m_flag = true;
				System.out.println("終了します");
			}

		}
		
		this.fileWriter(drinkinfo, moneyinfo);

		System.exit(0);

	}
	
	private void fileWriter(DrinkInfo drinkinfo,MoneyInfo moneyinfo) {
		String outputFileName = "files/drink.txt";
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
			for (int i = 0; i < drinkinfo.get_drinkInfoList().size(); i++) {
				String str = String.valueOf(drinkinfo.get_drinkInfoList().get(i).get_storage());
				writer.write(str);
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String outputFileName_money = "files/money.txt";
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName_money))) {
			for (int i = 0; i < moneyinfo.get_moneyInfoList().size(); i++) {
				String str = String.valueOf(moneyinfo.get_moneyInfoList().get(i).get_storage());
				writer.write(str);
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// 在庫補充
	private void StorageAction(DrinkInfo drinkinfo) {
		List<Drink> drinkinfolist = drinkinfo.get_drinkInfoList();
		for (int i = 0; i < drinkinfolist.size(); i++) {
			drinkinfolist.get(i).set_storage();
		}
		System.out.println("在庫補充が完了しました");
	}

	// ログイン操作
	private void LoginAction(GUI gui) {
		boolean flag = false;
		String get_password;
		Menu m_num = Menu.NULL;
		while (flag == false) {

			do {
				get_password = gui.input_password();
				m_num = gui.input_management_num();
				System.out.print("");
			} while (Objects.isNull(get_password) && m_num != Menu.EXIT);

			if (password.equals(get_password)) {
				System.out.println("ログインしました");
				flag = true;
				gui.set_login(flag);
			} else if (m_num == Menu.EXIT) {
				System.exit(0);
			} else {
				//System.out.println("パスワードが間違っています");
			}
		}
	}

	// 釣銭整理
	private void CoinAction(MoneyInfo moneyinfo) {
		List<Money> moneyinfolist = moneyinfo.get_moneyInfoList();
		for (int i = 0; i < moneyinfolist.size(); i++) {
			moneyinfolist.get(i).reset_storage();
		}
		System.out.println("釣銭整理が完了しました");
	}

}
