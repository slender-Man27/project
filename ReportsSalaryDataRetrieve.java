package payroll;
import java.sql.*;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class ReportsSalaryDataRetrieve {
    public static void fetchDataSalaryIntoLinkedList(Connection connection, ReportsSalaryLinked linkedList, DefaultTableModel model) throws SQLException {
        Statement statement = connection.createStatement();

        int employee_id;
        String name;
        String position;
        double salary;
        double overtime;
        double deduction;
        Date date;

        String query = "SELECT ed.employee_id, " +
                "CONCAT(e.firstname_employee, ' ', e.lastname_employee) AS full_name, " +
                "p.position_name,p.salary, " +
                "d.overtime, " +
                "ed.deduction_date, " +
                "SUM(ed.deduction_amount) AS total_deduction " +
                "FROM employee_deductions ed " +
                "LEFT JOIN employee e ON ed.employee_id = e.id " +
                "LEFT JOIN positions p ON e.position_name = p.position_name " +
                "LEFT JOIN dailyTR d ON e.id = d.employee_id " +
                "GROUP BY ed.employee_id, ed.deduction_date ";


        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            employee_id = resultSet.getInt("employee_id");
            name = resultSet.getString("full_name");
            position = resultSet.getString("position_name");
            salary = resultSet.getDouble("salary");
            overtime = resultSet.getDouble("overtime");
            deduction = resultSet.getDouble("total_deduction");
            date = resultSet.getDate("deduction_date");

            double hoursrate = 100 * 1.5;
            double overtimeamount = overtime * hoursrate;
            double gross = salary + overtimeamount;
            double net = gross - deduction;


            try (Connection conn = DatabaseConnector.connect()) {
                PreparedStatement preparedStatement = conn.prepareStatement(
                        "INSERT IGNORE INTO employees_salary (employee_id, employee_name, employee_position, employee_salary, employee_gross, employee_net, employee_totalDed,employee_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
                );

                preparedStatement.setInt(1, employee_id );
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, position);
                preparedStatement.setDouble(4, salary);
                preparedStatement.setDouble(5, gross);
                preparedStatement.setDouble(6, net);
                preparedStatement.setDouble(7, deduction);

                if (date == null) {
                    preparedStatement.setDate(8, null);
                } else if (date != null) {
                    preparedStatement.setDate(8, new java.sql.Date(date.getTime()));
                }

                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        Statement stmt = connection.createStatement();
        String q = "SELECT * FROM employees_salary";
        ResultSet r = stmt.executeQuery(q);

        while (r.next()) {
            int employeeid = r.getInt("employee_id");
            String fullname = r.getString("employee_name");
            String employeeposition = r.getString("employee_position");
            double gross = r.getDouble("employee_gross");
            double sal = r.getDouble("employee_salary");
            double net = r.getDouble("employee_net");
            double ded = r.getDouble("employee_totalDed");
            Date deducdate = r.getDate("employee_date");

            linkedList.addSalaryNode(employeeid, fullname, employeeposition, gross, ded, net, sal, deducdate, model);
        }
    }
}
