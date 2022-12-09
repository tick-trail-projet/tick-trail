package com.ticktrail.basic;

import com.jfoenix.animation.alert.*;

import javafx.geometry.Pos;
import javafx.util.Duration;

import javax.management.Notification;

import org.controlsfx.control.Notifications;

public class Error {
    private String title;
    private String text;
    private String type;

    public Error(String title, String text, String type) {
        this.title = title;
        this.text = text;
        this.type = type;
    }

    public void runNotification() {
        Notifications notification = Notifications.create();
        notification.title(this.getTitle());
        notification.text(this.getText());
        notification.hideAfter(Duration.seconds(5));
        notification.position(Pos.BASELINE_RIGHT);
        notification.show();
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Error title(String title) {
        setTitle(title);
        return this;
    }

    public Error text(String text) {
        setText(text);
        return this;
    }

    public Error type(String type) {
        setType(type);
        return this;
    }
}
