package vip.iotworld.web.aspect;

import org.springframework.stereotype.Component;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Component
public class TimeAspect {
	@Around("execution(* vip.iotworld.web.controller.UserController.*(..))")
	public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
		
		System.out.println("time aspect start");
		
		Object[] args = pjp.getArgs();
		for (Object arg:args) {
			System.out.println("arg is "+arg);
		}
		
		Long start = new Date().getTime();
		
		Object object = pjp.proceed();
		
		System.out.println("time aspect 耗时:"+(new Date().getTime()- start));

		System.out.println("time aspect end");
		
		return object;
	}
}
