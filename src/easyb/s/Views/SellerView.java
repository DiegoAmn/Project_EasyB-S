/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyb.s.Views;

import easyb.s.Global;
import easyb.s.Product.NewReview;
import easyb.s.Product.Product;
import easyb.s.Product.ProductSold;
import easyb.s.User;
import easyb.s.Views.ProductCatalogView;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Steve
 */
public class SellerView extends javax.swing.JFrame {

    
    
    
    public SellerView() {
        initComponents();
        blockTextField();
        showUser();
        loadProductToTable();
        loadListOfSoldProductsTable();
        showRate();
        
    }
    
    //This method calculates and shows the rate of the seller user.
    private void showRate(){
        
        float totalStar = 0;
        float totalStarSales = 0;
        float totalReview = 0;
        float totalSales = 0;
        float rate;
        
        if (Global.reviewList.isEmpty()){
            
            rateTextField.setText(("0"));
            rateTextField.setHorizontalAlignment(JTextField.CENTER);
            
        }
        
        else{
            
            for (NewReview getInfo : Global.reviewList) {
            
            String emailForWhom = getInfo.getForWhom();
            int calification = getInfo.getCalification();
            int sale = getInfo.getPrice();

            
                if (emailForWhom.equals(Global.emailUser)){
            
                      totalStar = calification + totalStar;
                      totalSales = totalSales + sale;
                      totalReview++;

                }
                
            }
            
            if (totalSales <= 1000){
                
                totalStarSales = 1;
                   
            }
            
            else if (totalSales >= 1001 && totalSales <= 2000){
                
                totalStarSales = 2;
                 
            }
            
            else if (totalSales >= 2001 && totalSales <= 3000){
                
                totalStarSales = 3;
                 
            } 
            
            else if (totalSales >= 3001 && totalSales <= 4000){
                
                totalStarSales = 4;
                 
            }
            else {
                
                totalStarSales = 5;
                
            }

            rate = ((totalStar / totalReview) + totalStarSales)/2;
            rateTextField.setText((String.valueOf(rate)));
            rateTextField.setHorizontalAlignment(JTextField.CENTER);
            
        }  
        
    }
    
    //This method shows the products that the seller has for sale so far.
    public void loadProductToTable() {
        
        DefaultTableModel model = (DefaultTableModel) listOfProductsTable.getModel();

        Object rowDate[] = new Object[5];
            
        for (Product emailSeller : Global.productList){

        String email = emailSeller.getEmailSeller();
            
        String id = emailSeller.getId();    
        String productName = emailSeller.getProductName();
        int amount = emailSeller.getAmount();
        int price = emailSeller.getPrice();
        String condition = emailSeller.getCondition();
        
            if (email.equals(Global.emailUser)){
                              
                rowDate[0] = id;
                rowDate[1] = productName;
                rowDate[2] = amount;
                rowDate[3] = price;
                rowDate[4] = condition;
                
                model.insertRow(model.getRowCount(), rowDate);   
                
            }
                      
        }
  
    }    
    
    //This method shows the products that the seller has sold.
    public void loadListOfSoldProductsTable() {
        
        for (int info = 0; Global.soldProductList.size() > info; info++){
            
                ProductSold position = Global.soldProductList.get(info);
                
                if ((position.getEmailSeller().equals(Global.emailUser))){
                    
                    DefaultTableModel model = (DefaultTableModel) listOfSoldProductsTable.getModel();

                    Object rowDate[] = new Object[7];

                        rowDate[0] = Global.soldProductList.get(info).getId();
                        rowDate[1] = Global.soldProductList.get(info).getProductName();
                        rowDate[2] = Global.soldProductList.get(info).getAmount();
                        rowDate[3] = Global.soldProductList.get(info).getPrice();
                        rowDate[4] = Global.soldProductList.get(info).getCondition();
                        rowDate[5] = Global.soldProductList.get(info).getEmailBuyer();
                        rowDate[6] = Global.soldProductList.get(info).getStatusReviewBuyer();
                        model.insertRow(model.getRowCount(), rowDate);
 
                }
                
        }

    }
    
