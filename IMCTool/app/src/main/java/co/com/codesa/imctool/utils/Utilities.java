package co.com.codesa.imctool.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import co.com.codesa.imctool.R;

/**
 * Created by jorgeluispenalopez on 13/10/16.
 */

public class Utilities {
    public static boolean isNotEmpty(String sbString) {
        return (sbString != null && !sbString.equals("") && !sbString.equals("null"));
    }

    public static boolean isNumber(String sbString){
        if(sbString.matches("\\d+(?:\\.\\d+)?"))
        {
            System.out.println("Matches");
            return true;
        }
        else
        {
            System.out.println("No Match");
            return false;
        }
    }


    public static void showSimpleAlertDialog(Context context, String sbTitle, String sbMessage) {
        // 1. Instantiate an AlertDialog.Builder with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage(sbMessage)
                .setTitle(sbTitle);
        builder.setNeutralButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        // 3. Get the AlertDialog from create()
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
