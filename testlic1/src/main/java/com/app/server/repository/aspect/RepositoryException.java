package com.app.server.repository.aspect;import java.sql.SQLException;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.persistence.LockTimeoutException;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.OptimisticLockException;
import javax.persistence.PessimisticLockException;
import javax.persistence.QueryTimeoutException;
import javax.persistence.RollbackException;
import javax.persistence.TransactionRequiredException;

import org.aspectj.lang.ProceedingJoinPoint;

import com.spartan.pluggable.logger.alarms.AppAlarm;
import com.spartan.pluggable.logger.api.LogManager;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.spartan.pluggable.logger.event.RequestHeaderBean;

public final class RepositoryException{
	
	private LogManager Log=LogManagerFactory.getInstance();
	
	public void getException(String boundedContext,String domain,Exception e,RequestHeaderBean requestHeaderBean,ProceedingJoinPoint joinPoint) throws Exception
	{
		
		
		if (e instanceof EntityExistsException) {	
			AppAlarm appAlarm=Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.db.EntityExistsException");
			Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
			throw new EntityExistsException(appAlarm.getAlarmID());
		}
		if (e instanceof EntityNotFoundException) {
			AppAlarm appAlarm=Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.db.EntityNotFoundException");
			Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
			throw new com.spartan.pluggable.exception.layers.db.EntityNotFoundException(appAlarm.getAlarmID(),e.getCause());
		}
		if (e instanceof LockTimeoutException) {
			AppAlarm appAlarm=Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.db.LockTimeoutException");
			Log.out.println(appAlarm.getAlarmID(),requestHeaderBean,joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(),String.format(appAlarm.getMessage(), e.getMessage()));
			throw new com.spartan.pluggable.exception.layers.db.LockTimeoutException(appAlarm.getAlarmID(),e.getCause());
		}
		if (e instanceof NoResultException) {
			AppAlarm appAlarm=Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.db.NoResultException");
			Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getCause());
			throw new com.spartan.pluggable.exception.layers.db.NoResultException(appAlarm.getAlarmID(),e.getCause());
		}
		if (e instanceof NonUniqueResultException) {
			AppAlarm appAlarm=Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.db.NonUniqueResultException");
			Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getCause());
			throw new com.spartan.pluggable.exception.layers.db.NonUniqueResultException(appAlarm.getAlarmID(),e.getCause());
		}
		if (e instanceof OptimisticLockException) {
			AppAlarm appAlarm=Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.db.OptimisticLockException");
			Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getCause());
			throw new com.spartan.pluggable.exception.layers.db.OptimisticLockException(appAlarm.getAlarmID(),e.getCause());

		}
		if (e instanceof PessimisticLockException) {
			AppAlarm appAlarm=Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.db.PessismisticLockException");
			Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getCause());
			throw new com.spartan.pluggable.exception.layers.db.PessismisticLockException(appAlarm.getAlarmID(),e.getCause());
		}
		if (e instanceof QueryTimeoutException) {
			AppAlarm appAlarm=Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.db.QueryTimeoutException");
			Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getCause());
			throw new com.spartan.pluggable.exception.layers.db.QueryTimeoutException(appAlarm.getAlarmID(),e.getCause());

		}
		if (e instanceof RollbackException) {
			AppAlarm appAlarm=Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.db.RollbackException");
			Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getCause());
			throw new com.spartan.pluggable.exception.layers.db.RollbackException(appAlarm.getAlarmID(),e.getCause());

		}
		if (e instanceof TransactionRequiredException) {
			AppAlarm appAlarm=Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.db.TransactionRequiredException");
			Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getCause());
			throw new com.spartan.pluggable.exception.layers.db.TransactionRequiredException(appAlarm.getAlarmID(),e.getCause());
		}
		if (e instanceof IllegalArgumentException) {
			AppAlarm appAlarm=Log.getExceptionAlarm(boundedContext, domain, "com.spartan.pluggable.exception.layers.db.EntityNotFoundException");
			Log.out.println(appAlarm.getAlarmID(), requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getCause());
			throw new IllegalArgumentException(appAlarm.getAlarmID());
		}
		if (e instanceof Exception) {
			Log.out.println(boundedContext+domain+"352151500", requestHeaderBean, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature()
					.getName(), e.getCause());
			e.printStackTrace();
			throw new Exception(boundedContext+domain+"352151500");

		}


	}


}

