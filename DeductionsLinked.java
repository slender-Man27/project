package payroll;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

class DeducNode {
    
    public String deduc_descript;
    public double deduc_rate;
    public String deduc_status;
    public DeducNode next;
    public DeducNode prev;

    /*public Node() {
        this.pos_name = " ";
        this.pos_department = " ";
        this.pos_salary = 0.0;
        this.pos_emtype = " ";
        this.pos_status = " ";
        this.next = null;
        this.prev = null;
    }*/
    
    public DeducNode(String deducName, double deducRate, String deducStatus) {
        this.deduc_descript = deducName;
        this.deduc_rate = deducRate;
        this.deduc_status = deducStatus;
        this.next = null;
        this.prev = null;
    }

    public String getDeducName() {
        return deduc_descript;
    }
    
    public double getDeducRate() {
        return deduc_rate;
    }
    
    public String getDeducStatus() {
        return deduc_status;
    }

    public void displayLink() {
        System.out.print(
                "Name: " + deduc_descript +
                        ", Rate: " + deduc_rate +
                        ", Status: " + deduc_status + " "
        );
        System.out.println();
    }
}
public class DeductionsLinked {
    
    DeducNode head;
    public DeducNode last = null;

    public boolean isEmpty(){
        return head == null;
    }
    
    public void addDeducNode(String deducName, double deducRate, String deducStatus, DefaultTableModel model) {
        DeducNode newNode = new DeducNode(deducName,deducRate,deducStatus);

        if (isDeducDuplicate(newNode.getDeducName())) {
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
                    "INSERT INTO deductions (deduction_description, rate, deduction_status) VALUES (?, ?, ?)"
            );

            preparedStatement.setString(1, newNode.getDeducName());
            preparedStatement.setDouble(2, newNode.getDeducRate());
            preparedStatement.setString(3, newNode.getDeducStatus());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {

        }
             //displayMessage("The position name " + newNode.getPosName() + " successfully added." );
             updateDeducTable(model);
        //Object[] row = {newNode.getPosName(), newNode.getPosDepartment(), newNode.getPosSalary(), newNode.getPosType(), newNode.getPosStatus()};
        //model.addRow(row);
    }
    
    private boolean isDeducDuplicate(String deducName) {
        DeducNode current = head;
        while (current != null) {
            if (current.getDeducName().equals(deducName)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    public void updateDeducTable(DefaultTableModel model) {

        model.setRowCount(0);

        DeducNode current = head;
        while (current != null) {
            Object[] data = {current.deduc_descript, current.deduc_rate, current.deduc_status};
            model.addRow(data);
            current = current.next;
        }
    }
    
        public void updateDeducNode(String oldDeducName, String newDeducName, double newDeducRate, String newDeducStatus) {
        DeducNode current = head;

        while (current != null) {
            if (current.deduc_descript.equals(oldDeducName)) {
                current.deduc_descript = newDeducName;
                current.deduc_rate = newDeducRate;
                current.deduc_status = newDeducStatus;
                
                break;
            }

            current = current.next;
        }

        try (Connection connection = DatabaseConnector.connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE deductions SET deduction_description = ?, rate = ?, deduction_status = ? WHERE deduction_description = ?"

            );

            preparedStatement.setString(1, newDeducName);
            preparedStatement.setDouble(2, newDeducRate);
            preparedStatement.setString(3, newDeducStatus);
            preparedStatement.setString(4, oldDeducName);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {

        }

        displayMessage("Successfully Updated!");

    }
        
     public void deleteDeducNode(String oldDeducName) {
        DeducNode current = head;

        while (current != null && !current.deduc_descript.equals(oldDeducName)) {
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
                    "DELETE FROM deductions WHERE description = ?"
            );

            preparedStatement.setString(1, oldDeducName);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {

        }

        displayMessage("Successfully Deleted!");
    }
    
     public DeducNode searchDeducNode(String deducName) {
        DeducNode current = head;
        while (current != null) {
            if (current.getDeducName().equals(deducName)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    public void bubbleSortBySalary() {
        if (head == null || head.next == null) {
            return;
        }

        boolean swapped;
        DeducNode temp;
        DeducNode current;

        do {
            swapped = false;
            current = head;

            while (current.next != null) {
                if (current.deduc_rate > current.next.deduc_rate) {
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

        updateDeducTable(model);
    }
    
    private void displayMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    
    
    
}
