
package payroll;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tablereports.TableActionCellEditor;
import tablereports.TableActionCellRender;
import tablereports.TableActionEvent;

public class ReportsSalary extends javax.swing.JFrame implements ActionListener {

    private ReportsSalaryLinked salary = new ReportsSalaryLinked();
    private ReportsSalaryDataRetrieve saldb = new ReportsSalaryDataRetrieve();

    private int selectedRow = -1;

    public void ReportsSalary() {
        initComponents();
        cellButton();
        returnButton.addActionListener(this);
        filterButton.addActionListener(this);
        searchButton.addActionListener(this);
        sortButton.addActionListener(this);
        databaseRetrieval();

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
                selectedRow = r;
                if(selectedRow >= 0 && selectedRow < model.getRowCount()){
                    int ID = (int) model.getValueAt(selectedRow,0);
                    Payslip emPayslip = new Payslip();
                    emPayslip.Payslip(ID);
                    setVisible(false);
                    dispose();
                }


                //ReportsPayslip emPayslip = new ReportsPayslip();
                //emPayslip.setVisible(true);
            }
        };
        jTable1.getColumnModel().getColumn(7).setCellRenderer(new TableActionCellRender());
        jTable1.getColumnModel().getColumn(7).setCellEditor(new TableActionCellEditor(event));
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
    public void databaseRetrieval() {
        try (Connection connection = DatabaseConnector.connect()) {
            saldb.fetchDataSalaryIntoLinkedList(connection, salary, (DefaultTableModel) jTable1.getModel());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public double sumNum(DefaultTableModel model, int columnIndex) {
        double sum = 0.0;

        for (int row = 0; row < model.getRowCount(); row++) {
            Object value = model.getValueAt(row, columnIndex);

            if (value != null) {
                try {
                    double numericValue = Double.parseDouble(value.toString());
                    sum += numericValue;
                } catch (NumberFormatException e) {
                    System.err.println("Non-numeric value encountered: " + value);
                }
            }
        }
        return sum;
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
        searchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        salaryLabel = new javax.swing.JLabel();
        deducLabel = new javax.swing.JLabel();
        netLabel = new javax.swing.JLabel();
        returnButton = new javax.swing.JButton();
        filterButton = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        sortButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 650));
        setMinimumSize(new java.awt.Dimension(1000, 650));
        setPreferredSize(new java.awt.Dimension(1000, 603));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setText("SALARY REPORTS");

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

        searchButton.setBackground(new java.awt.Color(51, 153, 153));
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(38, 94, 124));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Employee ID", "Name", "Position", "Gross Salary", "Deduction", "Net Salary", "Date", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(50);
        jTable1.setSelectionBackground(new java.awt.Color(51, 153, 153));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel4.setText("Total Salary Amount");

        salaryLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        salaryLabel.setText("Total Basic Salary:");

        deducLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        deducLabel.setText("Total Deductions:");

        netLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        netLabel.setText("Total Net Salary:");

        returnButton.setBackground(new java.awt.Color(51, 153, 153));
        returnButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ascending Order" }));

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel8.setText("Sort by:");

        sortButton.setBackground(new java.awt.Color(44, 132, 142));
        sortButton.setForeground(new java.awt.Color(255, 255, 255));
        sortButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-check-18.png"))); // NOI18N
        sortButton.setText("Ok");
        sortButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(44, 132, 142)));
        sortButton.setMargin(new java.awt.Insets(3, 14, 3, 14));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(salaryLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(394, 394, 394)
                                        .addComponent(jLabel1))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(searchButton))
                                    .addComponent(deducLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(netLabel, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(returnButton)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(29, 29, 29)
                                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(14, 14, 14)
                                            .addComponent(filterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(280, 280, 280)
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(sortButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(32, 32, 32)))
                        .addGap(37, 37, 37))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(searchButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sortButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(filterButton)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(returnButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(salaryLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deducLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(netLabel)))
                .addGap(534, 534, 534))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {

    }
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed

    }//GEN-LAST:event_searchButtonActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        updateSecondComboBox();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed

    }//GEN-LAST:event_returnButtonActionPerformed

    private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterButtonActionPerformed

    public void actionPerformed(java.awt.event.ActionEvent e) {

        String selectedFirst = jComboBox1.getSelectedItem().toString();
        String selectedSecond = jComboBox2.getSelectedItem() != null ? jComboBox2.getSelectedItem().toString() : "";
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        int sal = 3;
        double totalSal = sumNum(model, sal);
        salaryLabel.setText("Total Basic Salary:  " + totalSal);

        int deduc = 4;
        double totalDeduc = sumNum(model, deduc);
        deducLabel.setText("Total Deductions:  " + totalDeduc);

        int net = 5;
        double totalNet = sumNum(model, net);
        netLabel.setText("Total Net Salary:  " + totalNet);

        if (e.getSource() == filterButton) {
            jTextField1.setText(" ");
            if(selectedFirst.equals("All")){
                salary.updateSalaryTable(model);
                sal = 3;
                totalSal = sumNum(model, sal);
                salaryLabel.setText("Total Basic Salary:  " + totalSal);

                deduc = 4;
                totalDeduc = sumNum(model, deduc);
                deducLabel.setText("Total Deductions:  " + totalDeduc);

                net = 5;
                totalNet = sumNum(model, net);
                netLabel.setText("Total Net Salary:  " + totalNet);

            }
            else if(selectedFirst.equals("Month")) {
                int num_month = java.time.Month.valueOf(selectedSecond.toUpperCase()).getValue();
                salary.filterByMonth(num_month, model);

                sal = 3;
                totalSal = sumNum(model, sal);
                salaryLabel.setText("Total Basic Salary:  " + totalSal);

                deduc = 4;
                totalDeduc = sumNum(model, deduc);
                deducLabel.setText("Total Deductions:  " + totalDeduc);

                net = 5;
                totalNet = sumNum(model, net);
                netLabel.setText("Total Net Salary:  " + totalNet);
            }
            else if (selectedFirst.equals("Quarter")) {
                int quarter;

                if(selectedSecond.equals("Jan - Mar")){
                    quarter = 1;
                    salary.filterByQuarter(quarter, model);

                    sal = 3;
                    totalSal = sumNum(model, sal);
                    salaryLabel.setText("Total Basic Salary:  " + totalSal);

                    deduc = 4;
                    totalDeduc = sumNum(model, deduc);
                    deducLabel.setText("Total Deductions:  " + totalDeduc);

                    net = 5;
                    totalNet = sumNum(model, net);
                    netLabel.setText("Total Net Salary:  " + totalNet);
                }
                else if(selectedSecond.equals("Apr - Jun")){
                    quarter = 2;
                    salary.filterByQuarter(quarter, model);
                    sal = 3;
                    totalSal = sumNum(model, sal);
                    salaryLabel.setText("Total Basic Salary:  " + totalSal);

                    deduc = 4;
                    totalDeduc = sumNum(model, deduc);
                    deducLabel.setText("Total Deductions:  " + totalDeduc);

                    net = 5;
                    totalNet = sumNum(model, net);
                    netLabel.setText("Total Net Salary:  " + totalNet);
                }
                else if(selectedSecond.equals("Jul - Sep")){
                    quarter = 3;
                    salary.filterByQuarter(quarter, model);

                    sal = 3;
                    totalSal = sumNum(model, sal);
                    salaryLabel.setText("Total Basic Salary:  " + totalSal);

                    deduc = 4;
                    totalDeduc = sumNum(model, deduc);
                    deducLabel.setText("Total Deductions:  " + totalDeduc);

                    net = 5;
                    totalNet = sumNum(model, net);
                    netLabel.setText("Total Net Salary:  " + totalNet);
                }
                else if(selectedSecond.equals("Oct - Dec")){
                    quarter = 4;
                    salary.filterByQuarter(quarter, model);

                    sal = 3;
                    totalSal = sumNum(model, sal);
                    salaryLabel.setText("Total Basic Salary:  " + totalSal);

                    deduc = 4;
                    totalDeduc = sumNum(model, deduc);
                    deducLabel.setText("Total Deductions:  " + totalDeduc);

                    net = 5;
                    totalNet = sumNum(model, net);
                    netLabel.setText("Total Net Salary:  " + totalNet);
                }

            } else if (selectedFirst.equals("Year")) {
                int year;
                if(!selectedSecond.isEmpty()) {
                    if (selectedSecond.equals("2020")) {
                        year = 2020;
                        salary.filterByYear(year, model);

                        sal = 3;
                        totalSal = sumNum(model, sal);
                        salaryLabel.setText("Total Basic Salary:  " + totalSal);

                        deduc = 4;
                        totalDeduc = sumNum(model, deduc);
                        deducLabel.setText("Total Deductions:  " + totalDeduc);

                        net = 5;
                        totalNet = sumNum(model, net);
                        netLabel.setText("Total Net Salary:  " + totalNet);
                    } else if (selectedSecond.equals("2021")) {
                        year = 2021;
                        salary.filterByYear(year, model);

                        sal = 3;
                        totalSal = sumNum(model, sal);
                        salaryLabel.setText("Total Basic Salary:  " + totalSal);

                        deduc = 4;
                        totalDeduc = sumNum(model, deduc);
                        deducLabel.setText("Total Deductions:  " + totalDeduc);

                        net = 5;
                        totalNet = sumNum(model, net);
                        netLabel.setText("Total Net Salary:  " + totalNet);
                    } else if (selectedSecond.equals("2022")) {
                        year = 2022;
                        salary.filterByYear(year, model);

                        sal = 3;
                        totalSal = sumNum(model, sal);
                        salaryLabel.setText("Total Basic Salary:  " + totalSal);

                        deduc = 4;
                        totalDeduc = sumNum(model, deduc);
                        deducLabel.setText("Total Deductions:  " + totalDeduc);

                        net = 5;
                        totalNet = sumNum(model, net);
                        netLabel.setText("Total Net Salary:  " + totalNet);

                    } else if (selectedSecond.equals("2023")) {
                        year = 2023;
                        salary.filterByYear(year, model);

                        sal = 3;
                        totalSal = sumNum(model, sal);
                        salaryLabel.setText("Total Basic Salary:  " + totalSal);

                        deduc = 4;
                        totalDeduc = sumNum(model, deduc);
                        deducLabel.setText("Total Deductions:  " + totalDeduc);

                        net = 5;
                        totalNet = sumNum(model, net);
                        netLabel.setText("Total Net Salary:  " + totalNet);
                    }
                }else{

                }
            } else {
                salary.updateSalaryTable(model);

                sal = 3;
                totalSal = sumNum(model, sal);
                salaryLabel.setText("Total Basic Salary:  " + totalSal);

                deduc = 4;
                totalDeduc = sumNum(model, deduc);
                deducLabel.setText("Total Deductions:  " + totalDeduc);

                net = 5;
                totalNet = sumNum(model, net);
                netLabel.setText("Total Net Salary:  " + totalNet);
            }
        }
        if (e.getSource() == searchButton) {
            String idText = jTextField1.getText();

            if(idText.isEmpty()){
                JOptionPane.showMessageDialog(null,"Empty","Error",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            try {
                int id = Integer.parseInt(idText);
                salary.searchNodeByID(id, model);

            }catch (NumberFormatException ex){
                salary.searchNodeByName(idText,model);

            }


            sal = 3;
            totalSal = sumNum(model, sal);
            salaryLabel.setText("Total Basic Salary:  " + totalSal);

            deduc = 4;
            totalDeduc = sumNum(model, deduc);
            deducLabel.setText("Total Deductions:  " + totalDeduc);

            net = 5;
            totalNet = sumNum(model, net);
            netLabel.setText("Total Net Salary:  " + totalNet);
            if(jTextField1!=null){
                jTextField1.setText("");
            }
        }
        else if(e.getSource() == sortButton){
            salary.displaySortedValues(model);
        }

        if (e.getSource() == returnButton) {
            ReportsMenu remenu = new ReportsMenu();
            remenu.ReportsMenu();
            remenu.setVisible(true);
            setVisible(false);
            dispose();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel deducLabel;
    private javax.swing.JButton filterButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel netLabel;
    private javax.swing.JButton returnButton;
    private javax.swing.JLabel salaryLabel;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton sortButton;
    // End of variables declaration//GEN-END:variables
}
