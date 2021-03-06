import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

/**
 * @author puck
 * @Description
 * @Date 2018/3/2
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "web")
//@MapperScan("web.dao.mapper")
//@EnableAspectJAutoProxy
public class WebConfig extends WebMvcConfigurerAdapter{

//    @Bean
//    public ViewResolver viewResolver(){
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/");
//        resolver.setSuffix(".jsp");
//        resolver.setExposeContextBeansAsAttributes(true);
//        return resolver;
//    }

    /**
     * <!-- 配置freeMarker的模板路径 -->
     * @return
     */
//    @Bean
//    public ViewResolver viewResolver(){
//        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
//        resolver.setPrefix("/WEB-INF/ftl/");
//        resolver.setSuffix(".ftl");
//        resolver.setCache(true);
//        resolver.setExposeContextBeansAsAttributes(true);
//        return resolver;
//    }

//    @Bean
//    public FreeMarkerConfigurer freeMarkerConfigurer(){
//        FreeMarkerConfigurer fkconf = new FreeMarkerConfigurer();
//        fkconf.setTemplateLoaderPath("/WEB-INF/ftl/");
//        fkconf.setDefaultEncoding("UTF-8");
//        return fkconf;
//    }

//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }
}
