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

//This class is the one used to perform the reviews of sellers and buyers.

public class NewReview extends Product{
    
    private int calification;
    private String comment;
    private String whoMakeIt;
    private String forWhom;

    
    
    
    public NewReview(int calification, String comment, String whoMakeIt, String forWhom, String id, String productName, int price, int amount, String condition, String emailSeller) {
        super(id, productName, price, amount, condition, emailSeller);
        this.calification = calification;
        this.comment = comment;
        this.whoMakeIt = whoMakeIt;
        this.forWhom = forWhom;
    }

    
    
    
    public int getCalification() {
        return calification;
    }

    public void setCalification(int calification) {
        this.calification = calification;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getWhoMakeIt() {
        return whoMakeIt;
    }

    public void setWhoMakeIt(String whoMakeIt) {
        this.whoMakeIt = whoMakeIt;
    }

    public String getForWhom() {
        return forWhom;
    }

    public void setForWhom(String forWhom) {
        this.forWhom = forWhom;
    }

    @Override
    public String getInformation() {
        
        return  "ID product: " + this.getId()+ "\n" + "Product name : "+ this.getProductName()+ "\n" + 
                "Purchased Amount: " + String.valueOf(this.getAmount())+ "\n" + "Total Price: " + String.valueOf(this.getPrice())+ "\n" + 
                "condition: " + this.getCondition() + "\n" + "Email Seller: " + this.getEmailSeller() + "\n" +
                "Calification: " + String.valueOf(this.getCalification()) + "\n" + "Comment: " + this.getComment() + "\n" +
                "Who Make It: " + this.getWhoMakeIt() + "\n" + "For Whom: " + this.getForWhom();
    }
 
}
