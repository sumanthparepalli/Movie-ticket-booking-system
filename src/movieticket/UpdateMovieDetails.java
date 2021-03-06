/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieticket;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author parep
 */
public class UpdateMovieDetails extends javax.swing.JFrame {

    /**
     * Creates new form UpdateMovieDetails
     */
    public UpdateMovieDetails() {
        initComponents();
        setIconImage(new ImageIcon("clap.png").getImage());
    }

    public final TheModel getData() throws Exception {
        ArrayList<Mov> arr = new ArrayList<>();
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie", "root", "");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select s_no,movie_name,genre,hall_no,date_format(date,'%d-%m-%y') as date,time,poster from details");
        while (rs.next()) {
            arr.add(new Mov(rs.getInt("s_no"), rs.getString("movie_name"), rs.getString("genre"), rs.getInt("hall_no"), rs.getString("date"), rs.getString("time"), rs.getBytes("poster")));
        }
        String[] columns = {"S. NO", "Movie Name", "Genre", "Hall No", "Date", "Time", "Poster"};
        Object[][] rows = new Object[arr.size()][7];
        for (int i = 0; i < arr.size(); i++) {
            rows[i][0] = arr.get(i).getS_no();
            rows[i][1] = arr.get(i).getMovie_name();
            rows[i][2] = arr.get(i).getGenre();
            rows[i][3] = arr.get(i).getHall_no();
            rows[i][4] = arr.get(i).getDate();
            rows[i][5] = arr.get(i).getTime();
            if (arr.get(i).getPoster() != null) {
                ImageIcon image = new ImageIcon(new ImageIcon(arr.get(i).getPoster()).getImage()
                        .getScaledInstance(150, 120, Image.SCALE_SMOOTH));
                rows[i][6] = image;
            } else {
                rows[i][6] = null;
            }
        }
        TheModel mod = new TheModel(rows, columns);
        return mod;
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        del = new javax.swing.JButton();
        change = new javax.swing.JButton();
        cancel = new javax.swing.JButton();

