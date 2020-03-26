package com.morfin.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder> {
    private List<ContactModel> contactModels;
    Context context;

    public ContactAdapter(Context context, List<ContactModel> contactModels){
        this.context = context;
        this.contactModels = contactModels;
    }

    @NonNull
    @Override
    public ContactAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.MyViewHolder holder, int position) {
        final ContactModel model = contactModels.get(position);
        holder.nama.setText()
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder {
    }
}
