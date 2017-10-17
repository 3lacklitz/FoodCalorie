package com.example.administrator.foodcalorie;

import android.content.Context;
import android.widget.Toast;

public class Util {
    Util(){

    }
    public static boolean validateData (String insertWeight, String insertHigh,
                                        String insertAge, Context context) {
        boolean isEmpty = false;
        if (insertWeight.equals("")) {
            isEmpty = true;
            Toast.makeText(context, "Please input Weight", Toast.LENGTH_LONG).show();
            return isEmpty;
        } else if (insertHigh.equals("")) {
            isEmpty = true;
            Toast.makeText(context, "Please input High", Toast.LENGTH_LONG).show();
            return isEmpty;
        } else if (insertAge.equals("")) {
            isEmpty = true;
            Toast.makeText(context, "Please input Age", Toast.LENGTH_LONG).show();
            return isEmpty;
        }
        return false;
    }
}
