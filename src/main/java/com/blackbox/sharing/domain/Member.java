package com.blackbox.sharing.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Member extends Person implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8600626344669680694L;

	private Float rating;

    private byte[] photo;

    @JsonBackReference
    @ManyToMany
    @JoinTable(name = "MEMBER_ROLE",
        joinColumns = @JoinColumn(name = "member_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    public List<Role> roles = new ArrayList<Role> ();

    @JsonManagedReference
    @ManyToMany(mappedBy="learners")
    public List<Course> courses = new ArrayList<Course> ();

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
	 * @param role
	 */
	public Member(Integer id, String name, String email, Float rating, byte[] photo, List<Role> role) {
		super(id, name, email);
		this.rating = rating;
		this.photo = photo;
		this.roles = role;
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
	 * @return the roles
	 */
	public List<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	/**
	 * @return the assignedCourses
	 */
	public List<Course> getAssignedCourses() {
		return courses;
	}

	/**
	 * @param assignedCourses the assignedCourses to set
	 */
	public void setAssignedCourses(List<Course> assignedCourses) {
		this.courses = assignedCourses;
	}
}