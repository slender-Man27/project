package payroll;
import javax.swing.table.DefaultTableModel;
import java.util.*;
class ReportEmployees{

    public int sr_num;
    public int employee_id;
    public String employee_fullName;

    public String employee_first;
    public String employee_last;
    public String employee_depart;
    public String employee_position;

    public String employee_status;
    public Date datehired;
    public ReportEmployees next;
    public ReportEmployees prev;

    public ReportEmployees(int sr,int employee_id, String employee_full, String employee_depart, String employee_position, String employee_status, Date datehired){
        this.sr_num = sr;
        this.employee_id = employee_id;
        this.employee_fullName = employee_full;
        this.employee_depart = employee_depart;
        this.employee_position = employee_position;
        this.employee_status = employee_status;
        this.datehired = datehired;
        this.next = null;
        this.prev = null;
    }

    public int getSr_num() {
        return sr_num;
    }

    public int getEmpID() {
        return employee_id;
    }

    public String getEmpFull() {
        return employee_fullName;
    }
    public String getEmployee_first(){
        return employee_first;
    }

    public String getEmployee_last() {
        return employee_last;
    }

    public String getPos() {
        return employee_position;
    }
    public String getEmpDepart() {
        return employee_depart;
    }
    public String getEmpStat() {
        return employee_status;
    }

    public Date getDateHired() {
        return datehired;
    }

}
public class ReportEmployeeList {
    ReportEmployees head;
    public ReportEmployees last = null;

    public boolean isEmpty() {
        return head == null;
    }

    public void addEmpListNode(int sr, int employee_id, String employee_full, String employee_depart, String employee_position, String employee_status, Date datehired ,DefaultTableModel model) {
        ReportEmployees newNode = new ReportEmployees(sr, employee_id, employee_full, employee_depart, employee_position, employee_status, datehired);


        if (isEmpty()) {
            head = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
        }
        last = newNode;
    }

    public void updateSalaryTable(DefaultTableModel model) {

        model.setRowCount(0);
        int seriesno = 1;
        ReportEmployees current = head;
        while (current != null) {
            Object[] data = {seriesno, current.employee_id, current.getEmpFull(), current.employee_depart,
                    current.employee_position, current.employee_status};
            seriesno++;
            model.addRow(data);
            current = current.next;
        }
    }

    public void filterByMonth(int month, DefaultTableModel model) {
        model.setRowCount(0);
        int seriesno = 1;
        ReportEmployees current = head;
        while (current != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(current.getDateHired());
            int nodeMonth = cal.get(Calendar.MONTH) + 1;

            if (nodeMonth == month) {
                Object[] data = {seriesno, current.employee_id, current.getEmpFull(), current.employee_depart,
                        current.employee_position, current.employee_status};
                seriesno++;
                model.addRow(data);
            }
            current = current.next;
        }
    }

    public void filterByQuarter(int quarter, DefaultTableModel model) {
        model.setRowCount(0);
        int seriesno = 1;
        ReportEmployees current = head;
        while (current != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(current.getDateHired());
            int nodeMonth = cal.get(Calendar.MONTH) + 1;
            int nodeQuarter = (nodeMonth - 1) / 3 + 1; // Calculate quarter

            if (nodeQuarter == quarter) {
                Object[] data = {seriesno, current.employee_id, current.getEmpFull(), current.employee_depart,
                                current.employee_position, current.employee_status};
                seriesno++;
                model.addRow(data);

            }
                current = current.next;
            }
        }


        public void filterByYear ( int year, DefaultTableModel model){
            model.setRowCount(0);
            int seriesno = 1;
            ReportEmployees current = head;
            while (current != null) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(current.getDateHired());
                int nodeYear = cal.get(Calendar.YEAR);

                if (nodeYear == year) {
                    Object[] data = {seriesno, current.employee_id, current.getEmpFull(), current.employee_depart,
                            current.employee_position, current.employee_status};
                    seriesno++;
                    model.addRow(data);
                }
                current = current.next;
            }
        }
        public void searchNode ( int id, DefaultTableModel model){
            model.setRowCount(0);
            int seriesno = 1;
            ReportEmployees current = head;
            while (current != null) {
                if (current.getEmpID() == id) {
                    Object[] data = {seriesno, current.employee_id, current.getEmpFull(), current.employee_depart,
                            current.employee_position, current.employee_status};
                    seriesno++;
                    model.addRow(data);
                }
                current = current.next;
            }

        }

        public void searchNodeByName (String name, DefaultTableModel model){
            model.setRowCount(0);
            int seriesno = 1;
            ReportEmployees current = head;
            while (current != null) {
                if (containsIgnoreCase(current.getEmpFull(), name)) {
                    Object[] data = {seriesno, current.employee_id, current.getEmpFull(), current.employee_depart,
                            current.employee_position, current.employee_status};
                    seriesno++;
                    model.addRow(data);
                }
                current = current.next;
            }

        }
        private boolean containsIgnoreCase (String source, String target){
            return source.toLowerCase().contains(target.toLowerCase());
        }
    }

