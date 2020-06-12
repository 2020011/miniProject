package miniproject_3;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		GUI gui = new GUI();

		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setBounds(10, 10, 500, 700);
		gui.setTitle("自動販売機システム");
		gui.setVisible(true);

		DrinkInfo drinkinfo = new DrinkInfo();
		MoneyInfo moneyinfo = new MoneyInfo();

		VendingMachine vend = new VendingMachine(drinkinfo, moneyinfo, gui);
		vend.start();
	}
}
