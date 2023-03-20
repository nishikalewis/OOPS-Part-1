package edu.umb.cs680.hw02;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class SingletonPrimeGeneratorTest {

    private SingletonPrimeGenerator actual= SingletonPrimeGenerator.getInstance(1,20);


    @Test
    void verify_values(){
        actual.generatePrimes();
        assertNotNull(actual);
    }

    @Test
    void verify_instances(){
        SingletonPrimeGenerator expected=SingletonPrimeGenerator.getInstance(2,30);
        assertEquals(actual,expected);
    }

    @Test
    void verify_primes(){
        actual.generatePrimes();
        Long[] expectedp={2L,3L,5L,7L,11L,13L,17L,19L};
        assertIterableEquals(Arrays.asList(expectedp), actual.getPrimes());
    }

    @Test
    void verify_exceptions(){
        try {
            SingletonPrimeGenerator c = SingletonPrimeGenerator.getInstance(-70, -1);
        } catch (Exception e) {

            assertEquals("Wrong input values: from=-70 to=-1", e.getMessage());
        }

    }

}