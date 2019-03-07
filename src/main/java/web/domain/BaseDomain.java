package web.domain;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class BaseDomain implements Serializable{

	private Long id;
	private Date created;
	private Date updated;
	private Date modified;
	private Integer yn;

}
