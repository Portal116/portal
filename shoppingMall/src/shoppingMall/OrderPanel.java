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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

public class OrderPanel {
   private static JPanel order = null;
   private static Connection con = DBConnect.getConnection();
   private static DefaultTableModel model;
   private static JTable table;
   private static JTextField textOrderNo;
   private static JTextField textID;
   private static JTextField textOrderAmount;
   private static JTextField textOrderDate;
   private static JTextField textProductNo;
   private static JTextField textTotalPrice;
//   private static String[] col_name = { "�ֹ� ��ȣ", "ID", "��ǰ ��ȣ", "����", "�Ǹ� ��¥", "�Ǹ� ����" };
   private static PreparedStatement pstmt = null;
   private static ResultSet rs = null;
   private static JTextField textSum;
   private static List<Integer> selectRows = new ArrayList<>();
   private static StringTokenizer st;
   private static DecimalFormat formatter = new DecimalFormat("###,###,###,###");
   private static JTextField textFieldSelectCnt;

   public OrderPanel() {
      getPanel();
   }

   public static JPanel getPanel() {
      // TODO Auto-generated method stub
      if (order == null) {
         order = new JPanel();
         order.setBackground(new Color(255, 0, 0, 0));
         order.setBounds(0, 100, 1184, 661);
         model = new DefaultTableModel(null, new String[] { "�ֹ� ��ȣ", "ID", "��ǰ ��ȣ", "����", "�Ǹ� ��¥", "�Ǹ� ����" }) {
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
         table = new JTable(model);
         resizeColumnWidth(table);
         table.setFont(new Font("���� ����", Font.PLAIN, 15));
         table.getTableHeader().setReorderingAllowed(false);
         table.setRowHeight(30);
         table.getTableHeader().setFont(new Font("���� ����", Font.PLAIN, 15));
         DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
         centerRenderer.setHorizontalAlignment(JLabel.CENTER);
         table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
         table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
         table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
         table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
         table.getColumnModel().getColumn(5).setCellRenderer(new RightNumberRenderer());
//         ������ �����ؼ� �� �Ǹž� ��� �뵵
         table.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
               int temp = table.getSelectedRow();
               selectRows.clear();
               selectRows.addAll(0,
                     Arrays.asList(Arrays.stream(table.getSelectedRows()).boxed().toArray(Integer[]::new)));
               int sum = 0;
               for (Integer i : selectRows) {
                  sum += ((int) model.getValueAt(i, 5));
               }
               String sumResult = formatter.format(sum);
               textSum.setText(sumResult);
               textFieldSelectCnt.setText(Integer.toString(table.getSelectedRowCount()));
            }
         });
         table.addMouseListener(new MouseAdapter() {
//            ������ �����ؼ� �� �Ǹž� ��� �뵵
            @Override
            public void mouseReleased(MouseEvent e) {
               selectRows.clear();
               selectRows.addAll(0,
                     Arrays.asList(Arrays.stream(table.getSelectedRows()).boxed().toArray(Integer[]::new)));
               int sum = 0;
               for (Integer i : selectRows) {
                  sum += ((int) model.getValueAt(i, 5));
               }
               String sumResult = formatter.format(sum);
               textSum.setText(sumResult);
               textFieldSelectCnt.setText(Integer.toString(table.getSelectedRowCount()));

            }

//            Ŭ���� �� text�� ��ȯ
            @Override
            public void mousePressed(MouseEvent e) {
               int temp = table.getSelectedRow();
               textOrderNo.setText(Integer.toString((Integer) model.getValueAt(temp, 0)));
               textID.setText((String) (model.getValueAt(temp, 1)));
               textProductNo.setText(Integer.toString((Integer) model.getValueAt(temp, 2)));
               textOrderAmount.setText(Integer.toString((Integer) model.getValueAt(temp, 3)));
               textOrderDate.setText((String) model.getValueAt(temp, 4));
               textTotalPrice.setText(Integer.toString((Integer) model.getValueAt(temp, 5)));
            }
         });
         JScrollPane scrollPane = new JScrollPane(table);
         scrollPane.setBounds(12, 10, 1160, 516);
         scrollPane.getViewport().setBackground(Color.WHITE);
         table.setAutoCreateRowSorter(true);
         TableRowSorter tablesorter = new TableRowSorter(table.getModel());
         order.setLayout(null);
         table.setRowSorter(tablesorter);
         scrollPane.setViewportView(table);
         order.add(scrollPane);
         JPanel insertPanel = new JPanel();
         insertPanel.setBackground(UIManager.getColor("Button.disabledShadow"));
         insertPanel.setBounds(12, 536, 991, 120);
         order.add(insertPanel);
         insertPanel.setLayout(null);
         JPanel infoPanel = new JPanel();
         infoPanel.setBackground(UIManager.getColor("Button.disabledShadow"));
         infoPanel.setBounds(0, 0, 992, 120);
         insertPanel.add(infoPanel);
         infoPanel.setLayout(null);
         JPanel infoPanel_1 = new JPanel();
         infoPanel_1.setBackground(UIManager.getColor("Button.disabledShadow"));
         infoPanel_1.setBounds(0, 0, 992, 40);
         infoPanel.add(infoPanel_1);
         infoPanel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
         JLabel lblOrderNo = new JLabel("\uC8FC\uBB38 \uBC88\uD638");
         infoPanel_1.add(lblOrderNo);
         lblOrderNo.setFont(new Font("���� ����", Font.PLAIN, 15));
         lblOrderNo.setBackground(Color.BLUE);
         textOrderNo = new JTextField();
         infoPanel_1.add(textOrderNo);
         textOrderNo.setFont(new Font("���� ����", Font.PLAIN, 15));
         textOrderNo.setColumns(10);
         JLabel lblID = new JLabel("ID");
         infoPanel_1.add(lblID);
         lblID.setFont(new Font("���� ����", Font.PLAIN, 15));
         textID = new JTextField();
         infoPanel_1.add(textID);
         textID.setFont(new Font("���� ����", Font.PLAIN, 15));
         textID.setColumns(10);
         JLabel lblOrderDate = new JLabel("\uD310\uB9E4 \uB0A0\uC9DC");
         infoPanel_1.add(lblOrderDate);
         lblOrderDate.setFont(new Font("���� ����", Font.PLAIN, 15));
         textOrderDate = new JTextField();
         infoPanel_1.add(textOrderDate);
         textOrderDate.setFont(new Font("���� ����", Font.PLAIN, 15));
         textOrderDate.setColumns(10);
         JLabel lblProductNo = new JLabel("\uC0C1\uD488 \uBC88\uD638");
         infoPanel_1.add(lblProductNo);
         lblProductNo.setFont(new Font("���� ����", Font.PLAIN, 15));
         textProductNo = new JTextField();
         infoPanel_1.add(textProductNo);
         textProductNo.setFont(new Font("���� ����", Font.PLAIN, 15));
         textProductNo.setColumns(10);
         JPanel infoPanel_2 = new JPanel();
         infoPanel_2.setBackground(UIManager.getColor("Button.disabledShadow"));
         infoPanel_2.setBounds(0, 40, 992, 40);
         infoPanel.add(infoPanel_2);
         infoPanel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
         JLabel lblOrderAmount = new JLabel("\uC218\uB7C9");
         infoPanel_2.add(lblOrderAmount);
         lblOrderAmount.setFont(new Font("���� ����", Font.PLAIN, 15));
         textOrderAmount = new JTextField();
         infoPanel_2.add(textOrderAmount);
         textOrderAmount.setFont(new Font("���� ����", Font.PLAIN, 15));
         textOrderAmount.setColumns(10);
         JComboBox comboBoxAmount = new JComboBox(new String[] { "����", "����", "�̻�", "����" });
         comboBoxAmount.setFont(new Font("���� ����", Font.PLAIN, 15));
         comboBoxAmount.setBackground(new Color(255, 255, 255));
         infoPanel_2.add(comboBoxAmount);
         JLabel lblTotalPrice = new JLabel("\uD310\uB9E4 \uAE08\uC561");
         infoPanel_2.add(lblTotalPrice);
         lblTotalPrice.setFont(new Font("���� ����", Font.PLAIN, 15));
         lblTotalPrice.setBackground(Color.WHITE);
         textTotalPrice = new JTextField();
         infoPanel_2.add(textTotalPrice);
         textTotalPrice.setFont(new Font("���� ����", Font.PLAIN, 15));
         textTotalPrice.setColumns(10);
         JComboBox comboBoxTotal = new JComboBox(new String[] { "����", "����", "�̻�", "����" });
         comboBoxTotal.setFont(new Font("���� ����", Font.PLAIN, 15));
         comboBoxTotal.setBackground(new Color(255, 255, 255));
         infoPanel_2.add(comboBoxTotal);

