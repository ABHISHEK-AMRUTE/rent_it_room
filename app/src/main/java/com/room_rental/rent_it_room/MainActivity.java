package com.room_rental.rent_it_room;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.graphics.Color;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
import java.util.ArrayList;

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
    RecyclerView rooms_adapter,hostels_adapter,pg_adapter,marriage_adapter,party_adapter,plots_adapter;
    private adapter_rooms madapter;
    private adapter_hostel madapter1;
    private adapter_pg madapter2;
    private  adapter_marriage madapter3;
    private adapter_party madapter4;
    private adapter_plots madapter5;
    private RecyclerView.LayoutManager mlayoutmanager,mlayoutmanager1,mlayoutmanager2,mlayoutmanager3,mlayoutmanager4,mlayoutmanager5;
    ArrayList<suggestion_class> examplelist =new ArrayList<suggestion_class>();
    ArrayList<suggestion_class> examplelist2 =new ArrayList<suggestion_class>();
    ArrayList<suggestion_class> examplelist3 =new ArrayList<suggestion_class>();
    ArrayList<suggestion_class> examplelist4 =new ArrayList<suggestion_class>();
    ArrayList<suggestion_class> examplelist5 =new ArrayList<suggestion_class>();
    ArrayList<suggestion_class> examplelist1 =new ArrayList<suggestion_class>();

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





        linearLayout=findViewById(R.id.front_layer);


        /////initialize bottom sheet/////
        bottomsheet_inisitializer();
        /////initialize adapters/////
        initialise_recyclerview();


        examplelist.add(new suggestion_class("ada","Abhishek amrute","Rs 5000/month"));
        examplelist.add(new suggestion_class("ada","Shivam prajapati","Rs 5320/month"));
        examplelist.add(new suggestion_class("ada","Who am i?","Rs 4000/month"));
        examplelist.add(new suggestion_class("ada","Mai kaun hu?","Rs 6000/month"));
        examplelist.add(new suggestion_class("ada","John doe","Rs 51,000/month"));
        examplelist.add(new suggestion_class("ada","Savita kumbhar","Rs 2000/month"));
        examplelist.add(new suggestion_class("ada","Aamir khan","Rs 1000/month"));
        examplelist.add(new suggestion_class("ada","shah rukhhh khan","Rs 500/month"));

        examplelist1.add(new suggestion_class("ada","Abhishek amrute","Rs 5000/month"));
        examplelist1.add(new suggestion_class("ada","Shivam prajapati","Rs 5320/month"));
        examplelist1.add(new suggestion_class("ada","Who am i?","Rs 4000/month"));
        examplelist1.add(new suggestion_class("ada","Mai kaun hu?","Rs 6000/month"));
        examplelist1.add(new suggestion_class("ada","John doe","Rs 51,000/month"));
        examplelist1.add(new suggestion_class("ada","Savita kumbhar","Rs 2000/month"));
        examplelist1.add(new suggestion_class("ada","Aamir khan","Rs 1000/month"));
        examplelist1.add(new suggestion_class("ada","shah rukhhh khan","Rs 500/month"));

        examplelist2.add(new suggestion_class("ada","Abhishek amrute","Rs 5000/month"));
        examplelist2.add(new suggestion_class("ada","Shivam prajapati","Rs 5320/month"));
        examplelist2.add(new suggestion_class("ada","Who am i?","Rs 4000/month"));
        examplelist2.add(new suggestion_class("ada","Mai kaun hu?","Rs 6000/month"));
        examplelist2.add(new suggestion_class("ada","John doe","Rs 51,000/month"));
        examplelist2.add(new suggestion_class("ada","Savita kumbhar","Rs 2000/month"));
        examplelist2.add(new suggestion_class("ada","Aamir khan","Rs 1000/month"));
        examplelist2.add(new suggestion_class("ada","shah rukhhh khan","Rs 500/month"));

        examplelist3.add(new suggestion_class("ada","Abhishek amrute","Rs 5000/month"));
        examplelist3.add(new suggestion_class("ada","Shivam prajapati","Rs 5320/month"));
        examplelist3.add(new suggestion_class("ada","Who am i?","Rs 4000/month"));
        examplelist3.add(new suggestion_class("ada","Mai kaun hu?","Rs 6000/month"));
        examplelist3.add(new suggestion_class("ada","John doe","Rs 51,000/month"));
        examplelist3.add(new suggestion_class("ada","Savita kumbhar","Rs 2000/month"));
        examplelist3.add(new suggestion_class("ada","Aamir khan","Rs 1000/month"));
        examplelist3.add(new suggestion_class("ada","shah rukhhh khan","Rs 500/month"));

        examplelist4.add(new suggestion_class("ada","Abhishek amrute","Rs 5000/month"));
        examplelist4.add(new suggestion_class("ada","Shivam prajapati","Rs 5320/month"));
        examplelist4.add(new suggestion_class("ada","Who am i?","Rs 4000/month"));
        examplelist4.add(new suggestion_class("ada","Mai kaun hu?","Rs 6000/month"));
        examplelist4.add(new suggestion_class("ada","John doe","Rs 51,000/month"));
        examplelist4.add(new suggestion_class("ada","Savita kumbhar","Rs 2000/month"));
        examplelist4.add(new suggestion_class("ada","Aamir khan","Rs 1000/month"));
        examplelist4.add(new suggestion_class("ada","shah rukhhh khan","Rs 500/month"));

        examplelist5.add(new suggestion_class("ada","Abhishek amrute","Rs 5000/month"));
        examplelist5.add(new suggestion_class("ada","Shivam prajapati","Rs 5320/month"));
        examplelist5.add(new suggestion_class("ada","Who am i?","Rs 4000/month"));
        examplelist5.add(new suggestion_class("ada","Mai kaun hu?","Rs 6000/month"));
        examplelist5.add(new suggestion_class("ada","John doe","Rs 51,000/month"));
        examplelist5.add(new suggestion_class("ada","Savita kumbhar","Rs 2000/month"));
        examplelist5.add(new suggestion_class("ada","Aamir khan","Rs 1000/month"));
        examplelist5.add(new suggestion_class("ada","shah rukhhh khan","Rs 500/month"));




    }

    public void bottomsheet_inisitializer()
    {
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
    public void initialise_recyclerview()
    {
        rooms_adapter=     findViewById(R.id.room_recycler);
        hostels_adapter=   findViewById(R.id.hostels_recycler);
        pg_adapter=        findViewById(R.id.pg_recycler);
        marriage_adapter=  findViewById(R.id.marriagelawn_recycler);
        party_adapter=     findViewById(R.id.partyhall_recycler);
        plots_adapter=     findViewById(R.id.plot_recycler);
        rooms_adapter.setHasFixedSize(true);
        hostels_adapter.setHasFixedSize(true);
        pg_adapter.setHasFixedSize(true);
        marriage_adapter.setHasFixedSize(true);
        party_adapter.setHasFixedSize(true);
        plots_adapter.setHasFixedSize(true);

        mlayoutmanager =new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        mlayoutmanager1 =new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        mlayoutmanager2 =new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        mlayoutmanager3 =new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        mlayoutmanager4 =new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        mlayoutmanager5 =new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        madapter = new adapter_rooms(examplelist);
        madapter1 = new adapter_hostel(examplelist1);
        madapter2 = new adapter_pg(examplelist2);
        madapter3 = new adapter_marriage(examplelist3);
        madapter4 = new adapter_party(examplelist4);
        madapter5 = new adapter_plots(examplelist5);
        rooms_adapter.setLayoutManager(mlayoutmanager);
        rooms_adapter.setAdapter(madapter);

        hostels_adapter.setLayoutManager(mlayoutmanager1);
        hostels_adapter.setAdapter(madapter1);


        pg_adapter.setLayoutManager(mlayoutmanager2);
        pg_adapter.setAdapter(madapter2);

        marriage_adapter.setLayoutManager(mlayoutmanager3);
        marriage_adapter.setAdapter(madapter3);

        party_adapter.setLayoutManager(mlayoutmanager4);
        party_adapter.setAdapter(madapter4);

        plots_adapter.setLayoutManager(mlayoutmanager5);
        plots_adapter.setAdapter(madapter5);
    }
}
