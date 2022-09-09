package main.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;


@MappedSuperclass
@Data
public abstract class AbstractEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name = "created_at",updatable = false)
	@CreationTimestamp
	private  LocalDateTime createdAt;
	
	@Column(name = "updated_at",updatable = true)
	@UpdateTimestamp	
	private LocalDateTime updatedAt;
}
