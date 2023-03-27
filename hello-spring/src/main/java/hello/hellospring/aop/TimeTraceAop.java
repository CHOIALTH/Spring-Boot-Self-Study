package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// AOP 적용 시 @Aspect를 적어줘야 함
@Aspect
@Component
public class TimeTraceAop {

    // hellospring 패키지 하위에는 전부 적용한 것
    @Around("execution(* hello.hellospring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        System.out.println("START = " + joinPoint.toString());
        // joinPoint.proceed() = 다음 메소드로 진행이 됨
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END = " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}
