package com.yamdeng.reboot.java.vo;

import java.util.Objects;

public class RequestCommand {

    private String loginId;
    private String loginPass;
    private String userName;
    private boolean isMale;
    private Integer age;
    private String address;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getLoginPass() {
        return loginPass;
    }

    public void setLoginPass(String loginPass) {
        this.loginPass = loginPass;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RequestCommand)) return false;
        RequestCommand that = (RequestCommand) o;
        return isMale == that.isMale && Objects.equals(loginId, that.loginId) && Objects.equals(loginPass, that.loginPass) && Objects.equals(userName, that.userName) && Objects.equals(age, that.age) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loginId, loginPass, userName, isMale, age, address);
    }

    @Override
    public String toString() {
        return "RequestCommand{" +
                "loginId='" + loginId + '\'' +
                ", loginPass='" + loginPass + '\'' +
                ", userName='" + userName + '\'' +
                ", isMale=" + isMale +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

}
