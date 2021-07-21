package com.example.callerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class ContactScreen extends AppCompatActivity implements ItemOnClick {
    private RecyclerView mrecycleview;
    private ArrayList<Contact> contactArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_screen);
        intidview();
        buildview();
        setview();

    }

    private void setview() {
        ContactAdapter contactAdapter = new ContactAdapter(contactArrayList,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mrecycleview.setLayoutManager(linearLayoutManager);
        mrecycleview.setAdapter(contactAdapter);

    }

    private void buildview() {
        contactArrayList= new ArrayList<>();
        Contact contact = new Contact("Bill Gates","9988980908",R.drawable.billgates);
        contactArrayList.add(contact);
        Contact contact1 = new Contact("Steve Job","8456789023",R.drawable.steve);
        contactArrayList.add(contact1);
        Contact contact2 = new Contact("Alex","9986545454",R.drawable.alex);
        contactArrayList.add(contact2);
        Contact contact3 = new Contact("Billie","9859957436",R.drawable.billie);
        contactArrayList.add(contact3);
        Contact contact4 = new Contact("Ambulance","101",R.drawable.ambulance);
        contactArrayList.add(contact4);
    }

    private void intidview() {
        mrecycleview=findViewById(R.id.recycleview);

    }

    @Override
    public void onCLick(Contact contact) {
        String Data = contact.getNumber().toString();
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + Data));
        startActivity(intent);
    }
}