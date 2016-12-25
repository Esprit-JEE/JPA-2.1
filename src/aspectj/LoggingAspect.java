package aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MemberSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.esprit.jpa.Main;

import org.aspectj.lang.annotation.Before;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;


@Aspect
public class LoggingAspect {
	
    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);


//  @Pointcut("execution(* /HelloSpring/src/main/java/tester/HelloWorld.setName(..))")
//  private void testing(){
//      
//  }
    
    //pointcut logRetrait() : execution(* com.objis.demoaspectj.banque.CompteBancaire.retrait(..));

    //@Before("* com.esprit.jpa.model.Student.getName(..)")
//    @Before("execution(* com.esprit.jpa.Main.main())")
//    public void testBefore2(){
//        System.out.println("yoo2");
//        logger.info("yoooooooooooooooooooooooooo");
//    }
    
//    @Pointcut("within(com.esprit.jpa.model..*)")
//    public void loggingPoincut() {}

//	@Pointcut("execution(* *.*(..))")
//	protected void allMethod() {
//	}
//    
    
    
//    before():execution(* *.testAspectj()) {
        
        //Next line is Advice. A piece of code that will be executed at certain pointcuts.  
//        System.out.println("Before execution of testAspectj() method");
//    }
    
    
//	@Around("within(com.esprit.jpa.service..*) || initialization(com.esprit.jpa.service..new(..))")
//	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
//		//	    LocalDateTime startDate = LocalDateTime.now();		
////	    System.out.println("@Around: Before calculation-");
////		logger.debug("Entering in Method :  " + joinPoint.getSignature().getName());
////		logger.debug("Class Name :  " + joinPoint.getSignature().getDeclaringTypeName());
////		logger.debug("Arguments :  " + Arrays.toString(joinPoint.getArgs()));
////		logger.debug("Target class : " + joinPoint.getTarget().getClass().getName());
////		System.out.println("@Around: After calculation-"+  java.time.Duration.between(startDate, LocalDateTime.now()).toMillis());
//		//return joinPoint.proceed();
//		
//		long start = System.currentTimeMillis();
//		try {
//			logger.debug("Arguments :  " + Arrays.toString(joinPoint.getArgs()));
//			String className = joinPoint.getSignature().getDeclaringTypeName();
//			String methodName = joinPoint.getSignature().getName();
//			Object result = joinPoint.proceed();
//			long elapsedTime = System.currentTimeMillis() - start;
//			logger.debug("Method " + className + "." + methodName + " ()" + " execution time : "
//					+ elapsedTime + " ms");
//		
//			return result;
//		} catch (IllegalArgumentException e) {
//			logger.error("Illegal argument " + Arrays.toString(joinPoint.getArgs()) + " in "
//					+ joinPoint.getSignature().getName() + "()");
//			throw e;
//		}
//	}
	

	   @Before("within(com.esprit.jpa.service..*)")
	   public void logEntryAdvice(JoinPoint joinPoint) {
	      MemberSignature signature = (MemberSignature)joinPoint.getSignature();
	      Logger targetLogger = LoggerFactory.getLogger(signature.getDeclaringTypeName());
	      targetLogger.debug(">>> " + signature.getName());
	   }

	   @After("within(com.esprit.jpa.service..*)")
	   public void logExitAdvice(JoinPoint joinPoint) {
	      MemberSignature signature = (MemberSignature)joinPoint.getSignature();
	      Logger targetLogger = LoggerFactory.getLogger(signature.getDeclaringTypeName());
	      targetLogger.debug("<<< " + signature.getName());
	   }
	
	
    //readAll
//    @Before("within(com.esprit.jpa.model..*)")
//    public void testBefore(){
//        System.out.println("yoo2");
//        logger.info("yoooooooooooooooooooooooooo");
//    }

//
//    @Before("execution(* tester.HelloWorld.setName(String))")
//    public void testBefore(){
//        System.out.println("yoo");
//    }

}