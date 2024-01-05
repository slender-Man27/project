package payroll;

import java.sql.*;
//import payroll.PositionsLinked;
import javax.swing.table.DefaultTableModel;
public class PositionsDataRetrieve {
    
    
    public static void fetchDataIntoLinkedList(Connection connection, PositionsLinked linkedList, DefaultTableModel model) throws SQLException {
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM positions";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {

            String posname = resultSet.getString("position_name");
            String depart = resultSet.getString("department");
            double possal = resultSet.getDouble("salary");
            String postype = resultSet.getString("employee_type");
            String posstatus = resultSet.getString("position_status");
            
            linkedList.addNode(posname,depart, possal, postype,posstatus,model);
        }
    }
}