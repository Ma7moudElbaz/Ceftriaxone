package com.cat.ceftriaxone.notifications;

public class Notifications_item {
    private final String title, body, imageUrl, date;

    public Notifications_item(String title, String body, String imageUrl, String date) {
        this.title = title;
        this.body = body;
        this.imageUrl = imageUrl;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDate() {
        return date;
    }
}