        try{
            jTable1.setBackground(new java.awt.Color(153, 255, 153));
            jTable1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Engravers MT", 0, 18), new java.awt.Color(255, 153, 153))); // NOI18N
            jTable1.setForeground(new java.awt.Color(0, 0, 255));
            jTable1.setModel(getData());
            jTable1.setGridColor(new java.awt.Color(255, 102, 102));
        }
        catch (Exception e)
        {
        }
        jTable1.setRowHeight(120);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(150);
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        try{
            jTable2.setBackground(new java.awt.Color(153, 255, 153));
            jTable2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Engravers MT", 0, 18), new java.awt.Color(255, 153, 153))); // NOI18N
            jTable2.setForeground(new java.awt.Color(0, 0, 255));
            jTable2.setModel(getData());
            jTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
            jTable2.setGridColor(new java.awt.Color(255, 102, 102));
            jTable2.setRowHeight(120);

            org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTable1, org.jdesktop.beansbinding.ELProperty.create("5"), jTable2, org.jdesktop.beansbinding.BeanProperty.create("rowMargin"));
            bindingGroup.addBinding(binding);
            binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTable1, org.jdesktop.beansbinding.ELProperty.create("true"), jTable2, org.jdesktop.beansbinding.BeanProperty.create("showHorizontalLines"));
            bindingGroup.addBinding(binding);
            binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTable1, org.jdesktop.beansbinding.ELProperty.create("true"), jTable2, org.jdesktop.beansbinding.BeanProperty.create("showVerticalLines"));
            bindingGroup.addBinding(binding);

        }
        catch (Exception e)
        {
        }
        jTable1.setRowHeight(120);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(150);
        jScrollPane3.setViewportView(jTable2);

        del.setFont(new java.awt.Font("Perpetua Titling MT", 1, 13)); // NOI18N
        del.setIcon(new javax.swing.ImageIcon(getClass().getResource("/movieticket/cancel2.png"))); // NOI18N
        del.setText("Delete");
        del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delActionPerformed(evt);
            }
        });

        change.setFont(new java.awt.Font("Perpetua Titling MT", 1, 13)); // NOI18N
        change.setIcon(new javax.swing.ImageIcon(getClass().getResource("/movieticket/modify.png"))); // NOI18N
        change.setText("Change/Modify");
        change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeActionPerformed(evt);
            }
        });

        cancel.setFont(new java.awt.Font("Perpetua Titling MT", 1, 13)); // NOI18N
        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/movieticket/back.png"))); // NOI18N
        cancel.setText("Back");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(del)
                .addGap(40, 40, 40)
                .addComponent(change)
                .addGap(48, 48, 48)
                .addComponent(cancel)
                .addGap(42, 42, 42))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 861, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(del)
                    .addComponent(change)
                    .addComponent(cancel))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
        MovieOptions obj = new MovieOptions();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delActionPerformed
        // TODO add your handling code here:
        int ch = JOptionPane.showConfirmDialog(null, "Are you Sure?\n Note: This cant be retreived back.");
        if (ch != 0) {
            JOptionPane.showMessageDialog(null, "Operation Canceled");
            return;
        }

        if (jTable2.getSelectedRowCount() == 1) {
            int row = jTable2.getSelectedRow() + 1;
            String query = "delete from details where s_no=" + row;
            String query2 = "update details set s_no=s_no-1 where  s_no>" + row;
            String query3="delete from  seats where s_no="+row;
            String query4="update seats set s_no=s_no-1 where  s_no>" + row;
            String query5="delete from  seats where s_no="+row;
            String query6="update payment set mov_no=mov_no-1 where  mov_no>" + row;
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie", "root", "");
                Statement st = con.createStatement();
                int rs = st.executeUpdate(query);
                int rs1=st.executeUpdate(query3);
                int rs2=st.executeUpdate(query5);
                rs = st.executeUpdate(query2);
                st.executeUpdate(query4);
                st.executeUpdate(query6);
                JOptionPane.showMessageDialog(null, "Sucessfully Deleted");
                MovieOptions obj = new MovieOptions();
                obj.setVisible(true);
                dispose();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
                JOptionPane.showMessageDialog(null, "Check your Database connection!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cant operate on " + jTable2.getSelectedRowCount() + " rows\n Select One row");
        }
    }//GEN-LAST:event_delActionPerformed

    private void changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeActionPerformed
        if (jTable2.getSelectedRowCount() == 1) {
            int ch = JOptionPane.showConfirmDialog(null, "Are you Sure?\n Note: This may delete and add the movie to database again");
            if (ch == 0) {
                int row = jTable2.getSelectedRow() + 1;
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie", "root", "");
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("select s_no,movie_name,genre,hall_no,date_format(date,'%d-%m-%y') as date,time,poster from details where s_no=" + row);
                    rs.next();
                    AddMovieDetails obj = new AddMovieDetails();
                    obj.setVisible(false);
                    obj.movNam.setText(rs.getString("movie_name"));
                    obj.genre.setText(rs.getString("genre"));
                    obj.hall.setText(rs.getString("hall_no"));
                    obj.time.setText(rs.getString("time"));
                    obj.date.setText(rs.getString("date"));
                    byte[] i=rs.getBytes("poster");
                    ImageIcon img=new ImageIcon(i);
                    obj.label.setIcon(new ImageIcon(img.getImage().getScaledInstance(obj.label.getWidth(), obj.label.getHeight(), Image.SCALE_SMOOTH)));
                    obj.jButton1.setVisible(false);
                    String query = "delete from details where s_no=" + row;
                    String query2 = "update details set s_no=s_no-1 where  s_no>" + row;
                    String query3="delete from  seats where s_no="+row;
                    String query4="update seats set s_no=s_no-1 where  s_no>" + row;
                    String query5="delete from  seats where s_no="+row;
                    String query6="update payment set mov_no=mov_no-1 where  mov_no>" + row;
                    try 
                    {
                        int rs1 = st.executeUpdate(query);
                        int rs2=st.executeUpdate(query3);
                        int rs3=st.executeUpdate(query5);
                        JOptionPane.showMessageDialog(null, "Sucessfully Deleted");
                        rs1 = st.executeUpdate(query2);
                        st.executeUpdate(query4);
                        st.executeUpdate(query6);
//                        MovieOptions obj2 = new MovieOptions();
//                        obj2.setVisible(true);
                        dispose();
                        
                    } 
                    catch (SQLException ex) 
                    {
                        System.out.println(ex.toString());
                        JOptionPane.showMessageDialog(null, "Check your Database connection!");
                    }
                    obj.setVisible(true);
                    obj.jButton2.setText("Save Changes");
                    obj.jButton2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            obj.update(i);
                        }
                    });
                    
                    dispose();
                    obj.addWindowListener(new WindowAdapter() {
                        public void windowClosing(WindowEvent e) {
                            int ch = JOptionPane.showConfirmDialog(null, "Are you sure? \n    Note: Make sure that you saved the changes");
                            if (ch == 0) {
                                dispose();
                            }
                        }
                    });
                } 
                catch (SQLException ex) {
                    Logger.getLogger(UpdateMovieDetails.class.getName()).log(Level.SEVERE, null, ex);
                }

            } 
            else {
                JOptionPane.showMessageDialog(null, "Operation Canceled");
            }
        } 
        else {
            JOptionPane.showMessageDialog(null, "Cant operate on " + jTable2.getSelectedRowCount() + " rows\n Select One row");
        }
    }//GEN-LAST:event_changeActionPerformed

//    public ImageIcon ResizeImage(String imgPath) {
//        ImageIcon MyImage = new ImageIcon(imgPath);
//        Image img = MyImage.getImage();
//        Image newImage = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon image = new ImageIcon(newImage);
//        return image;
//    }
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
            java.util.logging.Logger.getLogger(UpdateMovieDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateMovieDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateMovieDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateMovieDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UpdateMovieDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JButton change;
    private javax.swing.JButton del;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}