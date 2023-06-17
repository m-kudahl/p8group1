package com.example.plswork;

//a interface to check if notification permission is true or false
//is implemented in tab_layout to ensure that a permission check is used
public interface NotificationPermissionChecker {
    void onPermissionResult(boolean granted);

}
