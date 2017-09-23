package com.automation.utils;

public enum Selector {
    EMAIL_ID("email"),
    PASSWORD_ID("passwd"),
    USER_AVATAR_CLASS("employee_avatar_small"),
    LOGOUT_ID("header_logout"),
    MAIN_TAB_CLASS("maintab"),
    LINK_LEVEL_ONE_CLASS("link-levelone");

    private String value;

    Selector(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
