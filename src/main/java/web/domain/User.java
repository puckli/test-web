package web.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author lwz
 * @Description
 * @Date: 11:26 2019-03-07
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseDomain {

	private Long id;
	private String name;
	private String password;
	private Long creator;

	@TableField(exist = false)
	private List<Detail> detailList;
}
