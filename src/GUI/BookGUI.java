/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BLL.NhaXuatBanBLL;
import BLL.PhieuBanBLL;
import BLL.SachBLL;
import BLL.TacGiaBLL;
import BLL.TheLoaiBLL;
import DTO.NhaXuatBanDTO;
import DTO.SachDTO;
import DTO.TacGiaDTO;
import DTO.TaiKhoanDTO;
import DTO.TheLoaiDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

/**
 *
 * @author Hung
 */
public final class BookGUI extends javax.swing.JFrame {

    /**
     * Creates new form MenuEmployee
     */
    private TaiKhoanDTO tk;
    private SachBLL sachBLL = new SachBLL();
    private PhieuBanBLL phieuBanBLL = new PhieuBanBLL();
    private TheLoaiBLL theLoaiBLL = new TheLoaiBLL();
    private TacGiaBLL tacGiaBLL = new TacGiaBLL();
    private NhaXuatBanBLL nhaXuatBanBLL = new NhaXuatBanBLL();
    
    private JTextField id = new JTextField();
    private JTextField name = new JTextField();
    private JComboBox authorId = new JComboBox<String>();
    private JComboBox typeId = new JComboBox<String>();
    private JComboBox publisherId = new JComboBox<String>();
    private JTextField publishYear = new JTextField();
    private JTextField remain = new JTextField();
    private JTextField sellPrice = new JTextField();
    private JTextField importPrice = new JTextField();
    private JPanel popUpUpdateBook = getPopUpUpdateBook();

    
    private JPanel getPopUpUpdateBook() {
        Font font_16_plain = new Font("Monospaced", Font.PLAIN, 16);
        Font font_16_bold = new Font("Monospaced", Font.BOLD, 16);
        
        id.setFont(font_16_plain);
        name.setFont(font_16_plain);
        authorId.setFont(font_16_plain);
        typeId.setFont(font_16_plain);
        publisherId.setFont(font_16_plain);
        publishYear.setFont(font_16_plain);
        remain.setFont(font_16_plain);
        sellPrice.setFont(font_16_plain);
        importPrice.setFont(font_16_plain);
        
        JLabel idLabel = new JLabel("Mã sách: ");
        idLabel.setFont(font_16_bold);
        
        JLabel nameLabel = new JLabel("Tên sách: ");
        nameLabel.setFont(font_16_bold);
        
        JLabel authorIdLabel = new JLabel("Mã tác giả: ");
        authorIdLabel.setFont(font_16_bold);
        
        JLabel typeIdLabel = new JLabel("Mã thể loại: ");
        typeIdLabel.setFont(font_16_bold);
        
        JLabel publisherIdLabel = new JLabel("Mã nhà xuất bản: ");
        publisherIdLabel.setFont(font_16_bold);
        
        JLabel publishYearLabel = new JLabel("Năm xuất bản: ");
        publishYearLabel.setFont(font_16_bold);
        
        JLabel remainLabel = new JLabel("Số lượng còn lại: ");
        remainLabel.setFont(font_16_bold);
        
        JLabel sellPriceLabel = new JLabel("Giá bán: ");
        sellPriceLabel.setFont(font_16_bold);
        
        JLabel importPriceLabel = new JLabel("Giá nhập: ");
        importPriceLabel.setFont(font_16_bold);
        
        JPanel containerPanel = new JPanel();
        JPanel idPanel = new JPanel();
        JPanel namePanel = new JPanel();
        JPanel authorPanel = new JPanel();
        JPanel typePanel = new JPanel();
        JPanel publisherPanel = new JPanel();
        JPanel publishYearPanel = new JPanel();
        JPanel remainPanel = new JPanel();
        JPanel sellPricePanel = new JPanel();
        JPanel importPricePanel = new JPanel();

        containerPanel.setLayout(new GridLayout(3, 3, 10, 10));
        idPanel.setLayout(new BorderLayout());
        namePanel.setLayout(new BorderLayout());
        authorPanel.setLayout(new BorderLayout());
        typePanel.setLayout(new BorderLayout());
        publisherPanel.setLayout(new BorderLayout());
        publishYearPanel.setLayout(new BorderLayout());
        remainPanel.setLayout(new BorderLayout());
        sellPricePanel.setLayout(new BorderLayout());
        importPricePanel.setLayout(new BorderLayout());
        
        idPanel.add(idLabel, BorderLayout.NORTH);
        idPanel.add(id, BorderLayout.CENTER);
        
        namePanel.add(nameLabel, BorderLayout.NORTH);
        namePanel.add(name, BorderLayout.CENTER);
        
        authorPanel.add(authorIdLabel, BorderLayout.NORTH);
        authorPanel.add(authorId, BorderLayout.CENTER);
        
        typePanel.add(typeIdLabel, BorderLayout.NORTH);
        typePanel.add(typeId, BorderLayout.CENTER);
        
        publisherPanel.add(publisherIdLabel, BorderLayout.NORTH);
        publisherPanel.add(publisherId, BorderLayout.CENTER);
        
        publishYearPanel.add(publishYearLabel, BorderLayout.NORTH);
        publishYearPanel.add(publishYear, BorderLayout.CENTER);
        
        remainPanel.add(remainLabel, BorderLayout.NORTH);
        remainPanel.add(remain, BorderLayout.CENTER);
        
        sellPricePanel.add(sellPriceLabel, BorderLayout.NORTH);
        sellPricePanel.add(sellPrice, BorderLayout.CENTER);
        
        importPricePanel.add(importPriceLabel, BorderLayout.NORTH);
        importPricePanel.add(importPrice, BorderLayout.CENTER);
        
        containerPanel.add(idPanel);
        containerPanel.add(namePanel);
        containerPanel.add(authorPanel);
        containerPanel.add(typePanel);
        containerPanel.add(publisherPanel);
        containerPanel.add(publishYearPanel);
        containerPanel.add(remainPanel);
        containerPanel.add(sellPricePanel);
        containerPanel.add(importPricePanel);
        
        return containerPanel;
    }
    
