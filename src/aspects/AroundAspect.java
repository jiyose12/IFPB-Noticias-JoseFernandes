package aspects;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import modelo.Noticia;

@Aspect
public class AroundAspect {
	@Around("execution(* fachada.Fachada.cadastrarNoticia(..))")	
	public Object aroundGetCadastroNoticia(
			ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		// print out method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @Around on method: " + method);
		
		// display method arguments
		
		// get args
		Object[] args = theProceedingJoinPoint.getArgs();
		
		List<String> args2 = new ArrayList<>();
		// loop thru args
		for (Object tempArg : args) {
			//System.out.println(tempArg);
			
			if (tempArg instanceof String) {
				
				// capturar os dados do tipo String
				args2.add((String) tempArg);
			}
		}
		//inserir noticia no modelo backupnoticia
		System.out.println(args2);
		
		
		// get begin timestamp
		long begin = System.currentTimeMillis();
		
		// now, let's execute the method
		Object result = theProceedingJoinPoint.proceed();
		System.out.println(result);
		
		// get end timestamp
		long end = System.currentTimeMillis();
		
		// compute duration and display it
		long duration = end - begin;
		System.out.println("\n=====> Duration: " + duration / 1000.0 + " seconds");
		
		return result;
	}
}
