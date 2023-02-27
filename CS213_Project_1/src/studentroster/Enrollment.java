package studentroster;

/**
 The Enrollment class acts as a database for enrolled students, storing
 an array of enrolled students and the size of the array.
 @author Dylan Turner, Noor Hasan
 */
public class Enrollment {
    private EnrollStudent[] enrollStudents;
    private int size;

    /**
     *
     */
    public Enrollment() {
        this.enrollStudents = new EnrollStudent[Constant.ENROLLMENT_INITIAL.getValue()];
        this.size = 0;
    }

    /**
     *
     * @param enrollStudent
     */
    public void add(EnrollStudent enrollStudent) {
        if(this.size == enrollStudents.length){
            int newLength = this.size + 1;
            EnrollStudent[] tempEnroll = new EnrollStudent[newLength];
            for(int i = 0; i < this.size; i++) {
                tempEnroll[i] = this.enrollStudents[i];
            }
            tempEnroll[size] = enrollStudent;
            this.enrollStudents = tempEnroll;
            this.size++;
            return;
        }
        enrollStudents[size] = enrollStudent;
        this.size++;
    }

    public void remove(EnrollStudent enrollStudent) {
        int removePosition = find(enrollStudent);
        if(removePosition != Constant.NOT_FOUND.getValue()){
            enrollStudents[removePosition] = enrollStudents[size-1];
            enrollStudents[this.size-1] = null;
            this.size--;
        }
    }

    public boolean isAlreadyTaking(EnrollStudent student, int credits) {
        int position = find(student);
        return (this.enrollStudents[position].getCreditsEnrolled() == credits);
    }
    public boolean contains(EnrollStudent enrollStudent) {
        for(int i = 0; i < this.size; i++) {
            if(enrollStudents[i].equals(enrollStudent)){
                return true;
            }
        }
        return false;
    }

    public int find(EnrollStudent enrollStudent) {
        for(int i = 0; i < this.size; i++) {
            if(enrollStudents[i].equals(enrollStudent)){
                return i;
            }
        }
        return Constant.NOT_FOUND.getValue();
    }

    public EnrollStudent getEnrollStudent(Profile profile) {
        for(int i = 0; i < this.size; i++) {
            if(enrollStudents[i].getProfile().equals(profile)){
                return enrollStudents[i];
            }
        }
        return null;
    }

    public void setEnrollCredits(EnrollStudent enrollStudent, int enrollCredits) {
        int position = find(enrollStudent);
        this.enrollStudents[position].setCreditsEnrolled(enrollCredits);
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }

    public void print() { //print the array as is without sorting
        if(!isEmpty()){
            System.out.println("** Enrollment **");
            for(int i = 0; i < this.size; i++){
                System.out.println(enrollStudents[i].toString() + ": credits enrolled: " + enrollStudents[i].getCreditsEnrolled());
            }
            System.out.println("** end of enrollment **");
            return;
        }
        System.out.println("Enrollment is empty!");
    }

    public void printTuition(Roster roster) {
        double tuition;
        int creditsEnrolled;
        if(isEmpty()){
            System.out.println("Student roster is empty!");
            return;
        }
        System.out.println("** Tuition due **");
        for(EnrollStudent enrolled : this.enrollStudents) {
            if(!(enrolled == null)){
                Student currentStudent = roster.getStudent(enrolled.getProfile());
                tuition = currentStudent.tuitionDue(enrolled.getCreditsEnrolled());
                creditsEnrolled = enrolled.getCreditsEnrolled();
                System.out.println(currentStudent.getProfile().toString() + " "
                        + currentStudent.getType() + " enrolled " + creditsEnrolled
                        + " credits: tuition due: $" + tuition);
            }
        }
        System.out.println("** end of tuition due **");
    }

    public void semesterEnd(Roster roster) {
        int creditsEnrolled;
        int amountGraduated = 0;
        System.out.println("Credits completed has been updated.");
        System.out.println("** list of students eligible for graduation **");
        for(EnrollStudent enrolled : this.enrollStudents) {
            if(!(enrolled == null)){
                Student currentStudent = roster.getStudent(enrolled.getProfile());
                creditsEnrolled = enrolled.getCreditsEnrolled();
                currentStudent.addCredits(creditsEnrolled);
                if(currentStudent.getCredits() >= 120) {
                    System.out.println(currentStudent + " has graduated with " + currentStudent.getCredits());
                    amountGraduated++;
                }
            }
        }
        System.out.println("** end of graduation list");
    }
}
