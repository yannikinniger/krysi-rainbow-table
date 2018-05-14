import org.apache.commons.lang3.ArrayUtils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yannik Inniger
 */
public class Starter {

    //Initialisierung der vorgegebenen Werte
    private static int CHAINLENGTH = 2000;
    private static int PWLENGHT = 7;
    private static String H = "1d56a37fb6b08aa709fe90e12ca59e12";
    private static char[] AMOUNT_Z = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};


    // should be moved to DefaultReductionFunction
    public String reduction(String hashValue, int step) {
        BigInteger h = new BigInteger(hashValue, 16); //umwandlung
        h = h.add(BigInteger.valueOf(step));
        BigInteger x;
        String result = "";
        for (int i = 1; i < PWLENGHT; i++) {
            x = h.mod(BigInteger.valueOf(AMOUNT_Z.length));//x = H mod 36
            result = x.toString();    // KOMMENTAR: will ausgeben welche Zahl/Nummer aus AMOUNTZ x ist. also z.B. falls x = 10 ergibt dann ist es 'a'
          //  result = AMOUNTZ[x];          Kommentar: versuchte 2 Varianten aber scheint nicht zu stimmen.
            h = h.divide(BigInteger.valueOf(AMOUNT_Z.length));

        }
        return result;

    }


    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }



    public static void main(String[] args) {
        List<String> startValues = new ArrayList<>(2000);
        // generate startValues of passwords
        startValues.add("0000000");
        for (int position = passwordLength - 1; startValues.size() < 2000 || position >= 0; position -= 1) {
            char[] creationArray = ArrayUtils.subarray(possibleChars, 1, possibleChars.length);
            for (char c : creationArray) {
                StringBuilder currentBuilder = new StringBuilder("0000000");
                currentBuilder.setCharAt(position, c);
                List<String> additionalCombinations = combine(currentBuilder, position, creationArray);
                int newListSize = startValues.size() + additionalCombinations.size();
                if (newListSize > 2000) {
                    int maxSize = 2000 - startValues.size();
                    additionalCombinations = additionalCombinations.subList(0, maxSize);
                }
                startValues.addAll(additionalCombinations);
            }
        }
    }

    private static List<String> combine(StringBuilder initialString, int positionToCombine, char[] combinationChars) {
        List<String> combinations = new ArrayList<>();
        combinations.add(initialString.toString());
        for (int i = positionToCombine + 1; i < initialString.length(); i += 1) {
            for (char c : combinationChars) {
                initialString.setCharAt(i, c);
                combinations.add(initialString.toString());
            }
        }
        return combinations;
    }

}
