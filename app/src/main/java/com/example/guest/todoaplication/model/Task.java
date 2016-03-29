package com.example.guest.todoaplication.model;

/**
 * Created by Guest on 3/29/16.
 */

import java.util.UUID;

public class Task {
    private UUID uuid;
    private String title;
    private String category;
    private String description;

    public Task () {

    }

    public Task(String title, String category, String description) {
        this.uuid = UUID.randomUUID();
        this.title = title;
        this.category = category;
        this.description = description;
    }

//    public Task(String title, String category, String description, String uuid) {
//        this.uuid = UUID.fromString(uuid);
//        this.title = title;
//        this.category = category;
//        this.description = description;
//    }



    public UUID getUuid() {
        return uuid;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }
}
