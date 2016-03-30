package com.example.guest.todoaplication.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.guest.todoaplication.OnItemClickListener;
import com.example.guest.todoaplication.R;
import com.example.guest.todoaplication.activity.CRUDFragment;
import com.example.guest.todoaplication.activity.MainActivity;
import com.example.guest.todoaplication.model.Task;
import android.content.Context;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 3/29/16.
 */
public class TaskViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private Context mContext;
    private ArrayList<Task> taskList;


    @Bind(R.id.taskTitleDisplay) TextView titleLabel;
    @Bind(R.id.taskDescriptionDisplay) TextView descriptionLabel;
    @Bind(R.id.taskCategoryDisplay) TextView categoryLabel;


    public TaskViewHolder(View itemView, ArrayList<Task> tasks) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mContext = itemView.getContext();
        this.taskList = tasks;
        itemView.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (mContext instanceof MainActivity) {
            //build instance of fragment
            MainActivity activity = (MainActivity) mContext;
            FragmentManager fm = activity.getSupportFragmentManager();
            CRUDFragment crudFragment = CRUDFragment.newInstance();
            //add information to fragment
            Bundle bundle = new Bundle();
            bundle.putString("title", taskList.get(getLayoutPosition()).getTitle());
            bundle.putString("description", taskList.get(getLayoutPosition()).getDescription());
            bundle.putString("category", taskList.get(getLayoutPosition()).getCategory());
            bundle.putString("uuid", taskList.get(getLayoutPosition()).getUuid().toString());
            crudFragment.setArguments(bundle);
            //show fragment
            crudFragment.show(fm, "fragment_crud");
        }

    }





    public void bindTask (Task task) {
        titleLabel.setText(task.getTitle());
        descriptionLabel.setText(task.getDescription());
        categoryLabel.setText(task.getCategory());
    }

}


