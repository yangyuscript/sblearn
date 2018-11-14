package com.yangyuscript.websocketserver;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebsocketServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsocketServerApplication.class, args);
    }

    @Bean
    public SocketIOServer socketIOServer(){
        Configuration config = new Configuration();
        String os = System.getProperty("os.name");
        if(os.toLowerCase().startsWith("win")){
            System.out.println("this is windows");
            config.setHostname("localhost");
        }else{
            //正式发布时使用服务器公网ip
            config.setHostname("123.123.123.123");
        }
        config.setPort(9092);
        final SocketIOServer server = new SocketIOServer(config);
        return server;
    }

    @Bean
    public SpringAnnotationScanner springAnnotationScanner(SocketIOServer socketServer) {
        return new SpringAnnotationScanner(socketServer);
    }
}
