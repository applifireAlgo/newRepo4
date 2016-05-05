package com.app.server.businessservice.aspect;import org.aspectj.lang.ProceedingJoinPoint;

import com.spartan.pluggable.exception.layers.ds.BatchProcessFailedException;
import com.spartan.pluggable.exception.layers.ds.BatchProcessInterruptedException;
import com.spartan.pluggable.exception.layers.ds.BatchProcessNotFoundException;
import com.spartan.pluggable.exception.layers.ds.BusinessAspectFailedException;
import com.spartan.pluggable.exception.layers.ds.BusinessRuleFailedException;
import com.spartan.pluggable.exception.layers.ds.BusinessRuleInternalError;
import com.spartan.pluggable.exception.layers.ds.BusinessRuleInterruptedException;
import com.spartan.pluggable.exception.layers.ds.BusinessRuleNotFoundException;
import com.spartan.pluggable.exception.layers.ds.BusinessRulePreConditionException;
import com.spartan.pluggable.exception.layers.ds.NotificationConnectionException;
import com.spartan.pluggable.exception.layers.ds.NotificationFailedException;
import com.spartan.pluggable.exception.layers.ds.NotificationNotFoundException;
import com.spartan.pluggable.exception.layers.ds.NotificationTemplateException;
import com.spartan.pluggable.logger.alarms.AppAlarm;
import com.spartan.pluggable.logger.api.LogManager;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.spartan.pluggable.logger.event.RequestHeaderBean;

public final class BusinessException {

	private LogManager Log = LogManagerFactory.getInstance();

	public void getException(String boundedContext, String domain, Exception e,RequestHeaderBean requestHeaderBean, ProceedingJoinPoint joinPoint)throws Exception {

		if (e instanceof BusinessRulePreConditionException) {
			AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain,"com.spartan.pluggable.exception.layers.ds.BusinessRulePreConditionException");
			Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(),e.getMessage());
			throw new BusinessRulePreConditionException(appAlarm.getAlarmID(),e.getCause());
		}
		else if (e instanceof BusinessRuleInternalError) {
			AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain,"com.spartan.pluggable.exception.layers.ds.BusinessRuleInternalError");
			Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(),e.getMessage());
			throw new BusinessRuleInternalError(appAlarm.getAlarmID(),e.getCause());
		}
		else if (e instanceof BusinessRuleNotFoundException) {
			AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain,"com.spartan.pluggable.exception.layers.ds.BusinessRuleNotFoundException");
			Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(),e.getMessage());
			throw new BusinessRuleNotFoundException(appAlarm.getAlarmID(),e.getCause());
		}
		else if (e instanceof BusinessRuleFailedException) {
			AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain,"com.spartan.pluggable.exception.layers.ds.BusinessRuleFailedException");
			Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(),e.getMessage());
			throw new BusinessRuleFailedException(appAlarm.getAlarmID(),e.getCause());
		}
		else if (e instanceof BusinessRuleInterruptedException) {
			AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain,"com.spartan.pluggable.exception.layers.ds.BusinessRuleInterruptedException");
			Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(),e.getMessage());
			throw new BusinessRuleInterruptedException(appAlarm.getAlarmID(),e.getCause());
		}
		else if (e instanceof BusinessAspectFailedException) {
			AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain,"com.spartan.pluggable.exception.layers.ds.BusinessAspectFailedException");
			Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(),e.getMessage());
			throw new BusinessAspectFailedException(appAlarm.getAlarmID(),e.getCause());
		}
		else if (e instanceof BatchProcessFailedException) {
			AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain,"com.spartan.pluggable.exception.layers.ds.BatchProcessFailedException");
			Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(),e.getMessage());
			throw new BatchProcessFailedException(appAlarm.getAlarmID(),e.getCause());
		}
		else if (e instanceof BatchProcessInterruptedException) {
			AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain,"com.spartan.pluggable.exception.layers.ds.BatchProcessInterruptedException");
			Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(),e.getMessage());
			throw new BatchProcessInterruptedException(appAlarm.getAlarmID(),e.getCause());
		}
		else if (e instanceof BatchProcessNotFoundException) {
			AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain,"com.spartan.pluggable.exception.layers.ds.BatchProcessNotFoundException");
			Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(),e.getMessage());
			throw new BatchProcessNotFoundException(appAlarm.getAlarmID(),e.getCause());
		}
		else if (e instanceof NotificationConnectionException) {
			AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain,"com.spartan.pluggable.exception.layers.ds.NotificationConnectionException");
			Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(),e.getMessage());
			throw new NotificationConnectionException(appAlarm.getAlarmID(),e.getCause());
		}
		else if (e instanceof NotificationFailedException) {
			AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain,"com.spartan.pluggable.exception.layers.ds.NotificationFailedException");
			Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(),e.getMessage());
			throw new NotificationFailedException(appAlarm.getAlarmID(),e.getCause());
		}
		else if (e instanceof NotificationNotFoundException) {
			AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain,"com.spartan.pluggable.exception.layers.ds.NotificationNotFoundException");
			Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(),e.getMessage());
			throw new NotificationNotFoundException(appAlarm.getAlarmID(),e.getCause());
		}
		else if (e instanceof NotificationTemplateException) {
			AppAlarm appAlarm = Log.getExceptionAlarm(boundedContext, domain,"com.spartan.pluggable.exception.layers.ds.NotificationTemplateException");
			Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(),e.getMessage());
			throw new NotificationTemplateException(appAlarm.getAlarmID(),e.getCause());
		}else
		{
			Log.out.println(boundedContext+domain+"257101500", requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature()
					.getName(), e.getCause());
			e.printStackTrace();
			throw new Exception(boundedContext+domain+"257101500");
		}
		
	}
}
