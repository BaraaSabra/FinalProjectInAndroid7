package com.example.finalprojectinandroid;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

public class AppUtility {

    public static String readFromAssests(Context context, String FileName) {
        String string="";
        try {
            InputStream inputStream= context.getAssets().open(FileName);
            //كم في قيم متوفره في هذا inputstream
            int size= inputStream.available();
            //تحويله inputstrem الى byte
            byte[] bytesObject=new byte[size];
            inputStream.read(bytesObject);
            inputStream.close();
            string =new String(bytesObject,"UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }
}
