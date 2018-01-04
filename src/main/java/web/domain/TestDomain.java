package web.domain;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TestDomain extends BaseDomain{

	private String name;
	private String desc;

}
