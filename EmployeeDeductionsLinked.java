package payroll;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.util.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
class EmpDeducNode{

    public int emp_id;
    public Date deducDate;
    public String deducName;
    public double deducAmount;

    public EmpDeducNode next;
    public EmpDeducNode prev;

    public EmpDeducNode(int emp_id, Date deducDate, String deducName, double deducAmount){
        this.emp_id = emp_id;
        this.deducDate = deducDate;
        this.deducName = deducName;
        this.deducAmount = deducAmount;
    }

    public int getEmpID() {
        return emp_id;
    }

    public Date getDeducDate() {
        return deducDate;
    }

    public String getDeducName() {
        return deducName;
    }

    public double getDeducAmt() {
        return deducAmount;
    }

}
public class EmployeeDeductionsLinked {

    EmpDeducNode head;
    public EmpDeducNode last = null;

    public boolean isEmpty(){
        return head == null;
    }

    public void addEmpDeducNode(int emp_id, Date admideducDate, String deducName, double deducAmount) {
        EmpDeducNode newNode = new EmpDeducNode(emp_id, admideducDate, deducName, deducAmount);

        if (isDeducDuplicate(newNode.getEmpID(), newNode.getDeducName(), newNode.getDeducDate())) {
            displayMessage("The deduction " + newNode.getDeducName() + " have already been added. Please try again." );
            return;
        }

        if(isEmpty()){
            head = newNode;
        }
        else{
            last.next = newNode;
            newNode.prev = last;
        }
        last = newNode;

        try (Connection connection = DatabaseConnector.connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT IGNORE INTO employee_deductions (employee_id, deduction_date, deduction_description, deduction_amount) VALUES (?, ?, ?, ?)"
            );
            preparedStatement.setInt(1, newNode.getEmpID());
            preparedStatement.setDate(2, newNode.getDeducDate());
            preparedStatement.setString(3, newNode.getDeducName());
            preparedStatement.setDouble(4, newNode.getDeducAmt());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean isDeducDuplicate(int empID, String deducName, Date date) {
        EmpDeducNode current = head;
        while (current != null) {
            if (current.getEmpID() == empID && current.getDeducName().equals(deducName) && current.getDeducDate().equals(date)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    private void displayMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }




}
