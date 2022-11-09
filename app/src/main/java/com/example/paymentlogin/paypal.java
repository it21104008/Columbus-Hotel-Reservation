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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class paypal extends AppCompatActivity {



    private EditText name;
    private EditText cardNum;

    private Button save;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paypal);
        //Adding

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference  = firebaseDatabase.getReference();

        name = findViewById(R.id.paypalnm);
        cardNum = findViewById(R.id.password);

        save = findViewById(R.id.savePay);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getName = name.getText().toString();
                String getCard = cardNum.getText().toString();



                HashMap<String,Object> hashmap = new HashMap<>();
                hashmap.put("Email",getName);
                hashmap.put("password",getCard);


                databaseReference.child("Users")
                        .child(getName)
                        .setValue(hashmap)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(paypal.this, "Data Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(paypal.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }


        });







        //Buttons

        Button nextButton=(Button) findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityDis();
            }
        });

    }

    public void openActivityDis(){
        Intent intentDiscount = new Intent(this,Discounts.class);
        startActivity(intentDiscount);
    }






    // Update PayPal

    private void updateData(String name ,String cardNum) {

        HashMap<String, Object> Payment = new HashMap<>();
        Payment.put("cardNumber", name);
        Payment.put("cardHName", cardNum);


        databaseReference = FirebaseDatabase.getInstance().getReference("Payments");

        databaseReference.child("Users").updateChildren(Payment).addOnCompleteListener(task -> {

            if (task.isSuccessful()){
                Toast.makeText(paypal.this, "Successfully Updated", Toast.LENGTH_SHORT).show();

            }
            else {
                Toast.makeText(paypal.this, "Failed to update", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void clearControls(){
        name.setText("");
        cardNum.setText("");

    }




}


