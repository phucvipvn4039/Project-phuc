package com.example.login;

public class ScoreAttributes {
    private int id;
    private  String name;
    private String room;
    private String score;
    private String date;

    public ScoreAttributes(String name, String room, String score) {
        this.name = name;
        this.room = room;
        this.score = score;
    }

    public ScoreAttributes() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
