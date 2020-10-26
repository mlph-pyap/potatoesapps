package com.monstarlabsph.potatoesandroid.ui.kits.interfaces;

import android.view.View;

public interface RelativeLayoutTouchListener {

    public void motionRightScreen(View view);
    public void motionLeftScreen(View view);
    public void motionToBottomSwipe(View view);
    public void motionBottomToTopSwipe(View view);
    public void onClickEvent(View view);
}
