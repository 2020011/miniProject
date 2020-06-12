package miniproject_3;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MoneyInfoTest {

	MoneyInfo moneyInfo;
	
	@Before
	public void setup() {
		moneyInfo = new MoneyInfo();
	}
	
	@Test
	public void テスト1() {
		
		List<Money> list = moneyInfo.get_moneyInfoList();
		
		assertThat(list.get(0).get_name(), is("10円"));
		assertThat(list.get(0).get_storage(), is(50));
		assertThat(list.get(1).get_name(), is("50円"));
		assertThat(list.get(1).get_storage(), is(50));
		assertThat(list.get(2).get_name(), is("100円"));
		assertThat(list.get(2).get_storage(), is(0));
		assertThat(list.get(3).get_name(), is("500円"));
		assertThat(list.get(3).get_storage(), is(50));
		assertThat(list.get(4).get_name(), is("1000円"));
		assertThat(list.get(4).get_storage(), is(50));
	}
	
	@Test
	public void テスト2(){
		
		Money money = moneyInfo.get_moneyInfo("50円");
		
		assertThat(money.get_name(),is("50円"));
		assertThat(money.get_storage(),is(50));
	}
	
	
}
