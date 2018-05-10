package reduction;

import java.math.BigInteger;

/**
 * @author Yannik Inniger on 10.05.2018.
 */
public interface ReductionFunction {

    /**
     * Reduces a String to the length specified in the parameter length
     * @param hash Hash value which should be reduced
     * @param level Current number of the iteration
     * @param possibleChars All possible chars which could occur in the reduced String
     * @param length Length of the reduced String
     * @return
     */
    public String reduce(BigInteger hash, BigInteger level, char[] possibleChars, int length);

}
