package kadenho.ciphers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class EncryptCaesarCipherTest {
    @Test
    public void lowercaseLettersShiftOne() {
        String plaintext = "thisismystring";
        String[] expectedOutput = {"uijtjtnztusjoh", "1"};
        String[] actualOutput = CaesarCipher.encrypt(plaintext, 1);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseLettersShiftTen() {
        String plaintext = "goseahawks";
        String[] expectedOutput = {"qycokrkguc", "10"};
        String[] actualOutput = CaesarCipher.encrypt(plaintext, 10);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseLettersShiftTwentyFive() {
        String plaintext = "helloworld";
        String[] expectedOutput = {"gdkknvnqkc", "25"};
        String[] actualOutput = CaesarCipher.encrypt(plaintext, 25);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseShiftOneWithSpaces() {
        String plaintext = "south sioux city";
        String[] expectedOutput = {"tpvui tjpvy djuz", "1"};
        String[] actualOutput = CaesarCipher.encrypt(plaintext, 1);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseShiftTenWithSpaces() {
        String plaintext = "lincoln ne";
        String[] expectedOutput = {"vsxmyvx xo", "10"};
        String[] actualOutput = CaesarCipher.encrypt(plaintext, 10);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseShiftTwentyFiveWithSpaces() {
        String plaintext = "go big red";
        String[] expectedOutput = {"fn ahf qdc", "25"};
        String[] actualOutput = CaesarCipher.encrypt(plaintext, 25);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseShiftOneWithSpaces() {
        String plaintext = "This is my test";
        String[] expectedOutput = {"Uijt jt nz uftu", "1"};
        String[] actualOutput = CaesarCipher.encrypt(plaintext, 1);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseShiftTenWithSpaces() {
        String plaintext = "My goat is Lebron";
        String[] expectedOutput = {"Wi qykd sc Volbyx", "10"};
        String[] actualOutput = CaesarCipher.encrypt(plaintext, 10);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseShiftTwentyFiveWithSpaces() {
        String plaintext = "ChatGPT will not take my job";
        String[] expectedOutput = {"BgzsFOS vhkk mns szjd lx ina", "25"};
        String[] actualOutput = CaesarCipher.encrypt(plaintext, 25);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseShiftOneWithMixCharacters() {
        String plaintext = "My favorite math symbol is +, but = is cool too. Don't forget about ^ & %, and especially not # or $!";
        String[] expectedOutput = {"Nz gbwpsjuf nbui tzncpm jt +, cvu = jt dppm upp. Epo'u gpshfu bcpvu ^ & %, boe ftqfdjbmmz opu # ps $!", "1"};
        String[] actualOutput = CaesarCipher.encrypt(plaintext, 1);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseShiftTenWithMixCharacters() {
        String plaintext = "Hello! I @m using some {*special*}->characters<-now, would you like to try?:)";
        String[] expectedOutput = {"Rovvy! S @w ecsxq cywo {*czomskv*}->mrkbkmdobc<-xyg, gyevn iye vsuo dy dbi?:)", "10"};
        String[] actualOutput = CaesarCipher.encrypt(plaintext, 10);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseShiftTwentyFiveWithMixCharacters() {
        String plaintext = "N0w 1 4m g01ng t0 c0unt d0wn fr0m t3n, n1n3, 31gh7, 23v3n, 21x, f1v3, f0ur, thr33, tw0, 0n3, z3r0!";
        String[] expectedOutput = {"M0v 1 4l f01mf s0 b0tms c0vm eq0l s3m, m1m3, 31fg7, 23u3m, 21w, e1u3, e0tq, sgq33, sv0, 0m3, y3q0!", "25"};
        String[] actualOutput = CaesarCipher.encrypt(plaintext, 25);
        assertArrayEquals(expectedOutput, actualOutput);
    }
}