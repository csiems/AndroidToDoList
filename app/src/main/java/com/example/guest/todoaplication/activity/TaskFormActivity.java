package com.example.guest.todoaplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.guest.todoaplication.R;
import com.example.guest.todoaplication.ToDoApplication;
import com.example.guest.todoaplication.model.Task;

import java.util.UUID;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TaskFormActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.titleEditText) EditText titleLabel;
    @Bind(R.id.categoryEditText) EditText categoryLabel;
    @Bind(R.id.descriptionEditText) EditText descriptionLabel;
    @Bind(R.id.saveButton) Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_form);

        ButterKnife.bind(this);
        saveButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == saveButton) {
//            String uuidString = UUID.randomUUID().toString();
            String title = titleLabel.getText().toString();
            String category = categoryLabel.getText().toString();
            String description = descriptionLabel.getText().toString();
            Task newTask = new Task(title, category, description);
            saveTaskToFirebase(newTask);
            Intent intent = new Intent(TaskFormActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }

    public void saveTaskToFirebase(Task newTask) {
        ToDoApplication.getAppInstance()
                .getFirebaseRef()
                .child("tasks/" + newTask.getUuid())
                .setValue(newTask);
    }
}
