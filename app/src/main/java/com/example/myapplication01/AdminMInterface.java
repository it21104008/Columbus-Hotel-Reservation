package com.example.myapplication01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminMInterface extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_minterface);
    }

    //    Btn for Update Manage clients Page
    public void onclickMC(View view){
        Intent in=new Intent(this,MainActivity.class);
        startActivity(in);
    }

    //    Btn for Update Manage Payments Page
    public void onclickAB(View view){
        Intent in=new Intent(this,MainActivity4.class);
        startActivity(in);
    }

}