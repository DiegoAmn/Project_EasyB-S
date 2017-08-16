/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyb.s.Product;

/**
 *
 * @author Steve
 */

//This class is used to introduce new products from the seller which they put on sale.

public class NewProduct extends Product{

    public NewProduct(String id, String productName, int price, int amount, String condition, String emailSeller) {
        super(id, productName, price, amount, condition, emailSeller);
    }

    
   
    
    @Override
    public String getInformation() {
        return  "ID product: " + this.getId()+ "\n" + "Product name : "+ this.getProductName()+ "\n" + 
                "Amount: " + String.valueOf(this.getAmount())+ "\n" + "Unit Price: " + String.valueOf(this.getPrice())+ "\n" + 
                "condition: " + this.getCondition() + "\n" + "Email Seller: " + this.getEmailSeller();
    }
    
}
