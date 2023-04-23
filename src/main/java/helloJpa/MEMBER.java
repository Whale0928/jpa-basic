package helloJpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MEMBER {

	@Id
	private Long id;
	private String name;
}