    private void updateBookTable() {
        DefaultTableModel modelBook = (DefaultTableModel) bookTable.getModel();
        modelBook.setRowCount(0);
        
        setBookTable();
    }
    
    private long checkInputNumberValue(String value, String name) {
        long num;
        if (value == null) return -1;
        
        try {
            num = Integer.parseInt(value);
            if (num >= 0) {
                return num;
            } else {
                JOptionPane.showMessageDialog(this, name + " là một số không âm");
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, name + " là một số nguyên dương");
        }
        return -1;
    }
    
    private void showComfirmRemove(int row, String maSach) {
        DefaultTableModel modelBook = (DefaultTableModel) bookTable.getModel();
        if (JOptionPane.showConfirmDialog(this, "Bạn chắc chứ?", "Question", 2) == 0) {
            modelBook.removeRow(row);
            sachBLL.delete(maSach);
        }
    }
    
    private boolean validateValueUpdateBook(SachDTO sachCu) {
        String maSach = id.getText().toUpperCase();
        String tenSach = name.getText();
        String maTheLoai = (String) typeId.getSelectedItem();
        String maTacGia = (String) authorId.getSelectedItem();
        String maNhaXuatBan = (String) publisherId.getSelectedItem();
        String soLuongConLai = remain.getText();
        String giaBan = remain.getText();
        String giaNhap = sellPrice.getText();
        String namXuatBan = publishYear.getText();
        
        if ("".equals(maSach) || "".equals(tenSach) || "".equals(maTheLoai)
                || "".equals(maTacGia) || "".equals(maNhaXuatBan)
                || "".equals(soLuongConLai) || "".equals(giaBan)
                || "".equals(giaNhap) || "".equals(namXuatBan)) {
            JOptionPane.showMessageDialog(this, "Không được để trống bất kì trường nào");
            return false;
        }
        
        if (sachCu.getMaSach().equals(maSach) == false) {
            ArrayList<SachDTO> bookList = sachBLL.getAllSach();
            
            for (SachDTO s : bookList) {
                if (s.getMaSach().equals(maSach)) {
                    JOptionPane.showMessageDialog(this, "Mã sách đã tồn tại trong cơ sở dữ liệu");
                    return false;
                }
            }
        }
        
        int soLuongInt = (int) checkInputNumberValue(soLuongConLai, "Số lượng");
        if (soLuongInt < 0) {
            return false;
        }
        
        long giaBanLong = checkInputNumberValue(soLuongConLai, "Giá bán");
        if (giaBanLong < 0) {
            return false;
        }
        
        long giaNhapLong = checkInputNumberValue(soLuongConLai, "Giá nhập");
        if (giaNhapLong < 0) {
            return false;
        }
        
        if (namXuatBan.matches("[0-9]\\d{1,}") == false) {
            JOptionPane.showMessageDialog(this, "Năm xuất bản không hợp lệ");
            return false;
        }
        
        return true;
    }
    
