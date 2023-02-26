package studentroster;

/**
 Blueprint for student objects, stores their profile, major,
 and the amount of credits completed.
 @author Dylan Turner, Noor Hasan
 */
public abstract class Student implements Comparable<Student> {
    private Profile profile;
    private Major major;
    private int creditCompleted;

    /**
     Constructor for the Student object.
     @param profile the student's profile.
     @param major the student's major.
     @param creditCompleted the amount of credits completed.
     */
    public Student(Profile profile, String major,int creditCompleted) {
        this.profile = profile;
        this.creditCompleted = creditCompleted;
        for (Major allowedMajor: Major.values()){                   //assigned Major enum type based on string input.
            if (major.toUpperCase().equals(allowedMajor.toString())){
                this.major = allowedMajor;
                break;
            }
        }
    }

    /**
     Setter method for the student's major.
     */
    public void setMajor(Major major) {
        this.major = major;
    }

    /**
     Getter method for the student's profile.
     @return this student's profile.
     */
    public Profile getProfile() {
        return profile;
    }

    /**
     Getter method for the student's major.
     @return this student's major.
     */
    public Major getMajor() {
        return this.major;
    }

    /**
       Determines the student's standing based on how many
       credits they have earned.
       @return string representation of student's standing
     */
    public String getStanding(){
        if(this.creditCompleted < 30) {
            return "Freshmen";
        }else if(this.creditCompleted < 60){
            return "Sophomore";
        }else if(this.creditCompleted < 90){
            return "Junior";
        }
        return "Senior";
    }

    /**
     Getter method for the student's credits.
     @return this student's credits completed.
     */
    public int getCredits() {
        return this.creditCompleted;
    }

    /**
     *
     * @param creditEnrolled
     * @return
     */
    public boolean isValid(int creditEnrolled){};

    /**
     *
     * @param creditsEnrolled
     * @return
     */
    public abstract double tuitionDue(int creditsEnrolled);

    /**
     *
     * @return
     */
    public abstract boolean isResident();
    /**
     Converts the student to string representation.
     @return the string representation of this student.
     */
    @Override
    public String toString() {
        return (this.profile.toString() + " " + "(" + this.major.getMajorCode() + " "
                + this.major + " " + this.major.getSchool() + ") "
                + "creditCompleted: " + creditCompleted
                + " " + "(" + this.getStanding() + ")");
    }

    /**
     Determines whether two students are equal.
     @param otherStudent the other student in question.
     @return true if they are equal, false if not.
     */
    @Override
    public boolean equals(Object otherStudent) {
        if (otherStudent instanceof Student student) {
            return ((this.profile.equals(student.getProfile())));
        }
        return false;
    }

    /**
     Checks whether another student should be before or after this student.
     @param student the student to be compared to.
     @return 1 if the other student should be before this one.
     -1 if the other student should be after this one.
     0 if the two students are equal.
     */
    @Override
    public int compareTo(Student student) {
        if(this.profile.equals(student.getProfile())){
            return 0;
        }
        if (this.profile.compareTo(student.getProfile()) < 0) {
            return -1;
        }
        return 1;
    }

    /**
     Helper Method for Testbed Main.
     Creates two students from the test arrays and tests
     whether compareTo() method returns correct output.
     @param lname1 last name array of the first student.
     @param lname2 last name array of the second student.
     @param fname1 first name array of the first student.
     @param fname2 first name array of the second student.
     @param dob1 date of birth array of the first student
     @param dob2 date of birth array of the second student.
     @param test the test number to perform from the design document.
     @param correctOutput what the test should return.
     */
    private static void callTests(String[] lname1, String[] lname2, String[] fname1,
                                  String[] fname2, String[] dob1, String[] dob2,
                                  int test, int correctOutput){
        for (int i = 0; i < Constant.STUDENT_TESTS.getValue(); i++){
            Profile profile1 = new Profile(lname1[i],fname1[i],dob1[i]);
            Profile profile2 = new Profile(lname2[i],fname2[i],dob2[i]);
            Student student1 = new Student(profile1,Major.UNDEFINED.toString(), Constant.UNDEFINED_CREDITS.getValue());
            Student student2 = new Student(profile2,Major.UNDEFINED.toString(), Constant.UNDEFINED_CREDITS.getValue());
            System.out.println("Test #" + test + ", s1: " + fname1[i] + " " + lname1[i]
                    + ", s2: " + fname2[i] + " " + lname2[i] + ".");
            switch (correctOutput){
                case 1:
                    if (student1.compareTo(student2) > 0){
                        System.out.println("   s1.compareTo(s2) returns " + correctOutput
                                + ", Passed: True");
                        System.out.println();
                    }
                    else {
                        System.out.println("   s1.compareTo(s2) returns " + correctOutput
                                + ", Passed: False");
                        System.out.println();
                    }
                    break;
                case -1:
                    if (student1.compareTo(student2) < 0){
                        System.out.println("   s1.compareTo(s2) returns " + correctOutput
                                + ", Passed: True");
                        System.out.println();
                    }
                    else {
                        System.out.println("   s1.compareTo(s2) returns " + correctOutput
                                + ", Passed: False");
                        System.out.println();
                    }
                    break;
                case 0:
                    if (student1.compareTo(student2) == 0){
                        System.out.println("   s1.compareTo(s2) returns " + correctOutput
                                + ", Passed: True");
                        System.out.println();
                    }
                    else {
                        System.out.println("   s1.compareTo(s2) returns " + correctOutput
                                + ", Passed: False");
                        System.out.println();
                    }
            }
        }
    }                       //METHOD TOO LONG, NEED TO MODULIZE.

