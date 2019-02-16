package aspects;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import modelo.Noticia;

@Aspect
public class AfterReturningAspect {
	// add a new advice for @AfterReturning on the consultarNoticiasPorSetor method
	
		@AfterReturning(
				pointcut="execution(* daojpa.DAONoticia.consultarNoticiasPorSetor(*))",
				returning="result")
		public void afterReturningFindAccountsAdvice(
						JoinPoint theJoinPoint, List<Noticia> result) {
			
			// print out which method we are advising on 
			String method = theJoinPoint.getSignature().toShortString();
			System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);
					
			// print out the results of the method call
			//System.out.println("\n=====>>> result is: " + result);
			
			// let's post-process the data ... let's modify it :-)
			
			// convert the titulo names to uppercase
			convertAccountTitleToUpperCase(result);

			System.out.println("\n=====>>> result is: " + result);
			
		}

		private void convertAccountTitleToUpperCase(List<Noticia> result) {

			// loop through noticias

			for (Noticia tempNoticia : result) {
				
				// get uppercase version of name
				String theUpperName = tempNoticia.getTitulo().toUpperCase();
				
				// update the name on the titulo
				tempNoticia.setTitulo(theUpperName);
			}

		}

}
