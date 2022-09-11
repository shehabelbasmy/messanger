package main.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import main.enums.Role;

@Entity
@Table(name="`person`")
@Data
@EqualsAndHashCode(callSuper = false)
public class Person extends AbstractEntity {

	@Column(name="password",nullable = false)
	private String password;
	
	@Column(name="email",nullable = false,unique = true)
	private String email;
	
	@OneToOne(mappedBy = "person",fetch = FetchType.LAZY
			,cascade = CascadeType.ALL)
	private Profile profile;
	
	@Enumerated(EnumType.STRING)
	@Column(name="role")
	private Role role;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name="person-chat",joinColumns = @JoinColumn(name="person_id"),inverseJoinColumns = @JoinColumn(name="chat_id"))
	@ToString.Exclude
	private Set<Chat> chats;


}
