package com.example.activitidemo.rocketmq.controller.SR;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MySink {
    String INPUT = "my_input1";

    @Input(MySink.INPUT)
    SubscribableChannel input();

    String INPUT2 = "my_input2";

    @Input(MySink.INPUT2)
    SubscribableChannel input2();

    String INPUTTX = "inputTX";

    @Input(MySink.INPUTTX)
    SubscribableChannel inputTX();

}
