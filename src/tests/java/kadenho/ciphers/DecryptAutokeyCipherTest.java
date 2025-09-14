package kadenho.ciphers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DecryptAutokeyCipherTest {
    @Test
    public void lowercaseTextLowercaseShorterKey() {
        String plaintext = "emooegscx";
        String[] expectedOutput = {"pepperoni", "pizza"};
        String[] actualOutput = AutokeyCipher.decrypt(plaintext, "pizza");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseTextMixcaseShorterKey() {
        String plaintext = "nuzrpxeqxrtqrf";
        String[] expectedOutput = {"panfriedsalmon", "Yummy"};
        String[] actualOutput = AutokeyCipher.decrypt(plaintext, "Yummy");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseTextLowercaseShorterKey() {
        String plaintext = "XbpedEnoysg";
        String[] expectedOutput = {"FiletMignon", "steaks"};
        String[] actualOutput = AutokeyCipher.decrypt(plaintext, "steaks");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseTextMixcaseShorterKey() {
        String plaintext = "ALzvhKccpxqeg";
        String[] expectedOutput = {"ILoveCroutons", "salad"};
        String[] actualOutput = AutokeyCipher.decrypt(plaintext, "salad");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedTextLowercaseShorterKey() {
        String plaintext = "j lunm evz eeiym tnggvufs";
        String[] expectedOutput = {"i love the album immunity", "bags"};
        String[] actualOutput = AutokeyCipher.decrypt(plaintext, "bags");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedTextMixcaseShorterKey() {
        String plaintext = "i mzwp rmawdm cmkp djtvq";
        String[] expectedOutput = {"i also really like sling", "Amoeba"};
        String[] actualOutput = AutokeyCipher.decrypt(plaintext, "Amoeba");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedTextLowercaseShorterKey() {
        String plaintext = "Hfh flx cy tc xnjkscms nppzyq ns yswqgmtpms Ozijp";
        String[] expectedOutput = {"But one of my favorite albums is definitely Charm", "glorytothesnow"};
        String[] actualOutput = AutokeyCipher.decrypt(plaintext, "glorytothesnow");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedTextMixcaseShorterKey() {
        String plaintext = "Vysjw gg u Jtmyor LT fyb lhsa M wtii";
        String[] expectedOutput = {"There is a Shelly EP out that I like", "CrossYourMind"};
        String[] actualOutput = AutokeyCipher.decrypt(plaintext, "CrossYourMind");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedMixCharTextLowercaseShorterKey() {
        String plaintext = "nm blhmwios sztre ff vqgyial kazte ie...suqf!";
        String[] expectedOutput = {"my favorite brand of instant raman is...shin!", "bowl"};
        String[] actualOutput = AutokeyCipher.decrypt(plaintext, "bowl");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedMixCharTextMixcaseShorterKey() {
        String plaintext = "j wtdh vwjok dwfr rgjkvv! t vnzi npln t wkuk vs gbye 2-uabhece. ig fxekt 3 ftrulxe qf vxxlmj.";
        String[] expectedOutput = {"i wish songs were longer! i hate when a song is only 2-minutes. at least 3 minutes is better.", "Ballad"};
        String[] actualOutput = AutokeyCipher.decrypt(plaintext, "Ballad");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedMixCharTextLowercaseShorterKey() {
        String plaintext = "Eznkvf, Uglbiucpfef, Lditfc, Wlblnry Uasgmatgr, rch Fnoz Wnwwlrwqsx eil as xevfvurj sdbxmkw!";
        String[] expectedOutput = {"Clairo, Beabadoobee, Laufey, Sabrina Carpenter, and Suki Waterhouse are my favorite singers!", "concert"};
        String[] actualOutput = AutokeyCipher.decrypt(plaintext, "concert");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedMixCharTextMixcaseShorterKey() {
        String plaintext = "Q hlvg hw dqre vg Vvtkvkw! V nvdg tns jtu xmmf jfmr ypbjj wxths jpmfz vpls lwzk.";
        String[] expectedOutput = {"I want to live in Chicago! I love the big city feel while still being near home.", "Illinois"};
        String[] actualOutput = AutokeyCipher.decrypt(plaintext, "Illinois");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseTextLowercaseLongerKey() {
        String ciphertext = "nvpph";
        String[] expectedOutput = {"hello", "greetings"};
        String[] actualOutput = AutokeyCipher.decrypt(ciphertext, "greetings");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseTextMixcaseLongerKey() {
        String ciphertext = "uwrgw";
        String[] expectedOutput = {"piano", "FORTISSIMO"};
        String[] actualOutput = AutokeyCipher.decrypt(ciphertext, "FORTISSIMO");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseTextLowercaseLongerKey() {
        String ciphertext = "Sypq";
        String[] expectedOutput = {"Duck", "penguin"};
        String[] actualOutput = AutokeyCipher.decrypt(ciphertext, "penguin");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseTextMixcaseLongerKey() {
        String ciphertext = "Tfyrg";
        String[] expectedOutput = {"Bread", "SourDough"};
        String[] actualOutput = AutokeyCipher.decrypt(ciphertext, "SourDough");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedTextLowercaseLongerKey() {
        String ciphertext = "pu abf";
        String[] expectedOutput = {"hi mom", "imonthetv"};
        String[] actualOutput = AutokeyCipher.decrypt(ciphertext, "imonthetv");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedTextMixcaseLongerKey() {
        String ciphertext = "hme wmyrnup";
        String[] expectedOutput = {"the library", "ofAlexandria"};
        String[] actualOutput = AutokeyCipher.decrypt(ciphertext, "ofAlexandria");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedTextLowercaseLongerKey() {
        String ciphertext = "Ehz Wpl Rfexd";
        String[] expectedOutput = {"The Old Guard", "lavieillegarde"};
        String[] actualOutput = AutokeyCipher.decrypt(ciphertext, "lavieillegarde");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedTextMixcaseLongerKey() {
        String ciphertext = "Numprznmkq wy Lsgeetba Gwasi";
        String[] expectedOutput = {"University of Nebraska Omaha", "TheUniversityOfNebraskaLincoln"};
        String[] actualOutput = AutokeyCipher.decrypt(ciphertext, "TheUniversityOfNebraskaLincoln");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedMixCharTextLowercaseLongerKey() {
        String ciphertext = "j fhdp jkgdn!";
        String[] expectedOutput = {"i love bacon!", "butilikepancakestoo"};
        String[] actualOutput = AutokeyCipher.decrypt(ciphertext, "butilikepancakestoo");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedMixCharTextMixcaseLongerKey() {
        String ciphertext = "igv h uw, nrfbv!";
        String[] expectedOutput = {"its a me, mario!", "AndHisBrotherLuigi"};
        String[] actualOutput = AutokeyCipher.decrypt(ciphertext, "AndHisBrotherLuigi");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedMixCharTextLowercaseLongerKey() {
        String ciphertext = "Dc idzouzxh kmbx:";
        String[] expectedOutput = {"My favorite game:", "reddeadredemptiontwo"};
        String[] actualOutput = AutokeyCipher.decrypt(ciphertext, "reddeadredemptiontwo");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedMixCharTextMixcaseLongerKey() {
        String ciphertext = "32OO HHU4 KOG!";
        String[] expectedOutput = {"32GB DDR4 RAM!", "INeedToUpgrade"};
        String[] actualOutput = AutokeyCipher.decrypt(ciphertext, "INeedToUpgrade");
        assertArrayEquals(expectedOutput, actualOutput);
    }
}