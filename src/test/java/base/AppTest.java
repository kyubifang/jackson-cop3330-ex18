package base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    public void output_string_includes_type_and_convert() {
        App myApp = new App();
        String type = "C";
        int temp = 32;
        int convert = (temp - 32) * 5 / 9;
        String expectedOutput = "The temperature in Celsius is 0.";
        String actualOutput = myApp.generateOutputString(type, convert);

        assertEquals(expectedOutput, actualOutput);
    }
}