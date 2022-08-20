package composition;

import animals.Quackable;

import java.util.ArrayList;
import java.util.List;

public class Flock implements Quackable {
    private List<Quackable> quackers;

    public Flock() {
        quackers = new ArrayList<>();//ArrayList ที่เก็บ Quackable
    }

    public void add(Quackable quacker) {
        quackers.add(quacker);//เพิ่มQuackableเข้าฝูง
    }
    @Override
    public void quack() { //วนloopให้เป็ดทุกตัวquack
        for (Quackable duck : quackers)
            duck.quack();//ให้แต่ละตัว quack

        // แบบในหนังสือเป็นแบบเก่า ใช้ Iterator pattern
//        Iterator iterator = quackers.iterator();
//        while (iterator.hasNext()) {
//            Quackable quacker = (Quackable)iterator.next();
//            quacker.quack();
//        }
    }
}
