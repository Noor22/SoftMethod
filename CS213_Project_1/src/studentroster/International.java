package studentroster;

public class International extends NonResident {
    // extends NonResident class
    private boolean isStudyAbroad;
    public International(Profile profile, String major,int creditCompleted){
        super(profile,  major, creditCompleted);
    }
}
