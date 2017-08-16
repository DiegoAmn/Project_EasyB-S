/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyb.s.Views;

import easyb.s.Global;
import easyb.s.Product.NewProduct;
import easyb.s.Product.NewReview;
import easyb.s.Product.Product;
import easyb.s.Product.ProductSold;
import easyb.s.User;
import easyb.s.Users.Buyer;
import static easyb.s.Views.SellerView.listOfProductsTable;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import sun.util.calendar.CalendarUtils;

/**
 *
 * @author Steve
 */
public class BuyerView extends javax.swing.JFrame {

 
    /**
     * Creates new form Buyer
     */
    public BuyerView() {
        initComponents();
        loadProductToTable();
        loadProductsPurchasedListToTable();
        blockTextField();
        showUser();
        shoppingHistory();
        showRate();
        
           
    }
    
    //This method cleans the Sold Product Table. This is done to re-insert the data and not to repeat the data.
    private void clearSoldProductTable(){
        
        DefaultTableModel model = (DefaultTableModel) soldProductTable.getModel();
        
        for (int i = 0; i < soldProductTable.getRowCount(); i++) {
            
           model.removeRow(i);
           i-=1;
              
       }
    }
    
    //The function of this method is to show the amount of purchases made historically 
    //and the amount that has paid for all items
    private void shoppingHistory(){
        
      int numberPurchase = 0;
      int totalAmount = 0;
    
      for (ProductSold productSold : Global.soldProductList) {
                
                  int amountProduct = productSold.getAmount();
                  int priceProduct= productSold.getPrice();
                  String email = productSold.getEmailBuyer();
                  
                
                  if (email.equals(Global.emailUser)){
                    
                      numberPurchase= numberPurchase + amountProduct ;
                      totalAmount = priceProduct + totalAmount;
                }
                
        }
      
        itemAmountTextField.setText(String.valueOf(numberPurchase));
        priceAmountTextField.setText("$" + totalAmount);
        itemAmountTextField.setHorizontalAlignment(JTextField.RIGHT);  
        priceAmountTextField.setHorizontalAlignment(JTextField.RIGHT);  
          
    }
    
    //This method calculates and shows the rate of the buyer user.
    private void showRate(){
        
        float totalStar = 0;
        float totalReview = 0;
        float rate;
        
        if (Global.reviewList.isEmpty()){
            
            rateTextField.setText(("0"));
            rateTextField.setHorizontalAlignment(JTextField.CENTER);
            
        }
        
        else{
            
            for (NewReview getInfo : Global.reviewList) {
            
            String emailForWhom = getInfo.getForWhom();
            int calification = getInfo.getCalification();
            
                if (emailForWhom.equals(Global.emailUser)){
            
                      totalStar = calification + totalStar;
                      totalReview++;
            
                }
                
            }
            
            rate = totalStar / totalReview;
            rateTextField.setText((String.valueOf(rate)));
            rateTextField.setHorizontalAlignment(JTextField.CENTER);
            
        }  
        
    }

    //This method cleans the Product Table. This is done to re-insert the data and not to repeat the data.
    private void clearProductTable(){
        
        DefaultTableModel model = (DefaultTableModel) productsTable.getModel();
        
        for (int i = 0; i < productsTable.getRowCount(); i++) {
            
           model.removeRow(i);
           i-=1;
              
       }
    }
    
    //This method loads the Product Table with the list data that contains all the products that sellers have for sale.
    public void loadProductToTable() {

        DefaultTableModel model = (DefaultTableModel) productsTable.getModel();

        Object rowDate[] = new Object[6];
        for (int i = 0; i < Global.productList.size(); i++) {

            rowDate[0] = Global.productList.get(i).getId();
            rowDate[1] = Global.productList.get(i).getProductName();
            rowDate[2] = Global.productList.get(i).getAmount();
            rowDate[3] = Global.productList.get(i).getPrice();
            rowDate[4] = Global.productList.get(i).getCondition();
            rowDate[5] = Global.productList.get(i).getEmailSeller();
            model.insertRow(model.getRowCount(), rowDate);

        }

    }
    
