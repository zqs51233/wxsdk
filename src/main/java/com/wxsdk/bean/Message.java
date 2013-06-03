package com.wxsdk.bean;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-5-2
 * Time: 下午11:18
 * To change this template use File | Settings | File Templates.
 */
public abstract class Message extends BaseObject {
    protected String fromUserName; // 发送者
    protected String toUserName;    // 接收者
    protected long createTime;      //消息创建时间
    protected MessageType   messageType;
    private String funcFlag ="0";//位0x0001被标志时，星标刚收到的消息。

    protected String msgId;

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
}
