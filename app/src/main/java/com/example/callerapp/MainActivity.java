package com.example.callerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mbtnclick;
    private static final int REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbtnclick = findViewById(R.id.btnclick);
        mbtnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] Permissions = {Manifest.permission.READ_CONTACTS};
                ActivityCompat.requestPermissions(MainActivity.this, Permissions, REQUEST_CODE);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            Intent intent = new Intent(MainActivity.this,ContactScreen.class);
            startActivity(intent);


        }else if(grantResults[0] == PackageManager.PERMISSION_DENIED){
           showToast("Contacts not found");
        }
    }

    private void showToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}