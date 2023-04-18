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
public class SellEmployeeMenuGUI extends javax.swing.JFrame {

    /**
     * Creates new form LoginGUI
     */
    public SellEmployeeMenuGUI() {
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
        HoaDon_btn = new com.k33ptoo.components.KButton();
        KhachHang_btn = new com.k33ptoo.components.KButton();
        BanHang_btn = new com.k33ptoo.components.KButton();

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
                .addContainerGap(192, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(iconHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
            .addComponent(iconHeader2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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

        BanHang_btn.setToolTipText("");
        BanHang_btn.setkBackGroundColor(new java.awt.Color(153, 51, 255));
        BanHang_btn.setkBorderRadius(50);
        BanHang_btn.setkEndColor(new java.awt.Color(20, 61, 89));
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

        javax.swing.GroupLayout JPanel_backgroundLayout = new javax.swing.GroupLayout(JPanel_background);
        JPanel_background.setLayout(JPanel_backgroundLayout);
        JPanel_backgroundLayout.setHorizontalGroup(
            JPanel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
            .addGroup(JPanel_backgroundLayout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(BanHang_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(HoaDon_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(KhachHang_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPanel_backgroundLayout.setVerticalGroup(
            JPanel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel_backgroundLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125)
                .addGroup(JPanel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HoaDon_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BanHang_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KhachHang_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(171, Short.MAX_VALUE))
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

    private void HoaDon_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HoaDon_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HoaDon_btnActionPerformed

    private void KhachHang_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KhachHang_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KhachHang_btnActionPerformed

    private void BanHang_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BanHang_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BanHang_btnActionPerformed

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
            java.util.logging.Logger.getLogger(SellEmployeeMenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SellEmployeeMenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SellEmployeeMenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SellEmployeeMenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new SellEmployeeMenuGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton BanHang_btn;
    private javax.swing.JLabel Header;
    private com.k33ptoo.components.KButton HoaDon_btn;
    private keeptoo.KGradientPanel JPanel_background;
    private com.k33ptoo.components.KButton KhachHang_btn;
    private javax.swing.JLabel iconHeader1;
    private javax.swing.JLabel iconHeader2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
