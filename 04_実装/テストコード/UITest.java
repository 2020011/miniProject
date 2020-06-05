package miniproject_1;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class UITest {
	UI ui;
	
	@Before
	public void setup() {
		ui = new UI();
	}
	
	@Test
	public void test1_1() {
		int num = ui.input_select_num();
		assertThat(num,is(1));
	}
	
	@Test
	public void test1_2() {
		int num = ui.input_select_num();
		assertThat(num,is(0));
	}
	
	@Test
	public void test1_3() {
		int num = ui.input_select_num();
		assertThat(num,is(4));
	}
	
	@Test
	public void test1_4() {
		int num = ui.input_select_num();
		assertThat(num,is(-1));
	}
	
	@Test
	public void test2_1() {
		String num = ui.input_ticket_num();
		assertThat(num,is("001"));
	}
	
	@Test
	public void test3_1() {
		int num = ui.input_pur_num();
		assertThat(num,is(10));
	}
	
	@Test
	public void test3_2() {
		int num = ui.input_pur_num();
		assertThat(num,is(-1));
	}
	
	@Test
	public void test4_1() {
		String num = ui.input_id();
		assertThat(num,is("inu"));
	}

	@Test
	public void test5_1() {
		String num = ui.input_pass();
		assertThat(num,is("neko"));
	}
	
}
