
package payroll;
import java.awt.event.ActionListener;
public class ReportsMenu extends javax.swing.JFrame implements ActionListener {

    public void ReportsMenu() {
        initComponents();
        buttonSalary.addActionListener(this);
        buttonEmployees.addActionListener(this);
        buttonBack.addActionListener(this);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        buttonSalary = new javax.swing.JButton();
        buttonEmployees = new javax.swing.JButton();
        buttonBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 650));
        setMinimumSize(new java.awt.Dimension(1000, 650));
        setPreferredSize(new java.awt.Dimension(1000, 603));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(38, 94, 124));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-admin-100.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("REPORTS MENU");

        buttonSalary.setBackground(new java.awt.Color(51, 153, 153));
        buttonSalary.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        buttonSalary.setForeground(new java.awt.Color(255, 255, 255));
        buttonSalary.setText("Salary Reports");
        buttonSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalaryActionPerformed(evt);
            }
        });

        buttonEmployees.setBackground(new java.awt.Color(51, 153, 153));
        buttonEmployees.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        buttonEmployees.setForeground(new java.awt.Color(255, 255, 255));
        buttonEmployees.setText("Employee List");

        buttonBack.setBackground(new java.awt.Color(51, 153, 153));
        buttonBack.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        buttonBack.setForeground(new java.awt.Color(255, 255, 255));
        buttonBack.setText("Back");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(407, 407, 407)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonSalary, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(buttonEmployees, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(440, 440, 440)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(421, 421, 421)
                        .addComponent(jLabel2)))
                .addContainerGap(439, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(buttonSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(buttonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonSalaryActionPerformed


    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() == buttonSalary) {
            ReportsSalary salre = new ReportsSalary();
            salre.ReportsSalary();
            salre.setVisible(true);
            setVisible(false);
            dispose();
        }
        else if(e.getSource() == buttonEmployees){
            ReportsEmployees emrep = new ReportsEmployees();
            emrep.ReportsEmployees();
            emrep.setVisible(true);
            setVisible(false);
            dispose();
        }
        else if(e.getSource() == buttonBack){
            AdminMenu admin = new AdminMenu();
            admin.AdminMenu();
            admin.setVisible(true);
            setVisible(false);
            dispose();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBack;
    private javax.swing.JButton buttonEmployees;
    private javax.swing.JButton buttonSalary;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
