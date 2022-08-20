package adaptor;

import animals.Pigeon;
import animals.Quackable;

public class PigeonAdaptor implements Quackable {
    private Pigeon pigeon;

    public PigeonAdaptor(Pigeon pigeon) {
        this.pigeon = pigeon;
    }

    @Override
    public void quack() {
        int count = 1;

        while (count <= 2){
            pigeon.coo();
            count++;
        }
    }
}
