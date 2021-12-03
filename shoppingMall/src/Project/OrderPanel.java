package Project;

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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

public class OrderPanel {
	private static JPanel order = null;
	private static Connection con = DBConnect.getConnection();
	private static JTable tableMain = null;
	private static JTextField textOrderNo;
	private static JTextField textID;
	private static JTextField textOrderAmount;
	private static JTextField textOrderDate;
	private static JTextField textProductNo;
	private static JTextField textTotalPrice;
	public static String[] col_name = { "�ֹ� ��ȣ", "ID", "��ǰ ��ȣ", "����", "�Ǹ� ��¥", "�Ǹ� ����" };
	public static DefaultTableModel model;
	public static PreparedStatement pstmt = null;
	public static ResultSet rs = null;
	private static JTextField textSum;
	private static List<Integer> selectRows = new ArrayList<>();
	private static StringTokenizer st;
	private static DecimalFormat formatter = new DecimalFormat("###,###,###,###");
	private static JTextField textLineSum;
	private static JComboBox comboBoxTotalPrice;
	private static JComboBox comboBoxOrderAmount;

	public OrderPanel() {
		getPanel();
	}

	public static JPanel getPanel() {
		// TODO Auto-generated method stub
		if (order == null) {
			order = new JPanel();
			order.setBackground(Color.WHITE);

			order.setBounds(0, 100, 1184, 661);

			model = new DefaultTableModel(null, col_name) {
				public Class<?> getColumnClass(int columnIndex) {
					if (columnIndex == 0 || columnIndex == 2 || columnIndex == 3 || columnIndex == 5)
						return Integer.class;
					else
						return String.class;
				}

				@Override
				public boolean isCellEditable(int row, int column) {
					// TODO Auto-generated method stub
					return false;
				}

			};
			tableMain = new JTable(model);
			resizeColumnWidth(tableMain);
			tableMain.setFont(new Font("���� ����", Font.PLAIN, 15));
			tableMain.getTableHeader().setReorderingAllowed(false);
			tableMain.setRowHeight(30);
			tableMain.getTableHeader().setFont(new Font("���� ����", Font.PLAIN, 15));

			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment(JLabel.CENTER);
			tableMain.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
			tableMain.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
			tableMain.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
			tableMain.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
			tableMain.getColumnModel().getColumn(5).setCellRenderer(new RightNumberRenderer());

//			������ �����ؼ� �� �Ǹž� ��� �뵵
			tableMain.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					int temp = tableMain.getSelectedRow();
					selectRows.clear();
					selectRows.addAll(0,
							Arrays.asList(Arrays.stream(tableMain.getSelectedRows()).boxed().toArray(Integer[]::new)));
					int sum = 0;
					for (Integer i : selectRows) {
						sum += ((int) model.getValueAt(i, 5));
					}
					String sumResult = formatter.format(sum);
					textSum.setText(sumResult);
					textLineSum.setText(Integer.toString(selectRows.size()));
				}
			});

			tableMain.addMouseListener(new MouseAdapter() {
//				������ �����ؼ� �� �Ǹž� ��� �뵵
				@Override
				public void mouseReleased(MouseEvent e) {
					selectRows.clear();
					selectRows.addAll(0,
							Arrays.asList(Arrays.stream(tableMain.getSelectedRows()).boxed().toArray(Integer[]::new)));
					int sum = 0;
					for (Integer i : selectRows) {
						sum += ((int) model.getValueAt(i, 5));
					}
					String sumResult = formatter.format(sum);
					textSum.setText(sumResult);
					textLineSum.setText(Integer.toString(selectRows.size()));
				}

//				Ŭ���� �� text�� ��ȯ
				@Override
				public void mousePressed(MouseEvent e) {
					int temp = tableMain.getSelectedRow();
					textOrderNo.setText(Integer.toString((Integer) model.getValueAt(temp, 0)));
					textID.setText((String) (model.getValueAt(temp, 1)));
					textProductNo.setText(Integer.toString((Integer) model.getValueAt(temp, 2)));
					textOrderAmount.setText(Integer.toString((Integer) model.getValueAt(temp, 3)));
					textOrderDate.setText((String) model.getValueAt(temp, 4));
					textTotalPrice.setText(Integer.toString((Integer) model.getValueAt(temp, 5)));
				}
			});

			JScrollPane scrollPane = new JScrollPane(tableMain);
			scrollPane.setBounds(12, 10, 1160, 516);
			scrollPane.getViewport().setBackground(Color.WHITE);
			tableMain.setAutoCreateRowSorter(true);
			TableRowSorter tablesorter = new TableRowSorter(tableMain.getModel());
			order.setLayout(null);
			tableMain.setRowSorter(tablesorter);

			scrollPane.setViewportView(tableMain);
			order.add(scrollPane);

			JPanel insertPanel = new JPanel();
			insertPanel.setBounds(12, 536, 991, 120);
			order.add(insertPanel);
			insertPanel.setLayout(null);

			JPanel insertPanel2 = new JPanel();
			insertPanel2.setBackground(new Color(255, 255, 255));
			insertPanel2.setBounds(0, 0, 992, 120);
			insertPanel.add(insertPanel2);
			insertPanel2.setLayout(null);

			JPanel insertPanelTop = new JPanel();
			insertPanelTop.setBackground(new Color(255, 255, 255));
			insertPanelTop.setBounds(0, 0, 992, 40);
			insertPanel2.add(insertPanelTop);
			insertPanelTop.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

			JLabel lblOrderNo = new JLabel("\uC8FC\uBB38 \uBC88\uD638");
			insertPanelTop.add(lblOrderNo);
			lblOrderNo.setFont(new Font("���� ����", Font.PLAIN, 15));
			lblOrderNo.setBackground(Color.BLUE);

			textOrderNo = new JTextField();
			insertPanelTop.add(textOrderNo);
			textOrderNo.setFont(new Font("���� ����", Font.PLAIN, 15));
			textOrderNo.setColumns(10);

			JLabel lblID = new JLabel("ID");
			insertPanelTop.add(lblID);
			lblID.setFont(new Font("���� ����", Font.PLAIN, 15));

			textID = new JTextField();
			insertPanelTop.add(textID);
			textID.setFont(new Font("���� ����", Font.PLAIN, 15));
			textID.setColumns(10);

			JLabel lblOrderDate = new JLabel("\uD310\uB9E4 \uB0A0\uC9DC");
			insertPanelTop.add(lblOrderDate);
			lblOrderDate.setFont(new Font("���� ����", Font.PLAIN, 15));

			textOrderDate = new JTextField();
			insertPanelTop.add(textOrderDate);
			textOrderDate.setFont(new Font("���� ����", Font.PLAIN, 15));
			textOrderDate.setColumns(10);

			JLabel lblProductNo = new JLabel("\uC0C1\uD488 \uBC88\uD638");
			insertPanelTop.add(lblProductNo);
			lblProductNo.setFont(new Font("���� ����", Font.PLAIN, 15));

			textProductNo = new JTextField();
			insertPanelTop.add(textProductNo);
			textProductNo.setFont(new Font("���� ����", Font.PLAIN, 15));
			textProductNo.setColumns(10);

			JPanel insertPanelMiddle = new JPanel();
			insertPanelMiddle.setBackground(new Color(255, 255, 255));
			insertPanelMiddle.setBounds(0, 40, 992, 40);
			insertPanel2.add(insertPanelMiddle);
			insertPanelMiddle.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

			JLabel lblOrderAmount = new JLabel("\uC218\uB7C9");
			lblOrderAmount.setToolTipText("");
			insertPanelMiddle.add(lblOrderAmount);
			lblOrderAmount.setFont(new Font("���� ����", Font.PLAIN, 15));

			textOrderAmount = new JTextField();
			textOrderAmount.setToolTipText("");
			insertPanelMiddle.add(textOrderAmount);
			textOrderAmount.setFont(new Font("���� ����", Font.PLAIN, 15));
			textOrderAmount.setColumns(10);

			comboBoxOrderAmount = new JComboBox(new String[] { "����", "����", "�̻�", "����" });
			comboBoxOrderAmount.setFont(new Font("���� ����", Font.PLAIN, 15));
			comboBoxOrderAmount.setBackground(new Color(255, 255, 255));
			insertPanelMiddle.add(comboBoxOrderAmount);

			JLabel lblTotalPrice = new JLabel("\uD310\uB9E4 \uAE08\uC561");
			insertPanelMiddle.add(lblTotalPrice);
			lblTotalPrice.setFont(new Font("���� ����", Font.PLAIN, 15));
			lblTotalPrice.setBackground(Color.WHITE);

			textTotalPrice = new JTextField();
			textTotalPrice.setToolTipText("");
			insertPanelMiddle.add(textTotalPrice);
			textTotalPrice.setFont(new Font("���� ����", Font.PLAIN, 15));
			textTotalPrice.setColumns(10);

			comboBoxTotalPrice = new JComboBox(new String[] { "����", "����", "�̻�", "����" });
			comboBoxTotalPrice.setFont(new Font("���� ����", Font.PLAIN, 15));
			comboBoxTotalPrice.setBackground(new Color(255, 255, 255));
			insertPanelMiddle.add(comboBoxTotalPrice);

			JPanel insertPanelBottom = new JPanel();
			insertPanelBottom.setBackground(Color.WHITE);
			insertPanelBottom.setBounds(0, 80, 992, 40);
			insertPanel2.add(insertPanelBottom);
			insertPanelBottom.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

			JLabel lblLineSum = new JLabel("\uCD9C\uB825(\uC120\uD0DD)\uB41C \uD589");
			lblLineSum.setFont(new Font("���� ����", Font.PLAIN, 15));
			lblLineSum.setBackground(Color.BLUE);
			insertPanelBottom.add(lblLineSum);

			textLineSum = new JTextField();
			textLineSum.setText("0");
			textLineSum.setFont(new Font("���� ����", Font.PLAIN, 15));
			textLineSum.setColumns(10);
			insertPanelBottom.add(textLineSum);

			JLabel lblSum = new JLabel("\uCD1D \uD310\uB9E4\uC561");
			insertPanelBottom.add(lblSum);
			lblSum.setFont(new Font("���� ����", Font.PLAIN, 15));
			lblSum.setBackground(Color.BLUE);

			textSum = new JTextField();
			insertPanelBottom.add(textSum);
			textSum.setFont(new Font("���� ����", Font.PLAIN, 15));
			textSum.setColumns(10);

			JPanel buttonPanel = new JPanel();
			buttonPanel.setBackground(new Color(255, 255, 255));
			buttonPanel.setBounds(1003, 536, 169, 120);
			order.add(buttonPanel);
			buttonPanel.setLayout(null);

			JPanel buttonPanelTop = new JPanel();
			buttonPanelTop.setBackground(new Color(255, 255, 255));
			buttonPanelTop.setBounds(0, 0, 169, 40);
			buttonPanel.add(buttonPanelTop);

			JButton btnSearch = new RoundedButton("\uAC80\uC0C9");
			buttonPanelTop.add(btnSearch);
			btnSearch.setForeground(new Color(255, 255, 255));
			btnSearch.setFont(new Font("���� ����", Font.PLAIN, 15));
			btnSearch.setBackground(new Color(135, 206, 250));

			JButton btnUpdate = new RoundedButton("\uC218\uC815");
			buttonPanelTop.add(btnUpdate);
			btnUpdate.setText("\uAC31\uC2E0");
			btnUpdate.setForeground(new Color(255, 255, 255));
			btnUpdate.setFont(new Font("���� ����", Font.PLAIN, 15));
			btnUpdate.setBackground(new Color(135, 206, 250));

			JPanel buttonPanelMiddle = new JPanel();
			buttonPanelMiddle.setBackground(new Color(255, 255, 255));
			buttonPanelMiddle.setBounds(0, 40, 169, 40);
			buttonPanel.add(buttonPanelMiddle);

			JButton btnSave = new RoundedButton("\uC800\uC7A5");
			buttonPanelMiddle.add(btnSave);
			btnSave.setText("\uCD94\uAC00");
			btnSave.setForeground(new Color(255, 255, 255));
			btnSave.setFont(new Font("���� ����", Font.PLAIN, 15));
			btnSave.setBackground(new Color(135, 206, 250));

			JButton btnDelete = new RoundedButton("\uC0AD\uC81C");
			buttonPanelMiddle.add(btnDelete);
			btnDelete.setForeground(new Color(255, 255, 255));
			btnDelete.setFont(new Font("���� ����", Font.PLAIN, 15));
			btnDelete.setBackground(new Color(135, 206, 250));

			JPanel buttonPanelBottom = new JPanel();
			buttonPanelBottom.setBackground(new Color(255, 255, 255));
			buttonPanelBottom.setBounds(0, 80, 169, 40);
			buttonPanel.add(buttonPanelBottom);

			JButton btnReset = new RoundedButton("Reset");
			buttonPanelBottom.add(btnReset);
			btnReset.setText("\uCD08\uAE30\uD654");
			btnReset.setForeground(new Color(255, 255, 255));
			btnReset.setFont(new Font("���� ����", Font.PLAIN, 15));
			btnReset.setBackground(new Color(135, 206, 250));

			// �ֹ�����
			btnReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textOrderNo.setText("");
					textID.setText("");
					textProductNo.setText("");
					textOrderAmount.setText("");
					textOrderDate.setText("");
					textTotalPrice.setText("");
					getTable();
				}
			});

			// �ֹ����� �����ϱ� - ID, ��ǰ��ȣ, ����, �ֹ���¥�� �Է� / �ֹ���ȣ�� AI, ������ Ʈ���ŷ� �ڵ�
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String sql = "INSERT INTO ordertbl(ID, productNo, orderAmount, orderDate) VALUES(?, ?, ?, ?)";
					try {
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, textID.getText());
						pstmt.setInt(2, Integer.parseInt(textProductNo.getText()));
						pstmt.setInt(3, Integer.parseInt(textOrderAmount.getText()));
						String date = textOrderDate.getText();
						java.sql.Date sDate = java.sql.Date.valueOf(date);
						pstmt.setDate(4, sDate);
						pstmt.executeUpdate();
						getTable();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});

			// �ֹ����� �����ϱ� - �ֹ���ȣ�� ����
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String sql = "DELETE FROM ordertbl WHERE orderNo = ?";
					try {
						pstmt = con.prepareStatement(sql);
						pstmt.setInt(1, Integer.parseInt(textOrderNo.getText()));
						pstmt.executeUpdate();
						getTable();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});
			// �ֹ����� ������ ���� �ϱ�
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String sql = "UPDATE ordertbl SET ID=?, productNo=?, "
							+ " orderAmount=?, orderDate=? WHERE orderNo = ?";
					try {
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, textID.getText());
						pstmt.setInt(2, Integer.parseInt(textProductNo.getText()));
						pstmt.setInt(3, Integer.parseInt(textOrderAmount.getText()));
						String date = textOrderDate.getText();
						java.sql.Date sDate = java.sql.Date.valueOf(date);
						pstmt.setDate(4, sDate);
						pstmt.setInt(5, Integer.parseInt(textOrderNo.getText()));
						pstmt.executeUpdate();
						getTable();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});

			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					searchOrder(textOrderNo.getText(), textID.getText(), textProductNo.getText(),
							textOrderAmount.getText(), textOrderDate.getText(), textTotalPrice.getText(),
							comboBoxOrderAmount.getSelectedIndex(), comboBoxTotalPrice.getSelectedIndex());
				}
			});

			getTable();
		}
		return order;
	}

	public static void getTable() {
		model.setRowCount(0);
		try {
			String query = "SELECT * FROM ordertbl";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			int sum = 0;
			int idx1 = 0;
			while (rs.next()) {
				model.addRow(new Object[] { rs.getInt("orderNo"), rs.getString("ID"), rs.getInt("productNo"),
						rs.getInt("orderAmount"), rs.getString("orderDate"), rs.getInt("totalPrice") });
				sum += rs.getInt("totalPrice");
				idx1++;
			}
			String sumResult = formatter.format(sum);
			textSum.setText(sumResult);
			textLineSum.setText(Integer.toString(idx1));
		} catch (Exception e) {
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

	public static void searchOrder(String orderNo, String ID, String productNo, String orderAmount, String orderDate,
			String totalPrice, int comboOrderAmount, int comboTotalPrice) {
		String sql = "SELECT * FROM ordertbl WHERE ";

		if (!orderNo.equals("")) {
			st = new StringTokenizer(orderNo, ",");
			sql = sql + "(";
			while (st.hasMoreTokens()) {
				sql = sql + "Cast(orderNo as char(10)) like ? or ";
				st.nextToken();
			}
			sql = sql.substring(0, sql.length() - 3);
			sql = sql + ")";
			sql = sql + " and ";
		}
		if (!ID.equals("")) {
			st = new StringTokenizer(ID, ",");
			sql = sql + "(";
			while (st.hasMoreTokens()) {
				sql = sql + "ID like ? or ";
				st.nextToken();
			}
			sql = sql.substring(0, sql.length() - 3);
			sql = sql + ")";
			sql = sql + " and ";
		}
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
		if (!orderAmount.equals("")) {
			st = new StringTokenizer(orderAmount, ",");
			sql = sql + "(";
			switch (comboOrderAmount) {
			case (0):
				while(st.hasMoreTokens()) {
					sql = sql + "orderAmount = ? or ";
					st.nextToken();
				}				
				break;
			case (1):
				while (st.hasMoreTokens()) {
					sql = sql + "Cast(orderAmount as char(10)) like ? or ";
					st.nextToken();
				}
				break;
			case (2):
				while(st.hasMoreTokens()) {
					sql = sql + "orderAmount >= ? or ";
					st.nextToken();
				}
				break;
			case (3):
				while(st.hasMoreTokens()) {
					sql = sql + "orderAmount <= ? or ";
					st.nextToken();
				}
				break;
			}
			sql = sql.substring(0, sql.length() - 3);
			sql = sql + ")";
			sql = sql + " and ";
		}
		if (!orderDate.equals("")) {
			st = new StringTokenizer(orderDate, ",");
			sql = sql + "(";
			while (st.hasMoreTokens()) {
				sql = sql + "orderDate like ? or ";
				st.nextToken();
			}
			sql = sql.substring(0, sql.length() - 3);
			sql = sql + ")";
			sql = sql + " and ";
		}
		if (!totalPrice.equals("")) {
			st = new StringTokenizer(totalPrice, ",");
			sql = sql + "(";
			switch (comboTotalPrice) {
			case (0):
				while(st.hasMoreTokens()) {
					sql = sql + "totalPrice = ? or ";
					st.nextToken();
				}				
				break;
			case (1):
				while (st.hasMoreTokens()) {
					sql = sql + "Cast(totalPrice as char(15)) like ? or ";
					st.nextToken();
				}
				break;
			case (2):
				while(st.hasMoreTokens()) {
					sql = sql + "totalPrice >= ? or ";
					st.nextToken();
				}
				break;
			case (3):
				while(st.hasMoreTokens()) {
					sql = sql + "totalPrice <= ? or ";
					st.nextToken();
				}
				break;
			}
			sql = sql.substring(0, sql.length() - 3);
			sql = sql + ")";
			sql = sql + " and ";
		}
		sql = sql.substring(0, sql.length() - 4);
		try {
			pstmt = con.prepareStatement(sql);
			int idx = 1;
			if (!orderNo.equals("")) {
				st = new StringTokenizer(orderNo, ",");
				while (st.hasMoreTokens()) {
					pstmt.setString(idx++, "%" + st.nextToken().trim() + "%");
				}
			}
			if (!ID.equals("")) {
				st = new StringTokenizer(ID, ",");
				while (st.hasMoreTokens()) {
					pstmt.setString(idx++, "%" + st.nextToken().trim() + "%");
				}
			}
			if (!productNo.equals("")) {
				st = new StringTokenizer(productNo, ",");
				while (st.hasMoreTokens()) {
					pstmt.setString(idx++, "%" + st.nextToken().trim() + "%");
				}
			}
			if (!orderAmount.equals("")) {
				st = new StringTokenizer(orderAmount, ",");
				switch (comboOrderAmount) {
				case (1):
					while (st.hasMoreTokens()) {
						pstmt.setString(idx++, "%" + st.nextToken().trim() + "%");
					}
					break;
				default:
					while(st.hasMoreTokens()) {
						pstmt.setInt(idx++, Integer.parseInt(st.nextToken().trim()));
					}
					break;
				}				
			}
			if (!orderDate.equals("")) {
				st = new StringTokenizer(orderDate, ",");
				while (st.hasMoreTokens()) {
					pstmt.setString(idx++, "%" + st.nextToken().trim() + "%");
				}
			}
			if (!totalPrice.equals("")) {
				st = new StringTokenizer(totalPrice, ",");
				switch (comboTotalPrice) {
				case (1):
					while (st.hasMoreTokens()) {
						pstmt.setString(idx++, "%" + st.nextToken().trim() + "%");
					}
					break;
				default:
					while(st.hasMoreTokens()) {
						pstmt.setInt(idx++, Integer.parseInt(st.nextToken().trim()));
					}
					break;
				}				
			}

			rs = pstmt.executeQuery();
			model.setRowCount(0);
			int sum = 0;
			int idx2 = 0;
			while (rs.next()) {
				model.addRow(new Object[] { rs.getInt("orderNo"), rs.getString("ID"), rs.getInt("productNo"),
						rs.getInt("orderAmount"), rs.getString("orderDate"), rs.getInt("totalPrice") });
				sum += rs.getInt("totalPrice");
				idx2++;
			}
			String sumResult = formatter.format(sum);
			textSum.setText(sumResult);
			textLineSum.setText(Integer.toString(idx2));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}