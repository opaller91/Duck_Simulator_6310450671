package decorator;

import animals.Quackable;

import java.util.ArrayList;

public class QuackCounter implements Quackable {
    private Quackable duck;

    private static int numberOfQuacks;


    public QuackCounter(Quackable duck) {
        this.duck = duck;
    }

    @Override
    public void quack() {
//        System.out.println("4");
        duck.quack();
//        System.out.println("5");
        numberOfQuacks++;//ส่วนที่เพิ่ม behavier เข้ามา
//        System.out.println("6");
        System.out.println("This quack is counted !!!");
    }

    public static int getQuacks() {
        return numberOfQuacks;
    }

    public static void resetNumberOfQuacks(int numberOfQuacks) {
        QuackCounter.numberOfQuacks = numberOfQuacks;
    }

}
