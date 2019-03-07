package web.domain;

import lombok.Data;

/**
 * @author lwz
 * @Description
 * @Date: 11:26 2019-03-07
 */
@Data
public class User extends BaseDomain {

	private String name;
	private String password;
	private Long creator;
}
