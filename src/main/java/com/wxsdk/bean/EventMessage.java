package com.wxsdk.bean;

import org.dom4j.Element;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-5-3
 * Time: 下午10:30
 * To change this template use File | Settings | File Templates.
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
}
