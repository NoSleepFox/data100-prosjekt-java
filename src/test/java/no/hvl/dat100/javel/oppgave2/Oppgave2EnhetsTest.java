package no.hvl.dat100.javel.oppgave2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

@Timeout(30)
class Oppgave2EnhetsTest {

    static double[][] powerusage_month;
    static double[][] powerprices_month;

    @BeforeEach
    public void init() {
        powerusage_month = new double[][]{
            {0.31, 0.36, 0.45, 0.36, 0.43, 0.31, 2.01, 2.27, 2.13, 0.82, 0.98, 0.86, 0.8, 0.82, 0.84, 0.96, 1.1, 2.76, 2.53, 2.3, 2.89, 0.73, 0.8, 0.69},
            {0.3, 0.46, 0.47, 0.43, 0.42, 0.42, 2.37, 2.13, 2.33, 1.08, 0.94, 0.82, 1.2, 1.06, 1.02, 1.14, 0.83, 2.37, 2.45, 2.88, 2.5, 0.62, 0.66, 0.91}
        };
        powerprices_month = new double[][]{
            {2.12, 2.11, 2.19, 1.68, 1.85, 2.07, 6.64, 5.43, 5.56, 5.95, 2.14, 2.13, 1.2, 1.99, 1.3, 2.03, 1.62, 5.58, 4.37, 5.59, 3.94, 1.91, 2.41, 2.37},
            {2.43, 1.7, 1.37, 1.32, 1.39, 1.58, 5.82, 6.38, 5.04, 6.14, 1.95, 1.6, 2.11, 1.42, 1.39, 1.79, 1.83, 5.57, 4.58, 5.83, 4.52, 1.47, 1.46, 2.05}
        };
    }

    @Test
    public void testComputePowerUsage() {
        double sum = 58.32;
        assertEquals(sum, MonthlyPower.computePowerUsage(powerusage_month));
    }

    @Test
    public void testExceedThreshold() {
        double exceed_num = 50;
        boolean exceeded = MonthlyPower.exceedThreshold(powerusage_month, exceed_num);
        assertEquals(true, exceeded);
    }

    @Test
    public void testComputeSpotPrice() {
        double total = 231.98;
        double t_total = MonthlyPower.computeSpotPrice(powerusage_month, powerprices_month);
        assertEquals(total, t_total);
    }

    @Test
    public void testComputePowerSupport() {
        double total = 170.9;
        double t_total = MonthlyPower.computePowerSupport(powerusage_month, powerprices_month);
        assertEquals(total, t_total);

    }

    @Test
    public void testComputeNorgesPrice() {
        double total = 29.17;
        double t_total = MonthlyPower.computeNorgesPrice(powerusage_month);
        assertEquals(total, t_total);

    }
}
