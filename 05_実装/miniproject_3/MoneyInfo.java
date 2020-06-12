package miniproject_3;

import java.util.ArrayList;
import java.util.List;

public class MoneyInfo {
	private List<Money> moneyinfo;

	MoneyInfo() {
		moneyinfo = new ArrayList<>();
		Money money1 = new Money("10円", 50);
		Money money2 = new Money("50円", 50);
		Money money3 = new Money("100円", 50);
		Money money4 = new Money("500円", 50);
		Money money5 = new Money("1000円", 50);

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
