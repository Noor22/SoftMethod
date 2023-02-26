package studentroster;

public class EnrollStudent {
    private Profile profile;
    private int creditsEnrolled;

    /**
       Constructor for the EnrollStudent class.
       @param profile
       @param creditsEnrolled
     */
    public EnrollStudent(Profile profile, int creditsEnrolled) {
        this.profile = profile;
        this.creditsEnrolled = creditsEnrolled;
    }

    public boolean equals(){
        return true;
    }

    public String toString(){
        return "";
    }
}
