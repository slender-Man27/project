package payroll;

import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
//import java.util.Date;
class TimeInOutNode{
    public int employeeId;
    public Date day;
    public Time timeInAM;
    public Time timeOutAM;
    public Time timeInPM;
    public Time timeOutPM;
    public int overtimee;
    //public double overtimeRate;
    public TimeInOutNode next;
    public TimeInOutNode prev;

    public TimeInOutNode(int employeeId, Date day, Time timeInAM, Time timeOutAM, Time timeInPM, Time timeOutPM, int overtime) {
        this.employeeId = employeeId;
        this.day = day;
        this.timeInAM = timeInAM;
        this.timeOutAM = timeOutAM;
        this.timeInPM = timeInPM;
        this.timeOutPM = timeOutPM;
        this.overtimee = overtime;
        //this.overtimeRate = overtimeRate;
        this.next = null;
        this.prev = null;
    }
    public int getEmployeeId() {
        return employeeId;
    }

    public Date getDay() {
        return day;
    }

    public Time getTimeInAM() {
        return timeInAM;
    }

    public Time getTimeOutAM() {
        return timeOutAM;
    }

    public Time getTimeInPM() {
        return timeInPM;
    }

    public Time getTimeOutPM() {
        return timeOutPM;
    }

    public int getOvertime() {
        return overtimee;
    }

    //public double getOvertimeRate() {
        //return overtimeRate;
    //}

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public void setTimeInAM(Time timeInAM) {
        this.timeInAM = timeInAM;
    }

    public void setTimeOutAM(Time timeOutAM) {
        this.timeOutAM = timeOutAM;
    }

    public void setTimeInPM(Time timeInPM) {
        this.timeInPM = timeInPM;
    }

    public void setTimeOutPM(Time timeOutPM) {
        this.timeOutPM = timeOutPM;
    }

    public void setOvertime(int overtime) {
        this.overtimee = overtime;
    }

    //public void setOvertimeRate(double overtimeRate) {
       // this.overtimeRate = overtimeRate;
    //}


    public void displayLink() {
        System.out.print(
                "Name: " + employeeId +
                        ", Department: " + timeInAM +
                        ", Salary: " + timeOutAM +
                        ", Type: " + timeInPM +
                        ", Status: " + timeOutPM + " "
        );
        System.out.println();
    }

}
public class ClientTimeInOutLinked {
    public TimeInOutNode head;
    public TimeInOutNode last = null;

    public boolean isEmpty(){
        return head == null;
    }

