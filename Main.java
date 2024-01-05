package payroll;

public class Main {

    public static void main(String[] args) {
        PayrollDB ob = new PayrollDB();
        ob.PayrollDB();
        LogInPayroll login = new LogInPayroll();
        login.LogInPayroll();
        login.setVisible(true);
        
    }
}
