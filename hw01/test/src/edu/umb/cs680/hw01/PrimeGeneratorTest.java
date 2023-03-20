package edu.umb.cs680.hw01;
import edu.umb.cs680.hw01.PrimeGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeGeneratorTest {
    @Test
    public void positive_to_positive_case() {
        PrimeGenerator c = new PrimeGenerator(1, 71);
        c.generatePrimes();
        Long[] expectedPrimes = {2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L, 31L, 37L, 41L, 43L, 47L, 53L, 59L, 61L, 67L,71L};
        assertArrayEquals(expectedPrimes, c.getPrimes().toArray());

    }

    @Test
    public void negative_to_negative_case() {
        try {
            PrimeGenerator c = new PrimeGenerator(-77, -1);
        } catch (Exception e) {

            assertEquals("Wrong input values: from=-77 to=-1", e.getMessage());
        }

    }


    @Test
    public void negative_to_positive_case() {
        try {
            PrimeGenerator c = new PrimeGenerator(-2, 70);
        } catch (Exception e) {

            assertEquals("Wrong input values: from=-2 to=70", e.getMessage());
        }
    }

    @Test
    public void zero_case() {
        try {
            PrimeGenerator c = new PrimeGenerator(0, 0);
        }
        catch(Exception e){

            assertEquals("Wrong input values: from=0 to=0" ,e.getMessage());
        }
    }

}
