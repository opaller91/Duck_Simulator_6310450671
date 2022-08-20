import abstractfactory.AbstractDuckFactory;
import abstractfactory.CountingAndEchoDuckFactory;
import abstractfactory.CountingDuckFactory;
import abstractfactory.DuckFactory;
import adaptor.GooseAdapter;
import adaptor.PigeonAdaptor;
import animals.*;
import composition.Flock;
import composition.LeaderFlock;
import decorator.QuackCounter;
import decorator.QuackEcho;

public class DuckSimulator {
    public static void main(String[] args){
        DuckSimulator simulator = new DuckSimulator();
        simulator.simulate();

        //Abstract Factory
        //simulator.simulate(new DuckCall());//ขึ้นอยู่ว่าเราอยากได้factoryแบบไหน อันนี้แบบปกติ
        //จะใช้การเรียกใช้แบบบนหรือแบบล่างก็ได้
        AbstractDuckFactory duckFactory = new DuckFactory();//เลือกแบบที่ไม่มี decorator ใดเลย
        AbstractDuckFactory duckCountingFactory = new CountingDuckFactory();//เลือกแบบที่มี counter decorator
        AbstractDuckFactory duckCountingAndEchoFactory = new CountingAndEchoDuckFactory();//เลือกแบบที่ใช้ได้ทั้ง counter และ echo decorator

        simulator.simulateDuckFactorySimulate(duckFactory);//เรียก simulate
        simulator.simulateDuckCountingFactory(duckCountingFactory);
        simulator.simulateDuckCountingAndEchoFactory(duckCountingAndEchoFactory);

        //composite
        simulator.simulateCompositeNoLeader(duckFactory);
        simulator.simulateCompositesLeader(duckFactory);
    }

