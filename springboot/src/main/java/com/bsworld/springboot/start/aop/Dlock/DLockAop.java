package com.bsworld.springboot.start.aop.Dlock;

import com.bsworld.springboot.start.aop.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * program: fianl
 * author: bsworld.xie
 * create: 2020-01-10 13:47
 * description:
 */
@Aspect
@Component
public class DLockAop {
    private ExpressionParser parser = new SpelExpressionParser();

    private LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();

    @Autowired
    DLockService lockService;

    @Pointcut(value = "execution (public * *(..))")
    public void lockPc() {

    }

    @Around(value = "lockPc() && @annotation(dLock) ")
    public Object around(ProceedingJoinPoint pjp, DLock dLock) {
        String value = String.valueOf(System.currentTimeMillis());
        String key = dLock.key();
        try {
            long expireTime = dLock.expireTime();
            key = parse(pjp, key);
            lockService.lock(key, value, expireTime);
            return pjp.proceed();

        } catch (Throwable throwable) {

        } finally {
            lockService.releaseLock(key, value);
        }

        return null;
    }


    private Method getMethod(ProceedingJoinPoint pjp) {
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();

        return methodSignature.getMethod();
    }


    private String parse(ProceedingJoinPoint pjp, String key) {
        Method method = getMethod(pjp);
        Object[] arguments = pjp.getArgs();
        String[] params = discoverer.getParameterNames(method);
        EvaluationContext context = new StandardEvaluationContext();
        for (int len = 0; len < params.length; len++) {
            context.setVariable(params[len], arguments[len]);
        }
        try {
            Expression expression = parser.parseExpression(key);
            return expression.getValue(context, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void main(String[] args) {
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("name", "ddd");
        ExpressionParser parser = new SpelExpressionParser();
        String expression = "'hello' + #name";
        Expression expression1 = parser.parseExpression(expression);
        Object value = expression1.getValue(context,String.class);
        System.out.println(value);
    }


}
