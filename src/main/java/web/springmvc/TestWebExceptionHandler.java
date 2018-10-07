package web.springmvc;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import web.util.NotFoundException;

/**
 * @author puck
 * @Description
 * @ControllerAdvice 注解本身已经使用了@Component，因
 *  此@ControllerAdvice注解所标注的类将会自动被组件扫描获取
 *  到，就像带有@Component注解的类一样。
 * 现在，如果任意的控制器方法抛出了
 *   NotFoundException，不管这个方法位于哪个控制器
 *   中，都会调用这个notFoundHandler()方法来处理异
 *  常。我们可以像编写@RequestMapping注解的方法那样来编写
 *   @ExceptionHandler 注解的方法。如程序所示，它返
 *   回“error/duplicate”作为逻辑视图名，因此将会为用户展现一个友好的
 *   出错页面。
 * @Date 2018/10/7
 */
@ControllerAdvice
public class TestWebExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public String notFoundHandler(){
        return "error/404";
    }
}
