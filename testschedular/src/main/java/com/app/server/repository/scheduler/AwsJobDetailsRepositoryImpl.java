package com.app.server.repository.scheduler;
import com.app.shared.scheduler.ArtJobDetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.athena.server.pluggable.utils.helper.ResourceFactoryManagerHelper;

@Repository
public class AwsJobDetailsRepositoryImpl implements ArtJobDetailsRepository{

	@Autowired
	private ResourceFactoryManagerHelper emfResource;

	@Override
	@Transactional
	public List<ArtJobDetails> findAll()
			throws Exception {
		javax.persistence.EntityManager entityManager = emfResource.getResource();
		java.util.List<ArtJobDetails> query = entityManager.createQuery("select u from ArtJobDetails u").getResultList();
		return query;
	}
}