    //This method cleans the table called List Of Sold Products Table.
    private void clearListOfSoldProductsTable(){
        
        DefaultTableModel model = (DefaultTableModel) listOfSoldProductsTable.getModel();
        
        for (int i = 0; i < listOfSoldProductsTable.getRowCount(); i++) {
            
           model.removeRow(i);
           i-=1;
              
       }
    }

    //This method shows the view called Catalog View.
    public static void showCatalogView(){
        
    ProductCatalogView oCatalogView = new ProductCatalogView();
    oCatalogView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    oCatalogView.setLocationRelativeTo(null);
    oCatalogView.setVisible(true);
    
    }
    
    //This method shows the view called Statistic View.
    public void showStatisticView(){
        
        for (User user : Global.usersList){

            if (user.getEmail().equals(Global.emailUser)){

                user.showStatisticView();

            }

        }
    
    }
    
    //This method blocks a series of textfield so that the user can not modify them.
    public void blockTextField(){
    
    rateTextField.setEditable(false);
    userNameReviewTextField.setEditable(false);
    userTextField.setEditable(false);
    
    userNameReviewTextField.setEditable(false);
    commentTextArea.setEditable(false);
    calificationComboBox.setEnabled(false);
    addReviewButton.setEnabled(false);
    
    }
    
