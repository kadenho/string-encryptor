package kadenho.encryptor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DecryptVigenereCipherTest {
    @Test
    public void lowercaseTextLowercaseShorterKey() {
        String ciphertext = "emooegwmh";
        String[] expectedOutput = {"pepperoni", "pizza"};
        String[] actualOutput = StringEncryptor.decryptVigenereCipher(ciphertext, "pizza");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseTextMixcaseShorterKey() {
        String ciphertext = "nuzrpgypeyjgaz";
        String[] expectedOutput = {"panfriedsalmon", "Yummy"};
        String[] actualOutput = StringEncryptor.decryptVigenereCipher(ciphertext, "Yummy");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseTextLowercaseShorterKey() {
        String ciphertext = "XbpedEazrox";
        String[] expectedOutput = {"FiletMignon", "steaks"};
        String[] actualOutput = StringEncryptor.decryptVigenereCipher(ciphertext, "steaks");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseTextMixcaseShorterKey() {
        String ciphertext = "ALzvhUrzuwgnd";
        String[] expectedOutput = {"ILoveCroutons", "salad"};
        String[] actualOutput = StringEncryptor.decryptVigenereCipher(ciphertext, "salad");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedTextLowercaseShorterKey() {
        String ciphertext = "j lunf tnw blhmn isevnolz";
        String[] expectedOutput = {"i love the album immunity", "bags"};
        String[] actualOutput = StringEncryptor.decryptVigenereCipher(ciphertext, "bags");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedTextMixcaseShorterKey() {
        String ciphertext = "i mzwp remzpz liws wmins";
        String[] expectedOutput = {"i also really like sling", "Amoeba"};
        String[] actualOutput = StringEncryptor.decryptVigenereCipher(ciphertext, "Amoeba");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedTextLowercaseShorterKey() {
        String ciphertext = "Hfh flx cy tc xnjkxthv yepntw af raltbzrxzr Jlsea";
        String[] expectedOutput = {"But one of my favorite albums is definitely Charm", "glorytothesnow"};
        String[] actualOutput = StringEncryptor.decryptVigenereCipher(ciphertext, "glorytothesnow");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedTextMixcaseShorterKey() {
        String ciphertext = "Vysjw gg u Jtmyoa VD gmr hbrf Q ylmv";
        String[] expectedOutput = {"There is a Shelly EP out that I like", "CrossYourMind"};
        String[] actualOutput = StringEncryptor.decryptVigenereCipher(ciphertext, "CrossYourMind");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedMixCharTextLowercaseShorterKey() {
        String ciphertext = "nm blwcntus xcbbz zg wjduoje soilo wo...diwj!";
        String[] expectedOutput = {"my favorite brand of instant raman is...shin!", "bowl"};
        String[] actualOutput = StringEncryptor.decryptVigenereCipher(ciphertext, "bowl");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedMixCharTextMixcaseShorterKey() {
        String ciphertext = "j wtdh vpnrd whse wznjfr! t sawf wspn d toyr iv pnwj 2-mloueps. du lplsw 3 niyftht id mewuec.";
        String[] expectedOutput = {"i wish songs were longer! i hate when a song is only 2-minutes. at least 3 minutes is better.", "Ballad"};
        String[] actualOutput = StringEncryptor.decryptVigenereCipher(ciphertext, "Ballad");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedMixCharTextLowercaseShorterKey() {
        String ciphertext = "Eznkvf, Ugoochfhdsr, Nelygm, Fcfibpo Pcvgxphrt, eew Uixk Armgfuqyjx cfr oc wtxcekxv lkbtgvj!";
        String[] expectedOutput = {"Clairo, Beabadoobee, Laufey, Sabrina Carpenter, and Suki Waterhouse are my favorite singers!", "concert"};
        String[] actualOutput = StringEncryptor.decryptVigenereCipher(ciphertext, "concert");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedMixCharTextMixcaseShorterKey() {
        String ciphertext = "Q hlvg hw dqgp qa Qpaklrw! V zwnm esm owo uqej nrst optwm fhqdt mpqau vwic swzs.";
        String[] expectedOutput = {"I want to live in Chicago! I love the big city feel while still being near home.", "Illinois"};
        String[] actualOutput = StringEncryptor.decryptVigenereCipher(ciphertext, "Illinois");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseTextLowercaseLongerKey() {
        String ciphertext = "nvpph";
        String[] expectedOutput = {"hello", "greetings"};
        String[] actualOutput = StringEncryptor.decryptVigenereCipher(ciphertext, "greetings");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseTextMixcaseLongerKey() {
        String ciphertext = "uwrgw";
        String[] expectedOutput = {"piano", "FORTISSIMO"};
        String[] actualOutput = StringEncryptor.decryptVigenereCipher(ciphertext, "FORTISSIMO");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseTextLowercaseLongerKey() {
        String ciphertext = "Sypq";
        String[] expectedOutput = {"Duck", "penguin"};
        String[] actualOutput = StringEncryptor.decryptVigenereCipher(ciphertext, "penguin");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseTextMixcaseLongerKey() {
        String ciphertext = "Tfyrg";
        String[] expectedOutput = {"Bread", "SourDough"};
        String[] actualOutput = StringEncryptor.decryptVigenereCipher(ciphertext, "SourDough");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedTextLowercaseLongerKey() {
        String ciphertext = "pu abf";
        String[] expectedOutput = {"hi mom", "imonthetv"};
        String[] actualOutput = StringEncryptor.decryptVigenereCipher(ciphertext, "imonthetv");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedTextMixcaseLongerKey() {
        String ciphertext = "hme wmyrnup";
        String[] expectedOutput = {"the library", "ofAlexandria"};
        String[] actualOutput = StringEncryptor.decryptVigenereCipher(ciphertext, "ofAlexandria");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedTextLowercaseLongerKey() {
        String ciphertext = "Ehz Wpl Rfexd";
        String[] expectedOutput = {"The Old Guard", "lavieillegarde"};
        String[] actualOutput = StringEncryptor.decryptVigenereCipher(ciphertext, "lavieillegarde");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedTextMixcaseLongerKey() {
        String ciphertext = "Numprznmkq wy Lsgeetba Gwasi";
        String[] expectedOutput = {"University of Nebraska Omaha", "TheUniversityOfNebraskaLincoln"};
        String[] actualOutput = StringEncryptor.decryptVigenereCipher(ciphertext, "TheUniversityOfNebraskaLincoln");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedMixCharTextLowercaseLongerKey() {
        String ciphertext = "j fhdp jkgdn!";
        String[] expectedOutput = {"i love bacon!", "butilikepancakestoo"};
        String[] actualOutput = StringEncryptor.decryptVigenereCipher(ciphertext, "butilikepancakestoo");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedMixCharTextMixcaseLongerKey() {
        String ciphertext = "igv h uw, nrfbv!";
        String[] expectedOutput = {"its a me, mario!", "AndHisBrotherLuigi"};
        String[] actualOutput = StringEncryptor.decryptVigenereCipher(ciphertext, "AndHisBrotherLuigi");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedMixCharTextLowercaseLongerKey() {
        String ciphertext = "Dc idzouzxh kmbx:";
        String[] expectedOutput = {"My favorite game:", "reddeadredemptiontwo"};
        String[] actualOutput = StringEncryptor.decryptVigenereCipher(ciphertext, "reddeadredemptiontwo");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedMixCharTextMixcaseLongerKey() {
        String ciphertext = "32OO HHU4 KOG!";
        String[] expectedOutput = {"32GB DDR4 RAM!", "INeedToUpgrade"};
        String[] actualOutput = StringEncryptor.decryptVigenereCipher(ciphertext, "INeedToUpgrade");
        assertArrayEquals(expectedOutput, actualOutput);
    }
}
