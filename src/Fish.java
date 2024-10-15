
public class Fish extends Thread {

    private int coordinateX;

    private int coordinateY;

    private final Gender gender;

    private final Aquarium aquarium;

    private int lifeTime;

    private long timeOut;

    @Override
    public void run() {

        while (lifeTime != 0) {
            move();
            aquarium.checkForCollision(this);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lifeTime--;
            if (timeOut > 0) {
                timeOut--;
            }
        }

        aquarium.remove(this);
        System.out.println("Fish Died -> " + getName() + " " + this);
    }


    public void move() {
        int x = RandomFish.getRandom(4) + 1;

        int newX = getCoordinateX();
        int newY = getCoordinateY();

        switch (x) {
            case 1 -> newX++;
            case 2 -> newY++;
            case 3 -> newX--;
            case 4 -> newY--;
        }

        if (newX >= 0 && newX <= FishFactory.x) {
            setCoordinateX(newX);
        }

        if (newY >= 0 && newY <= FishFactory.y) {
            setCoordinateY(newY);
        }

        System.out.println(newX == getCoordinateX() && newY == getCoordinateY() ? "Didn't Move -> " + this : "");
    }


    public Fish(Aquarium aquarium, int coordinateX, int coordinateY, Gender gender, int live) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.aquarium = aquarium;
        this.gender = gender;
        this.lifeTime = live;
    }


    public void setTimeOut(long timeOut) {
        this.timeOut = timeOut;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Fish Info [" +
                "coordinateX = " + coordinateX +
                ", coordinateY = " + coordinateY +
                ", gender = " + gender +
                ", lifeTme = " + lifeTime +
                ']';
    }
}
