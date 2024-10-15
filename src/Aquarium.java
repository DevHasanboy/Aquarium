
import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private final List<Fish> fishList = new ArrayList<>();

    public synchronized void start() {
        if (fishList.isEmpty()) {
            for (int i = 0; i < FishFactory.initialCount; i++) {
                Fish generatedFish = FishFactory.generate(this);
                fishList.add(generatedFish);
                generatedFish.start();
            }
        }
        printDetail();
    }

    private void printDetail() {
        int male = 0;
        int female = 0;

        for (Fish fish : fishList) {
            if (fish.getGender() == Gender.MALE) {
                male++;
            } else {
                female++;
            }
        }

        System.out.println("----------- Fish List Info -----------");
        System.out.println("Male   -> " + male);
        System.out.println("Female -> " + female);
        System.out.println("Total  -> " + fishList.size());
        System.out.println("--------------------------------------");
    }

    public synchronized void remove(Fish fish) {
        fishList.remove(fish);
    }

    public synchronized void checkForCollision(Fish fish) {
        if (fishList.size() >= FishFactory.size) {
            System.err.println("no love");
        }

        for (Fish dto : fishList) {
            if (dto.getCoordinateX() == fish.getCoordinateX() && dto.getCoordinateY() == fish.getCoordinateY()) {
                if (!dto.getGender().equals(fish.getGender())) {
                    Fish generatedFish = FishFactory.generate(this);
                    fishList.add(generatedFish);
                    generatedFish.start();
                    System.out.println(generatedFish);
                    fish.setTimeOut(RandomFish.getRandom(10));
                    System.out.println("--------------- PROPAGATION ----------------");
                    System.out.println(fish + " " + Thread.currentThread().getName());
                    System.out.println(dto + " " + Thread.currentThread().getName());
                    System.out.println("--------------- New fish was born -----------\n" + generatedFish);
                    System.out.println("---------------------------------------------");

                    return;
                }
            }
        }
    }
}