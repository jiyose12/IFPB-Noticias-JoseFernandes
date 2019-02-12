package aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	@Before("execution(public void addAccount())")
	public void beforeLogin() {
		System.out.println("\n=============>>> Executando Antes do metodo login");
	}
}
