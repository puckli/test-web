package test.web;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import web.dao.mapper.UserMapper;
import web.domain.User;
import web.domain.enums.StatusEnum;
import web.exercise.strategy.WorkerService;
import web.springmvc.service.SpringContextService;
import web.springmvc.service.UserService;
import web.util.SerializeUtil;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lwz
 * @Description
 * @Date: 20:29 2019-03-19
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-config.xml"})
@Transactional
public class StategyTest {

	@Resource
	UserMapper userMapper;
	@Resource
	UserService userService;
	@Resource
	SpringContextService springContextService;
	@Autowired
	Environment evn;
	@Resource
	WorkerService workerService;

	@Test
	public void test() throws Exception{
		System.out.println(("----- method test ------"));

		workerService.doAction("strategyAImpl");

		workerService.doAction("strategyBImpl");


		System.out.println(JSONObject.toJSONString(evn.getActiveProfiles()));
		System.out.println(JSONObject.toJSONString(evn.getDefaultProfiles()));
		System.out.println(evn.getProperty("dmall.dmc.projectCode"));
		System.out.println(evn.getProperty("amp.serverAddress"));
		Assert.assertEquals(true, 1 == 1);

	}
}
