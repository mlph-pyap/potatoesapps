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

import com.monstarlabsph.potatoesandroid.ui.elements.core.spinnerbutton.NumberPickerData;

import java.util.ArrayList;
import java.util.List;

import static com.monstarlabsph.potatoesandroid.R.style;

public class SpinnerInButton extends androidx.appcompat.widget.AppCompatButton implements View.OnClickListener {
    private Context selfContext;
    private AlertDialog.Builder alertDialog;
    private LinearLayout mainViews;
    private LinearLayout viewsLinearTopButton;
    private LinearLayout viewsLinearNumberPicker;
    private AlertDialog alertDialogCreate;
    private Button btnDone;
    private Button btnCancel;

    private String textBtnDone = "Done";
    private String textBtnCancel = "Cancel";
    private boolean isBtnTextWillUpdatedWhenOnClick = false;
    private String textSplit = "";
    List<NumberPickerData> addNumberPickerValue = new ArrayList<NumberPickerData>();
    private SpinnerInButtonListener spinnerInButtonListener;

    public SpinnerInButton(Context context) {
        super(context);
        selfContext = context;
        init(context);
    }

    public SpinnerInButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        selfContext = context;
        init(context);


    }

    public SpinnerInButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        selfContext = context;
        init(context);
    }

    public List<String> getNumberFormatValue() {
        List<String> getNumberPickerValue = new ArrayList<String>();

        for (int i = 0; i < addNumberPickerValue.size(); i++) {
            NumberPicker dataPickerWidget = addNumberPickerValue.get(i).getNumberPicker();
            String[] dataPickerString = addNumberPickerValue.get(i).getValueArray();
            getNumberPickerValue.add(dataPickerString[dataPickerWidget.getValue()]);
        }


        return getNumberPickerValue;
    }

    public boolean getIsBtnTextWillUpdatedWhenOnClick() {
        return isBtnTextWillUpdatedWhenOnClick;
    }

    public void setIsBtnTextWillUpdatedWhenOnClick(boolean data) {
        isBtnTextWillUpdatedWhenOnClick = data;
    }

    public String getTextSplit() {
        return textSplit;
    }

    public void setTextSplit(String data) {
        textSplit = data;
    }

    private void initBtnTextWillUpdatedWhenOnClick() {
        if (isBtnTextWillUpdatedWhenOnClick == true) {
            List<String> dataInArray = getNumberFormatValue();

            String idList = dataInArray.toString();
            String idsListReplace = idList.substring(1, idList.length() - 1).replace(", ", textSplit);
            this.setText(idsListReplace);
        }
    }

    public NumberPicker addNumberFormat(String[] valueArray) {
        NumberPicker numbPicker = new NumberPicker(selfContext);

        numbPicker.setWrapSelectorWheel(false);


        numbPicker.setMinimumWidth(500);

        numbPicker.setMinimumHeight(200);

        numbPicker.setMaxValue(valueArray.length - 1);
        numbPicker.setMinValue(0);
        numbPicker.setDisplayedValues(valueArray);

        addNumberPickerValue.add(new NumberPickerData(numbPicker, valueArray));
        return numbPicker;

    }

    public void init(Context context) {


        alertDialog = new AlertDialog.Builder(context, style.AlertDialogNumerPickerTheme);

        Context dialogContext = alertDialog.getContext();

        mainViews = new LinearLayout(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.gravity = Gravity.BOTTOM;
        mainViews.setPadding(15, 15, 15, 15);
        mainViews.setOrientation(LinearLayout.VERTICAL);
        mainViews.setLayoutParams(params);

        this.setOnClickListener(this);

        viewsLinearTopButton = new LinearLayout(context);
        LinearLayout.LayoutParams viewsLinearTopButtonParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        viewsLinearTopButtonParams.gravity = Gravity.CENTER_HORIZONTAL;
        viewsLinearTopButtonParams.weight = 1;
        viewsLinearTopButtonParams.rightMargin = 5;
        viewsLinearTopButtonParams.leftMargin = 5;
        viewsLinearTopButton.setLayoutParams(viewsLinearTopButtonParams);

        initializeDialogTopButton(context);

        viewsLinearNumberPicker = new LinearLayout(context);
        LinearLayout.LayoutParams viewsLinearNumberPickerParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        viewsLinearNumberPickerParams.gravity = Gravity.CENTER_HORIZONTAL;
        viewsLinearNumberPicker.setPadding(15, 15, 15, 15);
        viewsLinearNumberPicker.setOrientation(LinearLayout.HORIZONTAL);
        viewsLinearNumberPicker.setLayoutParams(viewsLinearNumberPickerParams);

        for (int i = 0; i < addNumberPickerValue.size(); i++) {
            viewsLinearNumberPicker.addView(addNumberPickerValue.get(i).getNumberPicker());
        }
        mainViews.addView(viewsLinearTopButton);
        mainViews.addView(viewsLinearNumberPicker);
        alertDialog.setView(mainViews);


    }

    private void viewRemoveAll() {
        viewsLinearNumberPicker.removeAllViews();
        viewsLinearTopButton.removeAllViews();
        mainViews.removeAllViews();
    }

    public void setTextBtnDone(String value) {
        textBtnDone = value;
    }

    public void setTextBtnCancel(String value) {
        textBtnCancel = value;
    }

    public void onTopButtonClickEvent(@Nullable SpinnerInButton.SpinnerInButtonListener spinnerInButtonListener) {
        this.spinnerInButtonListener = spinnerInButtonListener;

    }


    public interface SpinnerInButtonListener {
        void onClickBtnCancel(View view);

        void onClickBtnDone(View view);
    }


    private void initializeDialogTopButton(Context context) {
        DisplayMetrics getMetrics = getWindowDisplayMetrics();

        btnDone = new Button(context);
        btnDone.setText(textBtnDone);
        btnDone.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        btnDone.setMinWidth((int) (getMetrics.widthPixels / 2));
        btnDone.setGravity(Gravity.RIGHT);


        btnCancel = new Button(context);
        btnCancel.setText(textBtnCancel);
        btnCancel.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        btnCancel.setMinWidth((int) (getMetrics.widthPixels / 2));
        btnCancel.setGravity(Gravity.LEFT);
        viewsLinearTopButton.addView(btnCancel);
        viewsLinearTopButton.addView(btnDone);

    }

    private DisplayMetrics getWindowDisplayMetrics() {
        DisplayMetrics displayMetrics = new DisplayMetrics();

        alertDialogCreate = alertDialog.create();
        Window lp = alertDialogCreate.getWindow();

        lp.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    private void buildVersion(Window lp) {
        if (Build.VERSION.SDK_INT < 16) {
            lp.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {

            View decorView = lp.getDecorView();
            int uiOption = View.SYSTEM_UI_FLAG_VISIBLE;
            decorView.setSystemUiVisibility(uiOption);
        }
    }

    @Override
    public void onClick(View view) {
        
        viewRemoveAll();
        init(view.getContext());
        alertDialogCreate = alertDialog.create();
        alertDialogCreate.setCanceledOnTouchOutside(false);

        Window lp = alertDialogCreate.getWindow();
        alertDialogCreate.show();
        btnDone.setOnClickListener(view12 -> {
            if (spinnerInButtonListener != null) {
                spinnerInButtonListener.onClickBtnDone(view12);
            }
            initBtnTextWillUpdatedWhenOnClick();
            viewRemoveAll();
            alertDialogCreate.cancel();
        });
        btnCancel.setOnClickListener(view1 -> {

            if (spinnerInButtonListener != null) {
                spinnerInButtonListener.onClickBtnCancel(view1);
            }


            viewRemoveAll();
            alertDialogCreate.cancel();
        });


        buildVersion(lp);
        lp.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        lp.setGravity(Gravity.BOTTOM);
        lp.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


    }


}
