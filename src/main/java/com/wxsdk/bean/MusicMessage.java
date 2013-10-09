package com.wxsdk.bean;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 *
 * User: free anuo
 * Date: 13-5-3
 * Time: 下午10:20
 * 音乐消息
 */
public class MusicMessage extends Message {

    private String title;
    private String description;
    private String musicUrl;
    private String hqMusicUrl; // 高质量音乐链接，WIFI环境优先使用该链接播放音乐



    @Override
    public String getXML() {
        Document document = DocumentHelper.createDocument();
        Element xmlEle = document.addElement("xml");
        super.loadBasicXmlInfos(xmlEle);
        Element musicEl = xmlEle.addElement("Music");

        Element titleEl = musicEl.addElement("Title");
        titleEl.setText(title);

        Element despEl = musicEl.addElement("Description");
        despEl.setText(description);

        Element musicUrlEl = musicEl.addElement("MusicUrl");
        musicUrlEl.setText(musicUrl);

        Element hqMusicUrlEl = musicEl.addElement("HQMusicUrl");
        hqMusicUrlEl.setText(hqMusicUrl);

        Element funcFlagEle = xmlEle.addElement("FuncFlag");
        funcFlagEle.setText(String.valueOf(this.getFuncFlag()));
        return document.asXML();
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

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    public String getHqMusicUrl() {
        return hqMusicUrl;
    }

    public void setHqMusicUrl(String hqMusicUrl) {
        this.hqMusicUrl = hqMusicUrl;
    }
}
