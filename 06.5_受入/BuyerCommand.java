package miniproject_3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

import java.util.List;

public class BuyerCommand implements Command {
	private int money;
	
	private int[] money_storages = new int[MoneyInfo.MONEY_KIND]; //在庫を一時保存する
	
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
				BuyAction(drinkinfo, gui,moneyinfo);
				gui.set_sum_label(this.money);
				gui.set();
			} else if (menu_num == Menu.CHANGE) {
				
			} else {
				System.out.print("");
			}

		}
		gui.set_sum_label(0);

		EndAction(gui,drinkinfo,moneyinfo);
		System.exit(0);

	}
	
	private void MoneyAction(MoneyInfo moneyinfo, GUI gui) {
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
					money.increase_storage();
					str = money.get_use_count();
					gui.reset_coin_price();
					gui.set_coin_storage_label(moneyinfo.get_moneyInfoList());
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

	
	private void BuyAction(DrinkInfo drinkinfo, GUI gui,MoneyInfo moneyinfo) {
		int drink_num = 0;
		Drink drink;
	
		do {
			drink_num = gui.input_drink_num();
			System.out.print("");
		} while (drink_num == 0);

		System.out.println("購入");
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
				if(this.buy_judge(drink,moneyinfo)) {
					gui.show_bought_result();
					this.money -= drink.get_price();
					drink.dec_storage();
					gui.set_storage_label(drinkinfo.get_drinkInfoList());
					gui.set_price(this.money);
				}
				else {
					gui.show_change();
					System.out.println("釣銭切れです");
				}
			}
		}
	}
	
	private boolean buy_judge(Drink drink,MoneyInfo moneyinfo) {
		boolean flag = false;
		boolean buy_flag = true;
		int money = this.money - drink.get_price();
		List<Money> money_list = moneyinfo.get_moneyInfoList();
		for(int i = 0;i<MoneyInfo.MONEY_KIND;i++) {
			this.money_storages[i] = money_list.get(i).get_storage();
			System.out.println(this.money_storages[i]);
		}
		
		while (money > 1 && buy_flag == true) {
			if (money >= 1000 && this.money_storages[0] != 0) {
				money -= 1000;
				this.money_storages[0]--;
				buy_flag = true;
			} else if (money >= 500 && this.money_storages[1] > 0) {
				money -= 500;
				this.money_storages[1]--;
				buy_flag = true;
			} else if (money >= 100 && this.money_storages[2] > 0) {
				money -= 100;
				this.money_storages[2]--;
				buy_flag = true;
			} else if (money >= 50 && this.money_storages[3] > 0) {
				money -= 50;
				this.money_storages[3]--;
				buy_flag = true;
			} else if (money >= 10 && this.money_storages[4] > 0) {
				money -= 10;
				this.money_storages[4]--;
				buy_flag = true;
			}else {
				buy_flag = false;
			}
		}
		
		if(money == 0) {
			flag = true;
		}
		return flag;
	}
	
	
	
	private void EndAction(GUI gui,DrinkInfo drinkinfo,MoneyInfo moneyinfo) {
	
		int[] i = new int[5];
		int coin = this.money;
		List<Money> money_list = moneyinfo.get_moneyInfoList();
		while (this.money > 1) {
			if (this.money >= 1000 && money_list.get(0).get_storage() > 0) {
				i[0]++;
				this.money -= 1000;
				money_list.get(0).decrease_storage();
				System.out.println(this.money);
			} else if (this.money >= 500&& money_list.get(1).get_storage() > 0) {
				i[1]++;
				this.money -= 500;
				money_list.get(1).decrease_storage();
				System.out.println(this.money);
			} else if (this.money >= 100&& money_list.get(2).get_storage() > 0) {
				i[2]++;
				this.money -= 100;
				money_list.get(2).decrease_storage();
				System.out.println(this.money);
			} else if (this.money >= 50&& money_list.get(3).get_storage() > 0) {
				i[3]++;
				this.money -= 50;
				money_list.get(3).decrease_storage();
				System.out.println(this.money);
			} else if (this.money >= 10 && money_list.get(4).get_storage() > 0) {
				i[4]++;
				this.money -= 10;
				money_list.get(4).decrease_storage();
				System.out.println(this.money);
			}
		}
		this.fileWriter(drinkinfo,moneyinfo);
		gui.set_change(i, coin);
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

}
