package miniproject_3;

public class Money {
	private String name;
	private int storage;
	private int use_count = 0; // 投入枚数
	private static final int DEFAULT_STORAGE = 30;

	public Money(String name, int storage) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.name = name;
		this.storage = storage;
	}

	public String get_name() {
		return this.name;
	}

	public int get_storage() {
		return this.storage;
	}

	public void set_storage(int storage) {
		this.storage = storage;
	}
	
	public void reset_storage() {
		this.storage = DEFAULT_STORAGE;
	}
	public void set_use_count() {
		this.use_count = this.use_count + 1;
	}

	public int get_use_count() {
		return this.use_count;
	}
	
	public void increase_storage() {
		this.storage = this.storage + 1;
	}

	public void decrease_storage() {
		this.storage = this.storage-1;
	}

}
