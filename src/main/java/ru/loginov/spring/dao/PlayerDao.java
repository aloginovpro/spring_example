package ru.loginov.spring.dao;

import ru.loginov.spring.databind.Databind;
import ru.loginov.spring.databind.JsonDatabind;
import ru.loginov.spring.entity.Player;

public class PlayerDao {

    private final Databind<Player> databind
            = new JsonDatabind<>(Player.class, "player.json");

    public Player get() {
        System.out.println("Returning player...");
        return databind.load();
    }

    public void update(Player player) {
        System.out.println("Updating player...");
        databind.save(player);
    }

}
