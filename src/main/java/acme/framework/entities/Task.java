package acme.framework.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;



@Entity

@Getter
@Setter
public class Task extends DomainEntity {
	
	//Serialisation identifier 
	 protected static final long serialVersionUID = 1L;
	 
	 //Attributes
	 
	 @NotNull
	 @NotEmpty
	 @Size(max=79)
	 protected String 	title;
	 
	 @NotNull
	 @Temporal(TemporalType.TIMESTAMP)
	 protected Date		start;
	 
	 @NotNull
	 @Temporal(TemporalType.TIMESTAMP)
	 protected Date		end;
	 
	 @NotNull
	 protected Double	workload;
	 
	 @NotEmpty
	 @Size(max=499)
	 protected String 	description;
	 
	 @NotNull
	 protected Boolean 	privacy;
	 
	 protected Manager manager;
	 

}
