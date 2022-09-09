package main.entity;

import java.util.List;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import main.enums.Role;

@Entity
@Table(name="`user`")
@Data
@EqualsAndHashCode(callSuper = false)
@Access(AccessType.FIELD)
public class User extends AbstractEntity {

	@Column(name="password",nullable = false)
	private String password;
	
	@Column(name="email",nullable = false,unique = true)
	private String email;
	
	@OneToOne(mappedBy = "user",fetch = FetchType.LAZY
			,cascade = CascadeType.ALL)
	private Profile profile;
	
	@Enumerated(EnumType.STRING)
	@Column(name="role")
	private Role role;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name="user_chat",joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="chat_is"))
	private List<Chat> chats;
	
	@Override
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="id")
	@Access(AccessType.PROPERTY)
	public Long getId() {
		return id;
	}

}
