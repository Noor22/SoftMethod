package studentroster;

/**
 The Tuition Values Enum class stores all the costs
 for each type of student.
 @author Dylan Turner, Noor Hasan
 */
public enum TuitionValues {
    //Table Values
    FULL_RESIDENT_BASE (12536),
    FULL_NONRESIDENT_BASE (29737),
    FULL_UNIVERSITY_FEE (3268),
    HEALTH_INSURANCE_FEE (2650),
    PART_RESIDENT_RATE (404),
    NONRESIDENT_RATE (966),
    PART_UNIVERSITY_FEE (2614.4), //80% Full University Fee
    ADDITIONAL_RESIDENT_RATE (404),
    ADDITIONAL_NONRESIDENT_RATE (966),

    //Max and Min Credits Values
    MAX_CREDITS (24),
    MIN_CREDITS (3),
    ABROAD_MAX_CREDITS (12),
    INTERNAL_MIN_CREDITS (12),
    ADDITIONAL_MAX (16),
    FULL_TIME_MIN (12),

    MAX_SCHOLARSHIP (10000),
    NEW_YORK_DISCOUNT (4000),
    CONNECTICUT (5000);

    private final double value;

    /**
     Creates the constant
     @param value the corresponding value.
     */
    TuitionValues(double value){
        this.value = value;
    }
    /**
     Getter method for the constants.
     @return the value of the specified constant.
     */
    public double getValue(){
        return this.value;
    }
}
