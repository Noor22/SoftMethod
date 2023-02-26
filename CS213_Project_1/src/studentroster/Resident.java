package studentroster;
public class Resident extends Student{

    // extends student class
    private int scholarship;
    public Resident(Profile profile, String major,int creditCompleted){
        super( profile,  major, creditCompleted);
    }

    public double tuitionDue(int creditsEnrolled){

    }

    public void setScholarship(int scholarship) {
        this.scholarship = scholarship;
    }

}
