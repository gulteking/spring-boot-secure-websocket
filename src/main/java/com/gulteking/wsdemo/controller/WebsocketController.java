package com.gulteking.wsdemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
@RequiredArgsConstructor
public class WebsocketController {

    private final SimpMessagingTemplate messagingTemplate;


    @MessageMapping("/send/message")
    public void chatMessage(String msg) {
        messagingTemplate.convertAndSend("chat", msg + " dt: " + new Date().toString());
    }
}
