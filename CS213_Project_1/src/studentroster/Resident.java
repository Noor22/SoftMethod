package studentroster;
public class Resident extends Student{
    private int scholarship;

    public Resident(Profile profile, String major,int creditCompleted){
        super(profile, major, creditCompleted);
        int scholarship = 0;
    }

    @Override
    public double tuitionDue(int creditsEnrolled){
        double tuition;
        int exCred = (int)(creditsEnrolled - TuitionValues.ADDITIONAL_MAX.getValue());
        if(exCred < 0)
            exCred = 0;
        if(creditsEnrolled >= 12 ){ // full time student
            tuition = TuitionValues.FULL_RESIDENT_BASE.getValue() + TuitionValues.FULL_UNIVERSITY_FEE.getValue()
                    + TuitionValues.ADDITIONAL_RESIDENT_RATE.getValue() * exCred - scholarship;
        }else{
            tuition = TuitionValues.PART_RESIDENT_RATE.getValue() * creditsEnrolled
                    + TuitionValues.PART_UNIVERSITY_FEE.getValue()-scholarship;
        }
        return tuition;
    }

    @Override
    public boolean isResident() {
        return true;
    }
}
