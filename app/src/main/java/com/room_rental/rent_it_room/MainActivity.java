package com.room_rental.rent_it_room;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.graphics.Color;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import android.widget.TextView;



import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    boolean halfExpanded=false;
    BottomNavigationView bottomNavigationView;
    TextView textSwitcher,notification,payRent,history,settings;

    Handler handler;
    int index;
    String[] text = {"have a property?","rent it now"};

    boolean animating=false;
    protected AlphaAnimation fadeIn = new AlphaAnimation(0.0f , 1.0f ) ;
    protected AlphaAnimation fadeOut = new AlphaAnimation( 1.0f , 0.0f ) ;

    Runnable runnable=new Runnable() {
        @Override
        public void run() {


            if(!animating){
                animate();
            }
            handler.postDelayed(runnable,0);

        }
    };

    private void animate() {


        animating=true;
        new CountDownTimer(6000, 3000) {
            @Override
            public void onTick(long millisUntilFinished) {

                if (index==2)
                    index=0;


                if(index==0)
                    textSwitcher.setBackgroundResource(0);
                else textSwitcher.setBackgroundResource(R.drawable.text_background);



                textSwitcher.setAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.fade_in));
                fadeIn.setStartOffset(0);
                fadeIn.setDuration(200);
                textSwitcher.startAnimation(fadeIn);
                fadeIn.setFillAfter(true);

                fadeOut.setFillAfter(true);
                fadeOut.setStartOffset(2600);
                fadeOut.setDuration(200);
                textSwitcher.setText(text[index]);
                index++;

                fadeIn.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        textSwitcher.startAnimation(fadeOut);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }

            @Override
            public void onFinish() {
                animating=false;

            }
        }.start();

    }

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setStatusBarColor(Color.parseColor("#9c27b0"));

        handler=new Handler();
        handler.postDelayed(runnable,0);
        runnable.run();
        index=0;

        linearLayout=findViewById(R.id.front_layer);
        toolbar=findViewById(R.id.toolbar);
        textSwitcher=findViewById(R.id.text_switcher);
        notification=findViewById(R.id.notification);
        payRent=findViewById(R.id.pay_rent);
        history=findViewById(R.id.history);
        settings=findViewById(R.id.settings);





        BottomSheetBehavior sheetBehavior=BottomSheetBehavior.from(linearLayout);
        bottomNavigationView=findViewById(R.id.bottom_nav_bar);

        sheetBehavior.setFitToContents(false);
        sheetBehavior.setHideable(false);

        sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sheetBehavior.getState()==BottomSheetBehavior.STATE_EXPANDED) {
                    notification.setVisibility(View.VISIBLE);
                    payRent.setVisibility(View.VISIBLE);
                    history.setVisibility(View.VISIBLE);
                    settings.setVisibility(View.VISIBLE);
                    toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_close_white_24dp));
                    sheetBehavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);
                    bottomNavigationView.setVisibility(View.GONE);
                    halfExpanded=true;
                }
                if(sheetBehavior.getState()==BottomSheetBehavior.STATE_HALF_EXPANDED){

                    toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_menu_white_24dp));
                    sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                    notification.setVisibility(View.GONE);
                    payRent.setVisibility(View.GONE);
                    history.setVisibility(View.GONE);
                    settings.setVisibility(View.GONE);
                    bottomNavigationView.setVisibility(View.VISIBLE);

                    halfExpanded=false;
                }
            }
        });







        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_DRAGGING&&halfExpanded) {

                    sheetBehavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);
                }
                if (newState == BottomSheetBehavior.STATE_DRAGGING&&!halfExpanded) {

                    sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

                notification.setAlpha((1-slideOffset)*2);
                payRent.setAlpha((1-slideOffset)*2);
                history.setAlpha((1-slideOffset)*2);
                settings.setAlpha((1-slideOffset)*2);

            }
        });




    }
}
