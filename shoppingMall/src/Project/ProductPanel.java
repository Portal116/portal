package Project;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

public class ProductPanel {
	private static JPanel product = null;
	private static Connection conn = DBConnect.getConnection();
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	private static DefaultTableModel model;
	private static JTable table;
	private static JTextField textFieldPNo;
	private static JTextField textFieldPName;
	private static JTextField textFieldCost;
	private static JTextField textFieldPrice;
	private static JTextField textFieldAmount;
	private static JTextField textFieldDate;
	private static int select = 0;
	private static JTextField textFieldType;
	private static StringTokenizer st;

	public ProductPanel() {
		getPanel();
	}

	@SuppressWarnings("serial")
	public static JPanel getPanel() {
		if (product == null) {
			product = new JPanel();
			product.setBackground(Color.WHITE);
			product.setBounds(0, 100, 1184, 661);
			product.setLayout(null);
			model = new DefaultTableModel(null, new String[] { "ªÛ«∞π¯»£", "ªÛ«∞∏Ì", "∫–∑˘", "ø¯∞°", "∆«∏≈∞°", "ºˆ∑Æ", "¿‘∞Ì≥Ø¬•" }) {
				public Class<?> getColumnClass(int columnIndex) {
					if (columnIndex == 0 || columnIndex == 3 || columnIndex == 4 || columnIndex == 5)
						return Integer.class;
					else
						return String.class;
					
				}
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			getTable();
			table = new JTable(model);
			resizeColumnWidth(table);
			table.setRowSorter(new TableRowSorter<DefaultTableModel>(model));
			table.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			table.getTableHeader().setReorderingAllowed(false);
			table.setRowHeight(30);
			table.getTableHeader().setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment(JLabel.CENTER);
			table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
			table.getColumnModel().getColumn(3).setCellRenderer(new RightNumberRenderer());
			table.getColumnModel().getColumn(4).setCellRenderer(new RightNumberRenderer());
			table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
			table.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
			
			
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					int idx = 0;
					select = table.getSelectedRow();
					textFieldPNo.setText(Integer.toString((Integer) model.getValueAt(select, idx++)));
					textFieldPName.setText((String) model.getValueAt(select, idx++));
					textFieldType.setText((String) model.getValueAt(select, idx++));
					textFieldCost.setText(Integer.toString((Integer) model.getValueAt(select, idx++)));
					textFieldPrice.setText(Integer.toString((Integer) model.getValueAt(select, idx++)));
					textFieldAmount.setText(Integer.toString((Integer) model.getValueAt(select, idx++)));
					textFieldDate.setText((String) model.getValueAt(select, idx++));
				}
			});
			table.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					int idx = 0;
					select = table.getSelectedRow();
					textFieldPNo.setText(Integer.toString((Integer) model.getValueAt(select, idx++)));
					textFieldPName.setText((String) model.getValueAt(select, idx++));
					textFieldType.setText((String) model.getValueAt(select, idx++));
					textFieldCost.setText(Integer.toString((Integer) model.getValueAt(select, idx++)));
					textFieldPrice.setText(Integer.toString((Integer) model.getValueAt(select, idx++)));
					textFieldAmount.setText(Integer.toString((Integer) model.getValueAt(select, idx++)));
					textFieldDate.setText((String) model.getValueAt(select, idx++));
				}
			});
			JScrollPane j = new JScrollPane(table);
			j.getViewport().setBackground(Color.WHITE);
			j.setBounds(12, 10, 1160, 516);
			product.add(j);
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBounds(12, 536, 991, 120);
			product.add(panel);
			JPanel infoPanel = new JPanel();
			infoPanel.setBackground(new Color(255, 255, 255));
			infoPanel.setBounds(0, 0, 991, 120);
			panel.add(infoPanel);
			infoPanel.setLayout(null);
			JPanel infoPanel_1 = new JPanel();
			infoPanel_1.setBackground(new Color(255, 255, 255));
			infoPanel_1.setBounds(0, 0, 991, 40);
			infoPanel.add(infoPanel_1);
			infoPanel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			JLabel pnoLabel = new JLabel("\uC0C1\uD488\uBC88\uD638");
			infoPanel_1.add(pnoLabel);
			pnoLabel.setHorizontalAlignment(SwingConstants.CENTER);
			pnoLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			textFieldPNo = new JTextField();
			infoPanel_1.add(textFieldPNo);
			textFieldPNo.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			textFieldPNo.setColumns(10);
			JLabel IDLabel_1 = new JLabel("\uC0C1\uD488\uBA85");
			infoPanel_1.add(IDLabel_1);
			IDLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			IDLabel_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			textFieldPName = new JTextField();
			infoPanel_1.add(textFieldPName);
			textFieldPName.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			textFieldPName.setColumns(10);
			JLabel typeLabel = new JLabel("\uBD84\uB958");
			infoPanel_1.add(typeLabel);
			typeLabel.setHorizontalAlignment(SwingConstants.CENTER);
			typeLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			textFieldType = new JTextField();
			infoPanel_1.add(textFieldType);
			textFieldType.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			textFieldType.setColumns(10);
			JPanel infoPanel_2 = new JPanel();
			infoPanel_2.setBackground(new Color(255, 255, 255));
			infoPanel_2.setBounds(0, 40, 991, 40);
			infoPanel.add(infoPanel_2);
			infoPanel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			JLabel IDLabel_2 = new JLabel("\uC6D0\uAC00");
			infoPanel_2.add(IDLabel_2);
			IDLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			IDLabel_2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			textFieldCost = new JTextField();
			infoPanel_2.add(textFieldCost);
			textFieldCost.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			textFieldCost.setColumns(10);
			JComboBox comboBoxCost = new JComboBox(new String[] { "¥‹¿œ", "∆˜«‘", "¿ÃªÛ", "¿Ã«œ" });
			comboBoxCost.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			comboBoxCost.setBackground(Color.WHITE);
			infoPanel_2.add(comboBoxCost);
			JLabel IDLabel_3 = new JLabel("\uD310\uB9E4\uAC00");
			infoPanel_2.add(IDLabel_3);
			IDLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			IDLabel_3.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			textFieldPrice = new JTextField();
			infoPanel_2.add(textFieldPrice);
			textFieldPrice.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			textFieldPrice.setColumns(10);
			JComboBox comboBoxPrice = new JComboBox(new String[] { "¥‹¿œ", "∆˜«‘", "¿ÃªÛ", "¿Ã«œ" });
			comboBoxPrice.setBackground(Color.WHITE);
			comboBoxPrice.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			infoPanel_2.add(comboBoxPrice);
			JPanel infoPanel_3 = new JPanel();
			infoPanel_3.setBackground(new Color(255, 255, 255));
			infoPanel_3.setBounds(0, 80, 991, 40);
			infoPanel.add(infoPanel_3);
			infoPanel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			JLabel IDLabel_1_1 = new JLabel("\uC218\uB7C9");
			IDLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			IDLabel_1_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			infoPanel_3.add(IDLabel_1_1);
			textFieldAmount = new JTextField();
			textFieldAmount.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			textFieldAmount.setColumns(10);
			infoPanel_3.add(textFieldAmount);
			JComboBox comboBoxAmount = new JComboBox(new String[] { "¥‹¿œ", "∆˜«‘", "¿ÃªÛ", "¿Ã«œ" });
			comboBoxAmount.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			comboBoxAmount.setBackground(Color.WHITE);
			infoPanel_3.add(comboBoxAmount);
			JLabel IDLabel_2_1 = new JLabel("\uC785\uACE0\uB0A0\uC9DC");
			IDLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
			IDLabel_2_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			infoPanel_3.add(IDLabel_2_1);
			textFieldDate = new JTextField("yyyy-MM-dd");
			textFieldDate.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			textFieldDate.setColumns(10);
			textFieldDate.setToolTipText("yyyy-MM-dd");
			infoPanel_3.add(textFieldDate);

			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(255, 255, 255));
			panel_1.setBounds(1003, 536, 169, 120);
			product.add(panel_1);
			panel_1.setLayout(null);

			JPanel panel_2 = new JPanel();
			panel_2.setBackground(new Color(255, 255, 255));
			panel_2.setBounds(0, 0, 169, 40);
			panel_1.add(panel_2);
			RoundedButton btnSearch = new RoundedButton("\uAC80\uC0C9");
			panel_2.add(btnSearch);
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					searchProduct(textFieldPNo.getText(), textFieldPName.getText(), textFieldType.getText(),
							textFieldCost.getText(), textFieldPrice.getText(), textFieldAmount.getText(),
							textFieldDate.getText(), comboBoxCost.getSelectedIndex(), comboBoxPrice.getSelectedIndex(),
							comboBoxAmount.getSelectedIndex());
				}
			});
			btnSearch.setForeground(Color.WHITE);
			btnSearch.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			btnSearch.setBackground(new Color(135, 206, 250));
			RoundedButton btnUpdate = new RoundedButton("\uAC31\uC2E0");
			panel_2.add(btnUpdate);
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String sql = "UPDATE producttbl SET productNo = ?, productName = ?, productType = ?, cost = ?, price = ?, amount = ?, receivedDate = ? where productNo = ?";
					try {
						int idx = 1;
						String date = textFieldDate.getText();
						java.sql.Date sDate = java.sql.Date.valueOf(date);
						pstmt = conn.prepareStatement(sql);
						pstmt.setInt(idx++, Integer.parseInt(textFieldPNo.getText()));
						pstmt.setString(idx++, textFieldPName.getText());
						pstmt.setString(idx++, textFieldType.getText());
						pstmt.setInt(idx++, Integer.parseInt(textFieldCost.getText()));
						pstmt.setInt(idx++, Integer.parseInt(textFieldPrice.getText()));
						pstmt.setInt(idx++, Integer.parseInt(textFieldAmount.getText()));
						pstmt.setDate(idx++, sDate);
						pstmt.setInt(idx++, (Integer) model.getValueAt(select, 0));
						System.out.println(select);
						pstmt.executeUpdate();
						model.setRowCount(0);
						getTable();
						if (pstmt != null)
							pstmt.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			btnUpdate.setForeground(Color.WHITE);
			btnUpdate.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			btnUpdate.setBackground(new Color(135, 206, 250));

			JPanel panel_3 = new JPanel();
			panel_3.setBackground(new Color(255, 255, 255));
			panel_3.setBounds(0, 40, 169, 40);
			panel_1.add(panel_3);
			RoundedButton btnInsert = new RoundedButton("\uCD94\uAC00");
			panel_3.add(btnInsert);
			btnInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String sql = "INSERT INTO producttbl values(?,?,?,?,?,?,?)";
					try {
						int idx = 1;
						String date = textFieldDate.getText();
						java.sql.Date sDate = java.sql.Date.valueOf(date);
						pstmt = conn.prepareStatement(sql);
						pstmt.setInt(idx++, Integer.parseInt(textFieldPNo.getText()));
						pstmt.setString(idx++, textFieldPName.getText());
						pstmt.setString(idx++, textFieldType.getText());
						pstmt.setInt(idx++, Integer.parseInt(textFieldCost.getText()));
						pstmt.setInt(idx++, Integer.parseInt(textFieldPrice.getText()));
						pstmt.setInt(idx++, Integer.parseInt(textFieldAmount.getText()));
						pstmt.setDate(idx, sDate);
						pstmt.executeUpdate();
						model.setRowCount(0);
						getTable();
						if (pstmt != null)
							pstmt.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (IllegalArgumentException e1) {
						e1.printStackTrace();
					}
				}
			});
			btnInsert.setForeground(Color.WHITE);
			btnInsert.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			btnInsert.setBackground(new Color(135, 206, 250));
			RoundedButton btnDelete = new RoundedButton("\uC0AD\uC81C");
			panel_3.add(btnDelete);
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String sql = "DELETE FROM producttbl where productNo = ?";
					try {
						pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, Integer.parseInt(textFieldPNo.getText()));
						pstmt.executeUpdate();
						model.setRowCount(0);
						getTable();
						if (pstmt != null)
							pstmt.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			btnDelete.setForeground(Color.WHITE);
			btnDelete.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			btnDelete.setBackground(new Color(135, 206, 250));

			JPanel panel_4 = new JPanel();
			panel_4.setBackground(new Color(255, 255, 255));
			panel_4.setBounds(0, 80, 169, 40);
			panel_1.add(panel_4);
			RoundedButton btnClear = new RoundedButton("\uCD08\uAE30\uD654");
			panel_4.add(btnClear);
			btnClear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textFieldPNo.setText("");
					textFieldPName.setText("");
					textFieldType.setText("");
					textFieldCost.setText("");
					textFieldPrice.setText("");
					textFieldAmount.setText("");
					textFieldDate.setText("");
					model.setRowCount(0);
					getTable();
				}
			});
			btnClear.setForeground(Color.WHITE);
			btnClear.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			btnClear.setBackground(new Color(135, 206, 250));
		}
		return product;
	}

	public static void getTable() {
		model.setRowCount(0);
		try {
			String sql = "SELECT * FROM producttbl";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				model.addRow(new Object[] { rs.getInt("productNo"), rs.getString("productName"),
						rs.getString("producttype"), rs.getInt("cost"), rs.getInt("price"), rs.getInt("amount"),
						rs.getString("receivedDate") });
			}
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void resizeColumnWidth(JTable table) {
		final TableColumnModel columnModel = table.getColumnModel();
		for (int column = 0; column < table.getColumnCount(); column++) {
			int width = 15; // Min width
			for (int row = 0; row < table.getRowCount(); row++) {
				TableCellRenderer renderer = table.getCellRenderer(row, column);
				Component comp = table.prepareRenderer(renderer, row, column);
				width = Math.max(comp.getPreferredSize().width + 1, width);
			}
			if (width > 300)
				width = 300;
			columnModel.getColumn(column).setPreferredWidth(width);
		}
	}

	public static void searchProduct(String productNo, String productName, String productType, String cost,
			String price, String amount, String receivedDate, int a, int b, int c) {
		// 0 ¥‹¿œ 1 ∆˜«‘ 2 ¿ÃªÛ 3 ¿Ã«œ
		String sql = "SELECT * FROM producttbl WHERE ";
//		String sql = "select * from producttbl where Cast(price as char) like ?";
		if (!productNo.equals("")) {
			st = new StringTokenizer(productNo, ",");
			sql = sql + "(";
			while (st.hasMoreTokens()) {
				sql = sql + "Cast(productNo as char(10)) like ? or ";
				st.nextToken();
			}
			sql = sql.substring(0, sql.length() - 3);
			sql = sql + ")";
			sql = sql + " and ";
		}
		if (!productName.equals("")) {
			st = new StringTokenizer(productName, ",");
			sql = sql + "(";
			while (st.hasMoreTokens()) {
				sql = sql + "productName like ? or ";
				st.nextToken();
			}
			sql = sql.substring(0, sql.length() - 3);
			sql = sql + ")";
			sql = sql + " and ";
		}
		if (!productType.equals("")) {
			st = new StringTokenizer(productType, ",");
			sql = sql + "(";
			while (st.hasMoreTokens()) {
				sql = sql + "productType like ? or ";
				st.nextToken();
			}
			sql = sql.substring(0, sql.length() - 3);
			sql = sql + ")";
			sql = sql + " and ";
		}
		if (!cost.equals("")) {
			switch (a) {
			case 0:// ¥‹¿œ
				st = new StringTokenizer(cost, ",");
				sql = sql + "(";
				while (st.hasMoreTokens()) {
					sql = sql + "cost = ? or ";
					st.nextToken();
				}
				sql = sql.substring(0, sql.length() - 3);
				sql = sql + ")";
				sql = sql + " and ";
				break;
			case 1:// ∆˜«‘
				st = new StringTokenizer(cost, ",");
				sql = sql + "(";
				while (st.hasMoreTokens()) {
					sql = sql + "Cast(cost as char(10)) like ? or ";
					st.nextToken();
				}
				sql = sql.substring(0, sql.length() - 3);
				sql = sql + ")";
				sql = sql + " and ";
				break;
			case 2:// ¿ÃªÛ
				st = new StringTokenizer(cost, ",");
				sql = sql + "(";
				while (st.hasMoreTokens()) {
					sql = sql + "cost >= ? or ";
					st.nextToken();
				}
				sql = sql.substring(0, sql.length() - 3);
				sql = sql + ")";
				sql = sql + " and ";
				break;
			default:// ¿Ã«œ
				st = new StringTokenizer(cost, ",");
				sql = sql + "(";
				while (st.hasMoreTokens()) {
					sql = sql + "cost <= ? or ";
					st.nextToken();
				}
				sql = sql.substring(0, sql.length() - 3);
				sql = sql + ")";
				sql = sql + " and ";
				break;
			}
		}
		if (!price.equals("")) {
			switch (b) {
			case 0:// ¥‹¿œ
				st = new StringTokenizer(price, ",");
				sql = sql + "(";
				while (st.hasMoreTokens()) {
					sql = sql + "price = ? or ";
					st.nextToken();
				}
				sql = sql.substring(0, sql.length() - 3);
				sql = sql + ")";
				sql = sql + " and ";
				break;
			case 1:// ∆˜«‘
				st = new StringTokenizer(price, ",");
				sql = sql + "(";
				while (st.hasMoreTokens()) {
					sql = sql + "Cast(price as char(10)) like ? or ";
					st.nextToken();
				}
				sql = sql.substring(0, sql.length() - 3);
				sql = sql + ")";
				sql = sql + " and ";
				break;
			case 2:// ¿ÃªÛ
				st = new StringTokenizer(price, ",");
				sql = sql + "(";
				while (st.hasMoreTokens()) {
					sql = sql + "price >= ? or ";
					st.nextToken();
				}
				sql = sql.substring(0, sql.length() - 3);
				sql = sql + ")";
				sql = sql + " and ";
				break;
			default:// ¿Ã«œ
				st = new StringTokenizer(price, ",");
				sql = sql + "(";
				while (st.hasMoreTokens()) {
					sql = sql + "price <= ? or ";
					st.nextToken();
				}
				sql = sql.substring(0, sql.length() - 3);
				sql = sql + ")";
				sql = sql + " and ";
				break;
			}
		}
		if (!amount.equals("")) {
			switch (c) {
			case 0:// ¥‹¿œ
				st = new StringTokenizer(amount, ",");
				sql = sql + "(";
				while (st.hasMoreTokens()) {
					sql = sql + "amount = ? or ";
					st.nextToken();
				}
				sql = sql.substring(0, sql.length() - 3);
				sql = sql + ")";
				sql = sql + " and ";
				break;
			case 1:// ∆˜«‘
				st = new StringTokenizer(amount, ",");
				sql = sql + "(";
				while (st.hasMoreTokens()) {
					sql = sql + "Cast(amount as char(10)) like ? or ";
					st.nextToken();
				}
				sql = sql.substring(0, sql.length() - 3);
				sql = sql + ")";
				sql = sql + " and ";
				break;
			case 2:// ¿ÃªÛ
				st = new StringTokenizer(amount, ",");
				sql = sql + "(";
				while (st.hasMoreTokens()) {
					sql = sql + "amount >= ? or ";
					st.nextToken();
				}
				sql = sql.substring(0, sql.length() - 3);
				sql = sql + ")";
				sql = sql + " and ";
				break;
			default:// ¿Ã«œ
				st = new StringTokenizer(amount, ",");
				sql = sql + "(";
				while (st.hasMoreTokens()) {
					sql = sql + "amount <= ? or ";
					st.nextToken();
				}
				sql = sql.substring(0, sql.length() - 3);
				sql = sql + ")";
				sql = sql + " and ";
				break;
			}
		}
		if (!receivedDate.equals("")) {
			st = new StringTokenizer(receivedDate, ",");
			sql = sql + "(";
			while (st.hasMoreTokens()) {
				sql = sql + "receivedDate like ? or ";
				st.nextToken();
			}
			sql = sql.substring(0, sql.length() - 3);
			sql = sql + ")";
			sql = sql + " and ";
		}
		sql = sql.substring(0, sql.length() - 4);
		System.out.println(sql);
		try {
			int idx = 1;
//			String sql = "select * from producttbl where Cast(price as char) like ?";
			pstmt = conn.prepareStatement(sql);
			if (!productNo.equals("")) {
				st = new StringTokenizer(productNo, ",");
				while (st.hasMoreTokens()) {
					pstmt.setString(idx++, "%" + st.nextToken().trim() + "%");
				}
			}
			if (!productName.equals("")) {
				st = new StringTokenizer(productName, ",");
				while (st.hasMoreTokens()) {
					pstmt.setString(idx++, "%" + st.nextToken().trim() + "%");
				}
			}
			if (!productType.equals("")) {
				st = new StringTokenizer(productType, ",");
				while (st.hasMoreTokens()) {
					pstmt.setString(idx++, "%" + st.nextToken().trim() + "%");
				}
			}
			if (!cost.equals("")) {
				switch (a) {
				case 1: // ∆˜«‘
					st = new StringTokenizer(cost, ",");
					while (st.hasMoreTokens()) {
						pstmt.setString(idx++, "%" + st.nextToken().trim() + "%");
					}
					break;
				default: // ¥‹¿œ, ¿ÃªÛ, ¿Ã«œ
					st = new StringTokenizer(cost, ",");
					while (st.hasMoreTokens()) {
						pstmt.setInt(idx++, Integer.parseInt(st.nextToken()));
					}
					break;
				}
			}
			if (!price.equals("")) {
				switch (b) {
				case 1: // ∆˜«‘
					st = new StringTokenizer(price, ",");
					while (st.hasMoreTokens()) {
						pstmt.setString(idx++, "%" + st.nextToken().trim() + "%");
					}
					break;
				default: // ¥‹¿œ, ¿ÃªÛ, ¿Ã«œ
					st = new StringTokenizer(price, ",");
					while (st.hasMoreTokens()) {
						pstmt.setInt(idx++, Integer.parseInt(st.nextToken()));
					}
					break;
				}
			}
			if (!amount.equals("")) {
				switch (c) {
				case 1: // ∆˜«‘
					st = new StringTokenizer(amount, ",");
					while (st.hasMoreTokens()) {
						pstmt.setString(idx++, "%" + st.nextToken().trim() + "%");
					}
					break;
				default: // ¥‹¿œ, ¿ÃªÛ, ¿Ã«œ
					st = new StringTokenizer(amount, ",");
					while (st.hasMoreTokens()) {
						pstmt.setInt(idx++, Integer.parseInt(st.nextToken()));
					}
					break;
				}
			}
			if (!receivedDate.equals("")) {
				st = new StringTokenizer(receivedDate, ",");
				while (st.hasMoreTokens()) {
					pstmt.setString(idx++, "%" + st.nextToken().trim() + "%");
				}
			}
//			pstmt.setString(1, "%5%");
			rs = pstmt.executeQuery();
			model.setRowCount(0);
			while (rs.next()) {
				model.addRow(new Object[] { rs.getInt("productNo"), rs.getString("productName"),
						rs.getString("producttype"), rs.getInt("cost"), rs.getInt("price"), rs.getInt("amount"),
						rs.getString("receivedDate") });
			}
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}

