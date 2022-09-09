package main.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractEntity  extends CreationEntity{

	@Setter
	protected Long id;
	
	public abstract Long getId();
}
