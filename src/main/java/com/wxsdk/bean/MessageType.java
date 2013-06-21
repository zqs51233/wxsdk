package com.wxsdk.bean;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-5-3
 * Time: 下午10:20
 * To change this template use File | Settings | File Templates.
 */
public enum MessageType {
    TEXT("text"),LOCATION("location"),PICTEXT("news"),PIC("pic"),LINK("link"),EVENT("event");

    public static MessageType getType(String txt){
       for(MessageType messageType:MessageType.values()){
           if(messageType.getText().equals(txt)){
               return messageType;
           }
       }
       return null;
    }
    private String txt;
    MessageType(String txt)  {
        this.txt =txt;
    }

    public String getText() {
        return txt;
    }

    public void setText(String text) {
        this.txt = text;
    }
}
