import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect // Marks this class as an Aspect
@Component // Makes it a Spring bean
public class LoggingAspect {

    // Define a pointcut that matches all methods in the com.example.service package
    @Pointcut("execution(* com.example.service.*.*(..))")
    public void serviceMethods() {}

    @Before("serviceMethods()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before method: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "serviceMethods()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("After returning from method: " + joinPoint.getSignature().getName() + " with result: " + result);
    }

    @AfterThrowing(pointcut = "serviceMethods()", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        System.err.println("After throwing exception from method: " + joinPoint.getSignature().getName() + " Exception: " + exception.getMessage());
    }

    @Around("serviceMethods()")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed(); // Execute the actual method
        } finally {
            long end = System.currentTimeMillis();
            System.out.println("Method " + proceedingJoinPoint.getSignature().getName() + " executed in " + (end - start) + "ms");
        }
        return result;
    }
}
