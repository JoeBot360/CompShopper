package com.example.compshopper3;
//built using Angga Risky tutorial


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
//import android.widget.Button;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView titlepage, subtitlepage, endpage;

    DatabaseReference reference;
    RecyclerView ourlist;
    ArrayList<MyList> list;
    ListAdapter listAdapter;


    //  Button btnAddNew;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titlepage = findViewById(R.id.titlepage);
        subtitlepage = findViewById(R.id.subtitlepage);
        endpage = findViewById(R.id.endpage);

       // btnAddNew = findViewById(R.id.btnAddNew);




        //working with data
        ourlist = findViewById(R.id.ourlist);
        ourlist.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<MyList>();

        //get data from firebase
        reference = FirebaseDatabase.getInstance().getReference().child("CompShopperApp");
        //Log.e("onCreate", "called");
        //if (true) {throw new NullPointerException("Called onCreate"); }
        Toast.makeText(getApplicationContext(), "created reference", Toast.LENGTH_LONG).show();

        reference.addValueEventListener( new ValueEventListener () {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //set code to retrieve data and replace layout
                //Toast.makeText(getApplicationContext(), "onDataChange called", Toast.LENGTH_LONG).show();

                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    MyList p = dataSnapshot1.getValue(MyList.class);
                    list.add(p);
                    p.setBestprice(p.price1);

                    Toast.makeText(getApplicationContext(), "p1:"+ p.bestprice,Toast.LENGTH_LONG).show();
                }
             //   MyList p = dataSnapshot.getValue(MyList.class);
             //   Toast.makeText(getApplicationContext(), "p: " + p, Toast.LENGTH_LONG).show();
             //   list.add(p);
                listAdapter = new ListAdapter(MainActivity.this, list);
                ourlist.setAdapter(listAdapter);
                listAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // set code to show an error
                Toast.makeText(getApplicationContext(), "Dude Where's My Data???", Toast.LENGTH_LONG).show();

            }


        });
    }
}
