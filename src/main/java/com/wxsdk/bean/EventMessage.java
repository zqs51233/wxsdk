package com.wxsdk.bean;

import org.dom4j.Element;

/**
 *
 * User: User: free anuo
 * Date: 13-5-3
 * Time: 下午10:30
 * 链接消息
 */
public class EventMessage extends Message {

    private String event;
    private String eventKey;
    private EventType eventType;

    public EventMessage(Element element_) {
        super(element_);
        this.setMessageType(MessageType.EVENT);
        this.setEvent(element_.elementTextTrim("Event"));
        this.setEventKey(element_.elementTextTrim("EventKey"));
        this.setEventType(EventType.getType(this.getEvent()));
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

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
}
