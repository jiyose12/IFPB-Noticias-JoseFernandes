package aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
public class MyAspect {

	@Before("execution(public void addAccount())")
	public void beforeLogin() {
		System.out.println("\n=============>>> Executando Antes do metodo login");
	}
	@Before("execution(public void justASysout())")
	public void beforeSysout() {
		System.out.println("\n=============>>> Executando Antes do metodo justasysout");
	}
}
