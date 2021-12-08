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
import java.sql.SQLException;
import java.util.StringTokenizer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

public class MemberPanel {
	private static JPanel member = null;
	private static Connection conn = DBConnect.getConnection();
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	private static DefaultTableModel model;
	private static JTable table;
	private static JScrollPane j;
	private static JTextField textFieldID;
	private static JTextField textFieldPhone;
	private static JTextField textFieldAddress;
	private static JTextField textFieldName;
	private static RoundedButton btndelete;
	private static RoundedButton btnUpdate;
	private static JPanel panel_1;
	private static StringTokenizer st;
	private static int select = 0;
	private static JPanel panel_2;
	private static JPanel panel_3;
	private static JPanel panel_4;
	private static JPanel panel_5;
	private static JPanel panel_6;
	private static JPanel panel_7;

	public MemberPanel() {
		getPanel();
	}

	@SuppressWarnings("serial")
	public static JPanel getPanel() {
		if (member == null) {
			member = new JPanel();
			member.setBackground(Color.WHITE);
			member.setBounds(0, 100, 1184, 661);
			member.setLayout(null);
			model = new DefaultTableModel(null, new String[] { "ID", "¿Ã∏ß", "¿¸»≠π¯»£", "¡÷º“" }) {
				@Override
				public boolean isCellEditable(int row, int column) {
					// TODO Auto-generated method stub
					return false;
				}
//				@Override
//				public Class<?> getColumnClass(int columnIndex) {
//					if (columnIndex == 0 || columnIndex == 4 || columnIndex == 5)
//						return Integer.class;
//					else
//						return String.class;
//				}
			};
			getTable();
			table = new JTable(model);
			table.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					select = table.getSelectedRow();
					int idx = 0;
					textFieldID.setText((String) model.getValueAt(select, idx++));
					textFieldName.setText((String) model.getValueAt(select, idx++));
					textFieldPhone.setText((String) model.getValueAt(select, idx++));
					textFieldAddress.setText((String) model.getValueAt(select, idx++));
				}
			});
			resizeColumnWidth(table);
			table.setRowSorter(new TableRowSorter<DefaultTableModel>(model));
			table.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			table.getTableHeader().setReorderingAllowed(false);
			table.setRowHeight(30);
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					select = table.getSelectedRow();
					int idx = 0;
					textFieldID.setText((String) model.getValueAt(select, idx++));
					textFieldName.setText((String) model.getValueAt(select, idx++));
					textFieldPhone.setText((String) model.getValueAt(select, idx++));
					textFieldAddress.setText((String) model.getValueAt(select, idx++));
				}
			});
			table.getTableHeader().setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			j = new JScrollPane(table);
			j.getViewport().setBackground(Color.WHITE);
			j.setBounds(12, 10, 1160, 516);
			member.add(j);
			panel_1 = new JPanel();
			panel_1.setBackground(new Color(255, 255, 255));
			panel_1.setBounds(12, 536, 991, 120);
			member.add(panel_1);
			panel_1.setLayout(null);
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 255, 255));
			panel.setBounds(0, 0, 991, 40);
			panel_1.add(panel);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			JLabel IDLabel = new JLabel("ID");
			IDLabel.setHorizontalAlignment(SwingConstants.CENTER);
			IDLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			panel.add(IDLabel);
			textFieldID = new JTextField();
			textFieldID.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			panel.add(textFieldID);
			textFieldID.setColumns(10);
			JLabel nameLabel = new JLabel("\uC774\uB984");
			panel.add(nameLabel);
			nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
			nameLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			textFieldName = new JTextField();
			textFieldName.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			panel.add(textFieldName);
			textFieldName.setColumns(10);
			JLabel phoneLabel = new JLabel("\uC804\uD654\uBC88\uD638");
			phoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
			phoneLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			panel.add(phoneLabel);
			textFieldPhone = new JTextField();
			textFieldPhone.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			panel.add(textFieldPhone);
			textFieldPhone.setColumns(10);
			
			panel_2 = new JPanel();
			panel_2.setBackground(new Color(255, 255, 255));
			panel_2.setBounds(0, 40, 991, 40);
			panel_1.add(panel_2);
			panel_2.setLayout(null);
			
			panel_4 = new JPanel();
			panel_4.setBackground(new Color(255, 255, 255));
			panel_4.setBounds(277, 0, 436, 40);
			panel_2.add(panel_4);
			panel_4.setLayout(null);
			JLabel addressLabel = new JLabel("\uC8FC\uC18C");
			addressLabel.setBounds(12, 9, 30, 21);
			panel_4.add(addressLabel);
			addressLabel.setHorizontalAlignment(SwingConstants.CENTER);
			addressLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			textFieldAddress = new JTextField();
			textFieldAddress.setBounds(54, 6, 372, 27);
			panel_4.add(textFieldAddress);
			textFieldAddress.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			textFieldAddress.setColumns(10);
			
			panel_3 = new JPanel();
			panel_3.setBackground(new Color(255, 255, 255));
			panel_3.setBounds(1003, 536, 169, 120);
			member.add(panel_3);
			panel_3.setLayout(null);
			
			panel_5 = new JPanel();
			panel_5.setBackground(new Color(255, 255, 255));
			panel_5.setBounds(0, 0, 169, 40);
			panel_3.add(panel_5);
			RoundedButton btnSearch = new RoundedButton("\uAC80\uC0C9");
			panel_5.add(btnSearch);
			btnSearch.setForeground(new Color(255, 255, 255));
			btnSearch.setBackground(new Color(135, 206, 250));
			btnSearch.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			btnUpdate = new RoundedButton("\uAC31\uC2E0");
			panel_5.add(btnUpdate);
			btnUpdate.setForeground(new Color(255, 255, 255));
			btnUpdate.setBackground(new Color(135, 206, 250));
			btnUpdate.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			btnUpdate.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String sql = "UPDATE membertbl SET id = ?, name = ?, phonenum = ?, address = ? where id = ?";
					try {
						PreparedStatement pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, textFieldID.getText());
						pstmt.setString(2, textFieldName.getText());
						pstmt.setString(3, textFieldPhone.getText());
						pstmt.setString(4, textFieldAddress.getText());
						pstmt.setString(5, (String)model.getValueAt(select, 0));
						pstmt.executeUpdate();
						model.setRowCount(0);
						getTable();

						if (pstmt != null)
							pstmt.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					searchMember(textFieldID.getText(), textFieldName.getText(), textFieldPhone.getText(),
							textFieldAddress.getText());
				}
			});
			
			panel_6 = new JPanel();
			panel_6.setBackground(new Color(255, 255, 255));
			panel_6.setBounds(0, 40, 169, 40);
			panel_3.add(panel_6);
			RoundedButton btnInsert = new RoundedButton("\uCD94\uAC00");
			panel_6.add(btnInsert);
			btnInsert.setForeground(new Color(255, 255, 255));
			btnInsert.setBackground(new Color(135, 206, 250));
			btnInsert.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			btndelete = new RoundedButton("\uC0AD\uC81C");
			panel_6.add(btndelete);
			btndelete.setForeground(new Color(255, 255, 255));
			btndelete.setBackground(new Color(135, 206, 250));
			btndelete.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			btndelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String sql = "DELETE FROM membertbl where id = ?";
					try {
						PreparedStatement pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, textFieldID.getText());
						pstmt.executeUpdate();
						model.setRowCount(0);
						getTable();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnInsert.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String sql = "INSERT INTO membertbl values(?,?,?,?)";
					try {
						PreparedStatement pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, textFieldID.getText());
						pstmt.setString(2, textFieldPhone.getText());
						pstmt.setString(3, textFieldAddress.getText());
						pstmt.setString(4, textFieldName.getText());
						pstmt.executeUpdate();
						model.setRowCount(0);
						getTable();

						if (pstmt != null)
							pstmt.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
			panel_7 = new JPanel();
			panel_7.setBackground(new Color(255, 255, 255));
			panel_7.setBounds(0, 80, 169, 40);
			panel_3.add(panel_7);
			RoundedButton btnClear = new RoundedButton("\uCD08\uAE30\uD654");
			panel_7.add(btnClear);
			btnClear.setForeground(new Color(255, 255, 255));
			btnClear.setBackground(new Color(135, 206, 250));
			btnClear.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			btnClear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textFieldID.setText("");
					textFieldName.setText("");
					textFieldPhone.setText("");
					textFieldAddress.setText("");
					model.setRowCount(0);
					getTable();
				}
			});
		}
		return member;
	}

	public static void getTable() {
		model.setRowCount(0);
		try {
			String sql = "SELECT * FROM membertbl";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				model.addRow(new Object[] { rs.getString("ID"), rs.getString("name"), rs.getString("phonenum"),
						rs.getString("address") });
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

	private static void searchMember(String id, String name, String phoneNum, String address) {
		System.out.println(id);
		System.out.println(name);
		System.out.println(phoneNum);
		System.out.println(address);
		String sql = "SELECT * FROM membertbl WHERE ";
//		String sql = "SELECT * FROM membertbl WHERE id = ? and name = ? and phonenum = ? and address = ?";
		if (!id.equals("")) {
			st = new StringTokenizer(id, ",");
			sql = sql + "(";
			while (st.hasMoreTokens()) {
				sql = sql + "id like ? or ";
				st.nextToken();
			}
			sql = sql.substring(0, sql.length() - 3);
			sql = sql + ")";
			sql = sql + " and ";
		}
		if (!name.equals("")) {
			st = new StringTokenizer(name, ",");
			sql = sql + "(";

			while (st.hasMoreTokens()) {
				sql = sql + "name like ? or ";
				st.nextToken();
			}
			sql = sql.substring(0, sql.length() - 3);
			sql = sql + ")";
			sql = sql + " and ";
		}
		if (!phoneNum.equals("")) {
			st = new StringTokenizer(phoneNum, ",");
			sql = sql + "(";
			while (st.hasMoreTokens()) {
				sql = sql + "phoneNum like ? or ";
				st.nextToken();
			}
			sql = sql.substring(0, sql.length() - 3);
			sql = sql + ")";
			sql = sql + " and ";
		}
		if (!address.equals("")) {
			st = new StringTokenizer(address, ",");
			sql = sql + "(";
			while (st.hasMoreTokens()) {
				sql = sql + "address like ? or ";
				st.nextToken();
			}
			sql = sql.substring(0, sql.length() - 3);
			sql = sql + ")";
			sql = sql + " and ";
		}
		
		sql = sql.substring(0, sql.length() - 4);
		
		try {
			int idx = 1;
			pstmt = conn.prepareStatement(sql);
			if (!id.equals("")) {
				st = new StringTokenizer(id, ",");
				while (st.hasMoreTokens()) {
					pstmt.setString(idx++, "%"+st.nextToken().trim()+"%");
				}
			}
			if (!name.equals("")) {
				st = new StringTokenizer(name, ",");
				while (st.hasMoreTokens()) {
					pstmt.setString(idx++, "%"+st.nextToken().trim()+"%");
				}
			}
			if (!phoneNum.equals("")) {
				st = new StringTokenizer(phoneNum, ",");
				while (st.hasMoreTokens()) {
					pstmt.setString(idx++, "%"+st.nextToken().trim()+"%");
				}
			}
			if (!address.equals("")) {
				st = new StringTokenizer(address, ",");
				while (st.hasMoreTokens()) {
					pstmt.setString(idx++, "%"+st.nextToken().trim()+"%");
				}
			}
			System.out.println(sql);
			rs = pstmt.executeQuery();
			model.setRowCount(0);
			while (rs.next()) {
				model.addRow(new Object[] { rs.getString("ID"), rs.getString("name"), rs.getString("phonenum"),
						rs.getString("address") });
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
