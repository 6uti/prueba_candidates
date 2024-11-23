package com.tericcabrel.authapi.candidate.application.request;

public class LoginCandidateDto {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public LoginCandidateDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginCandidateDto setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return "LoginCandidateDto{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
