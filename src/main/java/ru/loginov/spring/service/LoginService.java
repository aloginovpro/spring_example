package ru.loginov.spring.service;

import ru.loginov.spring.dao.PlayerDao;
import ru.loginov.spring.dao.SettingsDao;
import ru.loginov.spring.entity.Player;

public class LoginService {

    private final PlayerDao playerDao = new PlayerDao();
    private final SettingsDao settingsDao = new SettingsDao();

    public void login(String login, String password) {
        Player player = playerDao.get();
        if (!player.getLogin().equals(login)) {
            System.out.println("Unknown login");
            return;
        }
        if (!player.getPassword().equals(password)) {
            System.out.println("Incorrent password");
            return;
        }
        System.out.println("Thank you for logging in, " + player.getLogin() + "!");
        int bonus = settingsDao.getWelcomeBonus();
        System.out.println("You collect your welcome bonus: " + bonus);
        player = new Player(player.getId(), player.getLogin(), player.getPassword(), player.getScore() + bonus);
        playerDao.update(player);
        System.out.println("Your current score is " + player.getScore());
    }

}
