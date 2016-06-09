package com.app.server.repository.scheduler;
import com.app.shared.scheduler.ArtScheduleConfig;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.athena.server.pluggable.utils.helper.ResourceFactoryManagerHelper;

@Repository
@Transactional
public class ArtScheduleConfigRepositoryImpl implements ArtScheduleConfigRepository {
	@Autowired
	private ResourceFactoryManagerHelper emfResource;
	
	@Override
	@Transactional
	public void save(ArtScheduleConfig entity) {
		try {
			javax.persistence.EntityManager entityManager = emfResource.getResource();
			entityManager.persist(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public void update(ArtScheduleConfig entity) {
		try {
			javax.persistence.EntityManager entityManager = emfResource.getResource();
			entityManager.merge(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ArtScheduleConfig> findAll() {
		try {
			javax.persistence.EntityManager entityManager = emfResource.getResource();
			java.util.List<ArtScheduleConfig> query = entityManager.createQuery("select u from ArtScheduleConfig u").getResultList();
			return query;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArtScheduleConfig findById(String scheduleId) {
		try {
			javax.persistence.EntityManager entityManager = emfResource.getResource();
			javax.persistence.Query query = entityManager.createQuery("select u from ArtScheduleConfig u where u.schedulerId=:schedulerId");
			query.setParameter("schedulerId", scheduleId);
			ArtScheduleConfig entity = (ArtScheduleConfig) query.getSingleResult();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
		}return null;
	}
}
