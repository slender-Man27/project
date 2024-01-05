
package payroll;

import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import tableposition.TableActionCellEditor;
import tableposition.TableActionCellRender;
import tableposition.TableActionEvent;

public class Deductions extends javax.swing.JFrame implements ActionListener {
    
    private DeductionsLinked deduction = new DeductionsLinked();
    private DeductionsDataRetrieve deducdb = new DeductionsDataRetrieve();
    private int selectedRow = -1;
    
    public void Deductions() {
        initComponents();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        databaseRetrieval();
        returnButton.addActionListener(this);
        addDeductionsButton.addActionListener(this);
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

                descriptionTF.setText(model.getValueAt(r, 0).toString());
              

                double salary = Double.parseDouble(model.getValueAt(r, 1).toString());
                rateSpinner.setValue(salary);

                String status = model.getValueAt(r, 2).toString();
                if ("Active".equals(status)) {
                    activeRadio.setSelected(true);
                } else if ("Deactivated".equals(status)) {
                    deactivateRadio.setSelected(true);
                }
            }
             @Override
            public void onDelete(int r){
               
            }
             @Override
            public void onView(int r){
              
            }
        };
        jTable1.getColumnModel().getColumn(3).setCellRenderer(new TableActionCellRender());
        jTable1.getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditor(event));
    }
    
        public void databaseRetrieval() {
        try (Connection connection = DatabaseConnector.connect()) {
            deducdb.fetchDataIntoDeductionLinkedList(connection, deduction, (DefaultTableModel) jTable1.getModel());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        
// <editor-fold defaultstate="collapsed" desc="Generated Code. Do not modify">  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        searchTF = new javax.swing.JTextField();
        deducsearchLabel = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        returnButton = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        filterLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        descripLabel = new javax.swing.JLabel();
        descriptionTF = new javax.swing.JTextField();
        rateLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        activeRadio = new javax.swing.JRadioButton();
        deactivateRadio = new javax.swing.JRadioButton();
        addDeductionsButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        rateSpinner = new javax.swing.JSpinner();
        sortButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 650));
        setMinimumSize(new java.awt.Dimension(1000, 650));
        setPreferredSize(new java.awt.Dimension(1042, 532));
        setResizable(false);

        searchTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(44, 132, 142)));

        deducsearchLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        deducsearchLabel.setText("Deduction Description:");

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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Description", "Rate", "Status", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ascending Order", " " }));
        jComboBox1.setToolTipText("");

        filterLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        filterLabel.setText("Sort  by:");

        jPanel1.setBackground(new java.awt.Color(39, 100, 128));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DEDUCTIONS DETAILS");

        descripLabel.setForeground(new java.awt.Color(255, 255, 255));
        descripLabel.setText("Description");

        descriptionTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriptionTFActionPerformed(evt);
            }
        });

        rateLabel.setForeground(new java.awt.Color(255, 255, 255));
        rateLabel.setText("Rate % :");

        statusLabel.setForeground(new java.awt.Color(255, 255, 255));
        statusLabel.setText("Status:");

        activeRadio.setBackground(new java.awt.Color(39, 100, 128));
        buttonGroup1.add(activeRadio);
        activeRadio.setForeground(new java.awt.Color(255, 255, 255));
        activeRadio.setText("Active");
        activeRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activeRadioActionPerformed(evt);
            }
        });

        deactivateRadio.setBackground(new java.awt.Color(39, 100, 128));
        buttonGroup1.add(deactivateRadio);
        deactivateRadio.setForeground(new java.awt.Color(255, 255, 255));
        deactivateRadio.setText("Deactivate");

        addDeductionsButton.setBackground(new java.awt.Color(44, 132, 142));
        addDeductionsButton.setForeground(new java.awt.Color(255, 255, 255));
        addDeductionsButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Desktop\\PAYROLL FINAL FOLDER\\payroll\\src\\images\\add.png")); // NOI18N
        addDeductionsButton.setText("Add");
        addDeductionsButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(44, 132, 142)));
        addDeductionsButton.setMargin(new java.awt.Insets(5, 14, 5, 14));
        addDeductionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDeductionsButtonActionPerformed(evt);
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
                            .addComponent(descriptionTF, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                            .addComponent(descripLabel)
                            .addComponent(rateLabel)
                            .addComponent(statusLabel)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(122, 122, 122)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(updateButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addDeductionsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(activeRadio)
                                        .addGap(66, 66, 66)
                                        .addComponent(deactivateRadio))))
                            .addComponent(rateSpinner)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel1)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addComponent(descripLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(descriptionTF, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(rateLabel)
                .addGap(18, 18, 18)
                .addComponent(rateSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(statusLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(activeRadio)
                    .addComponent(deactivateRadio))
                .addGap(83, 83, 83)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addDeductionsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deducsearchLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(searchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(162, 162, 162)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sortButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(filterLabel))))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deducsearchLabel)
                    .addComponent(filterLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchButton)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sortButton)
                    .addComponent(searchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
 
    }//GEN-LAST:event_returnButtonActionPerformed

    private void descriptionTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptionTFActionPerformed

    }//GEN-LAST:event_descriptionTFActionPerformed

    private void addDeductionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDeductionsButtonActionPerformed
    
    }//GEN-LAST:event_addDeductionsButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
      
    }//GEN-LAST:event_updateButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed

    }//GEN-LAST:event_clearButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed

    }//GEN-LAST:event_deleteButtonActionPerformed

    private void activeRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activeRadioActionPerformed

    }//GEN-LAST:event_activeRadioActionPerformed
  // </editor-fold>  
    
    public void actionPerformed(java.awt.event.ActionEvent e) {
            
          String deducdesc = descriptionTF.getText();

      
      if (e.getSource() == addDeductionsButton) {
          
          if ( deducdesc.isEmpty() ) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields", "Information", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            deducdesc = descriptionTF.getText();
   
            double rate = 0.0;
            String salaryString = rateSpinner.getValue().toString();
            try {
                rate = Double.parseDouble(salaryString);
               
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid rate format:" + salaryString, "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            
            String deducstatus = "";
            if (activeRadio.isSelected()) {
                deducstatus = "Active";
            } else if (deactivateRadio.isSelected()) {
                deducstatus = "Deactivated";
            } else {
                JOptionPane.showMessageDialog(this, "Please select a status", "Information", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            //double dedrate = rate / 100.0;
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            deduction.addDeducNode(deducdesc, rate, deducstatus, model);

            clearInputFields();
          
        }
      
      else if(e.getSource() == updateButton){
          if ( deducdesc.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields", "Information", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            String oldDeducname = jTable1.getValueAt(selectedRow, 0).toString();
            String oldDeducname1 = searchTF.getText();

            deducdesc = descriptionTF.getText();
  
            double rate = 0.0;
            String rateString = rateSpinner.getValue().toString();
            try {
                rate = Double.parseDouble(rateString);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid salary format:" + rateString, "Information", JOptionPane.INFORMATION_MESSAGE);
            }

            String deducstatus = "";
            if (activeRadio.isSelected()) {
                deducstatus = "Active";
            } else if (deactivateRadio.isSelected()) {
                deducstatus = "Deactivated";
            } else {
                JOptionPane.showMessageDialog(this, "Please select a status", "Information", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            //double dedrate = rate / 100.0;
            if (oldDeducname1 == null || oldDeducname1.isEmpty()) {
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                deduction.updateDeducNode(oldDeducname, deducdesc, rate, deducstatus);
                deduction.updateDeducTable(model);
                clearInputFields();
            }else{
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                deduction.updateDeducNode(oldDeducname1, deducdesc, rate, deducstatus);
                deduction.updateDeducTable(model);                
                clearInputFields();
                searchTF.setText("");
            }
      }
      
      else if(e.getSource() == deleteButton){
          DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            String oldDeducname = null;
            String oldDeducname1 = searchTF.getText();

            if (selectedRow != -1 && selectedRow < jTable1.getRowCount()) {
                oldDeducname = jTable1.getValueAt(selectedRow, 0).toString();
            }

            int result = JOptionPane.showConfirmDialog(null, "Do you really want to delete?",
                    "Confirmation ", JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.YES_OPTION) {
                if (oldDeducname1 == null || oldDeducname1.isEmpty()) {
                    if (oldDeducname != null) {
                        deduction.deleteDeducNode(oldDeducname);
                        deduction.updateDeducTable(model);
                        clearInputFields();
                    } else {
                        JOptionPane.showMessageDialog(this, "Please select a row to delete or perform a search", "Information", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    deduction.deleteDeducNode(oldDeducname1);
                    deduction.updateDeducTable(model);
                    clearInputFields();
                    searchTF.setText("");
                }
            } else if(result == JOptionPane.NO_OPTION){
                clearInputFields();
            }
      
      }
      else if(e.getSource() == searchButton){
          String searchDeducname = searchTF.getText();
            DeducNode selectedNode = deduction.searchDeducNode(searchDeducname);

            if (selectedNode != null) {

                descriptionTF.setText(selectedNode.getDeducName());

                rateSpinner.setValue(selectedNode.getDeducRate());

                if ("Active".equals(selectedNode.getDeducStatus())) {
                    activeRadio.setSelected(true);
                } else if ("Deactivated".equals(selectedNode.getDeducStatus())) {
                    deactivateRadio.setSelected(true);
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "Deduction not found. Please Try Again.", "Information", JOptionPane.INFORMATION_MESSAGE);
                searchTF.setText("");
            }

      
      }
      else if(e.getSource() == sortButton){
          DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
          deduction.displaySortedValues(model);
      }
      else if(e.getSource() == clearButton){
            clearInputFields();
            
      } 
      else if (e.getSource() == returnButton) {
          
          AdminMenu admin = new AdminMenu();
          admin.AdminMenu();
          admin.setVisible(true);
          setVisible(false);
          dispose();
          
        }
      
    }
    
        private void clearInputFields() {
        descriptionTF.setText("");
        rateSpinner.setValue(0.0);
        buttonGroup1.clearSelection();


    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton activeRadio;
    private javax.swing.JButton addDeductionsButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton clearButton;
    private javax.swing.JRadioButton deactivateRadio;
    private javax.swing.JLabel deducsearchLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel descripLabel;
    private javax.swing.JTextField descriptionTF;
    private javax.swing.JLabel filterLabel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel rateLabel;
    private javax.swing.JSpinner rateSpinner;
    private javax.swing.JButton returnButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTF;
    private javax.swing.JButton sortButton;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
