package com.wxsdk.util;

import com.wxsdk.bean.EventMessage;
import com.wxsdk.bean.LinkMessage;
import com.wxsdk.bean.LocationMessage;
import com.wxsdk.bean.Message;
import com.wxsdk.bean.Message.MessageType;
import com.wxsdk.bean.PicMessage;
import com.wxsdk.bean.TextMessage;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 *
 * User: free anuo
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
        if (StringUtils.isNotBlank(xmlStr_)) {
            try {
                Document document = DocumentHelper.parseText(xmlStr_); // 将字符串转为XML
                Element element = document.getRootElement();
                message = parseElement(element);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
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
        MessageType messageType = getMessageType(element_.elementTextTrim(MSGTYPE));
        if (messageType == null) {
            return message;
        }
        switch (messageType) {
        case TEXT:
            message = new TextMessage(element_);
            break;
        case LOCATION:
            message = new LocationMessage(element_);
            break;
        case PIC:
            message = new PicMessage(element_);
            break;
        case LINK:
            message = new LinkMessage(element_);
            break;
        case EVENT:
            message = new EventMessage(element_);
            break;
        }
        return message;
    }

    public static String parseBean2Xml(Message message) {
        String xml = null;
        if (message != null) {
            xml = message.getXML();
        }
        return xml;
    }

}
