package zh.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAnnotationAop {

    /**
     * 切入点
     */
    @Pointcut("execution(* zh.annotation.TestAnnotation(..))")// && args(id)
    public void pointCut() {

    }

    @Before("pointCut()")
    public void before(){

    }

    @After("pointCut()")
    public void after() {
    }
    //执行成功后通知
    @AfterReturning("pointCut()")
    public void afterReturn() {
    }
    //抛出异常后通知
    @AfterThrowing("pointCut()")
    public void afterThrow() {
    }

    //环绕通知
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinpoint) {
        Object[] args = joinpoint.getArgs();
        return null;
    }
}
