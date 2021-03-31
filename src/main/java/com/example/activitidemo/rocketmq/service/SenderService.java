package com.example.activitidemo.rocketmq.service;

import com.example.activitidemo.rocketmq.controller.SR.MySource;
import org.apache.rocketmq.common.message.MessageConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
public class SenderService {

    @Autowired
    private Source source;

    @Autowired
    private MySource mySource;

    public void send(String msg) throws Exception{
        boolean b = source.output().send(MessageBuilder.withPayload(msg).build());
        System.out.println("初始化消息发送：" + b);
    }

    public void send1(String msg) throws Exception{
        boolean b = mySource.output().send(MessageBuilder.withPayload(msg).build());
        System.out.println("自定义消息发送1 =====》：" + b);
    }

    public void send2(String msg) throws Exception{
        boolean b = mySource.output2().send(MessageBuilder.withPayload(msg).build());
        System.out.println("自定义消息发送2 ====》：" + b);
    }

    public void sendTX(String msg) throws Exception{
        boolean b = mySource.outputTX().send(MessageBuilder.withPayload(msg).build());
        System.out.println("自定义消息发送TX ====》：" + b);
    }

    public <T> void sendTransactionalMsg(T msg,int num){
        MessageBuilder builder = MessageBuilder.withPayload(msg)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .setHeader("test", String.valueOf(num));
        Message message=builder.build();
        mySource.outputTX().send(message);
    }

    public <T> void sendObject(T msg,String tag,String key) throws Exception{
        Message message=MessageBuilder.withPayload(msg)
                .setHeader(MessageConst.PROPERTY_TAGS, tag)
                .setHeader(MessageConst.PROPERTY_KEYS,key)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build();

        boolean flag = mySource.output2().send(message);
        System.out.println("sendObject==>"+flag );
    }


}
