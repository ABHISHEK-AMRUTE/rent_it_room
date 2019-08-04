package com.room_rental.rent_it_room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter_plots extends RecyclerView.Adapter<adapter_plots.Exampleviewholder> {

    private ArrayList<suggestion_class> mexamplelist;
    private adapter_plots.OnitemClickListner mlistner;



    public interface OnitemClickListner
    {
        void onItemClick(int position);
        void ondeleteclick(int position);


    }



    public void setonitemclickedlistner(adapter_plots.OnitemClickListner listner)
    {
        mlistner=listner;
    }
    public static  class Exampleviewholder extends RecyclerView.ViewHolder
    {
        public TextView owner_name,cost;
        public ImageView expand,featured_image;

        public Exampleviewholder(@NonNull View itemView, final adapter_plots.OnitemClickListner listner) {
            super(itemView);
            owner_name=itemView.findViewById(R.id.owner_name);
            cost=itemView.findViewById(R.id.price);
            featured_image=itemView.findViewById(R.id.featured_image);
            expand=itemView.findViewById(R.id.expand);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listner!=null)
                    {
                        int position = getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION)
                        {
                            listner.onItemClick(position);
                        }
                    }
                }
            });
            expand.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });



        }
    }
    public adapter_plots(ArrayList<suggestion_class> exaplelist){

        mexamplelist=exaplelist;
    }

    @NonNull
    @Override
    public adapter_plots.Exampleviewholder onCreateViewHolder(@NonNull ViewGroup parent, int i) {


        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.room_suggestion,parent,false);
        adapter_plots.Exampleviewholder evh= new adapter_plots.Exampleviewholder(v,mlistner);
        return  evh;
    }

    @Override
    public void onBindViewHolder(@NonNull final adapter_plots.Exampleviewholder holder, int i) {

        final suggestion_class currentitem =mexamplelist.get(i);
        holder.featured_image.setImageResource(R.drawable.plots);
        holder.owner_name.setText(currentitem.owner_name);
        holder.cost.setText(currentitem.price);
    }


    @Override
    public int getItemCount() {
        return mexamplelist.size();
    }
}
