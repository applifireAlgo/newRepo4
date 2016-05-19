package com.app.server.repository.scheduler;
import com.app.shared.scheduler.ArtJobDetails;

import java.util.List;

public interface ArtJobDetailsRepository {

	public List<ArtJobDetails> findAll() throws Exception;
}
