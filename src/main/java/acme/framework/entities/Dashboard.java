package acme.framework.entities;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dashboard implements Serializable{
	
	private static final long	serialVersionUID	= 1L;

	Integer						numberOfTasks;
	Integer						numberOfPrivateTasks;
	Integer						numberOfFinishedTasks;
}
