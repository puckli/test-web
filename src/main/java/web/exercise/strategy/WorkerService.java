package web.exercise.strategy;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lwz
 * @description 策略模式
 * @time 2020/3/28 21:30
 */
@Component
public class WorkerService {

    /**
     * 自动注入
     * key：beanName
     */
    @Resource
    private Map<String, AbstractClass> stgMap;

    /**
     * 流程执行
     * @param strType beanName
     */
    public void doAction(String strType) {
        this.stgMap.get(strType).start();
    }
}