    //This method loads the table of products that were purchased by the buyer. 
    //This data comes from a sales list that was made.
    public void loadProductsPurchasedListToTable() {
        
        for (int info = 0; Global.soldProductList.size() > info; info++){
            
                ProductSold position = Global.soldProductList.get(info);
                
                if ((position.getEmailBuyer().equals(Global.emailUser))){
                    
                    DefaultTableModel model = (DefaultTableModel) soldProductTable.getModel();

                    Object rowDate[] = new Object[8];

                        rowDate[0] = Global.soldProductList.get(info).getId();
                        rowDate[1] = Global.soldProductList.get(info).getProductName();
                        rowDate[2] = Global.soldProductList.get(info).getAmount();
                        rowDate[3] = Global.soldProductList.get(info).getPrice() / Global.soldProductList.get(info).getAmount();
                        rowDate[4] = Global.soldProductList.get(info).getPrice();
                        rowDate[5] = Global.soldProductList.get(info).getCondition();
                        rowDate[6] = Global.soldProductList.get(info).getEmailSeller();
                        rowDate[7] = Global.soldProductList.get(info).getStatusReviewSeller();
                        model.insertRow(model.getRowCount(), rowDate);
 
                }
                
        }
        
    }
    
    //This method shows the view called Product Amount.
    public void showProductAmount() {
        
        ProductAmountView oProductAmount = new ProductAmountView();
        oProductAmount.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        oProductAmount.setLocationRelativeTo(null);
        oProductAmount.setVisible(true);
  
    }

    //This method shows the view called Statistic View.
    public void showStatisticView(){

        for (User user : Global.usersList){

            if (user.getEmail().equals(Global.emailUser)){

                user.showStatisticView();

            }

        }
    
    }

    //This method blocks a number of spaces in the views. 
    //With this so that the user does not modify the information that is displayed 
    //in these spaces or to enable them in certain functions of the view.
   public void blockTextField(){
    
        itemAmountTextField.setEditable(false);
        userNameReviewTextField.setEditable(false);
        rateTextField.setEditable(false);
        userTextField.setEditable(false);
        priceAmountTextField.setEditable(false);
        
        userNameReviewTextField.setEditable(false);
        commentTextArea.setEditable(false);
        calificationComboBox.setEnabled(false);
        addReviewButton.setEnabled(false);
        
    }
    
