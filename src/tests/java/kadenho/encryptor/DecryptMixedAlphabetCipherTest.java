package kadenho.encryptor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DecryptMixedAlphabetCipherTest {
    @Test
    public void lowercaseTextLowercaseKey() {
        String ciphertext = "ryffjujnfb";
        String[] expectedOutput = {"helloworld", "goodbyeworld"};
        String[] actualOutput = StringEncryptor.decryptMixedAlphabetCipher(ciphertext, "goodbyeworld");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseTextMixcaseKey() {
        String ciphertext = "kftlwcjuudesduujsde";
        String[] expectedOutput = {"softwareengineering", "ComputerScience"};
        String[] actualOutput = StringEncryptor.decryptMixedAlphabetCipher(ciphertext, "ComputerScience");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseTextLowercaseKey() {
        String ciphertext = "NwKfWhEq";
        String[] expectedOutput = {"PaNcAkEs", "waffles"};
        String[] actualOutput = StringEncryptor.decryptMixedAlphabetCipher(ciphertext, "waffles");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseTextMixcaseKey() {
        String ciphertext = "KihsgKirsQugsr";
        String[] expectedOutput = {"CamelCaseRules", "iLikeSnakeCase"};
        String[] actualOutput = StringEncryptor.decryptMixedAlphabetCipher(ciphertext, "iLikeSnakeCase");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedTextLowercaseKey() {
        String ciphertext = "e dcvr jcky ocvmqetr cqtests";
        String[] expectedOutput = {"i have many favorite artists", "clairo"};
        String[] actualOutput = StringEncryptor.decryptMixedAlphabetCipher(ciphertext, "clairo");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedTextMixcaseKey() {
        String ciphertext = "hts gbrd tn phaj iust nmo tn eo ly cbvnrhto";
        String[] expectedOutput = {"its hard to pick just one to be my favorite", "Beabadoobee"};
        String[] actualOutput = StringEncryptor.decryptMixedAlphabetCipher(ciphertext, "Beabadoobee");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedTextLowercaseKey() {
        String ciphertext = "Rko axtglfa B fkva qsa htjm Hfatesaop huq B tfpk fbda qsa htjm";
        String[] expectedOutput = {"For example I love the band Bleachers but I also like the band", "themarias"};
        String[] actualOutput = StringEncryptor.decryptMixedAlphabetCipher(ciphertext, "themarias");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedTextMixcaseKey() {
        String ciphertext = "C tbckg Sinrcki Dirmpktpr ike Sugc Witprblusp irp arpit tll";
        String[] expectedOutput = {"I think Sabrina Carpenter and Suki Waterhouse are great too", "IndiePop"};
        String[] actualOutput = StringEncryptor.decryptMixedAlphabetCipher(ciphertext, "IndiePop");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedMixCharTextLowercaseKey() {
        String ciphertext = "fy osvhmnqi fhvni omsguanpi np jsddngcqhg 2. nq np vimy urqi sgd pneey!";
        String[] expectedOutput = {"my favorite movie franchise is paddington 2. it is very cute and silly!", "studiocanal"};
        String[] actualOutput = StringEncryptor.decryptMixedAlphabetCipher(ciphertext, "studiocanal");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedMixCharTextMixcaseKey() {
        String ciphertext = "wcfrc omllfkbtnk jnvfd ln ynu ifhd tcd jnst: 1, 2, nq 3? tcdy mqd mii vdqy bqdmt jnvfds.";
        String[] expectedOutput = {"which paddington movie do you like the most: 1, 2, or 3? they are all very great movies.", "Marmalade"};
        String[] actualOutput = StringEncryptor.decryptMixedAlphabetCipher(ciphertext, "Marmalade");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedMixCharTextLowercaseKey() {
        String ciphertext = "F ifha jsky bakpaq lm jlvfaq, cut aqnarfsiiy dlpplp. Tday haan ja lk tda aeba lm jy qast!";
        String[] expectedOutput = {"I like many genres of movies, but especially horror. They keep me on the edge of my seat!", "scream"};
        String[] actualOutput = StringEncryptor.decryptMixedAlphabetCipher(ciphertext, "scream");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedMixCharTextMixcaseKey() {
        String ciphertext = "Ter jlst qrbrkt jlvfr F wntbero wns 20te Brktuqy Dfqi. Ft eno n vrqy sno rkofkd.";
        String[] expectedOutput = {"The most recent movie I watched was 20th Century Girl. It had a very sad ending.", "NaBoRa"};
        String[] actualOutput = StringEncryptor.decryptMixedAlphabetCipher(ciphertext, "NaBoRa");
        assertArrayEquals(expectedOutput, actualOutput);
    }

}
