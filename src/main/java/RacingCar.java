public class RacingCar implements Comparable<RacingCar>{

    private int position;
    private int max;
    private int min;
    private String name;

    RacingCar() {
        position = 0; // 초기화
    }

    RacingCar(String name, int max, int min) {
        this();
        this.name = name;
        this.max = max;
        this.min = min;
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public boolean enableMove(int a) {
        return a >= min && a <= max;
    }

    public void tryMove(int randomNum) {
        if (enableMove(randomNum))
            move();
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(RacingCar racingCar) {
        return racingCar.getPosition() - position;
    }
}
