package web.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lwz
 * @Description  detail for test
 * @Date: 16:02 2019-08-21
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Detail implements Serializable{

	private Long id;

}
