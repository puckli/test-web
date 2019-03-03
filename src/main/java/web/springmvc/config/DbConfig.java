package web.springmvc.config;

import org.springframework.jndi.JndiObjectFactoryBean;

/**
 * @author puck
 * @Description
 * @Date 2018/10/20
 */
public class DbConfig {

    public JndiObjectFactoryBean dataSource(){
        JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
        bean.setJndiName("jdbc/testWebDS");
        bean.setResourceRef(true);
        bean.setProxyInterface(javax.sql.DataSource.class);
        return bean;
    }
}
