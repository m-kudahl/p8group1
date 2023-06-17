package com.example.plswork;

public class User {

    //the users attributes
    private String email;
    private String fullName;
    private String municipality;
    private String userId;

    //a empty constructor for a user, which is not used
    public User() {
    }

    //the constructor we use, that on creating the object sets the users attributes
    public User(String email, String fullName, String municipality, String userId) {
        this.email = email;
        this.fullName = fullName;
        this.municipality = municipality;
        this.userId = userId;
    }
    //a setter for email if the empty constructor were used
    public void setUserEmail(String email) {
        this.email = email;
    }
    //getter for the email, which we don't currently use since we retrieves data on users by user id
    public String getUserEmail() {
        return email;
    }
    //a setter for user id if the empty constructor were used
    public void setUserId(String userId) {
        this.userId = userId;
    }
    //getter for the user id which is used to retrieve user data
    public String getUserId() {
        return userId;
    }
    //a setter for the users full name if the empty constructor were used
    public void setUserFullName(String name) {
        this.fullName = name;
    }
    //getter for the full name, which we don't currently use since we retrieves data on users by user id
    public String getUserFullName() {
        return fullName;
    }
    //a setter for users municipality if the empty constructor were used
    public void setUserMunicipality(String municipality) {
        this.municipality = municipality;
    }
    //getter for the users municipality, which we don't currently use since we retrieves data on users by user id
    public String getUserMunicipality() {
        return municipality;
    }


}
