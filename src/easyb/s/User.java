/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyb.s;

/**
 *
 * @author Steve
 */

//This is the main class of the EasyB&S program.

public abstract class User {
    
    private String name;
    private int id;
    private int age;
    private String email;
    private String country;
    private String user;
    private String passWord;

    
    
    
    public User(String name, int id, int age, String email, String country, String user, String passWord) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.email = email;
        this.country = country;
        this.user = user;
        this.passWord = passWord;
    }

    
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    
    
    //Polymorphic methods
    
    //This method obtains information from users.
    public abstract String getInformation();
    
    
    public abstract void showStatisticView();
    
    
    public abstract void getShowTypeOfUser();
    
    
    public abstract void getShowUserView();
    
    
    public abstract void getShowTime();
    
    
      
}

    
    