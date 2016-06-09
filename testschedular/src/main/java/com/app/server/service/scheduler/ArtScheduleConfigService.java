package com.app.server.service.scheduler;
import com.app.shared.scheduler.ArtJobDetails;

import com.app.shared.scheduler.ArtScheduleConfig;

import java.util.List;

import atg.taglib.json.util.JSONArray;

import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;


/****
 * 
 * @author puja
 *
 */

public interface ArtScheduleConfigService {

	public void save(ArtScheduleConfig entity) throws Exception;

	public void update(ArtScheduleConfig entity);

	public List<ArtScheduleConfig> findAll();

	public ArtScheduleConfig findById(String findKey) throws Exception;

	public JSONArray getTreeStores() throws Exception;
	
	public List<ArtJobDetails> findAllJobs()throws Exception;

}
