package com.blackbox.sharing.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String description;

    @JsonBackReference
    @ManyToMany(mappedBy="topics")
    public List<Course> courses = new ArrayList<Course> ();

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "topic")
    public Test test;

    @OneToMany(mappedBy="topic",
    		cascade = CascadeType.ALL,
    		orphanRemoval = true)
    public List<Lesson> lessons = new LinkedList<Lesson> ();

	/**
	 * 
	 */
	public Topic() {
	}

	/**
	 * @param id
	 * @param title
	 * @param description
	 * @param courses
	 * @param test
	 */
	public Topic(Integer id, String title, String description, List<Course> courses, Test test) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.courses = courses;
		this.test = test;
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @return the courses
	 */
	public List<Course> getCourses() {
		return courses;
	}

	/**
	 * @param courses the courses to set
	 */
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	/**
	 * @return the test
	 */
	public Test getTest() {
		return test;
	}

	/**
	 * @param test the test to set
	 */
	public void setTest(Test test) {
		this.test = test;
	}

	/**
	 * @return the lessons
	 */
	public List<Lesson> getLessons() {
		return lessons;
	}

	/**
	 * @param lessons the lessons to set
	 */
	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
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
		Topic other = (Topic) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final int maxLen = 3;
		return "Topic [id=" + id + ", title=" + title + ", description=" + description + ", courses="
				+ (courses != null ? courses.subList(0, Math.min(courses.size(), maxLen)) : null) + ", test=" + test
				+ "]";
	}

}
