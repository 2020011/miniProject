package miniproject_3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
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
	private JPanel side_p = new JPanel();
	private JPanel mother_p = new JPanel();
	private JPanel c_s_p = new JPanel();
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
	private List<JLabel> coin_storage_labels = new ArrayList<>();
	private List<JLabel> coin_name_labels = new ArrayList<>();

	GUI() {
		d_p.setLayout(null);
		d_p.setBackground(Color.BLACK);
		d_p.setBounds(70, 70, 500, 330);
		
		s_p.setLayout(null);
		s_p.setOpaque(false);
		s_p.setBounds(75, 380, 500, 100);

		side_p.setLayout(null);
		side_p.setOpaque(false);
		side_p.setBounds(0, 0, 900, 700);
		LineBorder border9 = new LineBorder(Color.BLACK, 2, true);
		side_p.setBorder(border9);

		mother_p.setLayout(null);
		mother_p.setBackground(Color.WHITE);
		mother_p.setBounds(480, 0, 470, 700);
		LineBorder border10 = new LineBorder(Color.BLACK, 2, true);
		mother_p.setBorder(border10);

		c_s_p.setLayout(null);
		c_s_p.setBackground(Color.WHITE);
		c_s_p.setBounds(0, 0, 470, 400);

		m_p.setLayout(null);
		m_p.setOpaque(false);
		m_p.setBounds(665, 400, 150, 150);
		
		mane_p.setLayout(null);
		mane_p.setOpaque(false);
		mane_p.setBounds(150, 500, 200, 100);
		mane_p.setVisible(false);

		main_mane_p.setLayout(null);
		main_mane_p.setOpaque(false);
		main_mane_p.setBackground(Color.BLACK);
		main_mane_p.setBounds(670, 590, 150, 50);

		end_mane_p.setLayout(null);
		end_mane_p.setOpaque(false);
		end_mane_p.setBounds(670, 550, 140, 100);
		end_mane_p.setVisible(false);

		pass_p.setLayout(null);
		pass_p.setOpaque(false);
		pass_p.setBounds(210, 450, 200, 150);
		pass_p.setVisible(false);
		
		coin_num_panel.setLayout(null);
		coin_num_panel.setOpaque(false);
		coin_num_panel.setBounds(350, 530, 120, 70);
		coin_num_panel.setVisible(false);

		coin_panel.setLayout(null);
		coin_panel.setOpaque(false);
		coin_panel.setBounds(180, 450, 140, 160);
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
		for (int i = 0; i < coin_storage_labels.size(); i++) {
			coin_storage_labels.get(i).setVisible(true);
			coin_name_labels.get(i).setVisible(true);
		}
	}

	public void show_result() {
		JOptionPane.showMessageDialog(this, "購入できませんでした");
	}
	
	public void show_not_bought() {
		JOptionPane.showMessageDialog(this, "購入しませんでした");
	}

	public void show_change() {
		JOptionPane.showMessageDialog(this, "釣銭切れです");
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

	public void set_coin_storage_label(List<Money> moneyinfo) {

		for (int i = 0; i < coin_storage_labels.size(); i++) {
			int money_storage = moneyinfo.get(i).get_storage();
			String storage = Integer.toString(money_storage);
			coin_storage_labels.get(i).setText(storage);
		}

	}

	public void set_management_button() {
		JButton button1 = new JButton("管理");
		button1.setBounds(10, 10, 120, 30);
		button1.setBackground(Color.RED);
		set_button(button1);

		JButton button2 = new JButton("在庫補充");
		button2.setBounds(60, 10, 120, 30);
		set_button(button2);

		JButton button3 = new JButton("釣銭整理");
		button3.setBounds(60, 60, 120, 30);
		set_button(button3);

		JButton button4 = new JButton("終了");
		button4.setBounds(10, 50, 120, 30);
		set_button(button4);

		pass1 = new JPasswordField();
		pass1.setBounds(50, 0, 120, 30);
		pass1.setColumns(20);

		JButton button5 = new JButton("OK");
		button5.setBounds(50, 100, 120, 30);
		set_button(button5);

		main_mane_p.add(button1);
		mane_p.add(button2);
		mane_p.add(button3);
		end_mane_p.add(button4);
		pass_p.add(pass1);
		pass_p.add(button5);

		mane_buttons.add(button1);
		mane_buttons.add(button2);
		mane_buttons.add(button3);
		mane_buttons.add(button4);

		getContentPane().add(mane_p, BorderLayout.CENTER);
		getContentPane().add(main_mane_p, BorderLayout.CENTER);
		getContentPane().add(end_mane_p, BorderLayout.CENTER);
		getContentPane().add(pass_p, BorderLayout.CENTER);

	}

	public void set_moneyinfo(List<Money> moneyinfo) {
		int j = 0;
		for (int i = 0; i < moneyinfo.size(); i++) {
			int money_storage = moneyinfo.get(i).get_storage();
			String storage = Integer.toString(money_storage);

			JLabel coin_st_label = new JLabel(storage);
			coin_st_label.setBounds(60 + j, 60, 60, 20);
			coin_st_label.setForeground(Color.BLACK);
			coin_st_label.setBackground(Color.WHITE);
			coin_st_label.setHorizontalAlignment(JLabel.CENTER);
			coin_st_label.setBorder(new LineBorder(Color.BLACK, 2, true));

			JLabel coin_name_label = new JLabel(moneyinfo.get(i).get_name());
			coin_name_label.setBounds(60 + j, 80, 80, 20);
			coin_name_label.setForeground(Color.BLACK);
			coin_name_label.setBackground(Color.WHITE);
			coin_name_label.setHorizontalAlignment(JLabel.CENTER);

			j = j + 80;

			coin_storage_labels.add(coin_st_label);
			coin_name_labels.add(coin_name_label);

		}

		for (int i = 0; i < coin_storage_labels.size(); i++) {
			s_p.add(coin_storage_labels.get(i));
		}

		for (int i = 0; i < coin_storage_labels.size(); i++) {
			coin_storage_labels.get(i).setVisible(false);
		}
		for (int i = 0; i < coin_name_labels.size(); i++) {
			s_p.add(coin_name_labels.get(i));
		}

		for (int i = 0; i < coin_name_labels.size(); i++) {
			coin_name_labels.get(i).setVisible(false);
		}

	}

	public void set_drinkinfo(List<Drink> drinkinfo) {
		int j = 0;
		for (int i = 0; i < drinkinfo.size(); i++) {
			int drink_price = drinkinfo.get(i).get_price();
			int drink_storage = drinkinfo.get(i).get_storage();
			String price = Integer.toString(drink_price);
			String storage = Integer.toString(drink_storage);

			JLabel label = new JLabel();
			label.setBounds(40 + j, 20, 130, 250);
			label.setOpaque(true);
			label.setBackground(Color.WHITE);
			label.setHorizontalAlignment(JLabel.CENTER);

			JLabel st_label = new JLabel(storage);
			st_label.setBounds(46 + j, 0, 80, 20);
			st_label.setForeground(Color.WHITE);
			st_label.setBackground(Color.WHITE);
			st_label.setHorizontalAlignment(JLabel.CENTER);
			st_label.setBorder(new LineBorder(Color.RED, 2, true));

			JButton button = new JButton(price);
			button.setBounds(40 + j, 280, 100, 20);
			button.setEnabled(false);
			set_button(button);
			j = j + 150;

			drink_buttons.add(button);
			drink_labels.add(label);
			storage_labels.add(st_label);
		}

		ImageIcon icon1 = new ImageIcon("files/coke.png");
		ImageIcon icon2 = new ImageIcon("files/poka.png");
		ImageIcon icon3 = new ImageIcon("files/tea.png");
		ImageIcon icon5 = new ImageIcon("files/yudetamago_logo.png");
		ImageIcon icon6 = new ImageIcon("files/haikei2.png");
		ImageIcon icon7 = new ImageIcon("files/frame1.png");
		ImageIcon icon8 = new ImageIcon("files/frame2.png");

		Image smallImg = icon5.getImage().getScaledInstance((int) (icon5.getIconWidth() * 0.15), -1,
				Image.SCALE_SMOOTH);
		Image smallImg2 = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.15), -1,
				Image.SCALE_SMOOTH);
		Image smallImg3 = icon2.getImage().getScaledInstance((int) (icon2.getIconWidth() * 0.40), -1,
				Image.SCALE_SMOOTH);
		Image smallImg4 = icon3.getImage().getScaledInstance((int) (icon3.getIconWidth() * 0.40), -1,
				Image.SCALE_SMOOTH);
		Image smallImg5 = icon7.getImage().getScaledInstance((int) (icon7.getIconWidth() * 0.23), -1,
				Image.SCALE_SMOOTH);
		Image smallImg6 = icon8.getImage().getScaledInstance((int) (icon8.getIconWidth() * 0.3), -1,
				Image.SCALE_SMOOTH);

		ImageIcon smallIcon = new ImageIcon(smallImg);
		ImageIcon coke = new ImageIcon(smallImg2);
		ImageIcon poka = new ImageIcon(smallImg3);
		ImageIcon tea = new ImageIcon(smallImg4);

		ImageIcon frame1 = new ImageIcon(smallImg5);
		ImageIcon frame2 = new ImageIcon(smallImg6);

		drink_labels.get(0).setIcon(coke);
		drink_labels.get(0).setOpaque(false);
		drink_labels.get(1).setIcon(poka);
		drink_labels.get(1).setOpaque(false);
		drink_labels.get(2).setIcon(tea);
		drink_labels.get(2).setOpaque(false);

		JLabel label = new JLabel();
		label.setBounds(0, -50, 900, 800);
		label.setOpaque(false);
		label.setBackground(Color.WHITE);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setIcon(icon6);

		JLabel label2 = new JLabel();
		label2.setBounds(650, 100, 130, 170);
		label2.setOpaque(false);
		label2.setHorizontalAlignment(JLabel.CENTER);
		label2.setIcon(smallIcon);

		JLabel label3 = new JLabel();
		label3.setBounds(590, 250, 280, 500);
		label3.setOpaque(false);
		label3.setHorizontalAlignment(JLabel.CENTER);
		label3.setIcon(frame1);

		JLabel label4 = new JLabel();
		label4.setBounds(80, 420, 500, 200);
		label4.setOpaque(false);
		label4.setHorizontalAlignment(JLabel.CENTER);
		label4.setIcon(frame2);

		for (int i = 0; i < drink_buttons.size(); i++) {
			d_p.add(drink_buttons.get(i));
		}

		for (int i = 0; i < drink_labels.size(); i++) {
			d_p.add(drink_labels.get(i));
		}

		for (int i = 0; i < drink_labels.size(); i++) {
			s_p.add(storage_labels.get(i));
		}

		side_p.add(label3);
		side_p.add(label4);

		side_p.add(label2);
		side_p.add(label);

		getContentPane().add(s_p, BorderLayout.CENTER);
		getContentPane().add(side_p, BorderLayout.CENTER);
		getContentPane().add(d_p, BorderLayout.CENTER);

		getContentPane().add(mother_p, BorderLayout.CENTER);

	}

	public void set_coin_num() {
		int X = 10;
		int Y = 10;
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
