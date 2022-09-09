package main.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Embeddable
public class CreationEntity {

	@Column(name = "created_at",updatable = false)
	@CreationTimestamp
	protected  LocalDateTime createdAt;
	
	@Column(name = "updated_at",updatable = true)
	@UpdateTimestamp	
	protected LocalDateTime updatedAt;
}
