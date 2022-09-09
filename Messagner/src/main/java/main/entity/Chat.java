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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import main.enums.ChatType;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="chat")
public class Chat extends AbstractEntity {

	@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name = "user-chat",
			joinColumns = @JoinColumn(name="chat_id"),
			inverseJoinColumns = @JoinColumn(name="user_id"))
	private Set<User> receivers;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "chat")
	@ToString.Exclude
	private Set<Message> messages;
	
	@Column(name = "name")
	private String name;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type",nullable = false)
	private ChatType type;


}
