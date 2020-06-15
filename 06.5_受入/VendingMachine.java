package miniproject_3;

import java.util.List;

public class VendingMachine {
	private DrinkInfo drinkinfo;
	private MoneyInfo moneyinfo;
	private GUI gui;

	public VendingMachine(DrinkInfo drinkinfo, MoneyInfo moneyinfo, GUI gui) {
		this.drinkinfo = drinkinfo;
		this.moneyinfo = moneyinfo;
		this.gui = gui;

		gui.set_menu();
		gui.set_coin_num();
		gui.set_coin(moneyinfo);
		gui.set_management_button();
		List<Drink> drinkinfolist = drinkinfo.get_drinkInfoList();
		List<Money> moneyinfolist = moneyinfo.get_moneyInfoList();

		gui.set_drinkinfo(drinkinfolist);
		gui.set_moneyinfo(moneyinfolist);

	}

	public void start() {

		Command b_command = new BuyerCommand();
		Command m_command = new ManegersCommand();
		Menu num = Menu.NULL;
		do {
			num = gui.input_command_num();
			System.out.print("");
		} while (num == Menu.NULL);

		if (num == Menu.ADDMONEY) {
			System.out.println("購入者モード");
			b_command.execute(gui, drinkinfo, moneyinfo);

		} else if (num == Menu.MANEGEMENT) {
			System.out.println("管理者モード");
			m_command.execute(gui, drinkinfo, moneyinfo);
		}

		gui.show_not_bought();
		System.exit(0);
	}

}
