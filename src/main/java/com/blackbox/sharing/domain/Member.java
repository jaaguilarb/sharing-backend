package com.blackbox.sharing.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Member extends Person implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8600626344669680694L;

	private Float rating;

    private byte[] photo;

    @ManyToMany
	@JoinTable(name="Member_Role",
		joinColumns = @JoinColumn(name = "member_id"),
		inverseJoinColumns = @JoinColumn(name = "role_id"))
    public List<Role> assignedRole = new ArrayList<Role> ();

    @ManyToMany
	@JoinTable(name="Member_Course",
		joinColumns = @JoinColumn(name = "member_id"),
		inverseJoinColumns = @JoinColumn(name = "course_id")
	)
    public List<Course> assignedCourses = new ArrayList<Course> ();

    /**
	 * 
	 */
	public Member() {
	}

	/**
	 * @param rating
	 * @param photo
	 * @param roles
	 */
	public Member(Float rating, byte[] photo) {
		this.rating = rating;
		this.photo = photo;
	}

	/**
	 * @param name
	 * @param email
	 * @param id
	 * @param rating
	 * @param photo
	 * @param assignedRole
	 */
	public Member(Integer id, String name, String email, Float rating, byte[] photo, List<Role> assignedRole) {
		super(id, name, email);
		this.rating = rating;
		this.photo = photo;
		this.assignedRole = assignedRole;
	}

	Float getRating() {
        return this.rating;
    }

    void setRating(Float value) {
        this.rating = value;
    }

    byte[] getPhoto() {
        return this.photo;
    }

    void setPhoto(byte[] value) {
        this.photo = value;
    }

	/**
	 * @return the assignedRole
	 */
	public List<Role> getAssignedRole() {
		return assignedRole;
	}

	/**
	 * @param assignedRole the assignedRole to set
	 */
	public void setAssignedRole(List<Role> assignedRole) {
		this.assignedRole = assignedRole;
	}

	/**
	 * @return the assignedCourses
	 */
	public List<Course> getAssignedCourses() {
		return assignedCourses;
	}

	/**
	 * @param assignedCourses the assignedCourses to set
	 */
	public void setAssignedCourses(List<Course> assignedCourses) {
		this.assignedCourses = assignedCourses;
	}
}