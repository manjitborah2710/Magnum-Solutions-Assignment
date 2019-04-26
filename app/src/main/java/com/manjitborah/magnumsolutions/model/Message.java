package com.manjitborah.magnumsolutions.model;

public class Message {
    public static final int SEND=100;
    public static final int RECEIVE=200;
    public static final int DATE=300;
    public static final int TYPE_TEXT=1;
    public static final int TYPE_IMAGE=2;

    private String msg;
    private String time;
    private int type;
    private int sendOrReceive;

    public Message(String msg, String time, int type, int sendOrReceive) {
        this.msg = msg;
        this.time = time;
        this.type = type;
        this.sendOrReceive = sendOrReceive;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSendOrReceive() {
        return sendOrReceive;
    }

    public void setSendOrReceive(int sendOrReceive) {
        this.sendOrReceive = sendOrReceive;
    }
}
