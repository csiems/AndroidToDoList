package com.example.guest.todoaplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
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
            String title = titleLabel.getText().toString();
            String category = categoryLabel.getText().toString();
            String description = descriptionLabel.getText().toString();
            if (!title.equals("") && !category.equals("") && !description.equals("")) {
                Task newTask = new Task(title, category, description);
                saveTaskToFirebase(newTask);
                emptyFormFields((ViewGroup) findViewById(R.id.scrollView));
                Intent intent = new Intent(TaskFormActivity.this, MainActivity.class);
                startActivity(intent);
            } else {
                if (title.equals("")) {
                    throwWarning(titleLabel);
                }
                if (category.equals("")) {
                    throwWarning(categoryLabel);
                }
                if (description.equals("")) {
                    throwWarning(descriptionLabel);
                }
            }
        }
    }

    private void throwWarning(EditText editText) {
        editText.setError("Missing form information!");
    }

    private void emptyFormFields(ViewGroup group) {
        for (int i = 0, count = group.getChildCount(); i < count; ++i) {
            View view = group.getChildAt(i);
            if (view instanceof EditText) {
                ((EditText)view).setText("");
            }

            if(view instanceof ViewGroup && (((ViewGroup)view).getChildCount() > 0))
                emptyFormFields((ViewGroup)view);
        }

    }

    public void saveTaskToFirebase(Task newTask) {
        ToDoApplication.getAppInstance()
                .getFirebaseRef()
                .child("tasks/" + newTask.getUuid())
                .setValue(newTask);
    }
}