    private void setJComboBox() {
        ArrayList<TheLoaiDTO> theLoaiList = theLoaiBLL.getAll();
        ArrayList<TacGiaDTO> tacGiaList = tacGiaBLL.getAll();
        ArrayList<NhaXuatBanDTO> nhaXuatBanList = nhaXuatBanBLL.getAll();
        
        typeId.addItem("");
        maTheLoaiInput.addItem("");
        
        authorId.addItem("");
        maTacGiaInput.addItem("");
        
        publisherId.addItem("");
        maNhaXuatBanInput.addItem("");
        
        maTheLoaiInput.setSelectedIndex(0);
        maTacGiaInput.setSelectedIndex(0);
        maNhaXuatBanInput.setSelectedIndex(0);
        
        for (TheLoaiDTO tl : theLoaiList) {
            typeId.addItem(tl.getMaTheLoai());
            maTheLoaiInput.addItem(tl.getMaTheLoai());
        }
        
        for (TacGiaDTO tg : tacGiaList) {
            authorId.addItem(tg.getMaTacGia());
            maTacGiaInput.addItem(tg.getMaTacGia());
        }
        
        for (NhaXuatBanDTO nxb : nhaXuatBanList) {
            publisherId.addItem(nxb.getMaNhaXuatBan());
            maNhaXuatBanInput.addItem(nxb.getMaNhaXuatBan());
        }
    }
    
    private void setBookTable() {
        String maSach;
        String tenSach;
        String maTheLoai;
        String maTacGia;
        String maNhaXuatBan;
        int soLuongConLai;
        long giaBan;
        long giaNhap;
        int namXuatBan;
            
        ArrayList<SachDTO> bookList = sachBLL.getAllSach();
        DefaultTableModel modelBook = (DefaultTableModel) bookTable.getModel();

        for (SachDTO s : bookList) {
            maSach = s.getMaSach();
            tenSach = s.getTenSach();
            maTheLoai = s.getMaTheLoai();
            maTacGia = s.getMaTacGia();
            maNhaXuatBan = s.getMaNhaXuatBan();
            soLuongConLai = s.getSoLuongConLai();
            giaBan = s.getGiaBan();
            giaNhap = s.getGiaNhap();
            namXuatBan = s.getNamXuatBan();

            modelBook.addRow(new Object[]{maSach, tenSach, maTheLoai, maTacGia, maNhaXuatBan, soLuongConLai, giaBan, giaNhap, namXuatBan, "O", "X"});
        }
    }
    
