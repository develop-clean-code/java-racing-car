public class RacingCarNameParser {

    private int nameCount;

    public String[] parse(String carNames) {

        String [] resultNames = carNames.split(",");
        for(int i = 0;i <resultNames.length;i++) {
            resultNames[i] = resultNames[i].trim();
        }

        this.nameCount = resultNames.length;

        return resultNames;
    }

    public int getNameCount() {
        return nameCount;
    }
}
