import org.junit.Test;
import reduction.DefaultReductionFunction;
import reduction.ReductionFunction;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

/**
 * @author Yannik Inniger on 10.05.2018.
 */
public class ReductionFunctionTest {

    @Test
    public void shouldReduceInput() {
        ReductionFunction reductionFunction = new DefaultReductionFunction();
        BigInteger hash = BigInteger.valueOf(12345);
        int passwordLength = 3;
        char[] possibleChars = {'a', 'b', 'c', 'd', 'e'};

        String expected = "dea";
        String result = reductionFunction.reduce(hash, 0, possibleChars, passwordLength);
        assertEquals(expected, result);
    }

}
