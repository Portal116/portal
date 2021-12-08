package Project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class MenuPanel {
	private static JPanel menu = null;

	public MenuPanel() {
		getPanel();
	}

	public static JPanel getPanel() {
		if (menu == null) {
			menu = new JPanel();
			menu.setBackground(Color.WHITE);
			menu.setBounds(0, 0, 1185, 100);
			menu.setLayout(null);

			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(307, 0, 571, 100);
			menu.add(panel);
			panel.setLayout(null);

			RoundedButton btnHome = new RoundedButton("Home");
			btnHome.setBounds(21, 12, 116, 76);
			panel.add(btnHome);
			btnHome.setText("\uCC98\uC74C");
			btnHome.setForeground(SystemColor.text);
			btnHome.setBackground(new Color(135, 206, 250));
			btnHome.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 30));
			btnHome.setPreferredSize(new Dimension(116, 63));
			btnHome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					HomePanel.initVisible(1);
					HomePanel.setMemberNo();
					HomePanel.setSales();
				}
			});

			RoundedButton btnMember = new RoundedButton("\uBA64\uBC84");
			btnMember.setText("\uD68C\uC6D0");
			btnMember.setBounds(158, 12, 116, 76);
			panel.add(btnMember);

			btnMember.setForeground(SystemColor.text);
			btnMember.setBackground(new Color(135, 206, 250));
			btnMember.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 30));
			btnMember.setPreferredSize(new Dimension(116, 63));

			btnMember.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					HomePanel.initVisible(2);
					MemberPanel.getTable();
				}
			});

			RoundedButton btnOrder = new RoundedButton("\uC8FC\uBB38");
			btnOrder.setBounds(295, 12, 116, 76);
			panel.add(btnOrder);
			btnOrder.setForeground(SystemColor.text);
			btnOrder.setBackground(new Color(135, 206, 250));
			btnOrder.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 30));
			btnOrder.setPreferredSize(new Dimension(116, 63));
			btnOrder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					HomePanel.initVisible(3);
					OrderPanel.getTable();
				}
			});

			RoundedButton btnProduct = new RoundedButton("\uC0C1\uD488");
			btnProduct.setBounds(432, 12, 116, 76);
			panel.add(btnProduct);
			btnProduct.setForeground(SystemColor.text);
			btnProduct.setBackground(new Color(135, 206, 250));
			btnProduct.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 30));
			btnProduct.setPreferredSize(new Dimension(116, 63));
			btnProduct.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					HomePanel.initVisible(4);
					ProductPanel.getTable();
				}
			});

		}
		return menu;
	}
}
