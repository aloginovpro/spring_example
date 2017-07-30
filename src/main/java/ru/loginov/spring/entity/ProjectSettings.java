package ru.loginov.spring.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.beans.ConstructorProperties;

public class ProjectSettings {

    private final int welcomeBonus;

    @ConstructorProperties({"welcomeBonus"})
    public ProjectSettings(
            @JsonProperty("welcomeBonus") int welcomeBonus
    ) {
        this.welcomeBonus = welcomeBonus;
    }

    public int getWelcomeBonus() {
        return welcomeBonus;
    }
}
