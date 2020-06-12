package miniproject_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DrinkInfo {
	private List<Drink> drinkinfo;

	DrinkInfo() {
		drinkinfo = new ArrayList<>();
		int[] c = new int[3];
		String inputFileName = "files/a.txt";
		try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
			c[0] = Integer.parseInt(reader.readLine());
			c[1] = Integer.parseInt(reader.readLine());
			c[2] = Integer.parseInt(reader.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}

		Drink drink1 = new Drink(1, "コカ・コーラ", 150, c[0]);
		Drink drink2 = new Drink(2, "ポカリスエット", 160, c[1]);
		Drink drink3 = new Drink(3, "お茶", 120, c[2]);
		drinkinfo.add(drink1);
		drinkinfo.add(drink2);
		drinkinfo.add(drink3);
	}

	public List<Drink> get_drinkInfoList() {
		return this.drinkinfo;
	}

	public Drink get_drinkInfo(int drink_num) {
		Drink drink = null;
		for (int i = 0; i < drinkinfo.size(); i++) {
			if (drinkinfo.get(i).get_num() == drink_num) {
				drink = drinkinfo.get(i);
			}
		}
		return drink;
	}

}
