
package payroll;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;

import tablereports.TableActionCellEditor;
import tablereports.TableActionCellRender;
import tablereports.TableActionEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ReportsEmployees extends javax.swing.JFrame implements ActionListener {

    ReportEmployeeList list = new ReportEmployeeList();
    private int row = -1;
    public void ReportsEmployees() {
        initComponents();
        cellButton();
        jButton2.addActionListener(this);
        returnButton.addActionListener(this);
        filterButton.addActionListener(this);

        try{
            fetchDataFromDatabase();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void cellButton(){
        TableActionEvent event = new TableActionEvent(){
            @Override
            public void onEdit(int r){

            }
            @Override
            public void onDelete(int r){

            }
            @Override
            public void onView(int r){
                DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
                row = r;
                if(row>=0 && row<model.getColumnCount()){
                    int emp_id =(int) model.getValueAt(row,1);
                    EmployeeDetails emDetails = new EmployeeDetails();
                    emDetails.EmployeeDetails(emp_id);
                    emDetails.setVisible(true);
                    setVisible(false);
                    dispose();
                }
            }
        };
        jTable1.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRender());
        jTable1.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(event));
    }

    private void updateSecondComboBox() {
        jComboBox2.removeAllItems();

        String selectedItem = (String) jComboBox1.getSelectedItem();

        if (selectedItem != null && !selectedItem.equals("All")) {
            jComboBox2.setEnabled(true);

            if (selectedItem.equals("Month")) {
                jComboBox2.addItem("January");
                jComboBox2.addItem("February");
                jComboBox2.addItem("March");
                jComboBox2.addItem("April");
                jComboBox2.addItem("May");
                jComboBox2.addItem("June");
                jComboBox2.addItem("July");
                jComboBox2.addItem("August");
                jComboBox2.addItem("September");
                jComboBox2.addItem("October");
                jComboBox2.addItem("November");
                jComboBox2.addItem("December");

            } else if (selectedItem.equals("Quarter")) {

                jComboBox2.addItem("Jan - Mar");
                jComboBox2.addItem("Apr - Jun");
                jComboBox2.addItem("Jul - Sep");
                jComboBox2.addItem("Oct - Dec");

            } else if (selectedItem.equals("Year")) {

                jComboBox2.addItem("2020");
                jComboBox2.addItem("2021");
                jComboBox2.addItem("2022");
                jComboBox2.addItem("2023");
            }
        } else {
            jComboBox2.setEnabled(false);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        returnButton = new javax.swing.JButton();
        filterButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 650));
        setMinimumSize(new java.awt.Dimension(1000, 650));
        setPreferredSize(new java.awt.Dimension(1000, 603));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setText("LIST OF EMPLOYEES");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Month", "Quarter", "Year" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Filter by:");

        jLabel3.setText("ID:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 153, 153));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(38, 94, 124));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Sr. No", "Employee ID", "Name", "Position", "Type", "Status", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(50);
        jTable1.setSelectionBackground(new java.awt.Color(51, 153, 153));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTable1);

        returnButton.setBackground(new java.awt.Color(51, 153, 153));
        returnButton.setForeground(new java.awt.Color(255, 255, 255));
        returnButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/return.png"))); // NOI18N
        returnButton.setText("Return");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        filterButton.setBackground(new java.awt.Color(51, 153, 153));
        filterButton.setForeground(new java.awt.Color(255, 255, 255));
        filterButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-check-18.png"))); // NOI18N
        filterButton.setText("Ok");
        filterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(29, 29, 29)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(filterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 842, Short.MAX_VALUE)
                        .addComponent(returnButton)))
                .addGap(37, 37, 37))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(404, 404, 404))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filterButton)
                            .addComponent(jLabel3))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(returnButton)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        updateSecondComboBox();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed

    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed

    }//GEN-LAST:event_returnButtonActionPerformed

    private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterButtonActionPerformed

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        String selectedFirst = jComboBox1.getSelectedItem().toString();
        String selectedSecond = jComboBox2.getSelectedItem() != null ? jComboBox2.getSelectedItem().toString() : "";

        if (e.getSource() == returnButton) {
            ReportsMenu remenu = new ReportsMenu();
            remenu.ReportsMenu();
            remenu.setVisible(true);
            setVisible(false);
            dispose();
        }
        else if(e.getSource() == jButton2) {
            String idT = jTextField1.getText();
            if(idT.isEmpty()){
                JOptionPane.showMessageDialog(null,"Empty","Error",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            try {
                int id = Integer.parseInt(idT);
                list.searchNode(id,model);

            } catch (NumberFormatException ex) {
                list.searchNodeByName(idT,model);
            }
            if(jTextField1!=null){
                jTextField1.setText("");
            }
        }
        if (e.getSource() == filterButton) {
            jTextField1.setText(" ");
            if(selectedFirst.equals("All")){
                list.updateSalaryTable(model);


            }
            else if(selectedFirst.equals("Month")) {
                int num_month = java.time.Month.valueOf(selectedSecond.toUpperCase()).getValue();
                list.filterByMonth(num_month, model);

            }
            else if (selectedFirst.equals("Quarter")) {
                int quarter;

                if(selectedSecond.equals("Jan - Mar")){
                    quarter = 1;
                    list.filterByQuarter(quarter, model);

                }
                else if(selectedSecond.equals("Apr - Jun")){
                    quarter = 2;
                    list.filterByQuarter(quarter, model);

                }
                else if(selectedSecond.equals("Jul - Sep")){
                    quarter = 3;
                    list.filterByQuarter(quarter, model);

                }
                else if(selectedSecond.equals("Oct - Dec")){
                    quarter = 4;
                    list.filterByQuarter(quarter, model);

                }

            } else if (selectedFirst.equals("Year")) {
                int year;
                if(!selectedSecond.isEmpty()) {
                    if (selectedSecond.equals("2020")) {
                        year = 2020;
                        list.filterByYear(year, model);

                    } else if (selectedSecond.equals("2021")) {
                        year = 2021;
                        list.filterByYear(year, model);

                    } else if (selectedSecond.equals("2022")) {
                        year = 2022;
                        list.filterByYear(year, model);

                    } else if (selectedSecond.equals("2023")) {
                        year = 2023;
                        list.filterByYear(year, model);

                    }
                }else{

                }
            } else {
                list.updateSalaryTable(model);

            }
        }

    }

    private void fetchDataFromDatabase() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        try (Connection connection = DatabaseConnector.connect()) {
            Statement statement = connection.createStatement();
            String sql = "SELECT id,lastname_employee,firstname_employee, positions.department, positions.position_name, date_hired, status " +
                    "FROM employee " +
                    "LEFT JOIN positions ON employee.position_name = positions.position_name";
            ;
            ResultSet resultSet = statement.executeQuery(sql);
            int serialNum = 1;

            while (resultSet.next()) {
                int ID = resultSet.getInt("id");
                String lN = resultSet.getString("lastname_employee");
                String fN = resultSet.getString("firstname_employee");
                String dep = resultSet.getString("department");
                String pos = resultSet.getString("position_name");
                String stat = resultSet.getString("status");
                Date dateHired = resultSet.getDate("date_hired");

                String full = fN+" "+lN;

                jTable1.setForeground(Color.white);
                Object []row = {serialNum,ID,full,dep,pos,stat};
                model.addRow(row);

                list.addEmpListNode(serialNum,ID,full,dep,pos,stat,dateHired,model);
                serialNum++;
            }
            resultSet.close();
            statement.close();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton filterButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton returnButton;
    // End of variables declaration//GEN-END:variables
}
