package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        TextView name = findViewById(R.id.fullnameet);
        TextView email = findViewById(R.id.emailet);
        TextView pass = findViewById(R.id.passet);
        TextView phone = findViewById(R.id.phoneet);


        Info info = new Info();

        name.setText(info.getName());
        email.setText(info.getEmail());
        pass.setText(info.getPass());
        phone.setText(info.getPhone());


    }
}