         JPanel infoPanel_3 = new JPanel();
         infoPanel_3.setBackground(UIManager.getColor("Button.disabledShadow"));
         infoPanel_3.setBounds(0, 78, 992, 42);
         infoPanel.add(infoPanel_3);

         JLabel lblNewLabel = new JLabel("\uD589\uC758 \uAC1C\uC218");
         lblNewLabel.setFont(new Font("���� ����", Font.PLAIN, 15));
         infoPanel_3.add(lblNewLabel);

         textFieldSelectCnt = new JTextField();
         textFieldSelectCnt.setFont(new Font("���� ����", Font.PLAIN, 15));
         textFieldSelectCnt.setEditable(false);
         infoPanel_3.add(textFieldSelectCnt);
         textFieldSelectCnt.setColumns(10);
         JLabel lblSum = new JLabel("\uCD1D \uD310\uB9E4\uC561");
         infoPanel_3.add(lblSum);
         lblSum.setFont(new Font("���� ����", Font.PLAIN, 15));
         lblSum.setBackground(Color.BLUE);
         textSum = new JTextField();
         textSum.setEditable(false);
         infoPanel_3.add(textSum);
         textSum.setFont(new Font("���� ����", Font.PLAIN, 15));
         textSum.setColumns(10);
         JPanel btnPanel = new JPanel();
         btnPanel.setBackground(UIManager.getColor("Button.disabledShadow"));
         btnPanel.setBounds(1003, 536, 169, 120);
         order.add(btnPanel);
         btnPanel.setLayout(null);
         JPanel btnPanel_1 = new JPanel();
         btnPanel_1.setBackground(UIManager.getColor("Button.disabledShadow"));
         btnPanel_1.setBounds(0, 0, 169, 40);
         btnPanel.add(btnPanel_1);
         JButton btnSearch = new RoundedButton("\uAC80\uC0C9");
         btnPanel_1.add(btnSearch);
         btnSearch.setForeground(new Color(255, 255, 255));
         btnSearch.setFont(new Font("���� ����", Font.PLAIN, 15));
         btnSearch.setBackground(new Color(135, 206, 250));
         JButton btnUpdate = new RoundedButton("\uC218\uC815");
         btnPanel_1.add(btnUpdate);
         btnUpdate.setText("\uAC31\uC2E0");
         btnUpdate.setForeground(new Color(255, 255, 255));
         btnUpdate.setFont(new Font("���� ����", Font.PLAIN, 15));
         btnUpdate.setBackground(new Color(135, 206, 250));
         JPanel btnPanel_2 = new JPanel();
         btnPanel_2.setBackground(UIManager.getColor("Button.disabledShadow"));
         btnPanel_2.setBounds(0, 40, 169, 40);
         btnPanel.add(btnPanel_2);
         JButton btnInsert = new RoundedButton("\uC800\uC7A5");
         btnPanel_2.add(btnInsert);
         btnInsert.setText("\uCD94\uAC00");
         btnInsert.setForeground(new Color(255, 255, 255));
         btnInsert.setFont(new Font("���� ����", Font.PLAIN, 15));
         btnInsert.setBackground(new Color(135, 206, 250));
         JButton btnDelete = new RoundedButton("\uC0AD\uC81C");
         btnPanel_2.add(btnDelete);
         btnDelete.setForeground(new Color(255, 255, 255));
         btnDelete.setFont(new Font("���� ����", Font.PLAIN, 15));
         btnDelete.setBackground(new Color(135, 206, 250));
         JPanel btnPanel_3 = new JPanel();
         btnPanel_3.setBackground(UIManager.getColor("Button.disabledShadow"));
         btnPanel_3.setBounds(0, 80, 169, 40);
         btnPanel.add(btnPanel_3);
         JButton btnClear = new RoundedButton("Reset");
         btnPanel_3.add(btnClear);
         btnClear.setText("\uCD08\uAE30\uD654");
         btnClear.setForeground(new Color(255, 255, 255));
         btnClear.setFont(new Font("���� ����", Font.PLAIN, 15));
         btnClear.setBackground(new Color(135, 206, 250));
         // �ֹ�����
         btnClear.addActionListener(new ActionListener() {
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
         btnInsert.addActionListener(new ActionListener() {
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
                           comboBoxAmount.getSelectedIndex(), comboBoxTotal.getSelectedIndex());

               textFieldSelectCnt.setText(Integer.toString(model.getRowCount()));
            }
         });
         getTable();
         BufferedImage image = null;
         try {
            image = ImageIO.read(new File("./source/1.jpg"));
         } catch (IOException e1) {
            e1.printStackTrace();
         }
         JLabel imageLabel = new JLabel(new ImageIcon(image));
         imageLabel.setBounds(0, -100, 1184, 761);
//         imageLabel.setPreferredSize(new Dimension(1184, 661));
         order.add(imageLabel);
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
         textFieldSelectCnt.setText(Integer.toString(model.getRowCount()));
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
            while (st.hasMoreTokens()) {
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
            while (st.hasMoreTokens()) {
               sql = sql + "orderAmount >= ? or ";
               st.nextToken();
            }
            break;
         case (3):
            while (st.hasMoreTokens()) {
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
            while (st.hasMoreTokens()) {
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
            while (st.hasMoreTokens()) {
               sql = sql + "totalPrice >= ? or ";
               st.nextToken();
            }
            break;
         case (3):
            while (st.hasMoreTokens()) {
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
               while (st.hasMoreTokens()) {
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
               while (st.hasMoreTokens()) {
                  pstmt.setInt(idx++, Integer.parseInt(st.nextToken().trim()));
               }
               break;
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