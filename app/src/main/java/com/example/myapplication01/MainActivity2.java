package com.example.myapplication01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }
    //    Back Button
    public void onclickAMbtn(View view){
        Intent in=new Intent(this,MainActivity.class);
        startActivity(in);
    }


    //    Btn for Update Manage Clients Page
    public void onclickMC(View view){
        Intent in=new Intent(this,MainActivity.class);
        startActivity(in);
    }


}