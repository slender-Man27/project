package payroll;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
class EmployeeNode{

    public int employee_id;
    public String employee_first;
    public String employee_last;
    public String employee_depart;
    public String employee_position;
    public Date employee_hired;
    public String employee_status;
    public EmployeeNode next;
    public EmployeeNode prev;

    public EmployeeNode(int employee_id, String employee_first, String employee_last, String employee_depart, String employee_position, Date employee_hired, String employee_status){
        this.employee_id = employee_id;
        this.employee_first = employee_first;
        this.employee_last = employee_last;
        this.employee_depart = employee_depart;
        this.employee_position = employee_position;
        this.employee_hired = employee_hired;
        this.employee_status = employee_status;
        this.next = null;
        this.prev = null;
    }
    public int getEmpID() {
        return employee_id;
    }

    public String getEmpFirst() {
        return employee_first;
    }
    public String getEmpLast() {
        return employee_last;
    }
    public String getPos() {
        return employee_position;
    }
    public String getEmpDepart() {
        return employee_depart;
    }
    public Date getDateHired() {
        return employee_hired;
    }
    public String getEmpStat() {
        return employee_status;
    }
}
public class EmployeeLinkedList {
    EmployeeNode head;
    public EmployeeNode last = null;

    public boolean isEmpty(){
        return head == null;
    }
    public void addEmpNode(int employee_id, String employee_first, String employee_last, String employee_depart, String employee_position, Date employee_hired, String employee_status, DefaultTableModel model){
        EmployeeNode newNode = new EmployeeNode(employee_id,employee_first, employee_last, employee_depart, employee_position, employee_hired, employee_status);


        if(isEmpty()){
            head = newNode;
        }
        else{
            last.next = newNode;
            newNode.prev = last;
        }
        last = newNode;
    }
    public void searchNodeByID(int id,DefaultTableModel model){
        model.setRowCount(0);
        EmployeeNode current = head;
        while(current !=null){
            if(current.getEmpID() == id){
                Object[] data = {current.employee_id,current.employee_last,current.employee_first,current.employee_depart,
                        current.employee_position, current.employee_hired, current.employee_status};
                model.addRow(data);
            }
            current = current.next;
        }

    }
    public void searchNodeByName(String name,DefaultTableModel model){
        model.setRowCount(0);
        EmployeeNode current = head;
        while(current !=null){
            if(containsIgnoreCase(current.employee_first, name)||containsIgnoreCase(current.employee_last, name)){
                Object[] data = {current.employee_id,current.employee_last,current.employee_first,current.employee_depart,
                        current.employee_position, current.employee_hired, current.employee_status};
                model.addRow(data);
            }
            current = current.next;
        }

    }

    public void updateEmpNode(int employee_id, String employee_depart, String employee_position, double sal, String type) {
        try (Connection connection = DatabaseConnector.connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE employee " +
                            "SET department = ?, employee_type = ?, salary = ? " +
                            "WHERE employee_id = ? AND position_name = ? "
            );

            preparedStatement.setString(1, employee_depart);
            preparedStatement.setString(2, type);
            preparedStatement.setDouble(3, sal);
            preparedStatement.setInt(4, employee_id);
            preparedStatement.setString(5, employee_position);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean containsIgnoreCase(String source, String target) {
        return source.toLowerCase().contains(target.toLowerCase());
    }
}
