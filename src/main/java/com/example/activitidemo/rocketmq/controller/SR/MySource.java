package com.example.activitidemo.rocketmq.controller.SR;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MySource {

    String OUTPUT = "my_output1";

    @Output(MySource.OUTPUT)
    MessageChannel output();

    String OUTPUT2 = "my_output2";

    @Output(MySource.OUTPUT2)
    MessageChannel output2();

    String OUTPUTTX = "outputTX";

    @Output(MySource.OUTPUTTX)
    MessageChannel outputTX();


}