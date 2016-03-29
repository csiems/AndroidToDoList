package com.example.guest.todoaplication;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Guest on 3/29/16.
 */
public class ToDoApplication extends Application {
    private static ToDoApplication app;
    private Firebase mFirebaseRef;

    public static ToDoApplication getAppInstance() {
        return app;
    }

    public Firebase getFirebaseRef() {
        return mFirebaseRef;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        Firebase.setAndroidContext(this);
        mFirebaseRef = new Firebase(this.getString(R.string.firebase_url));
    }
}
