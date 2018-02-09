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
	public Member(Float rating, byte[] photo, List<Role> roles) {
		this.rating = rating;
		this.photo = photo;
		this.assignedRole = roles;
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
}