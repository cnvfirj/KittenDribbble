package com.kittendevelop.kittendribbble.ui.register;

public class RegisterModel {

    public String getAuthorize() {
        return "https://dribbble.com/oauth/authorize?" +
                "client_id=8a4e6b1c8d3adca5d887b45a2147c48c11a3e4361ce5adef08964228413644a0&" +
                "scope=public+upload";
    }

    public String getDribbble() {
        return "https://dribbble.com";
    }

    public String getSignUp() {
        return "https://dribbble.com/signup/new";
    }

}
