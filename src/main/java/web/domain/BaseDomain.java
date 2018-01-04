package web.domain;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BaseDomain {

	private Long id;
	private Date created;
	private Date updated;
	private Integer yn;

}
