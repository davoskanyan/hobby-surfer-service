package me.hobbier.model;

import java.util.Date;

/**
 * @author lilit.abrahamyan on 9/27/2016.
 */

public class Organization {

	private final Integer id;
	private final String name;
	private final String description;
	private final Integer parentId;
	private final Date modifiedOn;

	public Organization(Integer id, String name, String description, Integer parentId) {
		this(id, name, description, parentId, null);
	}

	public Organization(Integer id, String name, String description, Integer parentId, Date modifiedOn) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.parentId = parentId;
		this.modifiedOn = modifiedOn;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Integer getParentId() {
		return parentId;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Organization that = (Organization) o;

		return id != null ? id.equals(that.id) : that.id == null;

	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}
}
