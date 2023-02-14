package com.auth.aop;

import com.auth.json.gson.GsonUtils;
import com.google.common.base.Stopwatch;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 方法统计耗时aop
 */
@Aspect
@Component
@Slf4j
public class MethodRunTimeAspet {

  @Pointcut(value = "@annotation(MethodRunTimeCount)")
  public void methodPointCut() {
  }

  @Around("methodPointCut()")
  public Object runTimeStatistics(ProceedingJoinPoint pjp) throws Throwable {
    Signature signature = pjp.getSignature();
    //被代理的类的类名
    String className = pjp.getTarget().getClass().getSimpleName();
    //方法名
    String methodName = signature.getName();
    //参数数组
    Object[] requestParams = pjp.getArgs();
    StringBuffer sb = new StringBuffer();
    if (requestParams.length != 0) {
      for (Object requestParam : requestParams) {
        sb.append(sb.length() > 0 ? "," : "");
        if (Objects.isNull(requestParam)) {
          sb.append("null");
          continue;
        }
        sb.append(GsonUtils.toJson(requestParam));
      }
    }
    log.info("[{}] class,[{}] method start,params: {}", className, methodName, sb);
    Stopwatch stopwatch = Stopwatch.createStarted();
    // 执行业务方法
    Object response = pjp.proceed();
    stopwatch.stop();
    log.info("[{}] class,[{}] method end,total run time: {}ms", className, methodName, stopwatch.elapsed(TimeUnit.MILLISECONDS));
    return response;
  }
}
