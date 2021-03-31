package com.example.activitidemo.rocketmq.service;

import com.example.activitidemo.rocketmq.controller.SR.MySink;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

@Service
public class ReceiveService {

//	@Autowired
//    private Sink sink;
	
	@StreamListener(value = Sink.INPUT)
    public void receiveMessage(String message){
        System.out.println("接收的消息input==>"+message);
    }

    @StreamListener(value = MySink.INPUT)
    public void receiveMessage1(String message){
        System.out.println("自定义接收的消息input1==>"+message);
    }

    @StreamListener(value = MySink.INPUT2)
    public void receiveMessage2(String message){
        System.out.println("自定义接收的消息input2==>"+message);
    }

    @StreamListener(value = MySink.INPUTTX)
    public void receiveMessageTX(String message){
        System.out.println("接收的消息inputTX==>"+message);
    }


}

