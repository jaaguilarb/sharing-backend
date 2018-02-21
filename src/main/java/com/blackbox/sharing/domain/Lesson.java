package com.blackbox.sharing.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Lesson implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7455099701492090246L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String description;

    public ResourceType resourceType;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="topic_id")
    public Topic topic;

    /**
	 * 
	 */
	public Lesson() {
	}

    /**
	 * @param id
	 * @param title
	 * @param description
	 * @param resourceType
	 */
	public Lesson(Integer id, String title, String description, ResourceType resourceType) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.resourceType = resourceType;
	}

	int getId() {
        return this.id;
    }

    void setId(int value) {
        this.id = value;
    }

    String getTitle() {
        return this.title;
    }

    void setTitle(String value) {
        this.title = value;
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
		Lesson other = (Lesson) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
