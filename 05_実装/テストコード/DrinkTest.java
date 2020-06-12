package miniproject_3;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class DrinkTest {
	Drink drink;
	
	@Before
	public void setup() {
	drink = new Drink(1,"コカ・コーラ",150,20);
	}

	@Test
	public void テスト１() {
		
		assertThat(drink.get_num(),is(1));
	}
	
	@Test
	public void テスト2() {
		
		assertThat(drink.get_name(),is("コカ・コーラ"));
	}
	
	@Test
	public void テスト3() {
		
		assertThat(drink.get_price(),is(150));
	}
	
	@Test
	public void テスト4() {
		
		assertThat(drink.get_storage(),is(20));
	}
	
	@Test
	public void テスト5() {//在庫の補充
		
		drink.set_storage();
		
		assertThat(drink.get_storage(),is(30));
	}
	
	@Test
	public void テスト６() {//在庫をへらす
		
		drink.dec_storage();
		
		assertThat(drink.get_storage(),is(19));
	}
}
