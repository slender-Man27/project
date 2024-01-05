package payroll;

import com.itextpdf.text.*;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.BaseColor;
import java.awt.Desktop;
import java.io.File;

import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Payslip extends JFrame implements ActionListener {
    private JLabel payslip,id,name,position,dateLabel,bas,over,Phil,pdF;
    private JLabel grossT,DeductT;

    private JButton back, generate;

    private int empID;


    private DefaultTableModel mode;
    private JTable table;

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();


    public void Payslip(int ID){
        this.empID = ID;

        frame.setTitle("Payslip");
        frame.setSize(1000,650);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        panel.setLayout(null);
        frame.add(panel);
        frame.add(panel2);

        panel.setSize(450,500);
        panel.setBounds(45,40,900,525);
        panel.setBackground(Color.white);

        panel2.setLayout(null);
        ImageIcon image = new ImageIcon("C:\\Users\\Tristan\\Pictures\\GUI\\Screenshot 2023-11-29 234119.png");
        // ImageIcon image = new ImageIcon("C:\\Users\\User\\Desktop\\PAYROLL FINAL FOLDER\\payroll\\src\\images\\Screenshot 2023-11-29 234119.png");
        JLabel background = new JLabel(image);
        background.setBounds(0,0, 1000, 720);
        panel2.add(background);

        //
        ImageIcon pdf = new ImageIcon("C:\\Users\\Tristan\\Pictures\\GUI\\360_F_380533515_CWsTHnDBMVgtNt3eCdHvdBkWgxNkTm9W.jpg");
        //ImageIcon pdf = new ImageIcon("C:\\Users\\User\\Desktop\\PAYROLL FINAL FOLDER\\payroll\\src\\images\\dwonload.png");
        Image size = pdf.getImage().getScaledInstance(50,50,Image.SCALE_REPLICATE);
        ImageIcon small = new ImageIcon(size);



        payslip = new JLabel("PAYSLIP");
        payslip.setFont(new Font("Barlow",Font.BOLD,20));
        payslip.setBounds(400,5,200,100);
        payslip.setForeground(Color.BLACK);

        id = new JLabel();
        id.setFont(new Font("Barlow",Font.PLAIN,16));
        id.setBounds(80,55,250,80);

        name = new JLabel();
        name.setFont(new Font("Barlow",Font.PLAIN,16));
        name.setBounds(80,75,250,80);

        position = new JLabel();
        position.setFont(new Font("Barlow",Font.PLAIN,16));
        position.setBounds(80,95,250,80);

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Barlow", Font.PLAIN, 16));
        dateLabel.setBounds(730, 73, 150, 30);
        panel.add(dateLabel);

        //Table content Labels

        pdF = new JLabel("Print Payslip :");
        pdF.setFont(new Font("Barlow",Font.BOLD,12));
        pdF.setBounds(80,430,100,100);
        //buttons

        generate = new JButton(small);
        generate.setBounds(200,460,50,50);
        generate.setBackground(Color.decode("#F5F5F5"));
        generate.addActionListener(this);


        back = new JButton("Back");
        back.setFont(new Font("Barlow",Font.BOLD,11));
        back.setBounds(700,470,100,30);
        back.setForeground(Color.white);
        back.setBackground(Color.decode("#26617E"));
        back.addActionListener(this);


        //

        //pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        //pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        try{
            fetchDataBase(String.valueOf(ID));
        }catch (SQLException e){
            e.printStackTrace();
        }


        panel.add(payslip);
        panel.add(id);
        panel.add(name);
        panel.add(position);
        panel.add(pdF);



        panel.add(generate);
        panel.add(back);



        frame.setVisible(true);

    }

