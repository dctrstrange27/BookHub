package com.example.jason_valley.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jason_valley.R;
import com.example.jason_valley.db.DataBase;
import com.example.jason_valley.usermodel.userModel;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class signup extends AppCompatActivity {

    TextInputEditText password, email, username, conPassword;
    Button signup;
    TextView signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.signup);

        email = findViewById(R.id.email);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        conPassword = findViewById(R.id.conPassword);
        signup = findViewById(R.id.signup);
        signin = findViewById(R.id.signin);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToSignIn = new Intent(getApplicationContext(),login.class);
                startActivity(goToSignIn);
            }
        });
        //Signup
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String e = email.getText().toString();
                String user = username.getText().toString();
                String pass = Objects.requireNonNull(password.getText()).toString();
                String conPass = conPassword.getText().toString();
                userModel userModel;
                userModel = new userModel(-1, e, user, pass);
                if (user.equals("") || pass.equals("") || e.equals("") || conPass.equals("")) {
                    Toast.makeText(signup.this, "Missing payLoads! Please Fill all the Missing Fields", Toast.LENGTH_SHORT).show();
                    System.out.println("Error: Fill all Fields!!!");
                } else {
                    if (pass.equals(conPass)) {
                        DataBase db = new DataBase(signup.this);
                        Boolean doesExist = db.doesExist(e);
                      if(pass.length() < 8){
                          Toast.makeText(signup.this, "Password is minimum of 8 characters", Toast.LENGTH_LONG).show();
                      }else {
                          Boolean check = checkPassword(pass);
                          if(check){
                              if (!doesExist) {
                                  try {
                                      Boolean res = db.createUser(userModel);
                                      if (res) {
                                          Toast.makeText(signup.this, "Successful Creating an Account!", Toast.LENGTH_LONG).show();
                                      } else {
                                          Toast.makeText(signup.this, "Failure Creating User", Toast.LENGTH_LONG).show();
                                      }
                                  } catch (Exception err) {
                                      Toast.makeText(signup.this, "Error creating User", Toast.LENGTH_LONG).show();
                                  }
                              } else
                                  Toast.makeText(signup.this, "User Already Exist! Use other Email Address!", Toast.LENGTH_LONG).show();
                          }else Toast.makeText(signup.this, "Password should have at least 1 uppercase!", Toast.LENGTH_LONG).show();
                      }
                    } else
                        Toast.makeText(signup.this, "Password Didn't Match!", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    //check password if has an uppercase,more than 8 characters
    public boolean checkPassword(String pass) {
        int c = 0;
        for (int a = 0; a < pass.length(); a++) {
            if (Character.isUpperCase(pass.charAt(a))) c++;
        }
        return c > 0;
    }
}