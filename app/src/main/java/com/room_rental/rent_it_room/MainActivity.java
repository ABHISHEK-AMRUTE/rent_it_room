package com.room_rental.rent_it_room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
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

        sheetBehavior.setFitToContents(false);
        sheetBehavior.setHideable(false);
        sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
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
