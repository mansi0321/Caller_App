package com.example.callerapp;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.BatchUpdateException;

public class ContactHolder extends RecyclerView.ViewHolder {
    private Button mbtnaditya;
    private ImageView mivaditya;

    public ContactHolder(@NonNull  View itemView) {
        super(itemView);
        intidviews(itemView);
    }

    private void intidviews(View itemView ) {
        mbtnaditya = itemView.findViewById(R.id.btnbill);
        mivaditya = itemView.findViewById(R.id.ivbill);

    }

    public void setData(Contact contact, ItemOnClick itemOnClick){
        mivaditya.setBackgroundResource(contact.getImage());
        mbtnaditya.setText(contact.getName());
        mbtnaditya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemOnClick.onCLick(contact);
            }
        });
    }
}
