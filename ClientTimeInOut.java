
package payroll;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import java.sql.Time;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.time.LocalTime;


public class ClientTimeInOut extends javax.swing.JFrame implements ActionListener{

    ClientTimeInOutLinked inout = new ClientTimeInOutLinked();
    private ClientTimeInOutDataRetrieve inoutdb = new ClientTimeInOutDataRetrieve();
    private int emp_id;
    public void ClientTimeInOut(int employee_id) {
        this.emp_id = employee_id;
        initComponents();
        databaseRetrieval();
        backButton.addActionListener(this);
        timeinButton.addActionListener(this);
        timeoutButton.addActionListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        timeinLabel = new javax.swing.JLabel();
        timeoutLabel = new javax.swing.JLabel();
        timeinButton = new javax.swing.JButton();
        timeoutButton = new javax.swing.JButton();
        timeoutTF = new javax.swing.JTextField();
        timeinTF = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(38, 94, 124));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel1.setText("TIME IN/OUT");

        timeinLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        timeinLabel.setText("Time In:");

        timeoutLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        timeoutLabel.setText("Time Out:");

        timeinButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        timeinButton.setText("Clock In");

        timeoutButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        timeoutButton.setText("Clock Out");

        timeinTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeinTFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(timeinButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(timeoutLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                .addComponent(timeinLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(47, 47, 47)
                            .addComponent(timeoutButton))
                        .addComponent(jLabel1))
                    .addComponent(timeoutTF))
                .addGap(56, 56, 56))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(59, 59, 59)
                    .addComponent(timeinTF, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(52, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(timeinLabel)
                .addGap(64, 64, 64)
                .addComponent(timeinButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeoutLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(timeoutTF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(timeoutButton)
                .addContainerGap(63, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(155, 155, 155)
                    .addComponent(timeinTF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(220, Short.MAX_VALUE)))
        );

        backButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(330, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(328, 328, 328))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addGap(40, 40, 40))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(backButton)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backButtonActionPerformed

    private void timeinTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeinTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timeinTFActionPerformed
    public void databaseRetrieval() {
        try (Connection connection = DatabaseConnector.connect()) {
            inoutdb.fetchDataIntoInOutLinkedList(connection, inout);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == backButton) {


            Client client = new Client();
            client.ClientView(emp_id);
            client.setVisible(true);
            setVisible(false);
            dispose();
        } else if (e.getSource() == timeinButton) {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
            Date now = new Date();
            String currentTime = dateFormat.format(now);
            timeinTF.setText(currentTime);


            SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date daynow = new Date();
            String currentDay = dateFormat.format(daynow);

            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            Date timenow = new Date();
            String currentTimee = timeFormat.format(timenow);

            try {
                Date morIn = timeFormat.parse("07:00:00");
                Date morInend = timeFormat.parse("11:59:00");
                Date aftIn = timeFormat.parse("19:00:00");
                Date aftInend = timeFormat.parse("24:59:00");

                Date currentTimeDate = timeFormat.parse(currentTimee);

                if (currentTimeDate.after(morIn) && currentTimeDate.before(morInend)) {
                    Time timeOutAM = null;
                    Time timeInPM = null;
                    Time timeOutPM = null;
                    int overtime = 0;
                    double overtimeRate = 0.0;
                    //System.out.println("in mor");
                    inout.inMorning(emp_id, new java.sql.Date(daynow.getTime()), java.sql.Time.valueOf(currentTimee),timeOutAM, timeInPM, timeOutPM, overtime);
                } else if (currentTimeDate.after(aftIn) && currentTimeDate.before(aftInend)) {
                    //System.out.println("in aft");
                    inout.inAfternoon(emp_id, new java.sql.Date(daynow.getTime()), java.sql.Time.valueOf(currentTimee));
                } else{
                    JOptionPane.showMessageDialog(null, "Unable to Clock In at the moment", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (ParseException ex) {
                ex.printStackTrace();

            }


        } else if (e.getSource() == timeoutButton) {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
            Date now = new Date();
            String currentTime = dateFormat.format(now);
            timeoutTF.setText(currentTime);

            SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date daynow = new Date();
            String currentDay = dayFormat.format(daynow);

            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            Date timenow = new Date();
            String currentTimee = timeFormat.format(timenow);

            try {
                Date morOut = timeFormat.parse("12:00:00");
                Date morOutend = timeFormat.parse("12:44:00");
                Date aftOut = timeFormat.parse("16:00:00");
                Date aftOutend = timeFormat.parse("18:00:00");

                Date currentTimeDate = timeFormat.parse(currentTimee);

                if (currentTimeDate.after(morOut) && currentTimeDate.before(morOutend)) {
                    //System.out.println("out mor");
                    inout.outMorning(emp_id, new java.sql.Date(daynow.getTime()), java.sql.Time.valueOf(currentTimee));
                } else if (currentTimeDate.after(aftOut) && currentTimeDate.before(aftOutend)) {
                    //System.out.println("out aft");
                    inout.outAfternoon(emp_id, new java.sql.Date(daynow.getTime()), java.sql.Time.valueOf(currentTimee));

                } else {
                    JOptionPane.showMessageDialog(null, "Unable to Clock Out at the moment", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (ParseException ex) {
                ex.printStackTrace();
            }

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton timeinButton;
    private javax.swing.JLabel timeinLabel;
    private javax.swing.JTextField timeinTF;
    private javax.swing.JButton timeoutButton;
    private javax.swing.JLabel timeoutLabel;
    private javax.swing.JTextField timeoutTF;
    // End of variables declaration//GEN-END:variables
}
