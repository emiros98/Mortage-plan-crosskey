import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CalculatorTest {
    Calculator c;
    ArrayList<String> prospect1;
    ArrayList<String> prospect2;
    ArrayList<String> prospect3;

    @BeforeEach
    void setUp() throws Exception {
        c = new Calculator();
        String[] a = {"alpha", "1000", "5", "2"};
        String[] b = {"beta", "0", "2", "10000"};
        String[] c = {"", "12", "1200", "1"};
        prospect1 = new ArrayList<>(List.of(a));
        prospect2 = new ArrayList<>(List.of(b));
        prospect3 = new ArrayList<>(List.of(c));
    }

    @Test
    public void testCalculate() {
        assertEquals("alpha wants to borrow 1000.0€ for a period of 2 years and pay 43.87€ each month.", c.calculate(prospect1));
        assertEquals("beta wants to borrow 0.0€ for a period of 10000 years and pay 0.0€ each month.", c.calculate(prospect2));
        assertEquals(" wants to borrow 12.0€ for a period of 1 years and pay 12.0€ each month.", c.calculate(prospect3));
    }


}