package com.wxsdk.util;

import com.wxsdk.bean.*;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * Created with IntelliJ IDEA.
 * User: zhangqisheng
 * Date: 13-5-3
 * Time: 上午12:31
 * xml 工具类
 */
public class XmlUtil {
    static final String MSGTYPE = "MsgType";

    /**
     * xml 解析为实体
     *
     * @param xmlStr_
     * @return
     */
    public static Message parseXML2Bean(String xmlStr_) {
        Message message = null;
        try {
            Document document = DocumentHelper.parseText(xmlStr_); // 将字符串转为XML
            Element element = document.getRootElement();
            message = parseElement(element);

        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return message;
    }

    private static MessageType getMessageType(String txt_) {
        MessageType messageType = null;
        messageType = MessageType.getType(txt_);
        return messageType;
    }

    private static Message parseElement(Element element_) {
        Message message = null;
        MessageType messageType = null;
        messageType = getMessageType(element_.elementTextTrim(MSGTYPE));
        if (messageType == null) {
            return message;
        }
        switch (messageType) {
            case TEXT:
                TextMessage textMessage = new TextMessage();
                textMessage.setFromUserName(element_.elementTextTrim("FromUserName"));
                textMessage.setToUserName(element_.elementTextTrim("ToUserName"));
                textMessage.setCreateTime(Long.valueOf(element_.elementTextTrim("CreateTime")));
                textMessage.setMessageType(messageType);
                textMessage.setContent(element_.elementTextTrim("Content"));
                textMessage.setMsgId(element_.elementTextTrim("MsgId"));
                message = textMessage;
                break;
            case LOCATION:
                LocationMessage locationMessage = new LocationMessage();
                locationMessage.setFromUserName(element_.elementTextTrim("FromUserName"));
                locationMessage.setToUserName(element_.elementTextTrim("ToUserName"));
                locationMessage.setCreateTime(Long.valueOf(element_.elementTextTrim("CreateTime")));
                locationMessage.setMessageType(messageType);
                locationMessage.setMsgId(element_.elementTextTrim("MsgId"));
                locationMessage.setLocationX(Double.valueOf(element_.elementTextTrim("Location_X")));
                locationMessage.setLocationY(Double.valueOf(element_.elementTextTrim("Location_Y")));
                locationMessage.setScale(Integer.valueOf(element_.elementTextTrim("Scale")));
                locationMessage.setLabel(element_.elementTextTrim("Label"));
                message = locationMessage;
                break;
        }
        return message;
    }
    public static String parseBean2Xml(Message message){
        if(message==null){
            return "";
        }
        //todo
        return null;
    }

    public static String parseBean2Xml(TextMessage textMessage_){
        Document document = DocumentHelper.createDocument();
        Element xmlEle = document.addElement("xml");
        loadBasicXmlInfos(xmlEle,textMessage_);
        Element ctEle = xmlEle.addElement("Content");
        ctEle.setText(textMessage_.getContent());

        Element  funcFlagEle = xmlEle.addElement("FuncFlag");
        funcFlagEle.setText(String.valueOf(textMessage_.getFuncFlag()));

        return document.asXML();

    }
    private static void loadBasicXmlInfos(Element xmlEle, Message message_){
        Element toUserEle = xmlEle.addElement("ToUserName");
        toUserEle.setText(message_.getToUserName());

        Element fromUserEle = xmlEle.addElement("FromUserName");
        fromUserEle.setText(message_.getFromUserName());

        Element createTimeEle = xmlEle.addElement("CreateTime");
        createTimeEle.setText(String.valueOf(message_.getCreateTime()));

        Element msgTypeEle = xmlEle.addElement("MsgType");
        msgTypeEle.setText(message_.getMessageType().getText());



    }

    public static String parseBean2Xml(PicTextReplayMessage picTextReplayMessage){
        if(picTextReplayMessage==null){
            return null;
        }

        Document document = DocumentHelper.createDocument();
        Element xmlEle = document.addElement("xml");
        loadBasicXmlInfos(xmlEle,picTextReplayMessage);
        Element articleCountEle = xmlEle.addElement("ArticleCount");
        articleCountEle.setText(String.valueOf(picTextReplayMessage.getArticleCount()));
        Element  articlesEle = xmlEle.addElement("Articles") ;
        // 明细
        Element itemEle=null;
        for(Article article:picTextReplayMessage.getArticles()){
            itemEle = articlesEle.addElement("item");
            loadXmlFromArticle(itemEle,article);
        }

        Element  funcFlagEle = xmlEle.addElement("FuncFlag");
        funcFlagEle.setText(String.valueOf(picTextReplayMessage.getFuncFlag()));
        return document.asXML();
    }
    public static void loadXmlFromArticle(Element parent_,Article article_){
        Element itemTitleEle=null;
        Element itemDesEle=null;
        Element itemPicUrlEle=null;
        Element itemUrlEle=null;
        itemTitleEle = parent_.addElement("Title");
        itemTitleEle.setText(article_.getTitle()==null?"":article_.getTitle());

        itemDesEle = parent_.addElement("Description");
        itemDesEle.setText(article_.getDescription()==null?"":article_.getDescription());

        itemPicUrlEle = parent_.addElement("PicUrl");
        itemPicUrlEle.setText(article_.getPicUrl()==null?"":article_.getPicUrl());

        itemUrlEle = parent_.addElement("Url");
        itemUrlEle.setText(article_.getUrl()==null?"":article_.getUrl());
    }






}