    private void addEventBookTable() {
        bookTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = bookTable.rowAtPoint(evt.getPoint());
                int col = bookTable.columnAtPoint(evt.getPoint());

                if (row >= 0 && col == 9) {
                    String maSach = String.valueOf(bookTable.getValueAt(row, 0));
                    String tenSach = String.valueOf(bookTable.getValueAt(row, 1));
                    String maTheLoai = String.valueOf(bookTable.getValueAt(row, 2));
                    String maTacGia = String.valueOf(bookTable.getValueAt(row, 3));
                    String maNhaXuatBan = String.valueOf(bookTable.getValueAt(row, 4));
                    int soLuongConLai = Integer.parseInt(String.valueOf(bookTable.getValueAt(row, 5)));
                    long giaBan = Long.parseLong(String.valueOf(bookTable.getValueAt(row, 6)));
                    long giaNhap = Long.parseLong(String.valueOf(bookTable.getValueAt(row, 7)));
                    int namXuatBan = Integer.parseInt(String.valueOf(bookTable.getValueAt(row, 8)));
                    
                    SachDTO sachCu = new SachDTO(maSach, tenSach, maTheLoai, maTacGia, maNhaXuatBan, soLuongConLai, giaBan, giaNhap, namXuatBan);
                    
                    id.setText(maSach);
                    name.setText(tenSach);
                    typeId.setSelectedItem(maTheLoai);
                    authorId.setSelectedItem(maTacGia);
                    publisherId.setSelectedItem(maNhaXuatBan);
                    publishYear.setText(namXuatBan + "");
                    remain.setText(soLuongConLai + "");
                    sellPrice.setText(giaBan + "");
                    importPrice.setText(giaNhap + "");
                    
                    int result = JOptionPane.showConfirmDialog(null, popUpUpdateBook, 
                                "Mời sửa sách " + tenSach, JOptionPane.OK_CANCEL_OPTION);
                    
                    if (result == JOptionPane.OK_OPTION) {
                        if (validateValueUpdateBook(sachCu) == false) return;
                        
                        maSach = id.getText().toUpperCase();
                        tenSach = name.getText();
                        maTheLoai = (String) typeId.getSelectedItem();
                        maTacGia = (String) authorId.getSelectedItem();
                        maNhaXuatBan = (String) publisherId.getSelectedItem();
                        soLuongConLai = Integer.parseInt(remain.getText());
                        giaBan = Long.parseLong(sellPrice.getText());
                        giaNhap = Long.parseLong(importPrice.getText());
                        namXuatBan = Integer.parseInt(publishYear.getText());
                        
                        SachDTO s = new SachDTO(maSach, tenSach, maTheLoai, maTacGia, maNhaXuatBan, soLuongConLai, giaBan, giaNhap, namXuatBan);
                        
                        sachBLL.update(s, sachCu.getMaSach());
                        
                        updateBookTable();
                        
                        id.setText("");
                        name.setText("");
                        authorId.setSelectedItem("");
                        typeId.setSelectedItem("");
                        publisherId.setSelectedItem("");
                        publishYear.setText("");
                        remain.setText("");
                        sellPrice.setText("");
                        importPrice.setText("");
                    }
                }
                
                if (row >= 0 && col == 10) {
                    String maSach = String.valueOf(bookTable.getValueAt(row, 0));
                    showComfirmRemove(row, maSach);
                    
                }
            }
        });
    }
    
    public BookGUI(TaiKhoanDTO tk) {
        initComponents();
        
        this.tk = tk;
        
        Thread th = new ClockLabel(dateTimeLabel);
        th.start();
        
        infoUser.setText(tk.getTenDangNhap());
        
        bookTable.getColumnModel().getColumn(6).setCellRenderer(new CurrencyTableCellRenderer());
        bookTable.getColumnModel().getColumn(7).setCellRenderer(new CurrencyTableCellRenderer());
        bookTable.getColumn("Xóa").setCellRenderer(new ButtonRenderer());
        bookTable.getColumn("Sửa").setCellRenderer(new ButtonRenderer());
        
        setBookTable();
        addEventBookTable();
        
        setJComboBox();
        
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
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        maSachInput = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tenSachInput = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        namXuatBanInput = new javax.swing.JTextField();
        soLuongConLaiInput = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        giaBanInput = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        giaNhapInput = new javax.swing.JTextField();
        maTheLoaiInput = new javax.swing.JComboBox<String>();
        maTacGiaInput = new javax.swing.JComboBox<String>();
        maNhaXuatBanInput = new javax.swing.JComboBox<String>();
        addBtn = new javax.swing.JButton();
        resetBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        inputBookName = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        bookTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sách");
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 950, Short.MAX_VALUE)
                .addComponent(dateTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        footerLayout.setVerticalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
            .addComponent(dateTimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thêm Sách");

        jLabel2.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel2.setText("Mã sách           :");

        maSachInput.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        maSachInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maSachInputActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel3.setText("Tên sách          :");

        tenSachInput.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel4.setText("Mã thể loại       :");

        jLabel5.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel5.setText("Mã tác giả        :");

        jLabel6.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel6.setText("Mã nhà xuất bản   :");

        jLabel7.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel7.setText("Năm xuất bản      :");

        namXuatBanInput.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        soLuongConLaiInput.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel8.setText("Số lượng còn lại  :");

        jLabel9.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel9.setText("Giá bán           :");

        giaBanInput.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel10.setText("Giá nhập          :");

        giaNhapInput.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        maTheLoaiInput.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        maTheLoaiInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maTheLoaiInputActionPerformed(evt);
            }
        });

        maTacGiaInput.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        maTacGiaInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maTacGiaInputActionPerformed(evt);
            }
        });

        maNhaXuatBanInput.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        addBtn.setBackground(new java.awt.Color(255, 153, 51));
        addBtn.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("Thêm");
        addBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addBtnMouseClicked(evt);
            }
        });
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        resetBtn.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        resetBtn.setText("Reset");
        resetBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(maSachInput))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tenSachInput))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(giaBanInput))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(maNhaXuatBanInput, 0, 201, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(maTacGiaInput, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(maTheLoaiInput, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(giaNhapInput))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(soLuongConLaiInput))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(namXuatBanInput)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(maSachInput, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tenSachInput, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(maTheLoaiInput, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(maTacGiaInput, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(maNhaXuatBanInput, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(namXuatBanInput, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(soLuongConLaiInput, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(giaBanInput, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(giaNhapInput, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        inputBookName.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        inputBookName.setForeground(new java.awt.Color(102, 102, 102));
        inputBookName.setText("Nhập tên sách");
        inputBookName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputBookNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputBookNameFocusLost(evt);
            }
        });
        inputBookName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputBookNameActionPerformed(evt);
            }
        });
        inputBookName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputBookNameKeyPressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel12.setText("Tìm Sách :");

        bookTable.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        bookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sách", "Tên Sách", "Mã TL", "Mã TG", "Mã NXB", "Còn Lại", "Giá Bán", "Giá Nhập", "Năm Xuất Bản", "Sửa", "Xóa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Long.class, java.lang.Long.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
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
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 931, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputBookName, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(inputBookName, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        new MenuGUI(tk);
    }//GEN-LAST:event_backBtnMouseClicked

    private void inputBookNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputBookNameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String value = inputBookName.getText();
            String maSach;
            String tenSach;
            String maTacGia;
            String maTheLoai;
            String maNhaXuatBan;
            int soLuongConLai;
            long giaBan;
            long giaNhap;
            int namXuatBan;
            
            ArrayList<SachDTO> bookList = sachBLL.getByCondition("tenSach LIKE '%" + value + "%'");
            DefaultTableModel modelBook = (DefaultTableModel) bookTable.getModel();
            modelBook.setRowCount(0);

            if (bookList.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, value + " không tồn tại trong cơ sở dữ liệu");
                setBookTable();
            } else {
                for (SachDTO s : bookList) {
                    maSach = s.getMaSach();
                    tenSach = s.getTenSach();
                    maTheLoai = s.getMaTheLoai();
                    maTacGia = s.getMaTacGia();
                    maNhaXuatBan = s.getMaNhaXuatBan();
                    soLuongConLai = s.getSoLuongConLai();
                    giaBan = s.getGiaBan();
                    giaNhap = s.getGiaNhap();
                    namXuatBan = s.getNamXuatBan();
                    
                    modelBook.addRow(new Object[]{maSach, tenSach, maTheLoai, maTacGia, maNhaXuatBan, soLuongConLai, giaBan, giaNhap, namXuatBan, "O", "X"});
                }
            }
        }
    }//GEN-LAST:event_inputBookNameKeyPressed

    
    
    private void inputBookNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputBookNameFocusGained
        inputBookName.setText("");
        inputBookName.setForeground(new Color(51, 51, 51));
    }//GEN-LAST:event_inputBookNameFocusGained

    private void inputBookNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputBookNameFocusLost
        inputBookName.setText("Nhập tên sách");
        inputBookName.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_inputBookNameFocusLost

    private void resetBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetBtnMouseClicked
        if (JOptionPane.showConfirmDialog(this, "Bạn chắc chứ?","Question", 2) == JOptionPane.OK_OPTION) {
            maSachInput.setText("");
            tenSachInput.setText("");
            maTheLoaiInput.setSelectedIndex(0);
            maTacGiaInput.setSelectedIndex(0);
            maNhaXuatBanInput.setSelectedIndex(0);
            soLuongConLaiInput.setText("");
            giaBanInput.setText("");
            giaNhapInput.setText("");
            namXuatBanInput.setText("");
        }
    }//GEN-LAST:event_resetBtnMouseClicked

    private boolean validateValueAddBook() {
        String maSach = maSachInput.getText().toUpperCase();
        String tenSach = tenSachInput.getText();
        String maTheLoai = (String) maTheLoaiInput.getSelectedItem();
        String maTacGia = (String) maTacGiaInput.getSelectedItem();
        String maNhaXuatBan = (String) maNhaXuatBanInput.getSelectedItem();
        String soLuongConLai = soLuongConLaiInput.getText();
        String giaBan = giaBanInput.getText();
        String giaNhap = giaNhapInput.getText();
        String namXuatBan = namXuatBanInput.getText();
        
        if ("".equals(maSach) || "".equals(tenSach) || "".equals(maTheLoai)
                || "".equals(maTacGia) || "".equals(maNhaXuatBan)
                || "".equals(soLuongConLai) || "".equals(giaBan)
                || "".equals(giaNhap) || "".equals(namXuatBan)) {
            JOptionPane.showMessageDialog(this, "Không được để trống bất kì trường nào");
            return false;
        }
        
        ArrayList<SachDTO> bookList = sachBLL.getAllSach();

        for (SachDTO s : bookList) {
            if (s.getMaSach().equals(maSach)) {
                JOptionPane.showMessageDialog(this, "Mã sách đã tồn tại trong cơ sở dữ liệu");
                return false;
            }
        }
        
        int soLuongInt = (int) checkInputNumberValue(soLuongConLai, "Số lượng");
        if (soLuongInt < 0) {
            return false;
        }
        
        long giaBanLong = checkInputNumberValue(giaBan, "Giá bán");
        if (giaBanLong < 0) {
            return false;
        }
        
        long giaNhapLong = checkInputNumberValue(giaNhap, "Giá nhập");
        if (giaNhapLong < 0) {
            return false;
        }
        
        if (namXuatBan.matches("[0-9]\\d{1,}") == false) {
            JOptionPane.showMessageDialog(this, "Năm xuất bản không hợp lệ");
            return false;
        }
        
        return true;
    }
    
    private void addBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseClicked
        if (validateValueAddBook() == false) return;
        
        String maSach = maSachInput.getText().toUpperCase();
        String tenSach = tenSachInput.getText();
        String maTheLoai = (String) maTheLoaiInput.getSelectedItem();
        String maTacGia = (String) maTacGiaInput.getSelectedItem();
        String maNhaXuatBan = (String) maNhaXuatBanInput.getSelectedItem();
        int soLuongConLai = Integer.parseInt(soLuongConLaiInput.getText());
        long giaBan = Long.parseLong(giaBanInput.getText());
        long giaNhap = Long.parseLong(giaNhapInput.getText());
        int namXuatBan = Integer.parseInt(namXuatBanInput.getText());
        
        SachDTO s = new SachDTO(maSach, tenSach, maTheLoai, maTacGia, maNhaXuatBan, soLuongConLai, giaBan, giaNhap, namXuatBan);
        
        if (sachBLL.insert(s)) {
            maSachInput.setText("");
            tenSachInput.setText("");
            maTheLoaiInput.setSelectedIndex(0);
            maTacGiaInput.setSelectedIndex(0);
            maNhaXuatBanInput.setSelectedIndex(0);
            soLuongConLaiInput.setText("");
            giaBanInput.setText("");
            giaNhapInput.setText("");
            namXuatBanInput.setText("");
            
            DefaultTableModel modelBook = (DefaultTableModel) bookTable.getModel();
            modelBook.addRow(new Object[]{maSach, tenSach, maTheLoai, maTacGia, maNhaXuatBan, soLuongConLai, giaBan, giaNhap, namXuatBan, "O", "X"});

            JOptionPane.showMessageDialog(rootPane, "Thêm sách thành công");
        }
    }//GEN-LAST:event_addBtnMouseClicked

    private void maTheLoaiInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maTheLoaiInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maTheLoaiInputActionPerformed

    private void maTacGiaInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maTacGiaInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maTacGiaInputActionPerformed

    private void maSachInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maSachInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maSachInputActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addBtnActionPerformed

    private void inputBookNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputBookNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputBookNameActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JLabel backBtn;
    private javax.swing.JTable bookTable;
    private javax.swing.JLabel dateTimeLabel;
    private javax.swing.JPanel footer;
    private javax.swing.JTextField giaBanInput;
    private javax.swing.JTextField giaNhapInput;
    private javax.swing.JPanel header;
    private javax.swing.JLabel infoUser;
    private javax.swing.JTextField inputBookName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel logoutBtn;
    private javax.swing.JComboBox<String> maNhaXuatBanInput;
    private javax.swing.JTextField maSachInput;
    private javax.swing.JComboBox<String> maTacGiaInput;
    private javax.swing.JComboBox<String> maTheLoaiInput;
    private javax.swing.JTextField namXuatBanInput;
    private javax.swing.JButton resetBtn;
    private javax.swing.JTextField soLuongConLaiInput;
    private javax.swing.JTextField tenSachInput;
    // End of variables declaration//GEN-END:variables
}
