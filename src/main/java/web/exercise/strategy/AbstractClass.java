package web.exercise.strategy;

import org.springframework.stereotype.Component;

/**
 * @author lwz
 * @description
 * @time 2020/3/28 21:27
 */
@Component
public abstract  class AbstractClass {

    public abstract void start();

    public void doFirst(){
        System.out.println("super doFirst");
    }

    public void doSecond(){
        System.out.println("super doSecond");
    }

    public abstract void doEnd();
}
