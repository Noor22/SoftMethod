package studentroster;

public class Enrollment {
    private EnrollStudent[] enrollStudents;
    private int size;

    public Enrollment() {
        this.enrollStudents = new EnrollStudent[Constant.ENROLLMENT_INITIAL.getValue()];
        this.size = 0;
    }

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
            enrollStudents[removePosition] = enrollStudent;
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

//    public EnrollStudent getEnrollStudent(EnrollStudent enrollStudent) {
//        for(int i = 0; i < this.size; i++) {
//            if(enrollStudents[i].equals(enrollStudent)){
//                System.out.println("gotem");
//                return enrollStudents[i];
//            }
//        }
//        System.out.println("poop null");
//        return null;
//    }

    public void setEnrollCredits(EnrollStudent enrollStudent, int enrollCredits) {
        int position = find(enrollStudent);
        this.enrollStudents[position].setCreditsEnrolled(enrollCredits);
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }

    public void print() { //print the array as is without sorting
        if(!isEmpty()){
            System.out.println("Print Enrollment");
            for(int i = 0; i < this.size; i++){
                System.out.println(enrollStudents[i].toString());
            }
            System.out.println("Print Enrollment End");
        }
        System.out.println("Enrollment is empty");
    }

    public void printTuition(Roster roster) {
        double tuition;
        for(EnrollStudent enrolled : this.enrollStudents) {
            Student currentStudent = roster.getStudent(enrolled.getProfile());
            tuition = currentStudent.tuitionDue(currentStudent.getCredits());
            System.out.println(currentStudent.getProfile().toString() + "owes " + tuition);
        }
    }

    public void semesterEnd(Roster roster) {
        int creditsEnrolled;
        for(EnrollStudent enrolled : this.enrollStudents) {
            Student currentStudent = roster.getStudent(enrolled.getProfile());
            creditsEnrolled = enrolled.getCreditsEnrolled();
            currentStudent.addCredits(creditsEnrolled);
            if(currentStudent.getCredits() >= 120){
                System.out.println(currentStudent + " has graduated with " + currentStudent.getCredits());
            }
        }
    }
}
