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

	         JPanel panel_1 = new JPanel();
	         panel_1.setBackground(new Color(255, 255, 255));
	         panel_1.setBounds(0, 0, 992, 120);
	         insertPanel.add(panel_1);
	         panel_1.setLayout(null);

	         JPanel panel_3 = new JPanel();
	         panel_3.setBackground(new Color(255, 255, 255));
	         panel_3.setBounds(0, 0, 992, 40);
	         panel_1.add(panel_3);
	         panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

	         JLabel lblOrderNo = new JLabel("\uC8FC\uBB38 \uBC88\uD638");
	         panel_3.add(lblOrderNo);
	         lblOrderNo.setFont(new Font("���� ����", Font.PLAIN, 15));
	         lblOrderNo.setBackground(Color.BLUE);

	         textOrderNo = new JTextField();
	         panel_3.add(textOrderNo);
	         textOrderNo.setFont(new Font("���� ����", Font.PLAIN, 15));
	         textOrderNo.setColumns(10);

	         JLabel lblID = new JLabel("ID");
	         panel_3.add(lblID);
	         lblID.setFont(new Font("���� ����", Font.PLAIN, 15));

	         textID = new JTextField();
	         panel_3.add(textID);
	         textID.setFont(new Font("���� ����", Font.PLAIN, 15));
	         textID.setColumns(10);

	         JLabel lblOrderDate = new JLabel("\uD310\uB9E4 \uB0A0\uC9DC");
	         panel_3.add(lblOrderDate);
	         lblOrderDate.setFont(new Font("���� ����", Font.PLAIN, 15));

	         textOrderDate = new JTextField();
	         panel_3.add(textOrderDate);
	         textOrderDate.setFont(new Font("���� ����", Font.PLAIN, 15));
	         textOrderDate.setColumns(10);

	         JLabel lblProductNo = new JLabel("\uC0C1\uD488 \uBC88\uD638");
	         panel_3.add(lblProductNo);
	         lblProductNo.setFont(new Font("���� ����", Font.PLAIN, 15));

	         textProductNo = new JTextField();
	         panel_3.add(textProductNo);
	         textProductNo.setFont(new Font("���� ����", Font.PLAIN, 15));
	         textProductNo.setColumns(10);

	         JPanel panel_2 = new JPanel();
	         panel_2.setBackground(new Color(255, 255, 255));
	         panel_2.setBounds(0, 40, 992, 40);
	         panel_1.add(panel_2);
	         panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

	         JLabel lblOrderAmount = new JLabel("\uC218\uB7C9");
	         panel_2.add(lblOrderAmount);
	         lblOrderAmount.setFont(new Font("���� ����", Font.PLAIN, 15));

	         textOrderAmount = new JTextField();
	         panel_2.add(textOrderAmount);
	         textOrderAmount.setFont(new Font("���� ����", Font.PLAIN, 15));
	         textOrderAmount.setColumns(10);

	         JComboBox comboBox = new JComboBox(new String[] { "����", "����", "�̻�", "����" });
	         comboBox.setFont(new Font("���� ����", Font.PLAIN, 15));
	         comboBox.setBackground(new Color(255, 255, 255));
	         panel_2.add(comboBox);

	         JLabel lblTotalPrice = new JLabel("\uD310\uB9E4 \uAE08\uC561");
	         panel_2.add(lblTotalPrice);
	         lblTotalPrice.setFont(new Font("���� ����", Font.PLAIN, 15));
	         lblTotalPrice.setBackground(Color.WHITE);

	         textTotalPrice = new JTextField();
	         panel_2.add(textTotalPrice);
	         textTotalPrice.setFont(new Font("���� ����", Font.PLAIN, 15));
	         textTotalPrice.setColumns(10);

	         JComboBox comboBox_1 = new JComboBox(new String[] { "����", "����", "�̻�", "����" });
	         comboBox_1.setFont(new Font("���� ����", Font.PLAIN, 15));
	         comboBox_1.setBackground(new Color(255, 255, 255));
	         panel_2.add(comboBox_1);

	         JLabel lblSum = new JLabel("\uCD1D \uD310\uB9E4\uC561");
	         panel_2.add(lblSum);
	         lblSum.setFont(new Font("���� ����", Font.PLAIN, 15));
	         lblSum.setBackground(Color.BLUE);

	         textSum = new JTextField();
	         
	         panel_2.add(textSum);
	         textSum.setFont(new Font("���� ����", Font.PLAIN, 15));
	         textSum.setColumns(10);

	         JPanel panel = new JPanel();
	         panel.setBackground(new Color(255, 255, 255));
	         panel.setBounds(1003, 536, 169, 120);
	         order.add(panel);
	         panel.setLayout(null);

	         JPanel panel_4 = new JPanel();
	         panel_4.setBackground(new Color(255, 255, 255));
	         panel_4.setBounds(0, 0, 169, 40);
	         panel.add(panel_4);

	         JButton btnSearch = new RoundedButton("\uAC80\uC0C9");
	         panel_4.add(btnSearch);
	         btnSearch.setForeground(new Color(255, 255, 255));
	         btnSearch.setFont(new Font("���� ����", Font.PLAIN, 15));
	         btnSearch.setBackground(new Color(135, 206, 250));

	         JButton btnUpdate = new RoundedButton("\uC218\uC815");
	         panel_4.add(btnUpdate);
	         btnUpdate.setText("\uAC31\uC2E0");
	         btnUpdate.setForeground(new Color(255, 255, 255));
	         btnUpdate.setFont(new Font("���� ����", Font.PLAIN, 15));
	         btnUpdate.setBackground(new Color(135, 206, 250));
	         
	         JPanel panel_5 = new JPanel();
	         panel_5.setBackground(new Color(255, 255, 255));
	         panel_5.setBounds(0, 40, 169, 40);
	         panel.add(panel_5);

	         JButton btnSave = new RoundedButton("\uC800\uC7A5");
	         panel_5.add(btnSave);
	         btnSave.setText("\uCD94\uAC00");
	         btnSave.setForeground(new Color(255, 255, 255));
	         btnSave.setFont(new Font("���� ����", Font.PLAIN, 15));
	         btnSave.setBackground(new Color(135, 206, 250));

	         JButton btnDelete = new RoundedButton("\uC0AD\uC81C");
	         panel_5.add(btnDelete);
	         btnDelete.setForeground(new Color(255, 255, 255));
	         btnDelete.setFont(new Font("���� ����", Font.PLAIN, 15));
	         btnDelete.setBackground(new Color(135, 206, 250));
	         
	         JPanel panel_6 = new JPanel();
	         panel_6.setBackground(new Color(255, 255, 255));
	         panel_6.setBounds(0, 80, 169, 40);
	         panel.add(panel_6);

	         JButton btnReset = new RoundedButton("Reset");
	         panel_6.add(btnReset);
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
							textOrderAmount.getText(), textOrderDate.getText(), textTotalPrice.getText());
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
			while (rs.next()) {
				model.addRow(new Object[] { rs.getInt("orderNo"), rs.getString("ID"), rs.getInt("productNo"),
						rs.getInt("orderAmount"), rs.getString("orderDate"), rs.getInt("totalPrice") });
				sum += rs.getInt("totalPrice");
			}
			String sumResult = formatter.format(sum);
			textSum.setText(sumResult);
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
			String totalPrice) {
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
			while (st.hasMoreTokens()) {
				sql = sql + "Cast(orderAmount as char(10)) like ? or ";
				st.nextToken();
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
			while (st.hasMoreTokens()) {
				sql = sql + "Cast(totalPrice as char(15)) like ? or ";
				st.nextToken();
			}
			sql = sql.substring(0, sql.length() - 3);
			sql = sql + ")";
			sql = sql + " and ";
		}
		sql = sql.substring(0, sql.length() - 4);
		System.out.println(sql);
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
				while (st.hasMoreTokens()) {
					pstmt.setString(idx++, "%" + st.nextToken().trim() + "%");
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
				while (st.hasMoreTokens()) {
					pstmt.setString(idx++, "%" + st.nextToken().trim() + "%");
				}
			}

			rs = pstmt.executeQuery();
			model.setRowCount(0);
			int sum = 0;
			while (rs.next()) {
				model.addRow(new Object[] { rs.getInt("orderNo"), rs.getString("ID"), rs.getInt("productNo"),
						rs.getInt("orderAmount"), rs.getString("orderDate"), rs.getInt("totalPrice") });
				sum += rs.getInt("totalPrice");
			}
			String sumResult = formatter.format(sum);
			textSum.setText(sumResult);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}