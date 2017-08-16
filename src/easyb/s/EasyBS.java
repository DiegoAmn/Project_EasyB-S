/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyb.s;

import easyb.s.Users.Buyer;
import easyb.s.Users.Seller;
import easyb.s.Views.UserView;

/**
 *
 * @author Steve
 */
public class EasyBS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Buyer newUserBuyer = new Buyer("Steve Araya",206950338,25,"steve","Costa Rica","Buyer","1234");
            Global.usersList.add(newUserBuyer);
        newUserBuyer = new Buyer("Diego Martinez",207860247,18,"diego","Costa Rica","Buyer","1234");
            Global.usersList.add(newUserBuyer);
        Seller newUserSeller = new Seller("","Diego",207860247,18,"diegoMartinez","Costa Rica","Seller","12");
            Global.usersList.add(newUserSeller);
        newUserSeller = new Seller("","Adelso Araya",204560678,22,"adelso","Costa Rica","Seller","1");
            Global.usersList.add(newUserSeller);
        
        UserView mainView = new UserView();
        mainView.setLocationRelativeTo(mainView);
        mainView.setVisible(true);
        
        
        
        
        

    }

}
