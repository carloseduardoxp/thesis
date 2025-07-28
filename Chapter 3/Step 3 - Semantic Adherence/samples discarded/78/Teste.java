@Aspect
public class LoggingAspect {
    @Before("execution(* com.example.MyService.*(..))")
    public void logMethodCall(JoinPoint joinPoint) {
        System.out.println("Method " + joinPoint.getSignature().getName() + " called");
    }
}

interface MyService {
    void doSomething();
}

class MyServiceImpl implements MyService {
    @Override
    public void doSomething() {
        System.out.println("Doing something");
    }
}
