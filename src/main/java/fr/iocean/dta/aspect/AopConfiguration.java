package fr.iocean.dta.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopConfiguration {

	@Before("execution(* fr.iocean.dta.service.*.*(..))")
	public void methodesAppTest() {
		System.out.println("EmployeeService()");
	}

	@AfterThrowing(pointcut = "execution(* *(..))", throwing = "ex")
	public void exceptionRunTime(Exception ex) {
		System.out.println(ex.getMessage());

	}

}
