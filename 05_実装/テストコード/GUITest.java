package miniproject_3_1;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class GUITest {
	
	private GUI gui;
	
	@Before
	public void setup() {
		gui = new GUI();
	}
	
	
	@Test
	public void test1_1() {
		this.gui.set();
		assertThat(this.gui.input_menu_num(),is(Menu.NULL));
	}
	
	@Test
	public void test2_1() {
		this.gui.set();
		assertThat(this.gui.input_coin_decision(),is(false));
	}
	
	@Test
	public void test3_1() {
		this.gui.set();
		assertThat(this.gui.input_coin(),is(0));
	}
	
	@Test
	public void test4_1() {
		this.gui.set();
		assertThat(this.gui.input_money_count(),is(0));
	}
	
	@Test
	public void test5_1() {
		this.gui.set();
		String str = null;
		assertThat(this.gui.input_coin_price(),is(str));
	}
	
	@Test
	public void test6_1() {
		this.gui.set();
		String str = null;
		assertThat(this.gui.input_password(),is(str));
	}

	@Test
	public void test7_1() {
		this.gui.set();
		assertThat(this.gui.input_drink_num(),is(0));
	}
	
	@Test
	public void test8_1() {
		this.gui.set();
		assertThat(this.gui.input_management_num(),is(Menu.NULL));
	}
	
	@Test
	public void test9_1() {
		this.gui.set();
		assertThat(this.gui.input_command_num(),is(Menu.NULL));
	}
	
	@Test
	public void test10_1() {
		this.gui.set();
		assertThat(this.gui.actionperfomed(),is(false));
	}
	
	@Test
	public void test11_1() {
		this.gui.set();
		this.gui.show_result();
		//assertThat(this.gui.input_coin_price(),is(str));
	}
	
	@Test
	public void test12_1() {
		this.gui.set();
		this.gui.show_message("a");
		//assertThat(this.gui.input_coin_price(),is(str));
	}
	
	@Test
	public void test13_1() {
		this.gui.set();
		this.gui.show_bought_result();
		//assertThat(this.gui.input_coin_price(),is(str));
	}
	
}
