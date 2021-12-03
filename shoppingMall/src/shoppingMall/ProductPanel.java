package shoppingMall;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
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
	private static JTextField textPNo;
	private static JTextField textPName;
	private static JTextField textCost;
	private static JTextField textPrice;
	private static JTextField textAmount;
	private static JTextField textReDate;
	private static JTextField textType;
	private static StringTokenizer st;
	private static JTextField textField;
	private static JOptionPane dialog = new JOptionPane();
	private static int select = 0;
	private static int selectRows = 0;

	public ProductPanel() {
		getPanel();
	}

	@SuppressWarnings("serial")
	public static JPanel getPanel() {
		if (product == null) {
			product = new JPanel();
			product.setBackground(new Color(255, 0, 0, 0));
			product.setBounds(0, 100, 1184, 661);
			product.setLayout(null);
			model = new DefaultTableModel(null, new String[] { "»óÇ°¹øÈ£", "»óÇ°¸í", "ºÐ·ù", "¿ø°¡", "ÆÇ¸Å°¡", "¼ö·®", "ÀÔ°í³¯Â¥" }) {
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

			table = new JTable(model);
			resizeColumnWidth(table);
			table.setRowSorter(new TableRowSorter<DefaultTableModel>(model));
			table.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
			table.getTableHeader().setReorderingAllowed(false);
			table.setRowHeight(30);
			table.getTableHeader().setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
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

					textPNo.setText(Integer.toString((Integer) model.getValueAt(select, idx++)));
					textPName.setText((String) model.getValueAt(select, idx++));
					textType.setText((String) model.getValueAt(select, idx++));
					textCost.setText(Integer.toString((Integer) model.getValueAt(select, idx++)));
					textPrice.setText(Integer.toString((Integer) model.getValueAt(select, idx++)));
					textAmount.setText(Integer.toString((Integer) model.getValueAt(select, idx++)));
					textReDate.setText((String) model.getValueAt(select, idx++));
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					textField.setText(Integer.toString(table.getSelectedRowCount()));
				}
			});
			table.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					int idx = 0;
					select = table.getSelectedRow();
					textField.setText(Integer.toString(table.getSelectedRowCount()));
					textPNo.setText(Integer.toString((Integer) model.getValueAt(select, idx++)));
					textPName.setText((String) model.getValueAt(select, idx++));
					textType.setText((String) model.getValueAt(select, idx++));
					textCost.setText(Integer.toString((Integer) model.getValueAt(select, idx++)));
					textPrice.setText(Integer.toString((Integer) model.getValueAt(select, idx++)));
					textAmount.setText(Integer.toString((Integer) model.getValueAt(select, idx++)));
					textReDate.setText((String) model.getValueAt(select, idx++));
				}
			});
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.getViewport().setBackground(Color.WHITE);
			scrollPane.setBounds(12, 10, 1160, 516);
			product.add(scrollPane);
			JPanel panel = new JPanel();
			panel.setBackground(UIManager.getColor("Button.disabledShadow"));
			panel.setLayout(null);
			panel.setBounds(12, 536, 991, 120);
			product.add(panel);
			JPanel infoPanel = new JPanel();
			infoPanel.setBackground(UIManager.getColor("Button.disabledShadow"));
			infoPanel.setBounds(0, 0, 991, 120);
			panel.add(infoPanel);
			infoPanel.setLayout(null);
			JPanel infoPanel_1 = new JPanel();
			infoPanel_1.setBackground(UIManager.getColor("Button.disabledShadow"));
			infoPanel_1.setBounds(0, 0, 991, 40);
			infoPanel.add(infoPanel_1);
			infoPanel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			JLabel lblPNo = new JLabel("\uC0C1\uD488\uBC88\uD638");
			infoPanel_1.add(lblPNo);
			lblPNo.setHorizontalAlignment(SwingConstants.CENTER);
			lblPNo.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
			textPNo = new JTextField();
			infoPanel_1.add(textPNo);
			textPNo.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
			textPNo.setColumns(10);
			JLabel lblPName = new JLabel("\uC0C1\uD488\uBA85");
			infoPanel_1.add(lblPName);
			lblPName.setHorizontalAlignment(SwingConstants.CENTER);
			lblPName.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
			textPName = new JTextField();
			infoPanel_1.add(textPName);
			textPName.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
			textPName.setColumns(10);
			JLabel lblType = new JLabel("\uBD84\uB958");
			infoPanel_1.add(lblType);
			lblType.setHorizontalAlignment(SwingConstants.CENTER);
			lblType.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
			textType = new JTextField();
			infoPanel_1.add(textType);
			textType.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
			textType.setColumns(10);
			JPanel infoPanel_2 = new JPanel();
			infoPanel_2.setBackground(UIManager.getColor("Button.disabledShadow"));
			infoPanel_2.setBounds(0, 40, 991, 40);
			infoPanel.add(infoPanel_2);
			infoPanel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			JLabel lblCost = new JLabel("\uC6D0\uAC00");
			infoPanel_2.add(lblCost);
			lblCost.setHorizontalAlignment(SwingConstants.CENTER);
			lblCost.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
			textCost = new JTextField();
			infoPanel_2.add(textCost);
			textCost.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
			textCost.setColumns(10);
			JComboBox comboBoxCost = new JComboBox(new String[] { "´ÜÀÏ", "Æ÷ÇÔ", "ÀÌ»ó", "ÀÌÇÏ" });
			comboBoxCost.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
			comboBoxCost.setBackground(Color.WHITE);
			infoPanel_2.add(comboBoxCost);
			JLabel lblPrice = new JLabel("\uD310\uB9E4\uAC00");
			infoPanel_2.add(lblPrice);
			lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
			lblPrice.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
			textPrice = new JTextField();
			infoPanel_2.add(textPrice);
			textPrice.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
			textPrice.setColumns(10);
			JComboBox comboBoxPrice = new JComboBox(new String[] { "´ÜÀÏ", "Æ÷ÇÔ", "ÀÌ»ó", "ÀÌÇÏ" });
			comboBoxPrice.setBackground(Color.WHITE);
			comboBoxPrice.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
			infoPanel_2.add(comboBoxPrice);
			JPanel infoPanel_3 = new JPanel();
			infoPanel_3.setBackground(UIManager.getColor("Button.disabledShadow"));
			infoPanel_3.setBounds(0, 80, 991, 40);
			infoPanel.add(infoPanel_3);
			infoPanel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			JLabel lblAmount = new JLabel("\uC218\uB7C9");
			lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
			lblAmount.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
			infoPanel_3.add(lblAmount);
			textAmount = new JTextField();
			textAmount.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
			textAmount.setColumns(10);
			infoPanel_3.add(textAmount);
			JComboBox comboBoxAmount = new JComboBox(new String[] { "´ÜÀÏ", "Æ÷ÇÔ", "ÀÌ»ó", "ÀÌÇÏ" });
			comboBoxAmount.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
			comboBoxAmount.setBackground(Color.WHITE);
			infoPanel_3.add(comboBoxAmount);
			JLabel lblReDate = new JLabel("\uC785\uACE0\uB0A0\uC9DC");
			lblReDate.setHorizontalAlignment(SwingConstants.CENTER);
			lblReDate.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
			infoPanel_3.add(lblReDate);
			textReDate = new JTextField("yyyy-MM-dd");
			textReDate.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
			textReDate.setColumns(10);
			textReDate.setToolTipText("yyyy-MM-dd");
			infoPanel_3.add(textReDate);
			
			JLabel selectCntLabel = new JLabel("\uC218");
			selectCntLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
			infoPanel_3.add(selectCntLabel);

			textField = new JTextField();
			textField.setEditable(false);
			textField.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
			textField.setColumns(10);
			infoPanel_3.add(textField);

			JPanel panel_1 = new JPanel();
			panel_1.setBackground(UIManager.getColor("Button.disabledShadow"));
			panel_1.setBounds(1003, 536, 169, 120);
			product.add(panel_1);
			panel_1.setLayout(null);

			JPanel panel_2 = new JPanel();
			panel_2.setBackground(UIManager.getColor("Button.disabledShadow"));
			panel_2.setBounds(0, 0, 169, 40);
			panel_1.add(panel_2);
			RoundedButton btnSearch = new RoundedButton("\uAC80\uC0C9");
			panel_2.add(btnSearch);
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (textType.getText().trim().equals("ºÐ·ù") || textPName.getText().trim().equals("»óÇ°¸í")) {
						if (textType.getText().trim().equals("ºÐ·ù"))
							distinctSearch("ºÐ·ù");
						if (textPName.getText().trim().equals("»óÇ°¸í"))
							distinctSearch("»óÇ°¸í");
					} else {
						searchProduct(textPNo.getText(), textPName.getText(), textType.getText(), textCost.getText(),
								textPrice.getText(), textAmount.getText(), textReDate.getText(),
								comboBoxCost.getSelectedIndex(), comboBoxPrice.getSelectedIndex(),
								comboBoxAmount.getSelectedIndex());
					}
					textField.setText(Integer.toString(model.getRowCount()));
				}
			});
			btnSearch.setForeground(Color.WHITE);
			btnSearch.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
			btnSearch.setBackground(new Color(135, 206, 250));
			RoundedButton btnUpdate = new RoundedButton("\uAC31\uC2E0");
			panel_2.add(btnUpdate);
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setUpdate();
				}
			});
			btnUpdate.setForeground(Color.WHITE);
			btnUpdate.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
			btnUpdate.setBackground(new Color(135, 206, 250));

			JPanel panel_3 = new JPanel();
			panel_3.setBackground(UIManager.getColor("Button.disabledShadow"));
			panel_3.setBounds(0, 40, 169, 40);
			panel_1.add(panel_3);
			RoundedButton btnInsert = new RoundedButton("\uCD94\uAC00");
			panel_3.add(btnInsert);
			btnInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setInsert();
				}
			});
			btnInsert.setForeground(Color.WHITE);
			btnInsert.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
			btnInsert.setBackground(new Color(135, 206, 250));
			RoundedButton btnDelete = new RoundedButton("\uC0AD\uC81C");
			panel_3.add(btnDelete);
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setDelete();
				}
			});
			btnDelete.setForeground(Color.WHITE);
			btnDelete.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
			btnDelete.setBackground(new Color(135, 206, 250));

			JPanel panel_4 = new JPanel();
			panel_4.setBackground(UIManager.getColor("Button.disabledShadow"));
			panel_4.setBounds(0, 80, 169, 40);
			panel_1.add(panel_4);
			RoundedButton btnClear = new RoundedButton("\uCD08\uAE30\uD654");
			panel_4.add(btnClear);
			btnClear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setClear();
				}
			});
			btnClear.setForeground(Color.WHITE);
			btnClear.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
			btnClear.setBackground(new Color(135, 206, 250));

			BufferedImage image = null;
			try {
				image = ImageIO.read(new File("./source/1.jpg"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			JLabel imageLabel = new JLabel(new ImageIcon(image));
			imageLabel.setBounds(0, -100, 1184, 761);
//			imageLabel.setPreferredSize(new Dimension(1184, 661));
			product.add(imageLabel);
			getTable();
		}
		return product;
	}

	private static void setClear() {
		textPNo.setText("");
		textPName.setText("");
		textType.setText("");
		textCost.setText("");
		textPrice.setText("");
		textAmount.setText("");
		textReDate.setText("");
		model.setRowCount(0);
		getTable();
	}

	private static void setDelete() {
		String sql = "DELETE FROM producttbl where productNo = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(textPNo.getText()));
			pstmt.executeUpdate();
			model.setRowCount(0);
			getTable();
			if (pstmt != null)
				pstmt.close();
		} catch (SQLException e1) {
			String error = "ÁÖ¹® ³»¿ªÀÌ ÀÖ´Â »óÇ°ÀÌ¶ó »èÁ¦ÇÒ ¼ö ¾ø½À´Ï´Ù.";
			JLabel lblError = new JLabel(error);
			lblError.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
			dialog.showMessageDialog(null, lblError, "Error", JOptionPane.PLAIN_MESSAGE);
		}
	}

	private static void setInsert() {
		String sql = "INSERT INTO producttbl values(?,?,?,?,?,?,?)";
		try {
			int idx = 1;
			String date = textReDate.getText();
			java.sql.Date sDate = java.sql.Date.valueOf(date);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(idx++, Integer.parseInt(textPNo.getText()));
			pstmt.setString(idx++, textPName.getText());
			pstmt.setString(idx++, textType.getText());
			pstmt.setInt(idx++, Integer.parseInt(textCost.getText()));
			pstmt.setInt(idx++, Integer.parseInt(textPrice.getText()));
			pstmt.setInt(idx++, Integer.parseInt(textAmount.getText()));
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

	private static void setUpdate() {
		String sql = "UPDATE producttbl SET productNo = ?, productName = ?, productType = ?, cost = ?, price = ?, amount = ?, receivedDate = ? where productNo = ?";
		try {
			int idx = 1;
			String date = textReDate.getText();
			java.sql.Date sDate = java.sql.Date.valueOf(date);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(idx++, Integer.parseInt(textPNo.getText()));
			pstmt.setString(idx++, textPName.getText());
			pstmt.setString(idx++, textType.getText());
			pstmt.setInt(idx++, Integer.parseInt(textCost.getText()));
			pstmt.setInt(idx++, Integer.parseInt(textPrice.getText()));
			pstmt.setInt(idx++, Integer.parseInt(textAmount.getText()));
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

	private static void distinctSearch(String sel) {
		model.setRowCount(0);
		String sql = "";
		if (sel.trim().equals("»óÇ°¸í"))
			sql = "SELECT DISTINCT productName FROM producttbl";
		else if (sel.trim().equals("ºÐ·ù"))
			sql = "SELECT DISTINCT productType FROM producttbl";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (sel.trim().equals("»óÇ°¸í"))
					model.addRow(new Object[] { null, rs.getString("productName"), null, null, null, null, null });
				else if (sel.trim().equals("ºÐ·ù"))
					model.addRow(new Object[] { null, null, rs.getString("producttype"), null, null, null, null });
			}
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			textField.setText(Integer.toString(model.getRowCount()));
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
		// 0 ´ÜÀÏ 1 Æ÷ÇÔ 2 ÀÌ»ó 3 ÀÌÇÏ
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
			case 0:// ´ÜÀÏ
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
			case 1:// Æ÷ÇÔ
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
			case 2:// ÀÌ»ó
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
			default:// ÀÌÇÏ
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
			case 0:// ´ÜÀÏ
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
			case 1:// Æ÷ÇÔ
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
			case 2:// ÀÌ»ó
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
			default:// ÀÌÇÏ
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
			case 0:// ´ÜÀÏ
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
			case 1:// Æ÷ÇÔ
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
			case 2:// ÀÌ»ó
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
			default:// ÀÌÇÏ
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
				case 1: // Æ÷ÇÔ
					st = new StringTokenizer(cost, ",");
					while (st.hasMoreTokens()) {
						pstmt.setString(idx++, "%" + st.nextToken().trim() + "%");
					}
					break;
				default: // ´ÜÀÏ, ÀÌ»ó, ÀÌÇÏ
					st = new StringTokenizer(cost, ",");
					while (st.hasMoreTokens()) {
						pstmt.setInt(idx++, Integer.parseInt(st.nextToken()));
					}
					break;
				}
			}
			if (!price.equals("")) {
				switch (b) {
				case 1: // Æ÷ÇÔ
					st = new StringTokenizer(price, ",");
					while (st.hasMoreTokens()) {
						pstmt.setString(idx++, "%" + st.nextToken().trim() + "%");
					}
					break;
				default: // ´ÜÀÏ, ÀÌ»ó, ÀÌÇÏ
					st = new StringTokenizer(price, ",");
					while (st.hasMoreTokens()) {
						pstmt.setInt(idx++, Integer.parseInt(st.nextToken()));
					}
					break;
				}
			}
			if (!amount.equals("")) {
				switch (c) {
				case 1: // Æ÷ÇÔ
					st = new StringTokenizer(amount, ",");
					while (st.hasMoreTokens()) {
						pstmt.setString(idx++, "%" + st.nextToken().trim() + "%");
					}
					break;
				default: // ´ÜÀÏ, ÀÌ»ó, ÀÌÇÏ
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
