
package payroll;

import java.sql.*;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import tableposition.TableActionCellEditor;
import tableposition.TableActionCellRender;
import tableposition.TableActionEvent;
import javax.swing.table.DefaultTableModel;


public class Positions extends javax.swing.JFrame implements ActionListener {

    private PositionsLinked position = new PositionsLinked();
    private PositionsDataRetrieve poddb = new PositionsDataRetrieve();
    private int selectedRow = -1;
    public void Positions() {

        initComponents();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        databaseRetrieval();
        returnButton.addActionListener(this);
        addPositionButton.addActionListener(this);
        clearButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
        searchButton.addActionListener(this);
        sortButton.addActionListener(this);
        cellButton();

    }
        
    public void cellButton(){
        TableActionEvent event = new TableActionEvent(){
            @Override
            public void onEdit(int r){
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

                selectedRow = r;

                posnameTF.setText(model.getValueAt(r, 0).toString());
                posdepartTF.setText(model.getValueAt(r, 1).toString());


                double salary = Double.parseDouble(model.getValueAt(r, 2).toString());
                salarySpinner.setValue(salary);


                String employmentType = model.getValueAt(r, 3).toString();
                if ("Regular".equals(employmentType)) {
                    regularRB.setSelected(true);
                } else if ("Contractual".equals(employmentType)) {
                    contractualRB.setSelected(true);
                }

                String status = model.getValueAt(r, 4).toString();
                if ("Active".equals(status)) {
                    activeRB.setSelected(true);
                } else if ("Deactivated".equals(status)) {
                    deactiveRB.setSelected(true);
                }
            }
             @Override
            public void onDelete(int r){
                
            }
             @Override
            public void onView(int r){
              
            }
        };
        jTable1.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender());
        jTable1.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(event));
    }
    
    public void databaseRetrieval() {
        try (Connection connection = DatabaseConnector.connect()) {
            poddb.fetchDataIntoLinkedList(connection, position, (DefaultTableModel) jTable1.getModel());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code. Do not modify">  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        returnButton2 = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        searchTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        returnButton = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        posnameTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        posdepartTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        regularRB = new javax.swing.JRadioButton();
        contractualRB = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        activeRB = new javax.swing.JRadioButton();
        deactiveRB = new javax.swing.JRadioButton();
        addPositionButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        salarySpinner = new javax.swing.JSpinner();
        sortButton = new javax.swing.JButton();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 650));
        setMinimumSize(new java.awt.Dimension(1000, 650));
        setPreferredSize(new java.awt.Dimension(963, 588));
        setResizable(false);

        searchTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(44, 132, 142)));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel2.setText("Position Name:");

        searchButton.setBackground(new java.awt.Color(44, 132, 142));
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Desktop\\PAYROLL FINAL FOLDER\\payroll\\src\\images\\search.png")); // NOI18N
        searchButton.setText("Search");
        searchButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(44, 132, 142)));
        searchButton.setMargin(new java.awt.Insets(3, 14, 3, 14));

        jTable1.setBackground(new java.awt.Color(39, 100, 128));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Position", "Department", "Salary", "Type ", "Status", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(50);
        jTable1.setSelectionBackground(new java.awt.Color(44, 132, 142));
        jScrollPane1.setViewportView(jTable1);

        returnButton.setBackground(new java.awt.Color(44, 132, 142));
        returnButton.setForeground(new java.awt.Color(255, 255, 255));
        returnButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Desktop\\PAYROLL FINAL FOLDER\\payroll\\src\\images\\return.png")); // NOI18N
        returnButton.setText("Return");
        returnButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(44, 132, 142)));
        returnButton.setMargin(new java.awt.Insets(3, 14, 3, 14));
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ascending Order" }));

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel8.setText("Sort by:");

        jPanel1.setBackground(new java.awt.Color(39, 100, 128));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("POSITION DETAILS");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Position Name:");

        posnameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posnameTFActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Department:");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Type of Employment:");

        regularRB.setBackground(new java.awt.Color(39, 100, 128));
        buttonGroup1.add(regularRB);
        regularRB.setForeground(new java.awt.Color(255, 255, 255));
        regularRB.setText("Regular");
        regularRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regularRBActionPerformed(evt);
            }
        });

        contractualRB.setBackground(new java.awt.Color(39, 100, 128));
        buttonGroup1.add(contractualRB);
        contractualRB.setForeground(new java.awt.Color(255, 255, 255));
        contractualRB.setText("Contractual");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Salary Per Month: ");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Status:");

        activeRB.setBackground(new java.awt.Color(39, 100, 128));
        buttonGroup2.add(activeRB);
        activeRB.setForeground(new java.awt.Color(255, 255, 255));
        activeRB.setText("Active");

        deactiveRB.setBackground(new java.awt.Color(39, 100, 128));
        buttonGroup2.add(deactiveRB);
        deactiveRB.setForeground(new java.awt.Color(255, 255, 255));
        deactiveRB.setText("Deactivate");

        addPositionButton.setBackground(new java.awt.Color(44, 132, 142));
        addPositionButton.setForeground(new java.awt.Color(255, 255, 255));
        addPositionButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Desktop\\PAYROLL FINAL FOLDER\\payroll\\src\\images\\add.png")); // NOI18N
        addPositionButton.setText("Add");
        addPositionButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(44, 132, 142)));
        addPositionButton.setMargin(new java.awt.Insets(5, 14, 5, 14));
        addPositionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPositionButtonActionPerformed(evt);
            }
        });

        updateButton.setBackground(new java.awt.Color(44, 132, 142));
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-check-18.png"))); // NOI18N
        updateButton.setText("Update");
        updateButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(44, 132, 142)));
        updateButton.setMargin(new java.awt.Insets(3, 14, 3, 14));
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        clearButton.setBackground(new java.awt.Color(44, 132, 142));
        clearButton.setForeground(new java.awt.Color(255, 255, 255));
        clearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-clear-18.png"))); // NOI18N
        clearButton.setText("Clear");
        clearButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(44, 132, 142)));
        clearButton.setMargin(new java.awt.Insets(3, 14, 3, 14));
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(44, 132, 142));
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete1.png"))); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(44, 132, 142)));
        deleteButton.setMargin(new java.awt.Insets(3, 14, 3, 14));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(posdepartTF, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addComponent(posnameTF, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(regularRB)
                                        .addGap(66, 66, 66)
                                        .addComponent(contractualRB))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(activeRB)
                                        .addGap(66, 66, 66)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(deactiveRB)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(updateButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addPositionButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(salarySpinner)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel1)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(posnameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(posdepartTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regularRB)
                    .addComponent(contractualRB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(salarySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(activeRB)
                    .addComponent(deactiveRB))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addPositionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        sortButton.setBackground(new java.awt.Color(44, 132, 142));
        sortButton.setForeground(new java.awt.Color(255, 255, 255));
        sortButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-check-18.png"))); // NOI18N
        sortButton.setText("Ok");
        sortButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(44, 132, 142)));
        sortButton.setMargin(new java.awt.Insets(3, 14, 3, 14));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(searchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel2))
                            .addGap(142, 142, 142)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(sortButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel8)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sortButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(searchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
       
    }//GEN-LAST:event_returnButtonActionPerformed

    private void returnButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButton2ActionPerformed
        
    }//GEN-LAST:event_returnButton2ActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
       
    }//GEN-LAST:event_clearButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        
    }//GEN-LAST:event_updateButtonActionPerformed

    private void posnameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posnameTFActionPerformed
        
    }//GEN-LAST:event_posnameTFActionPerformed

    private void addPositionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPositionButtonActionPerformed
        
    }//GEN-LAST:event_addPositionButtonActionPerformed

    private void regularRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regularRBActionPerformed
        
    }//GEN-LAST:event_regularRBActionPerformed
    // </editor-fold>  

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {

        String posname = posnameTF.getText();
	    String posdepart = posdepartTF.getText();
            
            //double salary;
            //String salaryString = salarySpinner.getValue().toString();
            //try {
              //  salary = Double.parseDouble(salaryString);
               
            //} catch (NumberFormatException ex) {
              //  JOptionPane.showMessageDialog(this, "Invalid salary format:" + salaryString, "Error", JOptionPane.ERROR_MESSAGE);
            //}
            
        if (e.getSource() == returnButton) {
            
            AdminMenu admin = new AdminMenu();
            admin.AdminMenu();
            admin.setVisible(true);
            setVisible(false);
            dispose();
            
        }
        
        else if(e.getSource() == addPositionButton){

            if ( posname.isEmpty() || posdepart.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields", "MESSAGE",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            posname = posnameTF.getText();
            posdepart = posdepartTF.getText();
            
            
            String typeofEmployment = "";
            if (regularRB.isSelected()) {
                typeofEmployment = "Regular";
            } else if (contractualRB.isSelected()) {
                typeofEmployment = "Contractual";
            } else {
                JOptionPane.showMessageDialog(this, "Please select a type of employment", "MESSAGE",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            double salary = 0.0;
            String salaryString = salarySpinner.getValue().toString();
            try {
                salary = Double.parseDouble(salaryString);
               
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid salary format:" + salaryString, "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            String posstatus = "";
            if (activeRB.isSelected()) {
                posstatus = "Active";
            } else if (deactiveRB.isSelected()) {
                posstatus = "Deactivated";
            } else {
                JOptionPane.showMessageDialog(this, "Please select a status", "MESSAGE",JOptionPane.INFORMATION_MESSAGE);
                return;
            }


            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            position.addNode(posname, posdepart, salary, typeofEmployment, posstatus, model);

            clearInputFields();

	 
        }

        else if(e.getSource() == updateButton){

            if ( posname.isEmpty() || posdepart.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields", "MESSAGE",JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            String oldPosname = jTable1.getValueAt(selectedRow, 0).toString();
            String oldPosname1 = searchTF.getText();

            posname = posnameTF.getText();
            posdepart = posdepartTF.getText();


            String typeofEmployment = "";
            if (regularRB.isSelected()) {
                typeofEmployment = "Regular";
            } else if (contractualRB.isSelected()) {
                typeofEmployment = "Contractual";
            } else {
                JOptionPane.showMessageDialog(this, "Please select a type of employment", "MESSAGE",JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            double salary = 0.0;
            String salaryString = salarySpinner.getValue().toString();
            try {
                salary = Double.parseDouble(salaryString);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid salary format:" + salaryString, "Error", JOptionPane.ERROR_MESSAGE);
            }

            String posstatus = "";
            if (activeRB.isSelected()) {
                posstatus = "Active";
            } else if (deactiveRB.isSelected()) {
                posstatus = "Deactivated";
            } else {
                JOptionPane.showMessageDialog(this, "Please select a status", "MESSAGE",JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            if (oldPosname1 == null || oldPosname1.isEmpty()) {
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                position.updateNode(oldPosname, posname, posdepart, salary, typeofEmployment, posstatus);
                position.updateTable(model);
                clearInputFields();
            }else{
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                position.updateNode(oldPosname1, posname, posdepart, salary, typeofEmployment, posstatus);
                position.updateTable(model);
                clearInputFields();
                searchTF.setText("");
            }


        }
        else if(e.getSource() == deleteButton){
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            String oldPosname = null;
            String oldPosname1 = searchTF.getText();

            if (selectedRow != -1 && selectedRow < jTable1.getRowCount()) {
                oldPosname = jTable1.getValueAt(selectedRow, 0).toString();
            }

            int result = JOptionPane.showConfirmDialog(null, "Do you really want to delete?",
                    "Confirmation ", JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.YES_OPTION) {
                if (oldPosname1 == null || oldPosname1.isEmpty()) {
                    if (oldPosname != null) {
                        position.deleteNode(oldPosname);
                        position.updateTable(model);
                        clearInputFields();
                    } else {
                        JOptionPane.showMessageDialog(this, "Please select a row to delete or perform a search", "MESSAGE",JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    position.deleteNode(oldPosname1);
                    position.updateTable(model);
                    clearInputFields();
                    searchTF.setText("");
                }
            } else if(result == JOptionPane.NO_OPTION){
                clearInputFields();
            }
        }

        else if(e.getSource() == searchButton){

            String searchPosname = searchTF.getText();
            Node selectedNode = position.searchNode(searchPosname);

            if (selectedNode != null) {

                posnameTF.setText(selectedNode.getPosName());
                posdepartTF.setText(selectedNode.getPosDepartment());

                if ("Regular".equals(selectedNode.getPosType())) {
                    regularRB.setSelected(true);
                } else if ("Contractual".equals(selectedNode.getPosType())) {
                    contractualRB.setSelected(true);
                }

                salarySpinner.setValue(selectedNode.getPosSalary());

                if ("Active".equals(selectedNode.getPosStatus())) {
                    activeRB.setSelected(true);
                } else if ("Deactivated".equals(selectedNode.getPosStatus())) {
                    deactiveRB.setSelected(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Position not found. Please Try Again.", "Error", JOptionPane.ERROR_MESSAGE);
                searchTF.setText("");
            }

        }

        else if(e.getSource() == clearButton){
            clearInputFields();
        }
        else if(e.getSource() == sortButton){
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            position.displaySortedValues(model);
        }
    }


    private void clearInputFields() {
        posnameTF.setText("");
        posdepartTF.setText("");
        buttonGroup1.clearSelection();
        salarySpinner.setValue(0.0);
        buttonGroup2.clearSelection();


    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton activeRB;
    private javax.swing.JButton addPositionButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton clearButton;
    private javax.swing.JRadioButton contractualRB;
    private javax.swing.JRadioButton deactiveRB;
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField posdepartTF;
    private javax.swing.JTextField posnameTF;
    private javax.swing.JRadioButton regularRB;
    private javax.swing.JButton returnButton;
    private javax.swing.JButton returnButton2;
    private javax.swing.JSpinner salarySpinner;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTF;
    private javax.swing.JButton sortButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
