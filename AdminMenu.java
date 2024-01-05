
package payroll;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class AdminMenu extends javax.swing.JFrame implements ActionListener {

    public void AdminMenu() {
        initComponents();
        logoutButton.addActionListener(this);
        employeeButton.addActionListener(this);
        positionButton.addActionListener(this);
        reportsButton.addActionListener(this);
        deductionButton.addActionListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        employeeButton = new javax.swing.JButton();
        adminHead = new javax.swing.JLabel();
        deductionButton = new javax.swing.JButton();
        positionButton = new javax.swing.JButton();
        reportsButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 650));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(38, 94, 124));

        employeeButton.setBackground(new java.awt.Color(51, 153, 153));
        employeeButton.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        employeeButton.setForeground(new java.awt.Color(255, 255, 255));
        employeeButton.setText("Employees' Account");
        employeeButton.setBorder(null);
        employeeButton.setBorderPainted(false);
        employeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeButtonActionPerformed(evt);
            }
        });

        adminHead.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        adminHead.setForeground(new java.awt.Color(255, 255, 255));
        adminHead.setText("ADMIN MAIN MENU");

        deductionButton.setBackground(new java.awt.Color(51, 153, 153));
        deductionButton.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        deductionButton.setForeground(new java.awt.Color(255, 255, 255));
        deductionButton.setText("Deductions");
        deductionButton.setBorder(null);
        deductionButton.setBorderPainted(false);
        deductionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deductionButtonActionPerformed(evt);
            }
        });

        positionButton.setBackground(new java.awt.Color(51, 153, 153));
        positionButton.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        positionButton.setForeground(new java.awt.Color(255, 255, 255));
        positionButton.setText("Positions");
        positionButton.setBorder(null);
        positionButton.setBorderPainted(false);
        positionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positionButtonActionPerformed(evt);
            }
        });

        reportsButton.setBackground(new java.awt.Color(51, 153, 153));
        reportsButton.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        reportsButton.setForeground(new java.awt.Color(255, 255, 255));
        reportsButton.setText("Reports");
        reportsButton.setBorder(null);
        reportsButton.setBorderPainted(false);
        reportsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportsButtonActionPerformed(evt);
            }
        });

        logoutButton.setBackground(new java.awt.Color(51, 153, 153));
        logoutButton.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        logoutButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutButton.setText("Log out");
        logoutButton.setBorder(null);
        logoutButton.setBorderPainted(false);
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Desktop\\PAYROLL FINAL FOLDER\\payroll\\src\\images\\icons8-admin-100.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(226, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addComponent(adminHead, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(employeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(130, 130, 130)
                                .addComponent(positionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(deductionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(130, 130, 130)
                                .addComponent(reportsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(224, 224, 224))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(448, 448, 448))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(adminHead, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(employeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(positionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deductionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reportsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    // <editor-fold defaultstate="collapsed" desc="ActionPerformed">                                               
    private void employeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeButtonActionPerformed

    private void deductionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deductionButtonActionPerformed
        // TODO add your handling cwode here:
    }//GEN-LAST:event_deductionButtonActionPerformed

    private void positionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positionButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_positionButtonActionPerformed

    private void reportsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportsButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reportsButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
    }                                            
    // </editor-fold>//GEN-LAST:event_logoutButtonActionPerformed


    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() == employeeButton) {
            EmployeeAcc employee = new EmployeeAcc();
            employee.EmployeeAcc();
            employee.setVisible(true);
            setVisible(false);
            dispose();
        } else if (e.getSource() == positionButton) {
            Positions job = new Positions();
            job.Positions();
            job.setVisible(true);
            setVisible(false);
            dispose();
        } else if (e.getSource() == deductionButton) {
            Deductions deduct = new Deductions();
            deduct.Deductions();
            deduct.setVisible(true);
            setVisible(false);
            dispose();
        } else if (e.getSource() == reportsButton) {
            ReportsMenu deduct = new ReportsMenu();
            deduct.ReportsMenu();
            deduct.setVisible(true);
            setVisible(false);
            dispose();
        } else if (e.getSource() == logoutButton) {
            LogInPayroll login = new LogInPayroll();
            login.LogInPayroll();
            login.setVisible(true);
            setVisible(false);
            dispose();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adminHead;
    private javax.swing.JButton deductionButton;
    private javax.swing.JButton employeeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton positionButton;
    private javax.swing.JButton reportsButton;
    // End of variables declaration//GEN-END:variables
}
