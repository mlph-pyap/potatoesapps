package com.monstarlabsph.potatoesandroid.ui.kits;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.monstarlabsph.potatoesandroid.ui.kits.interfaces.RelativeLayoutTouchListener;

public class RelativeLayoutTouchEvent implements View.OnTouchListener {


        private String logTag = "ActivitySwipeDetector";
        private float MIN_DISTANCE =   100; // TODO change this runtime based on screen resolution. for 1920x1080 is to small the 100 distance

        private float MIN_DISTANCE_CLICK = 5;


        private float downX = 0;
    private float downY = 0f;
    private float upX = 0f;
    private float upY = 0f;
    private float moveX = 0f;
    private float moveY = 0f;
    private boolean isClick=false;
    private RelativeLayoutTouchListener relativeLayoutTouchListener; ;
    public RelativeLayoutTouchEvent(RelativeLayoutTouchListener relativeLayoutTouchListener, boolean isClick ){
        isClick = isClick;
        relativeLayoutTouchListener=relativeLayoutTouchListener;
    }

    void onRightToLeftSwipe(View view) {

      //  fragment.motionRightScreen()
        relativeLayoutTouchListener.motionRightScreen(view);

    }

    void onLeftToRightSwipe(View view) {

   //     fragment.motionLeftScreen()

        relativeLayoutTouchListener.motionLeftScreen(view);

    }

    void onTopToBottomSwipe(View view) {
        //  Log.i(logTag, "onTopToBottomSwipe!")
        relativeLayoutTouchListener.motionToBottomSwipe(view);


    }

    void onBottomToTopSwipe(View view) {
        //  Log.i(logTag, "onBottomToTopSwipe!")

        relativeLayoutTouchListener.motionBottomToTopSwipe(view);
    }
    void onClickEvent(View view) {
        //  Log.i(logTag, "onBottomToTopSwipe!")
     //   fragment.motionClickEvent(view)
        relativeLayoutTouchListener.onClickEvent(view);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        boolean isClickTrigger  = false;
        switch(event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                float deltaMoveX = Math.abs(event.getX()-moveX);
                float deltaMoveY = Math.abs(event.getY()-moveY);

                if(deltaMoveX>deltaMoveY){
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                  //  v?.parent?.requestDisallowInterceptTouchEvent(true)
                }else{
                    v.getParent().requestDisallowInterceptTouchEvent(false);
                  //  v?.parent?.requestDisallowInterceptTouchEvent(false)
                }

                moveX = event.getX();
                moveY = event.getY();
            break;
            case MotionEvent.ACTION_DOWN:
                upX = event.getX();
                upY = event.getY();

                downX = event.getX();
                downY = event.getY();
                return true;
            case MotionEvent.ACTION_UP:
                upX = event.getX();
                upY = event.getY();
                float deltaX = downX - upX;
                float deltaY = downY - upY;

                // swipe horizontal?
                boolean isClickWithTouch = false;
                if(isClick == true && !isClickTrigger){
                    isClickWithTouch = Math.abs(deltaX) < MIN_DISTANCE_CLICK || Math.abs(deltaY) < MIN_DISTANCE_CLICK;
                    isClickTrigger = true;
                }
                if ( isClickWithTouch ) {
                    Log.e("Press","click 2");
                    onClickEvent(v);
                }else{
                    Log.e("Press","swipe");

                    if (Math.abs(deltaX) > MIN_DISTANCE) {
                        // left or right
                        if (deltaX < 0) {
                            onLeftToRightSwipe(v);
                            return true;
                        }
                        if (deltaX > 0) {
                            onRightToLeftSwipe(v);
                            return true;
                        }
                    } else {
                        Log.i(logTag,
                                "Swipe was only " + Math.abs(deltaX) + " long horizontally, need at least " + MIN_DISTANCE);
                        // return false; // We don't consume the event
                    }

                    if (Math.abs(deltaY) > MIN_DISTANCE) {
                        // top or down
                        if (deltaY < 0) {
                            onTopToBottomSwipe(v);
                            return true;
                        }
                        if (deltaY > 0) {
                            onBottomToTopSwipe(v);
                            return true;
                        }
                    } else {
                        Log.i(logTag,
                                "Swipe was only " + Math.abs(deltaX) + " long vertically, need at least " + MIN_DISTANCE);
                        // return false; // We don't consume the event
                    }

                }


                return false;
        }
        return false;
    }
}
