package com.bismilah.tomirf.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Wisata extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> Database;
    private ArrayList<Integer> Data;
    private String[] Judul = {"Tomi", "Ramdhan", "fauzi", "Ferdi", "Taufik", "Dzaki"};
    private int[] Gambar = {R.drawable.tomi1, R.drawable.tomi2, R.drawable.tomi3,
            R.drawable.tomi4, R.drawable.tomi5, R.drawable.tomi6,};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata);
        Database = new ArrayList<>();
        Data = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler);


        DaftarItem();
        //Menggunakan Layout Manager, Dan Membuat List Secara Vertical
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        //Membuat Underline pada Setiap Item Didalam List
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.line));
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new RecyclerViewAdapter(Database, Data);
        //Memasang Adapter pada RecyclerView
        recyclerView.setAdapter(adapter);
    }

    private void DaftarItem(){
        for (int w=0; w<Judul.length; w++){
            Data.add(Gambar[w]);
            Database.add(Judul[w]);
        }
    }
}