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

    @JsonManagedReference
    @ManyToMany
    @JoinTable(name = "MEMBER_ROLE",
        joinColumns = @JoinColumn(name = "member_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    public List<Role> roles = new ArrayList<Role> ();

    @JsonBackReference
    @ManyToMany(mappedBy="members")
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
	 * @param assignedRole
	 */
	public Member(Integer id, String name, String email, Float rating, byte[] photo, List<Role> assignedRole) {
		super(id, name, email);
		this.rating = rating;
		this.photo = photo;
		this.roles = assignedRole;
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
	 * @return the assignedRoles
	 */
	public List<Role> getAssignedRoles() {
		return roles;
	}

	/**
	 * @param assignedRoles the assignedRoles to set
	 */
	public void setAssignedRoles(List<Role> assignedRoles) {
		this.roles = assignedRoles;
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