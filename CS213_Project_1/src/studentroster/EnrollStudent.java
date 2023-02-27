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

    public boolean equals(EnrollStudent otherEnroll){
        return (this.profile.equals(otherEnroll.profile));
    }

    public String toString(){
        return (this.profile.toString() + " " + this.creditsEnrolled);
    }

    public int getCreditsEnrolled(){
        return this.creditsEnrolled;
    }

    public void setCreditsEnrolled(int creditsEnrolled) {
        this.creditsEnrolled = creditsEnrolled;
    }

    public Profile getProfile() {
        return profile;
    }
}
