package web.springmvc.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import web.aop.LocalRetry;
import web.dao.mapper.UserMapper;
import web.domain.User;
import web.util.BusinessException;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lwz
 * @Description
 * @Date: 15:13 2019-08-21
 */
@Service
@Slf4j
public class UserService {

	@Resource
	UserMapper userMapper;

	@LocalRetry(argsClassName = {"web.domain.User", "java.util.List"}, maxRetry = 3)
	public User test(User e, List<User> list){
		e.getDetailList().forEach(System.out::println);
		list.forEach(System.out::println);
		try {
			int a = 3/0;
		} catch (Exception ex) {
			throw new BusinessException("exxx test:" + ex.getMessage());
		}
		return e;
	}

}
