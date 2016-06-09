package com.app.server.service.scheduler;
import com.app.shared.scheduler.ArtJobDetails;

import com.app.shared.scheduler.ArtScheduleConfig;

import com.app.server.repository.scheduler.ArtJobDetailsRepository;

import com.app.server.repository.scheduler.ArtScheduleConfigRepository;

import com.app.shared.scheduler.SchedulerGeneration;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import atg.taglib.json.util.JSONArray;

@Service
public class ArtScheduleConfigServiceImpl  implements ArtScheduleConfigService {

	@Autowired
	private ArtScheduleConfigRepository scheduleConfigRepo;

	@Autowired
	private SchedulerGeneration schedulerGeneration;

	@Autowired
	private ArtJobDetailsRepository artJobDetailsRepository;

	@Override
	public void save(ArtScheduleConfig entity) throws Exception {
		try {
			entity.setSchedulerExpression(schedulerGeneration.generateSchedulerExpression(entity));
		} catch (Exception e) {
			e.printStackTrace();
		}
		scheduleConfigRepo.save(entity);
	}

	@Override
	public void update(ArtScheduleConfig entity) {
		try {
			entity.setSchedulerExpression(schedulerGeneration.generateSchedulerExpression(entity));
		} catch (org.json.JSONException e) {
			e.printStackTrace();
		}
		scheduleConfigRepo.update(entity);
	}

	@Override
	public List<ArtScheduleConfig> findAll() {
		List<ArtScheduleConfig> lstEntity = scheduleConfigRepo.findAll();
		return lstEntity;
	}

	@Override
	public ArtScheduleConfig findById(String findKey) throws Exception {
		ArtScheduleConfig entity = scheduleConfigRepo.findById(findKey);
		return entity;
	}

	@Override
	public JSONArray getTreeStores() throws Exception {
		System.out.println("inside");
		List<ArtScheduleConfig> lstEntity = scheduleConfigRepo.findAll();
		JSONArray treeStoreJSONArray = new JSONArray();
		for (Iterator<ArtScheduleConfig> lstEntityIterator = lstEntity.iterator(); lstEntityIterator.hasNext();) {
			ArtScheduleConfig entity = (ArtScheduleConfig) lstEntityIterator.next();
			treeStoreJSONArray.add(entity.toTreeNode());
		}
		return treeStoreJSONArray;
	}

	@Override
	public List<ArtJobDetails> findAllJobs() throws Exception {
		try {
			return artJobDetailsRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
