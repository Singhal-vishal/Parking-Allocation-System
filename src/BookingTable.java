
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BookingTable extends javax.swing.JFrame {
public BookingTable() {
        initComponents();
        showRecords();
       }
    DefaultTableModel dtm;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Guard Id", "Car No.", "Slot No.", "Name", "Gender", "Mobile No.", "Entry Time", "Car Type"
            }
        ));
        jScrollPane4.setViewportView(jTable1);

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 370));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Search By Car No.");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 130, 20));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("Delete");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, -1, -1));

        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, 130, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 780, 500));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parking-allocation-planning.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 857, 546));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    //    public void showTableRecords() //display query
//    {
//        try 
//        {
//            Class.forName("com.mysql.jdbc.Driver");   
//            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
//            PreparedStatement st=con.prepareStatement("Select * from cardetail");
//            ResultSet rs=st.executeQuery();
//            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
//         } 
//            catch (SQLException | ClassNotFoundException ex){}
//    }
    
    public void showRecords() //display query
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");   
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
            PreparedStatement st=con.prepareStatement("Select * from cardetail");
            ResultSet rs=st.executeQuery();
            dtm=(DefaultTableModel)jTable1.getModel();
                     // jComboBox3.removeAllItems();
            while(rs.next())
           {
                Object obj[]={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)};
                dtm.addRow(obj);
                //jComboBox3.addItem(rs.getString(2)); //multiple time add ho raha hai
            }
       } 
            catch (SQLException | ClassNotFoundException ex){}
    }
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String item=(String)jComboBox3.getSelectedItem();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
            PreparedStatement st=con.prepareStatement("delete from cardetail where carNo=?");
            st.setString(1,item);
            st.executeUpdate();
            JOptionPane.showMessageDialog(this,"Record is Deletd");
            dtm.setNumRows(0);
            showRecords();
        }
        catch (SQLException | ClassNotFoundException ex) {

        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed

    }//GEN-LAST:event_jComboBox3ActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookingTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
