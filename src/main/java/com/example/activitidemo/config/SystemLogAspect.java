package com.example.activitidemo.config;

import com.example.activitidemo.config.annotation.Log;
import com.example.activitidemo.entity.po.SystemLog;
import com.example.activitidemo.entity.po.Users;
import com.example.activitidemo.service.SystemLogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

/**
 * 系统日志切面配置类
 */
@Aspect
@Component
@Slf4j
public class SystemLogAspect {
//
//
//    @Resource
//    private SystemLogService systemLogService;
//
//
//    @Pointcut("execution(* com.example.activitidemo.controller..*.*(..))")
//    public void controllerAspect(){
//
//    }
//
//
//    @Before("controllerAspect()")
//    public void doBefore(JoinPoint joinPoint){
//        System.out.println("执行controller前置通知!");
//    }
//
//    @Around("controllerAspect()")
//    public void around(JoinPoint joinPoint){
//        System.out.println("执行controller环绕通知开始!");
//        long startTime = System.currentTimeMillis();
//        try {
//            ProceedingJoinPoint proceedingJoinPoint = (ProceedingJoinPoint) joinPoint;
//            Object proceed = proceedingJoinPoint.proceed();
//            long endTime = System.currentTimeMillis();
//            System.out.println("around " + joinPoint + "\tUse time : " + (endTime - startTime) + " ms!");
//        }catch (Throwable throwable) {
//            throwable.printStackTrace();
//            long endTime = System.currentTimeMillis();
//            System.out.println("around " + joinPoint + "\tUse time : " + (endTime - startTime) + " ms!");
//        }
//    }
//
//    /**
//     * 后置通知 用于拦截Controller层记录用户的操作
//     *
//     * @param joinPoint 切点
//     */
//    @After("controllerAspect()")
//    public  void after(JoinPoint joinPoint) {
//
//       /* HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        HttpSession session = request.getSession();  */
//        //读取session中的用户
//        // User user = (User) session.getAttribute("user");
//        //请求的IP
//        //String ip = request.getRemoteAddr();
//        String ip = "127.0.0.1";
//        Users user = new Users();
//        user.setName("张三");
//        user.setAge(21);
//        try {
//
//            String targetName = joinPoint.getTarget().getClass().getName();
//            String methodName = joinPoint.getSignature().getName();
//            Object[] arguments = joinPoint.getArgs();
//            Class targetClass = Class.forName(targetName);
//            Method[] methods = targetClass.getMethods();
//            String operationType = "";
//            String operationName = "";
//            for (Method method : methods) {
//                if (method.getName().equals(methodName)) {
//                    Class[] clazzs = method.getParameterTypes();
//                    if (clazzs.length == arguments.length) {
//                        operationType = method.getAnnotation(Log.class).operationType();
//                        operationName = method.getAnnotation(Log.class).operationName();
//                        break;
//                    }
//                }
//            }
//            //*========控制台输出=========*//
//            System.out.println("=====controller后置通知开始=====");
//            System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()")+"."+operationType);
//            System.out.println("方法描述:" + operationName);
//            System.out.println("请求人:" + user.getName());
//            System.out.println("请求IP:" + ip);
//            //*========数据库日志=========*//
//            SystemLog systemLog = new SystemLog();
//            systemLog.setId(UUID.randomUUID().toString());
//            systemLog.setDescription(operationName);
//            systemLog.setMethod((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()")+"."+operationType);
//            systemLog.setLogType((long)0);
//            systemLog.setRequestIp(ip);
//            systemLog.setExceptioncode( null);
//            systemLog.setExceptionDetail( null);
//            systemLog.setParams(arguments.toString());
//            systemLog.setCreateBy(user.getName());
//            systemLog.setCreateDate(new Date());
//            //保存数据库
//            systemLogService.addSystemLog(systemLog);
//            System.out.println("=====controller后置通知结束=====");
//        }  catch (Exception e) {
//            //记录本地异常日志
//            log.error("==后置通知异常==");
//            log.error("异常信息:{}", e.getMessage());
//        }
//    }
//
//    /**
//     * 异常通知 用于拦截记录异常日志
//     *
//     * @param joinPoint
//     * @param e
//     */
//    @AfterThrowing(pointcut = "controllerAspect()", throwing="e")
//    public  void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
//        /*HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        HttpSession session = request.getSession();
//        //读取session中的用户
//        User user = (User) session.getAttribute(WebConstants.CURRENT_USER);
//        //获取请求ip
//        String ip = request.getRemoteAddr(); */
//        //获取用户请求方法的参数并序列化为JSON格式字符串
//
//        Users user = new Users();
//        user.setName("张三");
//        user.setAge(21);
//        String ip = "127.0.0.1";
//
//        String params = "";
//        if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {
//            for ( int i = 0; i < joinPoint.getArgs().length; i++) {
//                params += joinPoint.getArgs()[i] + ";";
//            }
//        }
//        try {
//
//            String targetName = joinPoint.getTarget().getClass().getName();
//            String methodName = joinPoint.getSignature().getName();
//            Object[] arguments = joinPoint.getArgs();
//            Class targetClass = Class.forName(targetName);
//            Method[] methods = targetClass.getMethods();
//            String operationType = "";
//            String operationName = "";
//            for (Method method : methods) {
//                if (method.getName().equals(methodName)) {
//                    Class[] clazzs = method.getParameterTypes();
//                    if (clazzs.length == arguments.length) {
//                        operationType = method.getAnnotation(Log.class).operationType();
//                        operationName = method.getAnnotation(Log.class).operationName();
//                        break;
//                    }
//                }
//            }
//            /*========控制台输出=========*/
//            System.out.println("=====异常通知开始=====");
//            System.out.println("异常代码:" + e.getClass().getName());
//            System.out.println("异常信息:" + e.getMessage());
//            System.out.println("异常方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()")+"."+operationType);
//            System.out.println("方法描述:" + operationName);
//            System.out.println("请求人:" + user.getName());
//            System.out.println("请求IP:" + ip);
//            System.out.println("请求参数:" + params);
//            /*==========数据库日志=========*/
//            SystemLog log = new SystemLog();
//            log.setId(UUID.randomUUID().toString());
//            log.setDescription(operationName);
//            log.setExceptioncode(e.getClass().getName());
//            log.setLogType((long)1);
//            log.setExceptionDetail(e.getMessage());
//            log.setMethod((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
//            log.setParams(params);
//            log.setCreateBy(user.getName());
//            log.setCreateDate(new Date());
//            log.setRequestIp(ip);
//            //保存数据库
//            systemLogService.addSystemLog(log);
//            System.out.println("=====异常通知结束=====");
//        }  catch (Exception ex) {
//            //记录本地异常日志
//            log.error("==异常通知异常==");
//            log.error("异常信息:{}", ex.getMessage());
//        }
//        /*==========记录本地异常日志==========*/
//        log.error("异常方法:{}异常代码:{}异常信息:{}参数:{}", joinPoint.getTarget().getClass().getName() + joinPoint.getSignature().getName(), e.getClass().getName(), e.getMessage(), params);
//
//    }
//
//

}
