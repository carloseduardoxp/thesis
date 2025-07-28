
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.service.*.*(..))")
    public void logBeforeAllMethods() {
        System.out.println("Logging before method execution");
    }

    @AfterReturning(
        pointcut = "execution(* com.example.service.*.get*(..))",
        returning = "result"
    )
    public void logAfterReturning(Object result) {
        System.out.println("Method returned: " + result);
    }

    @Around("execution(* com.example.service.*.process*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before process method");
        Object result = joinPoint.proceed();
        System.out.println("After process method");
        return result;
    }
}
