package payroll;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class EmployeeDedDataRetrieve {
    public static void fetchDataIntoEmployeeDedLinkedList(Connection connection, EmployeeDeductionsLinked linkedList) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM employee_deductions WHERE deduction_status = 'Active'"
        );
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int emp_id = resultSet.getInt("employee_id");
                Date deducDate = resultSet.getDate("deduction_date");
                String deducName = resultSet.getString("deduction_description");
                double deducAmt = resultSet.getDouble("deduction_amount");

                linkedList.addEmpDeducNode(emp_id, deducDate, deducName, deducAmt);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
    public static void fetchDataIntoEmpDedLinkedList(Connection connection, EmployeeDeductionsLinked linkedList, int emp_id, Date date, double salary) {
        //System.out.println(salary + "Salary");
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM deductions WHERE deduction_status = 'Active'"
        );
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String deducName = resultSet.getString("deduction_description");
                double deducRate = resultSet.getDouble("rate");
                double deducrate = deducRate / 100;
                double deducAmt = salary * deducrate;

                linkedList.addEmpDeducNode(emp_id, date, deducName, deducAmt);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
