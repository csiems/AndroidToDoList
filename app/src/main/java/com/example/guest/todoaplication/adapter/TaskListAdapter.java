package com.example.guest.todoaplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guest.todoaplication.R;
import com.example.guest.todoaplication.model.Task;

import java.util.ArrayList;

/**
 * Created by Guest on 3/29/16.
 */
public class TaskListAdapter extends RecyclerView.Adapter<TaskViewHolder>{

    private ArrayList<Task> taskList;
    private Context context;

    public TaskListAdapter (Context context, ArrayList<Task> tasks) {
        this.context = context;
        this.taskList = tasks;
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_list_item, parent, false);
        TaskViewHolder viewHolder = new TaskViewHolder(view, taskList);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        holder.bindTask(taskList.get(position));

    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }
}
