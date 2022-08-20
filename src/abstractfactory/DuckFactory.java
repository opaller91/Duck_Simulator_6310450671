package abstractfactory;

import animals.*;

public class DuckFactory extends AbstractDuckFactory {//แบบที่ไม่มี decorator ใดเลย
    public Quackable createMallardDuck() {
        return new MallardDuck();
    }

    public Quackable createRedheadDuck() {
        return new RedheadDuck();
    }

    public Quackable createDuckCall() {
        return new DuckCall();
    }

    public Quackable createRubberDuck() {
        return new RubberDuck();
    }

}
