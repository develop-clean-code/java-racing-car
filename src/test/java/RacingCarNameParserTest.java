import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RacingCarNameParserTest {

    private RacingCarNameParser racingCarNameParser;
    private String[] resultNames = {"test1", "test2", "test3"};
    private String testCase = " test1 , test2 , test3 ";

    @Before
    public void setup() {
        racingCarNameParser = new RacingCarNameParser();
    }

    @Test
    public void parse_성공() {


        String[] testCaseResult = racingCarNameParser.parse(testCase);

        for (int i = 0; i < resultNames.length; i++) {
            assertEquals(resultNames[i], testCaseResult[i]);
        }
    }


    @Test
    public void getNameCount_성공() {
        racingCarNameParser.parse(testCase);
        assertEquals(3, racingCarNameParser.getNameCount());
    }

    @Test
    public void getNameCount_실패() {
       racingCarNameParser.parse(testCase);
        assertNotEquals(0, racingCarNameParser.getNameCount());
    }
}
