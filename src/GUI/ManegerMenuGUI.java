/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.awt.Image;
import java.math.RoundingMode;
import javax.swing.ImageIcon;

/**
 *
 * @author trong
 */
public class ManegerMenuGUI extends javax.swing.JFrame {

    /**
     * Creates new form LoginGUI
     */
    public ManegerMenuGUI() {
        initComponents();
//        scaleImage();
        setBounds(350, 150, 1000, 600);
        setVisible(true);
    }
    
//    public void scaleImage(){
//        ImageIcon icon1 = new ImageIcon("D:\\LAP_TRINH_JAVA\\LoginGUI\\src\\logingui\\banhang.png");
//        Image img = icon1.getImage();
//        Image imgScale = img.getScaledInstance(SelectBanHang.getWidth(), SelectBanHang.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon scaleIcon = new ImageIcon(imgScale);
//        SelectBanHang.setIcon(scaleIcon);
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanel_background = new keeptoo.KGradientPanel();
        jPanel1 = new javax.swing.JPanel();
        Header = new javax.swing.JLabel();
        iconHeader1 = new javax.swing.JLabel();
        iconHeader2 = new javax.swing.JLabel();
        BanHang_btn = new com.k33ptoo.components.KButton();
        NhanVien_btn = new com.k33ptoo.components.KButton();
        KhachHang_btn = new com.k33ptoo.components.KButton();
        Sach = new com.k33ptoo.components.KButton();
        NhaCungCap_btn = new com.k33ptoo.components.KButton();
        TacGia_btn = new com.k33ptoo.components.KButton();
        NhapHang_btn = new com.k33ptoo.components.KButton();
        ThongKe_btn = new com.k33ptoo.components.KButton();
        HoaDon_btn = new com.k33ptoo.components.KButton();
        PhanLoai_btn = new com.k33ptoo.components.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 249, 108));
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 600));

        JPanel_background.setkEndColor(new java.awt.Color(255, 153, 0));
        JPanel_background.setkGradientFocus(600);
        JPanel_background.setkStartColor(new java.awt.Color(255, 255, 153));
        JPanel_background.setOpaque(false);
        JPanel_background.setPreferredSize(new java.awt.Dimension(1000, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 450));

        Header.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        Header.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Header.setText("Welcome to BookStore");
        Header.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Header.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        iconHeader1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MenuGUI/bookicon.png"))); // NOI18N

        iconHeader2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MenuGUI/bookicon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(iconHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(iconHeader2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(iconHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
            .addComponent(iconHeader2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        BanHang_btn.setToolTipText("");
        BanHang_btn.setkBackGroundColor(new java.awt.Color(153, 51, 255));
        BanHang_btn.setkBorderRadius(50);
        BanHang_btn.setkEndColor(new java.awt.Color(0, 51, 51));
        BanHang_btn.setkHoverEndColor(new java.awt.Color(20, 61, 89));
        BanHang_btn.setkHoverForeGround(new java.awt.Color(204, 255, 255));
        BanHang_btn.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        BanHang_btn.setkPressedColor(new java.awt.Color(51, 255, 0));
        BanHang_btn.setkSelectedColor(new java.awt.Color(0, 255, 51));
        BanHang_btn.setkStartColor(new java.awt.Color(204, 204, 204));
        BanHang_btn.setPreferredSize(new java.awt.Dimension(200, 155));
        BanHang_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BanHang_btnActionPerformed(evt);
            }
        });

        NhanVien_btn.setToolTipText("");
        NhanVien_btn.setkBackGroundColor(new java.awt.Color(153, 51, 255));
        NhanVien_btn.setkBorderRadius(50);
        NhanVien_btn.setkEndColor(new java.awt.Color(20, 61, 89));
        NhanVien_btn.setkHoverEndColor(new java.awt.Color(20, 61, 89));
        NhanVien_btn.setkHoverForeGround(new java.awt.Color(204, 255, 255));
        NhanVien_btn.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        NhanVien_btn.setkPressedColor(new java.awt.Color(51, 255, 0));
        NhanVien_btn.setkSelectedColor(new java.awt.Color(0, 255, 51));
        NhanVien_btn.setkStartColor(new java.awt.Color(204, 204, 204));
        NhanVien_btn.setPreferredSize(new java.awt.Dimension(200, 155));
        NhanVien_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NhanVien_btnActionPerformed(evt);
            }
        });

        KhachHang_btn.setToolTipText("");
        KhachHang_btn.setkBackGroundColor(new java.awt.Color(153, 51, 255));
        KhachHang_btn.setkBorderRadius(50);
        KhachHang_btn.setkEndColor(new java.awt.Color(20, 61, 89));
        KhachHang_btn.setkHoverEndColor(new java.awt.Color(20, 61, 89));
        KhachHang_btn.setkHoverForeGround(new java.awt.Color(204, 255, 255));
        KhachHang_btn.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        KhachHang_btn.setkPressedColor(new java.awt.Color(51, 255, 0));
        KhachHang_btn.setkSelectedColor(new java.awt.Color(0, 255, 51));
        KhachHang_btn.setkStartColor(new java.awt.Color(204, 204, 204));
        KhachHang_btn.setPreferredSize(new java.awt.Dimension(200, 155));
        KhachHang_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KhachHang_btnActionPerformed(evt);
            }
        });

        Sach.setToolTipText("");
        Sach.setkBackGroundColor(new java.awt.Color(153, 51, 255));
        Sach.setkBorderRadius(50);
        Sach.setkEndColor(new java.awt.Color(20, 61, 89));
        Sach.setkHoverEndColor(new java.awt.Color(20, 61, 89));
        Sach.setkHoverForeGround(new java.awt.Color(204, 255, 255));
        Sach.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Sach.setkPressedColor(new java.awt.Color(51, 255, 0));
        Sach.setkSelectedColor(new java.awt.Color(0, 255, 51));
        Sach.setkStartColor(new java.awt.Color(204, 204, 204));
        Sach.setPreferredSize(new java.awt.Dimension(200, 155));
        Sach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SachActionPerformed(evt);
            }
        });

        NhaCungCap_btn.setToolTipText("");
        NhaCungCap_btn.setkBackGroundColor(new java.awt.Color(153, 51, 255));
        NhaCungCap_btn.setkBorderRadius(50);
        NhaCungCap_btn.setkEndColor(new java.awt.Color(20, 61, 89));
        NhaCungCap_btn.setkHoverEndColor(new java.awt.Color(20, 61, 89));
        NhaCungCap_btn.setkHoverForeGround(new java.awt.Color(204, 255, 255));
        NhaCungCap_btn.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        NhaCungCap_btn.setkPressedColor(new java.awt.Color(51, 255, 0));
        NhaCungCap_btn.setkSelectedColor(new java.awt.Color(0, 255, 51));
        NhaCungCap_btn.setkStartColor(new java.awt.Color(204, 204, 204));
        NhaCungCap_btn.setPreferredSize(new java.awt.Dimension(200, 155));
        NhaCungCap_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NhaCungCap_btnActionPerformed(evt);
            }
        });

        TacGia_btn.setToolTipText("");
        TacGia_btn.setkBackGroundColor(new java.awt.Color(153, 51, 255));
        TacGia_btn.setkBorderRadius(50);
        TacGia_btn.setkEndColor(new java.awt.Color(20, 61, 89));
        TacGia_btn.setkHoverEndColor(new java.awt.Color(20, 61, 89));
        TacGia_btn.setkHoverForeGround(new java.awt.Color(204, 255, 255));
        TacGia_btn.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        TacGia_btn.setkPressedColor(new java.awt.Color(51, 255, 0));
        TacGia_btn.setkSelectedColor(new java.awt.Color(0, 255, 51));
        TacGia_btn.setkStartColor(new java.awt.Color(204, 204, 204));
        TacGia_btn.setPreferredSize(new java.awt.Dimension(200, 155));
        TacGia_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TacGia_btnActionPerformed(evt);
            }
        });

        NhapHang_btn.setToolTipText("");
        NhapHang_btn.setkBackGroundColor(new java.awt.Color(153, 51, 255));
        NhapHang_btn.setkBorderRadius(50);
        NhapHang_btn.setkEndColor(new java.awt.Color(20, 61, 89));
        NhapHang_btn.setkHoverEndColor(new java.awt.Color(20, 61, 89));
        NhapHang_btn.setkHoverForeGround(new java.awt.Color(204, 255, 255));
        NhapHang_btn.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        NhapHang_btn.setkPressedColor(new java.awt.Color(51, 255, 0));
        NhapHang_btn.setkSelectedColor(new java.awt.Color(0, 255, 51));
        NhapHang_btn.setkStartColor(new java.awt.Color(204, 204, 204));
        NhapHang_btn.setPreferredSize(new java.awt.Dimension(200, 155));
        NhapHang_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NhapHang_btnActionPerformed(evt);
            }
        });

        ThongKe_btn.setToolTipText("");
        ThongKe_btn.setkBackGroundColor(new java.awt.Color(153, 51, 255));
        ThongKe_btn.setkBorderRadius(50);
        ThongKe_btn.setkEndColor(new java.awt.Color(20, 61, 89));
        ThongKe_btn.setkHoverEndColor(new java.awt.Color(20, 61, 89));
        ThongKe_btn.setkHoverForeGround(new java.awt.Color(204, 255, 255));
        ThongKe_btn.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        ThongKe_btn.setkPressedColor(new java.awt.Color(51, 255, 0));
        ThongKe_btn.setkSelectedColor(new java.awt.Color(0, 255, 51));
        ThongKe_btn.setkStartColor(new java.awt.Color(204, 204, 204));
        ThongKe_btn.setPreferredSize(new java.awt.Dimension(200, 155));
        ThongKe_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThongKe_btnActionPerformed(evt);
            }
        });

        HoaDon_btn.setToolTipText("");
        HoaDon_btn.setkBackGroundColor(new java.awt.Color(153, 51, 255));
        HoaDon_btn.setkBorderRadius(50);
        HoaDon_btn.setkEndColor(new java.awt.Color(20, 61, 89));
        HoaDon_btn.setkHoverEndColor(new java.awt.Color(20, 61, 89));
        HoaDon_btn.setkHoverForeGround(new java.awt.Color(204, 255, 255));
        HoaDon_btn.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        HoaDon_btn.setkPressedColor(new java.awt.Color(51, 255, 0));
        HoaDon_btn.setkSelectedColor(new java.awt.Color(0, 255, 51));
        HoaDon_btn.setkStartColor(new java.awt.Color(204, 204, 204));
        HoaDon_btn.setPreferredSize(new java.awt.Dimension(200, 155));
        HoaDon_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HoaDon_btnActionPerformed(evt);
            }
        });

        PhanLoai_btn.setToolTipText("");
        PhanLoai_btn.setkBackGroundColor(new java.awt.Color(153, 51, 255));
        PhanLoai_btn.setkBorderRadius(50);
        PhanLoai_btn.setkEndColor(new java.awt.Color(20, 61, 89));
        PhanLoai_btn.setkHoverEndColor(new java.awt.Color(20, 61, 89));
        PhanLoai_btn.setkHoverForeGround(new java.awt.Color(204, 255, 255));
        PhanLoai_btn.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        PhanLoai_btn.setkPressedColor(new java.awt.Color(51, 255, 0));
        PhanLoai_btn.setkSelectedColor(new java.awt.Color(0, 255, 51));
        PhanLoai_btn.setkStartColor(new java.awt.Color(204, 204, 204));
        PhanLoai_btn.setPreferredSize(new java.awt.Dimension(200, 155));
        PhanLoai_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhanLoai_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPanel_backgroundLayout = new javax.swing.GroupLayout(JPanel_background);
        JPanel_background.setLayout(JPanel_backgroundLayout);
        JPanel_backgroundLayout.setHorizontalGroup(
            JPanel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
            .addGroup(JPanel_backgroundLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(JPanel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TacGia_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BanHang_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(JPanel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NhaCungCap_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NhapHang_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(JPanel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NhanVien_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sach, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(JPanel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(KhachHang_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PhanLoai_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(JPanel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HoaDon_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ThongKe_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        JPanel_backgroundLayout.setVerticalGroup(
            JPanel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel_backgroundLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(JPanel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KhachHang_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NhanVien_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NhapHang_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BanHang_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HoaDon_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(JPanel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TacGia_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NhaCungCap_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sach, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PhanLoai_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ThongKe_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanel_background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanel_background, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BanHang_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BanHang_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BanHang_btnActionPerformed

    private void NhanVien_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NhanVien_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NhanVien_btnActionPerformed

    private void KhachHang_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KhachHang_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KhachHang_btnActionPerformed

    private void SachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SachActionPerformed

    private void NhaCungCap_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NhaCungCap_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NhaCungCap_btnActionPerformed

    private void TacGia_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TacGia_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TacGia_btnActionPerformed

    private void NhapHang_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NhapHang_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NhapHang_btnActionPerformed

    private void ThongKe_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThongKe_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ThongKe_btnActionPerformed

    private void HoaDon_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HoaDon_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HoaDon_btnActionPerformed

    private void PhanLoai_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhanLoai_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PhanLoai_btnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManegerMenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManegerMenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManegerMenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManegerMenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManegerMenuGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton BanHang_btn;
    private javax.swing.JLabel Header;
    private com.k33ptoo.components.KButton HoaDon_btn;
    private keeptoo.KGradientPanel JPanel_background;
    private com.k33ptoo.components.KButton KhachHang_btn;
    private com.k33ptoo.components.KButton NhaCungCap_btn;
    private com.k33ptoo.components.KButton NhanVien_btn;
    private com.k33ptoo.components.KButton NhapHang_btn;
    private com.k33ptoo.components.KButton PhanLoai_btn;
    private com.k33ptoo.components.KButton Sach;
    private com.k33ptoo.components.KButton TacGia_btn;
    private com.k33ptoo.components.KButton ThongKe_btn;
    private javax.swing.JLabel iconHeader1;
    private javax.swing.JLabel iconHeader2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}