package com.app.server.repository.appbasicsetup.usermanagement.aspect;
import com.app.server.repository.aspect.RepositoryAspect;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import com.spartan.pluggable.logger.api.LogManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import com.spartan.healthmeter.entity.scheduler.MethodCallDetails;
import com.spartan.healthmeter.msgWriter.config.HealthConstants;
import com.athena.server.pluggable.utils.AppLoggerConstant;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.spartan.pluggable.logger.alarms.AppAlarm;
import com.app.server.repository.aspect.RepositoryException;

@Aspect
@Component
public class RepositoryusermanagementAspect extends RepositoryAspect {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private ArtMethodCallStack requestDetails;

    private LogManager Log = LogManagerFactory.getInstance(AppLoggerConstant.LOGGER_ID);

    @Around("allOperation()")
    public Object aroundAllOtherOpeartion(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodCallDetails methodCallDetails = new MethodCallDetails(requestDetails.getRequestId(), requestDetails.getCallSequence(), HealthConstants.CLASS_TYPE.REPOSITORY, runtimeLogInfoHelper.getRuntimeLogInfo().getUserIPAddress(), "", joinPoint.getTarget().getClass().toString(), joinPoint.getSignature().getName(), runtimeLogInfoHelper.getRuntimeLogInfo().getUserId(), requestDetails.getAppSessionId());
        Object object = null;
        repositoryLogic(joinPoint);
        try {
            Log.out.println("ABSUM314900100", runtimeLogInfoHelper.getRequestHeaderBean(), joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), joinPoint.getSignature().getDeclaringTypeName() + ":" + joinPoint.getSignature().getName());
            object = joinPoint.proceed();
            methodCallDetails.setPostCallDetails(HealthConstants.METHOD_NORMAL_EXECUTION);
            Log.out.println("ABSUM347900100", runtimeLogInfoHelper.getRequestHeaderBean(), joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), joinPoint.getSignature().getDeclaringTypeName(), methodCallDetails.getExecution_Time());
        } catch (Exception e) {
            RepositoryException repositoryException = new RepositoryException();
            repositoryException.getException("ABS", "UM", e, runtimeLogInfoHelper.getRequestHeaderBean(), joinPoint);
        } finally {
            requestDetails.addMethodCallDetails(methodCallDetails);
        }
        return object;
    }

    @Around("findOperation()||getOperation()")
    public Object aroundfindAll(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodCallDetails methodCallDetails = new MethodCallDetails(requestDetails.getRequestId(), requestDetails.getCallSequence(), HealthConstants.CLASS_TYPE.REPOSITORY, runtimeLogInfoHelper.getRuntimeLogInfo().getUserIPAddress(), "", joinPoint.getTarget().getClass().toString(), joinPoint.getSignature().getName(), runtimeLogInfoHelper.getRuntimeLogInfo().getUserId(), requestDetails.getAppSessionId());
        Object object = null;
        repositoryLogic(joinPoint);
        try {
            Log.out.println("ABSUM314900100", runtimeLogInfoHelper.getRequestHeaderBean(), joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), joinPoint.getSignature().getDeclaringTypeName() + ":" + joinPoint.getSignature().getName());
            object = joinPoint.proceed();
            methodCallDetails.setPostCallDetails(HealthConstants.METHOD_NORMAL_EXECUTION);
            Log.out.println("ABSUM347900100", runtimeLogInfoHelper.getRequestHeaderBean(), joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), joinPoint.getSignature().getDeclaringTypeName(), methodCallDetails.getExecution_Time());
        } catch (Exception e) {
            RepositoryException repositoryException = new RepositoryException();
            repositoryException.getException("ABS", "UM", e, runtimeLogInfoHelper.getRequestHeaderBean(), joinPoint);
        } finally {
            requestDetails.addMethodCallDetails(methodCallDetails);
        }
        return object;
    }

    @Around("saveOperation()")
    public Object aroundSave(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodCallDetails methodCallDetails = new MethodCallDetails(requestDetails.getRequestId(), requestDetails.getCallSequence(), HealthConstants.CLASS_TYPE.REPOSITORY, runtimeLogInfoHelper.getRuntimeLogInfo().getUserIPAddress(), "", joinPoint.getTarget().getClass().toString(), joinPoint.getSignature().getName(), runtimeLogInfoHelper.getRuntimeLogInfo().getUserId(), requestDetails.getAppSessionId());
        Object object = null;
        repositoryLogic(joinPoint);
        try {
            Log.out.println("ABSUM322900100", runtimeLogInfoHelper.getRequestHeaderBean(), joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), joinPoint.getSignature().getDeclaringTypeName() + ":" + joinPoint.getSignature().getName());
            object = joinPoint.proceed();
            methodCallDetails.setPostCallDetails(HealthConstants.METHOD_NORMAL_EXECUTION);
            Log.out.println("ABSUM347900100", runtimeLogInfoHelper.getRequestHeaderBean(), joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), joinPoint.getSignature().getDeclaringTypeName(), methodCallDetails.getExecution_Time());
        } catch (Exception e) {
            RepositoryException repositoryException = new RepositoryException();
            repositoryException.getException("ABS", "UM", e, runtimeLogInfoHelper.getRequestHeaderBean(), joinPoint);
        } finally {
            requestDetails.addMethodCallDetails(methodCallDetails);
        }
        return object;
    }

    @Around("updateOperation()")
    public Object aroundUpdate(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodCallDetails methodCallDetails = new MethodCallDetails(requestDetails.getRequestId(), requestDetails.getCallSequence(), HealthConstants.CLASS_TYPE.REPOSITORY, runtimeLogInfoHelper.getRuntimeLogInfo().getUserIPAddress(), "", joinPoint.getTarget().getClass().toString(), joinPoint.getSignature().getName(), runtimeLogInfoHelper.getRuntimeLogInfo().getUserId(), requestDetails.getAppSessionId());
        Object object = null;
        repositoryLogic(joinPoint);
        try {
            Log.out.println("ABSUM311900100", runtimeLogInfoHelper.getRequestHeaderBean(), joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), joinPoint.getSignature().getDeclaringTypeName() + ":" + joinPoint.getSignature().getName());
            object = joinPoint.proceed();
            methodCallDetails.setPostCallDetails(HealthConstants.METHOD_NORMAL_EXECUTION);
            Log.out.println("ABSUM347900100", runtimeLogInfoHelper.getRequestHeaderBean(), joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), joinPoint.getSignature().getDeclaringTypeName(), methodCallDetails.getExecution_Time());
        } catch (Exception e) {
            RepositoryException repositoryException = new RepositoryException();
            repositoryException.getException("ABS", "UM", e, runtimeLogInfoHelper.getRequestHeaderBean(), joinPoint);
        } finally {
            requestDetails.addMethodCallDetails(methodCallDetails);
        }
        return object;
    }

    @Around("deleteOperation()")
    public Object aroundDelete(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodCallDetails methodCallDetails = new MethodCallDetails(requestDetails.getRequestId(), requestDetails.getCallSequence(), HealthConstants.CLASS_TYPE.REPOSITORY, runtimeLogInfoHelper.getRuntimeLogInfo().getUserIPAddress(), "", joinPoint.getTarget().getClass().toString(), joinPoint.getSignature().getName(), runtimeLogInfoHelper.getRuntimeLogInfo().getUserId(), requestDetails.getAppSessionId());
        Object object = null;
        repositoryLogic(joinPoint);
        try {
            Log.out.println("ABSUM318900100", runtimeLogInfoHelper.getRequestHeaderBean(), joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), joinPoint.getSignature().getDeclaringTypeName() + ":" + joinPoint.getSignature().getName());
            object = joinPoint.proceed();
            methodCallDetails.setPostCallDetails(HealthConstants.METHOD_NORMAL_EXECUTION);
            Log.out.println("ABSUM347900100", runtimeLogInfoHelper.getRequestHeaderBean(), joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), joinPoint.getSignature().getDeclaringTypeName(), methodCallDetails.getExecution_Time());
        } catch (Exception e) {
            RepositoryException repositoryException = new RepositoryException();
            repositoryException.getException("ABS", "UM", e, runtimeLogInfoHelper.getRequestHeaderBean(), joinPoint);
        } finally {
            requestDetails.addMethodCallDetails(methodCallDetails);
        }
        return object;
    }

    @Around("alarmRepofindOperation()")
    public Object aroundAlarmRepofindOperation(ProceedingJoinPoint joinPoint) throws Throwable {
        Object object = null;
        try {
            object = joinPoint.proceed();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    @Pointcut("execution(* com.app.server.repository.appbasicsetup.usermanagement..save*(..))")
    protected void saveOperation() {
    }

    @Pointcut("execution(* com.app.server.repository.appbasicsetup.usermanagement..update*(..))")
    protected void updateOperation() {
    }

    @Pointcut("execution(* com.app.server.repository.appbasicsetup.usermanagement..delete*(..))")
    protected void deleteOperation() {
    }

    @Pointcut("execution(* com.app.server.repository.appbasicsetup.usermanagement..find*(..)) && ! alarmRepofindOperation()")
    protected void findOperation() {
    }

    @Pointcut("execution(* com.app.server.repository.appbasicsetup.usermanagement..get*(..)) && ! alarmRepofindOperation()")
    protected void getOperation() {
    }

    @Pointcut("execution(* com.app.server.repository.appbasicsetup.usermanagement..*(..)) && ! findOperation() && ! saveOperation() && ! updateOperation() && ! deleteOperation() && ! getOperation() && ! alarmRepofindOperation()")
    protected void allOperation() {
    }

    @Pointcut("execution(* com.app.server.repository.appbasicsetup.usermanagement.ArtLogAlarmRepository..getVersionNumber(..)) || execution(* com.app.server.repository.appbasicsetup.usermanagement.ArtLogAlarmRepository..getAlarmDataByType(..))")
    protected void alarmRepofindOperation() {
    }
}
