package studentroster;

public class International extends NonResident {
    private boolean isStudyAbroad;

    public International(Profile profile, String major,int creditCompleted, boolean isStudyAbroad){
        super(profile,  major, creditCompleted);
        this.isStudyAbroad = isStudyAbroad;
    }

    public double tuitionDue(int creditsEnrolled){
        double tuition;
        if(isStudyAbroad) {
             tuition = super.tuitionDue(creditsEnrolled); // uses nonresident tuition as a base
                tuition += TuitionValues.HEALTH_INSURANCE_FEE.getValue();
        }else{
             tuition = TuitionValues.FULL_UNIVERSITY_FEE.getValue() + TuitionValues.HEALTH_INSURANCE_FEE.getValue();
        }
        return tuition;
    }

    @Override
    public boolean isValid(int creditEnrolled) {
        if(!super.isValid(creditEnrolled)){
            return false;
        }else if(creditEnrolled >= TuitionValues.FULL_TIME_MIN.getValue() && isStudyAbroad){
            return false;
        }else if(creditEnrolled < TuitionValues.FULL_TIME_MIN.getValue() && !isStudyAbroad){
            return false;
        }
        return true;
    }

    @Override
    public boolean isResident() {
        return super.isResident();
    }
}
