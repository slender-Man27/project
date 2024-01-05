package payroll;

import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.sql.Time;

class ClientReportsNode{
    public int employeeId;
    public Date day;
    public Time timeInAM;
    public Time timeOutAM;
    public Time timeInPM;
    public Time timeOutPM;
    public int overtimee;

    public ClientReportsNode next;
    public ClientReportsNode prev;

    public ClientReportsNode(int employeeId, Date day, Time timeInAM, Time timeOutAM, Time timeInPM, Time timeOutPM, int overtime) {
        this.employeeId = employeeId;
        this.day = day;
        this.timeInAM = timeInAM;
        this.timeOutAM = timeOutAM;
        this.timeInPM = timeInPM;
        this.timeOutPM = timeOutPM;
        this.overtimee = overtime;
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

}
public class ClientReportsLinked {

    public ClientReportsNode head;
    public ClientReportsNode last = null;

    public boolean isEmpty(){
        return head == null;
    }

    public void dtrNode(int id, Date day, Time timeInAM, Time timeOutAM, Time timeInPM, Time timeOutPM, int overtime, DefaultTableModel model){

        ClientReportsNode newNode = new ClientReportsNode(id,day,timeInAM,timeOutAM,timeInPM,timeOutPM,overtime);

        if(isEmpty()){
            head = newNode;
        }
        else{
            last.next = newNode;
            newNode.prev = last;
        }
        last = newNode;

        updateDTRTable(model);
    }

    public void updateDTRTable(DefaultTableModel model) {

        model.setRowCount(0);
        int count = 1;
        ClientReportsNode current = head;
        while (current != null) {
            Object[] data = {count, current.day, current.timeInAM, current.timeOutAM, current.timeInPM, current.timeOutPM, current.overtimee };
            model.addRow(data);
            count++;
            current = current.next;
        }
    }
}
