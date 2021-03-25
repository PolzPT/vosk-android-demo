package org.kaldi.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpForm extends AppCompatActivity {

    //Variables
    private String mTag = "sign_in_form";
    TextInputLayout regFullName, regEmailAddress, regPassword;
    Button regCreateAcc;
    DatabaseReference reff;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mTag);

        //Hooks to all xml elements in sign_in_form.xml
        regFullName = findViewById(R.id.reg_full_name);
        regEmailAddress = findViewById(R.id.reg_email_address);
        regPassword = findViewById(R.id.reg_password);
        regCreateAcc = findViewById(R.id.reg_create_account_btn);

        user = new User();
        reff = FirebaseDatabase.getInstance().getReference().child("User");

        regCreateAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = regFullName.toString().trim();
                String email = regEmailAddress.toString().trim();
                String password = regPassword.toString().trim();
                user.setFirstName(name);
                user.setEmail(email);
                user.setPassword(password);
                reff.push().setValue(user);
                Toast.makeText(SignUpForm.this, "User Account Created",  Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setContentView(String tag) {
        int id = getResources().getIdentifier(tag, "layout", getPackageName());
        setContentView(id);
    }

}
