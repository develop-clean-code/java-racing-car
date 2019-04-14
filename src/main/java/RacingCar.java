public class RacingCar {

    private String carName;
    private int position;
    private final static int MAX = 9;
    private final static int MIN = 4;

    RacingCar(String carName) {
        this.carName = carName;
        this.position = 0;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }


    public String getName() {
        return carName;
    }

    public boolean move(int tryNumber) {
        if (isMovable(tryNumber)) {
            position++;
            return true;
        }

        return false;
    }

    public boolean isMovable(int tryNumber) {
        return tryNumber >= MIN && tryNumber <= MAX;
    }


    @Override
    public String toString() {
        return "RacingCar{" +
                "carName='" + carName + '\'' +
                ", position=" + position +
                '}';
    }
}
