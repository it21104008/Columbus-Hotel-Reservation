package com.example.paymentlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




//MASTERCARD Button



   Button masterButton=(Button) findViewById(R.id.masterButton);
   Button paypalButton=(Button)findViewById(R.id.paypalButton);




//anonymous inner class which create onClickListener interface and pass it



        masterButton.setOnClickListener(new View.OnClickListener() {
           @Override
        public void onClick(View view) {

      //calling method openActivityMaster
               openActivityMaster();
           }
       });



       paypalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPayPal();
            }
       });

    }





//Creating method
    public void openActivityMaster(){
        Intent intentMaster = new Intent(this, Mastercard.class);
        startActivity(intentMaster);
   }

    public void openPayPal(){
        Intent intentPaypal = new Intent(this,paypal.class);
        startActivity(intentPaypal);
    }
}