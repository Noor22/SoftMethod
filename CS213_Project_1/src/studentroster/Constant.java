package studentroster;

/**
 The Constant Enum class stores all the variables
 with constant values in order to preserve adequate
 coding standards.
 @author Dylan Turner, Noor Hasan
 */

public enum Constant {
    //Leap Year dividing numbers
    QUADRENNIAL(4),
    CENTENNIAL (100),
    QUATERCENTENNIAL (400),
    MAX_MONTH(12),
    MIN_MONTH(0),
    MAX_DAY(31),
    MIN_DAY(0),
    FEB_MAX(28),
    FEBRUARY (2),
    APRIL (4),
    JUNE (6),
    SEPTEMBER (9),
    NOVEMBER (11),
    INITIAL_SIZE (4),
    ENROLLMENT_INITIAL (1),
    NOT_FOUND (-1),
    MINIMUM_AGE (16),
    UNDEFINED_CREDITS (0),
    DATE_TESTS(5),
    STUDENT_TESTS (2);

    private final int value;

    /**
       Creates the constant
       @param value the corresponding value.
     */
    Constant(int value){
        this.value = value;
    }
    /**
       Getter method for the constants.
       @return the value of the specified constant.
     */
    public int getValue(){
        return this.value;
    }
}