    //This method shows in the upper left corner the name of the user who is currently logged in.
    public void showUser(){
        
        userTextField.setText(Global.emailUser);
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productsTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        addProductButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        wishListTable = new javax.swing.JTable();
        modifyAmountButton = new javax.swing.JButton();
        makePurchaseButton = new javax.swing.JButton();
        deleteProductButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        itemAmountTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        priceAmountTextField = new javax.swing.JTextField();
        rateTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        userTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        statisticsButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        userNameReviewTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        calificationComboBox = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        addReviewButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        commentTextArea = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        soldProductTable = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        doReviewButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel4.setText("Products List");

        productsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Product", "Product Name", "Quantity Available", "Unit Price $", "Condition", "eMail Seller"
            }
        ));
        jScrollPane1.setViewportView(productsTable);

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel5.setText("Wish List ");

        addProductButton.setBackground(new java.awt.Color(0, 0, 0));
        addProductButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pict--shopping-cart-marketing---vector-stencils-library.png--diagram-flowchart-example.png"))); // NOI18N
        addProductButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductButtonActionPerformed(evt);
            }
        });

        wishListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Product", "Product Name", "Quantity", "Total Price $", "Condition", "eMail Seller"
            }
        ));
        jScrollPane2.setViewportView(wishListTable);

        modifyAmountButton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        modifyAmountButton.setText("Modify Amount Product");
        modifyAmountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyAmountButtonActionPerformed(evt);
            }
        });

        makePurchaseButton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        makePurchaseButton.setText("Make purchase");
        makePurchaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makePurchaseButtonActionPerformed(evt);
            }
        });

        deleteProductButton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        deleteProductButton.setText("Delete Product");
        deleteProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProductButtonActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setText("Shopping History");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setText("Number of purchases made");

        itemAmountTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAmountTextFieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel3.setText("Total amount paid");

        priceAmountTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceAmountTextFieldActionPerformed(evt);
            }
        });

        rateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rateTextFieldActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/evaluatie-score.png"))); // NOI18N

        userTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTextFieldActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/user.png"))); // NOI18N

        statisticsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/traffic-stats.png"))); // NOI18N
        statisticsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statisticsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(222, 222, 222)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(itemAmountTextField)
                            .addComponent(priceAmountTextField))))
                .addGap(18, 18, 18)
                .addComponent(statisticsButton)
                .addGap(16, 16, 16))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel10))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(priceAmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statisticsButton)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(itemAmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel6.setText("User Review ");

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel7.setText("User Name");

        userNameReviewTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameReviewTextFieldActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel8.setText("Calification");

        calificationComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        calificationComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calificationComboBoxActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel9.setText("Make a comment ");

        addReviewButton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        addReviewButton.setText("Add Review");
        addReviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addReviewButtonActionPerformed(evt);
            }
        });

        commentTextArea.setColumns(20);
        commentTextArea.setRows(5);
        jScrollPane3.setViewportView(commentTextArea);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(calificationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7)
                    .addComponent(userNameReviewTextField)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                    .addComponent(addReviewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(176, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userNameReviewTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(calificationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addReviewButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        soldProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Product", "Product Name", "Amount", "Unit Price $", "Total Price $", "Condition", "eMail Seller", "Status Review"
            }
        ));
        jScrollPane4.setViewportView(soldProductTable);

        jLabel12.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel12.setText("Products purchased List");

        doReviewButton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        doReviewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Review.png"))); // NOI18N
        doReviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doReviewButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addProductButton)
                            .addComponent(doReviewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(jLabel4)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(modifyAmountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(makePurchaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(161, 161, 161))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(deleteProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(330, 330, 330))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deleteProductButton)
                            .addComponent(modifyAmountButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(makePurchaseButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(addProductButton)
                                .addGap(0, 222, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(doReviewButton))))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1283, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductButtonActionPerformed
        
    //This button loads a number of variables with information from the Products Table 
    //and once you do this activity proceeds to open the Product Amount View. 
    //This button also saves a value to a variable, this is used to make a specific function, 
    //which is to add a product to the Wish List Table of the buyer.
        
        Global.actionBuyer = 0;
        
        int row = productsTable.getSelectedRow();
        
        if (row == -1){
            
            JOptionPane.showMessageDialog(null,"You have to select one row.","Error",JOptionPane.ERROR_MESSAGE);
              
        }else
            {

            Global.productId = productsTable.getModel().getValueAt(row, 0).toString();
            Global.productName = productsTable.getModel().getValueAt(row, 1).toString();
            Global.productAmount = productsTable.getModel().getValueAt(row, 2).hashCode();
            Global.productPrice = productsTable.getModel().getValueAt(row, 3).hashCode();
            Global.productCondition = productsTable.getModel().getValueAt(row, 4).toString();
            Global.emailSeller = productsTable.getModel().getValueAt(row, 5).toString();

            showProductAmount();

            }
    }//GEN-LAST:event_addProductButtonActionPerformed

    private void itemAmountTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAmountTextFieldActionPerformed
        // TODO add your handling code here: 
    }//GEN-LAST:event_itemAmountTextFieldActionPerformed

    private void userNameReviewTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameReviewTextFieldActionPerformed
        // TODO add your handling code here: 
    }//GEN-LAST:event_userNameReviewTextFieldActionPerformed

    private void rateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rateTextFieldActionPerformed
        // TODO add your handling code here:    
    }//GEN-LAST:event_rateTextFieldActionPerformed

    private void userTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTextFieldActionPerformed
        // TODO add your handling code here:   
    }//GEN-LAST:event_userTextFieldActionPerformed

    private void priceAmountTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceAmountTextFieldActionPerformed
        // TODO add your handling code here:   
    }//GEN-LAST:event_priceAmountTextFieldActionPerformed

    private void modifyAmountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyAmountButtonActionPerformed
        
    //This button loads a number of variables with information from the Wish List Table and 
    //once you do this activity proceeds to open the Product Amount View. 
    //This button also saves a value to a variable, this is used to make a specific function, 
    //which is to change the product amount that the user wish to the Wish List Table of the buyer. 
        
        Global.actionBuyer = 1;
        
        int row = wishListTable.getSelectedRow();
        
        if (row == -1){
            
            JOptionPane.showMessageDialog(null,"You have to select one row to modify.","Error",JOptionPane.ERROR_MESSAGE);
              
        }else
            {
        
            Global.productId = wishListTable.getModel().getValueAt(row, 0).toString();
            Global.productName = wishListTable.getModel().getValueAt(row, 1).toString();
            Global.productAmount = wishListTable.getModel().getValueAt(row, 2).hashCode();
            Global.productPrice = wishListTable.getModel().getValueAt(row, 3).hashCode() / 
                    wishListTable.getModel().getValueAt(row, 2).hashCode();
            Global.productCondition = wishListTable.getModel().getValueAt(row, 4).toString();
            Global.emailSeller = wishListTable.getModel().getValueAt(row, 5).toString();

            Global.rowPurchasesListTable = row;

            showProductAmount();

            }
    }//GEN-LAST:event_modifyAmountButtonActionPerformed

    private void deleteProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProductButtonActionPerformed
        
    //This button removes the Wish List Table row containing a product that the buyer does not want to purchase. 
        
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) wishListTable.getModel();
        
        int rowPurchasesList = wishListTable.getSelectedRow();

        if(rowPurchasesList<0){
            
            JOptionPane.showMessageDialog(this,"The table is empty or you have not selected a row to delete.");
            
        }else {
          
        model.removeRow(rowPurchasesList);
        
        }
 
    }//GEN-LAST:event_deleteProductButtonActionPerformed

    private void doReviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doReviewButtonActionPerformed
    
    //This button saves the information of the row that the user selected from the Sold Product Table 
    //in a series of variables. Then enables a series of spaces so that the user can perform 
    //the review of the seller to which the user has not done the review.
        
        int selectRow = soldProductTable.getSelectedRow();
        
        if(selectRow == -1){
            
            JOptionPane.showMessageDialog(null,"You must to select a row for do the review.","Error",JOptionPane.ERROR_MESSAGE);
        
        }else{
            
            Global.productId = soldProductTable.getModel().getValueAt(selectRow, 0).toString();
            Global.productName = soldProductTable.getModel().getValueAt(selectRow, 1).toString();
            Global.productAmount = soldProductTable.getModel().getValueAt(selectRow, 2).hashCode();
            Global.productPrice = soldProductTable.getModel().getValueAt(selectRow, 4).hashCode();
            Global.productCondition = soldProductTable.getModel().getValueAt(selectRow, 5).toString();
            Global.emailSeller = soldProductTable.getModel().getValueAt(selectRow, 6).toString();
            Global.statusReviewSeller = soldProductTable.getModel().getValueAt(selectRow, 7).toString();
                    
                if (Global.statusReviewSeller.equals("Not done")){
                        
                    userNameReviewTextField.setText(Global.emailSeller);
                    commentTextArea.setEditable(true);
                    calificationComboBox.setEnabled(true);
                    addReviewButton.setEnabled(true);
                       
                }else{
                        
                    JOptionPane.showMessageDialog(null,"The review have done.","Warning",JOptionPane.WARNING_MESSAGE);
                        
                }
    
        }
        
    }//GEN-LAST:event_doReviewButtonActionPerformed

    private void makePurchaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makePurchaseButtonActionPerformed
        
    //This button performs many functions, but the most important is to realize the purchase 
    //of the user. It detects if the quantity purchased is less than or equal to the one the 
    //seller has in stock. An activity is performed for each of the cases.    
        
        int row = wishListTable.getSelectedRow();
        
        if (row == -1){
            
            JOptionPane.showMessageDialog(null,"You have to select one row.","Error",JOptionPane.ERROR_MESSAGE);
              
        }else
            {
            
            
            String id = wishListTable.getModel().getValueAt(row, 0).toString();
            String productName = wishListTable.getModel().getValueAt(row, 1).toString();
            int desiredQuantity = wishListTable.getModel().getValueAt(row, 2).hashCode();
            int totalPrice = wishListTable.getModel().getValueAt(row, 3).hashCode();
            String productCondition = wishListTable.getModel().getValueAt(row, 4).toString();
            String emailSeller = wishListTable.getModel().getValueAt(row, 5).toString();
            
            
            int iterator = 0;
            
            
            
            while (iterator < Global.productList.size()){
                
                NewProduct product = Global.productList.get(iterator);
                
                String idProduct = product.getId();
                String email = product.getEmailSeller();
                int amount = product.getAmount();
            
                if (idProduct.equals(id) && emailSeller.equals(email)){
                    
                    if (desiredQuantity == amount){
                        
                        ProductSold newProductSold = new ProductSold(Global.emailUser, "Not done", "Not done", 
                        id, productName, totalPrice, desiredQuantity, productCondition, emailSeller);
                        Global.soldProductList.add(newProductSold);
                        
                        Global.productList.remove(iterator);
   
                    }else
                    
                        {
                        
                        product.setAmount(amount - desiredQuantity);
                        
                        ProductSold newProductSold = new ProductSold(Global.emailUser, "Not done", "Not done", 
                        id, productName, totalPrice, desiredQuantity, productCondition, emailSeller);
                        Global.soldProductList.add(newProductSold);
                        
                        
                        
                        }    
                    
                }
                
            iterator ++;
            
            }
                       
            javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) wishListTable.getModel();
  
            model.removeRow(row);
            
            clearProductTable();
            loadProductToTable();
            clearSoldProductTable();
            loadProductsPurchasedListToTable();
            
            for (ProductSold productSold : Global.soldProductList){
                
                System.out.println(productSold.getInformation() + "\n" + "* ** *** **** | **** *** ** *");
            
            }
            
            } 
        
        shoppingHistory();

    }//GEN-LAST:event_makePurchaseButtonActionPerformed

    private void calificationComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calificationComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_calificationComboBoxActionPerformed

    private void addReviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addReviewButtonActionPerformed
    
    //This button performs the review. This proceeds to save the review made and to change 
    //the status of the review of the seller for "Done".
        
        int calification = Integer.parseInt(calificationComboBox.getSelectedItem().toString());
        String comment = commentTextArea.getText();
        
        NewReview newReview = new NewReview(calification, comment, Global.emailUser, 
        Global.emailSeller, Global.productId, Global.productName, Global.productPrice,
        Global.productAmount, Global.productCondition, Global.emailSeller);
        Global.reviewList.add(newReview);
        
        for (ProductSold productSold : Global.soldProductList) {
                
                String idProduct = productSold.getId();
                String email = productSold.getEmailSeller();
                
                if (idProduct.equals(Global.productId) && email.equals(Global.emailSeller)){
                    
                    productSold.setStatusReviewSeller("Done");
   
                }
                
            }
        
        
        clearSoldProductTable();
        loadProductsPurchasedListToTable();
        
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
            java.util.logging.Logger.getLogger(BuyerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuyerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuyerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuyerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuyerView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProductButton;
    private javax.swing.JButton addReviewButton;
    private javax.swing.JComboBox<String> calificationComboBox;
    private javax.swing.JTextArea commentTextArea;
    private javax.swing.JButton deleteProductButton;
    private javax.swing.JButton doReviewButton;
    private javax.swing.JTextField itemAmountTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton makePurchaseButton;
    private javax.swing.JButton modifyAmountButton;
    private java.awt.Panel panel1;
    private javax.swing.JTextField priceAmountTextField;
    private javax.swing.JTable productsTable;
    private javax.swing.JTextField rateTextField;
    private javax.swing.JTable soldProductTable;
    private javax.swing.JButton statisticsButton;
    private javax.swing.JTextField userNameReviewTextField;
    private javax.swing.JTextField userTextField;
    public static javax.swing.JTable wishListTable;
    // End of variables declaration//GEN-END:variables
}
