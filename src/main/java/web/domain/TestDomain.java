package web.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestDomain extends BaseDomain{

	private String name;
	private String desc;



}
