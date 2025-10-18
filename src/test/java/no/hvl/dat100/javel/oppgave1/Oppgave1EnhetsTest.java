package no.hvl.dat100.javel.oppgave1;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

@Timeout(30)
class Oppgave1EnhetsTest {

    static double[] test_powerprices;
    static double[] test_powerusage;
    static String text_printPowerPrices = "0,49 NOK 0,43 NOK 0,40 NOK 0,77 NOK 0,88 NOK 0,87 NOK 1,00 NOK 0,93 NOK 2,23 NOK 1,17 NOK 1,21 NOK 1,54 NOK 1,50 NOK 1,69 NOK 1,78 NOK 1,74 NOK 1,85 NOK 1,93 NOK 2,00 NOK 2,25 NOK 1,89 NOK 1,12 NOK 0,76 NOK 0,34 NOK";
    static String text_printPowerUsage = "0,62 kWh 0,42 kWh 0,58 kWh 0,63 kWh 0,68 kWh 0,67 kWh 2,36 kWh 2,08 kWh 2,20 kWh 1,39 kWh 1,19 kWh 1,15 kWh 1,22 kWh 1,09 kWh 1,03 kWh 1,22 kWh 2,69 kWh 2,99 kWh 2,48 kWh 2,47 kWh 1,06 kWh 1,00 kWh 0,80 kWh 0,97 kWh";

    private ByteArrayOutputStream print_out = new ByteArrayOutputStream();
    private PrintStream original_out;

    @BeforeEach
    public void initEach() {

        test_powerprices = new double[]{
            0.49, 0.43, 0.4, 0.77, 0.88, 0.87,
            1.0, 0.93, 2.23, 1.17, 1.21, 1.54,
            1.50, 1.69, 1.78, 1.74, 1.85, 1.93,
            2.0, 2.25, 1.89, 1.12, 0.76, 0.34
        };

        test_powerusage = new double[]{
            0.62, 0.42, 0.58, 0.63, 0.68, 0.67,
            2.36, 2.08, 2.20, 1.39, 1.19, 1.15,
            1.22, 1.09, 1.03, 1.22, 2.69, 2.99,
            2.48, 2.47, 1.06, 1.0, 0.8, 0.97
        };

        original_out = System.out;
        System.setOut(new PrintStream(print_out));
    }

    @AfterEach
    void restoreSystemOut() {
        System.setOut(original_out);
    }

    // oppgave a)
    @Test
    void testPrintPowerPrices() {
        DailyPower.printPowerPrices(test_powerprices);
        String result = print_out.toString();
        assertEquals(text_printPowerPrices.trim(), result.trim());
    }

    // oppgave b)
    @Test
    void testPrintPowerUsage() {
        DailyPower.printPowerUsage(test_powerusage);
        String result = print_out.toString();
        assertEquals(text_printPowerUsage.trim(), result.trim());
    }

    // oppgave c)
    @Test
    void testComputePowerUsage() {
        double sum = 32.99;
        double t_sum = DailyPower.computePowerUsage(test_powerusage);
        assertEquals(sum, t_sum);
    }

    // oppgave d)
    @Test
    void testComputeSpotPrice() {
        double spotprice = 49.37;
        double m_spotprice = DailyPower.computeSpotPrice(test_powerusage, test_powerprices);
        assertEquals(spotprice, m_spotprice);
    }

    // oppgave e) - f)
    @Test
    void testComputePowerSupport() {
        double power_support = 27.95;
        double t_power_support = DailyPower.computePowerSupport(test_powerusage, test_powerprices);
        assertEquals(power_support, t_power_support);
    }

    // oppgave g)
    @Test
    void testComputeNorgesPrice() {
        double total_price = 16.49;
        double t_total_price = DailyPower.computeNorgesPrice(test_powerusage);
        assertEquals(total_price, t_total_price);
    }

    // oppgave h) 
    @Test
    void testFindPeakUsage() {
        double peak_usage = 2.99;
        double t_peak_usage = DailyPower.findPeakUsage(test_powerusage);
        assertEquals(peak_usage, t_peak_usage);
    }

    // oppgave i)
    @Test
    void testFindAvgPower() {
        double average = 1.37;
        double t_average = DailyPower.findAvgPower(test_powerusage);
        assertEquals(average, t_average);
    }
}
