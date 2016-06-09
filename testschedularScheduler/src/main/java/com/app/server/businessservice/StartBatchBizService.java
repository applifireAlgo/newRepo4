package com.app.server.businessservice;
import java.util.concurrent.Future;

import org.quartz.SchedulerException;
import org.springframework.batch.core.JobParametersInvalidException;

public interface StartBatchBizService {

	public abstract Future<Object> initiateBatch() throws InterruptedException, JobParametersInvalidException, Exception, SchedulerException, ClassNotFoundException;

}
