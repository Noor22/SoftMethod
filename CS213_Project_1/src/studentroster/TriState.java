package studentroster;

public class TriState extends NonResident{

    // extends NonResident class
    private String state;
    public TriState(Profile profile, String major,int creditCompleted,String s){
        super( profile,  major, creditCompleted);
        this.state = s;
    }
}
