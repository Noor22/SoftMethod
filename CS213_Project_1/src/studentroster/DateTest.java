package studentroster;

import static org.junit.Assert.*;

public class DateTest {

    @org.junit.Test
    public void isValid_daysInFeb_NonLeap() {
        Date date = new Date("2/29/2003");   // required case 2/29/2003.
        assertFalse(date.isValid());
    }

    @org.junit.Test
    public void isValid_daysInFeb_Leap() {
        Date date = new Date("2/29/2016");
        assertTrue(date.isValid());
    }

    @org.junit.Test
    public void isValid_InValid_daysInFeb_Leap() {
        Date date = new Date("2/0/2016");
        assertFalse(date.isValid());
    }

    @org.junit.Test
    public void isValid_within30Days() {
        Date date = new Date("4/1/2003");
        assertTrue(date.isValid());
    }

    @org.junit.Test
    public void isValid_inValid_Day30() {
        Date date = new Date("4/31/2003"); //required test case

        assertFalse(date.isValid());
    }

    @org.junit.Test
    public void isValid_inValid_Day31() {
        Date date = new Date("3/32/2003"); //required test case

        assertFalse(date.isValid());
    }

    @org.junit.Test
    public void isValid_inValid_Month() {
        Date date = new Date("13/31/2003");  // required case 13/31/2003
        Date date2 = new Date("-1/31/2003"); //required test case

        assertFalse(date2.isValid());
        assertFalse(date.isValid());
    }
}