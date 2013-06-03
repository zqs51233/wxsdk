package com.wxsdk;

import com.wxsdk.bean.Message;

/**
 * Created with IntelliJ IDEA.
 * User: zhangqisheng
 * Date: 13-6-3
 * Time: 下午11:11
 * 需要实现该接口，处理业务逻辑
 */
public interface IMessageService {
    /**
     * 消息处理
     * @param msg
     * @return
     */
    public Message dispose(Message msg);
}
