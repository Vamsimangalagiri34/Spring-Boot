package com.vamsi.examples.AllExamples.AOP.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectEx {

    @Before("execution(* com.vamsi.examples.AllExamples.AOP.Controller.*.*(..))")
    public void logMethodParams(JoinPoint joinPoint) {
        System.out.println("📘 [BEFORE] Method called: " + joinPoint.getSignature().getName());


        Object[] args = joinPoint.getArgs();
        if (args.length == 0) {
            System.out.println("⚪ No parameters passed.");
            return;
        }

//        boolean isTrue=false;
        int count=0;
        for (Object arg : args) {
            if (arg instanceof Integer) {
                int id = (Integer) arg;
                System.out.println("🔹 Integer parameter: " + id);
                if(arg.equals(34)){
                    count++;
                }
            } else if (arg instanceof String) {
                String name = (String) arg;
                System.out.println("🔹 String parameter: " + name);
                if(name.equals("vamsi")){
                    count++;
                }
            } else {
                System.out.println("⚪ Other type parameter: " + arg.getClass().getSimpleName() + " = " + arg);
            }
        }

        if(count==2){
            System.out.println("login successfull");
        }

    }


    @After("execution(* com.vamsi.examples.AllExamples.AOP.Controller.*.*(..))")
    public void afterGreeting(JoinPoint joinPoint) {
        System.out.println("📘 [AFTER] Method called: " + joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* com.vamsi.examples.AllExamples.AOP.Service.*.*(..))")
    public  void afterReturning(JoinPoint joinPoint){
        System.out.println("📘 [AFTER RETURNING] Method called: " + joinPoint.getSignature().getName());
    }

    @AfterThrowing("execution(* com.vamsi.examples.AllExamples.AOP.Service.*.*(..))")
    public  void afterThrowing(){
        System.out.println("after throwing");
    }

}