    void simulate() {
        //Adaptor
        Quackable mallardDuck = new MallardDuck();
        Quackable redHeadDuck = new RedheadDuck();
        Quackable duckCall = new DuckCall();
        Quackable rubberDuck = new RubberDuck();
        //Goose goose = new Goose(); วิธี1 ของรูปแบบ2ในสไลด์ (แบบinterface)
        Quackable goose = new GooseAdapter(new Goose());//wraping วิธีที่2 ของรูปแบบ2ในสไลด์ (แบบinterface)
        Quackable pigeon = new PigeonAdaptor(new Pigeon());

        System.out.println("\nDuck Simulator");

        System.out.println("\nDuck Simulator (Adaptor)");
        simulate(mallardDuck);
        simulate(redHeadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        //simulate(new GooseAdaptor(goose)); วิธี1
        simulate(goose);//wraping วิธี2
        simulate(pigeon);
        System.out.println("------------------------------------------------------------------------------------------");

        //Decorator นับแต่เป็ดเลยมีแค่ 4 ครั้ง
        //QuackCounter
        Quackable mallardDuckCount = new QuackCounter(new MallardDuck());
        Quackable redHeadDuckCount = new QuackCounter(new RedheadDuck());
        Quackable duckCallCount = new QuackCounter(new DuckCall());
        Quackable rubberDuckCount = new QuackCounter(new RubberDuck());
        //Goose gooseCount = new Goose(); วิธี1 ของรูปแบบ2ในสไลด์ (แบบinterface)
        Quackable gooseCount = new GooseAdapter(new Goose());//wraping วิธีที่2 ของรูปแบบ2ในสไลด์ (แบบinterface)
        Quackable pigeonCount = new PigeonAdaptor(new Pigeon());

        System.out.println("\nDuck Simulator (Decorator)");

        System.out.println("\nDecorator : QuackCounter");
        simulate(mallardDuckCount);
        simulate(redHeadDuckCount);
        simulate(duckCallCount);
        simulate(rubberDuckCount);
        //simulate(new GooseAdaptor(gooseCount)); วิธี1
        simulate(gooseCount);//wraping วิธี2
        simulate(pigeonCount);
        System.out.println("The duck quacked " + QuackCounter.getQuacks() + " times");//นับแต่เป็ดเลยมีแค่ 4 ครั้ง

        //QuackEcho จะEchoแค่เป็ด
        Quackable mallardDuckEcho = new QuackEcho(new MallardDuck());
        Quackable redHeadDuckEcho = new QuackEcho(new RedheadDuck());
        Quackable duckCallEcho = new QuackEcho(new DuckCall());
        Quackable rubberDuckEcho = new QuackEcho(new RubberDuck());
        //Goose gooseEcho = new Goose(); วิธี1 ของรูปแบบ2ในสไลด์ (แบบinterface)
        Quackable gooseEcho = new GooseAdapter(new Goose());//wraping วิธีที่2 ของรูปแบบ2ในสไลด์ (แบบinterface)
        Quackable pigeonEcho = new PigeonAdaptor(new Pigeon());

        System.out.println("\nDecorator : QuackEcho");//จะEchoแค่เป็ด
        simulate(mallardDuckEcho);
        simulate(redHeadDuckEcho);
        simulate(duckCallEcho);
        simulate(rubberDuckEcho);
        //simulate(new GooseAdaptor(gooseEcho)); วิธี1
        simulate(gooseEcho);//wraping วิธี2
        simulate(pigeonEcho);


        //QuackCounter + QuackEcho
        QuackCounter.resetNumberOfQuacks(0);//reset จำนวน Quack จะได้ไม่งงเวลารัน
        Quackable mallardDuckMix = new QuackEcho(new QuackCounter(new MallardDuck()));//นับทั้งอันปกติและที่Echo
        Quackable redHeadDuckMix = new QuackCounter(new QuackEcho(new RedheadDuck()));//นับแค่อันที่Echo
        Quackable duckCallMix = new QuackEcho(new QuackCounter(new DuckCall()));//นับทั้งอันปกติและที่Echo
        Quackable rubberDuckMix = new QuackEcho(new QuackCounter(new RubberDuck()));//นับทั้งอันปกติและที่Echo
        //Goose gooseMix = new Goose(); วิธี1 ของรูปแบบ2ในสไลด์ (แบบinterface)
        Quackable gooseMix = new GooseAdapter(new Goose());//wraping วิธีที่2 ของรูปแบบ2ในสไลด์ (แบบinterface)
        Quackable pigeonMix = new PigeonAdaptor(new Pigeon());
        //ใน QuackEcho และ QuackCounter ถ้าเอาcomment ใน sytem.out.println ออกจะสามารถดูขั้นตอนexecuteได้

        System.out.println("\nDecorator : MIX");
        simulate(mallardDuckMix);
        simulate(redHeadDuckMix);
        simulate(duckCallMix);
        simulate(rubberDuckMix);
        //simulate(new GooseAdaptor(gooseMix)); วิธี1
        simulate(gooseMix);//wraping วิธี2
        simulate(pigeonMix);
        System.out.println("The duck quacked " + QuackCounter.getQuacks() + " times");//นับquack ได้ 7 ครั้ง
        System.out.println("------------------------------------------------------------------------------------------");

    }

    void simulateDuckFactorySimulate(AbstractDuckFactory duckFactory) {
        //Abstract Factory
        //DuckFactory
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable goose = new GooseAdapter(new Goose());
        Quackable pigeon = new PigeonAdaptor(new Pigeon());

        System.out.println("\nDuck Simulator (Abstract Factory)");
        System.out.println("\nAbstract Factory : DuckFactory");
        QuackCounter.resetNumberOfQuacks(0);//reset จำนวน Quack จะได้ไม่งงเวลารัน
        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(goose);
        simulate(pigeon);
        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");

    }

    void simulateDuckCountingFactory(AbstractDuckFactory duckCountingFactory) {
        //CountingDuckFactory
        Quackable mallardDuckCounting = duckCountingFactory.createMallardDuck();
        Quackable redheadDuckCounting = duckCountingFactory.createRedheadDuck();
        Quackable duckCallCounting = duckCountingFactory.createDuckCall();
        Quackable rubberDuckCounting = duckCountingFactory.createRubberDuck();
        Quackable gooseDuckCounting = new GooseAdapter(new Goose());
        Quackable pigeonEchoCounting = new PigeonAdaptor(new Pigeon());

        System.out.println("\nAbstract Factory : CountingDuckFactory");
        QuackCounter.resetNumberOfQuacks(0);//reset จำนวน Quack จะได้ไม่งงเวลารัน
        simulate(mallardDuckCounting);
        simulate(redheadDuckCounting);
        simulate(duckCallCounting);
        simulate(rubberDuckCounting);
        simulate(gooseDuckCounting);
        simulate(pigeonEchoCounting);
        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");

    }

    void simulateDuckCountingAndEchoFactory(AbstractDuckFactory duckCountingAndEchoFactory) {
        //CountingAndEchoDuckFactory
        Quackable mallardDuckCountingAndEcho = duckCountingAndEchoFactory.createMallardDuck();
        Quackable redheadDuckCountingAndEcho = duckCountingAndEchoFactory.createRedheadDuck();
        Quackable duckCallCountingAndEcho= duckCountingAndEchoFactory.createDuckCall();
        Quackable rubberDuckCountingAndEcho = duckCountingAndEchoFactory.createRubberDuck();
        Quackable gooseDuckCountingAndEcho = new GooseAdapter(new Goose());
        Quackable pigeonEchoCountingAndEcho = new PigeonAdaptor(new Pigeon());

        System.out.println("\nAbstract Factory : CountingDuckFactory");
        QuackCounter.resetNumberOfQuacks(0);//reset จำนวน Quack จะได้ไม่งงเวลารัน
        simulate(mallardDuckCountingAndEcho);
        simulate(redheadDuckCountingAndEcho);
        simulate(duckCallCountingAndEcho);
        simulate(rubberDuckCountingAndEcho);
        simulate(gooseDuckCountingAndEcho);
        simulate(pigeonEchoCountingAndEcho);
        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");
        System.out.println("------------------------------------------------------------------------------------------");

    }

    void simulateCompositeNoLeader(AbstractDuckFactory duckFactory) {
        //Factory
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable goose = new GooseAdapter(new Goose());
        Quackable pigeon = new PigeonAdaptor(new Pigeon());
        //------------------------------------------------------------------------------------------//

        //Composite
        System.out.println("\nDuck Simulator (Composite)");
        System.out.println("\nComposite : Flocks (No leader)");
        Flock flockOfDucks = new Flock();//สร้างฝูง

        flockOfDucks.add(mallardDuck);
        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(goose);
        flockOfDucks.add(pigeon);
        System.out.println("\nDuck Simulator ( Whole Flock Simulation )");
        simulate(flockOfDucks);//simulateแค่อันเดียวเพราะใส่ฝูงแล้ว มันวนloopให้แล้วในFlock

    }

    void simulateCompositesLeader(AbstractDuckFactory duckFactory) {
        //Factory
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable goose = new GooseAdapter(new Goose());
        Quackable pigeon = new PigeonAdaptor(new Pigeon());
        //------------------------------------------------------------------------------------------//

        //Composite
        System.out.println("\nComposite : Flocks (Leader)");
        LeaderFlock flockOfDucks = new LeaderFlock();//สร้างฝูง

        flockOfDucks.add(mallardDuck);
        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(goose);
        flockOfDucks.add(pigeon);
        simulate(flockOfDucks);//simulateแค่อันเดียวเพราะใส่ฝูงแล้ว มันวนloopให้แล้วในFlock

    }

    void simulate(Quackable duck) {
        duck.quack();
    }
}
