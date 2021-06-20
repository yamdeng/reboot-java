package com.yamdeng.reboot.java.type.hide.vo;

class ResultVo {
    private String name;
    private int statusType;
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatusType() {
        return statusType;
    }

    public void setStatusType(int statusType) {
        this.statusType = statusType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

public class CommandVo {

    String name;
    private String id;
    private String password;

    protected void display() {
        System.out.println("CommandVo display()");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
