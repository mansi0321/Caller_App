package com.example.callerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactHolder> {
    private ArrayList<Contact> contacts;
    private ItemOnClick itemOnClick;

    public ContactAdapter(ArrayList<Contact> contacts, ItemOnClick itemOnClick) {
        this.itemOnClick = itemOnClick;
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_layout, parent, false);
        return new ContactHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactHolder holder, int position) {
        Contact contact = contacts.get(position);
        holder.setData(contact,itemOnClick);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
