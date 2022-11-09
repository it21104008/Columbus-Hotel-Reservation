package com.example.paymentlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Discounts extends AppCompatActivity {


    DatabaseReference databaseReference;
    TextView nameOnCard,payAmount,cardNumber,CVC,DOE;
    MaterialButton cancelButton,updateButton;
    String key;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discounts);



        Button payButton=(Button) findViewById(R.id.pay);

        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityThanks();
            }
        });
    }

    public void openActivityThanks(){
        Intent intenttnx = new Intent(this,ThankYou.class);
        startActivity(intenttnx);
    }

}