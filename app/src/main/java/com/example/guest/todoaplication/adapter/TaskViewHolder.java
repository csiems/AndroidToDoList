package com.example.guest.todoaplication.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.guest.todoaplication.R;
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
    private final ArrayList<Task> taskList;

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

    }

    public void bindTask (Task task) {
        titleLabel.setText(task.getTitle());
        descriptionLabel.setText(task.getDescription());
        categoryLabel.setText(task.getCategory());
    }
}
