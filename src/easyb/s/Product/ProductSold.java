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

//This is the class you will find all the information that is needed to make an appropriate sale of a product.

public class ProductSold extends Product{
    
    private String emailBuyer;
    private String statusReviewBuyer;
    private String statusReviewSeller;
    
    

    
    public ProductSold(String emailBuyer, String statusReviewBuyer, String statusReviewSeller, String id, String productName, int price, int amount, String condition, String emailSeller) {
        super(id, productName, price, amount, condition, emailSeller);
        this.emailBuyer = emailBuyer;
        this.statusReviewBuyer = statusReviewBuyer;
        this.statusReviewSeller = statusReviewSeller;
    }

    
    
    
    public String getEmailBuyer() {
        return emailBuyer;
    }

    public void setEmailBuyer(String emailBuyer) {
        this.emailBuyer = emailBuyer;
    }

    public String getStatusReviewBuyer() {
        return statusReviewBuyer;
    }

    public void setStatusReviewBuyer(String statusReviewBuyer) {
        this.statusReviewBuyer = statusReviewBuyer;
    }

    public String getStatusReviewSeller() {
        return statusReviewSeller;
    }

    public void setStatusReviewSeller(String statusReviewSeller) {
        this.statusReviewSeller = statusReviewSeller;
    }

    @Override
    public String getInformation() {
        return  "ID product: " + this.getId()+ "\n" + "Product name : "+ this.getProductName()+ "\n" + 
                "Purchased Amount: " + String.valueOf(this.getAmount())+ "\n" + "Total Price: " + String.valueOf(this.getPrice())+ "\n" + 
                "condition: " + this.getCondition() + "\n" + "Email Seller: " + this.getEmailSeller() + "\n" +
                "Status Review Seller: " + this.getStatusReviewSeller() + "\n" + "Email Buyer: " + this.getEmailBuyer() + "\n" + 
                "Status Review Buyer: " + this.getStatusReviewBuyer(); 
                    
        
        
    }

    
    
  
}