    public void displayList() {
        TimeInOutNode current = head;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
    }
    private boolean isInOutDuplicate(int id, Date date) {
        try (Connection connection = DatabaseConnector.connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT COUNT(*) FROM dailytr WHERE employee_id = ? AND day = ?"
            );

            preparedStatement.setInt(1, id);
            preparedStatement.setDate(2, date);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    private boolean isSameDate(Date date1, Date date2) {
        LocalDate localDate1 = date1.toLocalDate();
        LocalDate localDate2 = date2.toLocalDate();

        return localDate1.isEqual(localDate2);
    }
    public void inoutNode(int id, Date day, Time timeInAM, Time timeOutAM, Time timeInPM, Time timeOutPM, int overtime){

        TimeInOutNode newNode = new TimeInOutNode(id,day,timeInAM,timeOutAM,timeInPM,timeOutPM,overtime);

        if(isEmpty()){
            head = newNode;
        }
        else{
            last.next = newNode;
            newNode.prev = last;
        }
        last = newNode;

    }

    public void inMorning(int id, Date day, Time timeInAM, Time timeOutAM, Time timeInPM, Time timeOutPM, int overtime){

        TimeInOutNode newNode = new TimeInOutNode(id,day,timeInAM,timeOutAM,timeInPM,timeOutPM,overtime);
        if (isInOutDuplicate(newNode.getEmployeeId(), newNode.getDay() )) {
            displayMessage("Already Clocked In/Out Today");
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
                    "INSERT INTO dailytr (employee_id, day,time_in_AM, time_out_AM, time_in_PM, time_out_PM, overtime) VALUES (?, ?, ?, ?, ?, ?, ?)"
            );

            preparedStatement.setInt(1, newNode.getEmployeeId());
            preparedStatement.setDate(2, newNode.getDay());
            preparedStatement.setTime(3, newNode.getTimeInAM());
            preparedStatement.setTime(4, newNode.getTimeOutAM());
            preparedStatement.setTime(5, newNode.getTimeInPM());
            preparedStatement.setTime(6, newNode.getTimeOutPM());
            preparedStatement.setInt(7, newNode.getOvertime());
            //preparedStatement.setDouble(8, newNode.getOvertimeRate());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        displayMessage("Good Morning! Successfully clocked in the morning.");
        displayList();
    }
    public void inAfternoon(int id, Date date, Time time) {

        Time timeInAM = null;
        Time timeOutAM = null;
        Time timeOutPM = null;
        int overtime = 0;
        double overtimeRate = 0.0;
        boolean alreadyClockedIn = false;

        TimeInOutNode current = head;

        while (current != null) {
            if (current.getEmployeeId() == id && isSameDate(current.getDay(), date)) {
                if (current.getTimeInPM() != null) {
                    displayMessage("Already clocked in this afternoon");
                    return;
                }
                if (current.getTimeOutAM() != null) {
                    current.setTimeInPM(time);
                    displayMessage("Good Afternoon! Successfully Clocked in.");

                    try (Connection connection = DatabaseConnector.connect()) {
                        PreparedStatement preparedStatement = connection.prepareStatement(
                                "UPDATE dailytr SET time_in_PM = ? WHERE employee_id = ? AND day = ?"
                        );

                        preparedStatement.setTime(1, time);
                        preparedStatement.setInt(2, id);
                        preparedStatement.setDate(3, date);
                        preparedStatement.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return;
                }else{
                    alreadyClockedIn = true;
                }
            }
            current = current.next;
        }
        if (!alreadyClockedIn) {
            TimeInOutNode newNode = new TimeInOutNode(id, date, timeInAM, timeOutAM, time, timeOutPM, overtime);

            if (isEmpty()) {
                head = newNode;
            } else {
                last.next = newNode;
                newNode.prev = last;
            }
            last = newNode;

            try (Connection connection = DatabaseConnector.connect()) {

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO dailytr (employee_id, day, time_in_AM, time_out_AM, time_in_PM, time_out_PM, overtime) VALUES (?, ?, ?, ?, ?, ?, ?)"
                );

                preparedStatement.setInt(1, newNode.getEmployeeId());
                preparedStatement.setDate(2, newNode.getDay());
                preparedStatement.setTime(3, newNode.getTimeInAM());
                preparedStatement.setTime(4, newNode.getTimeOutAM());
                preparedStatement.setTime(5, newNode.getTimeInPM());
                preparedStatement.setTime(6, newNode.getTimeOutPM());
                preparedStatement.setInt(7, newNode.getOvertime());

                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            displayMessage("Good Afternoon! Successfully Clocked in.");

        }
    }


    public void outMorning(int id, Date date, Time time) {
        TimeInOutNode current = head;

        while (current != null) {
            if (current.getEmployeeId() == id && isSameDate(current.getDay(), date)) {
                if (current.getTimeOutAM() != null) {
                    displayMessage("Already clocked out in the morning.");
                    return;
                }

                if (current.getTimeInAM() != null) {
                    current.setTimeOutAM(time);
                    displayMessage("Successfully Clocked Out in the Morning. Have a good day!");

                    try (Connection connection = DatabaseConnector.connect()) {
                        PreparedStatement preparedStatement = connection.prepareStatement(
                                "UPDATE dailytr SET time_out_AM = ? WHERE employee_id = ? AND day = ?"
                        );

                        preparedStatement.setTime(1, time);
                        preparedStatement.setInt(2, id);
                        preparedStatement.setDate(3, date);
                        preparedStatement.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return;
                } else {
                    displayMessage("Time in the morning not set yet.");
                    return;
                }
            }
            current = current.next;
        }

        displayMessage("No matching record found for the given ID and date.");
    }

    public void outAfternoon(int id, Date date, Time time) {
        TimeInOutNode current = head;

        while (current != null) {
            if (current.getEmployeeId() == id && isSameDate(current.getDay(), date)) {
                if (current.getTimeOutPM() != null) {
                    displayMessage("Already clocked out this afternoon");
                    return;
                } else if (current.getTimeInPM() != null) {
                    current.setTimeOutPM(time);
                    try (Connection connection = DatabaseConnector.connect()) {
                        PreparedStatement preparedStatement = connection.prepareStatement(
                                "UPDATE dailytr SET time_out_PM = ? WHERE employee_id = ? AND day = ?"
                        );

                        preparedStatement.setTime(1, time);
                        preparedStatement.setInt(2, id);
                        preparedStatement.setDate(3, date);
                        preparedStatement.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    displayMessage("Successfully clocked out this afternoon.");

                    overtime(id, date);

                    return;
                } else {
                    displayMessage("Time in the afternoon not set yet.");
                    return;
                }
            }
            current = current.next;
        }

        displayMessage("No matching record found for the given ID and date.");
    }

    public void overtime(int id, Date date) {

        TimeInOutNode current = head;

        while (current != null) {
            if (current.getEmployeeId() == id && isSameDate(current.getDay(), date)) {
                Time timeInAM = current.getTimeInAM();
                Time timeOutPM = current.getTimeOutPM();

                int overtime = calculateOvertime(timeInAM, timeOutPM);
                //double overtimerate = (overtime != 0) ? 100.0 / overtime : 0;

                try (Connection connection = DatabaseConnector.connect()) {
                    PreparedStatement preparedStatement = connection.prepareStatement(
                            "UPDATE dailytr SET overtime = ? WHERE employee_id = ? AND day = ?"
                    );

                    preparedStatement.setInt(1, overtime);
                    preparedStatement.setInt(2, id);
                    preparedStatement.setDate(3, date);
                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                return;
            }
            current = current.next;
        }

        displayMessage("No matching record found for the given ID and date.");
    }

    public int calculateHourDifference(Time start, Time end) {

        long milliseconds = end.getTime() - start.getTime();
        int hours = (int) (milliseconds / (1000 * 60 * 60));
        return hours;
    }

    public int calculateOvertime(Time timeInAM, Time timeOutPM) {
        final int REGULAR_WORK_HOURS = 8;

        if (timeInAM == null || timeOutPM == null) {
            return 0;
        }

        int totalWorkHours = calculateHourDifference(timeInAM, timeOutPM);
        int overtimeHours = totalWorkHours - REGULAR_WORK_HOURS;

        if (overtimeHours < 0) {
            overtimeHours = 0;
        }

        return overtimeHours;
    }


    public TimeInOutNode findNodeByIdAndDate(int id, Date date) {
        TimeInOutNode current = head;

        while (current != null) {
            if (current.getEmployeeId() == id && isSameDate(current.getDay(), date)) {
                return current;
            }
            current = current.next;
        }

        return null;
    }


    private void displayMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);

    }
}
