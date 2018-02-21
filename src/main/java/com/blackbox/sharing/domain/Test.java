package com.blackbox.sharing.domain;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Test implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2308071040836654604L;

	@Id
    private Integer id;

	@OneToMany(
        mappedBy = "test", 
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    public List<QA> questions = new LinkedList<QA> ();

    @OneToOne
    @JoinColumn(name = "topic_id")
    @MapsId
	public Topic topic;

    /**
	 * 
	 */
	public Test() {
	}

	/**
	 * @param id
	 * @param questions
	 * @param topic
	 */
	public Test(Integer id, List<QA> questions, Topic topic) {
		this.id = id;
		this.questions = questions;
		this.topic = topic;
	}

	Integer getId() {
        return this.id;
    }

    void setId(Integer value) {
        this.id = value;
    }

	/**
	 * @return the questions
	 */
	public List<QA> getQuestions() {
		return questions;
	}

	/**
	 * @param questions the questions to set
	 */
	public void setQuestions(List<QA> questions) {
		this.questions = questions;
	}

	/**
	 * @return the topic
	 */
	public Topic getTopic() {
		return topic;
	}

	/**
	 * @param topic the topic to set
	 */
	public void setTopic(Topic topic) {
		this.topic = topic;
	}

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
		Test other = (Test) obj;
		if (id != other.id)
			return false;
		return true;
	}
}