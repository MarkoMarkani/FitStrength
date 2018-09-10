package com.fit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fit.model.User;

/**
*
* @author Marko
*/
@Entity
@Table(name="USER_ROLES")
public class UserRole implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(name="USER_ROLE_ID")
	private Long userRoleId;
	
	@Column(name="ROLE")
	private String role;
    
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_TO_ROLE_ID")
	private User user;
    
	


	public UserRole() {
		
	}

	public UserRole(String role, User user) {
		
		this.role = role;
		this.user = user;
	}

	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
