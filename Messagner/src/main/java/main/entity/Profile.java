package main.entity;

import java.time.LocalDate;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import main.enums.Gender;

@Entity
@Table(name="profile")
@Data
@EqualsAndHashCode(callSuper = false)
@Access(AccessType.FIELD)
public class Profile extends AbstractEntity {

	@Column(name = "first_name",nullable = true)
	private String firstName;
	
	@Column(name="last_name",nullable = true)
	private String lastName;
	
	@Enumerated(EnumType.STRING)
	@Column(name="gender",nullable = true)
	private Gender gender;
	
	@Column(name="birth_date",nullable = true)
	private LocalDate birthDate;
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Access(AccessType.PROPERTY)
	@Override
	public Long getId() {
		return id;
	}

}
