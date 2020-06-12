package miniproject_3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

public class GUI extends JFrame implements ActionListener, UI {
	private JPanel s_p = new JPanel();
	private JPanel d_p = new JPanel();
	private JPanel m_p = new JPanel();
	private JPanel mane_p = new JPanel();
	private JPanel main_mane_p = new JPanel();
	private JPanel pass_p = new JPanel();
	private JPanel end_mane_p = new JPanel();
	private JPanel coin_num_panel = new JPanel();
	private JPanel coin_panel = new JPanel();
	private JLabel sum_label;
	private JPasswordField pass1;
	private int mane_num = 0;
	private int menu_num = 0;
	private int command_num;
	private int coin_num = 0;
	private int price = 0;
	private String coin_price;
	private int drink_num = 0;
	private String password = null;
	private boolean drink_flag = false;
	private boolean coin_flag = false;
	private List<JButton> menu_buttons = new ArrayList<>();
	private List<JButton> drink_buttons = new ArrayList<>();
	private List<JButton> coin_buttons = new ArrayList<>();
	private List<JButton> mane_buttons = new ArrayList<>();
	private List<JLabel> drink_labels = new ArrayList<>();
	private List<JLabel> storage_labels = new ArrayList<>();

	GUI() {
		d_p.setLayout(null);
		d_p.setBackground(Color.WHITE);
		d_p.setOpaque(false);
		d_p.setBounds(0, 0, 470, 400);

		s_p.setLayout(null);
		s_p.setBackground(Color.WHITE);
		s_p.setBounds(0, 0, 470, 400);

		m_p.setLayout(null);
		m_p.setBackground(Color.BLACK);
		m_p.setBounds(300, 400, 200, 280);
		LineBorder border2 = new LineBorder(Color.BLACK, 2, true);
		m_p.setBorder(border2);

		mane_p.setLayout(null);
		mane_p.setBackground(Color.WHITE);
		mane_p.setBounds(0, 400, 500, 300);
		mane_p.setVisible(false);

		main_mane_p.setLayout(null);
		main_mane_p.setBackground(Color.BLACK);
		main_mane_p.setBounds(0, 615, 300, 50);

		end_mane_p.setLayout(null);
		end_mane_p.setBackground(Color.WHITE);
		end_mane_p.setBounds(0, 400, 130, 300);
		end_mane_p.setVisible(false);

		pass_p.setLayout(null);
		pass_p.setBackground(Color.WHITE);
		pass_p.setBounds(110, 400, 200, 300);
		pass_p.setVisible(false);

		coin_num_panel.setLayout(null);
		coin_num_panel.setOpaque(false);
		coin_num_panel.setBounds(100, 400, 200, 250);
		coin_num_panel.setVisible(false);

		coin_panel.setLayout(null);
		coin_panel.setOpaque(false);
		coin_panel.setBounds(0, 400, 150, 250);
		coin_panel.setVisible(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		String cmd = e.getActionCommand();

		if (cmd.equals("お金を追加")) {
			JOptionPane.showMessageDialog(this, "お金を追加");
			coin_panel.setVisible(true);
			menu_buttons.get(0).setEnabled(false);
			main_mane_p.setVisible(false);
			menu_buttons.get(2).setEnabled(false);
			for (int i = 0; i < drink_buttons.size(); i++) {
				drink_buttons.get(i).setEnabled(false);
			}

			menu_num = 1;
			command_num = 1;
		} else if (cmd.equals("購入")) {
			JOptionPane.showMessageDialog(this, "購入");
			menu_num = 2;
		} else if (cmd.equals("おつり")) {
			JOptionPane.showMessageDialog(this, "おつり");
			menu_num = 3;
			command_num = 3;
		}

		if (cmd.equals("10円")) {
			JOptionPane.showMessageDialog(this, "10円を追加");
			coin_num_panel.setVisible(true);
			coin_price = "10円";
			price += 10;
		} else if (cmd.equals("50円")) {
			JOptionPane.showMessageDialog(this, "50円を追加");
			coin_num_panel.setVisible(true);
			coin_price = "50円";
			price += 50;
		} else if (cmd.equals("100円")) {
			JOptionPane.showMessageDialog(this, "100円を追加");
			coin_num_panel.setVisible(true);
			coin_price = "100円";
			price += 100;
		} else if (cmd.equals("500円")) {
			JOptionPane.showMessageDialog(this, "500円を追加");
			coin_num_panel.setVisible(true);
			coin_price = "500円";
			price += 500;
		} else if (cmd.equals("1000円")) {
			JOptionPane.showMessageDialog(this, "1000円を追加");
			coin_num_panel.setVisible(true);
			coin_price = "1000円";
			price += 1000;
		}

		if (cmd.equals("決定")) {
			JOptionPane.showMessageDialog(this, "決定します");
			coin_num_panel.setVisible(false);
			coin_panel.setVisible(false);
			menu_buttons.get(0).setEnabled(true);
			coin_num = 1;
			coin_flag = true;
			menu_buttons.get(2).setEnabled(true);

			for (int i = 0; i < drink_buttons.size(); i++) {
				drink_buttons.get(i).setEnabled(true);
			}

		}

		if (cmd.equals("150")) {
			JOptionPane.showMessageDialog(this, "コカ・コーラを追加");
			drink_num = 1;
			drink_flag = true;
			menu_num = 2;
		} else if (cmd.equals("160")) {
			JOptionPane.showMessageDialog(this, "ポカリスエットを追加");
			drink_num = 2;
			drink_flag = true;
			menu_num = 2;
		} else if (cmd.equals("120")) {
			JOptionPane.showMessageDialog(this, "お茶を追加");
			drink_num = 3;
			drink_flag = true;
			menu_num = 2;
		}

		if (cmd.equals("管理")) {
			end_mane_p.setVisible(true);
			main_mane_p.setVisible(false);
			pass_p.setVisible(true);
			m_p.setVisible(false);

			command_num = 2;
		}

		if (cmd.equals("OK")) {
			password = new String(pass1.getPassword());
		}

		if (cmd.equals("在庫補充")) {
			JOptionPane.showMessageDialog(this, "在庫補充が完了しました");
			mane_num = 1;
		} else if (cmd.equals("釣銭整理")) {
			JOptionPane.showMessageDialog(this, "釣銭整理が完了しました");
			mane_num = 2;
		} else if (cmd.equals("終了")) {
			JOptionPane.showMessageDialog(this, "終了します");
			mane_num = 3;
		}

	};

	// ～～～～～～～input系～～～～～～～～～
	public void set() {
		menu_num = 0;
		coin_num = 0;
		drink_num = 0;
		mane_num = 0;
		command_num = 0;
		coin_flag = false;
		coin_price = null;
	}

	public void set_price(int price) {
		this.price = price;
	}

	public void reset_coin_price() {
		coin_price = null;
	}

	// メニューセレクト
	public Menu input_menu_num() {
		Menu n = Menu.NULL;
		if (menu_num == 0) {
			n = Menu.NULL;
		} else if (menu_num == 1) {
			n = Menu.ADDMONEY;
		} else if (menu_num == 2) {
			n = Menu.BUY;
		} else if (menu_num == 3) {
			n = Menu.CHANGE;
		}

		return n;
	}

	public boolean input_coin_decision() {
		return this.coin_flag;
	}

	// 金額選択
	public int input_coin() {
		return price;
	};

	// コイン枚数
	public int input_money_count() {
		return coin_num;
	}

	public String input_coin_price() {
		return coin_price;
	}

	// パスワード
	public String input_password() {
		return password;
	}

	public int input_drink_num() {
		return drink_num;
	}

	public Menu input_management_num() {
		Menu n = Menu.NULL;
		if (mane_num == 1) {
			n = Menu.STORAGE;
		} else if (mane_num == 2) {
			n = Menu.CHANGESORT;
		} else if (mane_num == 3) {
			n = Menu.EXIT;
		} else if (mane_num == 0) {
			n = Menu.NULL;
		}

		return n;
	}

	public Menu input_command_num() {
		Menu n = Menu.NULL;
		if (command_num == 1) {
			n = Menu.ADDMONEY;
		} else if (command_num == 2) {
			n = Menu.MANEGEMENT;
		} else if (command_num == 3) {
			n = Menu.CHANGE;
		}
		return n;
	}

	public boolean actionperfomed() {
		return drink_flag;
	}

	// ～～～～～～～buttonセット系～～～～～～～～～
	public void set_login(boolean login) {
		pass_p.setVisible(false);
		mane_p.setVisible(true);
	}

	public void show_result() {
		JOptionPane.showMessageDialog(this, "購入しませんでした");
	}

	public void show_message(String str) {
		JOptionPane.showMessageDialog(this, str);
	}

	public void show_bought_result() {
		JOptionPane.showMessageDialog(this, "購入できました");

	}

	public void set_change(int[] change, int coin) {
		String ch = String.valueOf(coin);
		String[] str = new String[5];
		JOptionPane.showMessageDialog(this, "おつりは" + ch + "円です");

		if (change[0] > 0) {
			str[0] = "1000円" + change[0] + "枚です";
		} else {
			str[0] = "1000円" + 0 + "枚です";
		}
		if (change[1] > 0) {
			str[1] = "500円" + change[1] + "枚です";
		} else {
			str[1] = "500円" + 0 + "枚です";
		}
		if (change[2] > 0) {
			str[2] = "100円" + change[2] + "枚です";
		} else {
			str[2] = "100円" + 0 + "枚です";
		}
		if (change[3] > 0) {
			str[3] = "50円" + change[3] + "枚です";
		} else {
			str[3] = "50円" + 0 + "枚です";
		}
		if (change[4] > 0) {
			str[4] = "10円" + change[4] + "枚です";
		} else {
			str[4] = "10円" + 0 + "枚です";
		}

		JOptionPane.showMessageDialog(this, str[0] + "\n" + str[1] + "\n" + str[2] + "\n" + str[3] + "\n" + str[4]);
	}

	public void set_menu() {
		sum_label = new JLabel("0");
		sum_label.setBounds(15, 10, 120, 30);
		sum_label.setForeground(Color.BLACK);
		sum_label.setBackground(Color.WHITE);
		sum_label.setOpaque(true);

		JButton button1 = new JButton("お金を追加");
		button1.setBounds(15, 50, 120, 30);
		set_button(button1);
		JButton button2 = new JButton("購入");
		button2.setBounds(15, 40, 120, 30);
		set_button(button2);
		JButton button3 = new JButton("おつり");
		button3.setBounds(15, 90, 120, 30);
		set_button(button3);

		m_p.add(button1);
		m_p.add(button3);
		m_p.add(sum_label);

		menu_buttons.add(button1);
		menu_buttons.add(button2);
		menu_buttons.add(button3);

		getContentPane().add(m_p, BorderLayout.CENTER);

	}

	public void set_sum_label(int sum) {
		String str = Integer.toString(sum);
		sum_label.setText(str);
	}

	public void set_storage_label(List<Drink> drinkinfo) {

		for (int i = 0; i < drink_labels.size(); i++) {
			int drink_storage = drinkinfo.get(i).get_storage();
			String storage = Integer.toString(drink_storage);
			storage_labels.get(i).setText(storage);
		}

	}

	public void set_management_button() {
		JButton button1 = new JButton("管理");
		button1.setBounds(10, 10, 120, 30);
		set_button(button1);

		JButton button2 = new JButton("在庫補充");
		button2.setBounds(180, 50, 120, 30);
		set_button(button2);

		JButton button4 = new JButton("終了");
		button4.setBounds(0, 200, 120, 30);
		set_button(button4);

		pass1 = new JPasswordField();
		pass1.setBounds(50, 100, 120, 30);
		pass1.setColumns(20);

		JButton button5 = new JButton("OK");
		button5.setBounds(50, 200, 120, 30);
		set_button(button5);

		main_mane_p.add(button1);
		mane_p.add(button2);
		end_mane_p.add(button4);
		pass_p.add(pass1);
		pass_p.add(button5);

		mane_buttons.add(button1);
		mane_buttons.add(button2);
		mane_buttons.add(button4);

		getContentPane().add(mane_p, BorderLayout.CENTER);
		getContentPane().add(main_mane_p, BorderLayout.CENTER);
		getContentPane().add(end_mane_p, BorderLayout.CENTER);
		getContentPane().add(pass_p, BorderLayout.CENTER);

	}

	public void set_drinkinfo(List<Drink> drinkinfo) {
		int j = 0;
		for (int i = 0; i < drinkinfo.size(); i++) {
			int drink_price = drinkinfo.get(i).get_price();
			int drink_storage = drinkinfo.get(i).get_storage();
			String price = Integer.toString(drink_price);
			String storage = Integer.toString(drink_storage);

			JLabel label = new JLabel();
			label.setBounds(20 + j, 10, 130, 250);
			label.setOpaque(true);
			label.setBackground(Color.WHITE);
			label.setHorizontalAlignment(JLabel.CENTER);

			JLabel st_label = new JLabel(storage);
			st_label.setBounds(46 + j, 340, 80, 20);
			st_label.setForeground(Color.BLACK);
			st_label.setBackground(Color.WHITE);
			st_label.setHorizontalAlignment(JLabel.CENTER);
			st_label.setBorder(new LineBorder(Color.BLACK, 2, true));

			JButton button = new JButton(price);
			button.setBounds(20 + j, 300, 130, 20);
			button.setEnabled(false);
			set_button(button);
			j = j + 150;

			drink_buttons.add(button);
			drink_labels.add(label);
			storage_labels.add(st_label);
		}

		ImageIcon icon1 = new ImageIcon("files/coke.png");
		ImageIcon icon2 = new ImageIcon("files/pokari.png");
		ImageIcon icon3 = new ImageIcon("files/tea.png");
		drink_labels.get(0).setIcon(icon1);
		drink_labels.get(1).setIcon(icon2);
		drink_labels.get(2).setIcon(icon3);

		for (int i = 0; i < drink_buttons.size(); i++) {
			d_p.add(drink_buttons.get(i));
		}

		for (int i = 0; i < drink_labels.size(); i++) {
			d_p.add(drink_labels.get(i));
		}

		for (int i = 0; i < drink_labels.size(); i++) {
			s_p.add(storage_labels.get(i));
		}

		getContentPane().add(d_p, BorderLayout.CENTER);
		getContentPane().add(s_p, BorderLayout.CENTER);

	}

	public void set_coin_num() {
		int X = 50;
		int Y = 100;
		int x = 100;
		int y = 50;
		JButton button1_n = new JButton("決定");
		button1_n.setBounds(X, Y, x, y);
		set_button(button1_n);
		coin_num_panel.add(button1_n);

		getContentPane().add(coin_num_panel, BorderLayout.CENTER);
	}

	public void set_coin(MoneyInfo moneyinfo) {
		int X = 0;
		int Y = 0;
		int x = 120;
		int y = 30;
		List<Money> moneylist = moneyinfo.get_moneyInfoList();
		JButton button1_c = new JButton("10円");
		button1_c.setBounds(X, Y, x, y);
		set_button(button1_c);
		coin_panel.add(button1_c);
		JButton button2_c = new JButton("50円");
		button2_c.setBounds(X, Y + y, x, y);
		set_button(button2_c);
		coin_panel.add(button2_c);
		JButton button3_c = new JButton("100円");
		button3_c.setBounds(X, Y + 2 * y, x, y);
		set_button(button3_c);
		coin_panel.add(button3_c);
		JButton button4_c = new JButton("500円");
		button4_c.setBounds(X, Y + 3 * y, x, y);
		set_button(button4_c);
		coin_panel.add(button4_c);
		JButton button5_c = new JButton("1000円");
		button5_c.setBounds(X, Y + 4 * y, x, 30);
		set_button(button5_c);
		coin_panel.add(button5_c);

		if (moneylist.get(0).get_storage() == 0) {
			button1_c.setEnabled(false);
		} else if (moneylist.get(1).get_storage() == 0) {
			button2_c.setEnabled(false);
		} else if (moneylist.get(2).get_storage() == 0) {
			button3_c.setEnabled(false);
		} else if (moneylist.get(3).get_storage() == 0) {
			button4_c.setEnabled(false);
		} else if (moneylist.get(4).get_storage() == 0) {
			button5_c.setEnabled(false);
		}

		coin_buttons.add(button1_c);
		coin_buttons.add(button2_c);
		coin_buttons.add(button3_c);
		coin_buttons.add(button4_c);
		coin_buttons.add(button5_c);

		getContentPane().add(coin_panel, BorderLayout.CENTER);
	}

	public void set_button(JButton button) {
		button.setForeground(Color.BLACK);
		button.setBackground(Color.WHITE);
		button.addActionListener(this);
		button.setActionCommand(button.getText());
	}

}
