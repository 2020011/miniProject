package miniproject_3;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MoneyInfo {
	private List<Money> moneyinfo;
	public static final int MONEY_KIND = 5;
	
	MoneyInfo() {
		moneyinfo = new ArrayList<>();
		
		int[] m = new int[MONEY_KIND];
		String inputFileName = "files/money.txt";
		try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
			m[0] = Integer.parseInt(reader.readLine());
			m[1] = Integer.parseInt(reader.readLine());
			m[2] = Integer.parseInt(reader.readLine());
			m[3] = Integer.parseInt(reader.readLine());
			m[4] = Integer.parseInt(reader.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Money money1 = new Money("1000円", m[0]);
		Money money2 = new Money("500円", m[1]);
		Money money3 = new Money("100円", m[2]);
		Money money4 = new Money("50円", m[3]);
		Money money5 = new Money("10円", m[4]);
		
		moneyinfo.add(money1);
		moneyinfo.add(money2);
		moneyinfo.add(money3);
		moneyinfo.add(money4);
		moneyinfo.add(money5);

	}

	public List<Money> get_moneyInfoList() {
		return this.moneyinfo;
	}

	public Money get_moneyInfo(String money_name) {
		Money money = null;
		for (int i = 0; i < moneyinfo.size(); i++) {
			if (moneyinfo.get(i).get_name().equals(money_name)) {
				money = moneyinfo.get(i);
			}
		}
		return money;
	}
	
}
