package kadenho.encryptor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class EncryptAutokeyCipherTest {
    @Test
    public void lowercaseTextLowercaseShorterKey() {
        String plaintext = "pepperoni";
        String[] expectedOutput = {"emooegscx", "pizza"};
        String[] actualOutput = StringEncryptor.encryptAutokeyCipher(plaintext, "pizza");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseTextMixcaseShorterKey() {
        String plaintext = "panfriedsalmon";
        String[] expectedOutput = {"nuzrpxeqxrtqrf", "Yummy"};
        String[] actualOutput = StringEncryptor.encryptAutokeyCipher(plaintext, "Yummy");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseTextLowercaseShorterKey() {
        String plaintext = "FiletMignon";
        String[] expectedOutput = {"XbpedEnoysg", "steaks"};
        String[] actualOutput = StringEncryptor.encryptAutokeyCipher(plaintext, "steaks");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseTextMixcaseShorterKey() {
        String plaintext = "ILoveCroutons";
        String[] expectedOutput = {"ALzvhKccpxqeg", "salad"};
        String[] actualOutput = StringEncryptor.encryptAutokeyCipher(plaintext, "salad");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedTextLowercaseShorterKey() {
        String plaintext = "i love the album immunity";
        String[] expectedOutput = {"j lunm evz eeiym tnggvufs", "bags"};
        String[] actualOutput = StringEncryptor.encryptAutokeyCipher(plaintext, "bags");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedTextMixcaseShorterKey() {
        String plaintext = "i also really like sling";
        String[] expectedOutput = {"i mzwp rmawdm cmkp djtvq", "Amoeba"};
        String[] actualOutput = StringEncryptor.encryptAutokeyCipher(plaintext, "Amoeba");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedTextLowercaseShorterKey() {
        String plaintext = "But one of my favorite albums is definitely Charm";
        String[] expectedOutput = {"Hfh flx cy tc xnjkscms nppzyq ns yswqgmtpms Ozijp", "glorytothesnow"};
        String[] actualOutput = StringEncryptor.encryptAutokeyCipher(plaintext, "glorytothesnow");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedTextMixcaseShorterKey() {
        String plaintext = "There is a Shelly EP out that I like";
        String[] expectedOutput = {"Vysjw gg u Jtmyor LT fyb lhsa M wtii", "CrossYourMind"};
        String[] actualOutput = StringEncryptor.encryptAutokeyCipher(plaintext, "CrossYourMind");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedMixCharTextLowercaseShorterKey() {
        String plaintext = "my favorite brand of instant raman is...shin!";
        String[] expectedOutput = {"nm blhmwios sztre ff vqgyial kazte ie...suqf!", "bowl"};
        String[] actualOutput = StringEncryptor.encryptAutokeyCipher(plaintext, "bowl");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedMixCharTextMixcaseShorterKey() {
        String plaintext = "i wish songs were longer! i hate when a song is only 2-minutes. at least 3 minutes is better.";
        String[] expectedOutput = {"j wtdh vwjok dwfr rgjkvv! t vnzi npln t wkuk vs gbye 2-uabhece. ig fxekt 3 ftrulxe qf vxxlmj.", "Ballad"};
        String[] actualOutput = StringEncryptor.encryptAutokeyCipher(plaintext, "Ballad");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedMixCharTextLowercaseShorterKey() {
        String plaintext = "Clairo, Beabadoobee, Laufey, Sabrina Carpenter, and Suki Waterhouse are my favorite singers!";
        String[] expectedOutput = {"Eznkvf, Uglbiucpfef, Lditfc, Wlblnry Uasgmatgr, rch Fnoz Wnwwlrwqsx eil as xevfvurj sdbxmkw!", "concert"};
        String[] actualOutput = StringEncryptor.encryptAutokeyCipher(plaintext, "concert");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedMixCharTextMixcaseShorterKey() {
        String plaintext = "I want to live in Chicago! I love the big city feel while still being near home.";
        String[] expectedOutput = {"Q hlvg hw dqre vg Vvtkvkw! V nvdg tns jtu xmmf jfmr ypbjj wxths jpmfz vpls lwzk.", "Illinois"};
        String[] actualOutput = StringEncryptor.encryptAutokeyCipher(plaintext, "Illinois");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseTextLowercaseLongerKey() {
        String plaintext = "hello";
        String[] expectedOutput = {"nvpph", "greetings"};
        String[] actualOutput = StringEncryptor.encryptAutokeyCipher(plaintext, "greetings");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseTextMixcaseLongerKey() {
        String plaintext = "piano";
        String[] expectedOutput = {"uwrgw", "FORTISSIMO"};
        String[] actualOutput = StringEncryptor.encryptAutokeyCipher(plaintext, "FORTISSIMO");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseTextLowercaseLongerKey() {
        String plaintext = "Duck";
        String[] expectedOutput = {"Sypq", "penguin"};
        String[] actualOutput = StringEncryptor.encryptAutokeyCipher(plaintext, "penguin");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseTextMixcaseLongerKey() {
        String plaintext = "Bread";
        String[] expectedOutput = {"Tfyrg", "SourDough"};
        String[] actualOutput = StringEncryptor.encryptAutokeyCipher(plaintext, "SourDough");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedTextLowercaseLongerKey() {
        String plaintext = "hi mom";
        String[] expectedOutput = {"pu abf", "imonthetv"};
        String[] actualOutput = StringEncryptor.encryptAutokeyCipher(plaintext, "imonthetv");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedTextMixcaseLongerKey() {
        String plaintext = "the library";
        String[] expectedOutput = {"hme wmyrnup", "ofAlexandria"};
        String[] actualOutput = StringEncryptor.encryptAutokeyCipher(plaintext, "ofAlexandria");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedTextLowercaseLongerKey() {
        String plaintext = "The Old Guard";
        String[] expectedOutput = {"Ehz Wpl Rfexd", "lavieillegarde"};
        String[] actualOutput = StringEncryptor.encryptAutokeyCipher(plaintext, "lavieillegarde");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedTextMixcaseLongerKey() {
        String plaintext = "University of Nebraska Omaha";
        String[] expectedOutput = {"Numprznmkq wy Lsgeetba Gwasi", "TheUniversityOfNebraskaLincoln"};
        String[] actualOutput = StringEncryptor.encryptAutokeyCipher(plaintext, "TheUniversityOfNebraskaLincoln");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedMixCharTextLowercaseLongerKey() {
        String plaintext = "i love bacon!";
        String[] expectedOutput = {"j fhdp jkgdn!", "butilikepancakestoo"};
        String[] actualOutput = StringEncryptor.encryptAutokeyCipher(plaintext, "butilikepancakestoo");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedMixCharTextMixcaseLongerKey() {
        String plaintext = "its a me, mario!";
        String[] expectedOutput = {"igv h uw, nrfbv!", "AndHisBrotherLuigi"};
        String[] actualOutput = StringEncryptor.encryptAutokeyCipher(plaintext, "AndHisBrotherLuigi");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedMixCharTextLowercaseLongerKey() {
        String plaintext = "My favorite game:";
        String[] expectedOutput = {"Dc idzouzxh kmbx:", "reddeadredemptiontwo"};
        String[] actualOutput = StringEncryptor.encryptAutokeyCipher(plaintext, "reddeadredemptiontwo");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedMixCharTextMixcaseLongerKey() {
        String plaintext = "32GB DDR4 RAM!";
        String[] expectedOutput = {"32OO HHU4 KOG!", "INeedToUpgrade"};
        String[] actualOutput = StringEncryptor.encryptAutokeyCipher(plaintext, "INeedToUpgrade");
        assertArrayEquals(expectedOutput, actualOutput);
    }
}
