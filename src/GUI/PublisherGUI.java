/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BLL.NhaXuatBanBLL;
import DTO.NhaXuatBanDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Admin
 */
public class PublisherGUI extends javax.swing.JFrame {
    
    private NhaXuatBanBLL nhaXuatBanBLL = new NhaXuatBanBLL();
    
    private JTextField tenNXB = new JTextField();
    private JTextField diaChi = new JTextField();
    private JTextField sDT = new JTextField();
    
    private JPanel popUpUpdateNXB = getPopUpUpdateNXB();
    
    
    /**
     * Creates new form NhaXuatBanGUI
     */
    public PublisherGUI() {
        initComponents();
        
        Thread th = new ClockLabel(dateTimeLabel);
        th.start();
     
        setNXBTable();

        NXBTable.getColumn("Xóa").setCellRenderer(new ButtonRenderer());
        NXBTable.getColumn("Sửa").setCellRenderer(new ButtonRenderer());

        addEventNXBTable();

        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    
    private boolean validateValueAddNXB() {
        String tennxb = tenNXBInput.getText();
        String diachi = diaChiInput.getText();
        String sdt = sDTInput.getText();
        
        
        if ("".equals(tennxb) || "".equals(diachi)
                || "".equals(sdt) ) {
            JOptionPane.showMessageDialog(this, "Không được để trống bất kì trường nào");
            return false;
        }
        
        if(sdt.matches("(84|0[3|5|7|8|9])+([0-9]{8})\\b") == false){
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ");
            return false;
        }       
        
        return true;
    }
    
    
    private boolean validateValueUpdateNXB() {
        String tennxb = tenNXB.getText();
        String diachi = diaChi.getText();
        String sdt = sDT.getText();
        
        
        if ("".equals(tennxb) || "".equals(diachi)
                || "".equals(sdt) ) {
            JOptionPane.showMessageDialog(this, "Không được để trống bất kì trường nào");
            return false;
        }
        
      if(sdt.matches("(84|0[3|5|7|8|9])+([0-9]{8})\\b") == false){
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ");
            return false;
        }       
        
        
        return true;
    }
    
    private JPanel getPopUpUpdateNXB() {
        Font font_16_plain = new Font("Monospaced", Font.PLAIN, 16);
        Font font_16_bold = new Font("Monospaced", Font.BOLD, 16);
        
        tenNXB.setFont(font_16_plain);
        diaChi.setFont(font_16_plain);
        sDT.setFont(font_16_plain);
        
        
        JLabel tenNXBLabel = new JLabel("Tên NXB: ");
        tenNXBLabel.setFont(font_16_bold);
        
        JLabel diaChiLabel = new JLabel("Địa chỉ: ");
        diaChiLabel.setFont(font_16_bold);
        
        JLabel sDTLabel = new JLabel("Số điện thoại: ");
        sDTLabel.setFont(font_16_bold);
        
        
        
        JPanel containerPanel = new JPanel();
        JPanel tenNXBPanel = new JPanel();
        JPanel diaChiPanel = new JPanel();
        JPanel sDTPanel = new JPanel();
        

        containerPanel.setLayout(new GridLayout(3, 1, 10, 10));
        tenNXBPanel.setLayout(new BorderLayout());
        diaChiPanel.setLayout(new BorderLayout());
        sDTPanel.setLayout(new BorderLayout());
        
        
        tenNXBPanel.add(tenNXBLabel, BorderLayout.NORTH);
        tenNXBPanel.add(tenNXB, BorderLayout.CENTER);
        
        diaChiPanel.add(diaChiLabel, BorderLayout.NORTH);
        diaChiPanel.add(diaChi, BorderLayout.CENTER);
        
        sDTPanel.add(sDTLabel, BorderLayout.NORTH);
        sDTPanel.add(sDT, BorderLayout.CENTER);
        
        
        containerPanel.add(tenNXBPanel);
        containerPanel.add(diaChiPanel);
        containerPanel.add(sDTPanel);
       
        
        return containerPanel;
    }
    
    
    private void addEventNXBTable() {
        NXBTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = NXBTable.rowAtPoint(evt.getPoint());
                int col = NXBTable.columnAtPoint(evt.getPoint());

                if (row >= 0 && col == 4) {
                    int manxb = Integer.parseInt(String.valueOf(NXBTable.getValueAt(row, 0)));
                    String tennxb = String.valueOf(NXBTable.getValueAt(row, 1));
                    String diachi = String.valueOf(NXBTable.getValueAt(row, 2));
                    String sdt = String.valueOf(NXBTable.getValueAt(row, 3));
                    
                    tenNXB.setText(tennxb);
                    diaChi.setText(diachi);
                    sDT.setText(sdt);
                  
                    int result = JOptionPane.showConfirmDialog(null, popUpUpdateNXB, 
                                "Mời sửa thông tin NXB " , JOptionPane.OK_CANCEL_OPTION);
                    
                    if (result == JOptionPane.OK_OPTION){
                        if (validateValueUpdateNXB() == false) return;
                        
                        tennxb = tenNXB.getText();
                        diachi = diaChi.getText();
                        sdt = sDT.getText();
                        
                        NhaXuatBanDTO nxb = new NhaXuatBanDTO(manxb,tennxb,diachi,sdt);
                        
                        nhaXuatBanBLL.update(nxb);
                        
                        updateNXBTable();
                        
                        tenNXB.setText("");
                        diaChi.setText("");
                        sDT.setText("");
                    }
                    
                }
                
                if (row >= 0 && col == 5) {
                    int manxb = Integer.parseInt(String.valueOf(NXBTable.getValueAt(row, 0)));
                    showComfirmRemove(row, manxb);
                }
            }
        });
    }
    
    private void showComfirmRemove(int row, int manxb) {
        DefaultTableModel modelNXB = (DefaultTableModel) NXBTable.getModel();
        if (JOptionPane.showConfirmDialog(this, "Bạn chắc chứ?", "Question", 2) == 0) {
            modelNXB.removeRow(row);
            nhaXuatBanBLL.delete(manxb);
        }
    }
    
     private void setNXBTable() {
        int manxb;
        String tennxb;
        String diachi;
        String sdt;
        
            
        ArrayList<NhaXuatBanDTO> NXBList = nhaXuatBanBLL.getAll();
        DefaultTableModel modelNXB = (DefaultTableModel) NXBTable.getModel();
        modelNXB.setRowCount(0);

        for (NhaXuatBanDTO s : NXBList) {
            tennxb = s.getTenNhaXuatBan();
            diachi = s.getDiaChi();
            manxb = s.getMaNhaXuatBan();
            sdt = s.getSoDienThoai();
            

            modelNXB.addRow(new Object[]{manxb,tennxb,diachi,sdt, "O", "X"});
        }
    }
     
     private void updateNXBTable() {
        DefaultTableModel modelNXB = (DefaultTableModel) NXBTable.getModel();
        modelNXB.setRowCount(0);
        
        setNXBTable();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        inputSearch = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        abc = new javax.swing.JScrollPane();
        NXBTable = new javax.swing.JTable();
        condition = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        diaChiInput = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        sDTInput = new javax.swing.JTextField();
        addBtn = new javax.swing.JButton();
        resetBtn = new javax.swing.JButton();
        tenNXBInput = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        backBtn = new javax.swing.JLabel();
        dateTimeLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JLabel();
        exportExcel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel14.setText("Tìm nhà xuất bản:");

        inputSearch.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        inputSearch.setForeground(new java.awt.Color(102, 102, 102));
        inputSearch.setText("Tìm kiếm  ...");
        inputSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputSearchFocusLost(evt);
            }
        });
        inputSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputSearchActionPerformed(evt);
            }
        });
        inputSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputSearchKeyPressed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        abc.setBackground(new java.awt.Color(255, 255, 255));

        NXBTable.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        NXBTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã NXB ", "Tên NXB", "Địa Chỉ", "SĐT", "Sửa", "Xóa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        NXBTable.setUpdateSelectionOnSort(false);
        NXBTable.setVerifyInputWhenFocusTarget(false);
        abc.setViewportView(NXBTable);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(abc)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(abc, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
        );

        condition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã NXB", "Tên NXB"
            + "" }));
