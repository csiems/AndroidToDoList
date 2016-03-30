package com.example.guest.todoaplication.adapter;

import android.app.DownloadManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guest.todoaplication.R;
import com.example.guest.todoaplication.model.Task;
import com.example.guest.todoaplication.util.FirebaseRecyclerAdapter;
import com.firebase.client.Query;

/**
 * Created by Guest on 3/29/16.
 */
public class FirebaseTaskListAdapter extends FirebaseRecyclerAdapter<TaskViewHolder, Task> {


    public FirebaseTaskListAdapter (Query query, Class<Task> itemClass) {
        super(query, itemClass);
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_list_item, parent, false);
        return new TaskViewHolder(view, getItems());
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        holder.bindTask(getItem(position));

    }

    @Override
    protected void itemAdded(Task item, String key, int position) {
    }

    @Override
    protected void itemChanged(Task oldItem, Task newItem, String key, int position) {
    }

    @Override
    protected void itemRemoved(Task item, String key, int position) {
    }

    @Override
    protected void itemMoved(Task item, String key, int oldPosition, int newPosition) {
    }
}
