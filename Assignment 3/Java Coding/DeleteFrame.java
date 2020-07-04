/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package watch;

import java.awt.Color;
import java.awt.Font;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;


/**
 *
 * @author User
 */
public class DeleteFrame extends javax.swing.JFrame {

     ArrayList<BiodataRecord> biodata;
    ArrayList<SurveyRecord> survey;
    
    public DeleteFrame() {
        initComponents();
        biodata = new ArrayList<BiodataRecord>();
        survey = new ArrayList<SurveyRecord>();
        populateArrayList();
        
        model = new DefaultTableModel(){
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        };
 
        Table.setModel(model);
        model.addColumn("NAME");
        model.addColumn("CONTACT NUMBER");
        model.addColumn("DATE OF BIRTH");
        model.addColumn("GENDER");
        model.addColumn("MARITAL STATUS");
        model.addColumn("ADDRESS");
        model.addColumn("NATIONALITY");
        model.addColumn("E-MAIL");
        model.addColumn("SURVEY RESULT");
        
        JTableHeader header = Table.getTableHeader();
        header.setBackground(new Color(0,51,153));
        header.setForeground(Color.black);
        header.setFont(new Font("Trebuchet MS",Font.BOLD, 12));
        header.setOpaque(false);
        Table.setRowHeight(23);
        Table.setFont(new Font("Times New Roman",Font.BOLD, 14));
        
        for(int i=0;i<survey.size();i++){
                Object[] objs = {biodata.get(i).getName(),biodata.get(i).getContact(),biodata.get(i).getDate(),biodata.get(i).getGender(),biodata.get(i).getStatus(),biodata.get(i).getAddress(),biodata.get(i).getNation(),biodata.get(i).getEmail(),survey.get(i).getWatch()};
                model.addRow(objs);
        }
        TableColumnModel modelecolonne=Table.getColumnModel();
        TableModel modele = Table.getModel();
        int total = modelecolonne.getColumnCount();
        for(int y=0 ;y<total;y++){
            int taille=0;
            int total2= modele.getRowCount();
            for(int j=0;j<total2;j++){
                if(modele.getValueAt(j, y)!=null){
                    int taille2=modele.getValueAt(j, y).toString().length()*5;
                    if(taille2>taille){
                        taille=taille2;
                    }
                }modelecolonne.getColumn(y).setPreferredWidth(taille);
            }
        }

    }
     public void populateArrayList(){
        try{
            FileInputStream file = new FileInputStream("biodata.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);
            
            boolean endOfFile = false;
            
            while(!endOfFile){
                try{
                    biodata.add((BiodataRecord)inputFile.readObject());
                }
                catch(EOFException e){
                    endOfFile= true;
                }
                catch(Exception f){
                    JOptionPane.showMessageDialog(null, f.getMessage());
                }
            }
            inputFile.close();
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        try{
            FileInputStream file2 = new FileInputStream("survey.dat");
            ObjectInputStream inputFile2 = new ObjectInputStream(file2);
            
            boolean endOfFile = false;
            
            while(!endOfFile){
                try{
                    survey.add((SurveyRecord)inputFile2.readObject());
                }
                catch(EOFException e){
                    endOfFile= true;
                }
                catch(Exception f){
                    JOptionPane.showMessageDialog(null, f.getMessage());
                }
            }
            inputFile2.close();
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
      public void saveBiodataToFile(){
      try{
          FileOutputStream file = new FileOutputStream("biodata.dat");
          ObjectOutputStream outputFile = new ObjectOutputStream(file);
          
          for(int i=0; i<biodata.size();i++){
              outputFile.writeObject(biodata.get(i));
          }
          outputFile.close();
      } 
      catch(IOException e){
          JOptionPane.showMessageDialog(null, e.getMessage());
          
      }
      
    }
       public void saveSurveyToFile(){
      try{
          FileOutputStream file = new FileOutputStream("survey.dat");
          ObjectOutputStream outputFile = new ObjectOutputStream(file);
          
          for(int i=0; i<survey.size();i++){
              outputFile.writeObject(survey.get(i));
          }
          outputFile.close();
      } 
      catch(IOException e){
          JOptionPane.showMessageDialog(null, e.getMessage());
          
      }
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DeleteFrame");
        setAutoRequestFocus(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));

        Table.setBackground(new java.awt.Color(255, 204, 204));
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "CONTACT NUMBER", "DATE OF BIRTH", "GENDER", "MARITAL STATUS", "ADDRESS", "NATIONALITY", "E-MAIL", "SURVEY RESULT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table.setGridColor(new java.awt.Color(0, 0, 0));
        Table.setRowHeight(23);
        Table.setSelectionBackground(new java.awt.Color(0, 102, 204));
        Table.setShowGrid(true);
        jScrollPane1.setViewportView(Table);

        jButton1.setBackground(new java.awt.Color(204, 153, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setText("Back to MENU");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Bauhaus 93", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Delete Record Survey");

        jButton2.setBackground(new java.awt.Color(204, 153, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1330, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(513, 513, 513)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (evt.getSource()== jButton1){
            this.dispose();
            MenuFrame p=new MenuFrame();
            p.setVisible(true);
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (evt.getSource()== jButton2){
            int row = Table.getSelectedRow();
            if (row>=0){
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this,"\"Are You Comfirm to Delete the Item ?\"","Delete",dialogButton);

            if(dialogResult ==0){

                model.removeRow(row); 
                survey.remove(row);                              
                biodata.remove(row);
                saveBiodataToFile();
                saveSurveyToFile();
 
                FileWriter Writer = null;
                try {
                    File f = new File("Customer Survey Record.txt");
                    if(f.exists()){
                        f.delete();
                    }   
                    Writer = new FileWriter(f);
                    Writer.write("****************************************************************************\n");
                    Writer.write(":::::: SYSTEM TO RECORD SURVEY FOR TYPE OF WATCH THAT CUSTOMER PREFER ::::::\n");
                    Writer.write("****************************************************************************\n");
                    Writer.write(String.format("=====================================================================================================================================================================================================================%n"));
                    Writer.write(String.format("| %-19s| %-14s | %-14s| %-6s | %-15s| %-70s | %-14s | %-23s| %-15s|%n", "NAME","CONTACT NUMBER","DATE OF BIRTH","GENDER","MARITAL STATUS","ADDRESS","NATIONALITY","E-MAIL","SURVEY RESULT"));
                    Writer.write(String.format("=====================================================================================================================================================================================================================%n"));
                    for(int i=0;i<survey.size();i++){
                    Writer.write(String.format("| %-19s| %-14s | %-14s| %-6s | %-15s| %-70s | %-14s | %-23s| %-15s|%n", biodata.get(i).getName(),biodata.get(i).getContact(),biodata.get(i).getDate(),biodata.get(i).getGender(),biodata.get(i).getStatus(),biodata.get(i).getAddress(),biodata.get(i).getNation(),biodata.get(i).getEmail(),survey.get(i).getWatch()));
                    Writer.write("|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|\n");                                                           
                    }                    
                    Writer.close();
                    } catch (IOException ex) {
                    Logger.getLogger(ProgramFunction.class.getName()).log(Level.SEVERE, null, ex);
                    }

                model.setRowCount(0);
                for(int i=0;i<survey.size();i++){
                Object[] objs = {biodata.get(i).getName(),biodata.get(i).getContact(),biodata.get(i).getDate(),biodata.get(i).getGender(),biodata.get(i).getStatus(),biodata.get(i).getAddress(),biodata.get(i).getNation(),biodata.get(i).getEmail(),survey.get(i).getWatch()};
                model.addRow(objs);
                }
                 
              }

            }
            else{                                                         
                JOptionPane.showMessageDialog(null,"Delete ERROR , Please Try Again !");

            } 

        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(DeleteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeleteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeleteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeleteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeleteFrame().setVisible(true);
                
            }
        });
    }
    private final DefaultTableModel model;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
