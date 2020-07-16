/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LifeStyle;

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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import java.text.*;
import javax.swing.JComboBox;

/**
 *
 * @author User
 */
public class AddCart extends javax.swing.JFrame {
        ArrayList<Product> products;
        ArrayList<LoginRecord> login;
        LoginForm lf =new LoginForm();
        ArrayList<String> loginList = lf.getloginList();
        DecimalFormat formatter;
    /**
     * Creates new form AddCart
     */
    public AddCart() {
        initComponents();
        products = new ArrayList<Product>();
        login = new ArrayList<LoginRecord>();
        populateArrayList();
        formatter = new DecimalFormat("#####.00");
        
        model = new DefaultTableModel(){
            Class[] types = new Class [] {
                java.lang.String.class,java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        };
        Table.setModel(model);
        model.addColumn("CATEGORY");
        model.addColumn("ITEM DISCRIPTION");
        model.addColumn("QUANTITY");
        model.addColumn("PRICE (RM)");
        
        JTableHeader header = Table.getTableHeader();
        header.setBackground(new Color(0,51,153));
        header.setForeground(Color.black);
        header.setFont(new Font("Trebuchet MS",Font.BOLD, 12));
        header.setOpaque(false);
        Table.setRowHeight(23);
        Table.setFont(new Font("Times New Roman",Font.BOLD, 14));
        
        for(int i=0;i<products.size();i++){
                Object[] objs = {products.get(i).getCategory(),products.get(i).getItem(),products.get(i).getQuantity(),formatter.format(products.get(i).getPrice())};
                model.addRow(objs);
        }
        
        //auto resize table column
        TableColumnModel modelecolonne=Table.getColumnModel();
        TableModel modele = Table.getModel();
        int t = modelecolonne.getColumnCount();
        for(int y=0 ;y<t;y++){
            int taille=0;
            int total2= modele.getRowCount();
            for(int j=0;j<total2;j++){
                if(modele.getValueAt(j, y)!=null){
                    int taille2=modele.getValueAt(j, y).toString().length()*6;
                    if(taille2>taille){
                        taille=taille2;
                    }
                }modelecolonne.getColumn(y).setPreferredWidth(taille);
            }
        }
        
    }
public void populateArrayList(){
        
        
        try{
            FileInputStream file = new FileInputStream("products.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);
            
            boolean endOfFile = false;
            
            while(!endOfFile){
                try{
                    products.add ((Product)inputFile.readObject());
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
            FileInputStream file = new FileInputStream("login.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);
            
            boolean endOfFile = false;
            
            while(!endOfFile){
                try{
                    login.add((LoginRecord)inputFile.readObject());
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
    }


public void saveProductToFile(){
      try{
          FileOutputStream file = new FileOutputStream("products.dat");
          ObjectOutputStream outputFile = new ObjectOutputStream(file);
          
          for(int i=0; i<products.size();i++){
              outputFile.writeObject(products.get(i));
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        product = new javax.swing.JButton();
        mycart = new javax.swing.JButton();
        myorder = new javax.swing.JButton();
        signout = new javax.swing.JButton();
        myaccount = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        search = new javax.swing.JButton();
        total = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        order = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        ans = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("My Shopping Cart");

        jPanel1.setBackground(new java.awt.Color(153, 0, 51));

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));

        jLabel2.setFont(new java.awt.Font("Bauhaus 93", 0, 48)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MY SHOPPING CART");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(383, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(318, 318, 318))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 153));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Algerian", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SHOPPY");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        product.setBackground(new java.awt.Color(255, 255, 153));
        product.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        product.setText("PRODUCTS");
        product.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        product.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productActionPerformed(evt);
            }
        });

        mycart.setBackground(new java.awt.Color(255, 255, 153));
        mycart.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        mycart.setText("MY CART");
        mycart.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mycart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mycartActionPerformed(evt);
            }
        });

        myorder.setBackground(new java.awt.Color(255, 255, 153));
        myorder.setFont(new java.awt.Font("Yu Gothic", 1, 17)); // NOI18N
        myorder.setText("MY ORDER");
        myorder.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        myorder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myorderActionPerformed(evt);
            }
        });

        signout.setBackground(new java.awt.Color(255, 255, 153));
        signout.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        signout.setText("SIGN OUT");
        signout.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        signout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signoutActionPerformed(evt);
            }
        });

        myaccount.setBackground(new java.awt.Color(255, 255, 153));
        myaccount.setFont(new java.awt.Font("Yu Gothic", 1, 17)); // NOI18N
        myaccount.setText("MY ACCOUNT");
        myaccount.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        myaccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myaccountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(mycart, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(product, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(myorder, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(signout, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(myaccount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(product, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(mycart, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(myorder, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(myaccount, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(signout, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        Table.setBackground(new java.awt.Color(153, 255, 153));
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CATEGORY", "ITEM DISCRIPTION", "QUANTITY", "PRICE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table.setGridColor(new java.awt.Color(0, 0, 0));
        Table.setShowGrid(true);
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        jPanel4.setBackground(new java.awt.Color(255, 255, 153));

        jLabel3.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        jLabel3.setText("Category   :");

        jLabel4.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        jLabel4.setText("Item            :");

        jLabel5.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        jLabel5.setText("Quantity    :");

        jLabel6.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        jLabel6.setText("Price           :");

        add.setBackground(new java.awt.Color(102, 204, 255));
        add.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        add.setText("ADD Item");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        jTextField3.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        jTextField4.setEditable(false);
        jTextField4.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Product Discription");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));

        edit.setBackground(new java.awt.Color(102, 204, 255));
        edit.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        edit.setText("EDIT Quantity");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(102, 204, 255));
        delete.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        delete.setText("DELETE Item");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        clear.setBackground(new java.awt.Color(102, 204, 255));
        clear.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        clear.setText("CLEAR All");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        search.setBackground(new java.awt.Color(102, 204, 255));
        search.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        search.setText("Search Item");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        total.setBackground(new java.awt.Color(102, 204, 255));
        total.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        total.setText("TOTAL");
        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });

        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setAutoscrolls(false);
        jScrollPane4.setViewportView(jTextArea1);

        jLabel9.setText("*Category Cannot Edit*");

        jLabel10.setText("*Item Name Cannot Edit*");

        jLabel11.setText("*Price Cannot Edit*");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 27, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField3)
                                .addComponent(jTextField1)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))
                            .addComponent(jLabel10)))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel11)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel4))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        order.setBackground(new java.awt.Color(255, 255, 102));
        order.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        order.setText("ORDER NOW");
        order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("TOTAL : ");

        ans.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ans.setForeground(new java.awt.Color(255, 255, 255));
        ans.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ans.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(505, 505, 505)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ans, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(order, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ans, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(order, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void productActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Category().setVisible(true);
    }//GEN-LAST:event_productActionPerformed

    private void mycartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mycartActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new AddCart().setVisible(true);
    }//GEN-LAST:event_mycartActionPerformed

    private void myorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myorderActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new MyOrder().setVisible(true);
    }//GEN-LAST:event_myorderActionPerformed

    private void myaccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myaccountActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new MyAccount().setVisible(true);
    }//GEN-LAST:event_myaccountActionPerformed

    private void signoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signoutActionPerformed
        // TODO add your handling code here:
        int a=JOptionPane.showConfirmDialog(null,"DO YOU REALLY WANT TO SIGN OUT ?");
            if(a==JOptionPane.YES_OPTION){
                products.clear();
                saveProductToFile();
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                System.exit(0);
            }
            else{
   
            } 
    }//GEN-LAST:event_signoutActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Category().setVisible(true);
    }//GEN-LAST:event_addActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        // TODO add your handling code here:
        int i = Table.getSelectedRow();
        jTextField1.setText(model.getValueAt(i, 0).toString());
        jTextArea1.setText(model.getValueAt(i, 1).toString());
        jTextField3.setText(model.getValueAt(i, 2).toString());
        jTextField4.setText(model.getValueAt(i, 3).toString());
    }//GEN-LAST:event_TableMouseClicked
