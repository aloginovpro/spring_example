package ru.loginov.spring;

import ru.loginov.spring.service.LoginService;

public class Main {

    public static void main(String[] args) throws Exception {

        LoginService loginService = new LoginService();

        loginService.login("Alex", "qwz");
        loginService.login("Alex", "qwe");

    }

}
