package com.wxsdk;

import com.wxsdk.bean.Message;
import com.wxsdk.bean.PicTextReplayMessage;
import com.wxsdk.bean.PicTextReplayMessage.Article;

/**
 * User: free anuo
 * Date: 13-10-8
 * Time: 下午3:45
 * To change this template use File | Settings | File Templates.
 */
public class MessageServiceImpl implements IMessageService {
    @Override
    public Message disposeMsg(Message msg) {
        PicTextReplayMessage picTextReplayMessage = new PicTextReplayMessage();
        Article  article = new Article();
        return picTextReplayMessage;
    }

    @Override
    public String getToken() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
