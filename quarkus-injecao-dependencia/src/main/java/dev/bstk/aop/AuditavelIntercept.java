package dev.bstk.aop;

import io.quarkus.arc.Priority;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

@Auditavel
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class AuditavelIntercept implements Serializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuditavelIntercept.class);

    @AroundInvoke
    public Object invoke(final InvocationContext context) throws Exception {
        LOGGER.info("** AuditavelIntercept **");
        LOGGER.info("Method: [ {} ]", context.getMethod());
        LOGGER.info("Target: [ {} ]", context.getTarget());
        LOGGER.info("Timer: [ {} ]", context.getTimer());
        LOGGER.info("Constructor: [ {} ]", context.getConstructor());

        Object proceed = context.proceed();

        LOGGER.info("O objeto retornado pelo método invocado: [ {} ]", proceed);

        System.out.println("\n\n");

        return proceed;
    }
}
