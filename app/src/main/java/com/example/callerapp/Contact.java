package com.example.callerapp;

public class Contact {
    private String name;
    private String number;
    private int image;

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public int getImage() {
        return image;
    }

    public Contact(String name, String number, int image) {
        this.name = name;
        this.number = number;
        this.image = image;
    }
}
