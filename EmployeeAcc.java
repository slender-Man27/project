package payroll;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import table.TableActionCellEditor;
import table.TableActionCellRender;
import table.TableActionEvent;

public class EmployeeAcc extends javax.swing.JFrame implements ActionListener {


    EmployeeLinkedList employeeLinkedL= new EmployeeLinkedList();
    private int row = -1;



    public void EmployeeAcc() {
        initComponents();
        addEmployeeButton.addActionListener(this);
        searchButton.addActionListener(this);
        returnButton.addActionListener(this);
        cellButton();

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
                DefaultTableModel model =(DefaultTableModel) jTable1.getModel();
                row = r;
                if(row >=0 && row<model.getColumnCount()){
                    int emp_id = (int) model.getValueAt(row,0);
                    EmployeeEdit edit = new EmployeeEdit();
                    edit.EditAcc(emp_id);
                    edit.setVisible(true);
                    setVisible(false);
                    dispose();
                }
            }
            @Override
            public void onDelete(int r ){
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                row = r;
                int result = JOptionPane.showConfirmDialog(null, "Do you really want to delete?",
                        "Confirmation ", JOptionPane.YES_NO_OPTION);
                if(jTable1.isEditing() ){
                    jTable1.getCellEditor().stopCellEditing();

                }
                int emp_id = (int) model.getValueAt(row,0);
                if(result == JOptionPane.YES_OPTION) {

                    try {
                        delete(emp_id);
                        model.removeRow(row);

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }
                else if(result == JOptionPane.NO_OPTION){
                    JOptionPane.showMessageDialog(null,"Cancelled","Confirmation",JOptionPane.INFORMATION_MESSAGE);
                }

            }
            @Override
            public void onView(int r){
                DefaultTableModel model =(DefaultTableModel) jTable1.getModel();
                row = r;
                if(row>=0&& row<model.getColumnCount()){
                    int emp_id = (int) model.getValueAt(row,0);
                    EmployeeView view = new EmployeeView();
                    view.ViewAcc(emp_id);
                    view.setVisible(true);
                    setVisible(false);
                    dispose();
                }


            }
        };
        jTable1.getColumnModel().getColumn(7).setCellRenderer(new TableActionCellRender());
        jTable1.getColumnModel().getColumn(7).setCellEditor(new TableActionCellEditor(event));
    }

    private void fetchDataFromDatabase() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        try (Connection connection = DatabaseConnector.connect()) {
            Statement statement = connection.createStatement();
            String sql = "SELECT id,lastname_employee, firstname_employee,positions.department,positions.position_name, date_hired,status FROM employee " +
                    "LEFT JOIN positions " +
                    "ON employee.position_name = positions.position_name";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int ID = resultSet.getInt("id");
                String fN = resultSet.getString("lastname_employee");
                String lN = resultSet.getString("firstname_employee");
                String dep = resultSet.getString("department");
                String pos = resultSet.getString("position_name");
                java.sql.Date hired = resultSet.getDate("date_hired");
                String stat = resultSet.getString("status");


                jTable1.setForeground(Color.white);
                Object []row = {ID,fN,lN,dep,pos,hired,stat};
                model.addRow(row);

                employeeLinkedL.addEmpNode(ID,lN,fN,dep,pos,hired,stat, model);

            }
            resultSet.close();
            statement.close();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        addEmployeeButton = new javax.swing.JButton();
        returnButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 650));
        setMinimumSize(new java.awt.Dimension(1000, 650));
        setPreferredSize(new java.awt.Dimension(1000, 650));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1000, 650));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 650));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setText("ACCOUNT OF EMPLOYEES");

        jTable1.setBackground(new java.awt.Color(38, 94, 124));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null}
                },
                new String [] {
                        "Employee ID", "Surname", "First Name", "Department", "Position", "Date Hired", "Status", "Action"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(50);
        jTable1.setSelectionBackground(new java.awt.Color(51, 153, 153));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel2.setText("Employee ID / Name:");

        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(44, 132, 142)));

        searchButton.setBackground(new java.awt.Color(44, 132, 142));
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Desktop\\PAYROLL FINAL FOLDER\\payroll\\src\\images\\search.png")); // NOI18N
        searchButton.setText("Search");
        searchButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(44, 132, 142)));
        searchButton.setMargin(new java.awt.Insets(3, 14, 3, 14));

        addEmployeeButton.setBackground(new java.awt.Color(44, 132, 142));
        addEmployeeButton.setForeground(new java.awt.Color(255, 255, 255));
        addEmployeeButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Desktop\\PAYROLL FINAL FOLDER\\payroll\\src\\images\\add.png")); // NOI18N
        addEmployeeButton.setText("Add New Employee");
        addEmployeeButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(44, 132, 142)));
        addEmployeeButton.setMargin(new java.awt.Insets(5, 14, 5, 14));
        addEmployeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeButtonActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 911, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(548, 548, 548)
                                                .addComponent(addEmployeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jLabel2))
                                                .addGap(665, 665, 665)))
                                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(31, 31, 31)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(addEmployeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 592, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addEmployeeButtonActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_returnButtonActionPerformed


    public void actionPerformed(java.awt.event.ActionEvent e) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        if (e.getSource() == addEmployeeButton) {
            EmployeeAdd addNewEmployee = new EmployeeAdd();
            addNewEmployee.AddEmployee();
            addNewEmployee.setVisible(true);
            setVisible(false);
            dispose();
        }
        else if(e.getSource() == returnButton){
            AdminMenu admin = new AdminMenu();
            admin.AdminMenu();
            admin.setVisible(true);
            setVisible(false);
            dispose();
        }
        else if(e.getSource() == searchButton) {
            String key = jTextField1.getText();
            if(key.isEmpty()){
                JOptionPane.showMessageDialog(null,"Empty","Error",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            try {
                int id = Integer.parseInt(key);
                employeeLinkedL.searchNodeByID(id,model);

            } catch (NumberFormatException ex) {
                employeeLinkedL.searchNodeByName(key,model);
            }
            if(jTextField1!=null){
                jTextField1.setText("");
            }
        }
    }
   /*  try {
        delete(emp_id);
        model.removeRow(row);

    } catch (SQLException e) {
        e.printStackTrace();
    }

    */



    private void delete(int id)throws SQLException{
        try(Connection connection = DatabaseConnector.connect()){
            String sql = "DELETE FROM employee WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }

    }





    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEmployeeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton returnButton;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables
}
