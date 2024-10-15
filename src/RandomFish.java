

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomFish {

    private static final Random random = ThreadLocalRandom.current();

    public static Gender getRandomGender() {
        if (random.nextBoolean()) {
            return Gender.MALE;
        } else {
            return Gender.FEMALE;
        }
    }

    public static int getRandom(int n) {
        return random.nextInt(n);
    }
}
