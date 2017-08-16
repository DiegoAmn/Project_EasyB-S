/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyb.s.Users;

import Interfaces.ShowTime;
import Interfaces.ShowTypeOfUser;
import Interfaces.ShowUserView;
import easyb.s.User;
import easyb.s.Views.BuyerView;
import easyb.s.Views.StatisticView;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFrame;

/**
 *
 * @author Steve
 */

//This class is for the buyer. Everything that is done for this user must be done by this means.

public class Buyer extends User implements ShowTypeOfUser, ShowUserView, ShowTime{

    public Buyer(String name, int id, int age, String email, String country, String user, String passWord) {
        super(name, id, age, email, country, user, passWord);
    }

    @Override
    public String getInformation() {
         return "User Name: " + this.getName() + "\n" + "User ID: " + String.valueOf(this.getId()) + 
                 "\n" + "User Age: " + String.valueOf(this.getAge()) + "\n" + "User Email: " + 
                 this.getEmail() + "\n" + "Country: " + this.getCountry() + "\n" + "User Type: " + 
                 this.getUser() + "\n" + "User PassWord: " + this.getPassWord();
    }

    @Override
    public void showStatisticView() {

        StatisticView oStatisticView = new StatisticView();
        oStatisticView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        oStatisticView.setLocationRelativeTo(null);
        oStatisticView.setVisible(true);
        
    }

    @Override
    public void showTypeOfUser() {
        System.out.println("I am a Buyer and my name is " + this.getName());
    }

    @Override
    public void getShowTypeOfUser() {
        
        showTypeOfUser();
        
    }

    @Override
    public void showUserView() {
        
        BuyerView oBuyerView = new BuyerView();
        oBuyerView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        oBuyerView.setLocationRelativeTo(null);
        oBuyerView.setVisible(true);
          
    }
    
    @Override
    public void getShowUserView() {
        
        showUserView();
   
    }

    @Override
    public void showTime() {
        
        Calendar calendar = new GregorianCalendar();
        
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        
        System.out.println("Year: "+ year + " || " + "Month: " + month +" || " + "Day: " + day + 
                " || "+ "Hour: " + hour + ":" + minute + ":" + second);
        
    }

    @Override
    public void getShowTime() {
        
        showTime();
        
    }
 
}

