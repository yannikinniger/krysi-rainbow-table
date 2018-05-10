import reduction.ReductionFunction;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yannik Inniger
 */
public class RainbowTable {

    private final Map<String, String> values = new HashMap<>();

    /**
     * Should immediately trigger the creation of the rainbow table and save the values
     * @param passwordLength Length of the password to crack
     * @param possibleChars All possible chars which could occur in the password
     * @param chainLength Number of iterations each value should go through
     * @param reductionFunction Function to reduce a String
     * @param hashFunction Function to hash a String
     * @param startValues Start values of the rainbow table
     */
    public RainbowTable(int passwordLength, char[] possibleChars, int chainLength,
                        ReductionFunction reductionFunction, MessageDigest hashFunction, List<String> startValues) {
    }

    // does not search backwards yet
    public String get(String start) {
        return values.get(start);
    }

}
