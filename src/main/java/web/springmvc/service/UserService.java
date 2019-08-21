package web.springmvc.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import web.dao.mapper.UserMapper;
import web.domain.User;

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

	public void test(User e, List<String> strings){
		e.getDetailList().forEach(System.out::println);

		strings.forEach(System.out::println);
	}

}
