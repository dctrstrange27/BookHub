package com.example.jason_valley.db;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

public class helper {

    final static String EMAIL = "tripleam2022@gmail.com", PASS = "htrnfenswszubgmv";
    public static String randomKey(int length) {
        String genCars = "";

        int nums[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        while (length > 0) {
            genCars += nums[randomNum()];
            length--;
        }
        return genCars;
    }

    public static int randomNum() {
        return new Random().nextInt(9);
    }

    public static boolean checkIfExist(String from, String what){
        String strry [] = from.split(",");
        for(String st : strry) if(st.equals(what)) return true;
        return false;
    }

    public static String seatGenerator(int startseat, int endseat){
        String seat = "";
        for(; startseat <= endseat; startseat++)
            seat += startseat + (startseat == endseat ? "" : ",");
        return seat;
    }

    public static String toISODateString(Date date) {
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        sdf.setTimeZone(TimeZone.getTimeZone("CET"));
        String ISO = sdf.format(date);
        return ISO;
    }

    public static void saveImage(File file, Bitmap bitmap){
        if (!file.exists()) {
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                fos.flush();
                fos.close();
            } catch (java.io.IOException e) {
                System.out.println("Helper write image ");
                e.printStackTrace();
            }
        }
    }
    public static Bitmap getImage(File f){
        Bitmap btm = null;
        if (f.exists()) btm = BitmapFactory.decodeFile(f.getAbsolutePath());
        return btm;
    }
    public static void deleteFile(String filepath){
        File toDelete = new File(filepath);
        toDelete.delete();
    }
}
