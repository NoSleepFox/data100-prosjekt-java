package no.hvl.dat100.javel.oppgave2;

import no.hvl.dat100.javel.oppgave1.DailyPower;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Oppgave2EnhetsTest {

    // Testdata (enkle tall å regne med)
    private final double[][] usage = {
            {1.0, 2.0, 3.0},   // Dag 1 -> 6.0
            {0.5, 1.5, 2.0}    // Dag 2 -> 4.0  => Totalt 10.0 kWh
    };

    private final double[][] prices = {
            {1.0, 2.0, 3.0},   // Dag 1 spotpris = 1*1 + 2*2 + 3*3 = 14
            {2.0, 2.0, 1.0}    // Dag 2 spotpris = 0.5*2 + 1.5*2 + 2*1 = 5
    };                     // Totalt spotpris = 19 NOK

    private static final double EPS = 1e-9;

    // -----------------------------------------------------------
    // c) computePowerUsage
    // -----------------------------------------------------------
    @Test
    void computePowerUsage_summererHeleMaaneden() {
        double total = MonthlyPower.computePowerUsage(usage);
        assertEquals(10.0, total, EPS,
                "Forbruk for måneden skal bli summen av alle verdiene (10.0 kWh)");
    }

    // -----------------------------------------------------------
    // d) exceedThreshold
    // -----------------------------------------------------------
    @Test
    void exceedThreshold_underGrenseGirFalse() {
        boolean exceeded = MonthlyPower.exceedThreshold(usage, 5000);
        assertFalse(exceeded, "Skal ikke overstige 5000 kWh-grensen");
    }

    @Test
    void exceedThreshold_overGrenseGirTrue() {
        boolean exceeded = MonthlyPower.exceedThreshold(usage, 5);
        assertTrue(exceeded, "Skal overstige 5 kWh-grensen (bruk 10 kWh totalt)");
    }

    // -----------------------------------------------------------
    // e) computeSpotPrice
    // -----------------------------------------------------------
    @Test
    void computeSpotPrice_beregnerRiktigPris() {
        double totalPrice = MonthlyPower.computeSpotPrice(usage, prices);
        assertEquals(20.0, totalPrice, EPS,
                "Totalt beløp for måneden (uten støtte) skal bli 19.0 NOK");
    }

    // f) computePowerSupport

    @Test
    void computePowerSupport_aggregererDagligStotte() {

        double expected = DailyPower.computePowerSupport(usage[0], prices[0])
                + DailyPower.computePowerSupport(usage[1], prices[1]);

        double actual = MonthlyPower.computePowerSupport(usage, prices);

        assertEquals(expected, actual, EPS,
                "Månedsstøtte skal være summen av daglig støtte");
    }

    // -----------------------------------------------------------
    // g) computeNorgesPrice
    // -----------------------------------------------------------
    @Test
    void computeNorgesPrice_beregnerRiktigMedDagensMetode() {
        // Her bruker DailyPower.computeNorgesPrice dagens konstante 0.5 NOK per kWh
        // så totalen blir totalForbruk (10.0) * 0.5 = 5.0 NOK
        double norgespris = MonthlyPower.computeNorgesPrice(usage);
        assertEquals(5.0, norgespris, EPS,
                "Norgespris for måneden skal bli 5.0 NOK (10 kWh * 0.5)");
    }

    // -----------------------------------------------------------
    // a) + b) (ikke returnerer noe, kun skriver ut)
    // -----------------------------------------------------------
    // Disse kan ikke testes direkte uten å fange System.out,
    // men vi kan sjekke at de ikke kaster unntak:
    @Test
    void printPowerUsage_kasterIkkeUnntak() {
        assertDoesNotThrow(() -> MonthlyPower.print_PowerUsage(usage));
    }

    @Test
    void printPowerPrices_kasterIkkeUnntak() {
        assertDoesNotThrow(() -> MonthlyPower.print_PowerPrices(prices));
    }
}



