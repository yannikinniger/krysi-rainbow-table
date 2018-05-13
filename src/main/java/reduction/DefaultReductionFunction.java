package reduction;

import java.math.BigInteger;

/**
 * @author Yannik Inniger on 10.05.2018.
 */
public class DefaultReductionFunction implements ReductionFunction {

    @Override
    public String reduce(BigInteger hash, int level, char[] possibleChars, int length) {
        final BigInteger numberOfPossibleChars = BigInteger.valueOf(possibleChars.length);
        BigInteger hashPlusLevel = hash.add(BigInteger.valueOf(level));

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i += 1) {
            BigInteger ri = hashPlusLevel.mod(numberOfPossibleChars);
            hashPlusLevel = hashPlusLevel.divide(numberOfPossibleChars);
            stringBuilder.insert(0, possibleChars[ri.intValue()]);
        }
        return stringBuilder.toString();
    }

}
