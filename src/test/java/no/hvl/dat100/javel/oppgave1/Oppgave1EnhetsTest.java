package no.hvl.dat100.javel.oppgave1;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

@Timeout(30)
class Oppgave1EnhetsTest {

    static double[] test_powerprices;
    static double[] test_powerusage;
    static String text_printPowerPrices = "0,10 NOK 0,20 NOK 0,30 NOK 0,40 NOK 0,50 NOK 0,60 NOK 0,70 NOK 0,80 NOK 1,90 NOK 1,00 NOK 1,10 NOK 1,20 NOK 1,30 NOK 1,40 NOK 1,50 NOK 1,60 NOK 1,70 NOK 1,80 NOK 1,90 NOK 2,00 NOK 1,50 NOK 1,00 NOK 0,50 NOK 0,10 NOK";

    @BeforeEach
    public void initEach() {
        test_powerprices = DayPowerData.powerprices_day;
        test_powerusage = DayPowerData.powerusage_day;

    }

    // oppgave a)
    @Test
    void testPrintPowerPrices() {
        ByteArrayOutputStream print_out = new ByteArrayOutputStream();
        PrintStream original_out = System.out;
        System.setOut(new PrintStream(print_out));

        DailyPower.printPowerPrices(test_powerprices);

        System.setOut(original_out);

        String result = print_out.toString();
        assertEquals(text_printPowerPrices.trim(), result.trim());
    }

    // oppgave b)
}
