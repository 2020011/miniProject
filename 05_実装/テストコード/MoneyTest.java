package miniproject_3;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
	Money money;
	
	@Before
	public void setup() {
		money = new Money("10円",50);
	}
	
	@Test
	public void テスト1() {//名前の取得
		
		assertThat(money.get_name(),is("10円"));
	}
	
	@Test
	public void テスト2() {//在庫取得
		
		assertThat(money.get_storage(),is(50));
	}
	
	@Test
	public void テスト3() {//在庫の補充
		money.set_storage(60);
		assertThat(money.get_storage(),is(60));
	}
	
}