condition.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        conditionActionPerformed(evt);
    }
    });

    javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
    jPanel7.setLayout(jPanel7Layout);
    jPanel7Layout.setHorizontalGroup(
        jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jLabel14)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(inputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(condition, 0, 120, Short.MAX_VALUE))
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(0, 0, 0))
    );
    jPanel7Layout.setVerticalGroup(
        jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel7Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel14)
                .addComponent(inputSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(condition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel5.setPreferredSize(new java.awt.Dimension(442, 551));

    jPanel6.setBackground(new java.awt.Color(255, 255, 255));

    jLabel9.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
    jLabel9.setForeground(new java.awt.Color(255, 153, 0));
    jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel9.setText("Thêm Nhà Xuất Bản");
    jLabel9.setPreferredSize(new java.awt.Dimension(130, 33));

    jLabel11.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
    jLabel11.setText("Tên nhà xuất bản :");
    jLabel11.setPreferredSize(new java.awt.Dimension(213, 25));

    jLabel12.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
    jLabel12.setText("Địa chỉ          :");
    jLabel12.setPreferredSize(new java.awt.Dimension(213, 25));

    diaChiInput.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
    diaChiInput.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            diaChiInputActionPerformed(evt);
        }
    });

    jLabel13.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
    jLabel13.setText("Số điện thoại    :");
    jLabel13.setPreferredSize(new java.awt.Dimension(213, 25));

    sDTInput.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
    sDTInput.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            sDTInputActionPerformed(evt);
        }
    });

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
    resetBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            resetBtnActionPerformed(evt);
        }
    });

    tenNXBInput.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
    tenNXBInput.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            tenNXBInputActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
    jPanel6.setLayout(jPanel6Layout);
    jPanel6Layout.setHorizontalGroup(
        jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel6Layout.createSequentialGroup()
            .addGap(20, 20, 20)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(diaChiInput))
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(sDTInput))
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(tenNXBInput))
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(140, 140, 140)
                    .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 46, Short.MAX_VALUE)))
            .addContainerGap())
    );
    jPanel6Layout.setVerticalGroup(
        jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel6Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(23, 23, 23)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(tenNXBInput, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(diaChiInput, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sDTInput, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(40, 40, 40)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(111, 111, 111))
    );

    javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
    jPanel5.setLayout(jPanel5Layout);
    jPanel5Layout.setHorizontalGroup(
        jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel5Layout.createSequentialGroup()
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );
    jPanel5Layout.setVerticalGroup(
        jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jPanel4.setBackground(new java.awt.Color(255, 204, 102));
    jPanel4.setPreferredSize(new java.awt.Dimension(1388, 56));

    backBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/back.png"))); // NOI18N
    backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            backBtnMouseClicked(evt);
        }
    });

    dateTimeLabel.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
    dateTimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    dateTimeLabel.setText("dateTimeLabel");
    dateTimeLabel.setPreferredSize(new java.awt.Dimension(158, 33));

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel4Layout.createSequentialGroup()
            .addGap(23, 23, 23)
            .addComponent(backBtn)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dateTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );
    jPanel4Layout.setVerticalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(dateTimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
            .addContainerGap())
    );

    jPanel1.setBackground(new java.awt.Color(255, 204, 102));
    jPanel1.setPreferredSize(new java.awt.Dimension(219, 65));

    jLabel1.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Nhà Xuất Bản");

    logoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/logout.png"))); // NOI18N
    logoutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            logoutBtnMouseClicked(evt);
        }
    });

    exportExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/import-excel.png"))); // NOI18N
    exportExcel.setToolTipText("Xuất Excel");
    exportExcel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    exportExcel.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            exportExcelMouseClicked(evt);
        }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(19, 19, 19)
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(exportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(35, 35, 35)
            .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(44, 44, 44))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(exportExcel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
            .addGap(0, 0, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1187, Short.MAX_VALUE)
        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1187, Short.MAX_VALUE)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputSearchActionPerformed

    private void conditionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conditionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_conditionActionPerformed

    private void diaChiInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diaChiInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diaChiInputActionPerformed

    private void sDTInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sDTInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sDTInputActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addBtnActionPerformed

    private void resetBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetBtnMouseClicked
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(this, "Bạn chắc chứ?", "Question", 2) == JOptionPane.OK_OPTION) {
            tenNXBInput.setText("");
            diaChiInput.setText("");
            sDTInput.setText("");
        }
    }//GEN-LAST:event_resetBtnMouseClicked

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resetBtnActionPerformed

    private void backBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_backBtnMouseClicked

    private void logoutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_logoutBtnMouseClicked

    private void tenNXBInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenNXBInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tenNXBInputActionPerformed

    private void addBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseClicked
        // TODO add your handling code here:
        if (validateValueAddNXB() == false)
            return;
        
        String tennxb = tenNXBInput.getText();
        String diachi = diaChiInput.getText();
        String sdt = sDTInput.getText();

        NhaXuatBanDTO nxb = new NhaXuatBanDTO(-1,tennxb,diachi,sdt);

        int manxb = nhaXuatBanBLL.insert(nxb);
        
        if (manxb >= 1) {
            tenNXBInput.setText("");
            diaChiInput.setText("");
            sDTInput.setText("");
            

            DefaultTableModel modelNXB = (DefaultTableModel) NXBTable.getModel();
            modelNXB.addRow(new Object[] { manxb,tennxb,diachi,sdt, "O", "X" });

            JOptionPane.showMessageDialog(rootPane, "Thêm NXB thành công");
        }
    }//GEN-LAST:event_addBtnMouseClicked

    private void inputSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputSearchKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int con =  condition.getSelectedIndex();
            String value = inputSearch.getText();
            String tennxb;
            String diachi;
            int manxb;
            String sdt;
            
            ArrayList<NhaXuatBanDTO> NXBList = new ArrayList<>();
            
            if(con == 0){
                NXBList = nhaXuatBanBLL.getByCondition("maNhaXuatBan LIKE '%" + value + "%'");
            }else{
                NXBList = nhaXuatBanBLL.getByCondition("tenNhaXuatBan LIKE '%" + value + "%'");
            }
            
            DefaultTableModel modelNXB = (DefaultTableModel) NXBTable.getModel();
            modelNXB.setRowCount(0);

            if (NXBList.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, value + " không tồn tại  hoặc điều kiện kiện tìm kiếm không đúng");
                setNXBTable();
            } else {
                for (NhaXuatBanDTO s : NXBList) {
                    tennxb = s.getTenNhaXuatBan();
                    diachi = s.getDiaChi();
                    manxb = s.getMaNhaXuatBan();
                    sdt= s.getSoDienThoai();
                    
                    
                    modelNXB.addRow(new Object[]{manxb,tennxb,diachi,sdt, "O", "X"});
                }
            }
        }
    }//GEN-LAST:event_inputSearchKeyPressed

    private void inputSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputSearchFocusGained
        // TODO add your handling code here:
         inputSearch.setText("");
        inputSearch.setForeground(new Color(51, 51, 51));
    }//GEN-LAST:event_inputSearchFocusGained

    private void inputSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputSearchFocusLost
        // TODO add your handling code here:
        inputSearch.setText("Tìm kiếm ...");
        inputSearch.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_inputSearchFocusLost

    private void exportExcelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportExcelMouseClicked
        ArrayList<NhaXuatBanDTO> nxbList = nhaXuatBanBLL.getAll();

        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("nhaxuatban");

            XSSFRow row = null;
            XSSFCell cell = null;

            row = sheet.createRow(0);

            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Mã nhà xuất bản");

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Tên nhà xuất bản");

            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Địa chỉ");

            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Số điện thoại");

            int i = 1;
            for (NhaXuatBanDTO nxb : nxbList) {
                row = sheet.createRow(0 + i);

                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(i);

                cell = row.createCell(1, CellType.NUMERIC);
                cell.setCellValue(nxb.getMaNhaXuatBan());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(nxb.getTenNhaXuatBan());

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(nxb.getDiaChi());

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(nxb.getSoDienThoai());

                i++;
            }

            File f = new File("D://nhaxuatban.xlsx");
            try {
                FileOutputStream fis = new FileOutputStream(f);

                workbook.write(fis);
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_exportExcelMouseClicked

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable NXBTable;
    private javax.swing.JScrollPane abc;
    private javax.swing.JButton addBtn;
    private javax.swing.JLabel backBtn;
    private javax.swing.JComboBox<String> condition;
    private javax.swing.JLabel dateTimeLabel;
    private javax.swing.JTextField diaChiInput;
    private javax.swing.JLabel exportExcel;
    private javax.swing.JTextField inputSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel logoutBtn;
    private javax.swing.JButton resetBtn;
    private javax.swing.JTextField sDTInput;
    private javax.swing.JTextField tenNXBInput;
    // End of variables declaration//GEN-END:variables
}
