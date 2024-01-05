package payroll;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LogInPayroll extends javax.swing.JFrame implements ActionListener {

    Connection connection;
    public void LogInPayroll() {
        initComponents();
        connectToDB();
        loginButton.addActionListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        left = new javax.swing.JPanel();
        welcome = new javax.swing.JLabel();
        system_title = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        right = new javax.swing.JPanel();
        logintitle = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        userTF = new javax.swing.JTextField();
        passLabel = new javax.swing.JLabel();
        selectLabel = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        loginButton = new javax.swing.JButton();
        passTF = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 650));
        setMinimumSize(new java.awt.Dimension(1000, 650));
        setResizable(false);

        jPanel2.setLayout(null);

        left.setBackground(new java.awt.Color(38, 94, 124));

        welcome.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        welcome.setForeground(new java.awt.Color(255, 255, 255));
        welcome.setText("Welcome!");

        system_title.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        system_title.setForeground(new java.awt.Color(255, 255, 255));
        system_title.setText("Employee Payroll System");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imagerep.png"))); // NOI18N

        javax.swing.GroupLayout leftLayout = new javax.swing.GroupLayout(left);
        left.setLayout(leftLayout);
        leftLayout.setHorizontalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftLayout.createSequentialGroup()
                .addGroup(leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftLayout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(welcome))
                    .addGroup(leftLayout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(system_title))
                    .addGroup(leftLayout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(155, Short.MAX_VALUE))
        );
        leftLayout.setVerticalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftLayout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(welcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(system_title)
                .addContainerGap(186, Short.MAX_VALUE))
        );

        jPanel2.add(left);
        left.setBounds(0, 0, 580, 630);

        right.setBackground(new java.awt.Color(255, 255, 255));

        logintitle.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        logintitle.setText("LOG-IN  ADMIN-EMPLOYEE");

        userLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userLabel.setText("USERNAME:");

        userTF.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(46, 139, 146), 1, true));
        userTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTFActionPerformed(evt);
            }
        });

        passLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        passLabel.setText("PASSWORD:");

        selectLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        selectLabel.setText("SELECT POSITION: ");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Employee" }));
        jComboBox1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(46, 139, 146), 1, true));
        jComboBox1.setFocusable(false);
        jComboBox1.setLightWeightPopupEnabled(false);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        loginButton.setBackground(new java.awt.Color(46, 139, 146));
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("LOG IN");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        passTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passTFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rightLayout = new javax.swing.GroupLayout(right);
        right.setLayout(rightLayout);
        rightLayout.setHorizontalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightLayout.createSequentialGroup()
                .addGap(0, 100, Short.MAX_VALUE)
                .addComponent(logintitle)
                .addGap(97, 97, 97))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148))
            .addGroup(rightLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userTF)
                    .addComponent(passTF, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                    .addComponent(userLabel)
                    .addComponent(passLabel)
                    .addComponent(selectLabel)
                    .addComponent(jComboBox1, 0, 269, Short.MAX_VALUE))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        rightLayout.setVerticalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(logintitle)
                .addGap(47, 47, 47)
                .addComponent(userLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userTF, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(passLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passTF, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(selectLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );

        jPanel2.add(right);
        right.setBounds(578, 0, 420, 650);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="ActionPerformed">                                       
    private void userTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTFActionPerformed

    }//GEN-LAST:event_userTFActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginButtonActionPerformed

    private void passTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passTFActionPerformed
    // </editor-fold>                                     
   public void connectToDB() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll", "root", "");
        } catch (SQLException e) {
            System.out.println("Unable to connect to the database");
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("Error Message: " + e.getMessage());
            System.exit(1);
        }
    }

    public int getEmployeeID(String username, String password) {
        try{
            String sql = "SELECT id FROM employee WHERE id = ? AND password = ? AND status = 'Active' ";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, username);
                statement.setString(2, password);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getInt("id");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("Error Message: " + e.getMessage());
        }
        return -1;
    }

    public void actionPerformed(java.awt.event.ActionEvent e) {
        String username = userTF.getText();
        String password = passTF.getText();
        int employeeID = getEmployeeID(username, password);
        String selectedPosition = jComboBox1.getSelectedItem().toString();
        if (e.getSource() == loginButton) {
            if (selectedPosition.equals("Employee") && (employeeID != -1)) {
                JOptionPane.showMessageDialog(this, "Login Successfully.");
                Client client = new Client();
                //client.Client();
                client.ClientView(employeeID);
                client.setVisible(true);
                setVisible(false);
                dispose();
            }
            else if (selectedPosition.equals("Admin")&&username.equals("admin") && password.equals("admin123")) {
                JOptionPane.showMessageDialog(this, "Login Succesfully");
                AdminMenu admin = new AdminMenu();
                admin.AdminMenu();
                admin.setVisible(true);
                setVisible(false);
                dispose();
            }
            else {
                JOptionPane.showMessageDialog(this, "Unable to Login. Invalid Username or Password.");
            }
        }

    }

    /*public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogInPayroll().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel left;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel logintitle;
    private javax.swing.JLabel passLabel;
    private javax.swing.JPasswordField passTF;
    private javax.swing.JPanel right;
    private javax.swing.JLabel selectLabel;
    private javax.swing.JLabel system_title;
    private javax.swing.JLabel userLabel;
    private javax.swing.JTextField userTF;
    private javax.swing.JLabel welcome;
    // End of variables declaration//GEN-END:variables
}
