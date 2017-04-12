package me.hobbier.service;

import me.hobbier.model.Hobby;

import java.util.Set;

/**
 * @author lilit.abrahamyan on 10/24/2016.
 */
public interface HobbierInternalService {

	/**
	 * Returns permissions granted to organization
	 *
	 * @return permissions identifiers set
	 */
	Set<Hobby> getHobbies();


}
