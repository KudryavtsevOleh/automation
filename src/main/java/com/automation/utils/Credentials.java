package com.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Credentials {

    private String login;
    private String password;

    public void init() throws IOException {
        try (InputStream is = new FileInputStream("src/main/resources/credentials.properties")) {
            Properties properties = new Properties();
            properties.load(is);
            login = properties.getProperty("login");
            password = properties.getProperty("password");
        } catch (Exception e) {
            System.out.println("Error occurred while reading properties file: " + e.getMessage());
        }
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
