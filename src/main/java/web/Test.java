package web;

import com.alibaba.fastjson.JSONObject;
import web.domain.TestDomain;

import java.math.BigDecimal;

public class Test {

	public static void main(String[] arg){
		TestDomain td = TestDomain.builder().name("aaa").bigDecimal(new BigDecimal(3.22D)).build();
		td.setYn(1);
		System.out.println(td);
		System.out.println(JSONObject.toJSONString(td));

	}
}