//////////////////////////////////////
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(generate)){

            String path = " "+ "_Payslip.pdf";
            JFileChooser file = new JFileChooser();
            file.setFileSelectionMode(JFileChooser.FILES_ONLY);
            File folder = new File("C:\\Users\\User\\Desktop\\PAYROLL FINAL FOLDER\\payroll\\src\\Payslips");
            file.setCurrentDirectory(folder);
            int x = file.showSaveDialog(this);

            if(x ==JFileChooser.APPROVE_OPTION){
                path = file.getSelectedFile().getPath();
                JOptionPane.showMessageDialog(null,"Downloaded Successfully","MESSAGE",JOptionPane.INFORMATION_MESSAGE);

            }
            else if(x==JFileChooser.CANCEL_OPTION){
                JOptionPane.showMessageDialog(null,"Cancelled","MESSAGE",JOptionPane.INFORMATION_MESSAGE);
                return;
            }


            Document document = new Document();
            try {
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
                document.setPageSize(PageSize.A4);
                document.open();


                com.itextpdf.text.Font headEr = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 15, com.itextpdf.text.Font.BOLD,BaseColor.WHITE);
                com.itextpdf.text.Font cellfont = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 13, com.itextpdf.text.Font.ITALIC);
                com.itextpdf.text.Font totalfont = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12, com.itextpdf.text.Font.BOLDITALIC,BaseColor.WHITE);
                com.itextpdf.text.Font idFont = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 11, com.itextpdf.text.Font.BOLD);
                com.itextpdf.text.Font nameFont = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 11, com.itextpdf.text.Font.BOLD);
                com.itextpdf.text.Font positionFont = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 11, com.itextpdf.text.Font.BOLD);
                com.itextpdf.text.Font DateFont = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 13, com.itextpdf.text.Font.BOLD);
                BaseColor color = new BaseColor(45,133,143);

                addCenteredParagraph2(document,"PAYSLIP",Font.BOLD,20);
                addCenteredParagraph2(document," ",Font.BOLD,15);
                document.add(new Paragraph(id.getText(), idFont));
                document.add(new Paragraph(name.getText(), nameFont));
                document.add(new Paragraph(position.getText(), positionFont));
                PdfContentByte canvas = writer.getDirectContent();
                float xAxis = 450f;
                float yAxis = 735f;
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Paragraph(dateLabel.getText(),DateFont),xAxis,yAxis,0);

                addCenteredParagraph2(document," ",Font.BOLD,15);
                addCenteredParagraph2(document," ",Font.BOLD,15);



                PdfPTable pdfPTable = new PdfPTable(3);
                PdfPCell headerCell1 = new PdfPCell(new Phrase("Gross Salary", headEr));
                PdfPCell headerCell2 = new PdfPCell(new Phrase("Deductions", headEr));
                PdfPCell headerCell3 = new PdfPCell(new Phrase("Net Salary", headEr));

                headerCell1.setBackgroundColor(color);
                headerCell2.setBackgroundColor(color);
                headerCell3.setBackgroundColor(color);

                headerCell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                headerCell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                headerCell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                float headerRowHeight = 30;
                headerCell1.setFixedHeight(headerRowHeight);
                headerCell2.setFixedHeight(headerRowHeight);
                headerCell3.setFixedHeight(headerRowHeight);


                pdfPTable.addCell(headerCell1);
                pdfPTable.addCell(headerCell2);
                pdfPTable.addCell(headerCell3);



                pdfPTable.setHorizontalAlignment(Element.ALIGN_CENTER);

                pdfPTable.setWidthPercentage(100);
                pdfPTable.setWidths(new int[]{30, 30, 30});

                for (int i = 0; i < mode.getRowCount(); i++) {
                    for (int j = 0; j < mode.getColumnCount(); j++) {
                        Object cellValue = mode.getValueAt(i, j);
                        PdfPCell cell;
                        if (i <mode.getRowCount()-1  ) {
                            cell = new PdfPCell(new Phrase(cellValue !=null ? cellValue.toString():"",cellfont));
                            cell.setFixedHeight(60);
                        } else {
                            cell = new PdfPCell(new Phrase(cellValue !=null ? cellValue.toString():"",totalfont));
                            cell.setFixedHeight(30);
                            cell.setBackgroundColor(color);
                        }
                        pdfPTable.addCell(cell);
                    }

                }


                document.add(pdfPTable);
                File pdfFile = new File(path);
                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.OPEN)) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    System.out.println("Opening PDF file is not supported on this platform.");
                }



            }catch (FileNotFoundException ex){
                Logger.getLogger(Payslip.class.getName()).log(Level.SEVERE,null,ex);
            }catch (DocumentException | IOException ex){
                Logger.getLogger(Payslip.class.getName()).log(Level.SEVERE,null,ex);
            }

            document.close();

        }
        if(e.getSource() == back){
            ReportsSalary emSalary = new ReportsSalary();
            emSalary.ReportsSalary();
            emSalary.setVisible(true);
            frame.setVisible(false);
            dispose();
        }
    }

    private void addCenteredParagraph2(Document document, String text, int bold, int fontSize) throws DocumentException {
        Paragraph paragraph = new Paragraph(text, new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, fontSize, bold));
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);
    }

    static class ColoredRowRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            renderer.setBackground(Color.white);

            return renderer;
        }
    }
    static class NonEditableRowTableModel extends DefaultTableModel {
        public NonEditableRowTableModel(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            // Make all cells non-editable
            return false;
        }

    }


    public void fetchDataBase(String ID) throws SQLException{
        try(Connection connection = DatabaseConnector.connect()){
            Statement statement = connection.createStatement();
            String sql = "SELECT id, CONCat(firstname_employee,' ',lastname_employee) AS full_name, " +
                    "positions.position_name, positions.salary," +
                    "dailyTR.overtime, " +
                    "employees_salary.employee_salary, employee_deductions.deduction_date, " +
                    "employees_salary.employee_net  FROM employee " +
                    "LEFT JOIN positions ON employee.position_name = positions.position_name " +
                    "LEFT JOIN dailyTR ON employee.id = dailyTR.employee_id " +
                    "LEFT JOIN employee_deductions ON employee.id = employee_deductions.employee_id " +
                    "LEFT JOIN employees_salary ON employee.id = employees_salary.employee_id " +
                    "WHERE id = ?";

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setString(1,ID);
                ResultSet resultSet = preparedStatement.executeQuery();

                if(resultSet.next()){

                    String  iD = resultSet.getString("id");
                    String Name = resultSet.getString("full_name");
                    String pos = resultSet.getString("position_name");
                    Date dedDate = resultSet.getDate("deduction_date");
                    double sal = resultSet.getDouble("salary");
                    double oT = resultSet.getDouble("overtime");
                    double tSal = resultSet.getDouble("employee_salary");
                    double tNet = resultSet.getDouble("employee_net");




                    id.setText("ID: "+ iD);
                    name.setText("Name: "+Name);
                    position.setText("Position: "+pos);
                    dateLabel.setText("Date: "+ dedDate);
                    bas = new JLabel("Basic Salary : "+sal);
                    bas.setPreferredSize(new Dimension(250,80));

                    double hoursrate = 100 * 1.5;
                    double overtimeamount = oT * hoursrate;
                    double grossAmt = sal + overtimeamount;

                    over = new JLabel("Overtime : "+overtimeamount);
                    over.setPreferredSize(new Dimension(250,80));
                    Phil =new JLabel( );
                    Phil.setPreferredSize(new Dimension(250,80));
                    JLabel grossT = new JLabel("Total : "+tSal);
                    //JLabel grossT;
                    JLabel NetT;
                    String [] head = {"Gross Salary","Deductions","Net Salary"};


                    Statement statement1 = connection.createStatement();
                    String sqlCount = "SELECT COUNT(*) FROM deductions";
                    ResultSet countresultSet = statement1.executeQuery(sqlCount);
                    int count = 0;

                    if(countresultSet.next()){
                        count = countresultSet.getInt(1);
                        count++;
                    }

                    countresultSet.close();

                    String [][] data = new String[count+2][3];

                    double totalDed = 0;
                    int dataIndex = 0;

                    data[0][0] = bas.getText();
                    data[1][0] = over.getText();
                    //data[count+1][0] = grossT.getText();


                    //data[count+1][2] = NetT.getText();

                    //double totalDed =0;

                    String sql2 = "SELECT deduction_description, deduction_amount " +
                            "FROM employee_deductions " +
                            "WHERE employee_id = ? " +
                            "AND deduction_date = ? ";

                    try {

                        PreparedStatement pstmt = connection.prepareStatement(sql2);

                        pstmt.setInt(1, empID);
                        pstmt.setDate(2, dedDate);

                        resultSet = pstmt.executeQuery();


                        while (resultSet.next() && dataIndex < count) {
                            String description = resultSet.getString("deduction_description");
                            double amount = resultSet.getDouble("deduction_amount");
                            count++;
                            data[dataIndex][1] =description+": "+amount;
                            totalDed+=amount;
                            dataIndex++;
                        }

                        resultSet.close();
                        pstmt.close();
                    } catch (SQLException e) {

                        e.printStackTrace();
                    }
                    //DeductT = new JLabel("Total : "+totalDed );

                    //data[dataIndex+1][1] = DeductT.getText();

                    double totalnet = sal - totalDed;
                    //NetT = new JLabel("Total : "+ totalnet);
                    data[dataIndex + 1][0] = "Total Gross Salary: " + grossAmt;
                    data[dataIndex + 1][1] = "Total Deductions: " + totalDed;
                    data[dataIndex + 1][2] = "Total Net Salary: " + totalnet;

                    Phil = new JLabel();
                    Phil.setPreferredSize(new Dimension(250, 80));

                    this.table = new JTable();
                    this.mode = new NonEditableRowTableModel(data,head);
                    this.table.setModel(this.mode);
                    this.table.setSize(800,300);
                    this.table.setLocation(40,160);
                    this.table.setBackground(Color.white);
                    Font tableFont = new Font("Arial", Font.BOLD, 30);
                    this.table.setFont(tableFont);
                    table.setDefaultRenderer(Object.class, new ColoredRowRenderer() );

                    this.table.getTableHeader().setReorderingAllowed(false);
                    int grossIdx =0 , dedIdx = 1, netIdx = 2;
                    int HeaderH = 50;

                    TableColumn Gross = table.getColumnModel().getColumn(grossIdx);
                    Gross.setPreferredWidth(100);

                    TableColumn Ded = table.getColumnModel().getColumn(dedIdx);
                    Ded.setPreferredWidth(100);

                    TableColumn NEt = table.getColumnModel().getColumn(netIdx);
                    NEt.setPreferredWidth(100);

                    this.table.getTableHeader().setPreferredSize(new Dimension(100,HeaderH));
                    table.getTableHeader().setFont(new Font("Barlow",Font.BOLD,15));

                    for(int i = 0; i < mode.getRowCount();i++){
                        if(i<mode.getRowCount()-1) {
                            table.setRowHeight(i, 40);
                        }else{
                            table.setRowHeight(i, 50);
                        }
                    }


                    table.setFont(new Font("Barlow",Font.PLAIN,13));

                    JScrollPane pane = new JScrollPane(table);
                    pane.setBounds(80,155,750,290);
                    panel.add(pane);

                }
                resultSet.close();

            }
        }
    }

}

