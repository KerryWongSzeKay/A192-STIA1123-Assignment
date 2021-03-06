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
public class EditFrame extends javax.swing.JFrame {

    ArrayList<BiodataRecord> biodata;
    ArrayList<SurveyRecord> survey;
    
    public EditFrame() {
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edit Frame");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.setForeground(new java.awt.Color(240, 240, 240));

        jPanel4.setBackground(new java.awt.Color(255, 255, 153));

        jComboBox1.setBackground(new java.awt.Color(255, 204, 51));
        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "       < SELECT TYPE OF STATUS >", "Single", "Married", "Divorced", "Engaged", "Widowed" }));

        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        jTextField6.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N

        jTextField7.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N

        jButton1.setBackground(new java.awt.Color(255, 204, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("RESET ALL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 204, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("UPDATE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 153));
        jLabel8.setText("Marital Status         :");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 153));
        jLabel11.setText("E-mail Address        :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 153));
        jLabel9.setText("Address                    :");

        jTextField1.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N

        jTextField2.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 153));
        jLabel7.setText("( DD/MM/YYYY )  ");

        jTextField3.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel.setFont(new java.awt.Font("Algerian", 1, 65)); // NOI18N
        jLabel.setForeground(new java.awt.Color(153, 0, 51));
        jLabel.setText("EDIT RECORD");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Name                        :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("Contact Number     :");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 153));
        jLabel12.setText("Date Of Birth           :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("Gender                     :");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 153));
        jLabel10.setText("Nationality               :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("Survey Result         :");

        jTextField8.setEditable(false);
        jTextField8.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N

        jComboBox2.setBackground(new java.awt.Color(255, 204, 51));
        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "             < SELECT GENDER >", "Male", "Female" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 102));
        jLabel5.setText("Click Here To Go Back MENU");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel6.setText("*Survey Result Cannot Edit*");

        jLabel13.setText("*please input in one line*");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4)
                            .addComponent(jComboBox1, 0, 248, Short.MAX_VALUE)
                            .addComponent(jTextField2)
                            .addComponent(jTextField1)
                            .addComponent(jTextField3)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(4, 4, 4)
                        .addComponent(jLabel7))
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                        .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jButton1)
                        .addGap(36, 36, 36)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel12))
                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        Table.setBackground(new java.awt.Color(153, 255, 153));
        Table.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        Table.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
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
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        jTextArea2.setEditable(false);
        jTextArea2.setBackground(new java.awt.Color(255, 204, 204));
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 955, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        // TODO add your handling code here:
        int i = Table.getSelectedRow();
        jTextArea2.setText("");
        jTextField1.setText(model.getValueAt(i, 0).toString());
        jTextField2.setText(model.getValueAt(i, 1).toString());
        jTextField3.setText(model.getValueAt(i, 2).toString());
        jComboBox2.setSelectedItem(model.getValueAt(i, 3).toString());
        jComboBox1.setSelectedItem(model.getValueAt(i, 4).toString());
        jTextArea1.setText(model.getValueAt(i, 5).toString());
        jTextField6.setText(model.getValueAt(i, 6).toString());
        jTextField7.setText(model.getValueAt(i, 7).toString());
        jTextField8.setText(model.getValueAt(i, 8).toString());
        
            String name = model.getValueAt(i, 0).toString();
            String contact = model.getValueAt(i, 1).toString();
            String date = model.getValueAt(i, 2).toString();
            String gender = model.getValueAt(i, 3).toString();
            String status = model.getValueAt(i, 4).toString();
            String nation = model.getValueAt(i, 6).toString();
            String address = model.getValueAt(i, 5).toString();
            String email = model.getValueAt(i, 7).toString();
            String watch = model.getValueAt(i, 8).toString();
            
        Font font = new Font("Monospaced", Font.BOLD, 19);
        jTextArea2.setFont(font);         
        jTextArea2.append("::::: Record Survey For Type Of Watch That Customer Prefer :::::"
           +"\n\nName              : "+name
           +"\nContact Number    : "+contact
           +"\nDate Of Birthday  : "+date
           +"\nGender            : "+gender
           +"\nMarital Status    : "+status
           +"\nAddress           : "+address
           +"\nNationality       : "+nation
           +"\nEmail Address     : "+email
           +"\nSurvey Result     : "+watch);

    }//GEN-LAST:event_TableMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (evt.getSource()== jButton2){
            int row = Table.getSelectedRow();
            if(row>=0){
              String name = biodata.get(row).getName();
              String contact =biodata.get(row).getContact();
              String date = biodata.get(row).getDate();
              String gender = biodata.get(row).getGender();
              String status = biodata.get(row).getStatus();
              String address = biodata.get(row).getAddress();
              String nation = biodata.get(row).getNation();
              String email = biodata.get(row).getEmail();
             

              if(!jComboBox1.getSelectedItem().equals("       < SELECT TYPE OF STATUS >")){
                  if(!jComboBox2.getSelectedItem().equals("             < SELECT GENDER >")){
                      String editname = jTextField1.getText();
                      String editcontact = jTextField2.getText();
                      String editdate = jTextField3.getText();
                      String editgender = jComboBox2.getSelectedItem().toString();
                      String editstatus = jComboBox1.getSelectedItem().toString();
                      String editaddress = jTextArea1.getText();
                      String editnationality = jTextField6.getText();
                      String editemail = jTextField7.getText();
                      
                      biodata.get(row).setName(editname);
                      biodata.get(row).setContact(editcontact);
                      biodata.get(row).setDate(editdate);
                      biodata.get(row).setGender(editgender);
                      biodata.get(row).setStatus(editstatus);
                      biodata.get(row).setAddress(editaddress);
                      biodata.get(row).setNation(editnationality);
                      biodata.get(row).setEmail(editemail);
                      
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
                          for(int j=0;j<biodata.size();j++){
                              Writer.write(String.format("| %-19s| %-14s | %-14s| %-6s | %-15s| %-70s | %-14s | %-23s| %-15s|%n", biodata.get(j).getName(),biodata.get(j).getContact(),biodata.get(j).getDate(),biodata.get(j).getGender(),biodata.get(j).getStatus(),biodata.get(j).getAddress(),biodata.get(j).getNation(),biodata.get(j).getEmail(),survey.get(j).getWatch()));
                              Writer.write("|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|\n");
                          }
                          Writer.close();
                      } catch (IOException ex) {
                          Logger.getLogger(ProgramFunction.class.getName()).log(Level.SEVERE, null, ex);
                     }
                      saveBiodataToFile();
                      model.setValueAt(jTextField1.getText(), row, 0);
                      model.setValueAt(jTextField2.getText(), row, 1);
                      model.setValueAt(jTextField3.getText(), row, 2);
                      model.setValueAt(jComboBox2.getSelectedItem(), row, 3);
                      model.setValueAt(jComboBox1.getSelectedItem(), row, 4);
                      model.setValueAt(jTextArea1.getText(), row, 5);
                      model.setValueAt(jTextField6.getText(), row, 6);
                      model.setValueAt(jTextField7.getText(), row, 7);
                        jTextArea2.setText("");
                        String n = model.getValueAt(row, 0).toString();
                        String c = model.getValueAt(row, 1).toString();
                        String d = model.getValueAt(row, 2).toString();
                        String g = model.getValueAt(row, 3).toString();
                        String s = model.getValueAt(row, 4).toString();
                        String nt = model.getValueAt(row, 6).toString();
                        String a = model.getValueAt(row, 5).toString();
                        String e = model.getValueAt(row, 7).toString();
                        String watch = model.getValueAt(row, 8).toString();
                        Font font = new Font("Monospaced", Font.BOLD, 19);
                        jTextArea2.setFont(font);         
                        jTextArea2.append("::::: Record Survey For Type Of Watch That Customer Prefer :::::"
                           +"\n"     
                           +"\nName              : "+n
                           +"\nContact Number    : "+c
                           +"\nDate Of Birthday  : "+d
                           +"\nGender            : "+g
                           +"\nMarital Status    : "+s
                           +"\nAddress           : "+a
                           +"\nNationality       : "+nt
                           +"\nEmail Address     : "+e
                           +"\nSurvey Result     : "+watch);

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
                  
              }
            if(jTextField1.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Please Input ( Name ) to Update");
            }
            if(jTextField2.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Please Input ( Contact Number ) to Update");
            }
            if(jTextField3.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Please Input ( Date Of Birth ) to Update");
            }
            if(jTextField6.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Please Input ( Nationality ) to Update");
            }
            if(jTextField7.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Please Input ( E-mail Address ) to Update");
            }
            if(jComboBox1.getSelectedItem().equals("       < SELECT TYPE OF STATUS >"))
            {
                JOptionPane.showMessageDialog(null,"Please Select (Marital Status) to Update");
            }
            if(jComboBox2.getSelectedItem().equals("             < SELECT GENDER >"))
            {
                JOptionPane.showMessageDialog(null,"Please Select (Gender) to Update");
            }
            if(jTextArea1.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Please Input ( Address ) to Update");
            }
          }
          else{
          JOptionPane.showMessageDialog(null,"UPDATE ERROR !!!");
          }
            
      }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (evt.getSource()== jButton1){
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField6.setText("");
            jTextField7.setText("");
            jTextArea1.setText("");
            jComboBox1.setSelectedIndex(0);
            jComboBox2.setSelectedIndex(0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        if (evt.getSource()== jLabel5){
            this.dispose();
            MenuFrame p=new MenuFrame();
            p.setVisible(true);
        }
    }//GEN-LAST:event_jLabel5MouseClicked

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
            java.util.logging.Logger.getLogger(EditFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditFrame().setVisible(true);
            }
        });
    }
    
    private final DefaultTableModel model;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables


}
