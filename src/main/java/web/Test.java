package web;

import com.alibaba.fastjson.JSONObject;
import web.domain.TestDomain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

public class Test {

	public static void main(String[] arg){
		String arrStr = "32,343,54";
		String[] arr = arrStr.split(",");
		Optional<String> erpStoreId = Arrays.stream(arr).filter(e -> e.equals("2")).findFirst();
		System.out.println(erpStoreId == null);
		System.out.println(erpStoreId.orElse("1"));
		System.out.println(erpStoreId.get());

	}
}
