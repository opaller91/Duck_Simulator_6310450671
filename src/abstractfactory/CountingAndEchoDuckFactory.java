package abstractfactory;

import animals.*;
import decorator.QuackCounter;
import decorator.QuackEcho;

public class CountingAndEchoDuckFactory extends AbstractDuckFactory {//แบบที่ใช้ได้ทั้ง counter และ echo decorator
    @Override
    public Quackable createMallardDuck() {
        return new QuackEcho(new QuackCounter(new MallardDuck()));
    }

    @Override
    public Quackable createRedheadDuck() {
        return new QuackEcho(new QuackCounter(new RedheadDuck()));
    }

    @Override
    public Quackable createDuckCall() {
        return new QuackEcho(new QuackCounter(new DuckCall()));
    }

    @Override
    public Quackable createRubberDuck() {
        return new QuackEcho(new QuackCounter(new RubberDuck()));
    }
}
