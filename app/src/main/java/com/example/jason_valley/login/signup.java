package com.example.jason_valley.login;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.jason_valley.R;
import com.example.jason_valley.db.DataBase;

public class signup extends AppCompatActivity {
    EditText email,username,password,conPassword;
    Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.signup);
        DataBase db = new DataBase(this);
        email =  (EditText) findViewById(R.id.email);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        conPassword = (EditText) findViewById(R.id.conPassword);
        signup = (Button) findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String e = email.getText().toString();
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String conPass = conPassword.getText().toString();
                if(user.equals("")|| pass.equals("") || e.equals("")|| conPass.equals("")){
                    Toast.makeText(signup.this,"Missing payLoads! Please Fill all the Missing Fields",Toast.LENGTH_SHORT).show();
                    System.out.println("Error: Fill all Fields!!!");
                }else {
                    if(pass.equals(conPass)){
                            Boolean doesExist =  db.doesExist(e);
                        if(!doesExist){
                            Boolean create =  db.createUser(e,user,pass);
                              if(!create) {
                                  Toast.makeText(signup.this,"Registration Failed!!!",Toast.LENGTH_SHORT).show();
                              }
                           else {
                                  Toast.makeText(signup.this,"Registration Successful",Toast.LENGTH_SHORT).show();
                                  Intent goToSignIn = new Intent(getApplicationContext(),login.class);
                                  startActivity(goToSignIn);
                              }
                        }
                        Toast.makeText(signup.this,"User Already Exist.!!",Toast.LENGTH_SHORT).show();
                    }else
                        Toast.makeText(signup.this, "Password Didn't Match!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}