package studentroster;

public class TriState extends NonResident{
    private String state;

    public TriState(Profile profile, String major,int creditCompleted,String s){
        super( profile,  major, creditCompleted);
        this.state = s;
    }

    public double tuitionDue(int creditsEnrolled){
        double tuition;
        tuition = super.tuitionDue(creditsEnrolled); // uses nonresident tuition as a base
        if(state.equals("NY")){
            tuition -= 4000;
        } else if (state.equals("CT")) {
            tuition -= 5000;
        }
        return tuition;
    }

    @Override
    public boolean isResident() {
        return super.isResident();
    }

    @Override
    public boolean isValid(int creditEnrolled) {
        return super.isValid(creditEnrolled);
    }
}
