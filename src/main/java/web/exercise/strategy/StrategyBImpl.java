package web.exercise.strategy;

import org.springframework.stereotype.Component;

/**
 * @author lwz
 * @description
 * @time 2020/3/28 21:29
 */
@Component
public class StrategyBImpl extends AbstractClass {
    
    @Override
    public void start() {
        System.out.println("b impl start");
        doFirst();
        doSecond();
        doEnd();
    }

    @Override
    public void doSecond() {
        super.doSecond();
        System.out.println("b impl doSecond");
    }

    @Override
    public void doEnd() {
        System.out.println("b impl doEnd");
    }
}
