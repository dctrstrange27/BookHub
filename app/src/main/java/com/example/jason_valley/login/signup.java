package com.example.jason_valley.login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jason_valley.R;
import com.example.jason_valley.db.DataBase;
import com.example.jason_valley.homeFragment.mainHome;
import com.example.jason_valley.usermodel.loggedIn;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;
import java.util.Random;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class signup extends AppCompatActivity {
    TextInputEditText password, email, username, conPassword;
    Button signup;
    TextView signin;
    EditText code;
    String getCode = "";


    boolean sendAgain = false;
    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        email = findViewById(R.id.email);
        username = findViewById(R.id.username);
        password = findViewById(R.id.passwd);
        conPassword = findViewById(R.id.conPassword);
        signup = findViewById(R.id.signup);
        gotToSignIn();

        //Signup
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String e = email.getText().toString();
                String user = username.getText().toString();
                String pass = Objects.requireNonNull(password.getText()).toString();
                String conPass = conPassword.getText().toString();
                if (user.equals("") || pass.equals("") || e.equals("") || conPass.equals("")) {
                    Toast.makeText(signup.this, "Missing payLoads! Please Fill all the Missing Fields", Toast.LENGTH_SHORT).show();
                    System.out.println("Error: Fill all Fields!!!");
                } else {
                    if (pass.equals(conPass)) {
                        if(checkPassword(pass)){
                            if(pass.length() < 8){
                                Toast.makeText(signup.this, "Password is minimum of 8 characters", Toast.LENGTH_SHORT).show();
                            }else {
                                if(doesExist(e)){
                                    Toast.makeText(signup.this, "user Already Exist!!", Toast.LENGTH_SHORT).show();
                                }else {
                                    sendMail(e);
                                    new Handler().postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                        verify();
                                        }
                                    },3500);
                                }
                            }
                        }else {
                            Toast.makeText(signup.this, "Password should have at least 1 Uppercase Letter", Toast.LENGTH_SHORT).show();
                        }
                    } else
                        Toast.makeText(signup.this, "Password Didn't Match!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    //verify user
    public void verifyUser(){
            try {
            DataBase db = new DataBase(signup.this);
            String e = email.getText().toString();
            String usr = username.getText().toString();
            String paswd = password.getText().toString();
            String hash = BCrypt.withDefaults().hashToString(12, paswd.toCharArray());
            loggedIn loggedIn;
            loggedIn = new loggedIn(-1,e,usr,hash,null,false,0,0);
            Boolean create = db.newUserLogIn(loggedIn);
            if(create){
                Toast.makeText(signup.this,"Successfully Registered!",Toast.LENGTH_SHORT).show();
                welcome();
            }else {
                Toast.makeText(signup.this,"Failed creating an Account",Toast.LENGTH_SHORT).show();
            }
        } catch (Exception err) {
            Toast.makeText(signup.this, "Error creating User", Toast.LENGTH_SHORT).show();
        }
    }

    public Boolean doesExist(String eUser){
        DataBase db = new DataBase(signup.this);
        return db.doesExist(eUser);
    }


    /// Verification diag
    public void verify(){

        Dialog verify = new Dialog(signup.this);
        verify.setContentView(R.layout.send_code);
        verify.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        verify.getWindow().getAttributes().windowAnimations=R.style.diagAnim;
        ImageButton closeV = verify.findViewById(R.id.closeV);
        Button ver  =  verify.findViewById(R.id.verify);
        code =  verify.findViewById(R.id.code);
        String e = email.getText().toString();
        TextView emails =  verify.findViewById(R.id.clickEmail);

        TextView c =  verify.findViewById(R.id.countdown);
        TextView exp = verify.findViewById(R.id.expired);
        TextView resend = verify.findViewById(R.id.resend);
        CountDownTimer start = new CountDownTimer(300000, 1000) {
            @SuppressLint("SetTextI18n")
            @Override
            public void onTick(long mili) {
                c.setText(""+(mili/1000)+" Seconds..");
                resend.setVisibility(View.GONE);
            }
            @Override
            public void onFinish() {
                sendAgain = true;
                getCode = "asfasdfawe";
                exp.setVisibility(View.GONE);
                resend.setVisibility(View.VISIBLE);
                resend.setText("Resend");
                c.setText("Code Expired! Send Token Again!");
                c.setTextColor(Color.rgb(255,57,51));
            }
        };
        start.start();

        resend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // call verify again
                if(sendAgain){
                    start.start();
                    verify();
                }else {
                    Toast.makeText(signup.this, "wait for Time to finish", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // will go to gmail.com
        emails.setText(e);
        emails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String google = "http://www.gmail.com";
                Uri webAdd = Uri.parse(google);
                Intent goToEmail = new Intent(Intent.ACTION_VIEW, webAdd);
                startActivity(goToEmail);
            }
        });
        // this will send to email
        verify.show();
        ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    try {
                        if(code.getText().toString().equals(getCode)){
                            verify.dismiss();
                            start.onFinish();
                            verifyUser();
                        }else {
                            Toast.makeText(signup.this, "Invalid Code!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }catch (Exception e){
                        System.out.println(e);
                    }
            }
        });
        closeV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verify.dismiss();
                start.onFinish();
            }
        });
    }
    public boolean sendMail(String e){
        String subject = "VERIFICATION CODE";
        int random =  rand.nextInt(10000);
        String code = Integer.toString(random);
        getCode = code;
        sendCode sendCode = new sendCode(signup.this,e,subject,code);
        sendCode.execute();
        return sendCode.isSend();
    }
    //welcome dialog
    public void welcome(){
        Dialog diag = new Dialog(this);
        diag.setContentView(R.layout.registered_successful);
        diag.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        diag.getWindow().getAttributes().windowAnimations=R.style.diagAnim;
        TextView name =  diag.findViewById(R.id.name);

        String user = username.getText().toString();
        name.setText(user);
        ImageButton close = diag.findViewById(R.id.close);

        //for closing dialog box
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diag.dismiss();
            }
        });
        diag.show();

        Button btnOkay = diag.findViewById(R.id.okay);
        btnOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(signup.this, "Welcome "+username.getText().toString()+"! Thank you for Signing up!", Toast.LENGTH_SHORT).show();
                diag.dismiss();
                Intent goToHome = new Intent(getApplicationContext(), mainHome.class);
                startActivity(goToHome);
            }
        });
    }
    // route to log in
    public void gotToSignIn(){
        signin = findViewById(R.id.sign_in);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToSignIn = new Intent(getApplicationContext(),login.class);
                startActivity(goToSignIn);
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
