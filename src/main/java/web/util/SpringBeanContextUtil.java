package web.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 获取bean工具
 *
 * @author lwz
 * @date 2019-08-21
 **/
@Component
public class SpringBeanContextUtil implements ApplicationContextAware {


    protected static ApplicationContext context;

    public static ApplicationContext getContext() {
        return context;
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(String name) {
        return (T) context.getBean(name);
    }

    public static <T> T get(Class<T> tClass) {
        return context.getBean(tClass);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

}
