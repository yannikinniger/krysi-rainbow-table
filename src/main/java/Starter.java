import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Yannik Inniger
 */
public class Starter {

    //Initialisierung der vorgegebenen Werte
    private static int CHAINLENGTH = 2000;
    private static int PWLENGHT = 7;
    private static String H = "1d56a37fb6b08aa709fe90e12ca59e12";
    private static char[] AMOUNTZ = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};


    // should be moved to DefaultReductionFunction
    public String reduction(String hashValue, int step) {
        BigInteger h = new BigInteger(hashValue, 16); //umwandlung
        h = h.add(BigInteger.valueOf(step));
        BigInteger x;
        String result = "";
        for (int i = 1; i < PWLENGHT; i++) {
            x = h.mod(BigInteger.valueOf(AMOUNTZ.length));//x = H mod 36
            result = x.toString();    // KOMMENTAR: will ausgeben welche Zahl/Nummer aus AMOUNTZ x ist. also z.B. falls x = 10 ergibt dann ist es 'a'
          //  result = AMOUNTZ[x];          Kommentar: versuchte 2 Varianten aber scheint nicht zu stimmen.
            h = h.divide(BigInteger.valueOf(AMOUNTZ.length));

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

    }

}
