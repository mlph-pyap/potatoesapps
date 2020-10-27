package com.monstarlabsph.potatoesandroid.ui.elements;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.appcompat.app.ActionBar;

import static com.monstarlabsph.potatoesandroid.R.style;
import static com.monstarlabsph.potatoesandroid.R.styleable;

public class ModalsBarLayout extends LinearLayout {

    public static int WRAP_CONTENT = 0;
    public static int MATCH_PARENT = 1;

    String layout_src;
    String project_src;

    private Context contextmain;
    private AttributeSet attrsmain;

    ViewBinding viewBinding;

    private Integer int_layout_src =0;
    private Integer int_project_src;

    private AlertDialog alertDialogCreate;

    private ModalsBarLayoutListener modalsBarLayoutListener;

    public ModalsBarLayout(Context context) {

        super(context);
        init(context, null, 0, 0);
    }

    public ModalsBarLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0, 0);
        //? this.setVisibility(INVISIBLE);
    }

    public ModalsBarLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr, 0);
    }

    public ModalsBarLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setIntLayoutSrc(Integer data) {
        int_layout_src = data;
    }

    public void setIntProjectSrc(ModalsBarLayoutListener data) {
        modalsBarLayoutListener = data;
    }

    public interface ModalsBarLayoutListener {
        void onViewModalsBar(Context context, View view);
    }

    private void initAttr(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        if (attrs != null) {
            TypedArray attributes = context.getTheme().obtainStyledAttributes(attrs, styleable.ModalsBarLayout, defStyleAttr, defStyleRes);
            layout_src = attributes.getString(styleable.ModalsBarLayout_layout_src);
            project_src = attributes.getString(styleable.ModalsBarLayout_project_src);
        }
    }

    private void init(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        initAttr(context, attrs, defStyleAttr, defStyleRes);
        contextmain = context;
        attrsmain = attrs;
    }
    private void buildVersion(Window lp) {
        if (Build.VERSION.SDK_INT < 16) {
            lp.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            lp.setDecorFitsSystemWindows(true);
        } else {
            View decorView = lp.getDecorView();
            int uiOption = View.SYSTEM_UI_FLAG_VISIBLE;
            decorView.setSystemUiVisibility(uiOption);
        }
    }

    public void show() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(contextmain, style.AlertDialogNumerPickerTheme);
        Context dialogContext = alertDialog.getContext();

        LayoutInflater myLayout = LayoutInflater.from(contextmain);
        final View dialogView = myLayout.inflate(int_layout_src, null);

        LinearLayout mainViews = new LinearLayout(contextmain, attrsmain);
        LinearLayout.LayoutParams params = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT
        );
        params.gravity = Gravity.BOTTOM;
        mainViews.setPadding(15, 15, 15, 15);
        mainViews.setOrientation(LinearLayout.VERTICAL);
        mainViews.setLayoutParams(params);

        LinearLayout.LayoutParams params_constraint = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT
        );
        dialogView.setLayoutParams(params_constraint);

        mainViews.addView(dialogView);
        alertDialog.setView(mainViews);
        alertDialogCreate = alertDialog.create();
        alertDialogCreate.setCanceledOnTouchOutside(false);

        if (modalsBarLayoutListener != null) {
            modalsBarLayoutListener.onViewModalsBar(dialogContext, dialogView);
        }

        Window lp = alertDialogCreate.getWindow();
        buildVersion(lp);

        lp.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        lp.setGravity(Gravity.BOTTOM);
        lp.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialogCreate.show();
    }
}
