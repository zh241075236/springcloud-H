package zh.annotation.processor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import zh.annotation.TestAnnotation;

@Aspect
@Component
public class TestAspect {

    @Pointcut(value = "@annotation(testAnnotation)")
    public void pointCut(TestAnnotation testAnnotation){}

    @Before(value = "pointCut(testAnnotation)")
    public void before(JoinPoint joinPoint,TestAnnotation testAnnotation){
        System.out.println("before");
    }

    @Around(value = "pointCut(testAnnotation)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint,TestAnnotation testAnnotation){
        String value = testAnnotation.value();
        System.out.println("around:" + value);
        return null;
    }

    @After(value = "pointCut(testAnnotation)")
    public void after(TestAnnotation testAnnotation){
        System.out.println("after");
    }
}
