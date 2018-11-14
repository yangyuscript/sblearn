package com.yangyuscript.websocketserver.utils;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.plugin2.message.Message;

import java.net.Socket;
import java.util.ArrayList;
import java.util.UUID;

@Component
public class MessageEventHandler {
    public static SocketIOServer socketIoServer;
    static ArrayList<UUID> listClient = new ArrayList<>();
    static final int limitSeconds = 60;

    @Autowired
    public MessageEventHandler(SocketIOServer server) {
        socketIoServer = server;
    }

    @OnConnect
    public void onConnect(SocketIOClient client) {
        listClient.add(client.getSessionId());
        System.out.println("客户端:" + client.getSessionId() + "已连接");
    }

    @OnDisconnect
    public void onDisconnect(SocketIOClient client) {
        System.out.println("客户端:" + client.getSessionId() + "断开连接");
    }


    @OnEvent(value = "messageevent")
    public void onEvent(SocketIOClient client, AckRequest request, MessageInfo data) {
        System.out.println("发来消息：" + data.getMsgContent());
        MessageInfo msg =new MessageInfo();
        msg.setMsgType("1");
        msg.setMsgContent(data.getMsgContent());
        msg.setUserId(client.getSessionId().toString());
        socketIoServer.getClient(client.getSessionId()).sendEvent("messageevent", msg);
        for (UUID clientId : listClient) {
            if (socketIoServer.getClient(clientId) == null || clientId == client.getSessionId()){
                continue;
            }
            msg.setMsgType("2");
            socketIoServer.getClient(clientId).sendEvent("messageevent", msg);
        }
    }

    //这里就是向客户端推消息了
    public static void sendBuyLogEvent() {
        String dateTime = DateUtils.getTimeYYYYmmDDHHMMSS();

        for (UUID clientId : listClient) {
            if (socketIoServer.getClient(clientId) == null){
                continue;
            }
            socketIoServer.getClient(clientId).sendEvent("enewbuy", dateTime, 1);
        }
    }
}
