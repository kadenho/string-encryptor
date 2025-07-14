package kadenho.encryptor;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MixedAlphabetCipherTest {
    @Test
    public void lowercaseTextLowercaseKey() {
        String plaintext = "helloworld";
        String[] expectedOutput = {"ryffjujnfb", "goodbyeworld"};
        String[] actualOutput = StringEncryptor.mixedAlphabetCipher(plaintext, "goodbyeworld");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseTextMixcaseKey() {
        String plaintext = "softwareengineering";
        String[] expectedOutput = {"kftlwcjuudesduujsde", "ComputerScience"};
        String[] actualOutput = StringEncryptor.mixedAlphabetCipher(plaintext, "ComputerScience");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseTextLowercaseKey() {
        String plaintext = "PaNcAkEs";
        String[] expectedOutput = {"NwKfWhEq", "waffles"};
        String[] actualOutput = StringEncryptor.mixedAlphabetCipher(plaintext, "waffles");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseTextMixcaseKey() {
        String plaintext = "CamelCaseRules";
        String[] expectedOutput = {"KihsgKirsQugsr", "iLikeSnakeCase"};
        String[] actualOutput = StringEncryptor.mixedAlphabetCipher(plaintext, "iLikeSnakeCase");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedTextLowercaseKey() {
        String plaintext = "i have many favorite artists";
        String[] expectedOutput = {"e dcvr jcky ocvmqetr cqtests", "clairo"};
        String[] actualOutput = StringEncryptor.mixedAlphabetCipher(plaintext, "clairo");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedTextMixcaseKey() {
        String plaintext = "its hard to pick just one to be my favorite";
        String[] expectedOutput = {"hts gbrd tn phaj iust nmo tn eo ly cbvnrhto", "Beabadoobee"};
        String[] actualOutput = StringEncryptor.mixedAlphabetCipher(plaintext, "Beabadoobee");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedTextLowercaseKey() {
        String plaintext = "For example I love the band Bleachers but I also like the band";
        String[] expectedOutput = {"Rko axtglfa B fkva qsa htjm Hfatesaop huq B tfpk fbda qsa htjm", "themarias"};
        String[] actualOutput = StringEncryptor.mixedAlphabetCipher(plaintext, "themarias");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedTextMixcaseKey() {
        String plaintext = "I think Sabrina Carpenter and Suki Waterhouse are great too";
        String[] expectedOutput = {"C tbckg Sinrcki Dirmpktpr ike Sugc Witprblusp irp arpit tll", "IndiePop"};
        String[] actualOutput = StringEncryptor.mixedAlphabetCipher(plaintext, "IndiePop");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedMixCharTextLowercaseKey() {
        String plaintext = "my favorite movie franchise is paddington 2. it is very cute and silly!";
        String[] expectedOutput = {"fy osvhmnqi fhvni omsguanpi np jsddngcqhg 2. nq np vimy urqi sgd pneey!", "studiocanal"};
        String[] actualOutput = StringEncryptor.mixedAlphabetCipher(plaintext, "studiocanal");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedMixCharTextMixcaseKey() {
        String plaintext = "which paddington movie do you like the most: 1, 2, or 3? they are all very great movies.";
        String[] expectedOutput = {"wcfrc omllfkbtnk jnvfd ln ynu ifhd tcd jnst: 1, 2, nq 3? tcdy mqd mii vdqy bqdmt jnvfds.", "Marmalade"};
        String[] actualOutput = StringEncryptor.mixedAlphabetCipher(plaintext, "Marmalade");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedMixCharTextLowercaseKey() {
        String plaintext = "I like many genres of movies, but especially horror. They keep me on the edge of my seat!";
        String[] expectedOutput = {"F ifha jsky bakpaq lm jlvfaq, cut aqnarfsiiy dlpplp. Tday haan ja lk tda aeba lm jy qast!", "scream"};
        String[] actualOutput = StringEncryptor.mixedAlphabetCipher(plaintext, "scream");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedMixCharTextMixcaseKey() {
        String plaintext = "The most recent movie I watched was 20th Century Girl. It had a very sad ending.";
        String[] expectedOutput = {"Ter jlst qrbrkt jlvfr F wntbero wns 20te Brktuqy Dfqi. Ft eno n vrqy sno rkofkd.", "NaBoRa"};
        String[] actualOutput = StringEncryptor.mixedAlphabetCipher(plaintext, "NaBoRa");
        assertArrayEquals(expectedOutput, actualOutput);
    }

}
