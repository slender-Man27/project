
package payroll;


import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EmployeeEdit extends javax.swing.JFrame implements ActionListener {

    EmployeeLinked employeeLinked = new EmployeeLinked();
    private ImageIcon format  = null;
    private int emp_id;
    File f = null;
    String path = null;
    private ImageIcon Format  = null;
    public void EditAcc(int Id) {
        this.emp_id = Id;
        initComponents();
        returnButton1.addActionListener(this);
        returnButton.addActionListener(this);
        returnButton2.addActionListener(this);
        jButton1.addActionListener(this);
        positionDataComboBox();
        try{
            fetchDataFromDatabase(Id);
        }catch (SQLException e){
            e.printStackTrace();
        }
        ViewImage(Id);
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
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        firstNameTF = new javax.swing.JTextField();
        lastNameTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        femaleRB = new javax.swing.JRadioButton();
        birthTF = new javax.swing.JTextField();
        maleRB = new javax.swing.JRadioButton();
        picLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        positionsCombox = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        dateHiredTF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        activeRB = new javax.swing.JRadioButton();
        deactivateRB = new javax.swing.JRadioButton();
        returnButton = new javax.swing.JButton();
        returnButton2 = new javax.swing.JButton();
        returnButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 650));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("Update Employee's Account");

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
                .addContainerGap(314, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                .addContainerGap(315, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel3.setText("First Name:");

        firstNameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameTFActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel4.setText("Last Name:");

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel6.setText("Date of Birth:");

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel5.setText("Sex:");

        buttonGroup1.add(femaleRB);
        femaleRB.setText("Female");
        femaleRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleRBActionPerformed(evt);
            }
        });

        birthTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                birthTFActionPerformed(evt);
            }
        });

        buttonGroup1.add(maleRB);
        maleRB.setText("Male");

        picLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 97, 126)));

        jButton1.setBackground(new java.awt.Color(44, 132, 142));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add Profile");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
                .addContainerGap(302, Short.MAX_VALUE))
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

        positionsCombox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        positionsCombox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positionsComboxActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel9.setText("Date Hired:");

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel8.setText("Status:");

        buttonGroup2.add(activeRB);
        activeRB.setText("Active");

        buttonGroup2.add(deactivateRB);
        deactivateRB.setText("Deactivate");

        returnButton.setBackground(new java.awt.Color(44, 132, 142));
        returnButton.setForeground(new java.awt.Color(255, 255, 255));
        returnButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        returnButton.setText("Update");
        returnButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(44, 132, 142)));
        returnButton.setMargin(new java.awt.Insets(3, 14, 3, 14));
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(480, 480, 480)))
                        .addGap(107, 107, 107))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
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
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(dateHiredTF)
                                    .addComponent(positionsCombox, 0, 313, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(returnButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(returnButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(50, 50, 50)
                                .addComponent(activeRB)
                                .addGap(69, 69, 69)
                                .addComponent(deactivateRB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(returnButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
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
                                    .addComponent(maleRB)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(picLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(positionsCombox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(dateHiredTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(returnButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(activeRB)
                            .addComponent(deactivateRB))
                        .addContainerGap(36, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(returnButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void firstNameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameTFActionPerformed

    private void femaleRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleRBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_femaleRBActionPerformed

    private void birthTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_birthTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_birthTFActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void positionsComboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positionsComboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_positionsComboxActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_returnButtonActionPerformed

    private void returnButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_returnButton2ActionPerformed

    private void returnButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_returnButton1ActionPerformed


    public void actionPerformed(java.awt.event.ActionEvent e) {

        String surname = lastNameTF.getText();
        String firstname = firstNameTF.getText();
        String birth;
        String hired;
        if (e.getSource() == returnButton1) {
            EmployeeAcc employee = new EmployeeAcc();
            employee.EmployeeAcc();
            employee.setVisible(true);
            setVisible(false);
            dispose();
        } else if (e.getSource() == jButton1) {
            //add pic
            JFileChooser file = new JFileChooser();
            file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            File folder = new File("C:\\Users\\Tristan\\Downloads");
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
        else if(e.getSource() == returnButton){
            //update
            if(surname.isEmpty() || firstname.isEmpty()){
                JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            surname = lastNameTF.getText();
            firstname = firstNameTF.getText();

            String gen = null;
            if(femaleRB.isSelected()){
                gen = "Female";
            }
            else if(maleRB.isSelected()){
                gen = "Male";
            }
            else {
                JOptionPane.showMessageDialog(this, "Please select a gender identity ", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String post = positionsCombox.getSelectedItem().toString();
            String empStatus = null;

            if(activeRB.isSelected()){
                empStatus = "Active";
            }else if(deactivateRB.isSelected()){
                empStatus = "Deactivated";
            }else {
                JOptionPane.showMessageDialog(this, "Please select a status", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            java.sql.Date bDate ;
            java.sql.Date hDate ;
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
                }else {
                    JOptionPane.showMessageDialog(this, "Error parsing date: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                return;
            }

            if(path == null){
                employeeLinked.updateNode(emp_id,surname,firstname,bDate,gen,post,hDate,empStatus);
            }
            else {
                employeeLinked.updateNodePicture(emp_id, surname, firstname, bDate, gen, post, hDate, empStatus,path);
            }
            clearInputFields();
            picLabel.setIcon(null);
        }
        else if(e.getSource().equals(returnButton2)){
            clearInputFields();
        }
    }

    private void fetchDataFromDatabase(int id) throws SQLException {

        try (Connection connection = DatabaseConnector.connect()) {
            Statement statement = connection.createStatement();
            String sql = "SELECT lastname_employee, firstname_employee, date_of_birth, sex, positions.position_name, date_hired, status FROM employee " +
                    "LEFT JOIN positions " +
                    "ON employee.position_name = positions.position_name " +
                    "WHERE id = ?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                ResultSet resultSet = ps.executeQuery();

                if (resultSet.next()) {
                    String lN = resultSet.getString("lastname_employee");
                    String fN = resultSet.getString("firstname_employee");
                    java.sql.Date birth = resultSet.getDate("date_of_birth");
                    String sex = resultSet.getString("sex");
                    String pos = resultSet.getString("position_name");
                    java.sql.Date hired = resultSet.getDate("date_hired");
                    String stat = resultSet.getString("status");


                    lastNameTF.setText(lN);
                    firstNameTF.setText(fN);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
                    birthTF.setText(dateFormat.format(birth));

                    if ("Male".equals(sex)) {
                        maleRB.setSelected(true);
                        femaleRB.setSelected(false);
                    } else if ("Female".equals(sex)) {
                        femaleRB.setSelected(true);
                        maleRB.setSelected(false);
                    }
                    positionsCombox.setSelectedItem(pos);
                    dateHiredTF.setText(dateFormat.format(hired));

                    if("Active".equals(stat)){
                        activeRB.setSelected(true);
                        deactivateRB.setSelected(false);
                    }
                    else if("Deactivated".equals(stat)){
                        deactivateRB.setSelected(true);
                        activeRB.setSelected(false);
                    }
                }
                resultSet.close();
                statement.close();

            }
        }
    }

    public void ViewImage(int id){
        try(Connection connection = DatabaseConnector.connect()){
            String sql = "SELECT emp_prof FROM employee WHERE id = ?";

            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setInt(1,id);
                ResultSet set = ps.executeQuery();

                if (set.next()) {
                    byte[] img = set.getBytes("emp_prof");
                    format = new ImageIcon(img);
                    Image im = format.getImage();
                    Image im2 = im.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                    ImageIcon imageIcon = new ImageIcon(im2);

                    picLabel.setIcon(imageIcon);
                }
            }



        }catch (SQLException e){
            e.printStackTrace();
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
