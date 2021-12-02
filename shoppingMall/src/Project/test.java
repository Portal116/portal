//package Project;
//
//import java.awt.Color;
//import java.awt.Component;
//import java.awt.Font;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.StringTokenizer;
//
//import javax.swing.JButton;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.JTextField;
//import javax.swing.SwingConstants;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableCellRenderer;
//import javax.swing.table.TableColumnModel;
//import javax.swing.table.TableRowSorter;
//
//public class ProductPanel {
//   private static JPanel product = null;
//   private static Connection conn = DBConnect.getConnection();
//   private static PreparedStatement pstmt;
//   private static ResultSet rs;
//   private static DefaultTableModel model;
//   private static JTable table;
//   private static JTextField textFieldPNo;
//   private static JTextField textFieldPName;
//   private static JTextField textFieldCost;
//   private static JTextField textFieldPrice;
//   private static JTextField textFieldAmount;
//   private static JTextField textFieldDate;
//   private static int select = 0;
//   private static JTextField textFieldType;
//   private static StringTokenizer st;
//
//   public ProductPanel() {
//      getPanel();
//   }
//
//   @SuppressWarnings("serial")
//   public static JPanel getPanel() {
//      if (product == null) {
//         product = new JPanel();
//         product.setBounds(0, 100, 1184, 700);
//         product.setLayout(null);
//         model = new DefaultTableModel(null, new String[] { "��ǰ��ȣ", "��ǰ��", "�з�", "����", "�ǸŰ�", "����", "�԰���¥" }) {
//            @Override
//            public boolean isCellEditable(int row, int column) {
//               return false;
//            }
//         };
//         getTable();
//         table = new JTable(model);
//         resizeColumnWidth(table);
//         table.setRowSorter(new TableRowSorter<DefaultTableModel>(model));
//         table.setFont(new Font("���� ����", Font.PLAIN, 15));
//         table.getTableHeader().setReorderingAllowed(false);
//         table.setRowHeight(30);
//         table.getTableHeader().setFont(new Font("���� ����", Font.PLAIN, 15));
//         table.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent e) {
//               int idx = 0;
//               select = table.getSelectedRow();
//               textFieldPNo.setText(Integer.toString((Integer) model.getValueAt(select, idx++)));
//               textFieldPName.setText((String) model.getValueAt(select, idx++));
//               textFieldType.setText((String) model.getValueAt(select, idx++));
//               textFieldCost.setText(Integer.toString((Integer) model.getValueAt(select, idx++)));
//               textFieldPrice.setText(Integer.toString((Integer) model.getValueAt(select, idx++)));
//               textFieldAmount.setText(Integer.toString((Integer) model.getValueAt(select, idx++)));
//               textFieldDate.setText((String) model.getValueAt(select, idx++));
//            }
//         });
//         table.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyReleased(KeyEvent e) {
//               int idx = 0;
//               select = table.getSelectedRow();
//               textFieldPNo.setText(Integer.toString((Integer) model.getValueAt(select, idx++)));
//               textFieldPName.setText((String) model.getValueAt(select, idx++));
//               textFieldType.setText((String) model.getValueAt(select, idx++));
//               textFieldCost.setText(Integer.toString((Integer) model.getValueAt(select, idx++)));
//               textFieldPrice.setText(Integer.toString((Integer) model.getValueAt(select, idx++)));
//               textFieldAmount.setText(Integer.toString((Integer) model.getValueAt(select, idx++)));
//               textFieldDate.setText((String) model.getValueAt(select, idx++));
//            }
//         });
//         JScrollPane j = new JScrollPane(table);
//         j.getViewport().setBackground(Color.WHITE);
//         j.setBounds(12, 10, 1160, 439);
//         product.add(j);
//         JPanel panel = new JPanel();
//         panel.setLayout(null);
//         panel.setBounds(25, 480, 1119, 120);
//         product.add(panel);
//         JPanel infoPanel = new JPanel();
//         infoPanel.setBounds(0, 0, 851, 120);
//         panel.add(infoPanel);
//         infoPanel.setLayout(null);
//         JPanel infoPanel_1 = new JPanel();
//         infoPanel_1.setBounds(13, 10, 824, 27);
//         infoPanel.add(infoPanel_1);
//         infoPanel_1.setLayout(new GridLayout(0, 6, 0, 0));
//         JLabel pnoLabel = new JLabel("\uC0C1\uD488\uBC88\uD638");
//         infoPanel_1.add(pnoLabel);
//         pnoLabel.setHorizontalAlignment(SwingConstants.CENTER);
//         pnoLabel.setFont(new Font("���� ����", Font.PLAIN, 15));
//         textFieldPNo = new JTextField();
//         infoPanel_1.add(textFieldPNo);
//         textFieldPNo.setFont(new Font("���� ����", Font.PLAIN, 15));
//         textFieldPNo.setColumns(10);
//         JLabel IDLabel_1 = new JLabel("\uC0C1\uD488\uBA85");
//         infoPanel_1.add(IDLabel_1);
//         IDLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
//         IDLabel_1.setFont(new Font("���� ����", Font.PLAIN, 15));
//         textFieldPName = new JTextField();
//         infoPanel_1.add(textFieldPName);
//         textFieldPName.setFont(new Font("���� ����", Font.PLAIN, 15));
//         textFieldPName.setColumns(10);
//         JLabel typeLabel = new JLabel("\uBD84\uB958");
//         infoPanel_1.add(typeLabel);
//         typeLabel.setHorizontalAlignment(SwingConstants.CENTER);
//         typeLabel.setFont(new Font("���� ����", Font.PLAIN, 15));
//         textFieldType = new JTextField();
//         infoPanel_1.add(textFieldType);
//         textFieldType.setFont(new Font("���� ����", Font.PLAIN, 15));
//         textFieldType.setColumns(10);
//         JPanel infoPanel_2 = new JPanel();
//         infoPanel_2.setBounds(13, 47, 824, 27);
//         infoPanel.add(infoPanel_2);
//         infoPanel_2.setLayout(new GridLayout(0, 6, 0, 0));
//         JLabel IDLabel_2 = new JLabel("\uC6D0\uAC00");
//         infoPanel_2.add(IDLabel_2);
//         IDLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
//         IDLabel_2.setFont(new Font("���� ����", Font.PLAIN, 15));
//         textFieldCost = new JTextField();
//         infoPanel_2.add(textFieldCost);
//         textFieldCost.setFont(new Font("���� ����", Font.PLAIN, 15));
//         textFieldCost.setColumns(10);
//         JLabel IDLabel_3 = new JLabel("\uD310\uB9E4\uAC00");
//         infoPanel_2.add(IDLabel_3);
//         IDLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
//         IDLabel_3.setFont(new Font("���� ����", Font.PLAIN, 15));
//         textFieldPrice = new JTextField();
//         infoPanel_2.add(textFieldPrice);
//         textFieldPrice.setFont(new Font("���� ����", Font.PLAIN, 15));
//         textFieldPrice.setColumns(10);
//         JPanel infoPanel_3 = new JPanel();
//         infoPanel_3.setBounds(13, 83, 824, 27);
//         infoPanel.add(infoPanel_3);
//         infoPanel_3.setLayout(new GridLayout(0, 6, 0, 0));
//         JLabel IDLabel_1_1 = new JLabel("\uC218\uB7C9");
//         IDLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
//         IDLabel_1_1.setFont(new Font("���� ����", Font.PLAIN, 15));
//         infoPanel_3.add(IDLabel_1_1);
//         textFieldAmount = new JTextField();
//         textFieldAmount.setFont(new Font("���� ����", Font.PLAIN, 15));
//         textFieldAmount.setColumns(10);
//         infoPanel_3.add(textFieldAmount);
//         JLabel IDLabel_2_1 = new JLabel("\uC785\uACE0\uB0A0\uC9DC");
//         IDLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
//         IDLabel_2_1.setFont(new Font("���� ����", Font.PLAIN, 15));
//         infoPanel_3.add(IDLabel_2_1);
//         textFieldDate = new JTextField("yyyy-MM-dd");
//         textFieldDate.setFont(new Font("���� ����", Font.PLAIN, 15));
//         textFieldDate.setColumns(10);
//         textFieldDate.setToolTipText("yyyy-MM-dd");
//         infoPanel_3.add(textFieldDate);
//         JButton btnInsert = new JButton("insert");
//         btnInsert.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//               String sql = "INSERT INTO producttbl values(?,?,?,?,?,?,?)";
//               try {
//                  int idx = 1;
//                  String date = textFieldDate.getText();
//                  java.sql.Date sDate = java.sql.Date.valueOf(date);
//                  pstmt = conn.prepareStatement(sql);
//                  pstmt.setInt(idx++, Integer.parseInt(textFieldPNo.getText()));
//                  pstmt.setString(idx++, textFieldPName.getText());
//                  pstmt.setString(idx++, textFieldType.getText());
//                  pstmt.setInt(idx++, Integer.parseInt(textFieldCost.getText()));
//                  pstmt.setInt(idx++, Integer.parseInt(textFieldPrice.getText()));
//                  pstmt.setInt(idx++, Integer.parseInt(textFieldAmount.getText()));
//
//                  pstmt.setDate(idx, sDate);
//                  pstmt.executeUpdate();
//                  model.setRowCount(0);
//                  getTable();
//                  if (pstmt != null)
//                     pstmt.close();
//               } catch (SQLException e1) {
//                  e1.printStackTrace();
//               } catch (IllegalArgumentException e1) {
//                  e1.printStackTrace();
//               }
//            }
//         });
//         btnInsert.setForeground(Color.WHITE);
//         btnInsert.setFont(new Font("���� ����", Font.PLAIN, 15));
//         btnInsert.setBackground(new Color(135, 206, 250));
//         btnInsert.setBounds(863, 0, 97, 23);
//         panel.add(btnInsert);
//         JButton btnDelete = new JButton("delete");
//         btnDelete.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//               String sql = "DELETE FROM producttbl where productNo = ?";
//               try {
//                  pstmt = conn.prepareStatement(sql);
//                  pstmt.setInt(1, Integer.parseInt(textFieldPNo.getText()));
//                  pstmt.executeUpdate();
//                  model.setRowCount(0);
//                  getTable();
//                  if (pstmt != null)
//                     pstmt.close();
//               } catch (SQLException e1) {
//                  e1.printStackTrace();
//               }
//            }
//         });
//         btnDelete.setForeground(Color.WHITE);
//         btnDelete.setFont(new Font("���� ����", Font.PLAIN, 15));
//         btnDelete.setBackground(new Color(135, 206, 250));
//         btnDelete.setBounds(863, 45, 97, 23);
//         panel.add(btnDelete);
//         JButton btnUpdate = new JButton("update");
//         btnUpdate.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//               String sql = "UPDATE producttbl SET productNo = ?, productName = ?, productType = ?, cost = ?, price = ?, amount = ?, receivedDate = ? where productNo = ?";
//               try {
//                  int idx = 1;
//                  String date = textFieldDate.getText();
//                  java.sql.Date sDate = java.sql.Date.valueOf(date);
//                  pstmt = conn.prepareStatement(sql);
//                  pstmt.setInt(idx++, Integer.parseInt(textFieldPNo.getText()));
//                  pstmt.setString(idx++, textFieldPName.getText());
//                  pstmt.setString(idx++, textFieldType.getText());
//                  pstmt.setInt(idx++, Integer.parseInt(textFieldCost.getText()));
//                  pstmt.setInt(idx++, Integer.parseInt(textFieldPrice.getText()));
//                  pstmt.setInt(idx++, Integer.parseInt(textFieldAmount.getText()));
//                  pstmt.setDate(idx++, sDate);
//                  pstmt.setInt(idx++, (Integer) model.getValueAt(select, 0));
//                  System.out.println(select);
//                  pstmt.executeUpdate();
//                  model.setRowCount(0);
//                  getTable();
//                  if (pstmt != null)
//                     pstmt.close();
//               } catch (SQLException e1) {
//                  e1.printStackTrace();
//               }
//            }
//         });
//         btnUpdate.setForeground(Color.WHITE);
//         btnUpdate.setFont(new Font("���� ����", Font.PLAIN, 15));
//         btnUpdate.setBackground(new Color(135, 206, 250));
//         btnUpdate.setBounds(972, 0, 97, 23);
//         panel.add(btnUpdate);
//         JButton btnSearch = new JButton("search");
//         btnSearch.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//               searchProduct(textFieldPNo.getText(), textFieldPName.getText(), textFieldType.getText(),
//                     textFieldCost.getText(), textFieldPrice.getText(), textFieldAmount.getText(),
//                     textFieldDate.getText());
//            }
//         });
//         btnSearch.setForeground(Color.WHITE);
//         btnSearch.setFont(new Font("���� ����", Font.PLAIN, 15));
//         btnSearch.setBackground(new Color(135, 206, 250));
//         btnSearch.setBounds(863, 87, 97, 23);
//         panel.add(btnSearch);
//         JButton btnClear = new JButton("clear");
//         btnClear.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//               textFieldPNo.setText("");
//               textFieldPName.setText("");
//               textFieldType.setText("");
//               textFieldCost.setText("");
//               textFieldPrice.setText("");
//               textFieldAmount.setText("");
//               textFieldDate.setText("");
//               model.setRowCount(0);
//               getTable();
//            }
//         });
//         btnClear.setForeground(Color.WHITE);
//         btnClear.setFont(new Font("���� ����", Font.PLAIN, 15));
//         btnClear.setBackground(new Color(135, 206, 250));
//         btnClear.setBounds(972, 87, 97, 23);
//         panel.add(btnClear);
//      }
//      return product;
//   }
//
//   public static void getTable() {
//      model.setRowCount(0);
//      try {
//         String sql = "SELECT * FROM producttbl";
//         pstmt = conn.prepareStatement(sql);
//         rs = pstmt.executeQuery();
//         while (rs.next()) {
//            model.addRow(new Object[] { rs.getInt("productNo"), rs.getString("productName"),
//                  rs.getString("producttype"), rs.getInt("cost"), rs.getInt("price"), rs.getInt("amount"),
//                  rs.getString("receivedDate") });
//         }
//         if (rs != null)
//            rs.close();
//         if (pstmt != null)
//            pstmt.close();
//      } catch (SQLException e) {
//         e.printStackTrace();
//      }
//   }
//
//   public static void resizeColumnWidth(JTable table) {
//      final TableColumnModel columnModel = table.getColumnModel();
//      for (int column = 0; column < table.getColumnCount(); column++) {
//         int width = 15; // Min width
//         for (int row = 0; row < table.getRowCount(); row++) {
//            TableCellRenderer renderer = table.getCellRenderer(row, column);
//            Component comp = table.prepareRenderer(renderer, row, column);
//            width = Math.max(comp.getPreferredSize().width + 1, width);
//         }
//         if (width > 300)
//            width = 300;
//         columnModel.getColumn(column).setPreferredWidth(width);
//      }
//   }
//
//   public static void searchProduct(String productNo, String productName, String productType, String cost,
//         String price, String amount, String receivedDate) {
//      String sql = "SELECT * FROM producttbl WHERE ";
////      String sql = "select * from producttbl where Cast(price as char) like ?";
//      if (!productNo.equals("")) {
//         st = new StringTokenizer(productNo, ",");
//         sql = sql + "(";
//         while (st.hasMoreTokens()) {
//            sql = sql + "Cast(productNo as char(10)) like ? or ";
//            st.nextToken();
//         }
//
//         sql = sql.substring(0, sql.length() - 3);
//         sql = sql + ")";
//         sql = sql + " and ";
//      }
////
//      if (!productName.equals("")) {
//         st = new StringTokenizer(productName, ",");
//         sql = sql + "(";
//         while (st.hasMoreTokens()) {
//            sql = sql + "productName like ? or ";
//            st.nextToken();
//         }
//         sql = sql.substring(0, sql.length() - 3);
//         sql = sql + ")";
//         sql = sql + " and ";
//      }
//      if (!productType.equals("")) {
//         st = new StringTokenizer(productType, ",");
//         sql = sql + "(";
//         while (st.hasMoreTokens()) {
//            sql = sql + "productType like ? or ";
//            st.nextToken();
//         }
//         sql = sql.substring(0, sql.length() - 3);
//         sql = sql + ")";
//         sql = sql + " and ";
//      }
//      if (!cost.equals("")) {
//         st = new StringTokenizer(cost, ",");
//         sql = sql + "(";
//         while (st.hasMoreTokens()) {
//            sql = sql + "Cast(cost as char(10)) like ? or ";
//            st.nextToken();
//         }
//         sql = sql.substring(0, sql.length() - 3);
//         sql = sql + ")";
//         sql = sql + " and ";
//      }
//      if (!price.equals("")) {
//         st = new StringTokenizer(price, ",");
//         sql = sql + "(";
//         while (st.hasMoreTokens()) {
//            sql = sql + "Cast(price as char(10)) like ? or ";
//            st.nextToken();
//         }
//         sql = sql.substring(0, sql.length() - 3);
//         sql = sql + ")";
//         sql = sql + " and ";
//      }
//      if (!receivedDate.equals("")) {
//         st = new StringTokenizer(receivedDate, ",");
//         sql = sql + "(";
//         while (st.hasMoreTokens()) {
//            sql = sql + "receivedDate like ? or ";
//            st.nextToken();
//         }
//         sql = sql.substring(0, sql.length() - 3);
//         sql = sql + ")";
//         sql = sql + " and ";
//      }
//      sql = sql.substring(0, sql.length() - 4);
//      System.out.println(sql);
//      try {
//         int idx = 1;
////         String sql = "select * from producttbl where Cast(price as char) like ?";
//         pstmt = conn.prepareStatement(sql);
//         if (!productNo.equals("")) {
//            st = new StringTokenizer(productNo, ",");
//            while (st.hasMoreTokens()) {
//               pstmt.setString(idx++, "%" + st.nextToken().trim() + "%");
//            }
//         }
//         if (!productName.equals("")) {
//            st = new StringTokenizer(productName, ",");
//            while (st.hasMoreTokens()) {
//               pstmt.setString(idx++, "%" + st.nextToken().trim() + "%");
//            }
//         }
//         if (!productType.equals("")) {
//            st = new StringTokenizer(productType, ",");
//            while (st.hasMoreTokens()) {
//               pstmt.setString(idx++, "%" + st.nextToken().trim() + "%");
//            }
//         }
//         if (!cost.equals("")) {
//            st = new StringTokenizer(cost, ",");
//            while (st.hasMoreTokens()) {
//               pstmt.setString(idx++, "%" + st.nextToken().trim() + "%");
//            }
//         }
//         if (!price.equals("")) {
//            st = new StringTokenizer(price, ",");
//            while (st.hasMoreTokens()) {
//               pstmt.setString(idx++, "%" + st.nextToken().trim() + "%");
//            }
//         }
//         if (!receivedDate.equals("")) {
//            st = new StringTokenizer(receivedDate, ",");
//            while (st.hasMoreTokens()) {
//               pstmt.setString(idx++, "%" + st.nextToken().trim() + "%");
//            }
//         }
////         pstmt.setString(1, "%5%");
//         rs = pstmt.executeQuery();
//         model.setRowCount(0);
//         while (rs.next()) {
//            model.addRow(new Object[] { rs.getInt("productNo"), rs.getString("productName"),
//                  rs.getString("producttype"), rs.getInt("cost"), rs.getInt("price"), rs.getInt("amount"),
//                  rs.getString("receivedDate") });
//         }
//         if (rs != null)
//            rs.close();
//         if (pstmt != null)
//            pstmt.close();
//      } catch (SQLException e1) {
//         e1.printStackTrace();
//      }
//   }
//}