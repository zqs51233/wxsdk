package com.wxsdk.bean;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 *
 * User: free anuo
 * Date: 13-5-3
 * Time: 下午10:23
 * 文本消息
 */
public class TextMessage extends Message {

    private String content;

    public TextMessage(Element element_) {
        super(element_);
        this.setMessageType(MessageType.TEXT);
        this.setContent(element_.elementTextTrim("Content"));
    }

    @Override
    public String getXML() {
        Document document = DocumentHelper.createDocument();
        Element xmlEle = document.addElement("xml");
        super.loadBasicXmlInfos(xmlEle);
        Element ctEle = xmlEle.addElement("Content");
        ctEle.setText(this.getContent());
        Element funcFlagEle = xmlEle.addElement("FuncFlag");
        funcFlagEle.setText(String.valueOf(this.getFuncFlag()));
        return document.asXML();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
