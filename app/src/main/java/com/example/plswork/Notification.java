package com.example.plswork;

/**
 * Getters and setters for notifikationerne
 */
public class Notification {

    //the notification class, a notification consists of a title, message and a timestamp
    private String title;
    private String message;

    private String timestamp;

    //an empty constructor if the setters are used
    public  Notification(){

    }

    //a constructor to construct the notification with a title, messsage and timestamp
    public Notification(String title, String message, String timestamp) {
        this.title = title;
        this.message = message;
        this.timestamp = timestamp;
    }
    //getter for the notifications title
    public String getTitle() {
        return title;
    }
    //setter for the notifications title
    public void setTitle(String title) {
        this.title = title;
    }
    //getter for the notifications message
    public String getMessage() {
        return message;
    }
    //setter for the notifications message
    public void setMessage(String message) {
        this.message = message;
    }
    //getter for the notifications timestamp
    public String getTimestamp() {
        return timestamp;
    }
    //setter for the notifications timestamp
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
