package com.example.plswork;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//to show the notifications in a recyclerView, we create a class that handles showing the notifications
//the class extends androids RecyclerView.Adapter with a custom view holder: NotificationViewHolder
public class NotificationRecyclerView extends RecyclerView.Adapter<NotificationRecyclerView.NotificationViewHolder> {

    //we initiate a list of the Notification class and call it notifications
    private List<Notification> notifications;

    //a constructor which takes a list of notifications and set the notifications to those notifications
    public NotificationRecyclerView(List<Notification> notifications) {
        this.notifications = notifications;
    }

    //to show the notifications in a RecyclerView we overwrite the method from RecyclerView.Adapter called onCreateViewHolder method
    //The parent class called ViewGroup is the group of views the notification is part of, we don't use the viewType class so its just there because it has to
    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        //we create a new View with the content of the xml file notification_messages, which holds an empty title, empty text and empty timestamp, which we later
        //want to populate, the parent class is used to
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.notification_messages, viewGroup, false);
        //we then initiate a new view to create view to be able to show more notifications
        return new NotificationViewHolder(view);
    }

    //we then populate the contents in the view we just returned with the title, message and timestamp of the notification
    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {
        Notification notification = notifications.get(position);
        holder.titleTextView.setText(notification.getTitle());
        holder.messageTextView.setText(notification.getMessage());
        holder.timestampTextView.setText(notification.getTimestamp());
    }

    //the amount of notifications
    @Override
    public int getItemCount() {
        return notifications.size();
    }
    //to reference the textViews in the notification_messages class we need to reference them in this class to then pass the data to the other classes
    //like the onBindViewHolder class
    public static class NotificationViewHolder extends RecyclerView.ViewHolder {
        //this class has text views for title, message and timestamp in the notification_messages class
        public TextView titleTextView;
        public TextView messageTextView;
        public TextView timestampTextView;

        //the constructor of this class takes a view (xml file) and sets the NotificationViewHolders attributes to those text views
        public NotificationViewHolder(View view) {
            super(view);
            titleTextView = view.findViewById(R.id.titleTextView);
            messageTextView = view.findViewById(R.id.messageTextView);
            timestampTextView = view.findViewById(R.id.timestampTextView);
        }
    }
}

