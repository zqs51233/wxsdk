package com.wxsdk.bean;

import org.dom4j.Element;

/**
 *
 * User: free anuo
 * Date: 13-5-2
 * Time: 下午11:18
 * 消息基础类
 */
public abstract class Message extends BaseObject {

    protected String fromUserName; // 发送者
    protected String toUserName; // 接收者
    protected long createTime; // 消息创建时间
    protected MessageType messageType;
    private String funcFlag = "0";// 位0x0001被标志时，星标刚收到的消息。

    protected String msgId;

    public Message() {}

    public Message(Element element_) {
        this.setFromUserName(element_.elementTextTrim("FromUserName"));
        this.setToUserName(element_.elementTextTrim("ToUserName"));
        this.setCreateTime(Long.valueOf(element_.elementTextTrim("CreateTime")));
        this.setMsgId(element_.elementTextTrim("MsgId"));
    }

    protected void loadBasicXmlInfos(Element xmlEle) {
        Element toUserEle = xmlEle.addElement("ToUserName");
        toUserEle.setText(this.getToUserName());

        Element fromUserEle = xmlEle.addElement("FromUserName");
        fromUserEle.setText(this.getFromUserName());

        Element createTimeEle = xmlEle.addElement("CreateTime");
        createTimeEle.setText(String.valueOf(this.getCreateTime()));

        Element msgTypeEle = xmlEle.addElement("MsgType");
        msgTypeEle.setText(this.getMessageType().getText());
    }

    public String getXML() {
        return null;
    }

    public String getFuncFlag() {
        return funcFlag;
    }

    public void setFuncFlag(String funcFlag) {
        this.funcFlag = funcFlag;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public  enum MessageType {
        TEXT("text"), LOCATION("location"), PICTEXT("news"), PIC("pic"), LINK("link"), EVENT("event");

        public static MessageType getType(String txt) {
            for (MessageType messageType : MessageType.values()) {
                if (messageType.getText().equals(txt)) {
                    return messageType;
                }
            }
            return null;
        }

        private String txt;

        MessageType(String txt) {
            this.txt = txt;
        }

        public String getText() {
            return txt;
        }

        public void setText(String text) {
            this.txt = text;
        }
    }
}
