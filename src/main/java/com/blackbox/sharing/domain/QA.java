package com.blackbox.sharing.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class QA implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4717638291815161455L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String question;

    private String correctAnswer;

    private String answer;

    public QAType itemType;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    public Test test;

	/**
	 * 
	 */
	public QA() {
	}

	/**
	 * @param id
	 * @param question
	 * @param correctAnswer
	 * @param answer
	 * @param itemType
	 * @param test
	 */
	public QA(Integer id, String question, String correctAnswer, String answer, QAType itemType, Test test) {
		this.id = id;
		this.question = question;
		this.correctAnswer = correctAnswer;
		this.answer = answer;
		this.itemType = itemType;
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
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return the correctAnswer
	 */
	public String getCorrectAnswer() {
		return correctAnswer;
	}

	/**
	 * @param correctAnswer the correctAnswer to set
	 */
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * @return the itemType
	 */
	public QAType getItemType() {
		return itemType;
	}

	/**
	 * @param itemType the itemType to set
	 */
	public void setItemType(QAType itemType) {
		this.itemType = itemType;
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
		QA other = (QA) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
