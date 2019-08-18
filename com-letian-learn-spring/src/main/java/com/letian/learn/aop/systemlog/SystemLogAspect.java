package com.letian.learn.aop.systemlog;


import com.alibaba.fastjson.JSON;
import com.letian.learn.aop.systemlog.dto.LogDTO;
import com.letian.learn.aop.systemlog.enums.ChildrenLogEnum;
import com.letian.learn.aop.systemlog.enums.ParentLogEnum;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

/**
 * 系统日志记录
 *
 * @author : lh
 * @version : 1.0.0
 * @description :
 * @date :  2019-08-12 09:41
 */
@Component
@Aspect
public class SystemLogAspect {

    @Pointcut("@annotation(com.letian.learn.sping.aop.log.SystemLog)")
    public void systemLog() {
    }

//    @Before("systemLog()")
//    public void doBefore(JoinPoint joinPoint) {
//
//    }

    @Around("systemLog()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        LogDTO logDTO = dealParam(joinPoint);
        long start = System.currentTimeMillis();
        // 调用目标方法
        Object result = joinPoint.proceed();
        //写日志
        logDTO.setExecuteTime(System.currentTimeMillis() - start);
        System.out.println(logDTO);
        return result;
    }


    public LogDTO dealParam(ProceedingJoinPoint joinPoint) {
        LogDTO logDTO = new LogDTO();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SystemLog systemLog = method.getAnnotation(SystemLog.class);
        //设置日志的大类小类和操作类型
        logDTO.setParentType(systemLog.parentType().getKey());
        logDTO.setChildrenType(systemLog.childrenType().getKey());
        logDTO.setOperatingType(systemLog.operateType().getKey());
        logDTO.setContent(systemLog.content());
        //SystemLog 没有设定,就去找SystemLogApi的类型
        if (systemLog.parentType() == ParentLogEnum.NOT || systemLog.childrenType() == ChildrenLogEnum.NOT) {
            Class<?> systemLogClass = joinPoint.getTarget().getClass();
            SystemLogApi systemLogApi = systemLogClass.getAnnotation(SystemLogApi.class);
            //如果没有就直接跳出,不添加日志
            if (systemLogApi == null) {
                return logDTO;
            }
            if (systemLog.parentType() == ParentLogEnum.NOT) {
                logDTO.setParentType(systemLogApi.parentType().getKey());
            }
            if (systemLog.childrenType() == ChildrenLogEnum.NOT) {
                logDTO.setChildrenType(systemLogApi.childrenType().getKey());
            }
        }
        // 接收到请求，记录请求内容
        Parameter[] params = method.getParameters();
        if (params.length != 0) {
            Map<String, Object> logParamMap = new HashMap<>();
            Object[] values = joinPoint.getArgs();
            for (int i = 0, len = values.length; i < len; i++) {
                Object paramValue = values[i];
                if (!isPutObject(paramValue)) {
                    continue;
                }
                //获取参数名
                Parameter param = params[i];
                SystemLogParam systemLogParam = param.getAnnotation(SystemLogParam.class);
                String paramName;
                if (systemLogParam == null || "".equals(systemLogParam.value())) {
                    paramName = param.getName();
                } else {
                    paramName = systemLogParam.value();
                }
                //判断值是否为空
                if (paramValue == null) {
                    logParamMap.put(paramName, null);
                    continue;
                }
                //是否是自定义对象
                if (param.getType().getClassLoader() == null) {
                    logParamMap.put(paramName, paramValue);
                } else {
                    putDefinedObject(paramName, paramValue, logParamMap);
                }
            }
            logDTO.setLogParameter(JSON.toJSONString(logParamMap));
        }
        return logDTO;
    }


    /**
     * 放入自定义的对象
     *
     * @param paramName   参数名称
     * @param paramValue  参数值
     * @param logParamMap json化的map
     */
    private void putDefinedObject(String paramName, Object paramValue, Map<String, Object> logParamMap) {
        Class<?> valueClass = paramValue.getClass();
        Field[] fields = valueClass.getDeclaredFields();
        Map<String, Object> map = new HashMap<>();
        for (Field field : fields) {
            field.setAccessible(true);
            String name = field.getName();
            try {
                Object object = field.get(paramValue);
                if (object == null) {
                    continue;
                }
                if (!isPutObject(object)) {
                    continue;
                }
                map.put(name, object);
            } catch (IllegalAccessException e) {
                System.err.println(e.getMessage());
            }
        }
        logParamMap.put(paramName, map);
    }

    /**
     * 判断是否放入日志
     *
     * @param paramValue 参数值
     * @return true: 放入, false： 不放入
     */
    private boolean isPutObject(Object paramValue) {
        if (paramValue instanceof ServletRequest) {
            return false;
        }
        if (paramValue instanceof ServletResponse) {
            return false;
        }
        if (paramValue instanceof MultipartFile) {
            return false;
        }
        if (paramValue instanceof MultipartFile[]) {
            return false;
        }
        return true;
    }
}
