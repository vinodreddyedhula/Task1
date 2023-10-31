package com.task.thirdservice.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	@Pointcut("execution(* com.task.*..*(..))")
	private void allPublicMethods() {
		
	}
	
	@Around("allPublicMethods()")
	public Object logAroundMethod(ProceedingJoinPoint pjp) throws Throwable {
		Logger logger = LoggerFactory.getLogger(pjp.getTarget().getClass());
		logger.info("Entering into {}()", pjp.getSignature().getName());
	    Object returnValue=pjp.proceed();
		logger.info("Exited from {}()", pjp.getSignature().getName());
		return returnValue;
	}

}
