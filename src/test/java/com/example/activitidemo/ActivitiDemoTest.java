package com.example.activitidemo;


import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivitiDemoTest {
    @Autowired
    ProcessEngine processEngine;

    /**
     *这里注意：
     * 创建流程实例，可以在config中创建，这样项目启动时就将流程实例创建好，后面要用直接启动对应的流程实例就行。
     */
    @Test
    public void delployFlow() {
        System.out.println("--------创建流程实例---------");

        Deployment deployment = processEngine.getRepositoryService()
                .createDeployment()
                .name("请假流程")
                .addClasspathResource("diagrams/test.bpmn")//z合理是你画的流程图
                .deploy();
        System.out.println("部署ID：" + deployment.getId());
        System.out.println("部署名称：" + deployment.getName());

    }


    @Test
    public void flowStart() {
        System.out.println("-----------启动流程-----------");
        RuntimeService runtimeService = processEngine.getRuntimeService();

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("pm", "刘二狗i");//注意这里，对应我们流程图的${pm}
        map.put("day",3);//这里对应流程图${day}
        //这个是流程实例的key，就是整个流程图的id
        ProcessInstance pi = runtimeService.startProcessInstanceByKey("Process_1",map);

        System.out.println("流程实例的Id: "+pi.getId());//220001
        System.out.println("流程定义的Key: "+pi.getProcessDefinitionKey());//demo
        System.out.println("流程定义的Id: "+pi.getProcessDefinitionId());//demo:4:70004
        System.out.println("流程定义的Name: "+pi.getProcessDefinitionName());//null
        System.out.println("流程定义的Version: "+pi.getProcessDefinitionVersion());//null
    }

    @Test
    public void findMyPersonTask() {
        System.out.println("--------得到申请--------");
        String assignee = "刘二狗i";//代办人姓名。这里对应上面${pm},得到的是刘二狗的所有代办

        List<Task> taskList = processEngine.getTaskService()//获取任务service
                .createTaskQuery()//创建查询对象
                .taskAssignee(assignee)//指定查询人
                .list();
        if (taskList.size() > 0) {
            for (Task task : taskList) {
                System.out.println("代办任务ID:" + task.getId());//180007
                System.out.println("代办任务name:" + task.getName());//申请
                System.out.println("代办任务创建时间:" + task.getCreateTime());//Wed Aug 28 14:07:09 CST 2019
                System.out.println("代办任务办理人:" + task.getAssignee());//刘二狗i
                System.out.println("流程实例ID:" + task.getProcessInstanceId());//220001
                System.out.println("执行对象ID:" + task.getExecutionId());//97501
                System.out.println("代办任务的key"+task.getTaskDefinitionKey());
            }
        }
    }

    @Test
    public void completeTask(){
        System.out.println("--------申请审批并提交----------");

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("dm", "哈哈哈");//这里将下一个task的代办人提交
        String taskId = "187507";//这个id是上个方法得到的taskId

        //如果遇到这样的场景，你需要将你的申请信息传递给代办人，可以用下面这种传值的方式，取值getVariable()
        //注意下面的三个参数，第一个是taskID，第二个是传递的key,第三个是传递的value,如果value是对象的话必须要实现序列化
        processEngine.getTaskService().setVariable(taskId, "备注", "嗯，很好。这是我的备注");
        processEngine.getTaskService().complete(taskId,map);//完成任务
        System.out.println("申请审批完成，任务ID"+taskId);//97506

    }

    @Test
    public void findMyPersonTask2() {
        System.out.println("----------得到经理代办----------");
        String assignee = "哈哈哈";
        List<Task> taskList = processEngine.getTaskService()//获取任务service
                .createTaskQuery()//创建查询对象
                .taskAssignee(assignee)//指定查询人
                .list();
        TaskService taskService = processEngine.getTaskService();
        if (taskList.size() > 0) {
            for (Task task : taskList) {
                System.out.println("代办任务ID:" + task.getId());//100004
                System.out.println("代办任务name:" + task.getName());//经理审批
                System.out.println("代办任务创建时间:" + task.getCreateTime());//Wed Aug 28 13:05:23 CST 2019
                System.out.println("代办任务办理人:" + task.getAssignee());//哈哈哈
                System.out.println("流程实例ID:" + task.getProcessInstanceId());//97501
                System.out.println("执行对象ID:" + task.getExecutionId());//97501
                String beiZhu =(String) taskService.getVariable(task.getId(), "备注");//“name”对应前面set的variableName
                System.out.println("备注是："+beiZhu);
            }
        }
    }

    @Test
    public void completeTask1(){
        System.out.println("---------经理审批-----------");

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("gm", "总经理");
        String taskid = "190004";//这个id用的是提交给经理的taskId
        TaskService taskService = processEngine.getTaskService();
        String beiZhu =(String) taskService.getVariable(taskid, "备注");//“name”对应前面set的variableName
        System.out.println("备注是："+beiZhu);

        processEngine.getTaskService().complete(taskid,map);//完成任务
        System.out.println("经理审批完成，任务ID"+taskid);//85003

    }

    @Test
    public void findMyPersonTask3() {
        System.out.println("----------得到总经理代办----------");
        String assignee = "总经理";
        List<Task> taskList = processEngine.getTaskService()//获取任务service
                .createTaskQuery()//创建查询对象
                .taskAssignee(assignee)//指定查询人
                .list();
        if (taskList.size() > 0) {
            for (Task task : taskList) {
                System.out.println("代办任务ID:" + task.getId());//77504
                System.out.println("代办任务name:" + task.getName());//总经理审批
                System.out.println("代办任务创建时间:" + task.getCreateTime());//Wed Aug 28 14:17:01 CST 2019
                System.out.println("代办任务办理人:" + task.getAssignee());//总经理
                System.out.println("流程实例ID:" + task.getProcessInstanceId());//72501
                System.out.println("执行对象ID:" + task.getExecutionId());//72501
            }
        }
    }

    @Test

    public void completeTask2(){
        System.out.println("---------总经理审批-----------");
        String taskid = "77504";//这个id用的是提交给经理的taskId

        TaskService taskService = processEngine.getTaskService();

        processEngine.getTaskService().complete(taskid);//完成任务

        System.out.println("经理审批完成，任务ID"+taskid);//77504

    }

    /**
     * 根据流程实例id删除流程实例
     */
    @Test
    public void test12(){
        String processInstanceID = "220001";//这个实例id是创建流程实例的时候得到的，也可以通过taskID得到。
        
        processEngine.getRuntimeService().deleteProcessInstance(processInstanceID, "我愿意，结束。咋地啦！！！");
    }



}

