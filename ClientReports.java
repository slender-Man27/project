package payroll;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class ClientReports extends javax.swing.JFrame implements ActionListener{
    Connection connection;
    ClientReportsLinked dtr = new ClientReportsLinked();
    ClientTimeInOutDataRetrieve dtrdb = new ClientTimeInOutDataRetrieve();
    EmployeeDeductionsLinked empded = new EmployeeDeductionsLinked();
    EmployeeDedDataRetrieve empdeddb = new EmployeeDedDataRetrieve();
    private int emp_id;

    private Date currentmonthyear;
    private Date deductiondate;
    private double emp_sal;
    public void ClientReports(String id, double emp_sal) {
        connectToDB();
        this.emp_id = Integer.parseInt(id);

        LocalDate currentDate = LocalDate.now();
        Date currentDateInDate = java.sql.Date.valueOf(currentDate);
        this.currentmonthyear = currentDateInDate;

        this.emp_sal = emp_sal;

        initComponents();

        DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        String currentMonth = currentDate.format(monthFormatter);
        jLabel6.setText(currentMonth);

        databaseRetrieval();

        LocalDate curDate = LocalDate.now();

        int defaultDay = 28;

        int curYear = currentDate.getYear();
        int curMonth = currentDate.getMonthValue();

        LocalDate customDate = LocalDate.of(curYear, curMonth, defaultDay);

        java.sql.Date curDateInDate = java.sql.Date.valueOf(customDate);

        this.deductiondate = curDateInDate;

        //databaseDeduction();

        backButton.addActionListener(this);
        previousButton.addActionListener(this);

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        previousButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(38, 94, 124));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REPORTS");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Daily Time Records");

        previousButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        previousButton.setText("Generate");
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Previous Payslip");

        backButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("-");

        jTable1.setBackground(new java.awt.Color(38, 97, 126));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No.", "Date", "Time In(AM)", "Time Out(AM)", "Time In(PM)", "Time Out(PM)", "Overtime(hours)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(40);
        jTable1.setSelectionBackground(new java.awt.Color(45, 133, 143));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(328, 328, 328)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(previousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 706, Short.MAX_VALUE)
                                .addComponent(backButton)))
                        .addGap(36, 36, 36))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(85, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 827, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(88, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(50, 50, 50)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(286, 286, 286)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(previousButton))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(backButton)))
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(181, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(159, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1013, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 6, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 7, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_previousButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backButtonActionPerformed
    public void connectToDB() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll", "root", "");
        } catch (SQLException e) {
            System.out.println("Unable to connect to the database");
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("Error Message: " + e.getMessage());
            //System.exit(1);
        }
    }
    public void databaseRetrieval() {
        try (Connection connection = DatabaseConnector.connect()) {
            dtrdb.fetchDataIntoDTRLinkedList(connection, dtr, (DefaultTableModel) jTable1.getModel(), emp_id, currentmonthyear );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void databaseDeductionRetrieval() {
        try (Connection connection = DatabaseConnector.connect()) {
            empdeddb.fetchDataIntoEmployeeDedLinkedList(connection, empded);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void databaseDeduction() {
        try (Connection connection = DatabaseConnector.connect()) {
            empdeddb.fetchDataIntoEmpDedLinkedList(connection, empded, emp_id, deductiondate, emp_sal);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int findID(int empID, Date dateDed) {
        try{
            String sql = "SELECT employee_id FROM employee_deductions WHERE employee_id = ? AND deduction_date = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, empID);
                statement.setDate(2, dateDed);


                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getInt("employee_id");
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
        LocalDate curDate = LocalDate.now();
        int defaultDay = 28;
        int curYear = curDate.getYear();
        int curMonth = curDate.getMonthValue();
        //LocalDate customDate = LocalDate.of(curYear, curMonth, defaultDay);
        //java.sql.Date curDateInDate = java.sql.Date.valueOf(customDate);
        LocalDate prevMonthDate = curDate.minusMonths(1);
        LocalDate prevCustomDate = LocalDate.of(prevMonthDate.getYear(), prevMonthDate.getMonthValue(), defaultDay);
        java.sql.Date prevDateInDate = java.sql.Date.valueOf(prevCustomDate);
        int isIDfound = findID(emp_id, prevDateInDate);

        if (e.getSource() == backButton) {
            Client client = new Client();
            client.ClientView(emp_id);
            client.setVisible(true);
            setVisible(false);
            dispose();
        }

        if (e.getSource() == previousButton) {

            if (isIDfound != -1) {
                try {
                    DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    String currentMonthText = currentmonthyear.toString();
                    LocalDate currentMonth = LocalDate.parse(currentMonthText, monthFormatter);


                    LocalDate prev = currentMonth.minusMonths(1);
                    Date firstDayOfPreviousMonth = java.sql.Date.valueOf(prev.withDayOfMonth(1));
                    Date lastDayOfPreviousMonth = java.sql.Date.valueOf(prev.withDayOfMonth(prev.lengthOfMonth()));

                    databaseDeduction();

                    PayslipClient payslip = new PayslipClient();
                    payslip.Payslip(emp_id,firstDayOfPreviousMonth,lastDayOfPreviousMonth, emp_sal );
                    setVisible(false);
                    dispose();

                }catch (Exception exx){
                    exx.printStackTrace();
                }
            }else{
                JOptionPane.showMessageDialog(this, "Oops! It seems there are no reports " +
                        "available for you in the previous month. Unable to generate a payslip at the moment.");
            }

        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton previousButton;
    // End of variables declaration//GEN-END:variables
}
