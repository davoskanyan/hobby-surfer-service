package me.hobbier.model;

/**
 * Created by davos on 4/7/2017.
 */
public class Hobby {
	Integer id;
	MultilingualString name;

	public Hobby(Integer id, MultilingualString name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MultilingualString getName() {
		return name;
	}

	public void setName(MultilingualString name) {
		this.name = name;
	}
}
