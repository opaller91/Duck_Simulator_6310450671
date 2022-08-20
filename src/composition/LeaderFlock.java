package composition;

import animals.Quackable;

import java.util.ArrayList;
import java.util.List;

public class LeaderFlock implements Quackable {
    private List<Quackable> quackers;

    public LeaderFlock() {

        quackers = new ArrayList<>();//ArrayList ที่เก็บ Quackable
    }

    public void add(Quackable quacker) {
        quackers.add(quacker);//เพิ่มQuackableเข้าฝูง
    }

    @Override
    public void quack() { //วนloopให้เป็ดทุกตัวquack
        int count = 1;
        for (Quackable duck : quackers){
            if (count == 1){
                duck.quack();
                duck.quack();
                duck.quack();

            }
            else {
                duck.quack();
            }
            count++;
        }


    }
}
