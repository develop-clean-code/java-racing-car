import java.util.Random;

public class RacingCar {

    private int position;
    private Random random;
    private int max;
    private int min;

    RacingCar() {
        random = new Random();
        position = 0; // 초기화
    }

    RacingCar(int max, int min) {
        this();
        this.max = max;
        this.min = min;
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public boolean enableMove() {
        return random.nextInt(max + 1) > min;
    }

    public void tryMove() {
        if (enableMove())
            move();
    }
}
