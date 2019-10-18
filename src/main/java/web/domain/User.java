package web.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;

import java.util.List;

/**
 * @author lwz
 * @Description
 * @Date: 11:26 2019-03-07
 */
@Getter
@Setter
public class User extends BaseDomain {

	private Long id;
	private String name;
	private String password;
	private Long creator;

	@TableField(exist = false)
	private List<Detail> detailList;
}
