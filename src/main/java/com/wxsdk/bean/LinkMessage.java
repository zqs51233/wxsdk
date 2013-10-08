package com.wxsdk.bean;

import org.dom4j.Element;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-5-3
 * Time: 下午10:29
 * To change this template use File | Settings | File Templates.
 */
public class LinkMessage extends Message {

    private String title;
    private String description;
    private String url;
    private EventType eventType;

    public LinkMessage(Element element_) {
        super(element_);
        this.setMessageType(MessageType.LINK);
        this.setTitle(element_.elementTextTrim("Title"));
        this.setDescription(element_.elementTextTrim("Description"));
        this.setUrl(element_.elementTextTrim("Url"));
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
