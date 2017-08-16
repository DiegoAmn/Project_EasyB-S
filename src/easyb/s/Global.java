/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyb.s;

import easyb.s.Product.NewProduct;
import easyb.s.Product.NewReview;
import easyb.s.Product.Product;
import easyb.s.Product.ProductSold;
import java.util.ArrayList;

/**
 *
 * @author Steve
 */

//In this section you can find all lists and variables.

public class Global {
    
    public static ArrayList<User> usersList = new java.util.ArrayList<>();
    public static ArrayList<NewProduct> productList = new java.util.ArrayList<>();
    public static ArrayList<ProductSold> soldProductList = new ArrayList<>(); 
    public static ArrayList<NewReview> reviewList = new ArrayList<>();
    
    public static String emailUser= "";
    
    public static String productId = "";
    public static String productName = "";
    public static int productAmount = 0;
    public static int productPrice = 0;
    public static String productCondition = "";
    public static String emailSeller = "";
    public static String emailBuyer = "";
    public static String statusReviewSeller = "";
    public static String statusReviewBuyer = "";
    
    public static int rowPurchasesListTable = 0;
    
    public static int actionBuyer = 0;
    
    }
