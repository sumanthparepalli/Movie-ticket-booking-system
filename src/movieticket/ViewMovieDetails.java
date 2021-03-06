/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieticket;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author parep
 */
public class ViewMovieDetails extends javax.swing.JFrame {

    /**
     * Creates new form ViewMovieDetails2
     */
    public ViewMovieDetails() {
        initComponents();
        setIconImage(new ImageIcon("clap.png").getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        try{
            jTable1.setBackground(new java.awt.Color(153, 255, 153));
            jTable1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Engravers MT", 0, 18), new java.awt.Color(255, 153, 153))); // NOI18N
            jTable1.setForeground(new java.awt.Color(0, 0, 255));
            jTable1.setModel(getData());
            jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            jTable1.setGridColor(new java.awt.Color(255, 51, 51));

            org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTable1, org.jdesktop.beansbinding.ELProperty.create("true"), jTable1, org.jdesktop.beansbinding.BeanProperty.create("showHorizontalLines"));
            bindingGroup.addBinding(binding);
            binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTable1, org.jdesktop.beansbinding.ELProperty.create("true"), jTable1, org.jdesktop.beansbinding.BeanProperty.create("showVerticalLines"));
            bindingGroup.addBinding(binding);

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Check Your Database Connection!");
        }
        jTable1.setRowHeight(120);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(150);
        jScrollPane3.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 13)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/movieticket/back.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1011, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        new MovieOptions().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    public final TheModel getData() {
        try {
            ArrayList<Mov> arr=new ArrayList<>();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie", "root", "");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select s_no,movie_name,genre,hall_no,date_format(date,'%d-%m-%y') as date,time,poster from details");
            while(rs.next())
            {
                arr.add(new Mov(rs.getInt("s_no"),rs.getString("movie_name"),rs.getString("genre"),rs.getInt("hall_no"),rs.getString("date"),rs.getString("time"),rs.getBytes("poster")));
            }
            String[] columns={"S. NO","Movie Name","Genre","Hall No","Date","Time","Poster"};
            Object[][] rows=new Object[arr.size()][7];
            for (int i = 0; i < arr.size(); i++) {
                rows[i][0]=arr.get(i).getS_no();
                rows[i][1]=arr.get(i).getMovie_name();
                rows[i][2]=arr.get(i).getGenre();
                rows[i][3]=arr.get(i).getHall_no();
                rows[i][4]=arr.get(i).getDate();
                rows[i][5]=arr.get(i).getTime();
                if (arr.get(i).getPoster()!= null) {
                    ImageIcon image = new ImageIcon(new ImageIcon(arr.get(i).getPoster()).getImage()
                            .getScaledInstance(150, 120, Image.SCALE_SMOOTH));
                    rows[i][6] = image;
                } else {
                    rows[i][6] = null;
                }
            }
            TheModel mod=new TheModel(rows,columns);
            return mod;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            JOptionPane.showMessageDialog(null, "Check database connection");
        }
        return null;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewMovieDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMovieDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMovieDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMovieDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewMovieDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