    /**
       Testbed main for the compareTo() method.
       @param args standard main parameter.
     */
    public static void main (String[] args){
        String[] lname1Test1= {"Lamprich","Hasan"};
        String[] fname1Test1= {"Luke","Noor"};
        String[] lname2Test1= {"Toro","Turner"};
        String[] fname2Test1= {"Isabel","Dylan"};
        String[] dob1Test1 = {"04/16/2003","03/22/2003"};
        String[] dob2Test1 = {"07/22/2003","04/01/2003"};
        callTests(lname1Test1, lname2Test1, fname1Test1, fname2Test1, dob1Test1, dob2Test1
                , 1, -1);

        String[] lname1Test2= {"Toro","Turner"};
        String[] fname1Test2= {"Isabel","Dylan"};
        String[] lname2Test2= {"Lamprich","Hasan"};
        String[] fname2Test2= {"Luke","Noor"};
        String[] dob1Test2 = {"01/01/2000","01/01/2000"};
        String[] dob2Test2 = {"01/01/2000","01/01/2000"};
        callTests(lname1Test2, lname2Test2, fname1Test2, fname2Test2, dob1Test2, dob2Test2
                , 2, 1);

        String[] lname1Test3= {"Doe","Hasan"};
        String[] fname1Test3= {"Jane","Anna"};
        String[] lname2Test3= {"Doe","Hasan"};
        String[] fname2Test3= {"John","Bell"};
        String[] dob1Test3 = {"01/01/2000","01/01/2000"};
        String[] dob2Test3 = {"01/01/2000","01/01/2000"};
        callTests(lname1Test3, lname2Test3, fname1Test3, fname2Test3, dob1Test3, dob2Test3
                , 3, -1);

        String[] lname1Test4= {"Doe","Hasan"};
        String[] fname1Test4= {"John","Bell"};
        String[] lname2Test4= {"Doe","Hasan"};
        String[] fname2Test4= {"Jane","Anna"};
        String[] dob1Test4 = {"01/01/2000","01/01/2000"};
        String[] dob2Test4 = {"01/01/2000","01/01/2000"};
        callTests(lname1Test4, lname2Test4, fname1Test4, fname2Test4, dob1Test4, dob2Test4
                , 4, 1);

        String[] lname1Test5= {"Toro","Turner"};
        String[] fname1Test5= {"Isabel","Dylan"};
        String[] lname2Test5= {"Toro","Turner"};
        String[] fname2Test5= {"Isabel","Dylan"};
        String[] dob1Test5 = {"01/01/2000","01/01/2000"};
        String[] dob2Test5 = {"04/04/2004","05/05/2005"};
        callTests(lname1Test5, lname2Test5, fname1Test5, fname2Test5, dob1Test5, dob2Test5
                , 5, -1);

        String[] lname1Test6= {"Toro","Turner"};
        String[] fname1Test6= {"Isabel","Dylan"};
        String[] lname2Test6= {"Toro","Turner"};
        String[] fname2Test6= {"Isabel","Dylan"};
        String[] dob1Test6 = {"04/04/2004","05/05/2005"};
        String[] dob2Test6 = {"01/01/2000","01/01/2000"};
        callTests(lname1Test6, lname2Test6, fname1Test6, fname2Test6, dob1Test6, dob2Test6
                , 6, 1);

        String[] lname1Test7= {"Toro","Turner"};
        String[] fname1Test7= {"Isabel","Dylan"};
        String[] lname2Test7= {"Toro","Turner"};
        String[] fname2Test7= {"Isabel","Dylan"};
        String[] dob1Test7 = {"01/01/2000","04/01/2003"};
        String[] dob2Test7 = {"01/01/2000","04/01/2003"};
        callTests(lname1Test7, lname2Test7, fname1Test7, fname2Test7, dob1Test7, dob2Test7
                , 7, 0);
    }
}

