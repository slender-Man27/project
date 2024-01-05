package payroll;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

class Node {
    
    public String pos_name;
    public String pos_department;
    public double pos_salary;
    public String pos_emtype;
    public String pos_status;
    public Node next;
    public Node prev;

    /*public Node() {
        this.pos_name = " ";
        this.pos_department = " ";
        this.pos_salary = 0.0;
        this.pos_emtype = " ";
        this.pos_status = " ";
        this.next = null;
        this.prev = null;
    }*/
    public Node(String name, String depart, double sal, String type, String status) {
        this.pos_name = name;
        this.pos_department = depart;
        this.pos_salary = sal;
        this.pos_emtype = type;
        this.pos_status = status;
        this.next = null;
        this.prev = null;
    }

    public String getPosName() {
        return pos_name;
    }

    public String getPosDepartment() {
        return pos_department;
    }

    public double getPosSalary() {
        return pos_salary;
    }

    public String getPosType() {
        return pos_emtype;
    }

    public String getPosStatus() {
        return pos_status;
    }

    public void displayLink() {
        System.out.print(
                "Name: " + pos_name +
                        ", Department: " + pos_department +
                        ", Salary: " + pos_salary +
                        ", Type: " + pos_emtype +
                        ", Status: " + pos_status + " "
        );
        System.out.println();
    }
}


public class PositionsLinked {
    Node head;
    public Node last = null;

    public boolean isEmpty(){
        return head == null;
    }

    public void addNode(String name, String depart, double sal, String type, String status, DefaultTableModel model) {
        Node newNode = new Node(name,depart,sal,type,status);

        if (isDuplicate(newNode.getPosName())) {
            displayMessage("The position name " + newNode.getPosName() + " have already been added. Please try again." );
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
                    "INSERT INTO positions (position_name, department, salary, employee_type, position_status) VALUES (?, ?, ?, ?, ?)"
            );

            preparedStatement.setString(1, newNode.getPosName());
            preparedStatement.setString(2, newNode.getPosDepartment());
            preparedStatement.setDouble(3, newNode.getPosSalary());
            preparedStatement.setString(4, newNode.getPosType());
            preparedStatement.setString(5, newNode.getPosStatus());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {

        }
             //displayMessage("The position name " + newNode.getPosName() + " successfully added." );
             updateTable(model);
        //Object[] row = {newNode.getPosName(), newNode.getPosDepartment(), newNode.getPosSalary(), newNode.getPosType(), newNode.getPosStatus()};
        //model.addRow(row);


    }

    private boolean isDuplicate(String posName) {
        Node current = head;
        while (current != null) {
            if (current.getPosName().equals(posName)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void displayList() {
        Node current = head;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
    }

    public void updateTable(DefaultTableModel model) {

        model.setRowCount(0);


        Node current = head;
        while (current != null) {
            Object[] data = {current.pos_name, current.pos_department, current.pos_salary, current.pos_emtype, current.pos_status};
            model.addRow(data);
            current = current.next;
        }
    }

    public void updateNode(String oldPosName, String newPosName, String newPosDepartment, double newPosSalary,String newPosEmtype, String newPosStatus) {
        Node current = head;

        while (current != null) {
            if (current.pos_name.equals(oldPosName)) {
                current.pos_name = newPosName;
                current.pos_department = newPosDepartment;
                current.pos_salary = newPosSalary;
                current.pos_emtype = newPosEmtype;
                current.pos_status = newPosStatus;

                break;
            }

            current = current.next;
        }

        try (Connection connection = DatabaseConnector.connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE positions SET position_name = ?, department = ?, salary = ?, employee_type = ?, position_status = ? WHERE position_name = ?"

            );

            preparedStatement.setString(1, newPosName);
            preparedStatement.setString(2, newPosDepartment);
            preparedStatement.setDouble(3, newPosSalary);
            preparedStatement.setString(4, newPosEmtype);
            preparedStatement.setString(5, newPosStatus);
            preparedStatement.setString(6, oldPosName);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {

        }

        displayMessage("Successfully Updated!");

    }


    public void deleteNode(String oldPosName) {
        Node current = head;

        while (current != null && !current.pos_name.equals(oldPosName)) {
            current = current.next;
        }

        if (current == null) {
            displayMessage("No match found");
            return;
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            last = current.prev;
        }

        try (Connection connection = DatabaseConnector.connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM positions WHERE position_name = ?"
            );

            preparedStatement.setString(1, oldPosName);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {

        }

        displayMessage("Successfully Deleted!");
    }
    public void bubbleSortBySalary() {
        if (head == null || head.next == null) {
            return;
        }

        boolean swapped;
        Node temp;
        Node current;

        do {
            swapped = false;
            current = head;

            while (current.next != null) {
                if (current.pos_salary > current.next.pos_salary) {
                    temp = current.next;
                    current.next = temp.next;
                    if (temp.next != null) {
                        temp.next.prev = current;
                    }
                    temp.prev = current.prev;
                    if (current.prev != null) {
                        current.prev.next = temp;
                    } else {
                        head = temp;
                    }
                    current.prev = temp;
                    temp.next = current;

                    swapped = true;
                } else {
                    current = current.next;
                }
            }
        } while (swapped);
    }

    public void displaySortedValues(DefaultTableModel model) {

        bubbleSortBySalary();

        updateTable(model);
    }

    public Node searchNode(String posName) {
        Node current = head;
        while (current != null) {
            if (current.getPosName().equals(posName)) {
                return current;
            }
            current = current.next;
        }

        return null;
    }


    private void displayMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "MESSAGE",JOptionPane.INFORMATION_MESSAGE);
        }
    }

