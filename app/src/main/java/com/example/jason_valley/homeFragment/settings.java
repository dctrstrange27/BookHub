package com.example.jason_valley.homeFragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jason_valley.MainActivity;
import com.example.jason_valley.R;
import com.example.jason_valley.db.DataBase;
import com.example.jason_valley.front.front;
import com.example.jason_valley.login.login;
import com.example.jason_valley.login.signup;
import com.example.jason_valley.usermodel.loggedIn;

import java.util.List;

import at.favre.lib.crypto.bcrypt.BCrypt;


public class settings extends Fragment {
    private Bitmap bitmap;
    private Boolean hasNewImage = false;
    private ImageView cover;
    private TextView staticemail, staticusername, sw;
    private EditText usernameeditable, passwordeditable, conpass;
    private Button savebtn;
    private ImageButton close;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.setting, container, false);

        staticemail = v.findViewById(R.id.staticemail);
        staticusername = v.findViewById(R.id.staticUsername);
        usernameeditable = v.findViewById(R.id.usernameeditable);
        passwordeditable = v.findViewById(R.id.passwordeditable);
        sw = v.findViewById(R.id.sw);
        close = v.findViewById(R.id.closeL);
        savebtn = v.findViewById(R.id.savebtn);
        conpass = v.findViewById(R.id.passwordconfirmeditable);
        DataBase b = new DataBase(v.getContext());

        int checklogin = login.check();
        int checSignup = signup.check();
        String email = "";
        if(checklogin > 0){
            email = login.getEmail();
        }
        if(checSignup > 0){
            email = signup.getEmail();
        }
        List<loggedIn> userInfo = b.getUser(email);
        staticemail.setText(userInfo.get(0).getEmail());
        staticusername.setText(userInfo.get(0).getUsername());

        String finalEmail = email;
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = usernameeditable.getText().toString();
                String pass = passwordeditable.getText().toString();
                String conp = conpass.getText().toString();
                try {
                    if(user.equals("") || pass.equals("")){
                        Toast.makeText(v.getContext(), "Missing payloads", Toast.LENGTH_SHORT).show();
                    }else {
                        if (pass.equals(conp)) {
                            if(pass.length()  < 8){
                                Toast.makeText(v.getContext(), "Password is minimum of 8 characters", Toast.LENGTH_SHORT).show();
                            }else {
                                if (checkPassword(pass)) {
                                    String hash = BCrypt.withDefaults().hashToString(5, conp.toCharArray());
                                    Boolean handleUpdate = b.update(user, hash, finalEmail);
                                    if (handleUpdate) {
                                        Toast.makeText(v.getContext(), "successfully save", Toast.LENGTH_SHORT).show();
                                        onSuccess();
                                    }else {
                                        Toast.makeText(v.getContext(), "Failed to save", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(v.getContext(), "Password should have at least 1 Uppercase Letter", Toast.LENGTH_SHORT).show();
                                }
                            }
                        } else {
                            Toast.makeText(v.getContext(), "Password didn't Match", Toast.LENGTH_SHORT).show();
                        }
                    }

                }catch (Exception e){
                    System.out.println(e);
                }

            }
        });



        ((TextView) v.findViewById(R.id.logout)).setOnClickListener(JohnySinsei->{
            Dialog logoutconf = new Dialog(getContext());
            logoutconf.setContentView(R.layout.logout_dialog);
            logoutconf.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            logoutconf.getWindow().getAttributes().windowAnimations = R.style.diagAnim;
            logoutconf.show();

            ((ImageView) logoutconf.findViewById(R.id.closeL)).setOnClickListener(JohnySinsei2 -> {
                logoutconf.dismiss();
            });

            ((Button) logoutconf.findViewById(R.id.Yes)).setOnClickListener(JohnySinsei2 -> {
                Intent MAIN = new Intent(getContext(), MainActivity.class);
                startActivity(MAIN);
                getActivity().finish();
                System.exit(0);
                logoutconf.dismiss();
            });

            ((Button) logoutconf.findViewById(R.id.No)).setOnClickListener(JohnySinsei2 -> {
                logoutconf.dismiss();
            });
        });

        sw.setOnClickListener(JohnySinsei2 -> {
            Intent goToSignin = new Intent(getContext(), signup.class);
            startActivity(goToSignin);
        });


//        cover.setOnClickListener(JohnySensei -> {
//            Intent pickGal = new Intent(Intent.ACTION_PICK);
//            pickGal.setType("image/*");
//            pickGal.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//            startActivityForResult(pickGal, 1000);
//        });
        return v;
    }

    public void onSuccess(){
        Dialog logoutconf = new Dialog(getContext());
        logoutconf.setContentView(R.layout.success_save);
        logoutconf.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        logoutconf.getWindow().getAttributes().windowAnimations = R.style.diagAnim;
        logoutconf.show();

        ((ImageView) logoutconf.findViewById(R.id.closeS)).setOnClickListener(JohnySinsei2 -> {
            logoutconf.dismiss();
        });

        ((Button) logoutconf.findViewById(R.id.done)).setOnClickListener(JohnySinsei2 -> {
            Intent MAIN = new Intent(getContext(), MainActivity.class);
            startActivity(MAIN);
            getActivity().finish();
            System.exit(0);
            logoutconf.dismiss();
        });
    }
    public boolean checkPassword(String pass) {
        int c = 0;
        for (int a = 0; a < pass.length(); a++) {
            if (Character.isUpperCase(pass.charAt(a))) c++;
        }
        return c > 0;
    }

   // @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        mainHome parent = (mainHome) getActivity();
//        try {
//            if (resultCode == parent.RESULT_OK && requestCode == 1000) {
//                Uri targetUri = data.getData();
//                bitmap = BitmapFactory.decodeStream(parent.getContentResolver().openInputStream(targetUri));
//                hasNewImage = true;
//                cover.setImageBitmap(bitmap);
////              handleType();
//            } else if (resultCode == Activity.RESULT_CANCELED) {
//                System.out.println("CANCELLED ");
//            }
//        } catch (Exception e) {
//            System.out.println("Fire ERR " + e);
//        }
//    }

}