package com.solvworthcorporation.myaccount;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Sonesis 04/01/2017.
 */
public class PrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;


    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences("acc", PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setAmount(int amount) {
        editor.putInt("amu", amount);
        editor.commit();
    }

    public int getAmount() {
        return pref.getInt("amu", 0);
    }
}
