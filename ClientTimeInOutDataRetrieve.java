package payroll;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
public class ClientTimeInOutDataRetrieve {

    public static void fetchDataIntoInOutLinkedList(Connection connection, ClientTimeInOutLinked linkedList) throws SQLException {
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM dailytr";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {

            int employeeId = resultSet.getInt("employee_id");
            Date day = resultSet.getDate("day");
            Time timeInAM = resultSet.getTime("time_in_AM");
            Time timeOutAM = resultSet.getTime("time_out_AM");
            Time timeInPM = resultSet.getTime("time_in_PM");
            Time timeOutPM = resultSet.getTime("time_out_PM");
            int overtime = resultSet.getInt("overtime");
            //double overtimeRate = resultSet.getDouble("overtime_rate");

            linkedList.inoutNode(employeeId, day, timeInAM, timeOutAM, timeInPM, timeOutPM, overtime);
        }
    }
    public static void fetchDataIntoDTRLinkedList(Connection connection, ClientReportsLinked linkedList, DefaultTableModel model, int id, Date monthyear) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM dailytr WHERE employee_id = ? AND MONTH(day) = MONTH(?) AND YEAR(day) = YEAR(?)");
        preparedStatement.setInt(1, id);
        preparedStatement.setDate(2, monthyear);
        preparedStatement.setDate(3, monthyear);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int employeeId = resultSet.getInt("employee_id");
            Date day = resultSet.getDate("day");
            Time timeInAM = resultSet.getTime("time_in_AM");
            Time timeOutAM = resultSet.getTime("time_out_AM");
            Time timeInPM = resultSet.getTime("time_in_PM");
            Time timeOutPM = resultSet.getTime("time_out_PM");
            int overtime = resultSet.getInt("overtime");

            linkedList.dtrNode(employeeId, day, timeInAM, timeOutAM, timeInPM, timeOutPM, overtime, model);
        }
    }

}
