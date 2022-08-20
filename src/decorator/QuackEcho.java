package decorator;

import animals.Quackable;

public class QuackEcho implements Quackable {
    private Quackable duck;

    public QuackEcho(Quackable duck) {
        this.duck = duck;
    }

    @Override
    public void quack() {
//        System.out.println("1");
        duck.quack();
//        System.out.println("2");
        System.out.print("Echo :");
//        System.out.println("3");
        duck.quack();//Echo
    }
}
