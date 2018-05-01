package com.blackbox.sharing.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    ///@JsonBackReference
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "COURSE_MEMBER",
     joinColumns = { @JoinColumn(name = "course_id") },
     inverseJoinColumns = { @JoinColumn(name = "member_id") }
    )
    public List<Member> learners = new ArrayList<Member> ();

    ///@JsonIgnoreProperties("courses")
    ///@JsonIgnore
    @OneToMany(mappedBy="course")
    /***@JoinTable(name = "COURSE_TOPIC",
     joinColumns = { @JoinColumn(name = "course_id") },
     inverseJoinColumns = { @JoinColumn(name = "topic_id") }
    )***/
    public List<Topic> topics = new LinkedList<Topic> ();

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
	 * @return the learners
	 */
	public List<Member> getLearners() {
		return learners;
	}

	/**
	 * @param learners the learners to set
	 */
	public void setLearners(List<Member> learners) {
		this.learners = learners;
	}

	/**
	 * @return the topics
	 */
	public List<Topic> getTopics() {
		return topics;
	}

	/**
	 * @param topics the topics to set
	 */
	public void setTopics(List<Topic> topics) {
		this.topics = topics;
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