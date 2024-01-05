package payroll;


import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;
import java.io.*;
import java.net.ConnectException;
import java.sql.*;
import java.util.Random;


class empNode{


    public int id;
    public String empSur;
    public String empFirst;
    public Date empBirth;
    public String empSex;
    public String empDep;
    public String empPos;
    public Date empHired;
    public String empStat;
    public File image;


    public empNode next,prev;
    public empNode(String sName, String fName,Date birth,String sex,String pos,Date hired,String stat,File imgByte){
        this.empSur = sName;
        this.empFirst = fName;
        this.empBirth = birth;
        this.empSex = sex;
        this.empPos = pos;
        this.empHired = hired;
        this.empStat = stat;
        this.image = imgByte;
    }
    public String getEmpSur() {
        return empSur;
    }

    public String getEmpFirst() {
        return empFirst;
    }

    public Date getEmpBirth() {
        return empBirth;
    }

    public String getEmpSex() {
        return empSex;
    }

    public String getEmpDep() {
        return empDep;
    }

    public String getEmpPos() {
        return empPos;
    }

    public Date getEmpHired() {

        return empHired;
    }

    public File getImage() {
        return image;
    }

    public String getEmpStat() {
        return empStat;
    }
    public void displayLink() {
        System.out.print(
                "Last Name: " + empSur +
                        ",First Name: " + empFirst +
                        ", Date of Birth:"+empBirth+
                        ", Department: " + empDep+
                        ", Position: " + empPos +
                        ", Date Hired: " + empHired +
                        ", Status: "+ empStat+ ""
        );
        System.out.println();
    }
}


public class EmployeeLinked {
    public empNode head = null;
    public empNode last = null;
    //EmployeeAddDataRetrieve add = new EmployeeAddDataRetrieve();
    public boolean isEmpty(){
        return head == null;
    }
    private boolean isDuplicate(String SrName,String FrName) {
        empNode current = head;
        while (current != null) {
            if (current.getEmpSur().equals(SrName)&&current.getEmpFirst().equals(FrName)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void addNode(String sur, String first, Date birth, String sex, String post, Date hired, String stat, String path ){
        empNode newNode = new empNode(sur,first,birth,sex,post,hired,stat,new File(path));

        if(isDuplicate(newNode.getEmpSur(),newNode.getEmpFirst())){
            displayMessage("The "+ newNode.getEmpSur()+"and"+newNode.getEmpFirst() + " have already been added. Please try again." );
        }
        if(isEmpty()){
            head = newNode;
        }
        else {
            last.next = newNode;
            newNode.prev = last;
        }
        last = newNode;

        try(Connection connection = DatabaseConnector.connect()){
            String passGen = generatePass();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employee (firstname_employee, " +
                    "lastname_employee, date_of_birth, sex, position_name, date_hired, status, emp_prof, password)" +
                    " VALUES(?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, newNode.getEmpFirst());
            preparedStatement.setString(2,newNode.getEmpSur());
            preparedStatement.setDate(3,newNode.getEmpBirth());
            preparedStatement.setString(4,newNode.getEmpSex());
            preparedStatement.setString(5,newNode.getEmpPos());
            preparedStatement.setDate(6,newNode.getEmpHired());
            preparedStatement.setString(7,newNode.getEmpStat());

            try(InputStream is = new FileInputStream(newNode.getImage())){
                preparedStatement.setBlob(8,is);
                preparedStatement.setString(9,passGen);
                preparedStatement.executeUpdate();

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public void updateNode(int id,String sur, String first, Date birth, String sex, String post, Date hired, String stat){
        empNode current = head;

        while(current != null){
            current.empSur = sur;
            current.empFirst = first;
            current.empBirth = birth;
            current.empSex = sex;
            current.empPos = post;
            current.empHired = hired;
            current.empStat = stat;

            current =current.next;
        }

        try(Connection connection = DatabaseConnector.connect()){
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE employee " +
                    "SET firstname_employee = ?, " +
                    "lastname_employee = ?, " +
                    "date_of_birth = ?, " +
                    "sex = ? ," +
                    "position_name = ?, " +
                    "date_hired = ?, " +
                    "status = ? " +
                    "WHERE id = ?");
            preparedStatement.setString(1,first);
            preparedStatement.setString(2,sur);
            preparedStatement.setDate(3,birth);
            preparedStatement.setString(4,sex);
            preparedStatement.setString(5,post);
            preparedStatement.setDate(6,hired);
            preparedStatement.setString(7,stat);
            preparedStatement.setInt(8,id);
            preparedStatement.executeUpdate();


        }catch (SQLException e){
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Successfully Updated!", "Updated", JOptionPane.INFORMATION_MESSAGE);

    }
    public void updateNodePicture(int id,String sur, String first, Date birth, String sex, String post, Date hired, String stat, String path){
        empNode current = head;

        while(current != null){
            current.empSur = sur;
            current.empFirst = first;
            current.empBirth = birth;
            current.empSex = sex;
            current.empPos = post;
            current.empHired = hired;
            current.empStat = stat;
            current.image = new File(path);


            current =current.next;
        }

        try(Connection connection = DatabaseConnector.connect()){
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE employee " +
                    "SET firstname_employee = ?, " +
                    "lastname_employee = ?, " +
                    "date_of_birth = ?, " +
                    "sex = ? ," +
                    "position_name = ?, " +
                    "date_hired = ?, " +
                    "status = ?, " +
                    " emp_prof = ? WHERE id = ?");

            preparedStatement.setString(1,first);
            preparedStatement.setString(2,sur);
            preparedStatement.setDate(3,birth);
            preparedStatement.setString(4,sex);
            preparedStatement.setString(5,post);
            preparedStatement.setDate(6,hired);
            preparedStatement.setString(7,stat);


            try(InputStream is = new FileInputStream(path)){
                preparedStatement.setBlob(8,is);
                preparedStatement.setInt(9,id);
                preparedStatement.executeUpdate();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Successfully Updated!", "Updated", JOptionPane.INFORMATION_MESSAGE);

    }

    private void displayMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    private String generatePass(){
        Random random = new Random();
        int length = 5;
        StringBuilder pass = new StringBuilder();

        for(int i = 0; i<length;i++){
            int digit = random.nextInt(10);
            pass.append(digit);
        }
        return pass.toString();
    }

    public void searchNode(String name,DefaultTableModel model){
        model.setRowCount(0);
        empNode current = head;
        while(current !=null){
            if(current.getEmpSur().equals(name)||current.getEmpFirst().equals(name)){
                Object[] data = {current.getEmpSur(),current.empFirst,current.empDep,current.empPos,
                        current.empHired, current.empStat};
                model.addRow(data);
            }
            current = current.next;
        }

    }


    public empNode display(String fName){
        empNode current = head;
        while (current!=null){
            if(current.getEmpFirst().equals(fName)){
                return current;
            }
            current = current.next;
        }
        return null;
    }



}







