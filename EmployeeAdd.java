package payroll;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

public class EmployeeAdd extends javax.swing.JFrame implements ActionListener{

    EmployeeLinked employeeLinked = new EmployeeLinked();

    File f = null;
    String path = null;

    public void AddEmployee() {
        initComponents();
        returnButton.addActionListener(this);
        returnButton1.addActionListener(this);
        returnButton2.addActionListener(this);
        jButton1.addActionListener(this);
        positionDataComboBox();
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        firstNameTF = new javax.swing.JTextField();
        lastNameTF = new javax.swing.JTextField();
        birthTF = new javax.swing.JTextField("MM-DD-YYYY");
        birthTF.setFont(new Font("Roboto", Font.ITALIC, 12));
        birthTF.setForeground(Color.GRAY);
        birthTF.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(birthTF.getText().equals("MM-DD-YYYY")){
                    birthTF.setText("");
                    birthTF.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(birthTF.getText().isEmpty()){
                    birthTF.setText("MM-DD-YYYY");
                    birthTF.setForeground(Color.GRAY);
                }
            }});
        femaleRB = new javax.swing.JRadioButton();
        maleRB = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        positionsCombox = new javax.swing.JComboBox<>();
        activeRB = new javax.swing.JRadioButton();
        deactivateRB = new javax.swing.JRadioButton();
        dateHiredTF = new javax.swing.JTextField("MM-DD-YYYY");
        dateHiredTF.setFont(new Font("Roboto", Font.ITALIC, 12));
        dateHiredTF.setForeground(Color.GRAY);
        dateHiredTF.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(dateHiredTF.getText().equals("MM-DD-YYYY")){
                    dateHiredTF.setText("");
                    dateHiredTF.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(dateHiredTF.getText().isEmpty()){
                    dateHiredTF.setText("MM-DD-YYYY");
                    dateHiredTF.setForeground(Color.GRAY);
                }
            }});
        picLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();

        returnButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        returnButton1 = new javax.swing.JButton();
        returnButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 650));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("Create Employee's Account");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Employee's Details");

        jPanel2.setBackground(new java.awt.Color(38, 97, 126));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 97, 126)));

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Basic Background Information");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel3.setText("First Name:");

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel4.setText("Last Name:");

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel6.setText("Date of Birth:");

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel5.setText("Sex:");

        firstNameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameTFActionPerformed(evt);
            }
        });

        birthTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                birthTFActionPerformed(evt);
            }
        });

        buttonGroup1.add(femaleRB);
        femaleRB.setText("Female");
        femaleRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleRBActionPerformed(evt);
            }
        });

        buttonGroup1.add(maleRB);
        maleRB.setText("Male");

        jPanel3.setBackground(new java.awt.Color(38, 97, 126));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 97, 126)));

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Employee Company Information");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(288, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel7.setText("Position:");

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel8.setText("Status:");

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel9.setText("Date Hired:");

        positionsCombox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Position 1", "Position 2", "Position 3", "Position 4" }));
        positionsCombox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positionsComboxActionPerformed(evt);
            }
        });

        buttonGroup2.add(activeRB);
        activeRB.setText("Active");

        buttonGroup2.add(deactivateRB);
        deactivateRB.setText("Deactivate");

        picLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 97, 126)));

        jPanel4.setBackground(new java.awt.Color(38, 97, 126));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 97, 126)));

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Employee's Profile");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        returnButton.setBackground(new java.awt.Color(44, 132, 142));
        returnButton.setForeground(new java.awt.Color(255, 255, 255));
        returnButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        returnButton.setText("Add Record");
        returnButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(44, 132, 142)));
        returnButton.setMargin(new java.awt.Insets(3, 14, 3, 14));
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(44, 132, 142));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add Profile");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        returnButton1.setBackground(new java.awt.Color(44, 132, 142));
        returnButton1.setForeground(new java.awt.Color(255, 255, 255));
        returnButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Desktop\\PAYROLL FINAL FOLDER\\payroll\\src\\images\\return.png")); // NOI18N
        returnButton1.setText("Return");
        returnButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(44, 132, 142)));
        returnButton1.setMargin(new java.awt.Insets(3, 14, 3, 14));
        returnButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButton1ActionPerformed(evt);
            }
        });

        returnButton2.setBackground(new java.awt.Color(44, 132, 142));
        returnButton2.setForeground(new java.awt.Color(255, 255, 255));
        returnButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-clear-18.png"))); // NOI18N
        returnButton2.setText("Clear");
        returnButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(44, 132, 142)));
        returnButton2.setMargin(new java.awt.Insets(3, 14, 3, 14));
        returnButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8))
                                        .addGap(64, 64, 64)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(activeRB)
                                                .addGap(85, 85, 85)
                                                .addComponent(deactivateRB)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(positionsCombox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(50, 50, 50)
                                        .addComponent(dateHiredTF, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 374, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(returnButton, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                    .addComponent(returnButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lastNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(birthTF, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(firstNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(femaleRB)
                                        .addGap(83, 83, 83)
                                        .addComponent(maleRB)))))
                        .addGap(196, 196, 196)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(picLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(830, Short.MAX_VALUE)
                    .addComponent(returnButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(27, 27, 27)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(firstNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lastNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(birthTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(femaleRB)
                            .addComponent(maleRB))
                        .addGap(67, 67, 67)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(positionsCombox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(dateHiredTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(activeRB)
                            .addComponent(deactivateRB)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(picLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(109, 109, 109)
                        .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(returnButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 59, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(545, Short.MAX_VALUE)
                    .addComponent(returnButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(15, 15, 15)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void firstNameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameTFActionPerformed

    private void positionsComboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positionsComboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_positionsComboxActionPerformed

    private void femaleRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleRBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_femaleRBActionPerformed

    private void birthTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_birthTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_birthTFActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_returnButtonActionPerformed

    private void returnButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_returnButton1ActionPerformed

    private void returnButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_returnButton2ActionPerformed
    // </editor-fold>


    public void actionPerformed(java.awt.event.ActionEvent e) {

        String sur = lastNameTF.getText();
        String first = firstNameTF.getText();
        String birth = birthTF.getText();
        String hired = dateHiredTF.getText();


        if (e.getSource() == returnButton1) {
            EmployeeAcc employee = new EmployeeAcc();
            employee.EmployeeAcc();
            employee.setVisible(true);
            setVisible(false);
            dispose();
        }
        else if(e.getSource().equals(jButton1)){
            //add pic
            JFileChooser file = new JFileChooser();
            file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            File folder = new File("C:\\Users\\User\\Desktop\\PAYROLL FINAL FOLDER\\payroll\\src\\Employee Images");
            file.setCurrentDirectory(folder);
            FileNameExtensionFilter fn = new FileNameExtensionFilter("PNG JPG AND JPEG","png","jpeg","jpg");
            file.addChoosableFileFilter(fn);
            int load = file.showOpenDialog(null);
            if(load == file.APPROVE_OPTION){
                f = file.getSelectedFile();
                path = f.getAbsolutePath();
                ImageIcon img = new ImageIcon(path);
                Image resize = img.getImage().getScaledInstance(200,190, Image.SCALE_SMOOTH);
                ImageIcon small = new ImageIcon(resize);
                picLabel.setIcon(small);

            }
        }
        else if(e.getSource().equals(returnButton)){
            //add record
            if(sur.isEmpty()||first.isEmpty()||birth.isEmpty()||hired.isEmpty()){
                JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            }

            sur = lastNameTF.getText();
            first = firstNameTF.getText();

            String gen = null;
            if(femaleRB.isSelected()){
                gen = "Female";
            }
            else if(maleRB.isSelected()){
                gen ="Male";
            }
            else {
                JOptionPane.showMessageDialog(this, "Please select a gender identity ", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String post = positionsCombox.getSelectedItem().toString();

            String empStatus = "";

            if(activeRB.isSelected()){
                empStatus = "Active";
            }else if(deactivateRB.isSelected()){
                empStatus = "Deactivated";
            }else {
                JOptionPane.showMessageDialog(this, "Please select a status", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            java.sql.Date bDate = null;
            java.sql.Date hDate = null;
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
                birth = birthTF.getText();
                java.util.Date parsedDate = dateFormat.parse(birth);
                bDate = new java.sql.Date(parsedDate.getTime());

                hired = dateHiredTF.getText();
                java.util.Date parsedDate2 = dateFormat.parse(hired);
                hDate = new java.sql.Date(parsedDate2.getTime());

            }catch (ParseException ex){
                ex.printStackTrace();
                if(ex.getMessage().contains("Unparseable date:")){
                    JOptionPane.showMessageDialog(this, "Invalid date format. Please use the format MM-DD-YYYY", "Error", JOptionPane.ERROR_MESSAGE);
                    birthTF.setText("MM-DD-YYYY");
                    birthTF.setForeground(Color.GRAY);
                    dateHiredTF.setText("MM-DD-YYYY");
                    dateHiredTF.setForeground(Color.GRAY);
                }else {
                    JOptionPane.showMessageDialog(this, "Error parsing date: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                return;
            }
            if(path == null){
                JOptionPane.showMessageDialog(this, "Please add Profile photo", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            employeeLinked.addNode(sur,first,bDate,gen,post,hDate,empStatus,path);
            //fetchAddDataRetrieve(connection, EmployeeLinked, int empID,getEmpPos());
            JOptionPane.showMessageDialog(this, "Added Successfully", "Done", JOptionPane.INFORMATION_MESSAGE);
            clearInputFields();
            picLabel.setIcon(null);


        }
        else if(e.getSource().equals(returnButton2)){
            //clear
            clearInputFields();
        }
    }
    /**
     * ///////////////////////////////////////////////////////////////////////////////////////////////////////////
     */

    public void feel(){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployeeAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public void positionDataComboBox(){
        try(Connection connection = DatabaseConnector.connect()){
            String sql = "SELECT position_name FROM positions WHERE position_status = 'Active' ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            while (rs.next()){
                model.addElement(rs.getString("position_name"));
            }
            positionsCombox.setModel(model);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    private void clearInputFields() {
        lastNameTF.setText("");
        firstNameTF.setText("");
        birthTF.setText("MM-DD-YYYY");
        birthTF.setForeground(Color.GRAY);
        maleRB.setSelected(false);
        femaleRB.setSelected(false);
        dateHiredTF.setText("MM-DD-YYYY");
        dateHiredTF.setForeground(Color.GRAY);
        activeRB.setSelected(false);
        deactivateRB.setSelected(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton activeRB;
    private javax.swing.JTextField birthTF;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField dateHiredTF;
    private javax.swing.JRadioButton deactivateRB;
    private javax.swing.JRadioButton femaleRB;
    private javax.swing.JTextField firstNameTF;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField lastNameTF;
    private javax.swing.JRadioButton maleRB;
    private javax.swing.JLabel picLabel;
    private javax.swing.JComboBox<String> positionsCombox;
    private javax.swing.JButton returnButton;
    private javax.swing.JButton returnButton1;
    private javax.swing.JButton returnButton2;
    // End of variables declaration//GEN-END:variables




}
