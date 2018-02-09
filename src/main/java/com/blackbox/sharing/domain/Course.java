package com.blackbox.sharing.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Course implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4565638880584236635L;

	private Integer id;

    private String name;

    private String description;

    public List<Lesson> lesson = new ArrayList<Lesson> ();

    public List<Task> task = new ArrayList<Task> ();

    public List<Test> test = new ArrayList<Test> ();

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
	public Course(Integer id, String name, String description, List<Lesson> lesson, List<Task> task, List<Test> test) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.lesson = lesson;
		this.task = task;
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
	 * @return the lesson
	 */
	public List<Lesson> getLesson() {
		return lesson;
	}

	/**
	 * @param lesson the lesson to set
	 */
	public void setLesson(List<Lesson> lesson) {
		this.lesson = lesson;
	}

	/**
	 * @return the task
	 */
	public List<Task> getTask() {
		return task;
	}

	/**
	 * @param task the task to set
	 */
	public void setTask(List<Task> task) {
		this.task = task;
	}

	/**
	 * @return the test
	 */
	public List<Test> getTest() {
		return test;
	}

	/**
	 * @param test the test to set
	 */
	public void setTest(List<Test> test) {
		this.test = test;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final int maxLen = 3;
		return "Course [id=" + id + ", name=" + name + ", description=" + description + ", lesson="
				+ (lesson != null ? lesson.subList(0, Math.min(lesson.size(), maxLen)) : null) + ", task="
				+ (task != null ? task.subList(0, Math.min(task.size(), maxLen)) : null) + ", test="
				+ (test != null ? test.subList(0, Math.min(test.size(), maxLen)) : null) + "]";
	}
}