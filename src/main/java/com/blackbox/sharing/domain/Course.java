package com.blackbox.sharing.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Course implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4565638880584236635L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

    private String name;

    private String description;

    //public List<Lesson> lesson = new ArrayList<Lesson> ();

    //public List<Task> task = new ArrayList<Task> ();

    //public List<Test> test = new ArrayList<Test> ();

    @ManyToMany(mappedBy = "assignedCourses")
    public List<Member> hasLearners = new ArrayList<Member> ();

	/**
	 * 
	 */
	public Course() {
	}

	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param lesson
	 * @param task
	 * @param test
	 */
	public Course(Integer id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the hasLearners
	 */
	public List<Member> getHasLearners() {
		return hasLearners;
	}

	/**
	 * @param hasLearners the hasLearners to set
	 */
	public void setHasLearners(List<Member> hasLearners) {
		this.hasLearners = hasLearners;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}