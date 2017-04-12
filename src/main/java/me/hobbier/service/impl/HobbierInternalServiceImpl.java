package me.hobbier.service.impl;

import me.hobbier.dac.HobbierDao;
import me.hobbier.model.Hobby;
import me.hobbier.service.HobbierInternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author lilit.abrahamyan on 10/24/2016.
 */
@Repository
public class HobbierInternalServiceImpl implements HobbierInternalService {

	private final HobbierDao hobbierDao;

	@Autowired
	public HobbierInternalServiceImpl(HobbierDao organizationDao) {
		this.hobbierDao = organizationDao;
	}

	public Set<Hobby> getHobbies() {
		return hobbierDao.getHobbies();
	}


}
