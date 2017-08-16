

package easyb.s.Views;

import com.sun.glass.events.KeyEvent;
import easyb.s.Global;
import easyb.s.Product.NewProduct;
import easyb.s.Product.Product;
import static easyb.s.Views.SellerView.listOfProductsTable;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class ProductCatalogView extends javax.swing.JFrame {
    
    public ProductCatalogView() {
        initComponents();
    }
    
    //This method cleans the textfield so that every time the user adds a 
    //product all the textfield is cleaned and he can enter a new product.
    public void cleanTextFields(){
       
        productNameTextField.setText("");
        idProductTextField.setText("");
        priceTextField.setText("");
        quantityTextField.setText("");
        conditionComboBox.setSelectedIndex(0);
    }

    //This method shows the products that the user has for sale in the system.
    //Which is located in seller's view.
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
     
    //This method cleans the table called list Of Products Table. 
    //Which is located in seller's view.
    private void clearListOfProductsTable(){
        
        DefaultTableModel model = (DefaultTableModel) listOfProductsTable.getModel();
        
        for (int i = 0; i < listOfProductsTable.getRowCount(); i++) {
            
           model.removeRow(i);
           i-=1;
           
           
       }
   } 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_Catalog = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        addProductButton = new javax.swing.JButton();
        productNameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        priceTextField = new javax.swing.JTextField();
        quantityTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        conditionComboBox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        idProductTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        Table_Catalog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Product", "Product Name", "Quantity Available ", "Unit Price", "Used or new "
            }
        ));
        Table_Catalog.setEnabled(false);
        jScrollPane1.setViewportView(Table_Catalog);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Product Catalog ");

        addProductButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addProductButton.setText("Add Product");
        addProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductButtonActionPerformed(evt);
            }
        });

        productNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productNameTextFieldActionPerformed(evt);
            }
        });
        productNameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                productNameTextFieldKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Product Name:");

        priceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceTextFieldActionPerformed(evt);
            }
        });
        priceTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                priceTextFieldKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                priceTextFieldKeyPressed(evt);
            }
        });

        quantityTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityTextFieldActionPerformed(evt);
            }
        });
        quantityTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                quantityTextFieldKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                quantityTextFieldKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Price: ($)");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Condition:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Quantity Available: ");

        conditionComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Used", "New" }));
        conditionComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                conditionComboBoxKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel6.setText("Product ID:");

        idProductTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idProductTextFieldActionPerformed(evt);
            }
        });
        idProductTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                idProductTextFieldKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(addProductButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(conditionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabel5))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(quantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(productNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                        .addComponent(idProductTextField))
                                    .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2)))))
                .addGap(0, 218, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(133, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(idProductTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(productNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(quantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(conditionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(addProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    }// </editor-fold>//GEN-END:initComponents

    private void addProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductButtonActionPerformed

        //This button adds products to the list of products for sale with which the system has.
        //The seller can see the products that he is adding to the system in a table that is at 
        //the bottom of the view.
        if (idProductTextField.getText().equals("")){
            
            JOptionPane.showMessageDialog(this, "You must define an ID to add a product",
                    "Item registration problem", JOptionPane.ERROR_MESSAGE);
            this.idProductTextField.requestFocus();
            return;
            
        }
        
        if (productNameTextField.getText().equals("")){
            
            JOptionPane.showMessageDialog(this, "You must define a PRODUCT NAME to add a product",
                    "Item registration problem", JOptionPane.ERROR_MESSAGE);
            this.productNameTextField.requestFocus();
            return;
            
        }

        if (priceTextField.getText().equals("")){
            
            JOptionPane.showMessageDialog(this, "You must define a PRICE to add a product",
                    "Item registration problem", JOptionPane.ERROR_MESSAGE);
            this.priceTextField.requestFocus();
            return;
            
        }
        
        if (quantityTextField.getText().equals("")){
            
            JOptionPane.showMessageDialog(this, "You must define a PRODUCT AMOUNT to add a product",
                    "Item registration problem", JOptionPane.ERROR_MESSAGE);
            this.quantityTextField.requestFocus();
            return;
            
        }

        String condition = conditionComboBox.getSelectedItem().toString();
          
        String name = productNameTextField.getText();
        String id = idProductTextField.getText();
        int price = Integer.parseInt(priceTextField.getText());
        int amount = Integer.parseInt(quantityTextField.getText());

        
        DefaultTableModel model = (DefaultTableModel) Table_Catalog.getModel();

        Object rowDate[] = new Object[5];
            rowDate[0] = id;
            rowDate[1] = name;
            rowDate[2] = amount;
            rowDate[3] = price;
            rowDate[4] = condition;
            model.insertRow(model.getRowCount(), rowDate);   
            
        NewProduct newProduct = new NewProduct(id, name, price, amount, condition, Global.emailUser);
            Global.productList.add(newProduct);
            
            cleanTextFields();
        
        System.out.println("Size of the productList: "+ Global.productList.size());
         
        for (Product newPrintProduct: Global.productList){
            System.out.println(newPrintProduct.getInformation() + "\n" + "* ** *** **** | **** *** ** *");
            
        }
        
        clearListOfProductsTable();
        
        loadProductToTable();
        
        this.idProductTextField.requestFocus();
        
    }//GEN-LAST:event_addProductButtonActionPerformed

   
    private void productNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productNameTextFieldActionPerformed
        // TODO add your handling code here:
   
    }//GEN-LAST:event_productNameTextFieldActionPerformed

    private void idProductTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idProductTextFieldActionPerformed
        // TODO add your handling code here:
   
    }//GEN-LAST:event_idProductTextFieldActionPerformed

    private void priceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceTextFieldActionPerformed
        // TODO add your handling code here:
   
    }//GEN-LAST:event_priceTextFieldActionPerformed

    private void quantityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityTextFieldActionPerformed
        // TODO add your handling code here:
   
    }//GEN-LAST:event_quantityTextFieldActionPerformed

    private void priceTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priceTextFieldKeyTyped
        // TODO add your handling code here:
        
        char c = evt.getKeyChar();

        if (c < '0' || c > '9') {
            evt.consume();
        }
           
    }//GEN-LAST:event_priceTextFieldKeyTyped

    private void quantityTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityTextFieldKeyTyped
        // TODO add your handling code here:
        
        char c = evt.getKeyChar();

        if (c < '0' || c > '9') {
            evt.consume();
        }
        
    }//GEN-LAST:event_quantityTextFieldKeyTyped

    private void idProductTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idProductTextFieldKeyPressed
        // TODO add your handling code here:
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            this.productNameTextField.requestFocus();
            
        }
        
    }//GEN-LAST:event_idProductTextFieldKeyPressed

    private void productNameTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productNameTextFieldKeyPressed
        // TODO add your handling code here:
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            this.priceTextField.requestFocus();
            
        }
        
    }//GEN-LAST:event_productNameTextFieldKeyPressed

    private void priceTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priceTextFieldKeyPressed
        // TODO add your handling code here:
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            this.quantityTextField.requestFocus();
            
        }
        
    }//GEN-LAST:event_priceTextFieldKeyPressed

    private void quantityTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityTextFieldKeyPressed
        // TODO add your handling code here:
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            this.conditionComboBox.requestFocus();
            
        }
        
    }//GEN-LAST:event_quantityTextFieldKeyPressed

    private void conditionComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_conditionComboBoxKeyPressed
        // TODO add your handling code here:
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            this.addProductButton.requestFocus();
            
        }
        
    }//GEN-LAST:event_conditionComboBoxKeyPressed

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
            java.util.logging.Logger.getLogger(ProductCatalogView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductCatalogView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductCatalogView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductCatalogView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductCatalogView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table_Catalog;
    private javax.swing.JButton addProductButton;
    private javax.swing.JComboBox<String> conditionComboBox;
    private javax.swing.JTextField idProductTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField priceTextField;
    private javax.swing.JTextField productNameTextField;
    private javax.swing.JTextField quantityTextField;
    // End of variables declaration//GEN-END:variables
}
