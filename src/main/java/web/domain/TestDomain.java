package web.domain;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TestDomain extends BaseDomain{

	private String name;
	private String desc;

	private BigDecimal bigDecimal;

}
