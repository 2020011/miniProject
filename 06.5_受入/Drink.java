package miniproject_3;

public class Drink {
	private String name; // 飲み物の名前
	private int storage; // 飲み物の在庫
	private int price;
	private int num;
	final static private int MAX_STORAGE = 30;

	Drink(int drink_num, String name, int drink_price, int storage) {
		this.num = drink_num;
		this.name = name;
		this.storage = storage;
		this.price = drink_price;
	}

	public String get_name() {
		return this.name;
	}

	public int get_storage() {
		return this.storage;
	}

	public int get_price() {
		return this.price;
	}

	public int get_num() {
		return this.num;
	}

	public void set_storage() {
		this.storage = MAX_STORAGE;
	}

	public void dec_storage() {
		this.storage = storage - 1;
	}

}
