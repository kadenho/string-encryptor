package kadenho.ciphers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DecryptCaesarCipherTest {
    @Test
    public void lowercaseLettersShiftOne() {
        String ciphertext = "uijtjtnztusjoh";
        String[] expectedOutput = {"thisismystring", "1"};
        String[] actualOutput = CaesarCipher.decrypt(ciphertext, 1);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseLettersShiftTen() {
        String ciphertext = "qycokrkguc";
        String[] expectedOutput = {"goseahawks", "10"};
        String[] actualOutput = CaesarCipher.decrypt(ciphertext, 10);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseLettersShiftTwentyFive() {
        String ciphertext = "gdkknvnqkc";
        String[] expectedOutput = {"helloworld", "25"};
        String[] actualOutput = CaesarCipher.decrypt(ciphertext, 25);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseShiftOneWithSpaces() {
        String ciphertext = "tpvui tjpvy djuz";
        String[] expectedOutput = {"south sioux city", "1"};
        String[] actualOutput = CaesarCipher.decrypt(ciphertext, 1);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseShiftTenWithSpaces() {
        String ciphertext = "vsxmyvx xo";
        String[] expectedOutput = {"lincoln ne", "10"};
        String[] actualOutput = CaesarCipher.decrypt(ciphertext, 10);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseShiftTwentyFiveWithSpaces() {
        String ciphertext = "fn ahf qdc";
        String[] expectedOutput = {"go big red", "25"};
        String[] actualOutput = CaesarCipher.decrypt(ciphertext, 25);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseShiftOneWithSpaces() {
        String ciphertext = "Uijt jt nz uftu";
        String[] expectedOutput = {"This is my test", "1"};
        String[] actualOutput = CaesarCipher.decrypt(ciphertext, 1);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseShiftTenWithSpaces() {
        String ciphertext = "Wi qykd sc Volbyx";
        String[] expectedOutput = {"My goat is Lebron", "10"};
        String[] actualOutput = CaesarCipher.decrypt(ciphertext, 10);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseShiftTwentyFiveWithSpaces() {
        String ciphertext = "BgzsFOS vhkk mns szjd lx ina";
        String[] expectedOutput = {"ChatGPT will not take my job", "25"};
        String[] actualOutput = CaesarCipher.decrypt(ciphertext, 25);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseShiftOneWithMixCharacters() {
        String ciphertext = "Nz gbwpsjuf nbui tzncpm jt +, cvu = jt dppm upp. Epo'u gpshfu bcpvu ^ & %, boe ftqfdjbmmz opu # ps $!";
        String[] expectedOutput = {"My favorite math symbol is +, but = is cool too. Don't forget about ^ & %, and especially not # or $!", "1"};
        String[] actualOutput = CaesarCipher.decrypt(ciphertext, 1);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseShiftTenWithMixCharacters() {
        String ciphertext = "Rovvy! S @w ecsxq cywo {*czomskv*}->mrkbkmdobc<-xyg, gyevn iye vsuo dy dbi?:)";
        String[] expectedOutput = {"Hello! I @m using some {*special*}->characters<-now, would you like to try?:)", "10"};
        String[] actualOutput = CaesarCipher.decrypt(ciphertext, 10);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseShiftTwentyFiveWithMixCharacters() {
        String ciphertext = "M0v 1 4l f01mf s0 b0tms c0vm eq0l s3m, m1m3, 31fg7, 23u3m, 21w, e1u3, e0tq, sgq33, sv0, 0m3, y3q0!";
        String[] expectedOutput = {"N0w 1 4m g01ng t0 c0unt d0wn fr0m t3n, n1n3, 31gh7, 23v3n, 21x, f1v3, f0ur, thr33, tw0, 0n3, z3r0!", "25"};
        String[] actualOutput = CaesarCipher.decrypt(ciphertext, 25);
        assertArrayEquals(expectedOutput, actualOutput);
    }
}
