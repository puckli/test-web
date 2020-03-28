package web.exercise.strategy;

import org.springframework.stereotype.Component;

/**
 * @author lwz
 * @description
 * @time 2020/3/28 21:29
 */
@Component
public class StrategyAImpl extends AbstractClass {

    @Override
    public void start() {
        System.out.println("a impl start");
        doFirst();
        doEnd();
    }

    @Override
    public void doEnd() {
        System.out.println("a impl doEnd");
    }
}
