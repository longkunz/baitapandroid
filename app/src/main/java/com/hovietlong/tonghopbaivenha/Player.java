package com.hovietlong.tonghopbaivenha;

public class Player {
    Integer avatar;
    String name;
    Integer goal;
    String country;

    public Player(Integer avatar, String name, Integer goal, String country) {
        this.avatar = avatar;
        this.name = name;
        this.goal = goal;
        this.country = country;
    }

    public Integer getAvatar() {
        return avatar;
    }

    public void setAvatar(Integer avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGoal() {
        return goal;
    }

    public void setGoal(Integer goal) {
        this.goal = goal;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
