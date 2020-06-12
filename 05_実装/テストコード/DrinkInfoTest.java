package miniproject_3;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

public class DrinkInfoTest {
	
	@Test
	public void テスト1() {
		// 事前準備
		DrinkInfo drinkinfo = new DrinkInfo();
		List<Drink> drinks;
		drinks = drinkinfo.get_drinkInfoList();

		// 検証
		assertThat(drinks.get(0).get_num(), is(1));
		assertThat(drinks.get(0).get_name(), is("コカ・コーラ"));
		assertThat(drinks.get(0).get_price(), is(150));
		assertThat(drinks.get(0).get_storage(), is(30));
		assertThat(drinks.get(1).get_num(), is(2));
		assertThat(drinks.get(1).get_name(), is("ポカリスエット"));
		assertThat(drinks.get(1).get_price(), is(160));
		assertThat(drinks.get(1).get_storage(), is(30));
		assertThat(drinks.get(2).get_num(), is(3));
		assertThat(drinks.get(2).get_name(), is("お茶"));
		assertThat(drinks.get(2).get_price(), is(120));
		assertThat(drinks.get(2).get_storage(), is(30));

		// （必要であれば）後処理
	}

	@Test
	public void テスト2() {
		// 事前準備
		DrinkInfo drinkinfo = new DrinkInfo();

		// 検証
		assertThat(drinkinfo.get_drinkInfo(1).get_name(), is("コカ・コーラ"));
		assertThat(drinkinfo.get_drinkInfo(1).get_price(), is(150));
		assertThat(drinkinfo.get_drinkInfo(1).get_num(), is(1));
		assertThat(drinkinfo.get_drinkInfo(1).get_storage(), is(30));

		// （必要であれば）後処理
	}

}
