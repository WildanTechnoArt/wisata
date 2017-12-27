package com.bismilah.tomirf.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by tomi rf on 21/12/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<String> arrayList;
    private ArrayList<Integer> tomilist;

    public RecyclerViewAdapter(ArrayList<String> arrayList, ArrayList<Integer> tomilist){
        this.arrayList = arrayList;
        this.tomilist = tomilist;
    }
    //ViewHolder Digunakan Untuk Menyimpan Referensi Dari View-View
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView judultomi, tomi11;
        private ImageView tomi;
        private RelativeLayout tomilist;

        private Context context;

        public ViewHolder(View itemView){
            super(itemView);
            context = itemView.getContext();
            judultomi = itemView.findViewById(R.id.tomi1);
            tomi11 = itemView.findViewById(R.id.tomi11);
            tomi = itemView.findViewById(R.id.tomi);
            tomilist = itemView.findViewById(R.id.item_list);
            tomilist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    switch (getAdapterPosition()){
                        case 0:
                            intent = new Intent(context, Baturaden.class);
                            break;
                        case 1:
                            intent = new Intent(context, Balkem.class);
                            break;
                        case 2:
                            intent = new Intent(context, AlunAlun.class);
                            break;
                        case 3:
                            intent = new Intent(context, Baturaden.class);
                            break;
                        case 4:
                            intent = new Intent(context, Balkem.class);
                            break;
                        case 5:
                            intent = new Intent(context, AlunAlun.class);
                            break;
                    }
                    context.startActivity(intent);
                }
            });
        }
    }

    public ViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        //Membuat View untuk Menyiapkan dan Memasang Layout yang Akan digunakan pada RecyclerView
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_design, parent, false);
        ViewHolder VH = new ViewHolder(V);
        return VH;
    }
    @SuppressLint("SetTextI18n")
    public void onBindViewHolder (ViewHolder holder, final int position){
        final String Nama = arrayList.get(position);
        holder.judultomi.setText(Nama);
        holder.tomi11.setText("Gambar: "+ position);
        holder.tomi.setImageResource(tomilist.get(position));
        holder.judultomi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
    public int getItemCount(){
        //Menghitung Ukuran/Jumlah Data Yang Akan Ditampilkan Pada RecyclerView
        return arrayList.size();
    }

}