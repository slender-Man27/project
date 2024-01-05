package payroll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PayrollDB {

    static final String URL = "jdbc:mysql://localhost/";
    static final String user = "root";
    static final String pass = "";


    public void PayrollDB(){
        try{
            Connection con = DriverManager.getConnection(URL,user,pass);

        }catch (SQLException e){
            e.printStackTrace();
        }
        createDB();
        dbTable();
    }


    public void createDB(){
        try{
            Connection connection = DriverManager.getConnection(URL,user,pass);
            Statement statement = connection.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS payroll";
            statement.executeUpdate(sql);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void dbTable(){
        try {
            String URLDb = "jdbc:mysql://localhost/payroll";
            String USER = "root";
            String PASS ="";

            Connection connection = DriverManager.getConnection(URLDb,USER,PASS);
            Statement statement = connection.createStatement();

            ///
            String sql1 = "CREATE TABLE IF NOT EXISTS employee"+
                    "(id int(4) primary key auto_increment,"+
                    "firstname_employee varchar(100),"+
                    "lastname_employee varchar(100),"+
                    "date_of_birth date,"+
                    "sex varchar(50),"+
                    "department varchar(50),"+
                    "position_name varchar(50),"+
                    "employee_type varchar(50),"+
                    "salary double,"+
                    "date_hired date,"+
                    "status varchar(50),"+
                    "emp_prof LONGBLOB,"+
                    "password varchar(20),"+
                    "foreign key (position_name) references positions(position_name),"+
                    "foreign key(employee_type) references positions(position_name),"+
                    "foreign key(salary) references positions(position_name),"+
                    "foreign key(department) references positions(position_name))";

            String sq = "ALTER TABLE employee AUTO_INCREMENT =1000";

            statement.executeUpdate(sql1);
            statement.executeUpdate(sq);


            ///
            String sql2 = "CREATE TABLE IF NOT EXISTS positions"+
                    "(position_no int(4) unique key auto_increment,"+
                    "position_name varchar(50) primary key,"+
                    "department varchar(50),"+
                    "salary double,"+
                    "employee_type varchar(50),"+
                    "position_status varchar(50))";
            String s = "ALTER TABLE employee AUTO_INCREMENT = 1000";
            statement.executeUpdate(sql2);
            statement.executeUpdate(s);

            ///
            String sql3 = "CREATE TABLE IF NOT EXISTS deductions"+
                    "(deduction_description varchar(50) primary key,"+
                    "rate double,"+
                    "deduction_status varchar(50))";
            statement.executeUpdate(sql3);

            ///
            String sql4 = "CREATE TABLE IF NOT EXISTS dailyTR"+
                    "(employee_id int(4),"+
                    "day date,"+
                    "time_in_AM time,"+
                    "time_out_AM time,"+
                    "time_in_PM time,"+
                    "time_out_PM time,"+
                    "overtime int(10),"+
                    "foreign key(employee_id) references employee(id))";
            statement.executeUpdate(sql4);

            ///
            String sq15 = "CREATE TABLE IF NOT EXISTS employee_deductions " +
                    "(employee_id INT (4), " +
                    "deduction_date DATE, " +
                    "deduction_description VARCHAR(50), " +
                    "deduction_amount DOUBLE, " +
                    "FOREIGN KEY (employee_id) REFERENCES employee(id), " +
                    "FOREIGN KEY (deduction_description) REFERENCES deductions(description), " +
                    "UNIQUE (employee_id, deduction_date, deduction_description))";

            statement.executeUpdate(sq15);
            
            ///
            String sq16 = "CREATE TABLE IF NOT EXISTS employees_salary"+
                    "(employee_id int(4) primary key,"+
                    "employee_name varchar(50),"+
                    "employee_position varchar(50),"+
                    "employee_salary decimal(10,2),"+
                    "employee_gross decimal(10,2),"+
                    "employee_net decimal(10,2),"+
                    "employee_totalDed decimal(10,2), "+
                    "employee_date date,"+
                    "foreign key (employee_id) references employee(id))";
            statement.executeUpdate(sq16);

            
            String insertDeductions = "INSERT IGNORE INTO deductions (deduction_description, rate, deduction_status) " +
                          "VALUES ('Tax', 15.0, 'Active'), " +
                          "('Life Insurance', 10.0, 'Active'), " +
                          "('Pension', 8.0, 'Active'), " +
                          "('Health Insurance', 5.0, 'Active'), " +
                          "('Social Security', 3.0, 'Active')";
            statement.executeUpdate(insertDeductions);

            String insertDailyTR = "INSERT IGNORE INTO dailyTR (employee_id, day, time_in_AM, time_out_AM, time_in_PM, time_out_PM, overtime) " +
                       "VALUES (1001, '2024-01-02', '08:00:00', '12:00:00', '13:00:00', '17:00:00', 2), " +
                       "(1002, '2024-01-02', '09:30:00', '13:30:00', '14:30:00', '18:30:00', 1), " +
                       "(1003, '2024-01-02', '08:15:00', '12:15:00', '13:15:00', '17:15:00', 3), " +
                       "(1004, '2024-01-02', '10:00:00', '14:00:00', '15:00:00', '19:00:00', 2), " +
                       "(1005, '2024-01-02', '08:45:00', '12:45:00', '13:45:00', '17:45:00', 1)";
            statement.executeUpdate(insertDailyTR);
            
            String insertEmployeeDeductions = "INSERT IGNORE INTO employee_deductions (employee_id, deduction_date, deduction_description, deduction_amount) " +
                                  "VALUES (1000, '2023-12-28', 'Tax', 150.50), " +
                                  "(1001, '2023-12-28', 'Life Insurance', 200.00), " +
                                  "(1001, '2023-12-28', 'Tax', 200.00), " +
                                  "(1002, '2023-12-28', 'Pension', 200.00), " +
                                  "(1003, '2023-12-28', 'Health Insurance', 100.25), " +
                                  "(1004, '2023-12-28', 'Social Security', 75.00)";
            statement.executeUpdate(insertEmployeeDeductions);





        }catch (SQLException e){
            e.printStackTrace();
        }



    }

    public static void main(String[] args) {
        PayrollDB sql = new PayrollDB();
        sql.createDB();
        sql.dbTable();



    }

}


