package com.monstarlabsph.potatoesandroid.ui.elements;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.NumberPicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;

import com.monstarlabsph.potatoesandroid.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static com.monstarlabsph.potatoesandroid.R.style;

public class SpinnerInButton extends androidx.appcompat.widget.AppCompatButton implements View.OnClickListener{
    private Context selfContext;
    private AlertDialog.Builder alertDialog;
    private LinearLayout mainViews;
    private LinearLayout viewsLinearTopButton;
    private LinearLayout viewsLinearNumberPicker;
    List<NumberPicker> addNumberPickerValue =new ArrayList<NumberPicker>();

    public SpinnerInButton(Context context) {
        super(context);
        selfContext = context;
        init(context);
    }

    public SpinnerInButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        selfContext = context;
        init(context);
       //? this.setVisibility(INVISIBLE);


    }

    public SpinnerInButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        selfContext = context;
        init(context);
    }

    public NumberPicker addNumberFormat( String[] valueArray) {
        NumberPicker numbPicker = new NumberPicker( selfContext );

        numbPicker.setWrapSelectorWheel(false);

        numbPicker.setMinimumWidth(500);
        numbPicker.setMinimumHeight(200);

        numbPicker.setMaxValue(valueArray.length-1);
        numbPicker.setMinValue(0);
        numbPicker.setDisplayedValues(valueArray);
        addNumberPickerValue.add(numbPicker);
        return numbPicker;

    }
    public void init(Context context){

        alertDialog = new AlertDialog.Builder(context, style.AlertDialogTheme);
        Context dialogContext = alertDialog.getContext();

        mainViews=new LinearLayout(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.gravity =  Gravity.BOTTOM;
        mainViews.setPadding(15, 15, 15, 15);
        mainViews.setOrientation(LinearLayout.VERTICAL);//.orientation = LinearLayout.VERTICAL
        mainViews.setLayoutParams(params);//.layoutParams = params

        this.setOnClickListener(this);

        viewsLinearTopButton=new LinearLayout(context);
        LinearLayout.LayoutParams viewsLinearTopButtonParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        viewsLinearTopButtonParams.gravity = Gravity.CENTER_HORIZONTAL;
        viewsLinearTopButtonParams.weight = 1;
        viewsLinearTopButtonParams.rightMargin=5;
        viewsLinearTopButtonParams.leftMargin=5;
        viewsLinearTopButton.setLayoutParams(viewsLinearTopButtonParams);

        initializeDialogTopButton(context);

        viewsLinearNumberPicker=new LinearLayout(context);
        LinearLayout.LayoutParams viewsLinearNumberPickerParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        viewsLinearNumberPicker.setPadding(15, 15, 15, 15);
        viewsLinearNumberPicker.setOrientation(LinearLayout.HORIZONTAL);
        viewsLinearNumberPicker.setLayoutParams(viewsLinearNumberPickerParams);
        for(int i = 0; i<addNumberPickerValue.size(); i++){
            viewsLinearNumberPicker.addView(addNumberPickerValue.get(i));
        }
        mainViews.addView(viewsLinearTopButton);
        mainViews.addView(viewsLinearNumberPicker);
        alertDialog.setView(mainViews);


    }

    private void viewRemoveAll(){
        viewsLinearNumberPicker.removeAllViews();
        viewsLinearTopButton.removeAllViews();
        mainViews.removeAllViews();
    }
    private void initializeDialogTopButton(Context context){
        DisplayMetrics getMetrics = getWindowDisplayMetrics();

        Button btnDone = new Button(context);
        btnDone.setText("Yes");
        btnDone.setBackgroundDrawable( new ColorDrawable(Color.TRANSPARENT)    );
        btnDone.setMinWidth((int)(getMetrics.widthPixels/2.5));
        btnDone.setGravity(Gravity.RIGHT);


        Button btnCancel = new Button(context);
        btnCancel.setText("Ok");//fragment?.getString(R.string.alert_dialog_btn_cancel)
        btnCancel.setBackgroundDrawable( new ColorDrawable(Color.TRANSPARENT)    );
        btnCancel.setMinWidth((int)(getMetrics.widthPixels/2.5));
        btnCancel.setGravity(Gravity.LEFT);
        viewsLinearTopButton.addView(btnCancel);
        viewsLinearTopButton.addView(btnDone);

    }
    private DisplayMetrics  getWindowDisplayMetrics() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
       // fragment?.activity?.windowManager?.defaultDisplay?.getMetrics(displayMetrics)
        return displayMetrics;
    }
    private void buildVersion(Window lp) {
        if(Build.VERSION.SDK_INT <16){
            lp.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }else{

            View decorView = lp.getDecorView();
            int uiOption = View.SYSTEM_UI_FLAG_VISIBLE;
            decorView.setSystemUiVisibility(uiOption) ;
        }
    }
    @Override
    public void onClick(View view) {
        //
        viewRemoveAll();
        init(view.getContext());
        AlertDialog alertDialogCreate = alertDialog.create();
        alertDialogCreate.setCanceledOnTouchOutside(false);

        alertDialogCreate.show();

        Window lp = alertDialogCreate.getWindow();
        buildVersion(lp);
        lp.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        lp.setGravity(Gravity.BOTTOM);
        lp.setBackgroundDrawable( new ColorDrawable(android.graphics.Color.WHITE));

    }
}
