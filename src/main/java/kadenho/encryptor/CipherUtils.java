package kadenho.encryptor;

public class CipherUtils {
    public static final String UNSCRAMBLED_ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static int getModularMultiplicativeInverse(int multiplicative) {
        Integer multiplicativeInverse = null;
        int multiplicativeInverseCandidate = 0;
        while (multiplicativeInverse == null) {
            if ((multiplicativeInverseCandidate * multiplicative) % UNSCRAMBLED_ALPHABET.length() == 1) {
                multiplicativeInverse = multiplicativeInverseCandidate;
            } else {
                multiplicativeInverseCandidate++;
            }
        }
        return multiplicativeInverse;
    }
}
