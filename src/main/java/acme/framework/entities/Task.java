package acme.framework.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
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
	 @Positive
	 protected Double	workload;
	 
	 @NotEmpty
	 @Size(max=499)
	 protected String 	description;
	 
	 @NotNull
	 protected Boolean 	privacy;
	 
	 @NotNull
	 protected Integer idmanager;
	 
	 //Derived Attributes
	 
	 public Double getExecutionPeriod() {
		 Double res = null;
		 
		 final Date eStart = this.start;
		 final Date eEnd = this.end;
		 
		 final int days = eEnd.getDay() - eStart.getDay();
		 final int hours = (eEnd.getHours() - eStart.getHours()) + (days * 24);
		 int minutes = eEnd.getMinutes() - eStart.getMinutes();
		 if(minutes<0) {
			 minutes = 60 + minutes;
		 }
		 if(minutes<10) {
			 res = Double.valueOf(hours + ".0" + minutes);
		 } else {
			 res = Double.valueOf(hours + "." + minutes);
		 }
		 return res;
	 }
}
