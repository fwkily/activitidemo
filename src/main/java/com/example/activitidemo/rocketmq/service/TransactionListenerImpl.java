package com.example.activitidemo.rocketmq.service;

import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.messaging.Message;

//myTXProducerGroup和properties中的配置producer.group的值一样
@RocketMQTransactionListener(txProducerGroup = "myTXProducerGroup",corePoolSize = 5,maximumPoolSize = 10)
public class TransactionListenerImpl implements RocketMQLocalTransactionListener {

    /**
    * @description: 执行本地事务，也是执行本地业务逻辑
    * @author TAO
    * @date 2021/1/19 18:35
    */
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        Object num = msg.getHeaders().get("test");
        if ("1".equals(num)){
            System.out.println("executer:"+new String((byte[]) msg.getPayload())+"unknown");
            return RocketMQLocalTransactionState.UNKNOWN;
        }else if("2".equals(num)){
            System.out.println("executer:"+new String((byte[]) msg.getPayload())+"rollback");
            return RocketMQLocalTransactionState.ROLLBACK;
        }
        System.out.println("executer:"+new String((byte[]) msg.getPayload())+"commit");
        return RocketMQLocalTransactionState.COMMIT;
    }

    /**
   * @description: 回调检查
   * @author TAO
   * @date 2021/1/19 18:34
   */
    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message msg) {

        System.out.println("check:"+new String((byte[]) msg.getPayload()));
        return RocketMQLocalTransactionState.COMMIT;
    }
}

