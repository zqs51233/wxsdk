package com.wxsdk.bean;

import org.dom4j.Element;

import java.text.DecimalFormat;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-5-3
 * Time: 下午10:23
 * To change this template use File | Settings | File Templates.
 */
public class Article extends BaseObject {

    private String title;
    private String description;
    private String picUrl;    // 图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80。
    private String url;     //  点击图文消息跳转链接


    public  void loadXmlFromArticle(Element parent_){
        Element itemTitleEle=null;
        Element itemDesEle=null;
        Element itemPicUrlEle=null;
        Element itemUrlEle=null;
        itemTitleEle = parent_.addElement("Title");
        itemTitleEle.setText(this.getTitle()==null?"":this.getTitle());

        itemDesEle = parent_.addElement("Description");
        itemDesEle.setText(this.getDescription()==null?"":this.getDescription());

        itemPicUrlEle = parent_.addElement("PicUrl");
        itemPicUrlEle.setText(this.getPicUrl()==null?"":this.getPicUrl());

        itemUrlEle = parent_.addElement("Url");
        itemUrlEle.setText(this.getUrl()==null?"":this.getUrl());
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

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
    }
}
