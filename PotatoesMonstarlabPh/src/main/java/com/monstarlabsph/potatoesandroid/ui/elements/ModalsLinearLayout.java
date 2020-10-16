package com.monstarlabsph.potatoesandroid.ui.elements;

import android.app.AlertDialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import static com.monstarlabsph.potatoesandroid.R.*;

public class ModalsLinearLayout extends LinearLayout {
    public ModalsLinearLayout(Context context) {
        super(context);
    }

    public ModalsLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
       //? this.setVisibility(INVISIBLE);


    }

    public ModalsLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public ModalsLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    public void init(Context context,@Nullable AttributeSet attrs){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context, style.AlertDialogTheme);
        Context dialogContext = alertDialog.getContext();

        LinearLayout mainViews=new LinearLayout(context,attrs);
        LinearLayout.LayoutParams params = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT
        );
        params.gravity =  Gravity.BOTTOM;
        mainViews.setPadding(15, 15, 15, 15);
        mainViews.setOrientation(LinearLayout.VERTICAL);//.orientation = LinearLayout.VERTICAL
        mainViews.setLayoutParams(params);//.layoutParams = params



        for(int index = 0; index < ((ViewGroup) this).getChildCount(); index++) {
            View nextChild = ((ViewGroup) this).getChildAt(index);
            mainViews.addView(nextChild);
        }
        alertDialog.setView(mainViews);
        AlertDialog alertDialogCreate = alertDialog.create();
        alertDialogCreate.setCanceledOnTouchOutside(false);

        alertDialogCreate.show();
    }
}
