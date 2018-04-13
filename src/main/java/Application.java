import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * replace web.xml
 * @author puck
 * @Description
 * @Date 2018/3/1
 */
public class Application extends AbstractAnnotationConfigDispatcherServletInitializer{
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}


/**
 <jsp-config>
 <jsp-property-group>
 <description>HTML Encoding</description>
 <display-name>HTML Encoding Config</display-name>
 <url-pattern>*.jsp</url-pattern>  <!-- 设定值所影响的范围，如：/CH2 或 /*.jsp -->
 <url-pattern>*.html</url-pattern>
 <el-ignored>false</el-ignored>   <!-- 若为true，表示不支持EL语法 -->
 <page-encoding>UTF-8</page-encoding>
 <scripting-invalid>false</scripting-invalid>  <!-- 若为true，表示不支持<% scripting %>语法 -->
 </jsp-property-group>
 </jsp-config>
 */