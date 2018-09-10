package com.fit.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USER")
public class User implements Serializable {

	
	/**
	 *
	 * @author Marko
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Long userId;

	@NotNull
	@Size(min = 6, max = 15)
	@Column(name = "USERNAME")
	private String username;

	@NotNull
	@Size(min = 8, max = 15)
	@Column(name = "PASSWORD")
	private String password;

	@NotNull
	@Column(name = "EMAIL")
	@Email
	private String email;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_TO_ROLE_ID")
	private Set<UserRole> userRoles;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "TRAINER_TO_USER_ID")
	private Trainer trainer;
	
	

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_TO_WORKOUT_ID")
	private Set<Workout> workouts;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	private UserData userData;

	public User() {
	}

	public User(Long userId, @NotNull @Size(min = 6, max = 15) String username,
			@NotNull @Size(min = 8, max = 15) String password, @NotNull @Email String email, Set<UserRole> userRoles,
			 Set<Workout> workouts, UserData userData,Trainer trainer) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.userRoles = userRoles;
		this.trainer=trainer;
		this.workouts = workouts;
		this.userData = userData;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

    

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public Set<Workout> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(Set<Workout> workouts) {
		this.workouts = workouts;
	}

	public UserData getUserData() {
		return userData;
	}

	public void setUserData(UserData userData) {
		this.userData = userData;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
