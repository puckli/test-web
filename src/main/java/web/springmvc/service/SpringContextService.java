package web.springmvc.service;

import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Service;

/**
 * @author lwz
 * @Description 获取bean 工具
 * @Date: 16:34 2019-08-21
 */
@Service
public class SpringContextService extends ApplicationObjectSupport {

	public <T> T get(String beanName)
	{
		return (T) getApplicationContext().getBean(beanName);
	}

}
