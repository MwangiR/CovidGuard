package com.test.blemonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class otpActivity extends AppCompatActivity {
private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        editText = findViewById(R.id.editTextPhone);
        findViewById(R.id.buttonContinue). setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = editText.getText().toString();
                if (number.isEmpty() || number.length()<10){
                    editText.setError("Valid number is required..");
                    editText.requestFocus();
                    return;
                }
                String phonenumber = "+"+number;
                Intent intent = new Intent(otpActivity.this, VerifyPhoneActivity.class);
                intent.putExtra("phonenumber", phonenumber);
                startActivity(intent);
            }
        });

    }
}