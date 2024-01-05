
package payroll;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;

public class EmployeeView extends javax.swing.JFrame implements ActionListener {

    private ImageIcon format  = null;
    private int emp_id;



    public void ViewAcc(int employee_id) {
        this.emp_id = employee_id;
        initComponents();
        returnButton1.addActionListener(this);

        try{
            fetchDataFromDatabase(emp_id);
            fetchDataFromDatabaseEmp(emp_id);
        }catch (SQLException e){
            e.printStackTrace();
        }
        ViewImage(employee_id);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        picLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        firstnameLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lastnameLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        departLabel = new javax.swing.JLabel();
        posLabel = new javax.swing.JLabel();
        typeLabel = new javax.swing.JLabel();
        salLabel = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        returnButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 650));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        picLabel.setBackground(new java.awt.Color(38, 97, 126));
        picLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 97, 126)));
        jPanel1.add(picLabel);
        picLabel.setBounds(20, 100, 190, 190);

        jLabel1.setBackground(new java.awt.Color(38, 97, 126));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(38, 97, 126));
        jLabel1.setText("View Employee's Account");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 30, 243, 27);

        jLabel2.setBackground(new java.awt.Color(38, 97, 126));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(38, 97, 126));
        jLabel2.setText("Daily Attendance");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 310, 113, 20);

        firstnameLabel.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        firstnameLabel.setText("First Name");
        jPanel1.add(firstnameLabel);
        firstnameLabel.setBounds(540, 110, 340, 30);

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        jLabel3.setText("First Name");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(540, 140, 130, 13);

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        jLabel13.setText("Last Name");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(230, 140, 130, 13);

        lastnameLabel.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lastnameLabel.setText("Last Name");
        jPanel1.add(lastnameLabel);
        lastnameLabel.setBounds(230, 110, 260, 30);

        jPanel2.setBackground(new java.awt.Color(38, 97, 126));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Password:");

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Status:");

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Sex:");

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Date of Birth:");

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Department");

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Position:");

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Type of Employment: ");

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Basic Salary:");

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("None");

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("None");

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("None");

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("None");

        departLabel.setForeground(new java.awt.Color(255, 255, 255));
        departLabel.setText("None");

        posLabel.setForeground(new java.awt.Color(255, 255, 255));
        posLabel.setText("None");

        typeLabel.setForeground(new java.awt.Color(255, 255, 255));
        typeLabel.setText("None");

        salLabel.setForeground(new java.awt.Color(255, 255, 255));
        salLabel.setText("None");

        jLabel24.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Date Hired:");

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("None");

        jLabel23.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Employee ID:");

        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("None");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(typeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                    .addComponent(posLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(departLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(salLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(departLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(posLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(typeLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(salLabel)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel17)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel18))))
                .addContainerGap())
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(230, 160, 740, 130);

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
        jTable1.setRowHeight(30);
        jTable1.setSelectionBackground(new java.awt.Color(45, 133, 143));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 330, 950, 200);

        jLabel27.setBackground(new java.awt.Color(38, 97, 126));
        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(38, 97, 126));
        jLabel27.setText("Employee's Details");
        jPanel1.add(jLabel27);
        jLabel27.setBounds(30, 60, 113, 20);

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
        jPanel1.add(returnButton1);
        returnButton1.setBounds(890, 550, 80, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void returnButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_returnButton1ActionPerformed



    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() == returnButton1) {
            EmployeeAcc employee = new EmployeeAcc();
            employee.EmployeeAcc();
            employee.setVisible(true);
            setVisible(false);
            dispose();
        }
    }

    private void fetchDataFromDatabase(int id) throws SQLException {

        try (Connection connection = DatabaseConnector.connect()) {
            Statement statement = connection.createStatement();
            String sql = "SELECT lastname_employee, firstname_employee, id, date_of_birth, sex, status, password, date_hired, positions.department,positions.position_name, positions.employee_type, positions.salary FROM employee " +
                    "LEFT JOIN positions " +
                    "ON employee.position_name = positions.position_name " +
                    "WHERE id = ?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                ResultSet resultSet = ps.executeQuery();

                if (resultSet.next()) {
                    String lN = resultSet.getString("lastname_employee");
                    String fN = resultSet.getString("firstname_employee");
                    int ID = resultSet.getInt("id");
                    java.sql.Date birth = resultSet.getDate("date_of_birth");
                    String sex = resultSet.getString("sex");
                    String stat = resultSet.getString("status");
                    String pass = resultSet.getString("password");
                    java.sql.Date hired = resultSet.getDate("date_hired");
                    String dep = resultSet.getString("department");
                    String pos = resultSet.getString("position_name");
                    String type = resultSet.getString("employee_type");
                    String salary = resultSet.getString("salary");

                    lastnameLabel.setText(lN);
                    firstnameLabel.setText(fN);
                    jLabel26.setText(String.valueOf(ID));
                    jLabel15.setText(String.valueOf(birth));
                    jLabel16.setText(sex);
                    jLabel17.setText(stat);
                    jLabel18.setText(pass);
                    jLabel25.setText(String.valueOf(hired));
                    departLabel.setText(dep);
                    posLabel.setText(pos);
                    typeLabel.setText(type);
                    salLabel.setText(salary);

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

    private void fetchDataFromDatabaseEmp(int id) throws SQLException {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        try (Connection connection = DatabaseConnector.connect()) {
            String sql = "SELECT * FROM dailytr WHERE employee_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int ID = resultSet.getInt("employee_id");
                    java.sql.Date date = resultSet.getDate("day");
                    java.sql.Time timeIn = resultSet.getTime("time_in_AM");
                    java.sql.Time timeOut = resultSet.getTime("time_out_AM");
                    java.sql.Time timeInPm = resultSet.getTime("time_in_PM");
                    java.sql.Time timeOutPm = resultSet.getTime("time_out_PM");
                    int OT = resultSet.getInt("overtime");

                    // Handle null values for time columns
                    if (timeIn == null) {
                        timeIn = null; // Set to null to represent an empty value
                    }
                    if (timeOut == null) {
                        timeOut = null;
                    }
                    if (timeInPm == null) {
                        timeInPm = null;
                    }
                    if (timeOutPm == null) {
                        timeOutPm = null;
                    }

                    jTable1.setForeground(Color.white);

                    Object[] row = {ID, date, timeIn, timeOut, timeInPm, timeOutPm, OT};
                    model.addRow(row);
                }

                resultSet.close();
            }
        }
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel departLabel;
    private javax.swing.JLabel firstnameLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lastnameLabel;
    private javax.swing.JLabel picLabel;
    private javax.swing.JLabel posLabel;
    private javax.swing.JButton returnButton1;
    private javax.swing.JLabel salLabel;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration//GEN-END:variables
}
