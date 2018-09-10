package com.fit.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
*
* @author Marko
*/
@Entity
@Table(name = "WORKOUT")
public class Workout implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // bilo je identity
	@Column(name = "WORKOUT_ID")
	private Long workoutId;

	@NotNull
	@Column(name = "DESCRIPTION")
	private String description;

	@NotNull
	@Column(name = "DURATION")
	private Long duration;
	
	@NotNull
	@Column(name = "PROGRAM")
	//@Enumerated(EnumType.STRING)
	private Program program;   

	@NotNull
	@Column(name = "WORKOUT_DATE")
	private String workoutDate;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_CREATED")
	private Date dateCreated;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_TO_WORKOUT_ID")
	private User user;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_DATA_TO_WORKOUT_ID")
	private UserData userData;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "TRAINER_TO_WORKOUT_ID")
	private Trainer trainer;

	public Workout() {
	}

	public Workout(Long workoutId, @NotNull String description, @NotNull Long duration, @NotNull String workoutDate,
			@NotNull Date dateCreated,Program program, User user, UserData userData, Trainer trainer) {
		super();
		this.workoutId = workoutId;
		this.description = description;
		this.duration = duration;
		this.workoutDate = workoutDate;
		this.dateCreated = dateCreated;
		this.program=program;
		this.user = user;
		this.userData = userData;
		this.trainer = trainer;
	}

	public Long getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(Long workoutId) {
		this.workoutId = workoutId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public String getWorkoutDate() {
		return workoutDate;
	}

	public void setWorkoutDate(String workoutDate) {
		this.workoutDate = workoutDate;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserData getUserData() {
		return userData;
	}

	public void setUserData(UserData userData) {
		this.userData = userData;
	}

	


	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}
    
	
}
