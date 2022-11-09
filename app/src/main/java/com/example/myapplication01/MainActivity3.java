package com.example.myapplication01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void onclickMPBbtn(View view){
        Intent in=new Intent(this,MainActivity4.class);
        startActivity(in);
    }


    //    Btn for Update Manage Payments Page
    public void onclickMC(View view){
        Intent in=new Intent(this,MainActivity4.class);
        startActivity(in);
    }

}