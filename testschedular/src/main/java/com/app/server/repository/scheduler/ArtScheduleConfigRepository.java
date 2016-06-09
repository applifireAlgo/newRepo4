package com.app.server.repository.scheduler;
import com.app.shared.scheduler.ArtScheduleConfig;

import java.util.List;

public interface ArtScheduleConfigRepository {

	public void save(ArtScheduleConfig entity);

	public void update(ArtScheduleConfig entity);

	public List<ArtScheduleConfig> findAll();

	public ArtScheduleConfig findById(String findKey);

}
