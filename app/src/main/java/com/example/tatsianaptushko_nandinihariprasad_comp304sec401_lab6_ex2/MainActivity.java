package com.example.tatsianaptushko_nandinihariprasad_comp304sec401_lab6_ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent =new Intent(MainActivity.this, ServicesActivity.class);
        startActivity(intent);
    }
}