package web.springmvc.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import web.aop.ExceptionPointCut;
import web.base.BaseC;
import web.dao.mapper.UserMapper;
import web.domain.HttpResult;
import web.domain.User;
import web.util.BusinessException;
import web.util.LogHelper;

@Controller
@RequestMapping(value = "/test")
public class TestC extends BaseC
{
	private static final Logger logger = LogHelper.Test;
//	@Value(value = "${domain.name}")
//	private String job;
	private HttpResult result = HttpResult.fail("操作异常");
	@Autowired
	UserMapper userMapper;
	
	@RequestMapping
	@ResponseBody
	@ExceptionPointCut
	public HttpResult test(Model view, String exDesc, String name){
		exDesc = "测试异常！";
		logger.info("test()in..");
		System.out.println(".................");

		User user = userMapper.selectById(3);
		result.setData(user);
		try {
			int a = 3/0;
		} catch (Exception e) {
//			e.printStackTrace();
//			throw new BusinessException("buss");
		}
		return result;
	}

	@RequestMapping("/a")
	@ResponseBody
	@ExceptionPointCut
	public HttpResult testh(String exDesc){
		exDesc = "测试异常！";
		System.out.println("........testh.........");
		try {
			int a = 3/0;
		} catch (Exception e) {
			throw new BusinessException("buss testh");
		}
		return result;
	}

	@RequestMapping("/b")
	@ResponseBody
	public HttpResult test(){
		return result;
	}
}
 