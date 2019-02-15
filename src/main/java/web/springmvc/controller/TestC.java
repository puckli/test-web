package web.springmvc.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import web.aop.NeedExceptionHandle;
import web.util.BusinessException;
import web.util.LogHelper;

@Controller
@RequestMapping(value = "/test")
public class TestC
{
	private static final Logger logger = LogHelper.Test;
	@Value(value = "${domain.name}")
	private String job;
	
	@RequestMapping
	@ResponseBody
	@NeedExceptionHandle
	public String test(Model view){
		logger.info("test()in..");
		System.out.println(".................");
		int a = 3/0;
		return job;
	}
}
 