package web.springmvc.controller;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import web.aop.ExceptionPointCut;
import web.base.BaseC;
import web.dao.mapper.UserMapper;
import web.domain.HttpResult;
import web.domain.User;
import web.springmvc.service.UserService;
import web.util.BusinessException;
import web.util.LogHelper;
import web.util.SpringBeanContextUtil;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/test")
public class TestC extends BaseC
{
	private static final Logger logger = LogHelper.Test;
	@Resource
	UserService userService;
	@Autowired
	UserMapper userMapper;
	public final static Class[] argsType = new Class[]{Model.class};

	@RequestMapping
	@ResponseBody
//	@LocalRetry(beanName = "testC", argsClassName = {"org.springframework.ui.Model", "java.lang.String", "java.lang.String"}, maxRetry = 2)
	public HttpResult test(Model view, String exDesc, String name){
		exDesc = "测试异常！";
		logger.info("test()in...................");
		UserMapper mapper = SpringBeanContextUtil.get("userMapper");
		User user = mapper.selectById(3);
		userService.test(user, Lists.newArrayList(user));
		try {
			int a = 3/0;
		} catch (Exception e) {
			throw new BusinessException("exxx test:" + e.getMessage());
		}
		return HttpResult.success(user);
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
		return HttpResult.success();
	}

	@RequestMapping("/b")
	@ResponseBody
	public HttpResult test(){
		return HttpResult.success();
	}
}
 