private void clearField(){
        jTextField1.setText("");
        jTextArea1.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        ans.setText("");
}
    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        int row = Table.getSelectedRow();
            if(row>=0){
                
                int editquantity = Integer.parseInt(jTextField3.getText());
                
                products.get(row).setQuantity(editquantity);
                saveProductToFile();
                model.setValueAt(jTextField3.getText(), row, 2);
                clearField();
            }
        
            else{                                                         
                JOptionPane.showMessageDialog(null,"Edit ERROR , Please Try Again !");

            }
    }//GEN-LAST:event_editActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        int row = Table.getSelectedRow();
        if (row>=0){
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this,"\"Are You Comfirm to Delete the Item ?\"","Delete",dialogButton);
        
        if(dialogResult ==0){
             model.removeRow(row);
             products.remove(row);
             saveProductToFile();
             
             model.setRowCount(0);
               for(int i=0;i<products.size();i++){
                Object[] objs = {products.get(i).getCategory(),products.get(i).getItem(),products.get(i).getQuantity(),formatter.format(products.get(i).getPrice())};
                model.addRow(objs);
                }
            }
         clearField();
        }
        
        else{                                                         
            JOptionPane.showMessageDialog(null,"Delete ERROR , Please Try Again !");

        } 
    }//GEN-LAST:event_deleteActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        int move = model.getRowCount();
        for(int i = move - 1; i>=0; i--){
            model.removeRow(i);
        }
        products.clear();
        
        saveProductToFile();
        clearField();
        
    }//GEN-LAST:event_clearActionPerformed

    private void orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderActionPerformed
        // TODO add your handling code here:
        ans.setText("");
        double mul =0;
        double sum =0;
        for(int i=0; i<Table.getRowCount();i++){
            int a= Integer.parseInt(Table.getValueAt(i, 2).toString());
            double b= Double.parseDouble(Table.getValueAt(i, 3).toString());
            mul =a*b;
            sum = sum + mul;
            
        }
        String total = "RM "+Double.toString(sum)+"0";
        ans.setText(total);
        int a=JOptionPane.showConfirmDialog(null,"DO YOU CONFIRM YOUR ORDER ?");
            if(a==JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null,"SUCCESSFUL ORDER!! You Can click 'My Order' button to View Your Receipt.TQ ");
            }
         
            try(FileWriter Writer = new FileWriter("Customer Order.txt",true)) {
            //Writer = new FileWriter(f);
            int count=0;
            for(int i =0;i<login.size();i++){
            if((!(count>=1))&&(loginList.contains(login.get(i).getUsername())==true)){
                
            Writer.write("***********************************\n");
            Writer.write(":::::: Record Customer Order ::::::\n");
            Writer.write("***********************************\n");            
            Writer.write("Name           : "+login.get(i).getName()+"\n");
            Writer.write("Gender         : "+login.get(i).getGender()+"\n");
            Writer.write("Contact Number : "+login.get(i).getContact()+"\n");            
            Writer.write("Address        : "+login.get(i).getAddress()+"\n");
            Writer.write("Email          : "+login.get(i).getEmail()+"\n");
            count++;
                }
            }
            Writer.write("|================================================================================================================================|\n");
            Writer.write(String.format("| %-20s| %-60s| %-20s | %20s| %n","CATEGORY","PRODUCT","CAPACITY","PRICE(RM)" ));
            Writer.write("|================================================================================================================================|\n");
            for(int i=0;i<products.size();i++){
                Writer.write(String.format("| %-20s| %-60s| %-20d | %20.2f| %n", products.get(i).getCategory(),products.get(i).getItem(),products.get(i).getQuantity(),products.get(i).getPrice()));
                Writer.write("|--------------------------------------------------------------------------------------------------------------------------------|\n");
            }
            Writer.write(String.format("| %-105s| %20s| %n","TOTAL PRICE:",total));
            Writer.write("|--------------------------------------------------------------------------------------------------------------------------------|\n");
            Writer.close();
        }catch(IOException e){
            
        }
        FileWriter Writer = null;
        try {
            File f = new File("MyOrder.txt");
            if(f.exists()){
                f.delete();
            }   
            Writer = new FileWriter(f);
            Writer.write("*********************************\n");
            Writer.write(":::::: THANK YOU FOR ORDER ::::::\n");
            Writer.write("*********************************\n");            
            int count=0;
            for(int i =0;i<login.size();i++){
            if((!(count>=1))&&(loginList.contains(login.get(i).getUsername())==true)){
            Writer.write("Name           : "+login.get(i).getName()+"\n");
            Writer.write("Gender         : "+login.get(i).getGender()+"\n");
            Writer.write("Contact Number : "+login.get(i).getContact()+"\n");            
            Writer.write("Address        : "+login.get(i).getAddress()+"\n");
            Writer.write("Email          : "+login.get(i).getEmail()+"\n");
            count++;
                }
            }
            Writer.write("|================================================================================================================================|\n");
            Writer.write(String.format("| %-20s| %-60s| %-20s | %20s| %n","CATEGORY","PRODUCT DISCRIPTION","QUANTITY","PRICE(RM)" ));
            Writer.write("|================================================================================================================================|\n");
            for(int i=0;i<products.size();i++){
                Writer.write(String.format("| %-20s| %-60s| %-20d | %20.2f| %n", products.get(i).getCategory(),products.get(i).getItem(),products.get(i).getQuantity(),products.get(i).getPrice()));
                Writer.write("|--------------------------------------------------------------------------------------------------------------------------------|\n");
            }
            Writer.write(String.format("| %-105s| %20s| %n","TOTAL PRICE:",total));
            Writer.write("|--------------------------------------------------------------------------------------------------------------------------------|\n");
            Writer.close();
        }catch(IOException e){
            
        }
        
    }//GEN-LAST:event_orderActionPerformed
 public double getTotal(){
        
        double mul =0;
        double sum =0;
        for(int i=0; i<Table.getRowCount();i++){
            int a= Integer.parseInt(Table.getValueAt(i, 2).toString());
            double b= Double.parseDouble(Table.getValueAt(i, 3).toString());
            mul =a*b;
            sum = sum + mul;
            
        }
        ans.setText("RM "+Double.toString(sum)+"0");
        return sum;
    }
    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        // TODO add your handling code here:
        getTotal();
        
    }//GEN-LAST:event_totalActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        
        String[] categoryArray = {"< SELECT CATEGORY >","Watches","MakeUp","Shoes","Jewellery","Clothes"};

        JComboBox cb = new JComboBox(categoryArray);
        Object[] selection = { "Select Category :", cb};
        int input;
        input = JOptionPane.showConfirmDialog(null, selection, "SEARCH PRODUCTS", JOptionPane.OK_CANCEL_OPTION);
        String category = cb.getSelectedItem().toString();
        int count=0;
        int j=1;
        boolean a=false;
        if(input==JOptionPane.OK_OPTION){
             
            for(int i =0; i< products.size(); i++){
                a = products.get(i).getCategory().contains(category);
                if((a==true)&&(count>=0)&&(products.get(i).getCategory().equals(category))){                   
                    String item = "Item    :"+products.get(i).getItem();
                    String quantity = "Quantity :"+products.get(i).getQuantity();
                    String price = "Price  : "+formatter.format(products.get(i).getPrice());
                    Object[] result = { "FOUND !!! "+j++,"Category : "+category,item,quantity,price};
                    JOptionPane.showMessageDialog(this,result,"SEARCH RESULT",JOptionPane.OK_OPTION);
                    count++;
                   }               
            }
            if (a==false){                        
                if((count==0)){                    
                JOptionPane.showMessageDialog(this,"Not Found!!!","Search Product",JOptionPane.OK_OPTION);
                count++;
                }
            }
          
        }
    }//GEN-LAST:event_searchActionPerformed

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
            java.util.logging.Logger.getLogger(AddCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCart().setVisible(true);
            }
        });
    }
    
    private final DefaultTableModel model;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JButton add;
    private javax.swing.JLabel ans;
    private javax.swing.JButton clear;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JButton myaccount;
    private javax.swing.JButton mycart;
    private javax.swing.JButton myorder;
    private javax.swing.JButton order;
    private javax.swing.JButton product;
    private javax.swing.JButton search;
    private javax.swing.JButton signout;
    private javax.swing.JButton total;
    // End of variables declaration//GEN-END:variables
}
