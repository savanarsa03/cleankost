package com.example.cleankost.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cleankost.model.User;
import com.example.cleankost.R;

import java.util.List;

public class AdapterCleaning extends RecyclerView.Adapter<AdapterCleaning.MyViewHolder> {
    private Context context;
    private List<User> list;
    private Dialog dialog;

    public interface Dialog{
        void onClick(int pos);
    }
    public void setDialog(Dialog dialog){
        this.dialog = dialog;
    }
    public AdapterCleaning(Context context , List<User> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_clean, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position){
        holder.nama.setText(list.get(position).getName());
        holder.alamat.setText(list.get(position).getAlamat());
        holder.telepon.setText(list.get(position).getNo_telepon());
        holder.namapesan.setText(list.get(position).getNamapesan());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nama,alamat,telepon,namapesan;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            nama = itemView.findViewById(R.id.nama);
            alamat = itemView.findViewById(R.id.alamat);
            telepon = itemView.findViewById(R.id.telepon);
            namapesan = itemView.findViewById(R.id.Pesan);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (dialog!= null){
                        dialog.onClick(getLayoutPosition());
                    }
                }
            });
        }
    }
}