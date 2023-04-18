
package GUI;

import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ImageIcon;

public class LoginGUI extends javax.swing.JFrame {

    /**
     * Creates new form LoginGUI
     */
    public LoginGUI() {
        initComponents();
        this.setTitle("Đăng nhập");
        this.setBounds(300, 100, 1000, 600);
        scaleImage();
        setVisible(true);
    }

    public void scaleImage(){
        ImageIcon icon1 = new ImageIcon("D:\\LAP_TRINH_JAVA\\Do_an\\bookStoreJava\\src\\GUI\\loginlogo.png");
        Image img = icon1.getImage();
        Image imgScale = img.getScaledInstance(jLable_logo.getWidth(), jLable_logo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaleIcon = new ImageIcon(imgScale);
        jLable_logo.setIcon(scaleIcon);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLable_logo = new javax.swing.JLabel();
        jLabel_Test = new javax.swing.JLabel();
        label_pass = new javax.swing.JLabel();
        label_user = new javax.swing.JLabel();
        txTenDangNhap = new javax.swing.JTextField();
        txMatKhau = new javax.swing.JPasswordField();
        Login_button = new com.k33ptoo.components.KButton();
        showPass = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LoginGUI");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 153, 0));
        kGradientPanel1.setkGradientFocus(300);
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 153));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1000, 600));

        jLabel_Test.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel_Test.setForeground(new java.awt.Color(20, 61, 89));
        jLabel_Test.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Test.setText("WELCOME TO OUR BOOKSTORE");

        label_pass.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        label_pass.setForeground(new java.awt.Color(20, 61, 89));
        label_pass.setText("Mật Khẩu");

        label_user.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        label_user.setForeground(new java.awt.Color(20, 61, 89));
        label_user.setText("Tài Khoản");

        txTenDangNhap.setToolTipText("");
        txTenDangNhap.setOpaque(true);
        txTenDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txTenDangNhapActionPerformed(evt);
            }
        });

        txMatKhau.setToolTipText("");
        txMatKhau.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                txMatKhauComponentMoved(evt);
            }
        });

        Login_button.setForeground(new java.awt.Color(102, 102, 102));
        Login_button.setText("Đăng Nhập");
        Login_button.setToolTipText("");
        Login_button.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        Login_button.setkBackGroundColor(new java.awt.Color(0, 0, 0));
        Login_button.setkBorderRadius(25);
        Login_button.setkEndColor(new java.awt.Color(255, 255, 153));
        Login_button.setkForeGround(new java.awt.Color(20, 61, 89));
        Login_button.setkHoverEndColor(new java.awt.Color(20, 61, 89));
        Login_button.setkHoverForeGround(new java.awt.Color(244, 180, 26));
        Login_button.setkHoverStartColor(new java.awt.Color(20, 61, 89));
        Login_button.setkIndicatorColor(new java.awt.Color(20, 61, 89));
        Login_button.setkIndicatorThickness(40);
        Login_button.setkPressedColor(new java.awt.Color(20, 61, 89));
        Login_button.setkStartColor(new java.awt.Color(204, 102, 0));
        Login_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Login_buttonActionPerformed(evt);
            }
        });

        showPass.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        showPass.setForeground(new java.awt.Color(20, 61, 89));
        showPass.setText("Hiện mật khẩu");
        showPass.setToolTipText("");
        showPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel_Test, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLable_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)))
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(label_user, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label_pass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txTenDangNhap, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                        .addComponent(txMatKhau, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(showPass, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(Login_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(label_user, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(label_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(showPass)
                        .addGap(31, 31, 31)
                        .addComponent(Login_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel_Test, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLable_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(189, 189, 189))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txTenDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txTenDangNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txTenDangNhapActionPerformed

    private void Login_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Login_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Login_buttonActionPerformed

    private void showPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPassActionPerformed
        showPass.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == 1)
                txMatKhau.setEchoChar((char)0);
        else
                txMatKhau.setEchoChar('*'); //
        } });
    }//GEN-LAST:event_showPassActionPerformed

    private void txMatKhauComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_txMatKhauComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_txMatKhauComponentMoved

    
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
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton Login_button;
    private javax.swing.JLabel jLabel_Test;
    private javax.swing.JLabel jLable_logo;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel label_pass;
    private javax.swing.JLabel label_user;
    private javax.swing.JCheckBox showPass;
    private javax.swing.JPasswordField txMatKhau;
    private javax.swing.JTextField txTenDangNhap;
    // End of variables declaration//GEN-END:variables
}