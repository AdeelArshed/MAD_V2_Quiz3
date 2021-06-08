package com.example.mad_v2_quiz3;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class StdAdapter extends RecyclerView.Adapter<StdAdapter.ViewHolder> {

    LinkedList<StdInfo> student;
    public interface ItemClicked
    {
        void onRemoveClicked(int index);
        void onItemClicked(int index);
        void onEditClicked(int index);
    }
    ItemClicked myActivity;
    public StdAdapter(Context context, LinkedList<StdInfo> list)
    {
        myActivity = (ItemClicked) context;
        student = list;
    }


   public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName,tvProgram;
        ImageView ivEdit,ivDelete;


       public ViewHolder(@NonNull View itemView) {
           super(itemView);

           tvName=itemView.findViewById(R.id.tvName);
           tvProgram=itemView.findViewById(R.id.tvProgram);
           ivEdit=itemView.findViewById(R.id.ivEdit);
           ivDelete=itemView.findViewById(R.id.ivDelete);

           ivEdit.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   myActivity.onEditClicked(student.indexOf(itemView.getTag()));
               }
           });

           ivDelete.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   myActivity.onRemoveClicked(student.indexOf(itemView.getTag()));
               }
           });
           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   myActivity.onItemClicked(student.indexOf(itemView.getTag()));
               }
               });
               }
   }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.std_list,parent,false);


        return new ViewHolder(v);

    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


holder.itemView.setTag(student.get(position));
holder.tvName.setText(student.get(position).getFullname());
holder.tvProgram.setText(student.get(position).getProgram());

    }

    @Override
    public int getItemCount() {
        return student.size();
    }



}