package com.yangyuscript.websocketserver.utils;

/**
 *
 *@author yangyuscript
 *@date: 17:26 2018/11/13
 *
 **/
public class MessageInfo {
    private String msgContent;

    private String userId;

    private String msgType;

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
