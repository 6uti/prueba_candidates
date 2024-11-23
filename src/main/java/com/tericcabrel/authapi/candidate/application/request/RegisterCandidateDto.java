package com.tericcabrel.authapi.candidate.application.request;

public class RegisterCandidateDto {
    private String email;
    private String password;
    private String name;
    private String gender;
    private Integer salary_expected;

    public String getEmail() {
        return email;
    }

    public RegisterCandidateDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterCandidateDto setPassword(String password) {
        this.password = password;
        return this;
    }
    
    public String getName() {
        return name;
    }

    public RegisterCandidateDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public RegisterCandidateDto setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public Integer getSalary_expected() {
        return salary_expected;
    }

    public RegisterCandidateDto setSalary_expected(Integer salary_expected) {
        this.salary_expected = salary_expected;
        return this;
    }

    @Override
    public String toString() {
        return "RegisterCandidateDto{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", salary_expected='" + salary_expected + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
