package com.fit.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
*
* @author Marko
*/
@Entity
@Table(name = "USER_DATA")
public class UserData {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_DATA_ID")
	private Long userDataId;

	@NotNull
	@Column(name = "HEIGHT")
	private Long height;

	@NotNull
	@Column(name = "WEIGHT")
	private Long weight;

	@NotNull
	@Column(name = "AGE")
	private Long age;

	@NotNull
	@Column(name = "GENDER")
	//@Enumerated(EnumType.STRING)
	private Gender gender;

	@NotNull
	@Column(name = "ACTIVITY")
	private String activity;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_MEASURED")
	private Date dateMeasured;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_DATA_TO_WORKOUT_ID")
	private Set<Workout> workouts;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "USER_DATA_TO_USER_ID", nullable = false)
	private User user;

	public UserData() {
	}

	public UserData(Long userDataId, @NotNull Long height, @NotNull Long weight, @NotNull Long age,
			@NotNull Gender gender, @NotNull String activity, @NotNull Date dateMeasured, Set<Workout> workouts,
			User user) {
		super();
		this.userDataId = userDataId;
		this.height = height;
		this.weight = weight;
		this.age = age;
		this.gender = gender;
		this.activity = activity;
		this.dateMeasured = dateMeasured;
		this.workouts = workouts;
		this.user = user;
	}

	public Long getUserDataId() {
		return userDataId;
	}

	public void setUserDataId(Long userDataId) {
		this.userDataId = userDataId;
	}

	public Long getHeight() {
		return height;
	}

	public void setHeight(Long height) {
		this.height = height;
	}

	public Long getWeight() {
		return weight;
	}

	public void setWeight(Long weight) {
		this.weight = weight;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public Date getDateMeasured() {
		return dateMeasured;
	}

	public void setDateMeasured(Date dateMeasured) {
		this.dateMeasured = dateMeasured;
	}

	public Set<Workout> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(Set<Workout> workouts) {
		this.workouts = workouts;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

}
