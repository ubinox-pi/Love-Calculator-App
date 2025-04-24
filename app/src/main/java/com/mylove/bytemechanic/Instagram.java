package com.mylove.bytemechanic;

import static android.content.Intent.ACTION_VIEW;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Instagram extends AppCompatActivity {

    ImageView ashish,ayshi;
    TextView ashish1,ayshi1;
    DatabaseReference fdb;

    String Ashish,Ayshi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        fdb = FirebaseDatabase.getInstance().getReference("Link");
        ashish = findViewById(R.id.instagram_ashish);
        ayshi = findViewById(R.id.instagram_ayshi);
        ayshi1 = findViewById(R.id.instagram_ayshi1);
        ashish1 = findViewById(R.id.instagram_ashish1);

        ashish.setOnClickListener(v -> {
            Intent(Ashish);
        });
        ashish1.setOnClickListener(v->{
            Intent(Ashish);
        });
        ayshi.setOnClickListener(v -> {
            Intent(Ayshi);
        });
        ayshi1.setOnClickListener(v->{
            Intent(Ayshi);
        });

        fdb.child("Ashish").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    Ashish = snapshot.getValue(String.class);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Ashish = "https://www.instagram.com/hello_world.byte";
            }
        });

        fdb.child("Ayshi").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    Ayshi = snapshot.getValue(String.class);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Ayshi = "https://www.instagram.com/shannidhya_?utm_source=ig_web_button_share_sheet&igsh=ZDNlZDc0MzIxNw==";
            }
        });
    }

    void Intent(String s){
        try {
            Intent instag = new Intent(ACTION_VIEW, Uri.parse(s));
            instag.setPackage("com.instagram.android");
            startActivity(instag);
        }
        catch (Exception e)
        {
            Intent instag = new Intent(ACTION_VIEW, Uri.parse(s));
            startActivity(instag);
        }
    }
}