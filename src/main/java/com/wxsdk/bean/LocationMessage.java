package com.wxsdk.bean;

import org.dom4j.Element;

/**
 *
 * User: free anuo
 * Date: 13-5-3
 * Time: 下午10:27
 * 位置消息
 */
public class LocationMessage extends Message {

    private double locationX;
    private double locationY;
    private int scale;
    private String label;

    public LocationMessage() {}

    public LocationMessage(Element element_) {
        super(element_);
        this.setLocationX(Double.valueOf(element_.elementTextTrim("Location_X")));
        this.setLocationY(Double.valueOf(element_.elementTextTrim("Location_Y")));
        this.setScale(Integer.valueOf(element_.elementTextTrim("Scale")));
        this.setLabel(element_.elementTextTrim("Label"));
    }

    public double getLocationX() {
        return locationX;
    }

    public void setLocationX(double locationX) {
        this.locationX = locationX;
    }

    public double getLocationY() {
        return locationY;
    }

    public void setLocationY(double locationY) {
        this.locationY = locationY;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
