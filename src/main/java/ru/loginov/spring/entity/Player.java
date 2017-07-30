package ru.loginov.spring.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.beans.ConstructorProperties;

public class Player {

    private final int id;
    private final String login;
    private final String password;
    private final int score;

    @ConstructorProperties({"id", "login", "password", "score"})
    public Player(
            @JsonProperty("id") int id,
            @JsonProperty("login") String login,
            @JsonProperty("password") String password,
            @JsonProperty("score") int score) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getScore() {
        return score;
    }

}
