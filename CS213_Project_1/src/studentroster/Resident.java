package studentroster;
public class Resident extends Student{

    // extends student class
    private int scholarship;
    public Resident(Profile profile, String major,int creditCompleted,int s){
        super( profile,  major, creditCompleted);
        this.scholarship = s;
    }

    public double tuitionDue(int creditsEnrolled){

    }

}
