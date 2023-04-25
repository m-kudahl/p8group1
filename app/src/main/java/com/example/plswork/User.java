package com.example.plswork;

public class User {

    private String email;
    private String fullName;
    private String municipality;


    public User() {
    }

    public void setUserEmail(String email){
        this.email = email;
    }
    public String getUserEmail(){
        return email;
    }

    public void setUserFullName(String name){
        this.fullName = name;
    }
    public String getUserFullName(){
        return fullName;
    }

    public void setUserMunicipality(String municipality){
        this.municipality = municipality;
    }

    public String setUserMunicipality(){
        return municipality;
    }
}

