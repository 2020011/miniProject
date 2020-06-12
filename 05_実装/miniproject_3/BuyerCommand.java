package miniproject_3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class BuyerCommand implements Command {
	private int money;

	public void execute(GUI gui, DrinkInfo drinkinfo, MoneyInfo moneyinfo) {
		// TODO 自動生成されたメソッド・スタブ
		Menu menu_num = Menu.NULL;
		while (menu_num != Menu.CHANGE) {
			do {
				menu_num = gui.input_menu_num();
				System.out.print("");
			} while (menu_num == Menu.NULL);

			System.out.println(money);
			if (menu_num == Menu.ADDMONEY) {
				MoneyAction(moneyinfo, gui);
				gui.set_sum_label(this.money);
				gui.set();

			} else if (menu_num == Menu.BUY) {
				BuyAction(drinkinfo, gui);
				gui.set_sum_label(this.money);
				gui.set();
			} else if (menu_num == Menu.CHANGE) {

			} else {
				System.out.print("");
			}

		}
		gui.set_sum_label(0);
		String outputFileName = "files/a.txt";
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
			for (int i = 0; i < drinkinfo.get_drinkInfoList().size(); i++) {
				String str = String.valueOf(drinkinfo.get_drinkInfoList().get(i).get_storage());
				writer.write(str);
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		EndAction(gui);
		System.exit(0);

	}

	private void BuyAction(DrinkInfo drinkinfo, GUI gui) {
		int drink_num = 0;
		Drink drink;

		do {
			drink_num = gui.input_drink_num();
			System.out.print("");
		} while (drink_num == 0);

		System.out.print("購入");
		drink = drinkinfo.get_drinkInfo(drink_num);

		if (Objects.isNull(drink)) {
			System.out.println("存在しません");
		} else if (drink.get_storage() == 0) {
			gui.show_message("在庫切れです");
		} else {
			if (drink.get_price() > this.money) {
				System.out.println("投入金額が不足しています");
				gui.show_result();
			} else {
				gui.show_bought_result();
				this.money -= drink.get_price();
				drink.dec_storage();
				gui.set_storage_label(drinkinfo.get_drinkInfoList());
				gui.set_price(this.money);

			}
		}
	}

	void MoneyAction(MoneyInfo moneyinfo, GUI gui) {
		boolean x = false;
		String coin_price = null;
		int str = 0;
		int price = 0;
		Money money;
		while (true) {
			do {
				x = gui.input_coin_decision();
				coin_price = gui.input_coin_price();
				price = gui.input_coin();
				gui.set_sum_label(price);
				if (Objects.isNull(coin_price) == false) {
					money = moneyinfo.get_moneyInfo(coin_price);
					money.set_use_count();
					str = money.get_use_count();
					gui.reset_coin_price();
				}

				System.out.print("");
			} while (x == false);

			if (x == true) {
				break;
			}
		}
		System.out.println("coin終了");
		System.out.println(str);

		this.money = price * 1;
		System.out.println(this.money);
		System.out.println("moneycount終了");
	}

	void EndAction(GUI gui) {
		int[] i = new int[5];
		int coin = this.money;
		while (this.money > 1) {
			if (this.money >= 1000) {
				i[0]++;
				this.money -= 1000;
				System.out.println(this.money);
			} else if (this.money >= 500) {
				i[1]++;
				this.money -= 500;
				System.out.println(this.money);
			} else if (this.money >= 100) {
				i[2]++;
				this.money -= 100;
				System.out.println(this.money);
			} else if (this.money >= 50) {
				i[3]++;
				this.money -= 50;
				System.out.println(this.money);
			} else if (this.money >= 10) {
				i[4]++;
				this.money -= 10;
				System.out.println(this.money);
			}
		}

		for (int j = 0; j <= 4; j++) {
			if (i[j] > 0) {
				if (j == 0) {
					System.out.println("1000は" + i[j]);
				}
				if (j == 1) {
					System.out.println("500は" + i[j]);
				}
				if (j == 2) {
					System.out.println("100は" + i[j]);
				}
				if (j == 3) {
					System.out.println("50は" + i[j]);
				}
				if (j == 4) {
					System.out.println("10は" + i[j]);
				}
			}
		}

		gui.set_change(i, coin);
	}

}
