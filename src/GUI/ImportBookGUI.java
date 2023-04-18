/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BLL.ChiTietPhieuNhapBLL;
import BLL.NhanVienBLL;
import BLL.PhieuNhapBLL;
import BLL.PrintPDF;
import BLL.SachBLL;
import DTO.ChiTietPhieuNhapDTO;
import DTO.NhanVienDTO;
import DTO.PhieuNhapDTO;
import DTO.SachDTO;
import DTO.TaiKhoanDTO;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.lang.reflect.Array;
import java.sql.Date;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.UUID;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

/**
 *
 * @author Hung
 */
public final class ImportBookGUI extends javax.swing.JFrame {

    /**
     * Creates new form MenuEmployee
     */
    private TaiKhoanDTO tk;
    private SachBLL sachBLL = new SachBLL();
    private PhieuNhapBLL phieuNhapBLL = new PhieuNhapBLL();
    private ChiTietPhieuNhapBLL chiTietPhieuNhapBLL = new ChiTietPhieuNhapBLL();
    
    private Locale lc = new Locale("nv","VN"); //Định dạng locale việt nam
    private NumberFormat nf = NumberFormat.getInstance(lc);
    
    private ArrayList<Object[]> buyList = new ArrayList<>();
    private double tongTien = 0;
    
    private void updateBuyTable(int ma, int soLuong, long thanhTien) {
        DefaultTableModel modelBuy = (DefaultTableModel) buyTable.getModel();
        
        int row = modelBuy.getRowCount();
        
        for (int i = 0; i < row; i++) {
            int maSach = Integer.parseInt(String.valueOf(modelBuy.getValueAt(i, 0)));
            if (maSach == ma) {
                modelBuy.setValueAt(soLuong, i, 3);
                modelBuy.setValueAt(thanhTien, i, 4);
            }
        }
    }
    
    private void updateBookTable(int ma, int soLuong) {
        DefaultTableModel modelBook = (DefaultTableModel) bookTable.getModel();
        
        int row = modelBook.getRowCount();
        
        for (int i = 0; i < row; i++) {
            int maSach = Integer.parseInt(String.valueOf(modelBook.getValueAt(i, 0)));
            if (maSach == ma) {
                int soLuongConLai = Integer.parseInt(modelBook.getValueAt(i, 2).toString()) - soLuong;
                modelBook.setValueAt(soLuongConLai, i, 2);
            }
        }
    }
    
