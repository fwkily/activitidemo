package com.example.activitidemo.rocketmq.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.activitidemo.rocketmq.service.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController
{
	@Autowired
    private SenderService senderService;
    @GetMapping(value = "/input")
    public String input(@RequestParam String msg) throws Exception {
        senderService.send(msg);
        return "ok";
    }


    @GetMapping(value = "/input1")
    public String input1(@RequestParam String msg) throws Exception {
        senderService.send1(msg);
        return "ok";
    }

    @GetMapping(value = "/input2")
    public String input2(@RequestParam String msg) throws Exception {
        senderService.send2(msg);
        return "ok";
    }

    @GetMapping(value = "/inputtx")
    public String inputtx(@RequestParam String msg) throws Exception {
        senderService.sendTX(msg);
        return "ok";
    }

    @GetMapping(value = "/inputTX")
    public String inputTX(String msg) throws Exception {
        senderService.sendTransactionalMsg(msg+"1",1);
        senderService.sendTransactionalMsg(msg+"2",2);
        senderService.sendTransactionalMsg(msg+"3",3);
        senderService.sendTransactionalMsg(msg+"4",4);
        return "ok";
    }

    @GetMapping(value = "/sendObject")
    public String sendObject() throws Exception {
        JSONObject ss = new JSONObject();
        ss.put("name", "fwkhhh");
        senderService.sendObject(ss,"myTag","myKey");
        return "ok";
    }




}
