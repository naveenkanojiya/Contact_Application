package com.example.contactapplication;

public class ContactModal {
    int img;
    String name, number;


    public ContactModal(int img , String name , String number){
        this.name =name;
        this.number = number;
        this.img = img;
    }
    public ContactModal(String name , String number){
        this.name = name;
        this.number = number;
    }
}