    private int checkInputNumberValue(String value) {
        int soLuong;
        if (value == null) return -1;
        
        try {
            
            soLuong = Integer.parseInt(value);
            if (soLuong > 0) {
                return soLuong;
            } else {
                JOptionPane.showMessageDialog(this, "Số lượng là một số không âm");
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng là một số nguyên dương");
        }
        return -1;
    }
    
    private void updateTotalPay() {
        DefaultTableModel modelBuy = (DefaultTableModel) buyTable.getModel();
        
        int row = modelBuy.getRowCount();
        for (int i = 0; i < row; i++) {
            double pay = Double.parseDouble(String.valueOf(modelBuy.getValueAt(i, 4)));
            tongTien += pay;
        }
        
        totalPay.setText(nf.format(tongTien) + " VNĐ");
    }
    
    private void setBookTable() {
        ArrayList<SachDTO> bookList = sachBLL.getAllSach();
        int maSach;
        String tenSach;
        int soLuongConLai;
        long giaNhap;
        
        DefaultTableModel modelBook = (DefaultTableModel) bookTable.getModel();
        
        for (SachDTO s : bookList) {
            maSach = s.getMaSach();
            tenSach = s.getTenSach();
            soLuongConLai = s.getSoLuongConLai();
            giaNhap = s.getGiaNhap();
            modelBook.addRow(new Object[]{maSach, tenSach, soLuongConLai, giaNhap, "+"});
        }
        
        
    }
    
    private void addEventBookTable() {
        DefaultTableModel modelBook = (DefaultTableModel) bookTable.getModel();
        bookTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DefaultTableModel modelBuy = (DefaultTableModel) buyTable.getModel();
                int row = bookTable.rowAtPoint(evt.getPoint());
                int col = bookTable.columnAtPoint(evt.getPoint());

                if (row >= 0 && col == 4) {
                    int ma =  Integer.parseInt(String.valueOf(bookTable.getValueAt(row, 0)));
                    String ten = String.valueOf(bookTable.getValueAt(row, 1));
                    int conLai = Integer.parseInt(String.valueOf(bookTable.getValueAt(row, 2)));
                    long donGia = Long.parseLong(String.valueOf(bookTable.getValueAt(row, 3)));
                    
                    String value = JOptionPane.showInputDialog("Nhập số lượng");
                    int soLuong = checkInputNumberValue(value);
                    if (soLuong <= 0)  {
                        return;
                    }
                    if (soLuong > conLai) {
                        JOptionPane.showMessageDialog(rootPane, "Số lượng lớn hơn số lượng còn lại trong cửa hàng");
                        return;
                    }
                    
                    conLai += soLuong;
                    modelBook.setValueAt(conLai, row, 2);
                    
                    long thanhTien = donGia * soLuong;
                    
                    Object[] buyObject = new Object[]{ma, ten, donGia, soLuong, thanhTien, "-", "X"};
                    
                    for (int i = 0; i < buyList.size(); i++) {
                        if (Array.get(buyList.get(i), 0).toString().equals(ma)) {
                            int soLuongCu = Integer.parseInt(Array.get(buyList.get(i), 3).toString());
                            soLuong += soLuongCu;
                            thanhTien = soLuong * donGia;
                            buyObject = new Object[]{ma, ten, donGia, soLuong, thanhTien, "-", "X"};
                            
                            buyList.set(i, buyObject);
                            
                            updateBuyTable(ma, soLuong, thanhTien);
                            updateTotalPay();
                            return;
                        }
                    }
                    
                    buyList.add(buyObject);
                    modelBuy.addRow(buyObject);
                    updateTotalPay();
                }
            }
        });
    }
    
    private void showComfirmRemoveAll(int i, int row) {
        DefaultTableModel modelBuy = (DefaultTableModel) buyTable.getModel();
        if (JOptionPane.showConfirmDialog(this, "Bạn chắc chứ?", "Question", 2) == 0) {
            buyList.remove(i);
            int ma = Integer.parseInt(String.valueOf(modelBuy.getValueAt(row, 0)));
            int soLuong = (int) modelBuy.getValueAt(row, 3);
            updateBookTable(ma, soLuong);
            modelBuy.removeRow(row);
            updateTotalPay();
        }
    }
    
    private void addEventRemoveBookBuyList() {
        buyTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = buyTable.rowAtPoint(evt.getPoint());
                int col = buyTable.columnAtPoint(evt.getPoint());
                DefaultTableModel modelBuy = (DefaultTableModel) buyTable.getModel();

                if (row >= 0 && col == 5) {
                    int ma =  Integer.parseInt(String.valueOf(bookTable.getValueAt(row, 0)));
                    for (int i = 0; i < buyList.size(); i++) {
                        int maSach = Integer.parseInt(Array.get(buyList.get(i), 0).toString());
                        if (maSach == ma) {
                            String ten = Array.get(buyList.get(i), 1).toString();
                            long donGia = Long.parseLong(Array.get(buyList.get(i), 2).toString());
                            int soLuong = Integer.parseInt(Array.get(buyList.get(i), 3).toString());
                            
                            String value = JOptionPane.showInputDialog("Nhập số lượng");
                            int soLuongXoa = checkInputNumberValue(value);
                            if (soLuongXoa > soLuong) {
                                JOptionPane.showMessageDialog(rootPane, "Số lượng xóa lớn hơn số lượng hiện tại");
                                return;
                            }
                            
                            if (soLuongXoa <= 0) return;
                            
                            soLuong -= soLuongXoa;
                            if (soLuong <= 0) {
                                buyList.remove(i);
                                modelBuy.removeRow(row);
                                updateTotalPay();
                                updateBookTable(ma, soLuongXoa);
                                return;
                            }
                            
                            long thanhTien = soLuong * donGia;
                            
                            Object[] buyObject = new Object[]{maSach, ten, donGia, soLuong, thanhTien, "-", "X"};
                            
                            buyList.set(i, buyObject);
                            
                            updateBuyTable(ma, soLuong, thanhTien);
                            updateBookTable(ma, soLuongXoa);
                            updateTotalPay();
                            return;
                        }
                    }
                }
                
                if (row >= 0 && col == 6) {
                    int ma =  Integer.parseInt(String.valueOf(bookTable.getValueAt(row, 0)));
                    for (int i = 0; i < buyList.size(); i++) {
                        int maSach = Integer.parseInt(Array.get(buyList.get(i), 0).toString());
                        if (maSach == ma) {
                            showComfirmRemoveAll(i, row);
                            return;
                        }
                    }
                }
            }
        });
    }
    
    public ImportBookGUI(TaiKhoanDTO tk) {
        initComponents();
        
        this.tk = tk;
        
        Thread th = new ClockLabel(dateTimeLabel);
        th.start();
        
        infoUser.setText(tk.getTenDangNhap());
        employeeName.setText(tk.getTenDangNhap());
        
        bookTable.getColumnModel().getColumn(3).setCellRenderer(new CurrencyTableCellRenderer());
        bookTable.getColumn("Thêm").setCellRenderer(new ButtonRenderer());
        
        buyTable.getColumnModel().getColumn(2).setCellRenderer(new CurrencyTableCellRenderer());
        buyTable.getColumnModel().getColumn(4).setCellRenderer(new CurrencyTableCellRenderer());
        buyTable.getColumn("Xóa").setCellRenderer(new ButtonRenderer());
        buyTable.getColumn("Xóa Tất Cả").setCellRenderer(new ButtonRenderer());
        
        setBookTable();
        addEventBookTable();
        addEventRemoveBookBuyList();
        
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        infoUser = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JLabel();
        footer = new javax.swing.JPanel();
        dateTimeLabel = new javax.swing.JLabel();
        backBtn = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        employeeName = new javax.swing.JLabel();
        totalPay = new javax.swing.JLabel();
        payBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        supplierCbx = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        buyTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        inputBookId = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        bookTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        searchCbbox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nhập Sách");
        setBackground(new java.awt.Color(255, 204, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        header.setBackground(new java.awt.Color(255, 204, 102));

        infoUser.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        infoUser.setForeground(new java.awt.Color(51, 51, 51));
        infoUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoUser.setText("NV1 - Biện Thành Hưng");

        logoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/logout.png"))); // NOI18N
        logoutBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(infoUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logoutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
            .addComponent(infoUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        footer.setBackground(new java.awt.Color(255, 204, 102));

        dateTimeLabel.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        dateTimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateTimeLabel.setText("10/1/2003 - 22:00:00 PM");

        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/back.png"))); // NOI18N
        backBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout footerLayout = new javax.swing.GroupLayout(footer);
        footer.setLayout(footerLayout);
        footerLayout.setHorizontalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footerLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(backBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dateTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        footerLayout.setVerticalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
            .addComponent(dateTimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 204, 0));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel4.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel4.setText("Tên nhân viên  :");

        jLabel5.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel5.setText("Tổng tiền      :");

        employeeName.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        employeeName.setText("");

        totalPay.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        totalPay.setText("0 VNĐ");

        payBtn.setBackground(new java.awt.Color(255, 255, 153));
        payBtn.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        payBtn.setForeground(new java.awt.Color(51, 51, 51));
        payBtn.setText("Thanh Toán");
        payBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        payBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                payBtnMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel6.setText("Nhà cung cấp   :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(payBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(supplierCbx, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(totalPay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(employeeName, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(employeeName))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(totalPay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(supplierCbx))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(payBtn)
                .addGap(15, 15, 15))
        );

        buyTable.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        buyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sách", "Tên Sách", "Giá Nhập", "Số Lượng", "Thành Tiền", "Xóa", "Xóa Tất Cả"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(buyTable);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        inputBookId.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        inputBookId.setForeground(new java.awt.Color(102, 102, 102));
        inputBookId.setText("Nhập tên sách");
        inputBookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputBookIdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputBookIdFocusLost(evt);
            }
        });
        inputBookId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputBookIdKeyPressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel12.setText("Tìm Sách :");

        bookTable.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        bookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sách", "Tên Sách", "Còn Lại", "Giá Nhập", "Thêm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Long.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bookTable.setEditingColumn(1);
        bookTable.setEditingRow(1);
        jScrollPane3.setViewportView(bookTable);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        searchCbbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã sách", "Tên sách" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel12)
                .addGap(10, 10, 10)
                .addComponent(inputBookId, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchCbbox, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 833, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputBookId, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchCbbox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(footer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 609, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(footer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMouseClicked
        this.dispose();
        new LoginGUI();
    }//GEN-LAST:event_logoutBtnMouseClicked

    private void backBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseClicked
        this.dispose();
        NhanVienDTO nv = new NhanVienBLL().getByNVid(tk.getMaNhanVien());
            
        switch (nv.getVaiTro()) {
            case "Quản lý" -> new ManagerMenuGUI(tk).setVisible(true);
            case "Nhân viên bán hàng" -> new SellEmployeeMenuGUI(tk).setVisible(true);
            case "Nhân viên nhập hàng" -> new ImportEmployeeMenuGUI(tk).setVisible(true);
        }
    }//GEN-LAST:event_backBtnMouseClicked

    private void inputBookIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputBookIdKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String value = inputBookId.getText();
            int searchType = searchCbbox.getSelectedIndex();
            int maSach;
            String tenSach;
            int soLuongConLai;
            long giaNhap;
            
            ArrayList<SachDTO> bookList = null;
            DefaultTableModel modelBook = (DefaultTableModel) bookTable.getModel();
            modelBook.setRowCount(0);
            
            switch (searchType) {
                case 0 -> {
                    bookList = sachBLL.getByCondition("maSach LIKE '%" + value + "%'");
                }
                case 1 -> {
                    bookList = sachBLL.getByCondition("tenSach LIKE '%" + value + "%'");
                }
            }

            if (bookList.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, value + " không tồn tại trong cơ sở dữ liệu");
                setBookTable();
            } else {
                for (SachDTO s : bookList) {
                    maSach = s.getMaSach();
                    tenSach = s.getTenSach();
                    soLuongConLai = s.getSoLuongConLai();
                    giaNhap = s.getGiaNhap();
                    modelBook.addRow(new Object[]{maSach, tenSach, soLuongConLai, giaNhap, "+"});
                }
            }
        }
    }//GEN-LAST:event_inputBookIdKeyPressed

    private void payBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_payBtnMouseClicked
        if (buyList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa chọn sách nào cả!!!");
            return;
        }
        
        DefaultTableModel modelBuy = (DefaultTableModel) buyTable.getModel();
        long millis=System.currentTimeMillis();  
        Date ngayLap = new Date(millis);
        SachDTO s;
        int ma;
        int maNhaCungCap = Integer.parseInt(String.valueOf(supplierCbx.getSelectedItem()));
        int soLuongMua;
        
        PhieuNhapDTO pn = new PhieuNhapDTO(-1, tk.getMaNhanVien(), maNhaCungCap, ngayLap, tongTien);
        
        int maPhieuNhap = phieuNhapBLL.insert(pn);
        
        if (maPhieuNhap >= 0) {
            ChiTietPhieuNhapDTO ctpn;
        
            for (Object[] buy : buyList) {
                ma = Integer.parseInt(Array.get(buy, 0).toString());
                soLuongMua = Integer.parseInt(Array.get(buy, 3).toString());
                s = sachBLL.getById(ma);
                s.setSoLuongConLai(s.getSoLuongConLai() - soLuongMua);
                sachBLL.update(s);

                ctpn = new ChiTietPhieuNhapDTO(pn.getMaPhieuNhap(), ma, soLuongMua, s.getGiaNhap());

                chiTietPhieuNhapBLL.insert(ctpn);
            }
            
            int reply = JOptionPane.showConfirmDialog(rootPane,
                        "Thanh toán thành công, bạn có muốn IN PHIẾU NHẬP?", "Thành công",
                        JOptionPane.YES_NO_OPTION);
            
            if(reply == JOptionPane.OK_OPTION) {
                new PrintPDF().writePhieuNhap(maPhieuNhap);
            }

            for (int i = 0; i < modelBuy.getRowCount(); i++) {
                modelBuy.removeRow(i);
            }

            totalPay.setText("0 VNĐ");
            buyList.removeAll(buyList);
        }
    }//GEN-LAST:event_payBtnMouseClicked

    
    
    private void inputBookIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputBookIdFocusGained
        inputBookId.setText("");
        inputBookId.setForeground(new Color(51, 51, 51));
    }//GEN-LAST:event_inputBookIdFocusGained

    private void inputBookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputBookIdFocusLost
        inputBookId.setText("Nhập thông tin sách");
        inputBookId.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_inputBookIdFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backBtn;
    private javax.swing.JTable bookTable;
    private javax.swing.JTable buyTable;
    private javax.swing.JLabel dateTimeLabel;
    private javax.swing.JLabel employeeName;
    private javax.swing.JPanel footer;
    private javax.swing.JPanel header;
    private javax.swing.JLabel infoUser;
    private javax.swing.JTextField inputBookId;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel logoutBtn;
    private javax.swing.JButton payBtn;
    private javax.swing.JComboBox<String> searchCbbox;
    private javax.swing.JComboBox<String> supplierCbx;
    private javax.swing.JLabel totalPay;
    // End of variables declaration//GEN-END:variables
}
