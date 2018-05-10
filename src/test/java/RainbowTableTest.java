import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import reduction.DefaultReductionFunction;
import reduction.ReductionFunction;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Yannik Inniger on 10.05.2018.
 */
public class RainbowTableTest {

    @Test
    public void shouldCreateRainbowTable() throws Exception {
        String input = "0000000";

        char[] possibleChars = ArrayUtils.addAll(getNumbers(), getLetters());
        int passwordLength = 7;
        int chainLength = 3;
        List<String> startValues = Arrays.asList("0000000");
        ReductionFunction reductionFunction = new DefaultReductionFunction();
        MessageDigest hashFunction = MessageDigest.getInstance("MD5");

        RainbowTable rainbowTable = new RainbowTable(passwordLength, possibleChars, chainLength,
                                                     reductionFunction, hashFunction, startValues);

        String expected = "dues6fg";
        assertEquals(expected, rainbowTable.get(input));
    }

    private static char[] getNumbers() {
        char[] numbers = new char[10];
        for (int i = 0; i <= 9; i += 1) {
            numbers[i] = (char) (i + 48);
        }
        return numbers;
    }

    private static char[] getLetters() {
        char[] letters = new char[26];
        for (int i = 0; i < 26; i += 1) {
            letters[i] = (char) (i + 97);
        }
        return letters;
    }

}