    ////This method shows in the upper left corner the name of the user who is currently logged in.
    public void showUser(){
        
        userTextField.setText(Global.emailUser);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        userNameReviewTextField = new javax.swing.JTextField();
        calificationComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        commentTextArea = new javax.swing.JTextArea();
        addReviewButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listOfProductsTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        listOfSoldProductsTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        doReviewButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        rateTextField = new javax.swing.JTextField();
        userTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        statisticsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel3.setText("User Review");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel4.setText("User Name");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel5.setText("Calification");

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel6.setText("Make a comment");

        userNameReviewTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameReviewTextFieldActionPerformed(evt);
            }
        });

        calificationComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        commentTextArea.setColumns(20);
        commentTextArea.setRows(5);
        jScrollPane1.setViewportView(commentTextArea);

        addReviewButton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        addReviewButton.setText("Add Review");
        addReviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addReviewButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(calificationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6)
                    .addComponent(userNameReviewTextField)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                    .addComponent(addReviewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(126, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(118, 118, 118))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userNameReviewTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(calificationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addReviewButton)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        listOfProductsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Product", "Product Name", "Quantity Available", "Unit Price $", "Condition"
            }
        ));
        listOfProductsTable.setEnabled(false);
        jScrollPane2.setViewportView(listOfProductsTable);

        listOfSoldProductsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Product", "Product Name", "Quantity sold", "Total Price $", "Condition", "eMail Buyer", "Status Review"
            }
        ));
        jScrollPane3.setViewportView(listOfSoldProductsTable);

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel7.setText("List of Products");

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel8.setText("List of sold products");

        jButton2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jButton2.setText("Add Product");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        doReviewButton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        doReviewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Review.png"))); // NOI18N
        doReviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doReviewButtonActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));

        rateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rateTextFieldActionPerformed(evt);
            }
        });

        userTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTextFieldActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/evaluatie-score.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/user.png"))); // NOI18N

        statisticsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/traffic-stats.png"))); // NOI18N
        statisticsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statisticsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rateTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(statisticsButton)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statisticsButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(doReviewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(159, 159, 159)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(doReviewButton))))
                .addGap(23, 23, 23))
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

    private void userTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTextFieldActionPerformed
        // TODO add your handling code here:
           
    }//GEN-LAST:event_userTextFieldActionPerformed

    private void userNameReviewTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameReviewTextFieldActionPerformed
        // TODO add your handling code here:
          
    }//GEN-LAST:event_userNameReviewTextFieldActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        //This button opens the view called Catalog View.
        showCatalogView();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void rateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rateTextFieldActionPerformed
        // TODO add your handling code here:
          
    }//GEN-LAST:event_rateTextFieldActionPerformed

    private void doReviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doReviewButtonActionPerformed
        
        //This button saves the information of the row that the user selected from the Sold Product Table 
        //in a series of variables. Then enables a series of spaces so that the user can perform 
        //the review of the buyer to which the user has not done the review.
        int selectRow = listOfSoldProductsTable.getSelectedRow();
        
        if(selectRow == -1){
            
            JOptionPane.showMessageDialog(null,"You must to select a row for do the review.","Error",JOptionPane.ERROR_MESSAGE);
        
        }else{
            
            Global.productId = listOfSoldProductsTable.getModel().getValueAt(selectRow, 0).toString();
            Global.productName = listOfSoldProductsTable.getModel().getValueAt(selectRow, 1).toString();
            Global.productAmount = listOfSoldProductsTable.getModel().getValueAt(selectRow, 2).hashCode();
            Global.productPrice = listOfSoldProductsTable.getModel().getValueAt(selectRow, 3).hashCode();
            Global.productCondition = listOfSoldProductsTable.getModel().getValueAt(selectRow, 4).toString();
            Global.emailBuyer = listOfSoldProductsTable.getModel().getValueAt(selectRow, 5).toString();
            Global.statusReviewBuyer = listOfSoldProductsTable.getModel().getValueAt(selectRow, 6).toString();
                    
                if (Global.statusReviewBuyer.equals("Not done")){
                        
                    userNameReviewTextField.setText(Global.emailBuyer);
                    commentTextArea.setEditable(true);
                    calificationComboBox.setEnabled(true);
                    addReviewButton.setEnabled(true);
                       
                }else{
                        
                    JOptionPane.showMessageDialog(null,"The review have done.","Warning",JOptionPane.WARNING_MESSAGE);
                        
                }
    
            }
            
    }//GEN-LAST:event_doReviewButtonActionPerformed

    private void addReviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addReviewButtonActionPerformed
        
        //This button performs the review. This proceeds to save the review made and to change 
        //the status of the review of the buyer for "Done".
        int calification = Integer.parseInt(calificationComboBox.getSelectedItem().toString());
        String comment = commentTextArea.getText();
        
        NewReview newReview = new NewReview(calification, comment, Global.emailUser, 
        Global.emailBuyer, Global.productId, Global.productName, Global.productPrice,
        Global.productAmount, Global.productCondition, Global.emailUser);
        Global.reviewList.add(newReview);
        
        for (ProductSold productSold : Global.soldProductList) {
                
                String idProduct = productSold.getId();
                String email = productSold.getEmailBuyer();
                
                if (idProduct.equals(Global.productId) && email.equals(Global.emailBuyer)){
                    
                    productSold.setStatusReviewBuyer("Done");
                       
                }
                
            }
        
        clearListOfSoldProductsTable();
        loadListOfSoldProductsTable();
        
        userNameReviewTextField.setText("");
        commentTextArea.setText("");
        calificationComboBox.setSelectedIndex(0);
        commentTextArea.setEditable(false);
        calificationComboBox.setEnabled(false);
        addReviewButton.setEnabled(false);

        for (NewReview review: Global.reviewList){
            System.out.println(review.getInformation() + "\n" + "* ** *** **** | **** *** ** *");
        }
   
    }//GEN-LAST:event_addReviewButtonActionPerformed

    private void statisticsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statisticsButtonActionPerformed
        
        //This button shows the view called Statistic View.
        showStatisticView();
        
    }//GEN-LAST:event_statisticsButtonActionPerformed

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
            java.util.logging.Logger.getLogger(SellerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SellerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SellerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SellerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SellerView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addReviewButton;
    private javax.swing.JComboBox<String> calificationComboBox;
    private javax.swing.JTextArea commentTextArea;
    private javax.swing.JButton doReviewButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JTable listOfProductsTable;
    private javax.swing.JTable listOfSoldProductsTable;
    private javax.swing.JTextField rateTextField;
    private javax.swing.JButton statisticsButton;
    private javax.swing.JTextField userNameReviewTextField;
    private javax.swing.JTextField userTextField;
    // End of variables declaration//GEN-END:variables
}
