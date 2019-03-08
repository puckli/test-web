package web.dao;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author lwz
 * @Description
 * @Date: 17:49 2019-03-07
 */
@Configuration
public class DaoConfig {

//	@Autowired
//	private DataSourceProperties dataSourceProperties;

//	public MybatisSqlSessionFactoryBean sessionFactory(){
//		MybatisSqlSessionFactoryBean sessionFactory = new MybatisSqlSessionFactoryBean();
//		sessionFactory.setDataSource(dataSource);
//		return sessionFactory;
//	}


//	@Bean(name = "dataSource", initMethod = "init")
//	@Primary
//	@ConfigurationProperties(prefix = "spring.datasource")
//	public DruidDataSource datasource() throws SQLException {
//		DataSource dataSource = DataSourceBuilder.create().type(DruidDataSource.class).build();
//
//		return (DruidDataSource) dataSource;
//	}

//	@Bean(name = "dataSource")
//	public DataSource dataSource() {
//
//		DruidDataSource dataSource = new DruidDataSource();
//		dataSource.setUrl(dataSourceProperties.getUrl());
//		System.out.println(dataSourceProperties.getUrl());
//		dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
//		dataSource.setUsername(dataSourceProperties.getUsername());
//		dataSource.setPassword(dataSourceProperties.getPassword());
//
//		return dataSource;
//
//	}

//	public SqlSessionFactory sqlSessionFactory() throws Exception {
//		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//		sqlSessionFactoryBean.setDataSource(dataSource());
//		return sqlSessionFactoryBean.getObject();
//	}
}
