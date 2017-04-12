package me.hobbier.model;

import java.util.Map;

/**
 * @author lilit.abrahamyan on 10/13/2016.
 */
public class MultilingualString {

	private final Map<Integer, String> names;

	public MultilingualString(Map<Integer, String> names) {
		this.names = names;
	}

	public Map<Integer, String> getNames() {
		return names;
	}
}
