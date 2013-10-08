package com.wxsdk.bean;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-5-3
 * Time: 下午10:31
 * To change this template use File | Settings | File Templates.
 */
public enum EventType {

    subscribe("subscribe"), unsubscribe("unsubscribe"), CLICK("unsubscribe");

    private String txt;

    public static EventType getType(String txt) {
        for (EventType eventType : EventType.values()) {
            if (eventType.getTxt().equals(txt)) {
                return eventType;
            }
        }
        return null;
    }

    EventType(String txt) {
        this.txt = txt;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}
