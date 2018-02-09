package com.blackbox.sharing.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * @author joseph
 *
 */
@Entity
public class Enrollment implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8250390961869854925L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	/***@ManyToMany
	@JoinTable(name="Enrollment_Person",
		joinColumns = @JoinColumn(name = "enrollment_id"),
		inverseJoinColumns = @JoinColumn(name = "person_id"))***/
    //public List<Person> person = new ArrayList<Person> ();

	//public List<Course> assignedCourse = new ArrayList<Course> ();

	@ManyToMany
	@JoinTable(name="Enrollment_Member",
		joinColumns = @JoinColumn(name = "enrollment_id"),
		inverseJoinColumns = @JoinColumn(name = "person_id"))
    public List<Member> hasCourses = new ArrayList<Member> ();

    /**
	 * 
	 */
	public Enrollment() {
	}

	/**
	 * @param id
	 * @param person
	 * @param course
	 */
	public Enrollment(Integer id/*, List<Person> person, List<Course> course*/) {
		this.id = id;
		/*this.person = person;
		this.course = course;*/
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
	 * @return the course
	 */
	/***public List<Course> getCourse() {
		return course;
	}***/

	/**
	 * @return the hasCourses
	 */
	public List<Member> getHasCourses() {
		return hasCourses;
	}

	/**
	 * @param hasCourses the hasCourses to set
	 */
	public void setHasCourses(List<Member> hasCourses) {
		this.hasCourses = hasCourses;
	}

	/**
	 * @param course the course to set
	 */
	/***public void setCourse(List<Course> course) {
		this.course = course;
	}***/

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Enrollment other = (Enrollment) obj;
		if (id != other.id)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final int maxLen = 3;
		return "Enrollment [id=" + id + ", hasCourses="
				+ (hasCourses != null ? hasCourses.subList(0, Math.min(hasCourses.size(), maxLen)) : null) + "]";
	}
}