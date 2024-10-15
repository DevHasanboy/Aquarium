


public class FishFactory {

    public static final int liveTime = 30;
    public static final int x = 3;
    public static final int y = 3;
    public static final int initialCount = 3;

    public static final int size = x * y;

    public static Fish generate(Aquarium aquarium) {
        Gender g = RandomFish.getRandomGender();

        int live = RandomFish.getRandom(liveTime);

        return new Fish(aquarium, RandomFish.getRandom(x + 1), RandomFish.getRandom(y + 1), g, live);
    }
}


