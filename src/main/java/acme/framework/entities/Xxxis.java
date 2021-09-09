  
package acme.framework.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import acme.framework.datatypes.Money;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Xxxis extends DomainEntity {

	protected static final long	serialVersionUID	= 1L;
	
	//Pattern: dd/mm/yyyy
	@NotBlank
	@Pattern(regexp = "^\\d{2}[-](0[1-9]|[12][0-9]|3[01])(0[1-9]|1[012])\\d{2}")
	protected String xxx1;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	protected Date	xxx2;
	
	@Valid
	@NotNull
	protected Money xxx3;
	
	@NotNull
	protected Boolean xxx4;
}