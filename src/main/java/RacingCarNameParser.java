public class RacingCarNameParser {

    private int nameCount;

    public String[] parse(String carNames) {

        System.out.println(carNames);
        String [] resultNames = carNames.split(",");
        System.out.println(resultNames);
        for(int i = 0;i <resultNames.length;i++) {
            resultNames[i] = resultNames[i].trim();
            System.out.println(resultNames[i]);
        }

        nameCount = resultNames.length;
        System.out.println(nameCount);

        return resultNames;
    }

    public int getNameCount() {
        return nameCount;
    }
}
