public class RacingCar {

    private int position;
    private int max;
    private int min;

    RacingCar() {
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

    public boolean enableMove(int a) {
        return a >= min && a <= max;
    }

    public void tryMove(int randomNum) {
        if (enableMove(randomNum))
            move();
    }
}
