package com.example.paymentlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Mastercard extends AppCompatActivity {

private EditText name;
private EditText cardNum;
private EditText date;
private EditText cvv;
private Button save;
private FirebaseDatabase firebaseDatabase;
private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mastercard);

        // Save data from db

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference  = firebaseDatabase.getReference();

        name = findViewById(R.id.name);
        cardNum = findViewById(R.id.number);
        date = findViewById(R.id.expbt);
        cvv = findViewById(R.id.cvvbt);
        save = findViewById(R.id.saveButton);










        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getName = name.getText().toString();
                String getCard = cardNum.getText().toString();
                String getdates = date.getText().toString();
                String getcvv = cvv.getText().toString();





                HashMap<String,Object>  hashmap = new HashMap<>();
                hashmap.put("Name on Card",getName);
                hashmap.put("Card Number",getCard);
                hashmap.put("Date",getdates);
                hashmap.put("CVV",getcvv);

                databaseReference.child("Users")
                        .child(getName)
                        .setValue(hashmap)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(Mastercard.this, "Data Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Mastercard.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                }


        });






//Buttons
        Button nextButton=(Button) findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityDiscount();
            }
        });
    }

public void openActivityDiscount(){
    Intent intentdis = new Intent(this,Discounts.class);
    startActivity(intentdis);
}







 //Latest Update

    private void updateData(String name, String cardNumber, String date, String cvc) {

        HashMap<String, Object> Payment = new HashMap<>();
        Payment.put("cardNumber", name);
        Payment.put("cardHName", cardNumber);
        Payment.put("expDate", date);
        Payment.put("cvcCode", cvc);

        databaseReference = FirebaseDatabase.getInstance().getReference("Payments");

        databaseReference.child("Users").updateChildren(Payment).addOnCompleteListener(task -> {

            if (task.isSuccessful()){
                Toast.makeText(Mastercard.this, "Successfully Updated", Toast.LENGTH_SHORT).show();

            }
            else {
                Toast.makeText(Mastercard.this, "Failed to update", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void clearControls(){
        name.setText("");
        cardNum.setText("");
        date.setText("");
        cvv.setText("");
    }





}




