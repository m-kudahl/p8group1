package com.example.plswork;

public class User {

    private String email;
    private String fullName;
    private String municipality;
    private String userId;

    private String token;

    public User() {
    }

    public User(String email, String fullName, String municipality, String userId) {
        this.email = email;
        this.fullName = fullName;
        this.municipality = municipality;
        this.userId = userId;
    }

    public void setUserEmail(String email) {
        this.email = email;
    }

    public String getUserEmail() {
        return email;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserFullName(String name) {
        this.fullName = name;
    }

    public String getUserFullName() {
        return fullName;
    }

    public void setUserMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getUserMunicipality() {
        return municipality;
    }

    public String getUserToken() {
        return token;
    }
    public void setUserToken(String token) {
        this.token = token;
    }
}
