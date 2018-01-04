package web;

import web.domain.TestDomain;

public class Test {

	public static void main(String[] arg){
		TestDomain td = TestDomain.builder().name("aaa").build();
		td.setYn(1);
		System.out.println(td);

	}
}
