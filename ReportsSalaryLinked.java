
package payroll;

import java.util.*;
import java.util.Date;
import javax.print.DocFlavor;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

class SalaryNode {

    public int employee_id;
    public String name;
    public String position;
    public double gross;
    public double deduction;
    public double net;
    public Date date;
    public SalaryNode next;
    public SalaryNode prev;

    public SalaryNode(int employee_id, String name, String position, double gross, double deduction, double net, Date date) {
        this.employee_id = employee_id;
        this.name = name;
        this.position = position;
        this.gross = gross;
        this.deduction = deduction;
        this.net = net;
        this.date = date;
        this.next = null;
        this.prev = null;
    }

    public int getEmployeeId() {
        return employee_id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getGross() {
        return gross;
    }

    public double getDeduction() {
        return deduction;
    }

    public double getNet() {
        return net;
    }

    public Date getDate() {
        return date;
    }

    public void displayLink() {
        System.out.println("Employee ID: " + employee_id);
        System.out.println("Name: " + name);
        System.out.println("Position: " + position);
        System.out.println("Gross Salary: " + gross);
        System.out.println("Deduction: " + deduction);
        System.out.println("Net Salary: " + net);
        System.out.println("Date: " + date);
        System.out.println();
    }
}

public class ReportsSalaryLinked {

    SalaryNode head;
    public SalaryNode last = null;

    public boolean isEmpty(){
        return head == null;
    }

    public void addSalaryNode(int employee_id, String name, String position, double gross, double deduction, double net, double sal, Date date, DefaultTableModel model) {
        SalaryNode newNode = new SalaryNode(employee_id, name, position, gross,deduction, net, date);

        if (isSalaryDuplicate(employee_id,date)) {
            //displayMessage("The deduction for employee ID " + employee_id + " on date " + date + " has already been added. Please try again.");
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

        updateSalaryTable(model);
    }

    public void updateSalaryTable(DefaultTableModel model) {

        model.setRowCount(0);

        SalaryNode current = head;
        while (current != null) {
            Object[] data = {current.employee_id, current.name, current.position, current.gross, current.deduction, current.net, current.date };
            model.addRow(data);
            current = current.next;
        }
    }

    public boolean isSalaryDuplicate(int employeeId, Date date) {
        SalaryNode current = head;
        while (current != null) {
            Date currentDate = current.getDate();
            if (current.getEmployeeId() == employeeId && (currentDate != null && currentDate.equals(date))) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void filterByMonth(int month, DefaultTableModel model) {
        model.setRowCount(0);

        SalaryNode current = head;
        while (current != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(current.getDate());
            int nodeMonth = cal.get(Calendar.MONTH) + 1;

            if (nodeMonth == month) {
                Object[] data = {
                        current.employee_id, current.name, current.position,
                        current.gross, current.deduction, current.net, current.date
                };
                model.addRow(data);
            }
            current = current.next;
        }
    }


    public void filterByQuarter(int quarter, DefaultTableModel model) {
        model.setRowCount(0);

        SalaryNode current = head;
        while (current != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(current.getDate());
            int nodeMonth = cal.get(Calendar.MONTH) + 1;
            int nodeQuarter = (nodeMonth - 1) / 3 + 1; // Calculate quarter

            if (nodeQuarter == quarter) {
                Object[] data = {
                        current.employee_id, current.name, current.position,
                        current.gross, current.deduction, current.net, current.date
                };
                model.addRow(data);
            }
            current = current.next;
        }
    }
    public void filterByYear(int year, DefaultTableModel model) {
        model.setRowCount(0);

        SalaryNode current = head;
        while (current != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(current.getDate());
            int nodeYear = cal.get(Calendar.YEAR);

            if (nodeYear == year) {
                Object[] data = {
                        current.employee_id, current.name, current.position,
                        current.gross, current.deduction, current.net, current.date
                };
                model.addRow(data);
            }
            current = current.next;
        }
    }
    public void searchNodeByID(int id,DefaultTableModel model){
        model.setRowCount(0);
        SalaryNode current = head;
        while(current !=null){
            if(current.getEmployeeId() == id){
                Object[] data = {current.employee_id, current.name, current.position,
                        current.gross, current.deduction, current.net, current.date
                };
                model.addRow(data);
            }
            current = current.next;
        }

    }
    public void searchNodeByName(String name,DefaultTableModel model){
        model.setRowCount(0);
        SalaryNode current = head;
        while(current !=null){
            if(containsIgnoreCase(current.getName(), name)){
                Object[] data = {
                        current.employee_id, current.name, current.position,
                        current.gross, current.deduction, current.net, current.date
                };
                model.addRow(data);
            }
            current = current.next;
        }

    }
    public void bubbleSortBySalary() {
        if (head == null || head.next == null) {
            return;
        }

        boolean swapped;
        SalaryNode temp;
        SalaryNode current;

        do {
            swapped = false;
            current = head;

            while (current.next != null) {
                if (current.net > current.next.net) {
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

        updateSalaryTable(model);
    }
    private boolean containsIgnoreCase(String source, String target) {
        return source.toLowerCase().contains(target.toLowerCase());
    }

    private void displayMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "MESSAGE",JOptionPane.INFORMATION_MESSAGE);
    }

}
