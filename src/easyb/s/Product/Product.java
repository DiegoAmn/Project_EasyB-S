


//This is the main class of product. In this class is the most important information of the product.

package easyb.s.Product;



public abstract class Product {
    private String id;
    private String productName;
    private int price;
    private int amount;
    private String condition;
    private String emailSeller;
    

    public Product(String id, String productName, int price, int amount, String condition, String emailSeller) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.amount = amount;
        this.condition = condition;
        this.emailSeller = emailSeller;
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getEmailSeller() {
        return emailSeller;
    }

    public void setEmailSeller(String emailSeller) {
        this.emailSeller = emailSeller;
    }
    
    
    
    
    //Polymorphic method
    
    
    //This method obtains information from product.
    public abstract String getInformation();
    
}
