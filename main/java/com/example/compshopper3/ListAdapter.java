package com.example.compshopper3;
//Made Following Angga Risky tutorial

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    Context context;
    ArrayList<MyList> myList;

    public ListAdapter(Context c, ArrayList<MyList> p) {
        context = c;
        myList = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.itemtitle.setText(myList.get(i).getItemtitle());
        myViewHolder.price1.setText(myList.get(i).getPrice1());
        myViewHolder.price2.setText(myList.get(i).getPrice2());
        myViewHolder.price3.setText(myList.get(i).getPrice3());
    }


    @Override
    public int getItemCount() {
        return myList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView itemtitle, price1, price2, price3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemtitle = (TextView) itemView.findViewById(R.id.itemtitle);
            price1 = (TextView) itemView.findViewById(R.id.price1);
            price2 = (TextView) itemView.findViewById(R.id.price2);
            price3 = (TextView) itemView.findViewById(R.id.price3);
        }
    }
}
