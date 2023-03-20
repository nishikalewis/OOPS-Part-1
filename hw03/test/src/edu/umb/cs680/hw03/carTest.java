package edu.umb.cs680.hw03;
import edu.umb.cs680.hw03.car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class carTest {
    private String[] carToStringArray(car cta){

        int yrr=cta.getYear();
        String[] xyz = new String[]{cta.getMake(), cta.getModel(),String.valueOf(yrr)};
        return xyz;
    }

    @Test
    void VerifyCarEqualityWithMakeModelYear(){
        String[] expected_v=new String[]{"Toyota","RAV4","2018"};
        car actual_v=new car("Toyota","RAV4",2018,16,30000);
        assertArrayEquals(expected_v,carToStringArray(actual_v));
        String[] expected_2=new String[]{"ABC","XYZ","2022"};
        car actual_2=new car("ABC","XYZ",2022,19,43200);
        assertArrayEquals(expected_2,carToStringArray(actual_2));
    }


}