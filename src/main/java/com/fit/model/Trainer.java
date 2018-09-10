package com.fit.model;

import java.io.Serializable;

/**
*
* @author Marko
*/
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TRAINER")
public class Trainer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRAINER_ID")
	private Long trainerId;

	@NotNull
	@Column(name = "NAME")
	private String name;
	@NotNull
	@Column(name = "PRICE")
	private Long price;

	@NotNull
	@Column(name = "PROGRAM")
	//@Enumerated(EnumType.STRING)
	private Program program;   

	@NotNull
	@Column(name = "LEVEL")
	private String level;



	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "TRAINER_TO_WORKOUT_ID")
	private List<Workout>workouts;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "TRAINER_TO_USER_ID")
	private Set<User>users;
	

	public Trainer() {
		
	}

	public Trainer(Long trainerId, @NotNull String name, @NotNull Long price,Program program,
			@NotNull String level,List<Workout> workouts,Set<User>users) {
		super();
		this.trainerId = trainerId;
		this.name = name;
		this.price = price;
		this.level = level;
		this.program=program;
		this.users=users;
		this.workouts = workouts;
	}

	public Long getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Long trainerId) {
		this.trainerId = trainerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}
	
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
    


	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public List<Workout> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(List<Workout> workouts) {
		this.workouts = workouts;
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
