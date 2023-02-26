package studentroster;

public class NonResident extends Student {

    public NonResident(Profile profile, String major,int creditCompleted){
        super( profile,  major, creditCompleted);
    }

    public double tuitionDue(int creditsEnrolled){
        double tuition;
        int exCred = (int)(creditsEnrolled - TuitionValues.ADDITIONAL_MAX.getValue());
        if(exCred < 0)
            exCred = 0;
        if(creditsEnrolled >= 12 ){ // full time student
            tuition = TuitionValues.FULL_NONRESIDENT_BASE.getValue() + TuitionValues.FULL_UNIVERSITY_FEE.getValue()
                    + TuitionValues.ADDITIONAL_NONRESIDENT_RATE.getValue() * exCred ;
        }else{
            tuition = TuitionValues.ADDITIONAL_NONRESIDENT_RATE.getValue() * creditsEnrolled
                    + TuitionValues.PART_UNIVERSITY_FEE.getValue();
        }
        return tuition;
    }

    @Override
    public boolean isResident() {
        return false;
    }
}
