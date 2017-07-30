package ru.loginov.spring.dao;

import ru.loginov.spring.databind.Databind;
import ru.loginov.spring.databind.XmlDatabind;
import ru.loginov.spring.entity.ProjectSettings;

public class SettingsDao {

    private final Databind<ProjectSettings> databind =
            new XmlDatabind<>( "settings.xml");

    public int getWelcomeBonus() {
        return databind.load().getWelcomeBonus();
    }

}
