package kadenho.ciphers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class EncryptVigenereCipherTest {
    @Test
    public void lowercaseTextLowercaseShorterKey() {
        String plaintext = "pepperoni";
        String[] expectedOutput = {"emooegwmh", "pizza"};
        String[] actualOutput = VigenereCipher.encrypt(plaintext, "pizza");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseTextMixcaseShorterKey() {
        String plaintext = "panfriedsalmon";
        String[] expectedOutput = {"nuzrpgypeyjgaz", "Yummy"};
        String[] actualOutput = VigenereCipher.encrypt(plaintext, "Yummy");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseTextLowercaseShorterKey() {
        String plaintext = "FiletMignon";
        String[] expectedOutput = {"XbpedEazrox", "steaks"};
        String[] actualOutput = VigenereCipher.encrypt(plaintext, "steaks");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseTextMixcaseShorterKey() {
        String plaintext = "ILoveCroutons";
        String[] expectedOutput = {"ALzvhUrzuwgnd", "salad"};
        String[] actualOutput = VigenereCipher.encrypt(plaintext, "salad");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedTextLowercaseShorterKey() {
        String plaintext = "i love the album immunity";
        String[] expectedOutput = {"j lunf tnw blhmn isevnolz", "bags"};
        String[] actualOutput = VigenereCipher.encrypt(plaintext, "bags");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedTextMixcaseShorterKey() {
        String plaintext = "i also really like sling";
        String[] expectedOutput = {"i mzwp remzpz liws wmins", "Amoeba"};
        String[] actualOutput = VigenereCipher.encrypt(plaintext, "Amoeba");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedTextLowercaseShorterKey() {
        String plaintext = "But one of my favorite albums is definitely Charm";
        String[] expectedOutput = {"Hfh flx cy tc xnjkxthv yepntw af raltbzrxzr Jlsea", "glorytothesnow"};
        String[] actualOutput = VigenereCipher.encrypt(plaintext, "glorytothesnow");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedTextMixcaseShorterKey() {
        String plaintext = "There is a Shelly EP out that I like";
        String[] expectedOutput = {"Vysjw gg u Jtmyoa VD gmr hbrf Q ylmv", "CrossYourMind"};
        String[] actualOutput = VigenereCipher.encrypt(plaintext, "CrossYourMind");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedMixCharTextLowercaseShorterKey() {
        String plaintext = "my favorite brand of instant raman is...shin!";
        String[] expectedOutput = {"nm blwcntus xcbbz zg wjduoje soilo wo...diwj!", "bowl"};
        String[] actualOutput = VigenereCipher.encrypt(plaintext, "bowl");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedMixCharTextMixcaseShorterKey() {
        String plaintext = "i wish songs were longer! i hate when a song is only 2-minutes. at least 3 minutes is better.";
        String[] expectedOutput = {"j wtdh vpnrd whse wznjfr! t sawf wspn d toyr iv pnwj 2-mloueps. du lplsw 3 niyftht id mewuec.", "Ballad"};
        String[] actualOutput = VigenereCipher.encrypt(plaintext, "Ballad");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedMixCharTextLowercaseShorterKey() {
        String plaintext = "Clairo, Beabadoobee, Laufey, Sabrina Carpenter, and Suki Waterhouse are my favorite singers!";
        String[] expectedOutput = {"Eznkvf, Ugoochfhdsr, Nelygm, Fcfibpo Pcvgxphrt, eew Uixk Armgfuqyjx cfr oc wtxcekxv lkbtgvj!", "concert"};
        String[] actualOutput = VigenereCipher.encrypt(plaintext, "concert");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedMixCharTextMixcaseShorterKey() {
        String plaintext = "I want to live in Chicago! I love the big city feel while still being near home.";
        String[] expectedOutput = {"Q hlvg hw dqgp qa Qpaklrw! V zwnm esm owo uqej nrst optwm fhqdt mpqau vwic swzs.", "Illinois"};
        String[] actualOutput = VigenereCipher.encrypt(plaintext, "Illinois");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseTextLowercaseLongerKey() {
        String plaintext = "hello";
        String[] expectedOutput = {"nvpph", "greetings"};
        String[] actualOutput = VigenereCipher.encrypt(plaintext, "greetings");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseTextMixcaseLongerKey() {
        String plaintext = "piano";
        String[] expectedOutput = {"uwrgw", "FORTISSIMO"};
        String[] actualOutput = VigenereCipher.encrypt(plaintext, "FORTISSIMO");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseTextLowercaseLongerKey() {
        String plaintext = "Duck";
        String[] expectedOutput = {"Sypq", "penguin"};
        String[] actualOutput = VigenereCipher.encrypt(plaintext, "penguin");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseTextMixcaseLongerKey() {
        String plaintext = "Bread";
        String[] expectedOutput = {"Tfyrg", "SourDough"};
        String[] actualOutput = VigenereCipher.encrypt(plaintext, "SourDough");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedTextLowercaseLongerKey() {
        String plaintext = "hi mom";
        String[] expectedOutput = {"pu abf", "imonthetv"};
        String[] actualOutput = VigenereCipher.encrypt(plaintext, "imonthetv");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedTextMixcaseLongerKey() {
        String plaintext = "the library";
        String[] expectedOutput = {"hme wmyrnup", "ofAlexandria"};
        String[] actualOutput = VigenereCipher.encrypt(plaintext, "ofAlexandria");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedTextLowercaseLongerKey() {
        String plaintext = "The Old Guard";
        String[] expectedOutput = {"Ehz Wpl Rfexd", "lavieillegarde"};
        String[] actualOutput = VigenereCipher.encrypt(plaintext, "lavieillegarde");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedTextMixcaseLongerKey() {
        String plaintext = "University of Nebraska Omaha";
        String[] expectedOutput = {"Numprznmkq wy Lsgeetba Gwasi", "TheUniversityOfNebraskaLincoln"};
        String[] actualOutput = VigenereCipher.encrypt(plaintext, "TheUniversityOfNebraskaLincoln");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedMixCharTextLowercaseLongerKey() {
        String plaintext = "i love bacon!";
        String[] expectedOutput = {"j fhdp jkgdn!", "butilikepancakestoo"};
        String[] actualOutput = VigenereCipher.encrypt(plaintext, "butilikepancakestoo");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedMixCharTextMixcaseLongerKey() {
        String plaintext = "its a me, mario!";
        String[] expectedOutput = {"igv h uw, nrfbv!", "AndHisBrotherLuigi"};
        String[] actualOutput = VigenereCipher.encrypt(plaintext, "AndHisBrotherLuigi");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedMixCharTextLowercaseLongerKey() {
        String plaintext = "My favorite game:";
        String[] expectedOutput = {"Dc idzouzxh kmbx:", "reddeadredemptiontwo"};
        String[] actualOutput = VigenereCipher.encrypt(plaintext, "reddeadredemptiontwo");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedMixCharTextMixcaseLongerKey() {
        String plaintext = "32GB DDR4 RAM!";
        String[] expectedOutput = {"32OO HHU4 KOG!", "INeedToUpgrade"};
        String[] actualOutput = VigenereCipher.encrypt(plaintext, "INeedToUpgrade");
        assertArrayEquals(expectedOutput, actualOutput);
    }
}
